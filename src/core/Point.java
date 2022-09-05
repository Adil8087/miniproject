package core;

import java.io.Serializable;
import java.util.Objects;

public class Point implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float x;
	private float y;
	private String cityName;

	public Point(float x, float y, String cityName) {
		this.x = x;
		this.y = y;
		this.cityName = cityName;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public Point(String cityName) {
		super();
		this.cityName = cityName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cityName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return Objects.equals(cityName, other.cityName);
	}

	@Override
	public String toString() {
		return "City: " + cityName + ", Co-ordinates:(" + x + "," + y + ")";
	}

}
