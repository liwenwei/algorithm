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

public class DepthFirstPaths {

	// find paths in G from s
	public DepthFirstPaths(Graph G, int s) {
		
	}
	
	private int dfs(Graph G, int v) {
		
	}
	
	// is there a path from s to v
	public boolean hasPathTo(int v) {
		
	}
	
	// path from s to v
	// null if no such path
	public Iterable<Integer> pathTo(int v) {
		
	}
	
	// throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
	
}
