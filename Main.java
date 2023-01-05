import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// create a graph that consists all the distance between two stations
		int graph[][] = new int [][]{{0, 20, 40, 0, 0, 0}, 
						 			 {20, 0, 100, 0, 0, 70},
						 			 {40, 100, 0, 30, 0, 0},
						 			 {0, 0, 30, 0, 180, 0},
						 			 {0, 0, 0, 180, 0 ,100},
						 			 {0, 70, 0, 0, 100, 0}
									};
		// create a 2d AraryList to store the min path
		ArrayList<List<String>> path = new ArrayList<List<String>>(6);
		
		// create ArrayList for each element in the 2d ArrayList
		for(int i = 0; i < 6; i++) {
			path.add(new ArrayList<String>());
		}
		
		String stations[] = {"Kuala Lumpur", "Parit Raja", "Kajang", "Nusa", "Johor Bahru", "Singapore"};
		
		// Add reference station for each ArrayList
		for(int i = 0; i < stations.length; i++) {
			path.get(i).add(stations[i]);
		}
		Dijkstra g = new Dijkstra();
		g.dijkstraAlgorithm(graph, path, 0);
	}

}
