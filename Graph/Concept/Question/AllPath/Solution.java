package Graph.Concept.Question.AllPath;
import java.util.ArrayList;

/* 
    Q. All paths from Source to Target
    For given src & tar, print all paths that exists from src to tar(target)
    - src = 0, tar = 5

        
        1 --- 3 
      /       |  \
    0         |   5 --- 6
      \       |  /
        2 --- 4 
        
*/

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

public class Solution {

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

    // Modified DFS - O(V^V) - exponentail time complexity
    public static void printAllPaths(ArrayList<Edge> graph[], int curr, int target, boolean vis[], String path){
        if(curr == target){
            System.out.println(path);
            return;
        }

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(vis[curr] == false){
                vis[curr] = true;
                printAllPaths(graph, e.dest, target, vis, path + e.dest);
                vis[curr] = false;
            }
        }
    };

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // Print all paths of the Graph from src : 0 to target : 5
        printAllPaths(graph, 0, 5, new boolean[V], "0");

    };
};
