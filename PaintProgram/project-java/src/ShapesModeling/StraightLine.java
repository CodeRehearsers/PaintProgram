package ShapesModeling;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

public class StraightLine extends Shape {

	public StraightLine(Point p1, Point p2, Color frameColor) {
		super(p1, p2, false, frameColor, Color.black);
		
	}

	@Override
	public void draw(Graphics g) {
		Stroke old = ((Graphics2D)g).getStroke();
		g.setColor(frameColor);
		
		Stroke newStroke =new BasicStroke(strokeWidth,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                10.0f, null, 0.0f);
		((Graphics2D)g).setStroke(newStroke);
		g.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
		((Graphics2D)g).setStroke(old);
	}
	@Override
	public boolean contains(int x, int y) {
		int a = (int) (p1.getX() * (p2.getY() - y) + p2.getX() * (y - p1.getY()) + x * (p1.getY() - p2.getY()));
		System.out.println( a);
		return Math.abs(a)<3000 ? true : false;
	}
	public void drawSelector(Graphics g) {		
		Point e = new Point(p2),start = new Point(p1);
		Point p1,p2;
		if (e.getX() < start.x && e.getY() < start.y) {
			p2 = new Point(start);
			p1 = new Point(e.x,e.y);
		}else if(e.getX() < start.x && e.getY()>start.y) {
			p1 = new Point(start.x - (start.x - e.x),start.y);
			p2 = new Point(start.x,e.y);
		}
		else if(e.getX() > start.x && e.getY()<start.y) {
			p1=new Point(start.x,start.y - (start.y - e.y));
			p2 = new Point(e.x,start.y);
		}
		else {
			p1=new Point(start);
			p2=new Point(e.x,e.y);
		}
		super.drawSelector(p1,p2, g);
		
	}
	
	public static Shape newInstance() {
		return new StraightLine(new Point(0,0),new Point(0,0),Color.black);
	}
}
