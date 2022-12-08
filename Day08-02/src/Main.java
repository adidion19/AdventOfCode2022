import java.io.*;
import java.lang.reflect.Array;
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
         File file = new File("/home/ajdvb/IdeaProjects/AdventOfCode/Day08-01/input.txt");
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);
         String line;
         int j = 0, m = 0, ret = 0;
         ArrayList<Integer[]> arr = new ArrayList<>();
         while((line = br.readLine()) != null)
         {
            arr.add(new Integer[line.length()]);
            for (int i = 0; i < line.length(); i++)
            {
               arr.get(j)[i] = line.charAt(i) - '0';
               m = i;
            }
            j++;
         }
         boolean seen;
         int k = j, val, midval, mult;
         j = 0;

         for (; j != k; j++)
         {
            for (int i = 0; i != m + 1; i++)
            {
               midval = mult = 1;
               val = arr.get(j)[i];
               for (int n = j - 1; n > 0; n--)
               {
                  if (arr.get(n)[i] < val)
                  {
                     mult += 1;
                  }
                  else
                  {
                     break ;
                  }
               }
               val = arr.get(j)[i];
               for (int n = j + 1 ; n < k - 1; n++)
               {
                  if (arr.get(n)[i] < val)
                  {
                     midval += 1;
                  }
                  else
                  {
                     break ;
                  }
               }
               mult *= midval;
               midval = 1;
               val = arr.get(j)[i];
               for (int n = i - 1  ; n > 0; n--)
               {
                  if (arr.get(j)[n] < val)
                  {
                     midval += 1;
                  }
                  else
                  {
                     break ;
                  }
               }
               mult *= midval;
               midval = 1;
               val = arr.get(j)[i];
               for (int n = i + 1; n < m; n++)
               {
                  if (arr.get(j)[n] < val)
                  {
                     midval += 1;
                  }
                  else
                  {
                     break;
                  }
               }
               mult *= midval;
               midval = 1;
               if (ret < mult)
               {
                  ret = mult;
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