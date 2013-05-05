import java.util.*;

public class Dijikstra {

	public static void main(String[]args) {

		ArrayList < PriorityQueue < Node > > adj = new ArrayList < PriorityQueue < Node > > ();
		boolean [] v = new boolean [5];

		for(int i = 0; i < 5; i++) {
			adj.add(new PriorityQueue <Node> ());
		}

		PriorityQueue <Node> tmp;
		
		tmp = adj.get(0);
		tmp.add(new Node(1, 10));
		tmp.add(new Node(2, 5));

		tmp = adj.get(1);
		tmp.add(new Node(2, 2));
		tmp.add(new Node(3, 1));

		tmp = adj.get(2);
		tmp.add(new Node(1, 3));
		tmp.add(new Node(3, 9));
		tmp.add(new Node(4, 2));

		tmp = adj.get(3);
		tmp.add(new Node(4, 4));

		tmp = adj.get(4);
		tmp.add(new Node(3, 6));
		tmp.add(new Node(0, 7));

		/* Dijikstra */

		PriorityQueue <Node> pq = new PriorityQueue <Node> ();
		
		/* Add the start node to the PriorityQueue */
		pq.add(new Node(0,0));

		while(!pq.isEmpty()) {

			Node curr = (Node)pq.remove();

			int i = curr.i;
			int w = curr.w;

			if(v[i])
				continue;

			v[i] = true;

			tmp = adj.get(i);

			while(!tmp.isEmpty()) {
				curr = (Node)tmp.remove();
				pq.add(new Node(curr.i, curr.w + w));
			}
			System.out.println("Node: " + i + " Cost: " + w);	
		}
	}
}

class Node implements Comparable <Node> {
	
	int i;
	int w;

	public Node(int i, int w) {
		this.i = i;
		this.w = w;
	}

	public int compareTo(Node n) {
		return this.w - n.w;
	}
}