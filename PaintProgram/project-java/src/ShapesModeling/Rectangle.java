package ShapesModeling;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
public class Rectangle extends Shape{
	BasicStroke stroke;
	public Rectangle(Point p1,Point p2,Boolean isFilled,Color frameColor,Color insideColor) {
		super(p1,p2,isFilled,frameColor,insideColor);
		
	}
	public void setStroke(BasicStroke stroke) {
		this.stroke = stroke;
	}
	@Override
	public void draw(Graphics g) {
		Stroke old = ((Graphics2D)g).getStroke();
		Stroke newStroke =new BasicStroke(strokeWidth,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                10.0f, null, 0.0f);
		
		if (stroke!=null) {
			
			((Graphics2D)g).setStroke(stroke);
		}else {
			((Graphics2D)g).setStroke(newStroke);
		}
		
		if(isFilled)
		{	
			g.setColor(insideColor);
	        g.fillRect( Math.min((int)p1.getX(),(int)p2.getX()) , Math.min((int)p1.getY(),(int)p2.getY()) , Math.abs((int)p1.getX()-(int)p2.getX()) , Math.abs((int)p1.getY()-(int)p2.getY()) );
		}
		g.setColor(frameColor);
		g.drawRect( Math.min((int)p1.getX(),(int)p2.getX()) , Math.min((int)p1.getY(),(int)p2.getY()) , Math.abs((int)p1.getX()-(int)p2.getX()) , Math.abs((int)p1.getY()-(int)p2.getY()) );
		((Graphics2D)g).setStroke(old);
	}	
	@Override
	public boolean contains(int x,int y) {
		return x>Math.min((int)p1.getX(),(int)p2.getX()) && 
			   x< Math.min((int)p1.getX(),(int)p2.getX()) +  Math.abs((int)p1.getX()-(int)p2.getX()) &
			   y > Math.min((int)p1.getY(),(int)p2.getY()) &&
			   y< Math.min((int)p1.getY(),(int)p2.getY())  +Math.abs((int)p1.getY()-(int)p2.getY()) ;
	}
	public void drawSelector(Graphics g) {
		Point e = new Point(p2),start = new Point(p1);
		Point p1,p2;
		if (e.getX() < start.x && e.getY() < start.y) {
			p2 = new Point(start);
			p1 = new Point(e.x,e.y);
		}else if(e.getX() < start.x && e.getY()>start.y) {
			p1 = new Point(start.x - (start.x - e.x),start.y);
			p2 = new Point(start.x,e.y);
		}
		else if(e.getX() > start.x && e.getY()<start.y) {
			p1=new Point(start.x,start.y - (start.y - e.y));
			p2 = new Point(e.x,start.y);
		}
		else {
			p1=new Point(start);
			p2=new Point(e.x,e.y);
		}
		
		super.drawSelector(p1,p2, g);
	}
	
	public static Shape newInstance() {
		return (Shape) new Rectangle(new Point(0,0),new Point(0,0),false,Color.black,Color.black);
	}
}
