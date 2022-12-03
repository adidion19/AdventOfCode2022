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
         File file = new File("/home/ajdvb/IdeaProjects/AdventOfCode/Day03-01/input.txt");
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);
         StringBuffer sb = new StringBuffer();
         String line, first, second;
         int ret = 0;
         while((line = br.readLine()) != null)
         {
            first = line.substring(0, line.length() / 2);
            second = line.substring(line.length() / 2, line.length());
            String commonChars = first.replaceAll("[^"+second+"]","");
            ret += incr(commonChars.toCharArray()[0]);
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