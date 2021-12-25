//import package
package snakeandladder;
import java.util.Random;

//class
public class SnakeAndLadder {
    //instance variable declaration
    public static Random random = new Random();
    public static final int NO_PLAY = 0;
    public static final int LADDER = 1;
    public static final int SNAKE = 2;
    public static int choice = 0;
    public static final int maxPosition=100;
    public static final int minPosition=0;
    public static final int PLAYER1=1;
    public static final int PLAYER2=2;
    //method to display message
    public static void display(String s, String position) {
        System.out.println(s + " " + position);
    }

    //method to roll dice
    public static int rollDice() {
        return (random.nextInt(6) + 1);
    }
    //method to check if position is valid or not
    public static int validatePos(int dice,int position){
        if(position<minPosition){
            display("You have to start from 0!!","");
            return minPosition;
        }
        else if(position>maxPosition){
            display("But player require: "+(-position+dice+maxPosition)," to win !!!");
            return position-dice;
        }
        else return position;
    }
    //method to generate option to HOLD,CLIMB or BITE
    public static int move(int pos, int dice) {
        int option = random.nextInt(3);
        if (option == NO_PLAY) {
            display("Chosen not to Play", "");
            choice = NO_PLAY;
            return pos;
        } else if (option == SNAKE) {
            display("Snake Bite !!", "");
            choice = SNAKE;
            return pos - dice;
        } else {
            display("Climb Ladder !!!", "");
            choice = LADDER;
            return pos + dice;
        }
    }
    //method to decide player chance
    public static int chance(int option,int playerChance){
        if(option==LADDER){
            return playerChance;
        }
        else{
            if(playerChance==PLAYER1) {
                display("*******************", "*****************");
                return PLAYER2;
            }
            else {
                display("*******************","*****************");
                return PLAYER1;
            }
        }
    }
    //method to check which player won
    public static void checkWon(int currentPos,int playerChance){
        if(currentPos==maxPosition){
            display("Player "+ playerChance, "Won !!!!");

        }
    }
    // main method
    public static void main(String[] args) {
        //variable declaration
        int currentPos[] ={0,0,0};
        int dice;
        int countDiceRoll=0;
        int playerChance=PLAYER1;
        System.out.println("Welcome to Snake and Ladder Game"); //welcome message
        while(currentPos[playerChance]!=maxPosition) { // check if anyone reached 100
            display("Turn of Player: ",Integer.toString(playerChance)); //Display which player is rolling
            dice = rollDice(); //roll a dice
            countDiceRoll++; //count dice rolling
            display("You got: ", Integer.toString(dice)); //Display value of dice
            currentPos[playerChance] = move(currentPos[playerChance], dice); //move player
            currentPos[playerChance]= validatePos(dice,currentPos[playerChance]); //check if new position is valid
            display("Current Position: ", Integer.toString(currentPos[playerChance])); //Display new position
            checkWon(currentPos[playerChance],playerChance);//check if anyone won
            playerChance=chance(choice,playerChance);//decide chance
        }
        display("Dice Rolled for",Integer.toString(countDiceRoll)+" times."); //Display count of rolling
    }
}