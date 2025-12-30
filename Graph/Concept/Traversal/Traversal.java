package Graph.Concept.Traversal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Edge{
    int src;
    int dest;
    int wt;
    public Edge(int src, int dest){
        this.src = src;
        this.dest = dest;
    };
    public Edge(int src, int dest, int wt){
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    };
};

public class Traversal {

    public static void createGraph(ArrayList<Edge> graph[]){

        /*
        
             1 --- 3 
           /       | \
         0         |  5 --- 6
          \       |  /
           2 --- 4 
        
        */

        // It Creates a empty ArrayList, if not then throws null exception
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        
        graph[6].add(new Edge(6, 5));
        
    };

    public static void bfs(ArrayList<Edge> graph[], int V){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[V];
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if(vis[curr] == false){
                // 1. print current node
                System.out.print(curr+ " ");

                // 2. mark it as visited
                vis[curr] = true;

                // 3. Add All neighbours of current node in queue
                for(Edge neighbour : graph[curr]){
                    q.add(neighbour.dest);
                };
            };
        };
    };

    public static void bfsForDisconnectedGraps(ArrayList<Edge> graph[], int V, boolean vis[], int start){
        // Use to make sure of it.
        /*
            0 --- 1 --- 2
            3 --- 4
        */

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if(vis[curr] == false){
                // 1. print current node
                System.out.print(curr+ " ");

                // 2. mark it as visited
                vis[curr] = true;

                // 3. Add All neighbours of current node in queue
                for(Edge neighbour : graph[curr]){
                    q.add(neighbour.dest);
                };
            };
        };
    };

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == false){
                dfs(graph, e.dest, vis);
            }
        };
    };
    public static void main(String[] args) {

        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // --- Breath First Search(BFS) ---
        // bfs(graph, V);

        // --- Disconnected Graph BFS ---
        // boolean vis[] = new boolean[V];
        // for(int i = 0; i < graph.length; i++){
        //     if(vis[i] == false){
        //         bfsForDisconnectedGraps(graph, V, vis, i);
        //     }
        // }

        // --- Depth first Search (DFS) ---
        // boolean vis[] = new boolean[V];
        // dfs(graph, 0, new boolean[V]);

        // --- Disconnected Graph DFS ---
        boolean vis[] = new boolean[V];

        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                dfs(graph, i, vis);
            };
        };
    };
};
