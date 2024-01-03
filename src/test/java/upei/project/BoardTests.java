package upei.project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTests {

    /*
     * Test case for the default constructor Board.
     * Initializes a board with a 10x10 grid filled with '_' characters.
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testDefaultConstructor() {
        Board board = new Board();
        char[][] expectedGrid = new char[10][10];
        for (char[] row : expectedGrid) {
            for (int i = 0; i < row.length; i++) {
                assertEquals('_', board.getCell(i, 0));
            }
        }
    }

    /*
     * Test case for the getCell method.
     * Checks if the method retrieves the correct cell from the grid based on the provided parameters.
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testGetCell() {
        Board board = new Board();
        char[][] grid = board.getGrid();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                assertEquals(grid[i][j], board.getCell(i, j));
            }
        }
    }
    /*
     * Test case for the placeShip method.
     * Checks if the method correctly places a ship on the grid based on the provided parameters.
     */
    @Test
    public void testPlaceShip() {
        Board board = new Board();
        board.placeShip(0, 0, 3, true, "Ship1");
        char[][] grid = board.getGrid();
        for (int i = 0; i < 3; i++) {
            assertEquals('O', grid[0][i]);
        }
    }
    /*
     * Test case for the spotTaken method.
     * Checks if the method correctly identifies whether a spot is occupied by a ship.
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testSpotTaken() {
        Board board = new Board();
        assertFalse(board.spotTaken(0, 0, 3, true));
        board.placeShip(0, 0, 3, true, "Ship1");
        assertTrue(board.spotTaken(0, 0, 3, true));
    }

    /*
     * Test case for setting a cell in the grid.
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testSetCell() {
        Board board = new Board();
        char[][] initialGrid = board.getGrid().clone();
        int row = 2;
        int col = 3;
        char value = 'X';
        board.setCell(row, col, value);
        assertEquals(value, board.getGrid()[row][col], "The cell should be set to the specified value");
        // Verify that other cells in the grid remain unchanged
        for (int i = 0; i < board.getGrid().length; i++) {
            for (int j = 0; j < board.getGrid()[0].length; j++) {
                if (i != row || j != col) {
                    assertEquals(initialGrid[i][j], board.getGrid()[i][j],
                            "Other cells in the grid should remain unchanged");
                }
            }
        }
    }
    /*
     * Test case for retrieving the game board grid.
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testGetGrid() {
        Board board = new Board();
        char[][] expectedGrid = board.getGrid().clone();
        char[][] result = board.getGrid();
        assertArrayEquals(expectedGrid, result, "The retrieved grid should be the same as the initial grid");
    }
    /*
     * Test case for checking if all ships are sunk.
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testAllShipsSunk() {
        Board board = new Board();
        char[][] emptyGrid = new char[10][10];
        board.setGrid(emptyGrid);
        assertTrue(board.allShipsSunk(), "The method should return true when all ships are sunk");
        char[][] gridWithShip = new char[10][10];
        gridWithShip[2][3] = 'O';
        board.setGrid(gridWithShip);
        assertFalse(board.allShipsSunk(), "The method should return false when at least one ship is present");
    }
}
