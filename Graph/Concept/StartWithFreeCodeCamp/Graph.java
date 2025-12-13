// Visit: https://youtu.be/dS44jZyj5gU?si=DBTSZOp4Iz1diTLR

package Graph.Concept.StartWithFreeCodeCamp;

import java.util.ArrayList;

class Vertex {
    private String data;
    private ArrayList<Edge> edges;

    public Vertex(String data){
        this.data = data;
        this.edges = new ArrayList<Edge>();
    };


    public void addEdge(Vertex endVertex, Integer weight){
        this.edges.add(new Edge(this, endVertex, weight));
    };

    public void removeEdge(Vertex endVertex){
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    };

    public String getData(){
        return this.data;
    };

    public ArrayList<Edge> getEdges(){
        return this.edges;
    };

    public void print(boolean showWeight){
        String message = "";
        if(this.edges.size() == 0){
            System.out.println(this.data + " -->");
            return;
        }

        for(int i = 0; i < this.edges.size(); i++){
            if(i == 0){
                message += this.edges.get(i).getStart().data + "---> ";
            }

            message += this.edges.get(i).getEnd().data + "--> ";

            if(showWeight){
                message += "(" + this.edges.get(i).getWeight() + ")";
            };

            if(i != this.edges.size()){
                message += ", ";
            }
            System.out.println(message);
        };
    };
    

}

class Edge {
    // directed Graph
    private Vertex start;
    private Vertex end;
    private Integer weight;

    public Edge(Vertex start, Vertex end, Integer weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    };

    public Vertex getStart(){
        return this.start;
    };

    public Vertex getEnd(){
        return this.end;
    };

    public Integer getWeight(){
        return this.weight;
    };
}

public class Graph {
    private ArrayList<Vertex> vertices;
    private boolean isWeighted; 
    private boolean isDirected;
    
    public Graph(boolean isWeighted, boolean isDirected){
        this.vertices = new ArrayList<Vertex>();
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
    };

    public Vertex addVertex(String data){
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void addEdge(Vertex v1, Vertex v2, Integer wt){
        if(!this.isWeighted){
            wt = null;
        }
        v1.addEdge(v2, wt);
        if(!this.isDirected){
            v2.addEdge(v1, wt);
        }
    }

    public void removeEdge(Vertex v1, Vertex v2, Integer wt){
        v1.removeEdge(v2);
        if(!this.isDirected){
            v2.removeEdge(v1);
        }
    };

    public void removeVertex(Vertex vertex){
        this.vertices.remove(vertex);
    };

    public ArrayList<Vertex> getVertices(){
        return this.vertices;
    };

    public boolean isWeighted(){
        return this.isWeighted;
    };
    public boolean isDirected(){
        return this.isDirected;
    };

    public Vertex getVerticesByValue(String value){
        for(Vertex vertex : this.vertices){
            if(vertex.getData() == value){
                return vertex;
            }
        }
        return null;
    };

    public void print(){
        for(Vertex v : this.vertices){
            v.print(isWeighted);
        }
    };

    public static void main(String[] args) {

        Graph busNetwork = new Graph(true, true);
        Vertex virarStation = busNetwork.addVertex("Virar Station");
        Vertex manvelPada = busNetwork.addVertex("manvelPada");
        Vertex kargilNagar = busNetwork.addVertex("kargilNagar");
        Vertex nalasoparaStation = busNetwork.addVertex("nalasoparaStation");

        busNetwork.addEdge(virarStation, manvelPada, 1000);
        busNetwork.addEdge(manvelPada, kargilNagar, 200);
        busNetwork.addEdge(kargilNagar, nalasoparaStation, 3000);

        busNetwork.print();
    }
}
