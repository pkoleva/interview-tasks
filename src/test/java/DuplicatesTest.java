import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import unit.Utils;

import java.util.stream.Stream;

public class DuplicatesTest {
    Utils u = new Utils();

    private static Stream<Arguments> duplicateArrays(){
        return Stream.of(
                Arguments.of(1, new int[] {1,1,1,1}),
                Arguments.of(0, new int[] {}),
                Arguments.of(0, new int[] {1,2,3,4}),
                Arguments.of(2, new int[] {1,2,3,1,2,4})
        );
    }

    @ParameterizedTest
    @MethodSource("duplicateArrays")
    public void test1000_countValidDuplicates(int count, int[] array){
        int result = u.countDuplicates(array);
        Assertions.assertEquals(count,result);
    }

}
