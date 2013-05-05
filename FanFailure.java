import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
 
public class FanFailure {
  private static final boolean DEBUG = false;
 
  public static int[] getRange(int[] capacities, int minCooling) {
    Arrays.sort( capacities );
    int size = 0;
    int remaining = 0;
    int remaining2 = 0;

    /* Sum up the capacities of the fans */
    for (int i = 0; i < capacities.length; i++) {
      remaining += capacities[i];
    }

    System.out.println("System fans capacity: " + remaining);

    /* Calculte the MFS */
    remaining2 = remaining;
    while (remaining >= minCooling && size < capacities.length) {
      remaining -= capacities[ size++ ];
    }

    System.out.println("remaining: " + remaining);
    
    int size2 = capacities.length - 1;
    while (remaining2 >= minCooling && size2 >= 0) {
      remaining2 -= capacities[size2--];
    }
    size2 = capacities.length - 1 - size2;
    int[] ans = { size - 1, size2 - 1};
    return ans;
  }
 
  /** begin cut - don't modify this line*/
  public static void main(String[] a) {
  	int [] capacities = {676, 11, 223, 413, 823, 122, 547, 187, 28};
  	int minCooling = 1000;
  	int [] res = getRange(capacities, minCooling);
  	System.out.println(res[0] + " " + res[1]);
  }
}
