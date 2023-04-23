public class RobotLab2 {
    private static int candlesLit = 0;
    private static int LeftOrRight=0;


    public static void clearRow() {
        moveAndClear();
        moveAndClear();
        moveAndClear();
        moveAndClear();
        moveAndClear();
        moveAndClear();
        moveAndClear();
        moveAndClear();
        moveAndClear();
        moveAndClear();
    }
    public static void lightCandles() {
        while(candlesLit < 10) {
            FindTheOfTheCandleAndLight();
        }
        if (candlesLit == 10) {
            candlesLit = 0;
        }
    }

    private static void FindTheOfTheCandleAndLight() {
        if (!Robot.frontIsClear()) {
            Robot.turnLeft();
            Robot.move();
            RobotTurnRight();
        } else {
            Robot.move();
            Robot.makeDark();
            candlesLit ++;
            Robot.move();
            RobotTurnRight();
            if (Robot.frontIsClear()){
                Robot.move();
            }if (Robot.frontIsClear()){
                Robot.move();
            }if (Robot.frontIsClear()){
                Robot.move();
            }
            Robot.turnLeft();
        }
    }

    private static void RobotTurnRight() {
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.turnLeft();
    }

    public static void swap() {

        Robot.turnLeft();
        Robot.move();

        swapARow();
        returnUpARow();
        swapARow();
        returnUpARow();
        swapARow();
        returnUpARow();
        swapARow();
        returnUpARow();
        swapARow();
        returnUpARow();
        swapARow();
        returnUpARow();
        swapARow();
        returnUpARow();
        swapARow();
        returnUpARow();
        swapARow();
        returnUpARow();
        swapARow();
        returnUpARow();
    }
    //pre W on a completed row on the left side
    //post W up a row on the left side
    //post2 when the robot reaches the end of the row it will return to the center N
    private static void returnUpARow() {
        RobotTurnRight();
        if (Robot.frontIsClear()) {
            Robot.move();
            Robot.turnLeft();
        }else{
            RobotTurnRight();
            Robot.move();
            Robot.turnLeft();
        }
    }
    public static void completeRectangle() {
        GoToFirstDark();
        FindDarkNextSquare();
        RobotFaceNextSquare();
        FindDarkNextSquare();
        RobotFaceNextSquare();
        FindDarkNextSquare();
        RobotFaceNextSquare();
        FindDarkNextSquare();
        RobotFaceNextSquare();
    }

    //pre robot is facing W or E
    //post robot faces S
    //Was used for this first now everytime it can turn to each
        //next square since a rectangle turns 90 4 time in the same direction
    private static void RobotFaceNextSquare() {
        if (LeftOrRight==0)
            RobotTurnRight();
        if(LeftOrRight==1)
            Robot.turnLeft();
    }

    private static void FindDarkNextSquare() {
        Robot.move();
        while(!Robot.onDark()){
            Robot.makeDark();
            Robot.move();
        }
    }


    //pre the Robot is anywhere on the board and will begin moving to find a dark Square
    //post will face e if a dark square is in the first line and W for any other line
    //the robot will be sitting on the dark Square
    public static void GoToFirstDark(){
        LeftOrRight=0;
        while (Robot.frontIsClear()) {
            Robot.move();
            if (Robot.onDark()) {
                return;
            }
        }
        while(!Robot.onDark()) {
            FindFirstDark();
        }
    }
    //helper method to move across the whole board as long as it's a square
    public static void FindFirstDark() {
        RobotTurnRight();
        Robot.move();
        RobotTurnRight();
        LeftOrRight = 1;
        while (Robot.frontIsClear()) {
            Robot.move();
            if (Robot.onDark()) {
                return;
            }
        }
        RobotTurnAround();
        LeftOrRight = 0;
        while (Robot.frontIsClear()) {
            Robot.move();
            if (Robot.onDark()) {
                return;
            }
        }
    }

    //pre Robot is on any block and will face any direction
    //post Robot will now face direction B or turned 180 degrees
    public static void RobotTurnAround(){
        Robot.turnLeft();
        Robot.turnLeft();
    }


    //Pre E Can be on a light or dark square, and the robot will clear any square that is dark
    //Post E the square behind the robot is light, and it is now on the next square
    public static void moveAndClear() {
        if (Robot.onDark()){
            Robot.makeLight();
        }
        if (Robot.frontIsClear())
            Robot.move();
    }

    //pre should be W on the left to start asking what the row contains and swaps them
    //post W on a completed row on the left side
    public static void swapARow() {
        int Lone = 0;
        int Rone = 0;

        if (Robot.onDark()){
            Rone = 1;
        } else {
            Rone = 0;
        }

        Robot.turnLeft();
        Robot.turnLeft();
        Robot.move();
        Robot.move();

        if (Robot.onDark()){
            Lone = 1;
        } else {
            Lone = 0;
        }

        if (Rone == 1) {
            if (!Robot.onDark())
                Robot.makeDark();
        } else {
            if (Robot.onDark())
                Robot.makeLight();
        }

        Robot.turnLeft();
        Robot.turnLeft();
        Robot.move();
        Robot.move();

        if (Lone == 1) {
            if (!Robot.onDark())
                Robot.makeDark();
        } else {
            if (Robot.onDark())
                Robot.makeLight();
        }
    }



}
