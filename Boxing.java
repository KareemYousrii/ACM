class Boxing
{
    public static int maxCredit(int[] a, int[] b, int[] c, int[] d, int[] e)
    {
        final int count = 5;
        int[][] hits = new int [count][];
        int[] judges = new int [count]; //Whether the hit has been registered by the judge.
        int[] pos = new int [count];
        int result = 0;

        hits [0] = a; hits[1] = b; hits[2] = c; hits[3] = d; hits[4] = e;

        for(int i = 0; i < count; i++){
            judges[i] = -1;
            pos[i] = 0;
        }

        for(int i = 0; i <= 180000; i++)
        {
            for(int j = 0; j < count; j++)
            {
                if(pos[j] >= hits[j].length) 
                    continue;
                
                if(hits[j][pos[j]] <= i)
                {
                    judges[j] = hits[j][pos[j]]; //The hit has been registered by the judge.
                    pos[j]++;          
                }
            }

            int num = 0;
            for(int j = 0; j < count; j++)
            {
                if(judges[j] == -1)
                    continue;
                
                if(i - judges[j] <= 1000)
                    num++;
            }

            if(num >= 3)
            {
                result++;
                for(int j = 0; j < count; j++)
                    judges[j] = -1;
            }
        }

        return result;
    }
    public static void main(String[] args)
    {
        int[] a = {180000};
        int[] b = {1, 2, 3, 4, 5, 6, 179000, 179500, 179800};
        int[] c = {5, 10, 1000, 10000};
        int[] d = {5, 10, 1000, 10000};
        int[] e = {6, 9000};

        System.out.println(maxCredit(a, b, c, d, e));
    }
}