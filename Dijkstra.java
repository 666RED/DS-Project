import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
	static final int NUM_OF_STATIONS = 6;
	
	// find the minDistanceNode from all unvisited nodes
	int minDistance(int pathArray[], Boolean visitedNodes[]) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		
		for(int v = 0; v < NUM_OF_STATIONS; v++) {
			if(!visitedNodes[v] && pathArray[v] <= min) {
				min = pathArray[v];
				minIndex = v;
			}
		}
		return minIndex;
	}
	
	void printMinPath(int pathArray[], ArrayList<List<String>> path) { // just for the purpose of printing out result
		System.out.println("Minimum distance from KL to each station\n");
		System.out.println("From \t\t To \t\t Minimum Path");
		System.out.println("---------------------------------------------");
		for(int i = 1; i < path.size(); i++) {
			if(path.get(i).get(0).length() < 7) {
				System.out.print("Kuala Lumpur \t " + path.get(i).get(0) + "\t\t ");
			}else {
				System.out.print("Kuala Lumpur \t " + path.get(i).get(0) + "\t ");
			}
			for(int j = 1; j < path.get(i).size(); j++) {
				if(j != path.get(i).size() - 1) {
					System.out.print(path.get(i).get(j) + " -> ");
				}else {
					System.out.print(path.get(i).get(j));
				}
			}
			System.out.println("\n");
		}
		System.out.println("\nStation \t Minimum Distance from KL");
		System.out.println("-----------------------------------------");
		for(int i = 1; i < NUM_OF_STATIONS; i++) {
			if(path.get(i).get(0).length() < 9) {
				System.out.println(path.get(i).get(0) + " \t\t\t " + pathArray[i]);
			}else {
				System.out.println(path.get(i).get(0) + " \t\t " + pathArray[i]);
			}
		}
	}
	
	void dijkstraAlgorithm(int graph[][], ArrayList<List<String>> path, int sourceNode) {
		int pathArray[] = new int[NUM_OF_STATIONS];
		Boolean visitedNodes[] = new Boolean[NUM_OF_STATIONS];
		
		for(int i = 0; i < NUM_OF_STATIONS; i++) { // set all node as unvisited && all node has the minimum distance of infinity
			pathArray[i] = Integer.MAX_VALUE;
			visitedNodes[i] = false;
		}
		
		pathArray[sourceNode] = 0; // set distance of KL as 0 because it is the origin
		
		for(int count = 0; count < NUM_OF_STATIONS; count++) {
			int minDistanceNodeIndex = minDistance(pathArray, visitedNodes); // find the node with minimum distance
			visitedNodes[minDistanceNodeIndex] = true; // set it as visited
			
			for(int v = 0; v < NUM_OF_STATIONS; v++) {
				// if the node hasn't been visiting
				// the distance of minimum node is not infinity
				// the distance between the minimum node and the connected node is not 0 (they are connected)
				// this distance is less than the original distance of the connected node 
				// update the minimum distance (distance of minimum node + distance between it and connected node)
				if(!visitedNodes[v] && pathArray[minDistanceNodeIndex] != Integer.MAX_VALUE && graph[minDistanceNodeIndex][v] != 0 && pathArray[minDistanceNodeIndex] + graph[minDistanceNodeIndex][v] < pathArray[v]) {
					pathArray[v] = pathArray[minDistanceNodeIndex] + graph[minDistanceNodeIndex][v];
					if(path.get(v).size() != 1) {// to update the minimum path
						int sizeOfArray = path.get(v).size();
						for(int i = 1; i < sizeOfArray; i++) {
							path.get(v).remove(1); // remove the original path, but do not remove the reference station node
						}
					}
					if(path.get(minDistanceNodeIndex).size() == 1) { // if the minimum node has only itself
						path.get(v).add(path.get(minDistanceNodeIndex).get(0));
					}else {
						for(int i = 1; i < path.get(minDistanceNodeIndex).size(); i++) {
							path.get(v).add(path.get(minDistanceNodeIndex).get(i)); // adding all station from minimum node
						}
					}
					path.get(v).add(path.get(v).get(0)); // add the reference station node at the back of the path
				}
			}
		}
		printMinPath(pathArray, path);
	}
}
