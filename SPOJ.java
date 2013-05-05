import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Shop
{
    static final int INF = Integer.MAX_VALUE;
    static int d[][];
    static char m[][];
    static boolean v[][];

    /* What are these two lines? */
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {-1, 0, 1, 0};

    public static void main(String [] args) throws IOException
    {
        /* Reading the dimensions of the 2d array */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String wh[] = br.readLine().split(" ");
        int w = Integer.parseInt(wh[0]);
        int h = Integer.parseInt(wh[1]);

        /* Initializing the 2d arrays */
        d = new int[h][w];
        m = new char[h][w];
        v = new boolean[h][w];

        /* Start and destination coordinates */
        int xS = 0, yS = 0, xD = 0, yD = 0;

        /* Storing the values in a 2d array */ 
        for(int i = 0; i < h; i++)
        {
            String t = br.readLine();
            for(int j = 0; j < w; j++)
            {
                m[i][j] = t.charAt(j);
                if(m[i][j] == 'S')
                {
                    xS = i; yS = j;
                    d[i][j] = 0;
                }
                if(m[i][j] == 'D')
                {
                    xD = i; yD = j;
                    d[i][j] = 0;
                }
                if(m[i][j] == 'X')
                    d[i][j] = INF;
                else
                    d[i][j] = m[i][j] - '0';
            }
        }


        PriorityQueue<ShopN> pq = new PriorityQueue<ShopN>();
        
        /* Add the start point */
        pq.add(new ShopN(xS, yS, 0));
        while(!pq.isEmpty())
        {
            ShopN c = pq.remove();
            if(v[c.i][c.j]) continue;
            v[c.i][c.j] = true;
            if(m[c.i][c.j] == 'D')
                System.out.println(c.cost+ "SHIT!");
            for(int k = 0; k < 4; k++)
            {
                int nx = c.i + dx[k];
                int ny = c.j + dy[k];
                if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                pq.add(new ShopN(nx, ny, c.cost + d[nx][ny]));
            }
        }
    }
}
class ShopN implements Comparable<ShopN>
{
    int i, j, cost;
    public ShopN(int i, int j, int cost)
    {
        this.i = i;
        this.j = j;
        this.cost = cost;
    }
    public int compareTo(ShopN n)
    {
        return cost - n.cost;
    }
}