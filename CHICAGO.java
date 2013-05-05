import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.LinkedList;

class CHICAGO {

	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] in_arr;
		int n, m; //n: number of nodes m: numbber of edges.
		boolean [] v;
		ArrayList <LinkedList <Node>> adj;

		while(true) {
			adj = new ArrayList <LinkedList <Node> > ();
			String in = br.readLine();

			if(in.equals("0"))
				break;

			in_arr = in.split(" ");
			n = Integer.parseInt(in_arr[0]);
			m = Integer.parseInt(in_arr[1]);

			/* Initialize the ArrayList */
			for(int i = 0; i < n; i++) {
				adj.add(new LinkedList <Node>());
			}

			/* Create the adjacency list */
			for(int i = 0; i < m; i++) {
				in_arr = br.readLine().split(" ");

				/* Nodes and edge value read in from stdin */
				int n1 = Integer.parseInt(in_arr[0]) - 1;
				int n2 = Integer.parseInt(in_arr[1]) - 1;
				double e  = Double.parseDouble(in_arr[2]) / 100;

				/* Insert the nodes in the corresponding adjacency lists */
				adj.get(n1).add(new Node(n2, e));
				adj.get(n2).add(new Node(n1, e));
			}

			/* Dijikstra */
			PriorityQueue <Node> pq = new PriorityQueue <Node> ();
			LinkedList <Node> tmp;
			v = new boolean [n];

			/* Add the start node to the PriorityQueue */
			pq.add(new Node(0,1));

			while(!pq.isEmpty()) {

				Node curr = pq.remove();

				int i = curr.index;
				double p = curr.prob;

				if(v[i])
					continue;

				v[i] = true;

				if(i == n - 1)
				{
					System.out.println(String.format("%.6f percent", p * 100));
					break;
				}

				tmp = adj.get(i);

				while(!tmp.isEmpty()) {
					curr = tmp.remove();
					pq.add(new Node(curr.index, curr.prob * p));
				}
			}
		}
	}
}

class Node implements Comparable <Node> {

	int index;
	double prob;

	public Node(int i, double p) {
		this.index = i;
		this.prob = p;
	}

	public int compareTo(Node n) {

		/* Higher probability has higher priority */
		if(this.prob == n.prob)
			return 0;
		else if(this.prob > n.prob)
			return -1;
		else 
			return 1;
	}

}