package Week99_Final_Test_Sample;

public class P3_EasyLearning {
    int[][] switchingCost;
    public static void main(String[] args){
        int[][] testArr = {
                            {0, 1, 5},
                            {4, 0, 3},
                            {2, 1, 9}
                        };
        P3_EasyLearning easyLearning = new P3_EasyLearning(testArr);    
        System.out.println(easyLearning.compare(new int[] {0, 2}, new int[] {0, 1, 2}));
        System.out.println(easyLearning.bestSequence(testArr, 0, testArr.length - 1));
    }

    public P3_EasyLearning(int[][] arr) {
        switchingCost = arr;
    }

    // Time complexity: O(N)
    public int compare(int[] seq1, int[] seq2){
        int cost1 = 0;
        int cost2 = 0;

        if(seq1.length < 2 && seq2.length > 2){
            // The swithching cost of seq2 is higher
            return -1;
        } else if (seq1.length > 2 && seq2.length < 2){
            // The swithching cost of seq1 is higher
            return 1;
        } else if (seq1.length < 2 && seq2.length < 2){
            return 0;
        }

        // Compute the cost for seq1
        for(int i = 0; i < seq1.length - 1; i++){
            cost1 += switchingCost[seq1[i]][seq1[i+1]];
        }

        // Compute the cost for seq2
        for(int i = 0; i < seq2.length - 1; i++){
            cost2 += switchingCost[seq2[i]][seq2[i+1]];
        }

        if (cost1 > cost2){
            return 1;
        } else if (cost1 < cost2){
            return -1;
        } else {
            return 0;
        }
    }

    public int bestSequence(int[][] nodes, int src, int dest){
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
                    path = shortestNode + " " + path;
                }

                System.out.println(path);
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
