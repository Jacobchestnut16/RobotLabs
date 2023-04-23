//Jacob Chestnut

import java.io.IOException;
public class RobotLab4
{
  static int numDisks = 8;//global integer variable
  //since numDisks is global, it is available in all methods

  static int startTime = (int) System.currentTimeMillis(); // takes in the time as an int

  //tracking
  //1 = 1m, 3sec
  //2 = 3m, 2sec
  //3 = 7m, 2sec
  //4 = 15m, 3sec
  //5 = 31, 5
  //7 = 127, 6
  //8 = 255, 7
  //9 = 511, 12
  //10 = 1023, 19
  //12 = 4095, 67
  //13 = 8191, 126
  //14 = 16383, 282
  //15 = 32767, 512

  //int pre any
  //post returns an int that solves how many moves will be made
  public static int Math(){
    //y = -1 + 2^x
    int x = numDisks;
    int solve2rootX = (int) Math.pow(2, x);
    return solve2rootX - 1;
  }


  public static void main(String[] args) throws IOException
  {
    //keep these first two lines of code: they make and load the arena based on numDisks
    Robot.setDelay(0.000);
    TowersMap.make(numDisks);
    Robot.load("towers"+numDisks+".txt");

    //insert the rest of Towers of Hanoi solution here
    //remember that we call moveSmallest() and moveNonSmallest() until the tower has been moved
    //break moveSmallest() and moveNonSmallest() down into small, manageable methods (goToTop(), goToNext(), eraseTop(), etc.)


    //prints pre moves total
    System.out.println("The Moves made should equal: " + Math());
    System.out.println("Y = -1 + 2^x");

    //moves the tower
    moveTheTower();

    //gets the end time
    int endTime = (int) System.currentTimeMillis();
    //counts the time
    int e = endTime - startTime;
    //prints out how long it took
    System.out.println(e/1000 +" seconds long");

  }


  //pre the robot is E bottom
  //post the tower is moved somewhere else
  public static void moveTheTower(){
    int moves = Math();
    moveSmallest();
    //adds a move after each move
    moves--;
    System.out.println(moves + " moves left");
    // loops until the tower moved
    while (!theTowerMoved()) {
      moveTheNonSmallest();
      moves--;
      System.out.println(moves + " moves left");
      moveSmallest();
      moves--;
      System.out.println(moves + " moves left");

    }
  }

  //pre any
  //post did not change returns T or F
  public static boolean theTowerMoved() {
    move();
    turnLeft();
    int x = 0;
    while (Robot.onDark()){
      move();
      x ++;
    }
    turnRight();
    backUp();
    goToBottom();
    //gathers info and equates to see if the robot finished moving the tower
    return x == numDisks;
  }

  //pre any facing e bottom
  //post facing e bottom moved the smallest to the right
  public static void moveSmallest(){
    //finds the smallest
    findSmallest();
    goToTop();
    int x = eraseTop();
    goToBottom();
    moveToTheNext();
    goToTop();
    //moved one spire over to the right and draws the disk
    drawDisk(x);
    goToBottom();
  }

  //the int created to check if the robot puts the disk in the same place
  public static int moveLoop = 0;

  //pre any E bottom
  //post moved the non smallest any E bottom
  public static void moveTheNonSmallest(){
    //similar to moveSmallest()
    findTheNonSmallest();
    goToTop();
    int x = eraseTop();
    goToBottom();
    moveToTheNext();
    //counts e and x being the variable length from above before moving
    int e = countTheTop();
    moveToSpot(x, e);
    //well the robot is not smart like us
    //sometimes the robot will pick up the wrong piece
    //therefore we have to tell the robot it didn't finish its job go back and try a new disk
    if (moveLoop == 2)
    {
      //follows the same method of moving except for...
      moveToTheNext();
      findTheNonSmallest();
      goToTop();
      x = eraseTop();
      /*...we can always assume that if the robot picked up the wrong disk it will have to put that disk
      two spaces to the right so that its on top of the piece it tried to move
      always works because the smallest will be on the right of it and the piece it tried to move will be to it's left*/
      moveToTheNext();
      moveToTheNext();
      goToTop();
      drawDisk(x);
      goToBottom();
    }

    //makes the loop always happen from 0
    moveLoop = 0;
  }

  //pre E bottom of where the disk is at that needs to be moved
  //post E bottom of where the disk can be moved
  public static void moveToSpot(int x, int e) {
    //a lot happens here we need to move the piece so that were not bigger than the pieces already there
    //we want to make sure that it knows 0 is a free spot, and it can be placed
    //the move loop tells us that the robot moved a piece and put it back in the same spot
    //so within moveTheNonSmallest() we tell the robot how to find the right non smallest
    while (x > e && e != 0 && moveLoop != 2){
      moveLoop ++;
      moveToTheNext();
      e = countTheTop();
    }
    //this will also draw the disk in the right spot
    goToTop();
    drawDisk(x);
    goToBottom();
  }

  // int to makes sure the robot cannot pick up the same disk twice
  public static int CheckTheLastSize = 0;
  //int to make sure the robot doesn't move the same two disks
  public static int ConditionForEnteralLoop = 0;

  //pre any E bottom
  //post any E bottom of where the non smallest disk is
  public static void findTheNonSmallest(){
    int l1 = countTheTop();
    /* the robot needs to find a non smallest sometimes it can be the same one we just moved, but all that would
    cause is a loop that makes the robot only move three disks, so we ask the robot to make sure it grabs a new one
    //we don't want the robot to move 0 because 0 does nothing to the tower
    we don't want the robot to find the smallest and move it, and we do not want the robot to continuously pick up the same two disks
          where in a four tall tower it could just pick up the 2 & 3 disks and keep moving only those two
    */
    while (l1 == CheckTheLastSize || countTheTop() == 0 || isSmallest() && ConditionForEnteralLoop != 3){
      //while its true the robot goes to the next disk
      moveToTheNext();
      //and recounts the top disk
      l1 = countTheTop();
      //adds a number to the same two disks moved loop
      ConditionForEnteralLoop++;
    }
    //when the loop occurs we just skip the non smallest because we can then move a bigger disk if possible
    if (ConditionForEnteralLoop == 3){
      moveSmallest();
      //this can cause the robot to not be able to move the any smaller disks if needed,
      //so we subtract it to allow the robot to move the last disk it counted
      CheckTheLastSize --;
    }else{
      //we want the robot to remember its last piece when it can be moved
    CheckTheLastSize = l1;}
    //just resets the loop to 0
    ConditionForEnteralLoop = 0;

  }

  //pre any E bottom of where the disk is
  //post same E bottom with the disk removed returning its size value
  public static int eraseTop() {
    int i = 0;
    move();
    turnRight();
    move();
    turnLeft();
    while (Robot.onDark()){
      i++;
      Robot.makeLight();
      move();
    }
    turnAround();
    move(i+1);
    turnAround();
    goToBottom();
    // this is not a ninja method so that we can shortcut a count and erase
    // I may fix this
    // but its helpful this way so the robot only remembers a number for if it moves the disk
    return i;
  }

  //pre any E bottom
  //post any E bottom of the smallest disk
  public static void findSmallest(){
    while (!isSmallest()){
      moveToTheNext();
    }
  }

  //pre any E bottom
  //post did not change returns T or F
  public static boolean isSmallest(){
    int x = countTheTop();
    return x == 1;
  }

  //pre any E bottom
  //post moved a spire over, any E bottom
  public static void moveToTheNext(){
    move(numDisks+1);
    if(!Robot.frontIsClear()){
      turnAround();
      GoToEnd();
      turnAround();
    }

  }

  //pre any E bottom
  //post any E bottom returns the top number
  public static int countTheTop() {
    goToTop();
    turnRight();
    move();
    turnLeft();
    if(!Robot.frontIsClear()){
      turnLeft();
      move();
      turnRight();
    }
    int length = length();
    goToBottom();
    return length;
  }

  //pre any E
  //post any E bottom
  public static void goToBottom() {
    move();
    turnRight();
    GoToEnd();
    turnLeft();
    backUp();
  }

  //pre any
  //post any end of the row
  public static void GoToEnd() {
    while (Robot.frontIsClear()){
      move();
    }
  }

  //pre any E bottom
  //post any E top
  public static void goToTop() {
    move();
    turnLeft();
    while (Robot.onDark()){
      move();
    }
    turnRight();
    backUp();
  }


  //pre: facing at least diskLength light squares
  //post: disk drawn (squares made dark), Robot back to original location and direction
  public static void drawDisk(int diskLength)
  {
    int temp = diskLength;
    while(diskLength > 0)
    {
      Robot.move();
      Robot.makeDark();
      diskLength = diskLength - 1;
    }
    turnAround();
    move(temp);
    turnAround();
  }

  //shortcut method for moving one square
  public static void move()
  {
    if (Robot.frontIsClear())
    Robot.move();
  }


  //pre: facing at least n clear squares
  //post: Robot has moved n squares ahead, direction unchanged
  public static void move(int n)
  {
    while(n > 0)
    {
      move();
      n--;
    }
  }

  //pre:facing a disk (dark squares) of any length>0
  //post: location and direction unchanged, length of disk returned
  public static int length()
  {
    int length = 0;
    move();
    while(Robot.onDark())
    {
      move();
      length++;
    }
    turnAround();//methods that return values should not create side effects!
    move(length+1);
    turnAround();
    return length;
  }

  public static void backUp()
  {
    turnAround();
    Robot.move();
    turnAround();
  }

  public static void turnAround()
  {
    Robot.turnLeft();
    Robot.turnLeft();
  }

  public static void turnRight()
  {
    Robot.turnLeft();
    Robot.turnLeft();
    Robot.turnLeft();
  }
  public static void turnLeft(){
    Robot.turnLeft();

  }

}