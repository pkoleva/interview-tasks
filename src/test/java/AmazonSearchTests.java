import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class AmazonSearchTests extends BaseTest {

    @Test
    public void test1000_searchAnItem(){
        // 1. Find item.
        String criterion = "Harry Potter and the Cursed Child - Parts One and Two";
        searchPage.searchByCriteria(criterion);
        var results= searchPage.getSearchResultSet();

        // Validations.
        Assertions.assertTrue(results.get(0).getText().contains(criterion));

        // 2. Review item.
        WebElement element = searchPage.getSearchResultSet().get(0);
        String price = searchPage.getPrice(element);
        searchPage.selecPaperbacktItem(element);
        Map<String, String> itemProperties = itemPage.getItemProperties();

        // Validations.
        Assertions.assertEquals(price, itemProperties.get("price"));
        Assertions.assertTrue(itemProperties.get("title").contains(criterion));

        // 3. Add item to the basket.
        itemPage.addToBasket();
        basketPage.navigateToBasket();

        List<WebElement> items = basketPage.getItems();
        WebElement item = items.get(0);
        String itemDetails = basketPage.getItemDetails(item);

        // Validations.
        Assertions.assertEquals(1,items.size());
        Assertions.assertTrue(basketPage.isGiftSelected(item));
        Assertions.assertTrue(itemDetails.contains(criterion));

        Assertions.assertTrue(itemDetails.contains(price));
        Assertions.assertTrue(itemDetails.contains("Paperback"));
    }
}
