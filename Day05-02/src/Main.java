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
         File file = new File("/home/ajdvb/IdeaProjects/AdventOfCode/Day05-02/input.txt");
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);
         String line;
         int j = 0;
         String ret = "";
         String [] str = new String[3], parse = new String[10];
         while((line = br.readLine()) != null)
         {
            if (j < 9)
            {
               parse[j] = line;
               j++;
               continue;
            }
            break;
         }
         ArrayList<Stack<Character>> stack = init(parse);
         while((line = br.readLine()) != null)
         {
            line = line.replaceAll("[^\\d]", " ");
            line = line.trim();
            line = line.replaceAll(" +", " ");
            str = line.split(" ");
            int [] arr = new int [3];
            Stack<Character> tmp = new Stack<>();
            for (int i = 0; i < 3; i++)
            {
               arr[i] = Integer.parseInt(str[i]);
            }
            for (int i = arr[0] ; i > 0; i--)
            {
               tmp.push(stack.get(arr[1] - 1).pop());
            }
            for (;arr[0] > 0;arr[0]--)
            {
               stack.get(arr[2] - 1).push(tmp.pop());
            }

         }
         for (int i = 0 ; i < 9 ; i++)
         {
            ret += stack.get(i).pop();
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