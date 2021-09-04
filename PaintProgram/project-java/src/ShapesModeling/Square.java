package ShapesModeling;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

public class Square extends Shape {

	public Square(Point p1, Point p2, Boolean isFilled, Color frameColor, Color insideColor) {
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
		if (super.getP1().x < super.getP2().x && super.getP1().y < super.getP2().y) {
			if (isFilled) {
				g.setColor(insideColor);
				g.fillRect((int) p1.getX(), (int) p1.getY(), Math.abs((int) (p1.getX() - p2.getX())),
						Math.abs((int) (p1.getX() - p2.getX())));
			}
			g.setColor(frameColor);
			g.drawRect((int) p1.getX(), (int) p1.getY(), Math.abs((int) (p1.getX() - p2.getX())),
					Math.abs((int) (p1.getX() - p2.getX())));

		} else if (super.getP1().x < super.getP2().x && super.getP1().y > super.getP2().y) {
			if (isFilled) {
				g.setColor(insideColor);
				g.fillRect((int) p1.getX(), (int) p1.getY() - (int) Math.abs(p1.getX() - p2.getX()),
						Math.abs((int) (p1.getX() - p2.getX())), Math.abs((int) (p1.getX() - p2.getX())));
			}
			g.setColor(frameColor);
			g.drawRect((int) p1.getX(), (int) p1.getY() - (int) Math.abs(p1.getX() - p2.getX()),
					Math.abs((int) (p1.getX() - p2.getX())), Math.abs((int) (p1.getX() - p2.getX())));
		} else if (super.getP1().x > super.getP2().x && super.getP1().y < super.getP2().y) {
			if (isFilled) {
				g.setColor(insideColor);
				g.fillRect((int) p1.getX() - Math.abs((int) (p1.getX() - p2.getX())), (int) p1.getY(),
						Math.abs((int) (p1.getX() - p2.getX())), Math.abs((int) (p1.getX() - p2.getX())));
			}
			g.setColor(frameColor);
			g.drawRect((int) p1.getX() - Math.abs((int) (p1.getX() - p2.getX())), (int) p1.getY(),
					Math.abs((int) (p1.getX() - p2.getX())), Math.abs((int) (p1.getX() - p2.getX())));

		} else if (super.getP1().x > super.getP2().x && super.getP1().y > super.getP2().y) {
			if (isFilled) {
				g.setColor(insideColor);
				g.fillRect((int) p1.getX() - Math.abs((int) (p1.getX() - p2.getX())),
						(int) p1.getY() - (int) Math.abs(p1.getX() - p2.getX()),
						Math.abs((int) (p1.getX() - p2.getX())), Math.abs((int) (p1.getX() - p2.getX())));
			}
			g.setColor(frameColor);
			g.drawRect((int) p1.getX() - Math.abs((int) (p1.getX() - p2.getX())),
					(int) p1.getY() - (int) Math.abs(p1.getX() - p2.getX()), Math.abs((int) (p1.getX() - p2.getX())),
					Math.abs((int) (p1.getX() - p2.getX())));

		}
		((Graphics2D)g).setStroke(old);
	}
	
	@Override
	public boolean contains(int x, int y) {
		return x > Math.min((int) p1.getX(), (int) p2.getX())
				&& x < Math.min((int) p1.getX(), (int) p2.getX()) + Math.abs((int) p1.getX() - (int) p2.getX())
						& y > Math.min((int) p1.getY(), (int) p2.getY())
				&& y < Math.min((int) p1.getY(), (int) p2.getY()) + Math.abs((int) p1.getY() - (int) p2.getY());
	}
	public void drawSelector(Graphics g) {	
		Point e = new Point(p2);
		Point p1d,p2d;
		int size = Math.abs(p1.x - p2.x);
		if (p1.x < p2.x && p1.y < p2.y) {
			p1d = new Point(this.p1);
			p2d = new Point(p1d.x + size,p1d.y+size);
		} else if (p1.x < p2.x && p1.y > p2.y) {
			p1d = new Point( p1.x, p1.y - Math.abs(p1.x - p2.x));
			p2d = new Point(p1d.x + size,p1d.y+size);
		} else if (p1.x > p2.x && p1.y < p2.y) {
			p1d = new Point(p1.x - Math.abs((p1.x - p2.x)), p1.y);
			p2d = new Point(p1d.x + size,p1d.y+size);
		} else if (p1.x > p2.x && p1.y > p2.y) {
			p1d = new Point(p1.x- Math.abs(p1.x - p2.x),p1.y - Math.abs(p1.x - p2.x));			
			p2d = new Point(p1d.x + size,p1d.y+size);
		}
		super.drawSelector(p1,p2, g);
	}
	public static Shape newInstance() {
		return (Shape) new Square(new Point(0,0),new Point(0,0),false,Color.black,Color.black);
	}
}
