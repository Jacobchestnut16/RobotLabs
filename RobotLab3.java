//Jacob Chestnut
public class RobotLab3 {

    public static void runAll() {
        Robot.setDelay(0.02);

        Robot.load("maze2.txt");
        Maze();
        Robot.load("clear.txt");
        clearBoard();
        Robot.load("clear1.txt");
        clearBoard();
        Robot.load("clear2.txt");
        clearBoard();
        Robot.load("maze.txt");
        Maze();
        Robot.load("maze1.txt");
        Maze();
        Robot.load("dots.txt");
        connectDots();
        Robot.load("dots1.txt");
        connectDots();
        Robot.load("dots2.txt");
        connectDots();
        Robot.load("sort.txt");
        sort();
        Robot.load("sort1.txt");
        sort();
    }

    //pre the rows are messy
    //post the rows are sorted and robot is back in its place
    public static void sort() {
        sortTheRow();
        //will go to the next row and sort it if it can
        while (goToNextRow()){
            sortTheRow();
        }
        goBackToTheTop();
    }

    //pre the robot is at the bottom left facing E
    //post it's at the top facing E
    private static void goBackToTheTop() {
        Robot.turnLeft();
        while (Robot.frontIsClear()) {
            Robot.move();
        }
        RobotTurnRight();
    }

    //pre the robot is at the bottom left or row left E
    //post will move to the next row if it can
    //post will stay put and return false the robot cannot move
    public static boolean goToNextRow() {
        RobotTurnRight();
        if(!Robot.frontIsClear()) {
            Robot.turnLeft();
            return false;
        }
        if(Robot.frontIsClear())
            Robot.move();
        Robot.turnLeft();
        return true;
    }

    //pre the row is messy
    //post the row is sorted
    public static void sortTheRow() {
        while (!theRowIsSorted()) {
            findTheFirstDark();
            moveTheDark();
        }
    }


    //pre robot is E at the left of a row
    //post robot is E at the left of a row
    public static boolean theRowIsSorted() {
        goToEnd();
        TurnAround();
        while (Robot.onDark()){
            Robot.move();
        }
        while (Robot.frontIsClear()) {
                Robot.move();
            if (Robot.onDark()) {
                goToEnd();
                TurnAround();
                return false;
            }
        }
        TurnAround();
        return true;
    }

    //pre robot is E at the left
    //post robot is E on the dark square
    public static void findTheFirstDark() {
        while (!Robot.onDark()){
            if(Robot.frontIsClear())
                Robot.move();
        }
    }

    //pre E on the dark
    //post E at the begging of the row with the dark square in its right spot
    public static void moveTheDark() {
        Robot.makeLight();
        goToEnd();
        TurnAround();
        while (Robot.onDark()) {
            Robot.move();
        }
        Robot.makeDark();
        goToEnd();
        TurnAround();
    }




//pre the board has dots that need connected
    //post the robot connected them
    public static void connectDots() {
        if(!Robot.onDark())
            Robot.makeDark();
        //asks if all the dots are connected
        while (!allDotsAreConnected()){
            //Don't ask it just makes it work

            //pre any
            //post finds the dot turns marks it and moves to the next dot
            if(theDotIsInFront()){
                Robot.move();
                Robot.makeDark();
                Robot.move();
            }
            if(theDotIsOnTheRight()){
                RobotTurnRight();
                Robot.move();
                Robot.makeDark();
                Robot.move();
            }
            if(theDotIsOnTheLeft()){
                Robot.turnLeft();
                Robot.move();
                Robot.makeDark();
                Robot.move();
            }
        }
    }

    public static boolean allDotsAreConnected(){
        //Will return true if all sides do not have a dot
        //This was a IDEA IntelliJ thing it shortcuts it
        //But this just returns the results of all values returned from each method
        return !theDotIsInFront() && !theDotIsOnTheLeft() && !theDotIsOnTheRight();
    }

    public static boolean theDotIsInFront(){
        //pre faces from the last dot and is on a dot
        //post is in the same spot and orientation
        //returns ture if its in front
        if(Robot.frontIsClear()) {
            Robot.move();
            if(Robot.frontIsClear())
                Robot.move();
            else {
                TurnAround();
                Robot.move();
                TurnAround();
                return false;
            }
            if (Robot.onDark()) {
                TurnAround();
                Robot.move();
                Robot.move();
                TurnAround();
                return true;
            } else {
                TurnAround();
                Robot.move();
                Robot.move();
                TurnAround();
                return false;

            }
        }else
            return false;
    }
    public static boolean theDotIsOnTheRight(){
        //pre faces from the last dot and is on a dot
        //post is in the same spot and orientation
        //returns ture if it's on the right
        RobotTurnRight();
        if(Robot.frontIsClear()) {
            Robot.move();
            if(Robot.frontIsClear())
                Robot.move();
            else {
                TurnAround();
                Robot.move();
                TurnAround();
                Robot.turnLeft();
                return false;
            }
            if (Robot.onDark()) {
                TurnAround();
                Robot.move();
                Robot.move();
                TurnAround();
                Robot.turnLeft();
                return true;
            } else {
                TurnAround();
                Robot.move();
                Robot.move();
                TurnAround();
                Robot.turnLeft();
                return false;

            }
        }else {
            Robot.turnLeft();
            return false;
        }
    }
    public static boolean theDotIsOnTheLeft(){
        //pre faces from the last dot and is on a dot
        //post is in the same spot and orientation
        //returns ture if it's on the left
        Robot.turnLeft();
        if(Robot.frontIsClear()) {
            Robot.move();
            if(Robot.frontIsClear())
                Robot.move();
            else {
                TurnAround();
                Robot.move();
                TurnAround();
                RobotTurnRight();
                return false;
            }
            if (Robot.onDark()) {
                TurnAround();
                Robot.move();
                Robot.move();
                TurnAround();
                RobotTurnRight();
                return true;
            } else {
                TurnAround();
                Robot.move();
                Robot.move();
                TurnAround();
                RobotTurnRight();
                return false;

            }
        }else{
            RobotTurnRight();
            return false;
        }
    }


    public static void Maze() {
        //pre Robot is facing E at the beginning of the board
        //post Robot is on the dark square facing forward
        while (!Robot.onDark()) {
            if(!robotCanMoveRight()) {
                if (!Robot.frontIsClear()) {
                    if (RobotCanMoveLeft()) {
                        Robot.turnLeft();
                    }
                    if (RobotCantMoveTurnAround()) {
                        TurnAround();
                    }
                }
            }else {
                RobotTurnRight();
            }
            Robot.move();
        }
    }

    private static boolean RobotCantMoveTurnAround() {
        if(!RobotCanMoveLeft())
            TurnAround();
        if(Robot.frontIsClear()){
            TurnAround();
            return true;
        }else{
            TurnAround();
            return false;
        }
    }

    private static boolean RobotCanMoveLeft() {
        Robot.turnLeft();
        if(Robot.frontIsClear()){
            RobotTurnRight();
            return true;
        }else{
            RobotTurnRight();
            return false;
        }
    }

    private static boolean robotCanMoveRight() {
        RobotTurnRight();
        if(Robot.frontIsClear()){
            Robot.turnLeft();
            return true;
        }else{

            Robot.turnLeft();
            return false;
        }
    }

    //pre the robot is at the top left facing E
    //post the Robot is at the top left facing E with a clear board
    public static void clearBoard(){
        goToBottom();
        //the robot finds the bottom right of the room and faces it's first row
        while (Robot.frontIsClear()){
            clearTheRow();
            goToEnd();
            returnToNextRow();
        }
        //the robot turns around to admire its work
        TurnAround();
    }
    //pre W with a messy row
    //post W with a neat row
    public static void clearTheRow(){
        while (Robot.frontIsClear()){
            //the robot needs to find the dark square and turn them light
            if (Robot.onDark()){
                Robot.makeLight();
            }
            //he may move after they are light
            Robot.move();
        }
        //the robot found a loop brake he needs to clear his rows all the way to the wall
        if (Robot.onDark()){
            Robot.makeLight();
        }
        //he turns around slowly to see his row he made
        TurnAround();
    }
    //pre top left E
    //post bottom right W
    public static void goToBottom(){
        while (Robot.frontIsClear()){
            Robot.move();
        }
        RobotTurnRight();
        while (Robot.frontIsClear()){
            Robot.move();
        }
        RobotTurnRight();
    }

    //the robot is lazy, so he tells his wheels to move until the row ends
    public static void goToEnd(){
        while (Robot.frontIsClear()){
            Robot.move();
        }
    }
    //pre W lower row
    //post E next row
    //post-end E end of the row
    public static void returnToNextRow(){
        Robot.turnLeft();
        //the Robot looks to his left to find another row and moves into and prepares itself for the row
        if(Robot.frontIsClear()) {
            Robot.move();
            Robot.turnLeft();
        }else {
            // there are not any more rows let me check this row once more just increase
            Robot.turnLeft();
            goToEnd();
        }
    }



    //pre any
    //post turned right
    public static void RobotTurnRight(){
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.turnLeft();
    }
    //pre any
    //post facing 108 degrees in the opposite direction
    public static void TurnAround(){
        Robot.turnLeft();
        Robot.turnLeft();
    }
}
