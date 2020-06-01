/**
 * 
 */
package com.solutions.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author ajain10
 * @param <T>
 *
 */
public class Graph<T> {

	Map<T, List<T>> adjList;
	int V;
	
	/**
	 * Problem 1: Adjacency List Implementation for Integer data
	 */
	int vertex;
	LinkedList<Integer> list[];
	
	
	public Graph(int vertex) {
		this.vertex = vertex;
		list = new LinkedList[vertex];
		adjList = new HashMap<>();
		
		for(int i=0;i<vertex;i++) {
			list[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int source, int destination, boolean bidirect) {
		list[source].addFirst(destination);
		
		if(bidirect) {
			list[destination].addFirst(source);
		}
	}
	
	public void printGraph() {
		for(int i=0; i<vertex;i++) {
			if(list[i].size()>0) {
				for(int j=0;j<list[i].size();j++) {
					System.out.println("Vertex " +i +" is connected to vertex "+list[i].get(j));
				}
			}
		}
	}
	
	
	/**
	 * Problem 2: Adjacency List Implementation for Generic Data
	 */
	
	
	public void addGenericEdge(T u, T v, boolean bidirect) {
		if(adjList.get(u) == null) {
			adjList.put(u, new LinkedList<T>());
		}
		adjList.get(u).add(v);
		if(bidirect) {
			if(adjList.get(v) == null) {
				adjList.put(v, new LinkedList<T>());
			}
			adjList.get(v).add(u);
		}
	}
	
	
	public void printGenericGraph() {
		for(Map.Entry<T, List<T>> entry: adjList.entrySet()) {
			System.out.print(entry.getKey() + "-->");
			for(T e: entry.getValue()) {
				System.out.print(e + ",");
			}
			System.out.println();
		}
	}
	/**
	 * 
	 * Problem 3: Breadth First Traversal (BFS)
	 */
	public void bfs(int src) {
		Queue<Integer> q = new LinkedList<Integer>();
		Map<Integer, Boolean> visited = new HashMap<>();
		
		q.add(src);
		visited.put(src, true);
		
		while(!q.isEmpty()) {
			int node = q.poll();
			System.out.println("Visted Node " +node);
			
			
			for(int neighbor: list[node]) {
				if(visited.get(neighbor) == null || visited.get(neighbor) == false) {
					q.add(neighbor);
					visited.put(neighbor, true);
				}
			}
		}
	}
	
	
	/**
	 * 
	 * Problem 4: Single Source Shortest Path. Starting from one node, compute shortest path to all other nodes
	 */
	public void singleSourceShortestPath(T src) {
		Queue<T> q = new LinkedList<>();
		Map<T, Integer> distance = new HashMap<>();
		Map<T, T> parent = new HashMap<>();
		Map<T, Boolean> visited = new HashMap<>();
		
		//Setting all distance to infinity initially
		for(Map.Entry<T, List<T>> entry: adjList.entrySet()) {
			distance.put(entry.getKey(), Integer.MAX_VALUE);
		}
		q.add(src);
		distance.put(src, 0);
		
		
		while(!q.isEmpty()) {
			T node = q.peek();
			System.out.println(node + " ");
			visited.put(node, true);
			q.poll();
			
			for(T neighbor : adjList.get(node)) {
				if(!visited.get(neighbor)) {
					q.add(neighbor);
					visited.put(neighbor, true);
					distance.put(neighbor, distance.get(node) + 1);
					parent.put(neighbor, node);
				}
			}
			
			//Print distance of all the nodes
			for(T n: adjList.keySet()) {
				System.out.println("Distance of "+n + "from" +src +"is " + distance.get(n));
			}
			
			
		}
		
	}
	
	
	
	/**
	 * 
	 * Problem 5: Snake and Ladder Problem using BFS-SSSP Algorithm
	 * Given 1 - N Snakes and Ladders Board, starting and ending points of all snakes and ladders.You have to find out the minimum 
	 * number of dice throws to win the same.  Each dice throws can have any number from 1 to 6
	 * It is an unweighted directed graph
	 */
	public void snakeAndLadder(Graph g, T src, T dest) {
		//Step 1: Store the Graph
		int board[] = new int[50];
		board[2] = 13;
		board[5] = 2;
		board[9] = 18;
		board[18] = 11;
		board[17] = -13;
		board[20] = -14;
		board[24] = -8;
		board[25] = -10;
		board[32] = -2;
		board[34] = -22;
		
		
		//Step 2: Construct the Graph, i.e. add pairs of u and v
		for(int u=0;u<=36;u++) {
			//At every node, we can throw a dice
			for(int dice = 1; dice <=6; dice++) {
				int v = u+dice+board[u+dice];
				g.addGenericEdge(u, v, false);
			}
		}
		
		//Step 3: Do BFS Traversal to find shortest path 
		Queue<T> q = new LinkedList<T>();
		Map<T, Integer> distance = new HashMap<T, Integer>();
		Map<T, T> parent = new HashMap<>();
		Map<T, Boolean> visited = new HashMap();
		
		
		//Setting all distance to infinity initially
		for(Map.Entry<T, List<T>> entry: adjList.entrySet()) {
			distance.put(entry.getKey(), Integer.MAX_VALUE);
		}
				
				
		q.add(src);
		distance.put(src, 0);
		visited.put(src, true);
		
		while(!q.isEmpty()) {
			T node = q.peek();
			q.poll();
			
			//For the neighbors of the current node, find out the nodes which are not visited
			for(T neighbour: adjList.get(node)) {
				if(!visited.get(neighbour)) {
					q.add(neighbour);
					visited.put(neighbour, true);
					distance.put(neighbour, distance.get(node)+1);
					parent.put(neighbour, node);
				}
			}
			
		//Step 4: Print the path from destination to src
		T temp = dest;
		while(temp!=src) {
			System.out.print(temp + "<-----" );
			temp = parent.get(temp);
		}
			
		}
	}
	
	
	
	public static void main(String[] args) {
		Graph graph = new Graph(5);
        graph.addEdge(0, 1, true);
        graph.addEdge(0, 4, true);
        graph.addEdge(1, 2, true);
        graph.addEdge(1, 3, true);
        graph.addEdge(1, 4, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(3, 4, true);
        graph.printGraph();
        graph.bfs(0);
        
        Graph g2 = new Graph(50);
        g2.snakeAndLadder(g2, 0, 36);

	}

}
