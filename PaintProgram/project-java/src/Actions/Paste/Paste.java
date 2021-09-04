package Actions.Paste;

import java.awt.Point;
import java.util.ArrayList;

import Actions.Action;
import Actions.ActionHandler;
import Display.DrawPanel;
import ShapesModeling.Shape;

public class Paste extends Action {
	Point diff;
	PasteMouseAdapter mouseAdapter;
	ArrayList<Shape> clones = new ArrayList<>();
	public Paste(ActionHandler handler, DrawPanel dp) throws Exception {
		super(handler, dp);
		mouseAdapter = new PasteMouseAdapter(this);
	}
	public void init() {
		dp.addMouseListener(mouseAdapter);
	}
	@Override 
	public void doAction() throws Exception{
		super.doAction();
		Shape topLeftShape =  dp.getToCopyShapes().get(0);
		for(Shape shape : dp.getToCopyShapes()) 
			if (shape.getP1().y < topLeftShape.getP1().y) 
				topLeftShape = shape;
			else if(shape.getP1().y == topLeftShape.getP1().y) 
				if (shape.getP1().x < topLeftShape.getP1().x)
					topLeftShape = shape;
		int diffY = - (topLeftShape.getP1().y - mouseAdapter.pasteCoordinates.y ) ;
		int diffX = - (topLeftShape.getP1().x - mouseAdapter.pasteCoordinates.x ) ;
		for(Shape shape:dp.getToCopyShapes()) {
			Shape copy = shape.copyHere(shape.getP1().x + diffX,shape.getP1().y + diffY);
			dp.addShape(copy);
			dp.unSelectShape(shape);
			clones.add(copy);
		}
		dp.getToCopyShapes().clear();
		dp.repaint();
	}
	@Override
	public void unDoAction() {
		for(Shape shape : clones)
			dp.removeShape(shape);
		dp.repaint();
		super.unDoAction();
	}
	@Override
	public void redoAction() {
		for(Shape shape : clones)
			dp.addShape(shape);
		dp.repaint();
	}
	
}
