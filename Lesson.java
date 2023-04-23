public class Lesson
{ 
  
  public static void sort()
  {
    Robot.load("sort.txt");
    Robot.setDelay(0.005);
    
    //measure the width of the arena
    int width = distanceFromEnd();
    
    //set up to be at bottom-left facing north
    turnRight();
    goToEnd();
    turnAround();
    
    int passCount = 0;
    while(passCount <= width)
    {
      bubbleSortPass();
      passCount++;
      Robot.turnLeft();
      goToEnd();
      turnRight();
    }
    //repeat that as many times as needed
    
    
  }
  
  public static void bubbleSortPass()
  {
    while(rightIsClear())
    {
      //measure left
      int left = length();
      //measure right
      turnRight();
      Robot.move();
      Robot.turnLeft();
      int right = length();
      
      System.out.println(left);
      System.out.println(right);
      //swap if out of order
      if(right < left)//< > <= >= == !=
      {
        clearRow();
        turnAround();
        goToEnd();
        turnAround();
        makeDarkColumn(left);
        turnAround();
        goToEnd();
        turnAround();
        Robot.turnLeft();
        Robot.move();
        turnRight();
        clearRow();
        turnAround();
        goToEnd();
        turnAround();
        makeDarkColumn(right);
        turnAround();
        goToEnd();
        turnAround();
        turnRight();
        Robot.move();
        Robot.turnLeft();
      }
    }
    
  }
  
  public static int distanceFromEnd()
  {
    int distance = 1;
    while(Robot.frontIsClear())
    {
      distance++;
      Robot.move();
    }
    turnAround();
    goToEnd();
    turnAround();
    return distance;
  }
  
  public static boolean rightIsClear()
  {
    turnRight();
    if(Robot.frontIsClear())
    {
      Robot.turnLeft();
      return true;
    }
    else
    {
      Robot.turnLeft();
      return false;
    }
  }
  
  //pre: facing north, in a clear column of height >=n
  //post: at end of dark column, having made a dark column of n squares
  public static void makeDarkColumn(int n)
  {
    while(n>0)
    {
      Robot.makeDark();
      moveIfClear();
      n--;
    }
    
  }
    
  //pre: at the bottom, facing north
  //post: at the bottom, facing north, return how long the column is
  public static int length()
  {
    int length = 0;
    while(Robot.onDark() && Robot.frontIsClear())
    {
      length++;
      Robot.move();
    }
    
    if(Robot.onDark())//in case solid column
      length += 1;
    
    turnAround();
    goToEnd();
    turnAround();
    
    
    return length;
    
  }
  
  //pre:any
  //post:Robot has moved n spaces
  public static void moveNTimes(int n)
  {
    while(n > 0)
    {
      Robot.move();
      n--;
    }
    
  }
  
  //solving the combine problem with integer variables
  //pre: Robot facing east, at the top-left corner of a two-column arena
  //pre: there are two dark bottom-justified columns, and total height >= arena height
  //post: same dir and loc, the two dark columns combined on the right side 
  public static void combine()
  {
    Robot.load("combine2.txt");
    
    turnRight();
    goToEnd();
    turnAround();
    
    int leftCol = 0;
    while(Robot.onDark())
    {
      Robot.move();
      //leftCol++;
      //leftCol += 1;
      leftCol = leftCol + 1;
    }
    //leftCol is the height on the left
    System.out.println(leftCol);
    
    turnAround();
    clearRow();
    Robot.turnLeft();
    Robot.move();
    Robot.turnLeft();
    
    goToFirstLight();
    
    while(leftCol > 0)
    {
      Robot.makeDark();
      moveIfClear();
      leftCol = leftCol - 1;
      //leftCol -= 1;
      //leftCol--;
      
    }
    
    
    
    //NOTE: VARIABLE DECLARATION STATEMENT
    //<type of variable> <name of variable>;
    boolean isAwake;
    int age;
    double height;
    float wage;
    char letter;
    String name;
    //there are more types
    
    //NOTE: VARIABLE ASSIGNMENT STATEMENT
    //<name of variable> = <value of variable type (literal)>;
    isAwake = true;
    age = 39;
    height = 65.38742893;
    wage = 12.50f;
    letter =  'A';
    name = "John";
    
    //NOTE: VARIABLE DECLARATION AND ASSIGNMENT SIMULTANEOUSLY OK
    int steps = 7;
        
    //NOTE: RETRIEVE THE VALUE OF A VARIABLE BY USING ITS NAME
    System.out.println(age);
    System.out.println("age");
    System.out.println(age+1);
    System.out.println(age);
    System.out.println();
    
    age = age + 1;
    //age = 16 + 1 (after retrieve)
    //age = 17 (addition next)
    //variable age is assigned the value of 17
    System.out.println(age);
    System.out.println();
    
    //BECAUSE AGE = AGE + 1; IS WAY TOO HARD TO TYPE
    //SHORTHAND INCREMENT OPERATOR: +=
    age += 1;
    System.out.println(age);
    System.out.println();
    
    //BECAUSE AGE += 1; IS WAY TOO HARD TO TYPE
    //ANOTHER SHORTHAND INCREMENT OPERATOR: ++
    age++;
    System.out.println(age);
    
    
  }
  
  
  
  
  
  
  /* BASIC METHODS DEFINED BELOW
   * void goToEnd()
   * void goToFirstDark()
   * void goToFirstLight()
   * boolean rowIsLight()
   * void turnAround()
   * void turnRight()
   * void moveIfClear()
   * void backUp()
   * void makeLightAlways()
   * void makeDarkAlways()
   */
  
  //pre: any
  //post: at end of row, same direction
  public static void goToEnd()
  {
    while(Robot.frontIsClear())
      Robot.move();
  }

  //pre: any
  //post: same direction, at first dark or at end if no dark in row
  public static void goToFirstDark()
  {
    while(!Robot.onDark() && Robot.frontIsClear())
    {
      Robot.move();
    }
  }
  
  //pre: any
  //post: same direction, at first light or at end if no light in row
  public static void goToFirstLight()
  {
    while(Robot.onDark() && Robot.frontIsClear())
    {
      Robot.move();
    }
  }
  
  //pre:top-left, facing south (on light)
  //post:top-left facing south, 
  //returns true if all the squares in the row are light, false o/w
  public static boolean rowIsLight()//NOTE: BOOLEAN, NOT VOID
  {
    while(Robot.frontIsClear())
    {
      Robot.move();
      if(Robot.onDark())
      {
        turnAround();
        goToEnd();
        turnAround();
        return false;
      }
    }
    turnAround();
    goToEnd();
    turnAround();
    return true;
  }
  
  //pre: any
  //post: same loc, opposite dir
  public static void turnAround()
  {
    Robot.turnLeft();
    Robot.turnLeft();
  }
  
  //pre: any
  //post: same loc, right from the original dir
  public static void turnRight()
  {
    Robot.turnLeft();
    Robot.turnLeft();
    Robot.turnLeft();  
  }
  
  //pre:any
  //post: same dir, one square behind original if behind square was clear, same loc o/w
  public static void backUp()
  {
    turnAround();
    moveIfClear();
    turnAround();
  }
  

  //pre: any
  //post: same dir, one square ahead if front was clear, same loc if front was not clear
  public static void moveIfClear()
  {
    if(Robot.frontIsClear())
      Robot.move();
  }
  
  //pre: any
  //post: row cleared, same dir, at the end of the row that it just cleared
  public static void clearRow()
  {
    while(Robot.frontIsClear())
    {
      makeLightAlways();
      Robot.move();
    }
    makeLightAlways();
  }
  
  //pre: any
  //post: same dir and loc, current square light
  public static void makeLightAlways()
  {
    if(Robot.onDark())
      Robot.makeLight();
  }
  
  //pre: any
  //post: same dir and loc, current square dark
  public static void makeDarkAlways()
  {
    if(!Robot.onDark())
      Robot.makeDark();
  }
    
}