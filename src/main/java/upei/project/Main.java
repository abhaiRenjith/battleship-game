package upei.project;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    /*The static method initial is responsible for printing the welcome statements for the user, it also prints
    * a tiny clipart of battleship to capture the user's interest.*/
    public static void Initial() {
        System.out.print("\033[4;1m");
        System.out.println("Welcome to Battleship!!!");
        System.out.print("\033[0m");
        System.out.printf("%-6s%s%n", "     ", "|____|");
        System.out.printf("%-6s%s%n", "     ", "|____|");
        System.out.printf("%-5s%s%n", " ", "\\ |  | /");
        System.out.println("   ^^^^^^^^^^^^");
        System.out.println("Battle begins!!!");

    }
    /*The main method is responsible for the initialization of the ship object, game boards with different
    * strategies implemented, and finally it also contains the firing class which is responsible for the attacks
    * launched and deciding the winner.*/
    public static void main(String[] args) {

        Initial(); // Introductory print statements
        //Strategy 1 vS Strategy 2
        int p1victory = 0;
        int p2victory = 0;
        for(int i = 1; i < 101; i++){
            Strategy player1 = new Strategy();
            Strategy player2 = new Strategy();
            Firing firing1 = new Firing(player2);
            Firing firing2 = new Firing(player1);
            player1.Strategy_1();
            player2.Strategy_2();
            do {
                firing1.launchAttack(); //Launched attack
                firing2.launchAttack();
            }
            while (!player1.allShipsSunk() && !player2.allShipsSunk());
            if (player2.allShipsSunk()){
                p1victory++;
            } else {
                p2victory++;} //Win counter
        }
        System.out.println("End of battle one: Strategy 1 Vs Strategy 2");
        System.out.println("+---------+--------+---------+");
        System.out.println("| Player  | Wins   | Defeats |");
        System.out.println("+---------+--------+---------+");
        System.out.println(String.format("| Player 1 | %-5d | %-7d |", p1victory, p2victory));
        System.out.println(String.format("| Player 2 | %-5d | %-7d |", p2victory, p1victory));
        System.out.println("+---------+--------+---------+");
        p1victory = 0;
        p2victory = 0;
        for(int i = 1; i < 101; i++){
            Strategy player1 = new Strategy();
            Strategy player2 = new Strategy();
            Firing firing1 = new Firing(player2);
            Firing firing2 = new Firing(player1);
            player1.Strategy_1();
            player2.Strategy_3();
            do {
                firing1.launchAttack();
                firing2.launchAttack();
            }
            while (!player1.allShipsSunk() && !player2.allShipsSunk());
            if (player2.allShipsSunk()){
                p1victory++;
            } else {
                p2victory++;}
        }
        System.out.println("End of battle one: Strategy 1 Vs Strategy 3");
        System.out.println("+---------+--------+---------+");
        System.out.println("| Player  | Wins   | Defeats |");
        System.out.println("+---------+--------+---------+");
        System.out.println(String.format("| Player 1 | %-5d | %-7d |", p1victory, p2victory));
        System.out.println(String.format("| Player 2 | %-5d | %-7d |", p2victory, p1victory));
        System.out.println("+---------+--------+---------+");
        //Strategy 2 vS Strategy 3
        p1victory = 0;
        p2victory = 0;
        for(int i = 1; i < 101; i++){
            Strategy player1 = new Strategy();
            Strategy player2 = new Strategy();
            Firing firing1 = new Firing(player2);
            Firing firing2 = new Firing(player1);
            player1.Strategy_1();
            player2.Strategy_3();
            do {
                firing1.launchAttack();
                firing2.launchAttack();
            }
            while (!player1.allShipsSunk() && !player2.allShipsSunk());
            if (player2.allShipsSunk()){
                p1victory++;
            } else {
                p2victory++;}
        }
        System.out.println("End of battle one: Strategy 2 Vs Strategy 3");
        System.out.println("+---------+--------+---------+");
        System.out.println("| Player  | Wins   | Defeats |");
        System.out.println("+---------+--------+---------+");
        System.out.println(String.format("| Player 1 | %-5d | %-7d |", p1victory, p2victory));
        System.out.println(String.format("| Player 2 | %-5d | %-7d |", p2victory, p1victory));
        System.out.println("+---------+--------+---------+");


    }
}

