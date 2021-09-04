package Actions.Delete;


import java.util.ArrayList;
import Actions.Action;
import Actions.ActionHandler;
import Display.DrawPanel;
import ShapesModeling.Shape;

public class Delete extends Action {
	ArrayList<Shape> deleted = new ArrayList<>();
	public Delete(ActionHandler handler, DrawPanel dp) throws Exception {
		super(handler, dp);
		
	}
	@Override 
	public void doAction() throws Exception{
		super.doAction();
		deleted = new ArrayList<>(dp.getToDeleteShapes());
		dp.getShapes().removeAll(deleted);
		dp.getToDeleteShapes().clear();
		for(Shape shape: deleted) 
			dp.unSelectShape(shape);
		
		dp.getToCopyShapes().removeAll(deleted);
		dp.repaint();
		endOfAction();
	}
	@Override
	public void unDoAction() {
		for(Shape shape : deleted)
			dp.addShape(shape);
		dp.repaint();
		super.unDoAction();
	}
	@Override
	public void redoAction() {
		for(Shape shape : deleted)
			dp.removeShape(shape);
		dp.repaint();
	}
	
}
