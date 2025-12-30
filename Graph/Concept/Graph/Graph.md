# Basics Of Graphs

1. **Definition**: A graph is a collection of nodes (or vertices) connected by edges. It is used to represent relationships between pairs of objects.

2. **Components**:
   - **Vertices (Nodes)**: Vertices are simply nodes or points in the graph.
   - **Edges (Links)**: The connections between the vertices.
   - **Edges Types**:
     - **Uni-directional Edges**: One-way connections from one vertex to another.
     - **Bi-directional Edges**: Two-way connections between vertices.

3. **Graph Types**:
   - **Directed Graph (Digraph)**: A graph where edges have a direction, indicating a one-way relationship.
   - **Undirected Graph**: A graph where edges do not have a direction, indicating a two-way relationship.
   - **Weighted Graph**: A graph where edges have weights or costs associated with them.
   - **Unweighted Graph**: A graph where edges do not have weights.

4. **Graph Representation**:
   - **Adjacency Matrix**: A 2D array where the cell at row i and column j indicates the presence (and possibly weight) of an edge between vertex i and vertex j.
   - **Adjacency List(Most Common)**: A list where each vertex has a list of adjacent vertices.
   - **Edge List**: A list of all edges in the graph, where each edge is represented as a pair (or tuple) of vertices.
   - **Incidence Matrix**: A matrix that shows the relationship between vertices and edges, where rows represent vertices and columns represent edges.
   - **Implicit graphs**: Graphs that are not explicitly represented but can be inferred from other data structures or rules.

5. **What is Adjacency List?**
   An adjacency list is a collection of lists or arrays used to represent a graph. Each vertex in the graph has a list of all the vertices it is directly connected to by edges. This representation is efficient in terms of space, especially for sparse graphs, as it only stores existing edges.
   - Its a list of lists.
   - Each index represents a vertex.
   - Each element at that index is a list of vertices that are directly connected to that vertex.
   - Example:
     ```
     Vertex 0: [1, 2]
     Vertex 1: [0, 3]
     Vertex 2: [0]
     Vertex 3: [1]
     ```
   - Visual Representation:
     ```
     0 -- 1
     |    |
     2    3
     ```

    ``` 
    total vertex : 4
    total edges : 3
    ```

    Vertex wise:

    ```python
    # Source is always the index of the list
        0 --> {0, 1}, {0,2}
        1 --> {1, 0}, {1,3}
        2 --> {2, 0}
        3 --> {3, 1}
    ```

## Why Adjacency List?

- In Graph, one operations is used mostly that is to find all the neighbors of a given vertex.
- x is the number of neighbors of that vertex.
- In adjacency list, we can directly access the list of neighbors for a vertex in O(x) time.

---
# 2. Adjacency Matrix

An adjacency matrix is a 2D array used to represent a graph. The rows and columns of the matrix represent the vertices of the graph, and the entries in the matrix indicate whether there is an edge between the vertices. If there is an edge from vertex i to vertex j, the entry at row i and column j is typically set to 1 (or the weight of the edge in weighted graphs); otherwise, it is set to 0.

### Graph
```

  0      3
   \    / \
    \  /   \
     2 ---- 1

```

### Matrix Representation

```
     0 1 2 3
0  [ 0 0 1 0 ]
1  [ 0 0 1 1 ]
2  [ 1 1 0 1 ]
3  [ 0 1 1 0 ]
   ```

### Code Example

```java

int[][] adjacencyMatrix = {
    {0, 0, 1, 0}, // Edges from vertex 0 to 2
    {0, 0, 1, 1}, // Edges from vertex 1 to 2 and 3
    {1, 1, 0, 1}, // Edge from vertex 2 to 0, 1 and 3
    {0, 1, 1, 0}  // Edge from vertex 3 to 1 and 2
}; // V * V 
```
if Weighted graph, then we can store the weight instead of 1.

## Why not use Adjacency Matrix?

- We use extra space of storing `0s` for non-existing edges.
- we use `O(V^2)` space where V is the number of vertices.
- The operation to find all neighbors of a vertex takes `O(V)` time. on other hand, adjacency list takes `O(x)` time where x is the number of neighbors of that vertex.

---
# 3. Edge List

An edge list is a simple representation of a graph where each edge is stored as a pair (or tuple) of vertices. This representation is straightforward and efficient in terms of space, especially for sparse graphs, as it only stores the edges that exist.

### Graph
```
    0      3
     \ -1 / \ 6
  -2  \  /   \
       2 ---- 1
          10
```

```java
Edges = {
      {0, 2}, // Edge between vertex 0 and 2
      {1, 2}, // Edge between vertex 1 and 2
      {1, 3}, // Edge between vertex 1 and 3
      {2, 3}  // Edge between vertex 2 and 3
};
```

Then, later we can implement it using : 
- linkedList
- ArrayList

### Where to use Edge List?

- When we have to sort edges according to their weights.
- When we have to implement algorithms like Kruskal's Minimum Spanning Tree(MST) algorithm, which requires sorting edges by weight.

---
# 4. Implicit Graphs(Internal)

An implicit graph is a type of graph that is not explicitly represented using traditional data structures like adjacency lists or matrices. Instead, the graph's structure is inferred from other data or rules. Implicit graphs are often used in scenarios where the graph is too large to store explicitly or when the graph can be generated on-the-fly based on certain conditions.
where, the graph is given as a 2D grid/array.

- flood fill algorithm
- shortest path in a maze



