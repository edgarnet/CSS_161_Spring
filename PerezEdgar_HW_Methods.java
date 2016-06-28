import java.util.Scanner;

/**
 * The two Mario boards, with and without the Scanner class.
 * Program one is simply the empty boards.
 * Program two utilizes user input for fill in coins and mario for boards.
 * @author Edgar Perez 
 * @version 0.1
 */
public class PerezEdgar_HW_Methods
{
    public static void main(String[] args) {  //Main method calls both programs.
        runProgramOne();  //Runs program one first.
        runProgramTwo();  //Runs program two last to prevent parameter confusion.
    }
    
    public static void runProgramOne() {  //Program one which prints empty boards.
        String space = "";         //Empty string parameter.
        marioBoard1(space,space);  //First board.
        marioBoard2(space,space);  //Second board.
    }
    
    public static void runProgramTwo() {  //Program two which fills boards with user input.
        Scanner keyboard = new Scanner(System.in);          //Scanner object.
        System.out.println("What does Mario look like?");   //Asks user for mario.
        String mario = keyboard.nextLine();                 //User's input for mario.
        System.out.println("What does a coin look like?");  //Asks user for coin.
        String coin = keyboard.nextLine();                  //User's take on coin.
        System.out.println("Here is your board...");        //Prints...
        marioBoard1(mario,coin);                            //First board with mario and coins.
        marioBoard2(mario,coin);                            //Second board with mario and coins.
    }
    
    public static void marioBoard1(String mario, String coin) { //Method for first board.
        String space = ""; //Empty string parameter.
        segment1(space);   //Establishes coin/space for first segment
        segment2(coin);    //Establishes coin/space for second segment.
        segment1(space); 
        segment1(coin);  
        segment2(space); 
        segment3(mario);   //Establishes mario for third segment.
    }
    
    public static void marioBoard2(String mario, String coin){  //Method for second board.
        String space = ""; //Empty string parameter.
        segment1(space);   //Establishes coin/space for first segment
        segment1(space);   //Establishes coin/space for second segment.
        segment2(coin);  
        segment1(space);  
        segment1(coin);  
        segment1(space);  
        segment3(mario);   //Establishes mario for third segment.
    }
    
    public static void segment1(String coin) {  //Output for first segment.
        System.out.print("||\n||"+coin+"\n||"+coin+"\n||"+coin+"\n||\n||\n\n");
    }
    
    public static void segment2(String coin) {  //Output for second segment.
        System.out.print("||\n||   |?|"+coin+"\n||\n||\n||   |?|"+coin+"\n||\n\n");
    }
    
    public static void segment3(String mario) { //Output for third segment.
        System.out.print("||\n||||\n||||||\n||||||||\n||||||||||\n||||||||||||"+mario+"\n||\n||              ^\n|----------------\n\n");
    }
}
