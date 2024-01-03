package upei.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Firing {
    public Board opponentBoard;
    ArrayList<Integer> launchRow;
    ArrayList<Integer> launchCol;
    Random random = new Random();


    public Firing(Board opponentBoard) {
        ArrayList<Integer> launchRow = new ArrayList<>();
        ArrayList<Integer> launchCol = new ArrayList<>();
        this.opponentBoard = opponentBoard;
        this.launchCol = launchCol;
        this.launchRow = launchRow;

    }
    public ArrayList<Integer> getLaunchRow() {
        return launchRow; // A getter for launchRow
    }

    public ArrayList<Integer> getLaunchCol() {
        return launchCol; // A getter for launchCol
    }
        /* Fires at the specified coordinates on the opponent's board and
        * updates the game state accordingly.*/
        public void launchAttack(){
            if(isCoordEmpty()){
                int randomRow = random.nextInt(9);
                int randomCol = random.nextInt(9);
                fireAt(randomRow, randomCol);
            }else{
                int row = launchRow.get(0);
                int col = launchCol.get(0);
                fireAt(row, col);

            }
        }

        /*The method checks the content of the cell at the specified coordinates. If the cell is 'O' (occupied),
         * it marks the cell as 'X' (hit) and triggers the flowerGrid method to add new coordinates. If the
         * cell is 'M'(miss), it checks if the launch coordinate lists are not empty and recursively calls
         * launch attack. If the cell is neither 'O' nor 'M', it marks the cell as 'M', a miss.*/
        public void fireAt(int row, int col){
            char cell = opponentBoard.getCell(row, col);
            if (cell == 'O') {
                opponentBoard.setCell(row, col, 'X'); // Mark as hit
                flowerGrid(row,col);
            } else if(cell == 'M'){
                if (!launchRow.isEmpty() && !launchCol.isEmpty()) {
                    launchRow.remove(0);
                    launchCol.remove(0);
                    launchAttack();
                } else {
                    launchAttack();
                }
            }else {
                opponentBoard.setCell(row, col, 'M'); // Mark as miss
            }
        }
        /*Adds new coordinates to the launch lists based on the provided row and column coordinates.
         * New coordinates are added in the up, down, left, and right directions, if they are within
         * the bounds of a 10x10 grid. Loads the array with coordinates for neighbouring cells the
         * final diagram is going to look like flower hence the name flowerGrid */
        // Adds new coords
        public void flowerGrid(int row, int col) {
            int[] rowOffsets = {1, -1, 0, 0};
            int[] colOffsets = {0, 0, -1, 1};

            for (int i = 0; i < rowOffsets.length; i++) {
                int newRow = row + rowOffsets[i];
                int newCol = col + colOffsets[i];

                if (newRow >= 0 && newRow < 10 && newCol >= 0 && newCol < 10) {
                    launchRow.add(newRow);
                    launchCol.add(newCol);
                }
            }
        }
        /* Checks if the coordinate lists are empty*/
        public boolean isCoordEmpty(){
            return launchRow.isEmpty() && launchCol.isEmpty();
        }

        /*Retrieves the opponent's game board.*/
        public Board getOpponentBoard() {
            return this.opponentBoard;
        }
}

