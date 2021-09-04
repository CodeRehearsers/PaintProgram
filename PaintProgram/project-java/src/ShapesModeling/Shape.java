package ShapesModeling;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.lang.reflect.InvocationTargetException;


public abstract class Shape{
	
	protected Point p1;
	protected Point p2;
	protected Point start;
	protected Color frameColor = Color.black;
	protected Color insideColor = Color.white;
	protected boolean isFilled;
	protected Rectangle outer;
	protected boolean selected;
	int selectorMargin;
	Color selectorColor;
	int strokeWidth = 3;
	public Shape(Point p1,Point p2,Boolean isFilled,Color frameColor,Color insideColor) {
		this.frameColor = frameColor;
		this.insideColor=insideColor;
		this.p1 = new Point(p1);
		this.p2 = new Point(p2);
		this.start = new Point(p1);
		this.isFilled=isFilled;
		
	}
	public void setStrokeWidth(int strokeWidth) {
		this.strokeWidth = strokeWidth;
	}
	public void setStart(Point start) {
		this.start = start;
	}
	public void setMargin(int selectorMargin) {
		this.selectorMargin = selectorMargin;
	}
	public void setSelectorColor(Color selectorColor) {
		this.selectorColor = selectorColor;
	}
	public abstract void draw(Graphics g);
	
	public void select() {
		selected = true;
	}
	public void unSelect() {
		selected = false;
	}
	public boolean isSelected() {
		return selected ;
	}
	
	
	
	
	
	
	
	
	public Color getFrameColor() {
		return frameColor;
	}

	public void setFrameColor(Color frameColor) {
		this.frameColor = frameColor;
	}
	public Color getInsideColor() {
		return insideColor;
	}

	public void setInsideColor(Color insideColor) {
		this.insideColor = insideColor;
	}

	public Point getP1() {
		return p1;

	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public void setP1(int x, int y) {
		this.p1.x = x;
		this.p1.y = y;

	}
	public boolean getIsFilled() {
		return isFilled;
	}
	public void setIsFilled(boolean isFilled) {
		this.isFilled = isFilled ;
	}

	public void setP2(int x, int y) {
		this.p2.x = x;
		this.p2.y = y;

	}
	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}
	public boolean contains(int x,int y) {
		return false;
	}
	public Shape getClone() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Shape clone = (Shape) this.getClass().getDeclaredMethod("newInstance").invoke(null);
		clone.setP1(p1);
		clone.setP2(p2);
		clone.setStrokeWidth(strokeWidth);
		clone.setFrameColor(frameColor);
		clone.setInsideColor(insideColor);
		clone.setIsFilled(isFilled);
		return clone;
	}
	public Shape copyHere(int x,int y) {
		Shape clone;
		try {
			clone = getClone();
		} catch ( IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		int diffX =- (clone.p1.x - x);
		int diffY =-( clone.p1.y - y);
		clone.setP1(new Point(x,y));
		clone.setP2(new Point(p2.x + diffX , p2.y+ diffY));
		return clone;
	}
	public void drawSelector(Point p1,Point p2,Graphics g) {
		Rectangle selector = new Rectangle(new Point(p1.x - selectorMargin,p1.y - selectorMargin),new Point(p2.x + selectorMargin,p2.y + selectorMargin),false,selectorColor,Color.black);
		float dash[] = {10.0f};
		selector.setStroke(new BasicStroke(1.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                10.0f, dash, 0.0f));
		selector.draw(g);
		System.out.println("Selector Drawn for " + this.getClass().getSimpleName());
	}
	public abstract void drawSelector(Graphics g);
}
