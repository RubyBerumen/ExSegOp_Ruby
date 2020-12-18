/*
 * Dijkstra’s shortest path algorithm in Java using PriorityQueue - GeeksforGeeks. (2018, December 11). 
 * GeeksforGeeks. https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/
 */

// Java implementation of Dijkstra's Algorithm  
// using Priority Queue 
import java.util.*; 
public class DIJKSTRA { 
    

	private int dist[]; 
    private Set<Integer> settled; 
    private PriorityQueue<Node> pq; 
    private int V; 
    List<List<Node> > adj; 
  
    public DIJKSTRA(int V) 
    { 
        this.V = V; 
        dist = new int[V]; 
        settled = new HashSet<Integer>(); 
        pq = new PriorityQueue<Node>(V, new Node()); 
    } 
  
    public void dijkstra(List<List<Node> > adj, int src) 
    { 
        this.adj = adj; 
  
        for (int i = 0; i < V; i++) 
            dist[i] = Integer.MAX_VALUE; 
  
        pq.add(new Node(src, 0)); 
  
        dist[src] = 0; 
        while (settled.size() != V) { 
  
            int u = pq.remove().node; 
  
            settled.add(u); 
  
            e_Neighbours(u); 
        } 
    } 
  
    private void e_Neighbours(int u) 
    { 
        int edgeDistance = -1; 
        int newDistance = -1; 
  
        for (int i = 0; i < adj.get(u).size(); i++) { 
            Node v = adj.get(u).get(i); 
  
            if (!settled.contains(v.node)) { 
                edgeDistance = v.cost; 
                newDistance = dist[u] + edgeDistance; 
  
                if (newDistance < dist[v.node]) 
                    dist[v.node] = newDistance; 
  
                pq.add(new Node(v.node, dist[v.node])); 
            } 
        } 
    } 
  
    public static void main(String arg[]) 
    { 
        int V = 5; 
        int source = 0; 
 
        List<List<Node> > adj = new ArrayList<List<Node> >(); 
 
        for (int i = 0; i < V; i++) { 
            List<Node> item = new ArrayList<Node>(); 
            adj.add(item); 
        } 
  
        adj.get(0).add(new Node(1, 9)); 
        adj.get(0).add(new Node(2, 6)); 
        adj.get(0).add(new Node(3, 5)); 
        adj.get(0).add(new Node(4, 3)); 
  
        adj.get(2).add(new Node(1, 2)); 
        adj.get(2).add(new Node(3, 4)); 
  
        DIJKSTRA dpq = new DIJKSTRA(V); 
        dpq.dijkstra(adj, source); 
  
        System.out.println("El camino más corto :"); 
        for (int i = 0; i < dpq.dist.length; i++) 
            System.out.println(source + " a " + i + " es "
                               + dpq.dist[i]); 
    } 
} 
  
class Node implements Comparator<Node> { 
    public int node; 
    public int cost; 
  
    public Node() 
    { 
    } 
  
    public Node(int node, int cost) 
    { 
        this.node = node; 
        this.cost = cost; 
    } 
  
    @Override
    public int compare(Node node1, Node node2) 
    { 
        if (node1.cost < node2.cost) 
            return -1; 
        if (node1.cost > node2.cost) 
            return 1; 
        return 0; 
    } 
} 

