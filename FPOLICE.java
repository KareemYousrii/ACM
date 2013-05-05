import java.io.*;
import java.util.PriorityQueue;

class FPOLICE {

	public static void main(String[]args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [][] t; //Time associated with each station.
		int [][] r; //Risk associated wtih each station.
		int cases; //Number of test cases.
		String [] bounds; //The  array holding N and T.
		int n, max_time; //N and T.
		cases = Integer.parseInt(br.readLine()); //Number of test cases.
		boolean flag = false;

		for(int k = 0; k < cases; k++) {
			flag = false;
			bounds = (br.readLine()).split(" ");
			n = Integer.parseInt(bounds[0]);
			max_time = Integer.parseInt(bounds[1]);

			t = new int [n][n];
			r = new int [n][n];

			for(int i = 0; i < n; i++) {
				
				String [] row = br.readLine().split(" ");
				for(int j = 0; j < n; j++) {

					t[i][j] = Integer.parseInt(row[j]);

				}
			}

			for(int i = 0; i < n; i++) {
				
				String [] row = br.readLine().split(" ");
				for(int j = 0; j < n; j++) {

					r[i][j] = Integer.parseInt(row[j]);
				}
			}

			/* Dijikstra's algorithm */

			PriorityQueue <Node> adj = new PriorityQueue <Node> ();
			adj.add(new Node(0, 0, 0));

			while(!adj.isEmpty()) {

				Node c = (Node) adj.remove();

				if(c.i == n - 1 && c.time <= max_time) {

					System.out.println(c.risk + " " + c.time);
					flag = true;
					break;
				}

				for(int j = 0; j < n; j++) {

					int new_time = t[c.i][j] + c.time;

					if(c.i == j || new_time > max_time)
						continue;

					adj.add(new Node(j, r[c.i][j] + c.risk, new_time));
				}
			}

			if(!flag) {
				System.out.println(-1);
			}
		}
	}
}

class Node implements Comparable <Node> {

	int i;
	int risk;
	int time;

	public Node(int i, int risk, int time) {

		this.i = i;
		this.risk = risk;
		this.time = time;
	}

	public int compareTo(Node n) {

		if(risk == n.risk && time != n.time)
			return time - n.time;
		
		else if(risk == n.risk && time == n.time)
			return i - n.i;

		else 
			return risk - n.risk;
	}
}