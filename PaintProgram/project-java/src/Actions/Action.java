package Actions;

import Actions.ActionHandler.Status;
import Display.DrawPanel;

public abstract class Action {
	protected ActionHandler handler;
	protected DrawPanel dp;
	protected boolean ended = false;
	public Action(ActionHandler handler,DrawPanel dp) throws Exception{
		if (handler.isBusy())
			throw new Exception("handler BUSY!");
		
			
		this.handler = handler;
		this.dp = dp;
		System.out.println(this.getClass().getSimpleName() + " initialized !");
		handler.setStatus(Status.BUSY);
		
	}
	public void doAction() throws Exception {
		if (ended)
			throw new Exception("Action can not be done, it ended !");
		System.out.println(this.getClass().getSimpleName() + " invoked !");
		handler.actions.push(this);
	}
	public void unDoAction() {
		System.out.println(this.getClass().getSimpleName()+" --> undo ");
		handler.trash.push(this);
	}
	public void redoAction() {
		try {
			doAction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void endOfAction() {
		ended = true;
		handler.setStatus(Status.FREE);
	}
	
	public DrawPanel getDp() {
		return dp;
	}
}
