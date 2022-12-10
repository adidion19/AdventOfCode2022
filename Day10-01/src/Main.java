import java.io.*;
import java.util.Arrays;

public class Main
{
   public static void main(String[] args)
   {
      try
      {
         File file = new File("/home/ajdvb/IdeaProjects/AdventOfCode/Day10-01/input.txt");
         FileReader fr = new FileReader(file);
         BufferedReader br =new BufferedReader(fr);
         StringBuffer sb =new StringBuffer();
         String line;
         int ret = 0, cycle = 0, x = 1;
         while((line = br.readLine())!=null)
         {
            String [] arr = line.split(" ");
            cycle += 1;
            if (cycle % 40 == 20)
            {
               ret += x * cycle;
            }
            if (arr[0].equals("addx"))
            {
               cycle += 1;
               if (cycle % 40 == 20)
               {
                  ret += x * cycle;
               }
               x += Integer.parseInt(arr[1]);
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
