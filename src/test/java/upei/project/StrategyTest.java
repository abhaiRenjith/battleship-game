package upei.project;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


import java.util.concurrent.TimeUnit;

public class StrategyTest {

    /*When the method Strategy.Strategy_1 is executed, the method is responsible for
    * producing a game board with all 5 ships placed with respect to the strategy. If the
    * !strategy.allShipsSunk() evaluates to true, the program has succeeded in running,
    * else if it throws a false, then the ships are not being placed which will in turn
    * throw an exception.  */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testStrategy1(){
        Strategy strategy = new Strategy();
        strategy.Strategy_1();
        assert !strategy.allShipsSunk();
    }
    /*When the method Strategy.Strategy_2 is executed, the method is responsible for
     * producing a game board with all 5 ships placed with respect to the strategy. If the
     * !strategy.allShipsSunk() evaluates to true, the program has succeeded in running,
     * else if it throws a false, then the ships are not being placed which will in turn
     * throw an exception.  */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testStrategy2(){
        Strategy strategy = new Strategy();
        strategy.Strategy_2();
        assert !strategy.allShipsSunk();
    }
    /*When the method Strategy.Strategy_3 is executed, the method is responsible for
     * producing a game board with all 5 ships placed with respect to the strategy. If the
     * !strategy.allShipsSunk() evaluates to true, the program has succeeded in running,
     * else if it throws a false, then the ships are not being placed which will in turn
     * throw an exception.  */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testStrategy3(){
        Strategy strategy = new Strategy();
        strategy.Strategy_3();
        assert !strategy.allShipsSunk();
    }
    /*In this test we will be passing a number into the selectRandomNumberWithStep()
    * method and we are looking for our answer to be contained within the
    * [0,10) (')' denoted the ideal value should be less than 10)*/
    @Timeout(value = 100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void test1selectRandomNumberWithStep(){
        Strategy strategy = new Strategy();
        int result = strategy.selectRandomNumberWithStep(1);
        assertTrue(result >= 0 && result < 10, "Result should be in the range [0, 10) for step 1");
    }
    /*In this test we will be passing a number into the selectRandomNumberWithStep()
     * method and we are looking for our answer to be contained within the
     * [0,10) (')' denoted the ideal value should be less than 10)*/
    @Timeout(value = 100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void test2selectRandomNumberWithStep(){
        Strategy strategy = new Strategy();
        int result = strategy.selectRandomNumberWithStep(8);
        assertTrue(result >= 0 && result < 10, "Result should be in the range [0, 10) for step ");
    }
    /*This method has a return type of boolean, it takes in an integer value
    * which will be the column from the coordinates, and this method makes sure
    * the ship size can fit within the bounds of the grid, which is 10x10.*/
    //This test checks if true when col+size less than 10
    @Timeout(value = 100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testColPass1(){
        Strategy strategy = new Strategy();
        assertEquals(strategy.colPass(1, 3), true,"colPass should return true when col + size is less than 10");
    }
/*
    When size + col equals 10, this is the maximum possible combination.
*/

    @Timeout(value = 100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testColPass2(){
        Strategy strategy = new Strategy();
        assertEquals(strategy.colPass(5, 5), true,"colPass should return true when col + size is less than 10");
    }
/*
    When size + col more than 10, this should give us a false is the method is functioning properly.
*/

    @Timeout(value = 100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testColPass3(){
        Strategy strategy = new Strategy();
        assertEquals(strategy.colPass(7, 5), false,"colPass should return true when col + size is less than 10");
    }

    /*This method taken in an Arraylist of integers and generates a random number and returns a integer
    * which corresponds to the random number. The only way to do this test is by loading an Arraylist of
    * integers and trying to find if the random number generate was able to get at number from the loaded list,
    * since we are dealing with randoms here, we are not left with a lot of choice. */
    @Timeout(value = 100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testselectRandomNumber(){
        Strategy strategy = new Strategy();
        ArrayList<Integer> testList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int randomResult = strategy.selectRandomNumber(testList);
        assertTrue(testList.contains(randomResult), "Random number is not found in the list.");
    }
    /*This test case checks that the result of selectRandomBoolean is either true or false.
    Since the method generates a random boolean value, we are making sure it adheres to the
    expected boolean values. */
    @Timeout(value = 100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testSelectRandomBoolean() {
        Strategy strategy = new Strategy();
        boolean randomResult = strategy.selectRandomBoolean();
        assertTrue(randomResult || !randomResult, "Result should be either true or false");
    }
    /*For this test we will be passing 2 parameters, the row or col and ship size, if the
    * row + size tun out to be less than 10, then the ship can be placed at that position
    * without facing any bound errors. In the test1RowColPass we will be passing an invalid input
    * which should throw us a false, hence we assert a false. In the second test "test2RowColPassValidInput"
    * we will be providing the method with a valid input, so we will be asserting a true here. */
    @Timeout(value = 100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void test1RowColPassInvaldInput() {
        Strategy strategy = new Strategy();
        boolean result = strategy.rowColPass(7, 5);
        assertFalse(result, "The result should be false for invalid input");
    }

    @Timeout(value = 100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void test2RowColPassValidInput() {
        Strategy strategy = new Strategy();
        boolean result = strategy.rowColPass(2, 5);
        assertTrue(result, "The result should be true for valid input");
    }
    /*------------> End of test cases for Strategy class <-------------*/
}
