package upei.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Strategy extends Board {

    Random random = new Random();
    void Strategy_1(){

        ArrayList<Integer> avail_row = new ArrayList<>(); // An array is initialized to store the available rows
        ArrayList<Integer> avail_col = new ArrayList<>(); // An array is initialized to store the available cols
        for(int i =0; i<10; i++){
            avail_row.add(i); // Appending all possible rows into the array.
            avail_col.add(i); // Appending all possible columns into the array.
        }
        HashMap<String, Integer> dep_data = new HashMap<>(5); // The hashmap data structure is used to store the ship names along with the ship length.
        dep_data.put("Carrier", 5);
        dep_data.put("Battleship", 4);
        dep_data.put("Cruiser", 3);
        dep_data.put("Submarine", 3);
        dep_data.put("Destroyer", 2);

        for(String shipType: dep_data.keySet()){ // Iterates through the hashmaps by ship names.
            int ShipLength = dep_data.get(shipType); // Stores the value of keys in shipLength which is teh size of the ship.
            boolean finish = false;
            while(!finish){
                    int rowPick = selectRandomNumber(avail_row);
                    int colPick = selectRandomNumber(avail_col);
                    boolean VerHorPick = selectRandomBoolean();
                    if(rowColPass(rowPick, ShipLength) && rowColPass(colPick, ShipLength)){
                        if(!spotTaken(rowPick, colPick, ShipLength, VerHorPick)) {
                            placeShip(rowPick, colPick, ShipLength, VerHorPick, shipType);
                            finish = true;
                        }
                    }
            }
        }
    }
    /* Confusion strategy, we fuse two ships, the destroyer and ships like the submarine or a Cruiser to make the player
    * think they are destroying something bigger while they are actually destroying a ship of smaller size.
    * This is a  silly strategy to have fun with your friends */
    void Strategy_2(){
        ArrayList<Integer> avail_row = new ArrayList<>(); // An array is initialized to store the available rows
        ArrayList<Integer> avail_col = new ArrayList<>(); // An array is initialized to store the available cols
        for(int i =0; i<10; i++){
            avail_row.add(i); // Appending all possible rows into the array.
            avail_col.add(i); // Appending all possible columns into the array.
        }
        HashMap<String, Integer> dep_data = new HashMap<>(5); // The hashmap data structure is used to store the ship names along with the ship length.
        dep_data.put("Carrier", 5);
        dep_data.put("Battleship", 4);
        dep_data.put("Cruiser", 5);
        dep_data.put("Submarine", 3);
        for(String shipType: dep_data.keySet()){
            int ShipLength = dep_data.get(shipType);
            boolean finish = false;
            while(!finish){
                int rowPick = selectRandomNumber(avail_row);
                int colPick = selectRandomNumber(avail_col);
                boolean VerHorPick = selectRandomBoolean();
                if(rowColPass(rowPick, ShipLength) && rowColPass(colPick, ShipLength)){
                    if(!spotTaken(rowPick, colPick, ShipLength, VerHorPick)) {
                        placeShip(rowPick, colPick, ShipLength, VerHorPick, shipType);
                        finish = true;
                    }
                }
            }
        }
    }
    /*In this strategy the player tries to place the ships evenly to prevent the attacker from destroying
    * ships nearby while combing the area near the hit. */
    void Strategy_3() {
        int step = 2;
        HashMap<String, Integer> dep_data = new HashMap<>(5);
        dep_data.put("Carrier", 5);
        dep_data.put("Battleship", 4);
        dep_data.put("Cruiser", 3);
        dep_data.put("Submarine", 3);
        dep_data.put("Destroyer", 2);

        for (String shipType : dep_data.keySet()) {
            int ShipLength = dep_data.get(shipType);
            boolean finish = false;
            while (!finish) {
                int rowPick = selectRandomNumberWithStep(step);
                int colPick = selectRandomNumberWithStep(step);
                boolean VerHorPick = selectRandomBoolean();
                if (rowColPass(rowPick, ShipLength) && colPass(colPick, ShipLength)) {
                    if (!spotTaken(rowPick, colPick, ShipLength, VerHorPick)) {
                        placeShip(rowPick, colPick, ShipLength, VerHorPick, shipType);
                        finish = true;
                    }
                }
            }
        }
    }
    /*The goal of this method is to ensure that the generated number is a multiple of the step,
    providing a regular distribution on the board.*/
    int selectRandomNumberWithStep(int step) {
        return random.nextInt(10 / step) * step;
    }
    /*The colPass method checks if placing a ship of a given size at a specific column on the
    * game board would be within the board boundaries.*/
    boolean colPass(int col, int size) {
        return col + size <= 10;
    }

    /*This method is simply made to generate a random number from 0 to 9 and returns the element of the array
    * passed that corresponds to the random number generated*/
    int selectRandomNumber(ArrayList<Integer> array) {
        int randomIndex = random.nextInt(array.size());
        int randomnumber = array.get(randomIndex);
        return randomnumber;
    }

    /*Returns a random boolean*/
    boolean selectRandomBoolean(){
        boolean random_boolean = random.nextBoolean();
        return random_boolean;
    }

    /*The rowColPass method checks if the randomly generated row/col along with the ship length is no more
     than 10 so that they can be placed on the grid without any out of bound error.*/
    boolean rowColPass(int rowOrCol, int size) {
        if (rowOrCol + size < 10){
            return true;
        }return false;
    }
}


