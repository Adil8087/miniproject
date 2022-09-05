package utils;

import QuadTreeException.QuadTreeException;
import core.Point;
import core.Region;

public class QuadTreeValidationUtils {
	private static int low_Range = 0;
	private static int High_Range = 400;

	public static Point validateInput(float x, float y, String cityName) throws QuadTreeException {
		if (x <= High_Range && x >= low_Range && y <= High_Range && y >= low_Range)
			return new Point(x, y, cityName);
		else
			throw new QuadTreeException("Can't add City in quad tree as coardinates of points are outside range!!!!");
	}

	public static Region validateSearchRegion(float x1, float y1, float x2, float y2) throws QuadTreeException {
		if (x1 <= High_Range && x1 >= low_Range && y1 <= High_Range && y1 >= low_Range && x2 <= High_Range
				&& x2 >= low_Range && y2 <= High_Range && y2 >= low_Range)
			return new Region(x1, y1, x2, y2);
		else
			throw new QuadTreeException("Given range is beyond scope of the project!!!! \nRange of scope (0, 400)");

	}
}
