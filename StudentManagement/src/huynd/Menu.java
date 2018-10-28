/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynd;

/**
 *
 * @author Lawliet
 */
public class Menu {
    private static void printLine() {
        System.out.println(ConsoleColors.CYAN + "===========================================================" + ConsoleColors.RESET);
    }
    public static void printMainMenu() {
        System.out.println("============= FPT Management Student Program =============");
        System.out.println("    1. Admin");
        System.out.println("    2. Student");
        System.out.println("    3. Exit");
        Menu.printLine();
        Menu.printUserChoice();
    }
    public static void printUserChoice() {
        System.out.print("    "+ ConsoleColors.GREEN + "\u2022 " + ConsoleColors.RESET + "Your choice is: ");
    }
    
    public static void printAdminMenu() {
        //Menu.printLine();
        System.out.println(ConsoleColors.CYAN + "============= " + ConsoleColors.RESET + "FPT Students Management Program"+ ConsoleColors.CYAN + " =============" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.DARK_BLUE + "    1. \u2795 Add new student" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.DARK_BLUE + "    2. \u2315 Search student" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.DARK_BLUE + "    3. \u2635 List students" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.DARK_BLUE + "    4. \u25A6 Statistical table" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.DARK_BLUE + "    5. \u21E4 Exit" + ConsoleColors.RESET);
        Menu.printLine();
        Menu.printUserChoice();
    }
    public static void printStudentMenu() {
        
    }
    public static void printGenderMenu() {
        System.out.println("    - Gender: 1. \u2642 Male      2. \u2640 Female");
    }
    public static void printMajorMenu() {
        System.out.println("    " + "- Major: 1. Tourist    2. IT    3. English");
    }
    
    public static void printInvalidStament(String title) {
        System.out.println(ConsoleColors.RED + title + ConsoleColors.RESET);
    }
    public static void printContinueOption(String title) {
        System.out.println("    " + ConsoleColors.YELLOW + "\u2022 " + ConsoleColors.RESET + title + "1. Yes    2. No");
    }
    public static void printSuccessNotification(String title) {
        System.out.println("    " + ConsoleColors.GREEN + "\u2713 " + title + ConsoleColors.RESET);
    }
    public static void printFailedNotification(String title) {
        System.out.println("    " + ConsoleColors.RED + "\u2716 " + title + ConsoleColors.RESET);
    }
    
}
