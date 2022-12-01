import java.io.*;
import java.util.Arrays;

public class Main
{
   public static void main(String[] args)
   {
      try
      {
         File file= new File("/home/ajdvb/IdeaProjects/AdventOfCode/Day01-01/input.txt");
         FileReader fr= new FileReader(file);
         BufferedReader br=new BufferedReader(fr);
         StringBuffer sb=new StringBuffer();
         String line;
         int empty = 0;
         while((line=br.readLine())!=null)
         {
            sb.append(line);
            sb.append("\n");
            if (line.trim().isEmpty()) {
               empty++;
            }
         }
         String[] str = sb.toString().split("\n");
         int [] kcal = new int[empty];
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
         System.out.println(Arrays.stream(kcal).max().getAsInt());
      }
      catch (Exception e)
      {
         System.out.println("An error has occurred\n");
         System.exit(1);
      }
   }
}