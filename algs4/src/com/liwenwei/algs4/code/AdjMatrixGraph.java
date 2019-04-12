package com.liwenwei.algs4.code;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 
 * A graph, implement using an adjacency matrix(邻接矩阵).
 * Parallel edges are disallowed; self-loops are allowed
 * 
 * @author liwenwei
 *
 */
public class AdjMatrixGraph {
	private static final String NEWLINE = System.getProperty("line.separator");
	
	private final int V;
	private int E;
	private boolean[][] adj;
	
	// create a V-vertex graph with no edges
	public AdjMatrixGraph(int V) {
		if (V < 0) throw new IllegalArgumentException("Too few vertices");
		this.V = V;
		this.E = 0;
		adj = new boolean[V][V];
	}
	
	// random graph with V vertices and E edges
	// 假设Graph有V个顶点，最多有多少Edges？每个顶点都可以连接其他顶点也就是V-1个边，
	// 一共有V个顶点，去除重复的顶点，一共有V(V-1)/2个边
	public AdjMatrixGraph(int V, int E) {
		this(V);
		if (E > (long)V * (V - 1) / 2) throw new IllegalArgumentException("Too many edges");
		if (E < (long)V * (V - 1) / 2) throw new IllegalArgumentException("Too few edges");
		
		while (this.E != E) {
			int v = StdRandom.uniform(V);
			int w = StdRandom.uniform(V);
			addEdge(v, w);
		}
	}
	
	// number of vertices
	public int V() {
		return V;
	}
	
	// number of edges
	public int E() {
		return E;
	}
	
	// add edge v-w to this graph
	public void addEdge(int v, int w) {
		if (!adj[v][w]) E++;
		adj[v][w] = true;
		adj[w][v] = true;
	}
	
	// vertices adjacent to v
	public Iterable<Integer> adj(int v) {
		return new AdjIterator(v);
	}
	
	private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
		private int v;
        private int w = 0;
        
        public AdjIterator(int v) {
        	this.v = v;
		}
		
        @Override
		public Iterator<Integer> iterator() {
			return this;
		}
        
        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w]) return true;
                w++;
            }
            return false;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }
		
	}
	
	// string representation
	public String toString() {
		StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj(v)) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
	}
	
	public static void main(String[] args) {
        int V = Integer.parseInt(args[0]);
        int E = Integer.parseInt(args[1]);
        AdjMatrixGraph G = new AdjMatrixGraph(V, E);
        StdOut.println(G);
    }
}
