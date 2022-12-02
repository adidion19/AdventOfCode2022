import java.io.*;
import java.util.Arrays;

public class Main
{

   public static void main(String[] args)
   {
      try
      {
         File file = new File("/home/ajdvb/IdeaProjects/AdventOfCode/Day02-01/input.txt");
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);
         StringBuffer sb = new StringBuffer();
         String line;
         int x = 0;
         char c, d;
         while((line = br.readLine()) != null)
         {
            c = line.charAt(0);
            d = line.charAt(2);
            if (d == 'Y')
            {
               x += 3;
               if (c == 'A')
               {
                  x += 1;
               }
               else if (c == 'B')
               {
                  x += 2;
               }
               else
               {
                  x += 3;
               }
            }
            else if (d == 'Z')
            {
               x += 6;
               if (c == 'A')
               {
                  x += 2;
               }
               else if (c == 'B')
               {
                  x += 3;
               }
               else
               {
                  x += 1;
               }
            }
            else
            {
               if (c == 'A')
               {
                  x += 3;
               }
               else if (c == 'B')
               {
                  x += 1;
               }
               else
               {
                  x += 2;
               }
            }
         }
         System.out.println(x);
      }
      catch (Exception e)
      {
         System.out.println("An error has occurred\n");
         System.exit(1);
      }
   }
}