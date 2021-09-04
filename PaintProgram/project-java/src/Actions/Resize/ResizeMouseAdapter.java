package Actions.Resize;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ShapesModeling.Shape;
public class ResizeMouseAdapter extends MouseAdapter{
	private Resize resizeAction;
	private Point start;
	private Point base;
	public ResizeMouseAdapter(Resize drawAction) {
		this.resizeAction = drawAction;
	}
	public void mousePressed(MouseEvent e) {
		start = new Point(e.getX(),e.getY()); 
		base = new Point(e.getX(),e.getY()); 
	}
	public void mouseDragged(MouseEvent e) {	
		int diffX = -(base.x - e.getX());
		int diffY = -(base.y - e.getY());
		for(Shape shape : resizeAction.getDp().getSelectedShapes()) {
			shape.getP2().x += diffX;
			shape.getP2().y += diffY;
		}
		base = new Point(e.getX(),e.getY());
		resizeAction.getDp().repaint();
	}
	public void mouseReleased(MouseEvent e) {
		resizeAction.resizedShapes.addAll(resizeAction.getDp().getSelectedShapes());
		resizeAction.diff = new Point(-(start.x - base.x),-(start.y - base.y));
		resizeAction.getDp().removeMouseListener(this);
		resizeAction.getDp().removeMouseMotionListener(this);
		resizeAction.endOfAction();
	}
}
