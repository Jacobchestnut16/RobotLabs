/*
RobotClock helps turn RobotLab1.tellTime() into a working clock.

Note: RobotClock requires RobotLab1 to have the following methods:
printZero(), printOne(), printTwo(), ... printNine() and printColon().

It also requires that the Robot is facing east after telling the time.

To make it work:
1. Save RobotClock.java in the same folder as RobotLab1.
2. In RobotLab1:
public static void runClock()
{
  Robot.load("arena.txt");//arena = your text file from tellTime()
  Robot.setDelay(0.01);
  RobotClock.tellTime();
}	

If you have any questions, let me know.

*/

import java.util.*;

public class RobotClock {

    //pre:Robot facing east at top left corner of clear board
    //post:Robot will continue to print the time and clear the board until the program is closed
    public static void tellTime() {

          //the following statements will run over and over
        while (true) {
            do {
                //get the hour and minute from the computer, store into hour and minute
                int hour = (Calendar.getInstance()).get(Calendar.HOUR_OF_DAY);
                int minute = (Calendar.getInstance()).get(Calendar.MINUTE);

                //arithmetic to break hour and minute into digits
                int hour1 = hour / 10;    //hour1 = hour's tens digit
                int hour2 = hour % 10;    //hour2 = hour's ones digit
                if (hour1 >= 1 && hour2 > 2) {
                    hour1 -= 1;
                    hour2 -= 2;
                }
                int minute1 = minute / 10;    //minute1 = minute's tens digit
                int minute2 = minute % 10;    //minute2 = minutes's ones digit

                //call the methods to tell the time
                if (hour1 == 1) printDigit(1);
                else printDigit(0);
                printDigit(hour2);
                RobotLab1.printColon();
                printDigit(minute1);
                printDigit(minute2);

                //clear the display, leaving the Robot at the top left corner facing east
                if ((Calendar.getInstance()).get(Calendar.SECOND) == 55)
                    clearBoard();
            }
            while ((Calendar.getInstance()).get(Calendar.SECOND) == 0);
        }
    }

    //pre: n integer from 0 to 9
    //post: Robot will have moved according to whatever method in RobotLab1 was called
    public static void printDigit(int n) {
        if (n == 0) RobotLab1.printZero();
        else if (n == 1) RobotLab1.printOne();
        else if (n == 2) RobotLab1.printTwo();
        else if (n == 3) RobotLab1.printThree();
        else if (n == 4) RobotLab1.printFour();
        else if (n == 5) RobotLab1.printFive();
        else if (n == 6) RobotLab1.printSix();
        else if (n == 7) RobotLab1.printSeven();
        else if (n == 8) RobotLab1.printEight();
        else if (n == 9) RobotLab1.printNine();
        else System.out.println("Invalid n: " + n);
    }

    public static void turnLeft() {
        Robot.turnLeft();
    }

    //pre:Robot facing east
    //post:Robot at top left corner, facing east, all squares light
    public static void clearBoard() {
        goToEdge();
        turnRight();
        goToEdge();
        turnAround();//facing north, at bottom right square

        while (Robot.frontIsClear()) {
            turnLeft();
            clearRow();
            turnAround();
            goToEdge();
            turnLeft();
            if (Robot.frontIsClear()) {
                Robot.move();
            }
        }
        //go to the top left corner, face east
        turnLeft();
        clearRow();
        turnAround();

    }

    //pre: facing any direction
    //post: facing opposite direction, board unchanged
    public static void turnAround() {
        Robot.turnLeft();
        Robot.turnLeft();
    }

    //pre: facing any direction
    //post: turned right, board unchanged
    public static void turnRight() {
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.turnLeft();
    }

    //pre: facing west
    //post: facing west, returning whether at top
    public static boolean atTop() {
        turnRight();
        boolean retval = !Robot.frontIsClear();
        Robot.turnLeft();
        return retval;
    }

    //pre:facing west
    //post:facing west, row cleared
    public static void clearRow() {
        while (Robot.frontIsClear()) {
            if (Robot.onDark()) {
                Robot.makeLight();
            }
            Robot.move();
        }
        if (Robot.onDark()) {
            Robot.makeLight();
        }
    }

    //pre:facing any direction
    //post:at edge of row
    public static void goToEdge() {
        while (Robot.frontIsClear()) {
            Robot.move();
        }
    }


}