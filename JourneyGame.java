import javax.imageio.IIOException;
import java.io.*;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class JourneyGame {

    //Declare variables for title and HP
    private static String title = "Dungeon Warriors";
    int playerHP = 100;
    static int enemyHP = 200;

    //Declare an array of enemies and inventory items
    static String[] enemies = {"Orc", "Cyclops", "Troll"};
    String[] backpack = {"Dagger", "Sword", "Stick"};


    // --- New method to save game
    private static void saveGame(String choices) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("previousGame.txt"));
            writer.write(choices);
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // --- Load previous game Method
    private static String LoadGame() {
        String line = " ";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("previousGame.txt"));
            while ((line = reader.readLine()) !=null){
                System.out.println("Checkpoint: ");
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;

    } //end try catch

    public static void main(String[] args) {

        System.out.println("Welcome to " + title);


        // --- Ask user if they wish to play
        System.out.println("Type 'Yes' to begin");


        // --- Get answer from user
        Scanner input = new Scanner(System.in);
        String answer = input.next();



        // -- If the user says yes, display gameMenu
        if (answer.equals("Yes")) {


            //divider
            System.out.println("-------------------------------");

            System.out.println("> 1: Load Game");
            System.out.println("> 2: New Game");
            System.out.println("> 3: Quit Game");


            // -- Declare a string variable for user input
            String gameMenu = input.next();


            //divider
            System.out.println("-------------------------------");



            if (gameMenu.equals("1")){

                //Load previous game
                String choices = LoadGame();

            } else if (gameMenu.equals("2")) {

                System.out.println("Starting new game...");
                System.out.println("-------------------------------");

                // -- Begin Adventure
                System.out.println("It's time to head out on your journey, you must " +
                        "\ncapture the dungeon and obtain the book of knowledge.");
                System.out.println("Stepping out of your home. You're greeted with the morning sun. The small village barely awake." + "\n" +
                        "\n> Do you want to head into the giant forest OR goto the merchant shop?" +
                        "\n  'Forest' || 'Merchant' ");

                String choice1 = input.next();

                //Save choice -- CHECKPOINT ONE
                saveGame("> " + choice1);



                if (choice1.equals("Forest")) {
                    System.out.println("\nYou enter the giant forest. Traveling for three days without any issues," +
                            "\nyou stumble across a strange cottage..." + "\n" + "\n> Do you want to enter the cottage OR continue your journey?" +
                            "\n 'Cottage' || 'Continue' ");



                    String choice2 = input.next();

                    //Save choice -- CHECKPOINT TWO
                    saveGame("> " + choice1 + "\n> " + choice2);




                    if (choice2.equals("Cottage")){
                        System.out.println("\nYou enter the cottage and see a old woman, " +
                                "she instantly turns around and blasts you with a spell." +
                                "\nYour body turning into a pile of ash.");
                        System.out.println("-------------------------------");
                        System.out.println("\nGAME OVER.");

                    } else if (choice2.equals("Continue")) {
                        System.out.println("\nWalking another two days, you finally reached the Dungeon!" +
                                "\n" + "Entering you get past all the traps and spot the book of knowlege." +
                                "\n" + "As you're about to take the book you hear a loud crash.");



                        //create instance of Random class
                        Random rand = new Random();

                        //Generate random integers in range 0 to 3
                        int randomEnemy = rand.nextInt(3);

                        //Display the enemy to the player
                        System.out.println("\n> Oh no! A " + enemies[randomEnemy] + " has appeared!");
                        System.out.println("'Attack'  ||  'Hide'  ||  'Run'");



                        //Get input from the player
                        String action = input.next();


                        //Save choice -- CHECKPOINT THREE
                        saveGame("> " + choice1 + "\n> " + choice2 + "\n> " + action);



                        if (Objects.equals(action, "Attack")) {
                            System.out.println("\nYou attacked the " + enemies[randomEnemy] + " barely doing damage, " +
                                    "\nyou get tossed into a stone pillar." + " The " + enemies[randomEnemy] + " killing you instantly.");
                            System.out.println("-------------------------------");
                            System.out.println("\nGAME OVER.");

                        } else if (Objects.equals(action, "Hide")) {
                            System.out.println("\nSneaking the book of knowledge off the podium and into " +
                                    "your backpack, you quickly hide behind a stone pillar."+
                                    "\nThe " + enemies[randomEnemy] + " walking closer, sniffing the air.");

                            System.out.println("\n> Do you want to sneak attack or escape?" +
                                    "\n 'Attack' || 'Escape'");

                            String choice3 = input.next();

                            if (choice3.equals("Attack")){
                                System.out.println("\nYou walk out from behind the pillar" + " sneaking up on the " + enemies[randomEnemy] +
                                        "\nyou reach into your bag pulling out your dagger." +
                                        "\nSwiftly piercing the " + enemies[randomEnemy] + " in the heart, Killing it.");
                                System.out.println("-------------------------------");
                                System.out.println("\nYOU WIN.");

                            } else if (choice3.equals("Escape")){
                                System.out.println("\nYou successfully sneak away from the enemy, Escaping with your new treasure.");
                                System.out.println("-------------------------------");
                                System.out.println("\nYOU WIN.");
                            } //end choice3 if statement

                        } else if (Objects.equals(action, "Run")) {
                            System.out.println("\nGrabbing the book, you successfully retreat from combat. Escaping with your new treasure.");
                            System.out.println("-------------------------------");
                            System.out.println("\nYOU WIN.");

                        } //end action if statement


                    } //end CHOICE2 else if



                } else if (choice1.equals("Merchant")) {
                    System.out.println("\nYou walk to the merchant shop and slip on a banana peel, Cracking your skull.");
                    System.out.println("-------------------------------");
                    System.out.println("\nGAME OVER.");

                } //end CHOICE1 if

            } else {
                System.out.println("You quit the game.");
            }

        } //end if statement

    }//end class
}