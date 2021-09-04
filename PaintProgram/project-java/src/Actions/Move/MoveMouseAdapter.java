package Actions.Move;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ShapesModeling.Shape;
public class MoveMouseAdapter extends MouseAdapter{
	private Move moveAction;
	private Point start;
	private Point base;
	public MoveMouseAdapter(Move drawAction) {
		this.moveAction = drawAction;
	}
	public void mousePressed(MouseEvent e) {
		start = new Point(e.getX(),e.getY()); 
		base = new Point(e.getX(),e.getY()); 
	}
	public void mouseDragged(MouseEvent e) {	
		int diffX = -(base.x - e.getX());
		int diffY = -(base.y - e.getY());
		for(Shape shape : moveAction.getDp().getSelectedShapes()) {
			shape.getP1().x += diffX;
			shape.getP1().y += diffY;
			shape.getP2().x += diffX;
			shape.getP2().y += diffY;
		}
		base = new Point(e.getX(),e.getY());
		moveAction.getDp().repaint();
	}
	public void mouseReleased(MouseEvent e) {
		moveAction.movedShapes.addAll(moveAction.getDp().getSelectedShapes());
		moveAction.diff = new Point(-(start.x - base.x),-(start.y - base.y));
		moveAction.getDp().removeMouseListener(this);
		moveAction.getDp().removeMouseMotionListener(this);
		moveAction.endOfAction();
		
	}
}
