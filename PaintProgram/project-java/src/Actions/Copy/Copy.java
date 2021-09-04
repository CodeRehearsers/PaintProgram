package Actions.Copy;

import java.awt.Color;
import java.util.ArrayList;
import Actions.ActionHandler;
import Display.DrawPanel;
import ShapesModeling.Shape;

public class Copy extends Actions.Select.SelectAll{
	
	public Copy(ActionHandler handler,DrawPanel dp) throws Exception {
		super(handler,dp);
		selector.setFrameColor(Color.blue);
	}
	@Override
	public void doAction() throws Exception {
		super.doAction();
		for (Shape shape : dp.getShapes()) 
			if (selector.contains((int)shape.getP1().getX(),(int)shape.getP1().getY())) {
				System.out.println("FOUND => " + shape.getClass().getSimpleName());
				selectedShapes.add(shape);
				dp.addShapeToCopyList(shape);
			}
	}
	public ArrayList<Shape> getSelected(){
		return selectedShapes;
	}
	@Override
	public void unDoAction() {
		for(Shape shape : selectedShapes)
			dp.removeShapeFromCopyList(shape);
		super.unDoAction();
		dp.repaint();
	}
	@Override
	public void redoAction() {
		for(Shape shape : selectedShapes)
			dp.addShapeToCopyList(shape);
	}
}
