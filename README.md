## Task 1 - Count Duplicates
Consider an array of n integers. We define a non-unique value of numbers as an integer that appears at least twice in the array. For example, if numbers = [1, 1, 2, 2, 2, 3, 4, 3, 9], then there are a total of 3 non-unique values in the array (i.e., 1, 2, and 3). Complete the countDuplicates function. It has 1 parameter: an array of integers, and numbers.
It must return an integer denoting the number of non-unique values in the numbers array. AddJUnit tests covering the code.

**Input Format**
The code should read the following input from the input and pass it to the function:
The first line contains an integer, n, denoting the size of the numbers array.
Each line i of the n subsequent lines (where 0 ≤ i < n) contains an integer describing the value of numbers i.
- Constraints:

  1 ≤ n ≤ 1000
  
  1 ≤ numbers i ≤ 1000

**Output Format**
The function must return an integer denoting the number of non-unique values in numbers. This is printed to stdout by locked stub code in the editor.
| Sample Input 0| Sample Input 1|
| -------- | ------- |
|8|6|
|1|1|
|3|1|
|1|2|
|4|2|
|5|2|
|6|3|
|3||
|2||
| Sample Output 0 | Sample Output 1 |
|2|2|


Explanation 0
n = 8 and numbers = [1, 3, 1, 4, 5, 6, 3, 2].
The integers 1 and 3 both occur more than once, so we return 2 as our answer.

Explanation 1
n = 6 and numbers = [1, 1, 2, 2, 2, 3].
The integers 1 and 2 both occur more than once, so we return 2 as our answer.


## Task 2 - Selenium
Use Java, Selenium, and Chrome to Automate the following:
1. Navigate to amazon.co.uk - verify the page is correct and loaded.
2. Search in the books section for a book named "Harry Potter and the 	Cursed Child", 1 & 2.
   - Verify that the name of the first entry in the list has the same title.
   - Verify it has paperback version and verify it has selling price.
3. From the list with the books editions click on the paperback version. 
   - Check it has the expected title, the same price as on the previous page and it is paperback edition.
4. Add it to the basket and mark it as a gift.
   - check it was added as a gift in the basket.
5. Open the basket.
   - check that the title is the same, it is paperback edition and the price is the same as shown on the first search screen.
   - check it is the only item in the basket.


## Task 3 - Performance
You have to design a test that measures the performance of a software application.
The test has to run 1000 calls to the application. Not more or less than 100 at a time. If there are more, the application will crash, if less - the test won’t achieve its goal.
To test the performance framework, create a mock service class MockService with one method execute(). Each call of the test should use the method execute().
The method should finish in 1 to 1200 milliseconds and fail about 30% of the time with an exception. (You could use Java class Random for that).

**The test has to make the following checks:**
- The execute() calls finished with success should be not less than 70%.
- The count of the calls with time for execution of more than 1 second should be not more than 5%.
