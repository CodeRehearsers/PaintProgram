package Actions.Select;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import Actions.Action;
import Actions.ActionHandler;
import Actions.Draw.Draw;
import Display.DrawPanel;
import ShapesModeling.Rectangle;
import ShapesModeling.Shape;

public class SelectAll extends Action{
	protected ActionHandler localActionHandler = new ActionHandler();
	protected Rectangle selector;
	protected Draw selectorDraw;
	protected SelectMouseAdapter mouseAdapter;
	protected ArrayList<Shape> selectedShapes = new ArrayList<>();
	public SelectAll(ActionHandler handler,DrawPanel dp) throws Exception {
		super(handler,dp);
		mouseAdapter = new SelectMouseAdapter(this);
		Point start = new Point(0,0);
		selector = new Rectangle(start,start,false,Color.green,Color.black);
		float dash[] = {10.0f};
		selector.setStroke(new BasicStroke(1.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                10.0f, dash, 0.0f));
		selectorDraw = new Draw(localActionHandler,dp,selector,false);
	}
	public void init() {
		try {
			selectorDraw.doAction();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dp.addMouseListener(mouseAdapter);
	}
	@Override
	public void doAction() throws Exception {
		super.doAction();
		for (Shape shape : dp.getShapes()) 
			if (selector.contains((int)shape.getP1().getX(),(int)shape.getP1().getY())
					|| selector.contains((int)shape.getP2().getX(),(int)shape.getP2().getY())) {
				System.out.println("FOUND => " + shape.getClass().getSimpleName());
				selectedShapes.add(shape);
				dp.selectShape(shape);
			}
	}
	public ArrayList<Shape> getSelected(){
		return selectedShapes;
	}
	@Override
	public void unDoAction() {
		for(Shape shape : selectedShapes)
			dp.unSelectShape(shape);
		super.unDoAction();
		dp.repaint();
	}
	@Override
	public void redoAction() {
		for(Shape shape : selectedShapes)
			dp.selectShape(shape);
		dp.repaint();
	}
}
