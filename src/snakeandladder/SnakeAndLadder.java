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

    // main method
    public static void main(String[] args) {
        //variable declaration
        int currentPos = 0;
        int dice;
        System.out.println("Welcome to Snake and Ladder Game"); //welcome message
        while (currentPos != maxPosition) {
            display("You are on: ", Integer.toString(currentPos)); //start position
            dice = rollDice(); //roll a dice
            display("You got: ", Integer.toString(dice)); //Display value of dice
            currentPos = move(currentPos, dice);
            currentPos= validatePos(dice,currentPos); //check if new position is valid
            display("Current Position: ", Integer.toString(currentPos)); //Display new position

        }
    }
}