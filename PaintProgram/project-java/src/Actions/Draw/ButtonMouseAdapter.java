package Actions.Draw;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Actions.ActionHandler;
import Display.DrawPanel;
import ShapesModeling.Shape;

public class ButtonMouseAdapter extends MouseAdapter {
	Class<? extends Shape> type;
	ActionHandler handler;
	DrawPanel dp;
	Shape shape;
	public ButtonMouseAdapter(ActionHandler handler,DrawPanel dp,Class<? extends Shape> type) {
		this.dp = dp;
		this.handler = handler;
		this.type = type;
		
	}
	public void mousePressed(MouseEvent e) {
		Draw draw;
		try {
			draw = new Draw(handler,dp,type);
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}
		try {
			draw.doAction();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
