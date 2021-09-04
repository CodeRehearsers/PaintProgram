package Actions;

import java.util.Stack;

public class ActionHandler {
	public Stack<Action> trash = new Stack<>();
	public Stack<Action> actions = new Stack<>();
	protected Status status = Status.FREE;
	public void redo() {
		if (trash.empty()) {
			System.out.println("No REDO");
			return;
		}
		Action myAction = trash.pop();
		myAction.ended  = false;
		actions.push(myAction);
		myAction.redoAction();
	}
	public void undo() {
		if (actions.empty()) {
			System.out.println("No UNDO");
			return;
		}
		Action myAction = actions.pop();
		myAction.unDoAction();
	}
	public boolean isBusy() {
		return status == Status.BUSY ? true : false;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public enum Status{
		BUSY,FREE
	}
}
