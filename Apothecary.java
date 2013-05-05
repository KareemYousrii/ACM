import java.util.*;

public class Apothecary {

  public static int[] balance(int W)
  {
      ArrayList <Integer> a = new ArrayList();
      int res = W;

      while(res != 0)
      {
         a.add(res % 3);
         res /= 3;
      }

      a.add(0);

      int[] x = new int [a.size()];
      int[] y = new int [a.size()];
      int temp;
      int nxt;

      for(int i = 0; i < a.size(); i++)
      {
         temp = a.get(i);

         if(temp == 0)
         {
            x[i] = 0;
            y[i] = 0;
         }

         else if(temp == 1)
         {
            x[i] = 0;
            y[i] = 1;
         }

         else if(temp == 2)
         {
            nxt = a.get(i+1);
            x[i] = 1;
            y[i] = 0;
            a.set(i + 1, nxt + 1);
         } 
         else if(temp == 3)
         {
            nxt = a.get(i+1);
            x[i] = 0;
            y[i] = 0;
            a.set(i + 1, nxt + 1);
         }
      }

      for(int j = 0; j < a.size(); j++)
      {
         if(y[j] == 1)
            System.out.println(Math.pow(3,j));

         else if(x[j] == 1)
            System.out.println(-Math.pow(3,j));
      }

      return new int [10];
  }

  public static void main(String[] args)
  {   
      balance(1000000);
  }
}