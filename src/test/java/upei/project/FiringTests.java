package upei.project;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static javax.management.Query.times;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class FiringTests {

    /* The test initializes a board object and an object with the opponent board.
     * It checks that the launchRow and launchCol lists are empty initially.*/
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void test1FiringCOnstructor(){
        Board opponentBoard = new Board();
        Firing firing = new Firing(opponentBoard);
        ArrayList<Integer> launchRow = new ArrayList<>();
        ArrayList<Integer> launchCol = new ArrayList<>();
        assertTrue(launchRow.isEmpty(), "launchRow should be an empty list initially");
        assertTrue(launchCol.isEmpty(), "launchCol should be an empty list initially");
    }
    /* The test initializes a board object and a firing object with the opponent board.
     * It checks that the launchRow and launchCol lists are initialized.*/
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void test2FiringCOnstructor(){
        Board opponentBoard = new Board();
        Firing firing = new Firing(opponentBoard);
        ArrayList<Integer> launchRow = new ArrayList<>();
        ArrayList<Integer> launchCol = new ArrayList<>();
        assertNotNull(launchRow, "launchRow should be initialized");
        assertNotNull(launchCol, "launchCol should be initialized");
    }

    /*The test initializes a board object, a firing object, and launches an attack.
     * It checks that the coordinate lists are empty after the attack and verifies the state of the opponent board.*/
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testLaunchAttackWithNonEmptyCoords() {
        // Arrange
        Board opponentBoard = new Board();
        Firing firing = new Firing(opponentBoard);
        firing.launchRow = new ArrayList<>(List.of(2));
        firing.launchCol = new ArrayList<>(List.of(4));
        firing.launchAttack();
        verifyBoardAfterAttack(firing.getOpponentBoard(), 2, 4);
    }
    /*This method verifies the state of the opponent board after an attack at a specific coordinate.*/
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    private void verifyBoardAfterAttack(Board opponentBoard, int expectedRow, int expectedCol) {
        char cell = opponentBoard.getCell(expectedRow, expectedCol);
        assertTrue(cell == 'O' || cell == 'M', "The cell should be either 'O' (hit) or 'M' (miss)");
    }
    /* * Verifies the state of the opponent board after an attack with empty coordinates.
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    private void verifyBoardAfterAttack(Board opponentBoard, int boardSize) {
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                char cell = opponentBoard.getCell(row, col);
                assertTrue(cell == 'O' || cell == 'M', "The cell should be either 'O' (hit) or 'M' (miss)");
            }
        }
    }
    /* * Test case for firing at an '_' (blank) cell and marking it as 'M' (miss).
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testFireAtHit() {
        // Arrange
        Board opponentBoard = new Board();
        Firing firing = new Firing(opponentBoard);
        int row = 3;
        int col = 5;
        firing.fireAt(row, col);
        assertEquals('M', opponentBoard.getCell(row, col), "The cell should be marked as 'X' (hit)");
    }
    /* * Test case for firing at an 'M' (miss) cell and triggering a recursive attack.*/
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void test1FireAtMissAndRecursiveAttack() {
        // Arrange
        Board opponentBoard = new Board();
        Firing firing = new Firing(opponentBoard);
        firing.launchRow = new ArrayList<>(List.of(2));
        firing.launchCol = new ArrayList<>(List.of(4));
        firing.fireAt(2, 4);
        assertFalse(firing.isCoordEmpty(), "The coordinate lists should be empty after a miss");
    }
    /*
     * Test case for firing at an '_' (blank) cell and marking it as 'M' (Miss).
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void test2FireAtHit() {
        // Arrange
        Board opponentBoard = new Board();
        Firing firing = new Firing(opponentBoard);
        int row = 3;
        int col = 5;
        firing.fireAt(row, col);
        assertEquals('M', opponentBoard.getCell(row, col), "The cell should be marked as 'X' (hit)");
    }

    /*
     * Test case for firing at an 'M' (miss) cell and triggering a recursive attack.
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void test3FireAtMissAndRecursiveAttack() {
        Board opponentBoard = new Board();
        Firing firing = new Firing(opponentBoard);
        firing.launchRow = new ArrayList<>(List.of(2));
        firing.launchCol = new ArrayList<>(List.of(4));
        firing.fireAt(2, 4);
        assertFalse(firing.isCoordEmpty(), "The coordinate lists should load new attack when missed");
    }
    /*
     * Test case for firing at an unknown cell content and marking it as 'M' (miss).
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void test1FireAtUnknownCellContentAndMiss() {
        Board opponentBoard = new Board();
        Firing firing = new Firing(opponentBoard);
        int row = 3;
        int col = 5;
        opponentBoard.setCell(row, col, 'X');
        firing.fireAt(row, col);
        assertEquals('M', opponentBoard.getCell(row, col), "The cell should be marked as 'M' (miss)");
    }
    /*
     * Test case for adding new coordinates to the launch lists in all directions.
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void test2FlowerGrid() {
        // Arrange
        Firing firing = new Firing(new Board());
        int row = 3;
        int col = 5;
        firing.flowerGrid(row, col);
        assertTrue(firing.getLaunchRow().containsAll(Arrays.asList(row + 1, row - 1, row, row)),
                "New rows should be added to the launchRow list");
        assertTrue(firing.getLaunchCol().containsAll(Arrays.asList(col, col, col - 1, col + 1)),
                "New columns should be added to the launchCol list");
        assertEquals(4, firing.getLaunchRow().size(), "The launchRow list should contain 4 elements");
        assertEquals(4, firing.getLaunchCol().size(), "The launchCol list should contain 4 elements");
    }
    /*
     * Test case for adding new coordinates to the launch lists when the base coordinates are at the grid boundary.
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void test3FlowerGridAtBoundary() {
        // Arrange
        Firing firing = new Firing(new Board());
        int row = 0;
        int col = 0;

        firing.flowerGrid(row, col);
        assertTrue(firing.getLaunchRow().containsAll(Arrays.asList(row + 1, row, row)),
                "New rows should be added to the launchRow list");
        assertTrue(firing.getLaunchCol().containsAll(Arrays.asList(col, col + 1, col)),
                "New columns should be added to the launchCol list");
        assertEquals(2, firing.getLaunchRow().size(), "The launchRow list should contain 3 elements");
        assertEquals(2, firing.getLaunchCol().size(), "The launchCol list should contain 3 elements");
    }

    /*
     * Test case for adding new coordinates to the launch lists when the base coordinates are at the grid boundary.
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testFlowerGridAtBoundary() {
        Firing firing = new Firing(new Board());
        int row = 9;
        int col = 9;
        firing.flowerGrid(row, col);
        assertTrue(firing.getLaunchRow().containsAll(Arrays.asList(row - 1, row, row)),
                "New rows should be added to the launchRow list");
        assertTrue(firing.getLaunchCol().containsAll(Arrays.asList(col, col - 1, col)),
                "New columns should be added to the launchCol list");
        assertEquals(2, firing.getLaunchRow().size(), "The launchRow list should contain 3 elements");
        assertEquals(2, firing.getLaunchCol().size(), "The launchCol list should contain 3 elements");
    }
    /*
     * Test case for checking if coordinate lists are empty when both lists are empty.
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testIsCoordEmptyWithEmptyLists() {
        Firing firing = new Firing(new Board());
        firing.launchRow = new ArrayList<>();
        firing.launchCol = new ArrayList<>();
        boolean result = firing.isCoordEmpty();
        assertTrue(result, "The coordinate lists should be empty");
    }
    /*
     * Test case for checking if coordinate lists are not empty when either list is non-empty.
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testIsCoordEmptyWithNonEmptyLists() {
        Firing firing = new Firing(new Board());
        firing.launchRow = new ArrayList<>(List.of(2));
        firing.launchCol = new ArrayList<>();
        boolean result = firing.isCoordEmpty();
        assertFalse(result, "The coordinate lists should not be empty");
    }
    /*
     * Test case for retrieving the opponent's game board.
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testGetOpponentBoard() {
        Board opponentBoard = new Board();
        Firing firing = new Firing(opponentBoard);
        Board result = firing.getOpponentBoard();
        assertNotNull(result, "The opponent's game board should not be null");
        assertEquals(opponentBoard, result, "The retrieved board should be the same as the set board");
    }
    /*
     * Test case for retrieving the launchRow list.
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testGetLaunchRow() {
        Firing firing = new Firing(new Board());
        firing.launchRow = new ArrayList<>(List.of(2, 4, 6));
        ArrayList<Integer> result = firing.getLaunchRow();
        assertEquals(firing.launchRow, result, "The retrieved launchRow list should be the same as the set list");
    }
    /*
     * Test case for retrieving the launchCol list.
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testGetLaunchCol() {
        Firing firing = new Firing(new Board());
        firing.launchCol = new ArrayList<>(List.of(1, 3, 5));
        ArrayList<Integer> result = firing.getLaunchCol();
        assertEquals(firing.launchCol, result, "The retrieved launchCol list should be the same as the set list");
    }
}
