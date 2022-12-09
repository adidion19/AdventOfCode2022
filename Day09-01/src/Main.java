import java.io.*;
import java.util.ArrayList;

public class Main
{

   public static void main(String[] args)
   {
      try
      {
         File file = new File("/home/ajdvb/IdeaProjects/AdventOfCode/Day09-01/input.txt");
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);
         String line;
         int ret = 0;
         ArrayList<Character[]> arr = new ArrayList<>();
         for (int j = 0; j != 3000; j++)
         {
            arr.add(new Character[3000]);
            for (int i = 0; i != 3000 ; i++)
            {
               arr.get(j)[i] = new Character('.');
            }
         }
         int i1 = 1500, j1 = 1500;
         int i2 = 1500, j2 = 1499;
         while((line = br.readLine()) != null)
         {
            if (line.charAt(0) == 'L')
            {
               for (int i = 0; i < Integer.parseInt(line.substring(2)); i++)
               {
                  j1--;
                  if (i1 != i2 && j1 + 2 == j2)
                  {
                     if (i1 > i2)
                     {
                        i2++;
                     }
                     else
                     {
                        i2--;
                     }
                  }
                  if (i1 == i2 && j1 + 2 == j2)
                  {
                     j2--;
                  }

                  arr.get(i2)[j2] = new Character('#');
               }
            }
            if (line.charAt(0) == 'R')
            {
               for (int i = 0; i < Integer.parseInt(line.substring(2)); i++)
               {
                  j1++;
                  if (i1 != i2 && j1 - 2 == j2)
                  {
                     if (i1 > i2)
                     {
                        i2++;
                     }
                     else
                     {
                        i2--;
                     }
                  }
                  if (i1 == i2 && j1 - 2 == j2)
                  {
                     j2++;
                  }
                  arr.get(i2)[j2] = new Character('#');
               }
            }
            if (line.charAt(0) == 'U')
            {
               for (int i = 0; i < Integer.parseInt(line.substring(2)); i++)
               {
                  i1--;
                  if (j1 != j2 && i1 + 2 == i2)
                  {
                     if (j1 > j2)
                     {
                        j2++;
                     }
                     else
                     {
                        j2--;
                     }
                  }
                  if (j1 == j2 && i1 + 2 == i2)
                  {
                     i2--;
                  }
                  arr.get(i2)[j2] = new Character('#');
               }
            }
            if (line.charAt(0) == 'D')
            {
               for (int i = 0; i < Integer.parseInt(line.substring(2)) ; i++)
               {
                  i1++;
                  if (j1 != j2 && i1 - 2 == i2)
                  {
                     if (j1 > j2)
                     {
                        j2++;
                     }
                     else
                     {
                        j2--;
                     }
                  }
                  if (j1 == j2 && i1 - 2 == i2)
                  {
                     i2++;
                  }
                  arr.get(i2)[j2] = new Character('#');
               }
            }
         }
         for (int j = 0; j != 3000; j++)
         {
            for (int i = 0; i != 3000 ; i++)
            {
               if (arr.get(j)[i] == '#')
               {
                  ret++;
               }
            }
         }
         System.out.println(ret);
      }
      catch (Exception e)
      {
         System.out.println(e);
         System.exit(1);
      }
   }
}