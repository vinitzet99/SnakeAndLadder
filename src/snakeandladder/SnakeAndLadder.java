//import package
package snakeandladder;
import java.util.Random;

//class
public class SnakeAndLadder {
    //instance variable declaration
    public static Random random=new Random();

    //method to display message
    public static void display(String s,String position){
        System.out.println(s+" "+position);
    }
    //method to roll dice
    public static int rollDice(){
        return (random.nextInt(6)+1);
    }
    // main method
    public static void main(String[] args){
        //variable declaration
        int currentPos=0;
        int dice;
        System.out.println("Welcome to Snake and Ladder Game"); //welcome message
        display("You are on: ",Integer.toString(currentPos)); //start position
        dice=rollDice(); //roll a dice
        display("You got: ", Integer.toString(dice)); //Display value of dice
    }
}
