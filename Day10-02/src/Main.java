import java.io.*;
import java.util.Arrays;

public class Main
{
   public static void main(String[] args)
   {
      try
      {
         File file = new File("/home/ajdvb/IdeaProjects/AdventOfCode/Day10-02/input.txt");
         FileReader fr = new FileReader(file);
         BufferedReader br =new BufferedReader(fr);
         StringBuffer sb =new StringBuffer();
         String line;
         int ret = 0, cycle = 0, x = 1;
         String str = "";
         while((line = br.readLine())!=null)
         {
            String [] arr = line.split(" ");
            cycle += 1;
            if (cycle % 40 == 0)
            {
               System.out.println(str);
               str = "";
            }
            if (x - 1 == cycle % 40 || x == cycle % 40 || x + 1 == cycle % 40)
            {
               str += "#";
            }
            else
            {
               str += ".";
            }
            if (arr[0].equals("addx"))
            {
               cycle += 1;
               if (cycle % 40 == 0)
               {
                  System.out.println(str);
                  str = "";
               }
               x += Integer.parseInt(arr[1]);
               if (x - 1 == cycle % 40 || x == cycle % 40 || x + 1 == cycle % 40)
               {
                  str += "#";
               }
               else
               {
                  str += ".";
               }
            }
         }
         fr.close();

         System.out.println(ret);
      }
      catch (Exception e)
      {
         System.out.println("An error has occurred\n");
         System.exit(1);
      }
   }
}
