/************************************************************************************
 * 
 *  % java Graph tinyG.txt
 *  13 vertices, 13 edges 
 *  0: 6 2 1 5 
 *  1: 0 
 *  2: 0 
 *  3: 5 4 
 *  4: 5 6 3 
 *  5: 3 4 0 
 *  6: 0 4 
 *  7: 8 
 *  8: 7 
 *  9: 11 10 12 
 *  10: 9 
 *  11: 9 12 
 *  12: 11 9 
 * 
 ***********************************************************************************/
package com.liwenwei.algs4.code;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 无向图(Graph)
 * <p>
 * 用哪种数据结构来实现图，包含以下两个要求：
 * - 它必须为可能在应用中碰到的各类的图预留出足够的空间
 * - Graph的实例方法的实现一定要快——他们是开发处理图的各种用例的基础
 * <p>
 * 这些要求比较模糊，单他们仍然能够帮助我们再三种图的表示方法中进行选择
 * - 邻接矩阵。我们使用一个V乘V的布尔矩阵，当顶点v和顶点w之间有相邻的边时，定义v行w列的元素值为true，
 * 否则为false。这种表示方法不合符第一个条件——含有上百万个顶点的图是很常见的，V^2个布尔值需要的空间
 * 是不能满足的。
 * - 边的数组。定义个edge类，含有两个int实例变量。这种表示方法很简洁但不满足第二个条件——要实现adj()
 * 需要检查图中的所有边
 * - 邻接表数组（类似HashMap的结构）。我们使用一个顶点为索引的列表数组，其中每个元素都是和该顶点相邻的顶点列表
 * adj[0] -> [6, 2, 1, 5]
 * adj[1] -> [5, 4]
 * adj[2] -> [0]
 * ...
 * 
 * @author liwenwei
 *
 */
public class Graph {
	private static final String NEWLINE = System.getProperty("line.separator");
	
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	
	public Graph(int V) {
		if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}
	
	public Graph(In in) {
		try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            adj = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Integer>();
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                validateVertex(v);
                validateVertex(w);
                addEdge(v, w); 
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
	}
	
	public Graph(Graph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }
	
	/**
	 * 顶点数
	 * 
	 * @return int 顶点数
	 */
	public int V() {
		return V;
	}
	
	/**
	 * 边数
	 * 
	 * @return int 边数
	 */
	public int E() {
		return E;
	}
	
	// throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
	
	/**
	 * 向图中添加一条边v-w
	 * 
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		E++;
		adj[v].add(w);
		adj[w].add(v);
	}
	
	/**
	 * 和v相邻的所有顶点
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}
	
	/**
	 * 计算v的度数
	 * 
	 * @param v Vertex v
	 * @return
	 */
	public int degree(int v) {
		validateVertex(v);
		return adj[v].size();
	}
	
	/**
	 * 计算所有顶点的最大度数
	 * 
	 * @return
	 */
	public int maxDegree() {
		int max = 0;
		for (int v = 0; v < V; v++) {
			int val = degree(v);
			if (val > max)
				max = val;
		}
		return max;
	}
	
	/**
	 * 计算所有顶点的平均度数
	 * 
	 * 假设有个V个节点，E个边：由于没两个相连节点公用一个边，所以所有的节点的总度数为2E， 平均度数为2E/V
	 * 
	 * @return
	 */
	public double avgDegree() {
		return 2 * E() / V();
	}
	
	/**
	 * 计算自环的个数
	 * 
	 * 自环，一种特殊的图，即一条连接一个顶点和其自身的边
	 * 
	 * @return
	 */
	public int numberOfSelfLoops() {
		int count = 0;
		for (int v = 0; v <	V(); v++) {
			for (int w : adj(v))
				// 如果当前顶点和相邻顶点相等，则为自环
				if (v == w) count++;
		}
		return count / 2; // 每条边都被标记过两次
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
	}
	
	public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);
    }
	
}
