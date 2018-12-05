package com.liwenwei.algs4.code;

public class BST<Key extends Comparable<Key>, Value> {
	
	private Node root;
	private class Node {
		private Key key;          // 键
		private Value val;        // 值
		private Node left, right; // 指向子树的链接
		private int N;            // 以该结点为根的字数中的结点总数
		
		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N= N;
		}
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
		if (x == null) {
			return 0;
		} else {
			return x.N;
		}
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public Value get(Key key) {
		return get(root, key);
	}
	
	private Value get(Node x, Key key) {
		if (x == null) {
			return null;
		}
		
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return get(x.left, key);
		} else if (cmp > 0) {
			return get(x.right, key);
		} else {
			return x.val;
		} 
	}
	
	private void put(Key key, Value val) {
		if (key == null ) {
			return;
		}
		
		if (val == null) {
			// delete
		}
		put(root, key, val);
	}
	
	private Node put(Node x, Key key, Value val) {
		if (x == null) {
			return new Node(key, val, 1);
		}
		
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(x.left, key, val);
		} else if (cmp > 0) {
			x.right = put(x.right, key, val);
		} else {
			x.val = val;
		}
		
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Key min() {
		if (isEmpty()) {
			return null;
		}
		
		return min(root).key;
	}
	
	private Node min(Node x) {		
		if (x.left == null) {
			return x;
		} else {
			return min(x.left);
		}
	}
	
	public Key max() {
		if (isEmpty()) {
			return null;
		}
		
		return max(root).key;
	}
	
	private Node max(Node x) {		
		if (x.right == null) {
			return x;
		} else {
			return min(x.right);
		}
	}
	
	public static void main(String[] args) { 
        BST<String, Integer> st = new BST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            if ((st.size() > 1) && (st.floor(key) != st.floor2(key)))
                throw new RuntimeException("floor() function inconsistent");
            st.put(key, i);
        }

        for (String s : st.levelOrder())
            StdOut.println(s + " " + st.get(s));

        StdOut.println();

        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
