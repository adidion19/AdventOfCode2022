import java.io.*;
import java.util.Arrays;

public class Main
{
   public static int incr(char pChar)
   {
      if (pChar == 'X')
      {
         return 1;
      }
      if (pChar == 'Y')
      {
         return 2;
      }
      return 3;
   }

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
            x += incr(d);
            if (c == 'A')
            {
               if (d == 'X')
               {
                  x += 3;
               }
               else if (d == 'Y')
               {
                  x += 6;
               }
            }
            else if (c == 'B')
            {
               if (d == 'Z')
               {
                  x += 6;
               }
               else if (d == 'Y')
               {
                  x += 3;
               }
            }
            else
            {
               if (d == 'Z')
               {
                  x += 3;
               }
               else if (d == 'X')
               {
                  x += 6;
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