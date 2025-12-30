# Graph Traversal

Graph traversal refers to the process of visiting all the nodes (or vertices) in a graph in a systematic way. 
There are two primary methods for traversing graphs: 
- Depth-First Search (DFS) 
- Breadth-First Search (BFS).

## 1. BFS (Breadth-First Search)

BFS explores the neighbor nodes at the present depth prior to moving on to nodes at the next depth level.

- `O(V + E)` time complexity, where V is the number of vertices and E is the number of edges.
- `O(V)` space complexity for the queue and visited array.
- Go to immediate neighbors first
- `queue` data structure is used.
- create a array `visited[]` to keep track of visited nodes.

```java
    1 --- 3 
  /       |  \
0         |    5 --- 6
  \       |  /
    2 --- 4 

```

In Trees, There was Level Order Traversal, In Graphs, BFS is indirectly Level Order Traversal.


### Steps to perform BFS:
1. Start by putting source node in the queue and mark it as visited.
2. While the queue is not empty:
   - Dequeue a node from the queue and process it.
   - Get all adjacent nodes of the dequeued node. If an adjacent node has not been visited, mark it as visited and enqueue it.

### Example of BFS:
Consider the graph above and starting BFS from node `0`.
- Start with node `0`: Enqueue `0`, mark `0` as visited.
- Dequeue `0`: Process `0`, enqueue its neighbors `1` and `2`, mark them as visited.
- Dequeue `1`: Process `1`, enqueue its unvisited neighbor `3`, mark
`3` as visited.
- Dequeue `2`: Process `2`, enqueue its unvisited neighbor `4`, mark `4` as visited.
- Dequeue `3`: Process `3`, enqueue its unvisited neighbor `5`, mark `5` as visited.
- Dequeue `4`: Process `4`, all its neighbors are already visited.
- Dequeue `5`: Process `5`, enqueue its unvisited neighbor `6`, mark `6` as visited.
- Dequeue `6`: Process `6`, all its neighbors are already visited.

### Table of Traversal Order:
| Step | Queue        | Visited Nodes      | Processed Node |
|------|--------------|--------------------|----------------|
| 1    | [0]          | {0}                | -              |
| 2    | [1, 2]       | {0, 1, 2}         | 0              |
| 3    | [2, 3]       | {0, 1, 2, 3}      | 1              |
| 4    | [3, 4]       | {0, 1, 2, 3, 4}   | 2              |
| 5    | [4, 5]       | {0, 1, 2, 3, 4, 5}| 3              |
| 6    | [5, 6]       | {0, 1, 2, 3, 4, 5, 6}| 4              |
| 7    | [6]          | {0, 1, 2, 3, 4, 5, 6}| 5              |
| 8    | []           | {0, 1, 2, 3, 4, 5, 6}| 6              |

The order of traversal will be: `0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6`.

### Sudo Code for BFS:

```java
function BFS(graph, startNode):
    create a queue Q
    create a set visited

    enqueue startNode onto Q
    add startNode to visited

    while Q is not empty:
        currentNode = dequeue from Q
        if currentNode not in visited:
            1. print currentNode
            2. add currentNode to visited

            3. Add all unvisited neighbors of currentNode to Q
            for each neighbor of currentNode in graph:
                if neighbor not in visited:
                    add neighbor to visited
                    enqueue neighbor onto Q
```


## 2. DFS (Depth-First Search)

DFS explores as far as possible along each branch before backtracking.

- `recursion` & `recursion stack` data structure is used.
- `O(V + E)` time complexity, where V is the number of vertices and E is the number of edges.
- `O(V)` space complexity for the stack and visited array.

- In trees, we don't use visited array as there are no cycles.
- In graphs, we use visited array to avoid cycles.

