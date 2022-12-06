import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main
{
   public static ArrayList<Stack<Character>> init(String [] pStrings)
   {
      ArrayList<Stack<Character>> pStacks = new ArrayList<>(9);
      String [] str = new String[40];
      for (int i = 0; i < 9; i++)
      {
         pStacks.add(new Stack<Character>());
      }
      for (int i = 7; i >= 0; i--)
      {
         str = pStrings[i].split(" ");
         for (int j = 0, k = 0; j < 9; j++)
         {
            if (str[k].isEmpty())
            {
               k+=4;
               continue;
            }
            pStacks.get(j).push(str[k].charAt(1));
            k++;
         }
      }

      return pStacks;
   }

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