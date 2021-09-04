package Display;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class ShapesClick implements Shape {

	@Override
	public Rectangle getBounds() {
		return null;
	}

	@Override
	public Rectangle2D getBounds2D() {
		return null;
	}

	@Override
	public boolean contains(double x, double y) {
		return false;
	}

	@Override
	public boolean contains(Point2D p) {
		return false;
	}

	@Override
	public boolean intersects(double x, double y, double w, double h) {
		return false;
	}

	@Override
	public boolean intersects(Rectangle2D r) {
		return false;
	}

	@Override
	public boolean contains(double x, double y, double w, double h) {
		return false;
	}

	@Override
	public boolean contains(Rectangle2D r) {
		return false;
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at) {
		return null;
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		return null;
	}

}
