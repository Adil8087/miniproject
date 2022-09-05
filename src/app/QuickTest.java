package app;


import core.Point;
import core.QuadTree;
import core.Region;
import list.List;

public class QuickTest {
	public static void main(String[] args) {
		Region area = new Region(0, 0, 400, 400);
		QuadTree quadTree = new QuadTree(area);

//		float[][] points = new float[][] { { 1, 1 }, { 1, 2 }, { 2, 4 }, { 4, 1 }, { 8, 9 }, { 7, 3 },
//				{ 5, 5 }, { 4, 6 }, { 6, 3 }, { 9, 8 } };
//		String[] city = { "Nashik", "Pune", "Mumbai", "Ahmadnagar", "Delhi", "kolkata", "Goa", "Hyderabad", "Nagpur",
//				"Shimla" };
		float[][] points = new float[][] { { 21, 25 }, { 55, 53 }, { 70, 318 }, { 98, 302 }, 
		    { 49, 229 }, { 135, 229 }, { 224, 292 }, { 206, 321 }, { 197, 258 }, { 245, 238 } };
		    
		    String[] city = { "Nashik", "Pune", "Mumbai", "Ahmadnagar", "Delhi", "kolkata", "Goa", "Hyderabad", "Nagpur",
			"Shimla" };   

		for (int i = 0; i < points.length; i++) {
			Point point = new Point(points[i][0], points[i][1], city[i]);
			quadTree.addPoint(point);
//			for (Point j : result)
//				System.out.println(j);
		}
		Region searchArea = new Region(10, 10, 100, 100);
		List<Point> result = quadTree.search(searchArea);
		System.out.println(result);
	}
}


// 		LEFT RIGHT  NE NW SE SW 
