/************************************************************************************
 * 
 * java DepthFirstSearch tinyG.txt 0
 * 
 * Output:
 * 0 1 2 6 
 * NOT connected
 * 
 ***********************************************************************************/
package com.liwenwei.algs4.code;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * 寻找路径
 * 
 * @author liwenwei
 *
 */
public class DepthFirstPaths {

	private boolean[] marked;
	/**
	 * edgeTo[]整型数组起到Tremaux搜索中绳子的作用。这个数组可以找到从每个与s连通的顶点回到s的路径。
	 * 它会记住每个顶点到起点的路径，而不是记录当前顶点到起点的路径。在由边v-w第一次访问任意w时，将
	 * edgeTo[w]设为v来记住这条路径。换句话说，v-w是从s到w的路径上的最后一条已知的边。这样，搜索的
	 * 结果是一棵以起点为根结点的数，edgeTo[]是一棵由父连接表示的树
	 * <p>
	 * 0----------2
	 * | \     / /|
	 * |    1   / |
	 * |       /  |
	 * 5------3---4
	 * Output:
	 * edgeTo[]      0
	 * 0 |           |
	 * 1 | 2         2
	 * 2 | 0       /   \
	 * 3 | 2      1     3
	 * 4 | 3          /  \
	 * 5 | 3         4    5
	 */
	private int[] edgeTo;
	private final int s;
	
	// find paths in G from s
	public DepthFirstPaths(Graph G, int s) {
		this.s = s;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		validateVertex(s);
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				// 在由边v-w第一次访问任意w时，将edgeTo[w]设为v来记住这条路径
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}
	
	// is there a path from s to v
	public boolean hasPathTo(int v) {
		validateVertex(v);
		return marked[v];
	}
	
	// path from s to v
	// null if no such path
	public Iterable<Integer> pathTo(int v) {
		validateVertex(v);
		if (!hasPathTo(v)) return null;
		Stack<Integer> path =  new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s); // put the end vertex
		return path;
	}
	
	// throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
    
    public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		int s = Integer.parseInt(args[1]);
		DepthFirstPaths search = new DepthFirstPaths(G, s);
		for (int v = 0; v < G.V(); v++) {
			StdOut.print(s + " to " + v + ": ");
			if (search.hasPathTo(v)) {
				for (int x : search.pathTo(v)) {
					if (x == s) StdOut.print(x);
					else StdOut.print("-" + x);
				}
			}
			StdOut.println();
		}
	}
	
}
