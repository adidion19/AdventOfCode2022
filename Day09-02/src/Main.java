import java.io.*;
import java.util.ArrayList;

public class Main
{

   public static void moveLeft(int [] i1, int [] j1, int j, int [] size)
   {
      if (size[0] == j )
      {
         j1[j+1] = 1500;
         i1[j+1] = 1500;
         return ;
      }
      if (j == 0 || (!(i1[j] != i1[j + 1] && j1[j] + 2 == j1[j+1]) && !(i1[j] == i1[j+1] && j1[j] + 2 == j1[j+1])))
      {
         j1[j]--;
      }
      if (i1[j] != i1[j + 1] && j1[j] + 2 == j1[j+1])
      {
         if (i1[j] > i1[j+1])
         {
            i1[j+1]++;
         }
         else
         {
            i1[j+1]--;
         }
      }
      if (i1[j] == i1[j+1] && j1[j] + 2 == j1[j+1])
      {
         j1[j+1]--;
      }
   }

   public static void moveRight(int [] i1, int [] j1, int j, int [] size)
   {

      if (size[0] == j + 1)
      {
         System.out.println(size[0]);
         j1[j+1] = 1500;
         i1[j+1] = 1500;
//         return;
      }
      System.out.println(j1[j]);
      System.out.println(j1[j+1]);
      if (j == 0 || (!(i1[j] != i1[j + 1] && j1[j] - 2 == j1[j+1]) && !((i1[j] == i1[j+1] && j1[j] - 2 == j1[j+1]))))
      {
         j1[j]++;
      }
      if (i1[j] != i1[j + 1] && j1[j] - 2 == j1[j+1])
      {
         if (i1[j] > i1[j+1])
         {
            i1[j+1]++;
         }
         else
         {
            i1[j+1]--;
         }
         if (i1[j] == i1[j+1] && j1[j] - 2 == j1[j+1])
         {
            j1[j+1]++;
         }
      }
      else if (i1[j] == i1[j+1] && j1[j] - 2 == j1[j+1])
      {
         j1[j+1]++;
      }
   }

   public static void moveUp(int [] i1, int [] j1, int j, int [] size)
   {
      if (size[0] == j + 1)
      {
         System.out.println(size[0]);
         j1[j+1] = 1500;
         i1[j+1] = 1500;
//         return;
      }

      if (j == 0 || (!(j1[j] != j1[j + 1] && i1[j] + 2 == i1[j+1]) && !(j1[j] == j1[j+1] && i1[j] + 2 == i1[j+1])))
      {
         i1[j]--;
      }
      if (j1[j] != j1[j + 1] && i1[j] + 2 == i1[j+1])
      {
         if (j1[j] > j1[j+1])
         {
            j1[j+1]++;
         }
         else
         {
            j1[j+1]--;
         }
         if (j1[j] == j1[j+1] && i1[j] + 2 == i1[j+1])
         {
            i1[j+1]--;
         }
      }
      else if (j1[j] == j1[j+1] && i1[j] + 2 == i1[j+1])
      {
         i1[j+1]--;
      }
   }

   public static void moveDown(int [] i1, int [] j1, int j, int [] size)
   {
      if (size[0] == j)
      {
         j1[j+1] = 1500;
         i1[j+1] = 1500;
         return ;
      }
      if (j == 0 || (!(j1[j] != j1[j + 1] && i1[j] - 2 == i1[j+1]) && !(j1[j] == j1[j+1] && i1[j] - 2 == i1[j+1])))
      {
         i1[j]++;
      }
      if (j1[j] != j1[j + 1] && i1[j] - 2 == i1[j+1])
      {
         if (j1[j] > j1[j+1])
         {
            j1[j+1]++;
         }
         else
         {
            j1[j+1]--;
         }
         if (j1[j] == j1[j+1] && i1[j] - 2 == i1[j+1])
         {
            i1[j+1]++;
         }
      }
      else if (j1[j] == j1[j+1] && i1[j] - 2 == i1[j+1])
      {
         i1[j+1]++;
      }
   }

   public static void main(String[] args)
   {
      try
      {
         File file = new File("/home/ajdvb/IdeaProjects/AdventOfCode/Day09-02/input.txt");
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
         int []num = new int[1];
         num[0] = -1;
         int [] i1 = new int[10], j1 = new int[10];
         i1[0] = 1500;
         j1[0] = 1500;
         while((line = br.readLine()) != null)
         {
            System.out.println(line);
            if (line.charAt(0) == 'L')
            {
               for (int i = 0; i < Integer.parseInt(line.substring(2)); i++)
               {
                  for (int j = 0; j != (++num[0] > 9 ? 9 : num[0]); j++)
                  {
                     moveLeft(i1, j1, j, num);
                  }
                  System.out.println(j1[9]);
                  arr.get(i1[9])[j1[9]] = new Character('#');
               }
            }
            if (line.charAt(0) == 'R')
            {
               for (int i = 0; i < Integer.parseInt(line.substring(2)); i++)
               {
                  for (int j = 0; j != (++num[0] > 9 ? 9 : num[0]); j++)
                  {
                     moveRight(i1, j1, j, num);
                  }
                  arr.get(i1[9])[j1[9]] = new Character('#');
               }
            }
            if (line.charAt(0) == 'U')
            {
               for (int i = 0; i < Integer.parseInt(line.substring(2)); i++)
               {
                  for (int j = 0; j != (++num[0] > 9 ? 9 : num[0]); j++)
                  {
                     moveUp(i1, j1, j, num);
                  }
                  arr.get(i1[9])[j1[9]] = new Character('#');
               }
            }
            if (line.charAt(0) == 'D')
            {
               for (int i = 0; i < Integer.parseInt(line.substring(2)); i++)
               {
                  for (int j = 0; j != (++num[0] > 9 ? 9 : num[0]); j++)
                  {
                     moveDown(i1, j1, j, num);
                  }
                  arr.get(i1[9])[j1[9]] = new Character('#');
               }
            }
         }
         for (int j = 0; j != 3000; j++)
         {
            for (int i = 0; i != 3000 ; i++)
            {
               if (arr.get(i)[j] == '#')
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