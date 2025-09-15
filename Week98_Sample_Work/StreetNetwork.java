package Week98_Sample_Work;

public class StreetNetwork {
    int[][] network;
    int N;

    public StreetNetwork(int[][] network){
        this.network = network;
        N = network.length;
    }
    public static void main(String[] args){
        int[][] distances = {
            {0, -1, 5, 10},
            {-1, 0, 4, 2},
            {-1, 1, 0, 4},
            {3, -1, 7, 10}
        };

        StreetNetwork streetNetwork = new StreetNetwork(distances);
        System.out.println(streetNetwork.nearestNeighbour());
        System.out.println(streetNetwork.shortestToSchool());
    }

    public int nearestNeighbour(){
        int nearestDistance = Integer.MAX_VALUE;
        int neartestIndex = 0;

        for(int i = 1; i < N; i++){
            if(network[0][i] < 0) continue;
            if(nearestDistance > network[0][i]){
                nearestDistance = network[0][i];
                neartestIndex = i;
            }
        }

        return nearestDistance;
    }

    public int shortestToSchool(){
        int src = 0;
        int dest = N - 1;

        int[] distances = new int[N];
        boolean[] visited = new boolean[N];
        int[] previous = new int[N];

        // Update the shortest distance through shortest node
        // to all unvisited nodes
        while(true){
            // Greedy choice: retrieve the shortest-distance node from
            // unvisited nodes
            int shortest = Integer.MAX_VALUE;
            int shortestNode = -1;
            for(int i = 0; i < N; i++){
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
            for(int i = 0; i < N; i++){
                if(visited[i]) continue;
                // shortestNode and i are connected?
                if(network[shortestNode][i] > 0){
                    // current distance to i > distance reached through shortestNode
                    if(distances[i] > distances[shortestNode] + network[shortestNode][i]){
                        distances[i] = distances[shortestNode] + network[shortestNode][i];
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
        //shortestNodeand i are conn
    }
}
