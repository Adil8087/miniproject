package utils;

import core.Point;
import core.QuadTree;
import list.List;

public class QuadUtils {
	public static void populateQuadTree(QuadTree quadTree, List<Point> list1) {// List<Point>list1
//		Region area = new Region(0, 0, 400, 400);
//		QuadTree quadTree = new QuadTree(area);
//		List<Point>list1 = new List<Point>();

		float[][] points = new float[][] { { 21, 25 }, { 55, 53 }, { 70, 318 }, { 98, 302 }, { 49, 229 }, { 135, 229 },
				{ 224, 292 }, { 206, 321 }, { 197, 258 }, { 245, 238 }, { 212, 338 }, { 145, 138 }, { 355, 239 },
				{ 295, 318 }, { 24, 23 }, { 45, 98 }, { 85, 185 }, { 395, 378 }, { 365, 338 }, { 115, 208 } };
		String[] city = { "Nashik", "Pune", "Mumbai", "Ahmadnagar", "Delhi", "kolkata", "Goa", "Hyderabad", "Nagpur",
				"Shimla", "Banglore", "Chennai", "Kolkata", "Jaipur", "Ajmer", "Agra", "Lucknow", "Banaras", "Manali", "Mohali" };

		for (int i = 0; i < points.length; i++) {
			Point point = new Point(points[i][0], points[i][1], city[i]);
			if (quadTree.addPoint(point))
				list1.add(point);

		}
	}
}
