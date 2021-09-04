package Actions.Draw;


import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ShapesModeling.StraightLine;

public class DrawMouseAdapter extends MouseAdapter{
	private Draw drawAction;
	private Point base;
	private Point start;
	int status = 2;
	StraightLine helper;
	public DrawMouseAdapter(Draw drawAction) {
		this.drawAction = drawAction;
	}
	public void mousePressed(MouseEvent e) {
		start = new Point(e.getX(),e.getY()); 
		base = new Point(e.getX(),e.getY()); 
		drawAction.shape.setP1(e.getX(),e.getY());
		drawAction.shape.setP2(e.getX(),e.getY());
		drawAction.shape.setStart(start);
		drawAction.getDp().addShape(drawAction.shape);
		if (!drawAction.obeyDrawPanel)
			return;
		drawAction.shape.setStrokeWidth(drawAction.getDp().getStrokeWidth());
		drawAction.shape.setInsideColor(drawAction.getDp().getFillColor());
		drawAction.shape.setFrameColor(drawAction.getDp().getStrokeColor());
		drawAction.shape.setIsFilled(drawAction.getDp().getIsFilled());
			System.out.println("obeyed");
	}
	public void mouseDragged(MouseEvent e) {	
		int diffX = -(base.x - e.getX());
		int diffY = -(base.y - e.getY());
		drawAction.shape.getP2().x += diffX;
		drawAction.shape.getP2().y += diffY;
		base = new Point(e.getX(),e.getY());
		drawAction.getDp().repaint();

	}
	public void mouseReleased(MouseEvent e) {
		drawAction.getDp().removeMouseListener(this);
		drawAction.getDp().removeMouseMotionListener(this);
		drawAction.endOfAction();
	}
}
