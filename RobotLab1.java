//Jacob Chestnut


public class RobotLab1 {

    public static void main(String[] args) {
        runClock();
    }

    public static void runClock()
    {
        Robot.load("clockArena.txt");//arena = your text file from tellTime()
        Robot.setDelay(0.01);
        RobotClock.tellTime();

    }


    public static void DarkSquareLoop() {
        Robot.move();
        Robot.makeDark();
    }
    public static void MoveAndTurnRight(){
        Robot.move();
        Lesson.turnRight();
    }

    private static void MoveAndTurnLeft() {
        Robot.move();
        Robot.turnLeft();
    }

    public static void printZero(){
        MoveAndTurnRight();
        DarkSquareLoop();
        DarkSquareLoop();
        DarkSquareLoop();
        MoveAndTurnLeft();

        DarkSquareLoop();
        Robot.turnLeft();
        Robot.move();
        Robot.move();
        Robot.move();
        DarkSquareLoop();

        Lesson.turnRight();
        DarkSquareLoop();
        Lesson.turnRight();
        Robot.move();
        Robot.move();
        Robot.move();
        MoveAndTurnLeft();
        Robot.makeDark();

        MoveAndTurnLeft();
        DarkSquareLoop();
        DarkSquareLoop();
        DarkSquareLoop();
        MoveAndTurnRight();

        Robot.move();
    }



    public static void printOne(){
        Robot.move();
        MoveAndTurnRight();
        Robot.makeDark();
        DarkSquareLoop();
        DarkSquareLoop();
        DarkSquareLoop();
        DarkSquareLoop();
        Robot.turnLeft();
        MoveAndTurnLeft();
        Robot.makeDark();
        DarkSquareLoop();
        DarkSquareLoop();
        DarkSquareLoop();
        DarkSquareLoop();
        Lesson.turnRight();
        Robot.move();
        Robot.move();
    }
    public static void printTwo(){
        MoveAndTurnRight();
        DarkSquareLoop();
        Robot.move();
        Robot.move();
        DarkSquareLoop();

        Robot.turnLeft();
        DarkSquareLoop();
        Robot.turnLeft();
        DarkSquareLoop();
        Robot.move();
        Robot.move();
        DarkSquareLoop();

        Lesson.turnRight();
        DarkSquareLoop();
        Lesson.turnRight();
        Robot.move();
        DarkSquareLoop();
        Robot.move();
        DarkSquareLoop();

        Robot.turnLeft();
        DarkSquareLoop();
        Robot.turnLeft();
        Robot.move();
        Robot.move();
        DarkSquareLoop();

        MoveAndTurnRight();
        Robot.move();
    }
    public static void printThree(){
        DarkSquareLoop();
        Lesson.turnRight();
        Robot.move();
        Robot.move();
        Robot.move();
        DarkSquareLoop();

        Robot.turnLeft();
        DarkSquareLoop();
        Robot.turnLeft();
        Robot.move();
        DarkSquareLoop();
        Robot.move();
        DarkSquareLoop();

        Lesson.turnRight();
        DarkSquareLoop();
        Lesson.turnRight();
        Robot.move();
        DarkSquareLoop();
        Robot.move();
        DarkSquareLoop();

        Robot.turnLeft();
        MoveAndTurnLeft();
        DarkSquareLoop();
        Robot.move();
        DarkSquareLoop();

        MoveAndTurnRight();
        Robot.move();
    }
    public static void printFour(){
        DarkSquareLoop();
        Lesson.turnRight();
        DarkSquareLoop();
        DarkSquareLoop();
        Robot.turnLeft();
        DarkSquareLoop();
        DarkSquareLoop();
        MoveAndTurnRight();
        Robot.move();
        Robot.move();
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.makeDark();
        DarkSquareLoop();
        DarkSquareLoop();
        DarkSquareLoop();
        DarkSquareLoop();

        Lesson.turnRight();
        Robot.move();
    }
    public static void printFive(){
        DarkSquareLoop();
        Lesson.turnRight();
        DarkSquareLoop();
        Robot.move();
        Robot.move();
        DarkSquareLoop();

        Robot.turnLeft();
        DarkSquareLoop();
        Robot.turnLeft();
        Robot.move();
        DarkSquareLoop();
        Robot.move();
        DarkSquareLoop();

        Lesson.turnRight();
        DarkSquareLoop();
        Lesson.turnRight();
        Robot.move();
        DarkSquareLoop();
        Robot.move();
        DarkSquareLoop();

        Robot.turnLeft();
        Robot.move();
        Robot.makeDark();
        Robot.turnLeft();
        DarkSquareLoop();
        Robot.move();
        Robot.move();
        MoveAndTurnRight();
        Robot.makeDark();
        Robot.move();

    }
    public static void printSix(){
        MoveAndTurnRight();
        DarkSquareLoop();
        DarkSquareLoop();
        DarkSquareLoop();

        MoveAndTurnLeft();
        DarkSquareLoop();
        Robot.turnLeft();
        Robot.move();
        DarkSquareLoop();
        Robot.move();
        DarkSquareLoop();

        Lesson.turnRight();
        DarkSquareLoop();
        Lesson.turnRight();
        Robot.move();
        DarkSquareLoop();
        Robot.move();
        DarkSquareLoop();

        Robot.turnLeft();
        MoveAndTurnLeft();
        DarkSquareLoop();
        Robot.move();
        Robot.move();
        MoveAndTurnRight();
        Robot.move();
    }
    public static void printSeven(){
        DarkSquareLoop();
        DarkSquareLoop();
        Lesson.turnRight();
        Robot.move();
        Robot.move();
        DarkSquareLoop();
        DarkSquareLoop();

        Robot.turnLeft();
        MoveAndTurnLeft();
        Robot.move();
        DarkSquareLoop();
        Robot.move();
        DarkSquareLoop();

        Lesson.turnRight();
        DarkSquareLoop();
        Lesson.turnRight();
        DarkSquareLoop();



        MoveAndTurnLeft();
        MoveAndTurnLeft();
        Robot.move();
        MoveAndTurnRight();

    }
    public static void printEight(){
        MoveAndTurnRight();
        DarkSquareLoop();
        Robot.move();
        DarkSquareLoop();
        MoveAndTurnLeft();
        DarkSquareLoop();

        Robot.turnLeft();
        Robot.move();
        DarkSquareLoop();
        Robot.move();
        DarkSquareLoop();

        Lesson.turnRight();
        DarkSquareLoop();
        Lesson.turnRight();
        Robot.move();
        DarkSquareLoop();
        Robot.move();
        DarkSquareLoop();

        Robot.turnLeft();
        MoveAndTurnLeft();
        DarkSquareLoop();
        Robot.move();
        DarkSquareLoop();
        MoveAndTurnRight();
        Robot.move();
    }
    public static void printNine(){
        DarkSquareLoop();
        DarkSquareLoop();
        DarkSquareLoop();
        MoveAndTurnRight();
        DarkSquareLoop();
        DarkSquareLoop();
        DarkSquareLoop();
        DarkSquareLoop();

        Robot.turnLeft();
        Robot.turnLeft();
        Robot.move();
        Robot.move();
        Robot.turnLeft();
        DarkSquareLoop();
        DarkSquareLoop();
        DarkSquareLoop();
        Lesson.turnRight();
        DarkSquareLoop();
        Robot.move();
        Lesson.turnRight();
        Robot.move();
        Robot.move();
        DarkSquareLoop();
        Robot.move();

    }
    public static void printColon(){
        Robot.move();
        Lesson.turnRight();
        Robot.move();
        Robot.move();
        Robot.move();
        Robot.move();
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.move();
        Robot.makeDark();
        Robot.move();
        Robot.move();
        Robot.makeDark();
        Robot.move();
        Lesson.turnRight();
        Robot.move();
    }




    public static void darkenComb() {
        //RobotFillComb.CombFill();
    }
    public static void makeCheckered() {
        //RobotMakeCheckered.Checkered();
    }





}
