
package ShapesModeling;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

public class Triangle extends Shape {
	int[] Xs = new int[3];
	int[] Ys = new int[3];
	Point op1 ;
	public Triangle(Point p1, Point p2, Boolean isFilled, Color frameColor, Color insideColor) {
		super(p1, p2, isFilled, frameColor, insideColor);
		if (p2.x<p1.x) {
			p2.x = p1.x + (p1.x-p2.x);
		}
	}
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Stroke old = ((Graphics2D)g).getStroke();
		Stroke newStroke =new BasicStroke(strokeWidth,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                10.0f, null, 0.0f);
		((Graphics2D)g).setStroke(newStroke);
		int x3 = 0, y3 = 0;
		if (super.getP1().x <= super.getP2().x) {
			x3 =(super.getP1().x - Math.abs(super.getP1().x - super.getP2().x));
			y3 = super.getP2().y;
		} else if (super.getP1().x > super.getP2().x) {
			x3 = (super.getP1().x + Math.abs(super.getP1().x - super.getP2().x));
			y3 = super.getP2().y;
		}

		int[] Xcoordinate = { (int) p1.getX(), (int) p2.getX(), x3 };
		int[] Ycoordinate = { (int) p1.getY(), (int) p2.getY(), y3 };
		Xs = Xcoordinate;
		Ys = Ycoordinate;

		if (isFilled) {
			g.setColor(insideColor);
			g.fillPolygon(Xcoordinate, Ycoordinate, 3);
		}
		g.setColor(frameColor);
		g.drawPolygon(Xcoordinate, Ycoordinate, 3);
		((Graphics2D)g).setStroke(old);
	}
	static double area(int x1, int y1, int x2, int y2, int x3, int y3) {
		return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
	}
	@Override
	public boolean contains(int x, int y) {
		/* Calculate area of triangle ABC */
		double A = area(Xs[0], Ys[0], Xs[1], Ys[1], Xs[2], Ys[2]);

		/* Calculate area of triangle PBC */
		double A1 = area(x, y, Xs[1], Ys[1], Xs[2], Ys[2]);

		/* Calculate area of triangle PAC */
		double A2 = area( Xs[0], Ys[0],x, y, Xs[2], Ys[2]);

		/* Calculate area of triangle PAB */
		double A3 = area(Xs[0], Ys[0],Xs[1], Ys[1], x, y);

		/* Check if sum of A1, A2 and A3 is same as A */
		return (A == A1 + A2 + A3);
	}
	public void drawSelector(Graphics g) {
		Point e = new Point(p2),start = new Point(p1);
		Point p1,p2;
		if (e.getX() < start.x && e.getY() < start.y) {
			p1 = new Point(e);
			p2 = new Point(start.x + (start.x - e.x),start.y);
		}else if(e.getX() < start.x && e.getY()>start.y) {
			p1 = new Point(e.x,start.y);
			p2 = new Point(start.x + (start.x - e.x),e.y);
		}
		else if(e.getX() > start.x && e.getY()<start.y) {
			p1 = new Point(start.x - (e.x - start.x),e.y);
			p2 = new Point(e.x,start.y);
		}
		else {
			System.out.println(start);
			p1 = new Point(start.x - (e.x - start.x),start.y);
			System.out.println(p1);
			p2 = new Point(e);
		}
		super.drawSelector(p1,p2, g);
	}
	public static Shape newInstance() {
		return (Shape) new Triangle(new Point(0,0),new Point(0,0),false,Color.black,Color.black);
	}
}