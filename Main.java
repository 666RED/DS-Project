import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int graph[][] = new int [][]{{0, 20, 40, 0, 0, 0}, 
						 			 {20, 0, 100, 0, 0, 70},
						 			 {40, 100, 0, 30, 0, 0},
						 			 {0, 0, 30, 0, 180, 0},
						 			 {0, 0, 0, 180, 0 ,100},
						 			 {0, 70, 0, 0, 100, 0}
									};
		ArrayList<List<String>> path = new ArrayList<List<String>>(6);
		for(int i = 0; i < 6; i++) {
			path.add(new ArrayList<String>());
		}
		String stations[] = {"Kuala Lumpur", "Parit Raja", "Kajang", "Nusa", "Johor Bahru", "Singapore"};
		for(int i = 0; i < stations.length; i++) {
			path.get(i).add(stations[i]);
		}
		Dijkstra g = new Dijkstra();
		g.dijkstraAlgorithm(graph, path, 0);
	}

}
