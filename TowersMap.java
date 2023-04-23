import java.io.*;  // For PrintWriter, FileWriter
public class TowersMap
{
  public static void make(int n) throws IOException
  {
    PrintWriter out = new PrintWriter(new FileWriter("towers"+n+".txt"), true);
    
    String[] lines = new String[n+4];
    
    int width = 3*n+6;
    // Initialize each row of lines to be empty
    for(String line: lines) line="";
    
    // Build top and bottom wall
    String wallString = "";
    for(int i = 0; i < width; i++) wallString += "X";
    // Assign first and last element of lines to be wallString
    lines[0]=wallString;
    lines[lines.length-1]=wallString;
    
    // Build second row: X-spaces-X
    String secondRow = "X";
    for(int i = 0; i < width-2; i++) secondRow += ".";
    secondRow += "X";
    // Assign second element of lines to be the second row
    lines[1] = secondRow;
    
    // Build second from bottom row with plates
    String secondFromBottom = "X.";
    // Build a string of n X's
    String plate = "";
    for(int i = 0; i < n; i++)plate+="X";
    // Add three plates with spaces after to secondFromBottom
    for(int i = 0; i < 3; i++)secondFromBottom+=plate+".";
    // Add extra brick at the end of secondFromBottom
    secondFromBottom += "X";
    // Assign second to last element of lines to be secondFromBottom
    lines[lines.length-2] = secondFromBottom;
    
    // Add each line with a disk in it
    for(int i = 2; i < lines.length-2; i++)
    {
      // Start with "X."
      String diskLine = "X.";
      int disk = i-1;
      // Build the line with a disk in it
      diskLine+=darkString(disk) + lightString(width-3-disk);
      diskLine+="X";
      lines[i] = diskLine;
    }
    
    // Add the robot
    String bottomDisk = lines[lines.length-3]; 
    bottomDisk = bottomDisk.substring(0,1) + "E" + bottomDisk.substring(2,bottomDisk.length());
    lines[lines.length-3] = bottomDisk;
      
    // Add each String to the text file
    for(String line:lines) out.println(line);
    out.close();
    // Robot.load("towers"+n+".txt");
  }
  public static String darkString(int length)
  {
    String retval = "";
    for(int i = 0; i < length; i++)
    {
      retval += ":";
    }
    return retval;
  }
  public static String lightString(int length)
  {
    String retval = "";
    for(int i = 0; i < length; i++)
    {
      retval += ".";
    }
    return retval;
  }
}