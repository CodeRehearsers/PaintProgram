package Actions.Paste;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class PasteMouseAdapter extends MouseAdapter{
	private Paste pasteAction;
	Point pasteCoordinates;
	public PasteMouseAdapter(Paste pasteAction) {
		this.pasteAction = pasteAction;
	}
	@Override
	public void mouseReleased(MouseEvent e) {

		pasteCoordinates = new Point(e.getX(),e.getY());
		try {
			pasteAction.doAction();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		pasteAction.getDp().removeMouseListener(this);
		pasteAction.endOfAction();
	}
}
