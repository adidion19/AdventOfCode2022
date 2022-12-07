import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main
{

   public static void main(String[] args)
   {
      try
      {
         File file = new File("/home/ajdvb/IdeaProjects/AdventOfCode/Day06-02/input.txt");
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);
         String line;
         int j = 0, i = 4, b2o = 0;
         line = br.readLine();
         while (line.charAt(i) != '\0')
         {
            b2o = 0;
            for (int k = i - 2; k >= i - 14; k--)
            {
               for (int m = k + 1; m <= i ; m++)
               {
                  if (line.charAt(m) == line.charAt(k))
                  {
                     b2o = 1;
                     break;
                  }
                  if (m == i && k == i - 14)
                  {
                     b2o = 2;
                  }
               }
               if (b2o != 0)
               {
                  break ;
               }
            }
            if (b2o == 2)
            {
               break ;
            }
            i++;
         }
         System.out.println(i);
      }
      catch (Exception e)
      {
         System.out.println(e);
         System.exit(1);
      }
   }
}