import java.io.*;
import java.util.Arrays;

public class Main
{
   public static int incr(char pChar)
   {
      if (Character.isLowerCase(pChar))
      {
         return (Character.getNumericValue(pChar) - Character.getNumericValue('a') + 1);
      }
      else
      {
         return (Character.getNumericValue(pChar) - Character.getNumericValue('A') + 27);
      }
   }

   public static void main(String[] args)
   {
      try
      {
         File file = new File("/home/ajdvb/IdeaProjects/AdventOfCode/Day03-02/input.txt");
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);
         StringBuffer sb = new StringBuffer();
         String line, first = "", second = "", third = "";
         int ret = 0, count = 0;
         while((line = br.readLine()) != null)
         {
            if (count == 0)
            {
               first = line.substring(0, line.length());
            }
            else if (count == 1)
            {
               second = line.substring(0, line.length());
            }
            else
            {
               third = line.substring(0, line.length());
               String commonChars = first.replaceAll("[^"+second+"]","");
               commonChars = commonChars.replaceAll("[^"+third+"]","");
               ret += incr(commonChars.toCharArray()[0]);
               count = -1;
            }
            ++count;
         }
         System.out.println(ret);
     }
      catch (Exception e)
      {
         System.out.println("An error has occurred\n");
         System.exit(1);
      }
   }
}