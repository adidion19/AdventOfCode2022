import java.io.*;
import java.util.Arrays;

public class Main
{
   public static void main(String[] args)
   {
      try
      {
         File file = new File("/home/ajdvb/IdeaProjects/AdventOfCode/Day01-02/input.txt");
         FileReader fr = new FileReader(file);
         BufferedReader br =new BufferedReader(fr);
         StringBuffer sb =new StringBuffer();
         String line;
         int empty = 0;
         while((line = br.readLine())!=null)
         {
            sb.append(line);
            sb.append("\n");
            if (line.trim().isEmpty())
            {
               empty++;
            }
         }
         String[] str = sb.toString().split("\n");
         int[] kcal = new int[empty];
         int i = 0;
         kcal[i] = 0;
         for (String s: str)
         {
            if (s.isEmpty())
            {
               if (i == empty - 1)
               {
                  break;
               }
               i++;
               kcal[i] = 0;
            }
            else
            {
               kcal[i] += Integer.parseInt(s);
            }
         }
         fr.close();
         int temp;
         i = 0;
         for(; i < empty; i++ )
         {
            for (int j = i + 1; j < empty; j++)
            {
               if (kcal[i] > kcal[j])
               {
                  temp = kcal[i];
                  kcal[i] = kcal[j];
                  kcal[j] = temp;
               }
            }
         }
         System.out.println(kcal[empty - 1] + kcal[empty - 2] + kcal[empty - 3]);
      }
      catch (Exception e)
      {
         System.out.println("An error has occurred\n");
         System.exit(1);
      }
   }
}