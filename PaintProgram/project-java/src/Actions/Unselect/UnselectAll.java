package Actions.Unselect;

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

public class UnselectAll extends Action{
	ActionHandler localActionHandler = new ActionHandler();
	Rectangle selector;
	Draw selectorDraw;
	UnselectMouseAdapter mouseAdapter;
	ArrayList<Shape> UnselectedShapes = new ArrayList<>();
	public UnselectAll(ActionHandler handler,DrawPanel dp) throws Exception {
		super(handler,dp);
		mouseAdapter = new UnselectMouseAdapter(this);
		Point start = new Point(0,0);
		selector = new Rectangle(start,start,false,Color.red,Color.black);
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
			if (selector.contains((int)shape.getP1().getX(),(int)shape.getP1().getY())) {
				System.out.println("FOUND => " + shape.getClass().getSimpleName());
				UnselectedShapes.add(shape);
				dp.removeShapeFromCopyList(shape);
				dp.removeShapeFromDeleteList(shape);
				dp.unSelectShape(shape);
			}
	}
	public ArrayList<Shape> getSelected(){
		return UnselectedShapes;
	}
	@Override
	public void unDoAction() {
		for(Shape shape : UnselectedShapes)
			dp.selectShape(shape);
		dp.repaint();
		super.unDoAction();
	}
	@Override
	public void redoAction() {
		for(Shape shape : UnselectedShapes)
			dp.unSelectShape(shape);
	}
}
