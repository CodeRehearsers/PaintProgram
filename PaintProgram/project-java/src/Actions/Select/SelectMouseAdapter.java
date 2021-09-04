package Actions.Select;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class SelectMouseAdapter extends MouseAdapter{
	private SelectAll selectAction;
	public SelectMouseAdapter(SelectAll selectAction) {
		this.selectAction = selectAction;
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		try {
			selectAction.doAction();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		selectAction.getDp().removeMouseListener(this);
		selectAction.localActionHandler.undo();
		selectAction.endOfAction();
	}
}
