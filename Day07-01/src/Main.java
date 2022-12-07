import java.io.*;

public class Main
{
   public static class Node
   {
      public int mSize;
      public Node[] mChilds = new Node[40];
      public Node mParent;
      public int mNumChilds = 0;

      public Node(Node pParent, int pSize)
      {
         mParent = pParent;
         mSize = pSize;
      }
      public Node addChild(Node pChild)
      {
         mChilds[mNumChilds] = pChild;
         return mChilds[mNumChilds++];
      }

      public Node getParent()
      {
         return mParent;
      }

      public int countNode(Node pNode)
      {
         if (pNode.mNumChilds == 0)
         {
            return pNode.mSize;
         }
         int ret = 0;
         for (int i = pNode.mNumChilds ; i > 0; i--)
         {
            ret += pNode.countNode(pNode.mChilds[i - 1]);
         }
         return ret;
      }

      public Node getMother(Node pNode)
      {
         if (pNode.mParent == null)
         {
            return pNode;
         }
         return getMother(pNode.getParent());
      }
   }

   public static int fctRet(Node pNode)
   {
      if (pNode.mNumChilds == 0)
      {
         return 0;
      }
      int ret = 0;
      for (int i = pNode.mNumChilds ; i > 0; i--)
      {
         int tmp = pNode.countNode(pNode.mChilds[i - 1]);
         if (tmp > 100000)
         {
            if (pNode.mChilds[i - 1].mNumChilds != 0)
            {
               ret += tmp;
            }
         }
         ret += fctRet(pNode.mChilds[i - 1]);
      }
      return ret;
   }
   public static void main(String[] args)
   {
      try
      {
         File file = new File("/home/ajdvb/IdeaProjects/AdventOfCode/Day07-01/input.txt");
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);
         String line;
         int ret = 0;
         String path = "/";
         String[] cmd = new String[4];
         Node current = new Node(null, 0);
         Node parent = current;
         while((line = br.readLine()) != null)
         {
            cmd = line.split(" ");
            if (cmd[0].equals("$"))
            {
               if (cmd[1].equals("cd"))
               {
                  if (cmd[2].equals("/"))
                  {
                     continue;
                  }
                  else if (cmd[2].equals(".."))
                  {
                     current = current.getParent();
                     path = path.substring(0, path.lastIndexOf("/"));
                     path = path.substring(0, path.lastIndexOf("/") + 1);
                  }
                  else
                  {
                     path = path.concat(cmd[2] + "/");
                     Node tmp = new Node(current, 0);
                     current = current.addChild(tmp);
                  }
               }
            }
            else
            {
               if (cmd[0].equals("dir"))
               {
                  continue;
               }
               else
               {
                  Node tmp = new Node(current, Integer.parseInt(cmd[0]));
                  current.addChild(tmp);
               }
            }
         }
         current = current.getMother(current);
         ret += fctRet(current);
         System.out.println(ret);
      }
      catch (Exception e)
      {
         System.out.println(e);
         System.exit(1);
      }
   }
}