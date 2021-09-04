package ShapesModeling;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

public class Circle extends Shape {

	public Circle(Point p1, Point p2, Boolean isFilled, Color frameColor, Color insideColor) {
		super(p1, p2, isFilled, frameColor, insideColor);

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
		if (p1.equals(p2)) {
			g.setColor(insideColor);
			g.fillOval((int) p2.getX(), (int) p2.getY(), 4, 9);

		} else {
			if (super.getP1().x < super.getP2().x && super.getP1().y < super.getP2().y) {
				if (isFilled) {
					g.setColor(insideColor);
					g.fillOval((int) p1.getX(), (int) p1.getY(),
							(int) Math.max((int) Math.abs((int) (p1.getX() - p2.getX())),
									(int) Math.abs((int) (p1.getY() - p2.getY()))),
							(int) Math.max((int) Math.abs((int) (p1.getX() - p2.getX())),
									(int) Math.abs((int) (p1.getY() - p2.getY()))));
				}
				g.setColor(frameColor);
				g.drawOval((int) p1.getX(), (int) p1.getY(),
						(int) Math.max((int) Math.abs((int) (p1.getX() - p2.getX())),
								(int) Math.abs((int) (p1.getY() - p2.getY()))),
						(int) Math.max((int) Math.abs((int) (p1.getX() - p2.getX())),
								(int) Math.abs((int) (p1.getY() - p2.getY()))));

			} else if (super.getP1().x < super.getP2().x && super.getP1().y > super.getP2().y) {
				if (isFilled) {
					g.setColor(insideColor);
					g.fillOval((int) p1.getX(), (int) p1.getY() - (int) Math.abs(p1.getX() - p2.getX()),
							Math.abs((int) (p1.getX() - p2.getX())), Math.abs((int) (p1.getX() - p2.getX())));
				}
				g.setColor(frameColor);
				g.drawOval((int) p1.getX(), (int) p1.getY() - (int) Math.abs(p1.getX() - p2.getX()),
						Math.abs((int) (p1.getX() - p2.getX())), Math.abs((int) (p1.getX() - p2.getX())));
			} else if (super.getP1().x > super.getP2().x && super.getP1().y < super.getP2().y) {
				if (isFilled) { 
					g.setColor(insideColor);
					g.fillOval((int) p1.getX() - Math.abs((int) (p1.getX() - p2.getX())), (int) p1.getY(),
							Math.abs((int) (p1.getX() - p2.getX())), Math.abs((int) (p1.getX() - p2.getX())));
				}
				g.setColor(frameColor);
				g.drawOval((int) p1.getX() - Math.abs((int) (p1.getX() - p2.getX())), (int) p1.getY(),
						Math.abs((int) (p1.getX() - p2.getX())), Math.abs((int) (p1.getX() - p2.getX())));

			} else if (super.getP1().x > super.getP2().x && super.getP1().y > super.getP2().y) {
				if (isFilled) {
					g.setColor(insideColor);
					g.fillOval((int) p1.getX() - Math.abs((int) (p1.getX() - p2.getX())),
							(int) p1.getY() - (int) Math.abs(p1.getX() - p2.getX()),
							Math.abs((int) (p1.getX() - p2.getX())), Math.abs((int) (p1.getX() - p2.getX())));
				}
				g.setColor(frameColor);
				g.drawOval((int) p1.getX() - Math.abs((int) (p1.getX() - p2.getX())),
						(int) p1.getY() - (int) Math.abs(p1.getX() - p2.getX()),
						Math.abs((int) (p1.getX() - p2.getX())), Math.abs((int) (p1.getX() - p2.getX())));
			}

		}
		g2.setStroke(old);
	}
	@Override
	public boolean contains(int x,int y) {
		int radius = Math.max((int)(p2.getX()-p1.getX()), (int)(p2.getY() - p1.getY()))/2;
		Point point = new Point((int)p1.getX()+radius,(int)p1.getY()+radius);
		return new Point(x,y).distance(point) <= radius;
	}
	public void drawSelector(Graphics g) {
		Point endPoint = new Point(p1.x + Math.abs((int) (p1.getX() - p2.getX())),p1.y +  Math.abs((int) (p1.getX() - p2.getX())));
		super.drawSelector(p1, endPoint, g);
	}
	
	public static Shape newInstance() {
		return (Shape) new Circle(new Point(0,0),new Point(0,0),false,Color.black,Color.black);
	}
}