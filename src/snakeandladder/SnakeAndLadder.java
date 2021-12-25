//import package
package snakeandladder;


//class
public class SnakeAndLadder {
    //method to display message
    public static void display(String s,String position){
        System.out.println(s+" "+position);
    }
    // main method
    public static void main(String[] args){
        //variable declaration
        int currentPos=0;
        System.out.println("Welcome to Snake and Ladder Game"); //welcome message
        display("You are on: ",Integer.toString(0)); //start position
    }
}
