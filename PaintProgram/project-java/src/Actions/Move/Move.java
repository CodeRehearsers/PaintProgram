package Actions.Move;

import java.awt.Point;
import java.util.ArrayList;

import Actions.Action;
import Actions.ActionHandler;
import Display.DrawPanel;
import ShapesModeling.Shape;

public class Move extends Action {
	MoveMouseAdapter mouseAdapter;
	ArrayList<Shape> movedShapes = new ArrayList<>();
	Point diff;
	public Move(ActionHandler handler,DrawPanel dp) throws Exception {
		super(handler,dp);
		mouseAdapter = new MoveMouseAdapter(this);
	}

	@Override
	public void doAction() throws Exception{
		super.doAction();
		dp.addMouseListener(mouseAdapter);
		dp.addMouseMotionListener(mouseAdapter);
	}

	@Override
	public void unDoAction() {
		for(Shape shape : movedShapes) {
			shape.getP1().x -= diff.x;
			shape.getP1().y -= diff.y;
			shape.getP2().x -= diff.x;
			shape.getP2().y -= diff.y;
		}
		super.unDoAction();
		dp.repaint();
	}
	
	@Override
	public void redoAction() {
		for(Shape shape : movedShapes) {
			shape.getP1().x += diff.x;
			shape.getP1().y += diff.y;
			shape.getP2().x += diff.x;
			shape.getP2().y += diff.y;
		}
		dp.repaint();
	}

}
