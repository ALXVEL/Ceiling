package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static int speed = 0; //speed of fan (0-3, 0 being off)
    static boolean direction = false; // true if reversed, false if not

    static int reader(Scanner scanner){
        while(!scanner.hasNextInt()){
            scanner.nextLine(); // not number, skip line, keep looping until int
            System.out.println("Not an integer. Try again:");
        }
        return scanner.nextInt();
    }

    static void instructions(int n){
        if (n == 1){
            System.out.println("Speed Cord pulled.");
            if (speed == 3){
                speed = 0;
            }else{
                speed++;
            }
        }else if (n == 2){
            System.out.println("Direction Cord pulled.");
            direction = !direction;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Ceiling Instructions:
                 1: Increases fan speed (0-3, 0 being off)
                 2: Direction reversal
                 3: Quit""");

        while (true){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Current Configuration:" +
                    "\n Speed: " + speed +
                    "\n Reversed: " + direction);

            int user_input = -1; // variable for getting user input, every loop goes back to -1 to reset response.

            try {
                System.out.println("Your instruction (1-3): ");
                while (user_input < 1 || user_input > 3) {
                    user_input = reader(scanner); //reader method ensures we get an int
                    if (user_input < 1 || user_input > 3){ //input is an int, but not in range.
                        System.out.println("Not in range, try again. Instructions (1-3)");
                    }
                }
            }catch (InputMismatchException e) { //if the input is not an int, we catch exception
                scanner.nextLine(); //skips line due to wrong input (not 1-3)
                System.out.println("Wrong input, try again. Instructions (1-3):");
            }

            instructions(user_input); // leads to the two cords
            if(user_input == 3){
                System.out.println("Quitting...");
                break;
            }
        }
    }
}
