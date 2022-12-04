import java.io.*;
import java.util.Arrays;

public class Main
{
   public static int incr(int [] x)
   {
      if (x[2] >= x[0] && x[2] <= x[1] || x[3] >= x[0] && x[3] <= x[1])
      {
         return 1;
      }
      if (x[0] >= x[2] && x[0] <= x[3] || x[1] >= x[2] && x[1] <= x[3])
      {
         return 1;
      }
      return 0;
   }

   public static void main(String[] args)
   {
      try
      {
         File file = new File("/home/ajdvb/IdeaProjects/AdventOfCode/Day04-02/input.txt");
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);
         StringBuffer sb = new StringBuffer();
         String line;
         int ret = 0, i;
         while((line = br.readLine()) != null)
         {
            i = 0;
            String[] str = line.split("[,-]");
            int [] x = new int[4];
            for (String s: str)
            {
               if (!s.isEmpty())
               {
                  x[i] = Integer.parseInt(s);
               }
               ++i;
            }
            ret += incr(x);
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