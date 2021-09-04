package Actions.Delete;

import java.awt.Color;
import java.util.ArrayList;
import Actions.ActionHandler;
import Display.DrawPanel;
import ShapesModeling.Shape;

public class MarkDelete extends Actions.Select.SelectAll{
	
	public MarkDelete(ActionHandler handler,DrawPanel dp) throws Exception {
		super(handler,dp);
		selector.setFrameColor(Color.red);
	}
	@Override
	public void doAction() throws Exception {
		super.doAction();
		for (Shape shape : dp.getShapes()) 
			if (selector.contains((int)shape.getP1().getX(),(int)shape.getP1().getY())) {
				selectedShapes.add(shape);
				dp.addShapeToDeleteList(shape);
			}
	}
	public ArrayList<Shape> getSelected(){
		return selectedShapes;
	}
	@Override
	public void unDoAction() {
		dp.removeShapesFromDeleteList(selectedShapes);
		super.unDoAction();
		dp.repaint();
	}
	@Override
	public void redoAction() {
		for(Shape shape:selectedShapes) {
			dp.addShapeToDeleteList(shape);
		}
	}
}
