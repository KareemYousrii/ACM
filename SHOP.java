	import java.io.*;
	import java.util.PriorityQueue;

	class SHOP {

		public static void main(String[]args) throws IOException {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PriorityQueue <Node> adj; //The list of nodes.
			int[][] grid;
			boolean [][] v;
			String [] dimensions;
			int w,h;
			int inf = Integer.MAX_VALUE;
			String temp_str; 
			char temp_char;
			int Sx = 0, Sy = 0;
			int Dx = 0, Dy = 0;
			int [] dx = {0, 1, 0, -1};
			int [] dy = {-1, 0, 1, 0};

			while(true)
			{
				/* Read the dimensions from the input stream */
				dimensions = br.readLine().split(" ");
				w = Integer.parseInt(dimensions[0]);
				h = Integer.parseInt(dimensions[1]);

				if(w == 0 && h == 0)
					return;

				/* Initialize the grid */
				grid = new int[h][w];
				v = new boolean[h][w];

				for(int i = 0; i < h; i++) {
					
					temp_str = br.readLine();
					for(int j = 0; j < w; j++) {

						temp_char = temp_str.charAt(j);
						if(temp_char == 'X')
							grid[i][j] = inf;

						else if(temp_char == 'S') {

							grid[i][j] = 0;
							Sx = i;
							Sy = j;
						}
							
						else if(temp_char == 'D') {

							grid[i][j] = 0;
							Dx = i;
							Dy = j;
						}

						else
							grid[i][j] = temp_char - '0';
					}
				}
				/* Dijikstra's Algorithm */

				adj = new PriorityQueue <Node> ();

				adj.add(new Node(Sx, Sy, 0));

				while(!adj.isEmpty()) {

					/* Pop the head of the priority queue */
					Node n = adj.remove();

					if(v[n.i][n.j]) {
						continue;
					}

					v[n.i][n.j] = true;

					if(Dx == n.i && Dy == n.j) { //Found D

						System.out.println(n.cost);
					}

					for(int i = 0; i < 4; i++) {

						int new_i = n.i + dx[i];
						int new_j = n.j + dy[i];

						if(new_i < 0 || new_i >= h || new_j < 0 || new_j >= w) continue;
						adj.add(new Node(new_i, new_j, (grid[new_i][new_j] + n.cost)));
					}
				}
				br.readLine();
			}
		}
	}

	class Node implements Comparable<Node> {
		
		int i,j;
		int cost;

		public Node(int i, int j, int cost) {
			
			this.i = i;
			this.j = j;
			this.cost = cost;
		}

		public int compareTo(Node n) {
			return cost - n.cost;
		}
	}





