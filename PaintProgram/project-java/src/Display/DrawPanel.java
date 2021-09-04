package Display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;
import ShapesModeling.Shape;

public class DrawPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	protected ArrayList<Shape> shapes = new ArrayList<Shape>();
	protected Shape selected;
	protected MouseListener selectHandler;
	protected ArrayList<Shape> selectedShapes = new ArrayList<>();
	protected ArrayList<Shape> toCopyShapes = new ArrayList<>();
	protected ArrayList<Shape> toDeleteShapes = new ArrayList<>();
	int strokeWidth = 1;
	Color fillColor = Color.cyan;
	Color strokeColor = Color.black;
	boolean isFilled=false;
	public DrawPanel() {
		super();
		selectHandler = new MouseListener(this);
		this.addMouseListener(selectHandler);
	}
	public void removeShapeFromCopyList(Shape shape) {
		toCopyShapes.remove(shape);
	}
	public void removeShapesFromCopyList(ArrayList<Shape> shapes) {
		toCopyShapes.removeAll(shapes);
	}
	public void setStrokeWidth(int strokeWidth) {
		this.strokeWidth = strokeWidth;
	}
	public int getStrokeWidth() {
		return strokeWidth ;
	}
	public boolean getIsFilled() {
		return isFilled;
	}
	public void setIsFilled(boolean isFilled) {
		this.isFilled = isFilled ;
	}
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	public Color getFillColor() {
		return fillColor ;
	}
	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}
	public Color getStrokeColor() {
		return strokeColor ;
	}
	public void addShapeToCopyList(Shape shape) {
		toCopyShapes.add(shape);
	}
	public void removeShapeFromDeleteList(Shape shape) {
		toDeleteShapes.remove(shape);
	}
	public void removeShapesFromDeleteList(ArrayList<Shape> shapes) {
		toDeleteShapes.removeAll(shapes);
	}
	
	public void addShapeToDeleteList(Shape shape) {
		toDeleteShapes.add(shape);
	}
	
	public ArrayList<Shape> getToCopyShapes() {
		return toCopyShapes;
	}
	
	public ArrayList<Shape> getToDeleteShapes() {
		return toDeleteShapes;
	}
	
	public void addShape(Shape c) {
		shapes.add(c);
		this.repaint();
	}
	
	public void removeShape(Shape shape) {
		shapes.remove(shape);
	}
	
	public void selectShape(Shape shape) {
		if (shape.isSelected())
			return;
		selectedShapes.add(shape);
		shape.select();
	}
	
	public void unSelectShape(Shape shape) {
		if (!shape.isSelected())
			return;
		selectedShapes.remove(shape);
		shape.unSelect();
	}
	public ArrayList<Shape> getSelectedShapes() {
		return selectedShapes;
	}
	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Iterator it = shapes.iterator();
		while(it.hasNext()) {
			Shape shape = (Shape)it.next();
			if (shape.isSelected()){
				shape.setSelectorColor(Color.green);
				shape.setMargin(15);
				shape.drawSelector(g);
			}
			shape.draw(g);
		}
		for(Shape shape : toCopyShapes) {
			shape.setMargin(9);
			shape.setSelectorColor(Color.blue);
			shape.drawSelector(g);
		}
		for(Shape shape : toDeleteShapes) {
			shape.setMargin(21);
			shape.setSelectorColor(Color.red);
			shape.drawSelector(g);
		}	
	}
}

class MouseListener extends MouseAdapter {
	DrawPanel dp;

	public MouseListener(DrawPanel dp) {
		super();
		this.dp = dp;
	}
	public void mousePressed(MouseEvent e) {
		for (Shape shape : dp.shapes) {
			if (shape.contains(e.getX(), e.getY())) {
				dp.selected = shape;
				System.out.println(shape.getP1() + " // " + shape.getP2());
				break;
			}
		}
	}

}
