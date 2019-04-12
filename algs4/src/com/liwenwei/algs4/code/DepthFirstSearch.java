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
 * Depth First Search(DFS)，一个典型的递归方法去遍历每个顶点和边。
 * <p>
 * 在访问顶点时：
 * 1. 标记为已经访问
 * 2. 访问该顶点没有被访问过的邻接顶点
 * <p>
 * 通过深度优先遍历能解决什么问题？
 * 1. 连通性。给定一幅图，回答“两个给定的顶点是否连通？”或者“图中有多少个连通子图”
 * 两个给定的顶点是否连通？等价于两个给定的顶点之间是否存在一条路径，也可以称之为路径检测问题
 * 2. 单点路径。给定一幅图和一个起点s，回答“从s到给定目的顶点v是否存在一条路径？如果有，找出这
 * 条路径。”等类似的问题
 * 
 * @author liwenwei
 *
 */
public class DepthFirstSearch {

	private boolean[] marked;
	private int count;
	
	// Find vertices connected to a source vertex s
	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		validateVertex(s);
		count = 0;
		dfs(G, s);
	}
	
	// depth first search from vertex v
	private void dfs(Graph G, int v) {
		count++;
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked(w))
				dfs(G, w);
		}
	}
	
	// Is v connected to s?
	public boolean marked(int v) {
		validateVertex(v);
		return marked[v];
	}
	
	// How many vertices are connected to s?
	public int count() {
		return count;
	}
	
	// throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
    
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);
        DepthFirstSearch search = new DepthFirstSearch(G, s);
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v))
                StdOut.print(v + " ");
        }

        StdOut.println();
        if (search.count() != G.V()) StdOut.println("NOT connected");
        else                         StdOut.println("connected");
    }
}
