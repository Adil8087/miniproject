package core;

import java.io.Serializable;

import list.List;

public class QuadTree implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int MAX_POINTS = 3;
	private Region area;
	private List<Point> points1;
	private QuadTree[] qtree;

	public QuadTree(Region area) {
		this.area = area;
		points1 = new List<Point>();
		qtree = new QuadTree[4];

	}

	private boolean addPointToOneQuadrant(Point point) {
		boolean isPointAdded;
		for (int i = 0; i < 4; i++) {
			isPointAdded = this.qtree[i].addPoint(point);
			if (isPointAdded)
				return true;
		}
		return false;
	}

	private void createQuadrants() {
		Region region; // reference created
		for (int i = 0; i < qtree.length; i++) {
			region = this.area.getQuadrant(i);
			// // 0=SW, 1=NW, 2=NE, 3=SE
			qtree[i] = new QuadTree(region);
		}
	}

	private boolean QtreeIsEmpty() {
		boolean isEmpty = true;
		for (int i = 0; i < qtree.length; i++)
			if (qtree[i] != null)
				isEmpty = false;
		return isEmpty;
	}

	public boolean addPoint(Point point) {
		if (this.area.containsPoint(point)) {
			if (this.points1.size() < MAX_POINTS) {
				this.points1.add(point);
				return true;
			} else {
				if (QtreeIsEmpty()) {
					createQuadrants();
				}
				return addPointToOneQuadrant(point);
			}
		}
		return false;
	}
	public List<Point> search(Region searchRegion){
		return search(searchRegion, null);
	}
	
	
	private List<Point> search(Region searchRegion, List<Point> matches) {
		if (matches == null) {
			matches = new List<Point>();
		}
		if (!this.area.doesOverlap(searchRegion)) {
			return matches;
		} else {
			for (int i = 0; i < MAX_POINTS; i++) {
				Point temp = points1.Search(i);
				if (temp != null && searchRegion.containsPoint(temp))
					matches.add(temp);
			}
			if (!QtreeIsEmpty()) {
				for (int i = 0; i < qtree.length; i++) {
					qtree[i].search(searchRegion, matches);
				}
			}
		}
		return matches;
	}
}