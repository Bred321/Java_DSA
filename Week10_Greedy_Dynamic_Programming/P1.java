package Week10_Greedy_Dynamic_Programming;

public class P1 {
    public static void main(String[] args){
        int[][] distances = {
            {0, 3, 2, 0},
            {3, 0, 0, 5},
            {2, 0, 0, 9},
            {0, 5, 9, 0}
        };
        System.out.println("Shortest distance: " + shortestPath(distances, 0, distances.length - 1));
    }

    static int shortestPath(int[][] nodes, int src, int dest){
        int n = nodes.length;
        int[] distances = new int[n]; // distances[i] stores the minimum distance from src to i
        boolean[] visited = new boolean[n]; // visit state
        int[] previous = new int[n]; // used to construct the shortest path; previous[i] stores the node that is visited before i

        // Initialization
        for(int i = 0; i < n; i++){
            distances[i] = Integer.MAX_VALUE;
            previous[i] = -1;
        }
        distances[src] = 0;
    

        while(true){
            // Greedy choice: retrieve the shortest-distance node from
            // unvisited nodes
            int shortest = Integer.MAX_VALUE;
            int shortestNode = -1;
            for(int i = 0; i < n; i++){
                if(visited[i]){
                    continue;
                }
                if(shortest > distances[i]) {
                    shortest = distances[i];
                    shortestNode = i;
                }
            }

            // update the shortest distance through shortest node
            // to all unvisited nodes
            for(int i = 0; i < n; i++){
                if(visited[i]) continue;
                // shortestNode and i are connected?
                if(nodes[shortestNode][i] > 0){
                    // current distance to i > distance reached through shortestNode
                    if(distances[i] > distances[shortestNode] + nodes[shortestNode][i]){
                        distances[i] = distances[shortestNode] + nodes[shortestNode][i];
                        previous[i] = shortestNode;
                    }
                }
            }

            if(shortestNode == dest){
                // we reach the destination
                // display the shortest path
                String path = shortestNode + "";
                while(previous[shortestNode] != -1){
                    shortestNode = previous[shortestNode];
                    path = shortestNode + "->" + path;
                }

                System.out.println("Shortest path: " + path);
                return distances[dest];
            }

            // Even the shortest is INFINITY => stop
            if(shortest == Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            // continue the next round
            visited[shortestNode] = true;
        }
    }
}

// Problemm 1
// The list of cities and their direct distances are given in a 2D array. For example

// distances = [
//   [0, 3, 2, 0]
//   [3, 0, 0, 5],
//   [2, 0, 0, 9]
//   [0, 5, 9, 0]
// ]
// Explanation: the value at cell [i, j] represents the distance between city i and city j. The distance between a city and itself is zero (i.e., distances[i, i] = 0 for every i). If there is no direct path between city i and j, then distances[i, j] is also zero.

// Implement a program to calculate the shortest path's length from the first city (index 0) to the last city (index n - 1, n is the number of cities).

// In the above example, there are 2 paths from city 0 to city 3

// 0 -> 1 -> 3 (length 3 + length 5 = 8)

// 0 -> 2 -> 3 (length 2 + length 9 = 11)

// So, the shortest path is: 0 -> 1 -> 3