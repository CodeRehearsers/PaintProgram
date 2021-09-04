package Actions.Resize;

import java.awt.Point;
import java.util.ArrayList;

import Actions.Action;
import Actions.ActionHandler;
import Display.DrawPanel;
import ShapesModeling.Shape;

public class Resize extends Action {
	ResizeMouseAdapter mouseAdapter;
	ArrayList<Shape> resizedShapes = new ArrayList<>();
	Point diff;
	public Resize(ActionHandler handler,DrawPanel dp) throws Exception {
		super(handler,dp);
		mouseAdapter = new ResizeMouseAdapter(this);
	}

	@Override
	public void doAction() throws Exception{
		super.doAction();
		dp.addMouseListener(mouseAdapter);
		dp.addMouseMotionListener(mouseAdapter);
	}

	@Override
	public void unDoAction() {
		for(Shape shape : resizedShapes) {
			shape.getP2().x -= diff.x;
			shape.getP2().y -= diff.y;
		}
		dp.repaint();
		super.unDoAction();
	}
	
	@Override
	public void redoAction() {
		for(Shape shape : resizedShapes) {
			shape.getP2().x += diff.x;
			shape.getP2().y += diff.y;
		}
		dp.repaint();
	}

}
