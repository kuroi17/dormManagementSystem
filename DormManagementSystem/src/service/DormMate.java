package service;

import util.InputValidator;
import java.util.InputMismatchException;
import ui.Main;
import java.util.Scanner;

public class DormMate {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Initialize data from Main class
        Main.initializeData();
        StudentMenu studentMenu = new StudentMenu();
        LandlordMenu landlordMenu = new LandlordMenu();
        
        AsciiArt.printDorm();

        System.out.println("=== WELCOME TO DormMate! ===");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nAre you a:\n1. Student\n2. Landlord\n3. Exit");
            System.out.print("Enter choice: ");
            
            
            try {
                int choice = input.nextInt();
                input.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> studentMenu.portal(input);
                    case 2 -> landlordMenu.portal(input);
                    case 3 -> {
                        exit = true;
                        System.out.println("Exiting DormMate. Goodbye!");
                    }
                    default -> System.out.println("Invalid choice!");
                }
            } catch (InputMismatchException e) { // runtime exception for mismatch input types
                System.out.println("Invalid input! Please enter a number.");
                input.nextLine(); // clear buffer
            }
        }
        input.close();
    }   
}
class AsciiArt {

    public static void printDorm() {
        String PINK = "\u001B[95m";   
        String RESET = "\u001B[0m";

        String art =
                " ______         ,-----.    .-------.    ,---.    ,---.,---.    ,---.   ____   ,---------.    .-''-.             \n" +
                "|    _ `''.   .'  .-,  '.  |  _ _   \\   |    \\  /    ||    \\  /    | .'  __ `.\\          \\ .'_ _   \\      \n" +
                "| _ | ) _  \\ / ,-.|  \\ _ \\ | ( ' )  |   |  ,  \\/  ,  ||  ,  \\/  ,  |/   '  \\  \\`--.  ,---'/ ( ` )   '    \n" +
                "|( ''_'  ) |;  \\  '_ /  | :|(_ o _) /   |  |\\_   /|  ||  |\\_   /|  ||___|  /  |   |   \\  . (_ o _)  |       \n" +
                "| . (_) `. ||  _`,/ \\ _/  || (_,_).' __ |  _( )_/ |  ||  _( )_/ |  |   _.-`   |   :_ _:  |  (_,_)___|          \n" +
                "|(_    ._) ': (  '\\_/ \\   ;|  |\\ \\  |  || (_ o _) |  || (_ o _) |  |.'   _    |   (_I_)  '  \\   .---.      \n" +
                "|  (_.\\.' /  \\ `\"/  \\  ) / |  | \\ `'   /|  (_,_)  |  ||  (_,_)  |  ||  _( )_  |  (_(=)_)  \\  `-'    /     \n" +
                "|       .'    '. \\_/``.\"'  |  |  \\    / |  |      |  ||  |      |  |\\ (_ o _) /   (_I_)    \\       /       \n" +
                "'-----'`        '-----'    ''-'   `'-'  '--'      '--''--'      '--' '.(_,_).'    '---'     `'-..-'             \n" + 
                
                "\n"+

            "     " + PINK + "███████" + RESET + "       \n" +                                  
            "    " + PINK + "█     █" + RESET + " " + PINK + "█████████" + RESET + "    \n" +     
            "   " + PINK + "█       █" + RESET + " " + PINK + "███████████" + RESET + "   \n" +   
            PINK + "  ██████████████████████" + RESET + "  \n" +                                 
            PINK + " █                      █\n" +                       
            PINK + " █                      █\n" +                                              
            PINK + " █          " + PINK + "███" + PINK + "         █\n" +                         
            PINK + "  ██████████████████████" + RESET + "  \n";                                                                                                                                                 
           
        System.out.println(art);
    }
}