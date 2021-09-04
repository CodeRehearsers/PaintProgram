package Actions.Draw;


import Actions.Action;
import Actions.ActionHandler;
import Display.DrawPanel;
import ShapesModeling.Shape;

public class Draw extends Action {
	Shape shape;
	Class<? extends Shape> type;
	boolean obeyDrawPanel = true;
	DrawMouseAdapter mouseAdapter;
	public Draw(ActionHandler handler,DrawPanel dp,Shape shape) throws Exception {
		super(handler,dp);
		this.shape = shape;
		mouseAdapter = new DrawMouseAdapter(this);
	}
	public Draw(ActionHandler handler,DrawPanel dp,Shape shape,boolean obeyDrawPanel) throws Exception {
		super(handler,dp);
		this.shape = shape;
		this.obeyDrawPanel = obeyDrawPanel;
		mouseAdapter = new DrawMouseAdapter(this);
	}
	public Draw(ActionHandler handler,DrawPanel dp,Class<? extends Shape> type) throws Exception {
		super(handler,dp);
		shape = (Shape) type.getDeclaredMethod("newInstance").invoke(null);
		mouseAdapter = new DrawMouseAdapter(this);
	}
	@Override
	public void doAction() throws Exception {
		super.doAction();
		getDp().addMouseListener(mouseAdapter);
		getDp().addMouseMotionListener(mouseAdapter);
	}
	@Override
	public void unDoAction() {
		getDp().removeShape(shape);
		getDp().repaint();
		super.unDoAction();
	}
	@Override
	public void redoAction() {
		getDp().addShape(shape);
		getDp().repaint();
	}
}
