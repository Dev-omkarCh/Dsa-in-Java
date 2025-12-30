package Graph.Concept.Graph;
import java.util.ArrayList;

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

public class Graph {

    public static void createGraph(ArrayList<Edge> graph[]){

        /*
           0     3
            \ /   \
            2 ---- 1
        */

        // It Creates a empty ArrayList, if not then throws null exception
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));
        
    };

    public static void printNeighbours(ArrayList<Edge> vertex) {
        for (int i = 0; i < vertex.size(); i++) {
            Edge e = vertex.get(i);
            System.out.println("Neighbour : "+ e.dest + ", Weight : " + e.wt);
        }
    };

    public static void main(String[] args) {

        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        // Print 2's Neighbours
        printNeighbours(graph[2]);
    };
};
