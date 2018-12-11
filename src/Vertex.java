import java.awt.*;
import java.awt.event.MouseAdapter;

class Vertex extends MouseAdapter {
	
	// represents the point I'll be plotting
	// I'll make a small circle a dot
	private static boolean chosen = false;
	public int x,y,diameter;
	private Integer iD;
	private Color color;

	public Vertex() {
		
	}
	
	public Vertex(int x, int y, int diameter, Color color, int iD) {
		this.x = x;
		this.y = y;
		this.diameter = diameter; 
		this.color = color;
		this.iD = iD;
		
	}  

	public int getID() {
		return iD;
	}
	
	@Override
	 public boolean equals(Object obj) {
	        if (obj instanceof Vertex) {
	            Vertex pt = (Vertex)obj;
	            return (x == pt.x) && (y == pt.y);
	        }
	        return super.equals(obj);
	    } 
	public boolean isChosen(){
		chosen = true;
//		this.setColor(Color.decode("#15ef02"));
		return chosen;
	} 
	

	public void setID(int index) {
		iD = PointDisplay.index;
	}
	
	public void setChosen(boolean c) {
		if (c==false) this.setColor(Color.decode("#15ef02"));
		chosen = c;
	}
	
	 public void move(int x, int y) {
	        this.x = x;
	        this.y = y;
	 }
	
	public Vertex getVertex() {
        int x;
        int y;
        synchronized (this) {
            x = this.x;
            y = this.y;
        }
        return new Vertex(x, y, diameter, color, iD);
    }

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	} 
	
	public void setX(int n) {
		x = n;
	}
	
	public void setY(int n) {
		y = n;
	}
	
	public int getNum(int i) {
		return i;
	}

	
	public int getDiameter() {
		return diameter;
	}
	
	public Color getColor() {
		return color;
	}
	
	
	public void setColor(Color color) {
		this.color = color;	
	}

	@Override
	public String toString() {
		return getClass().getName() + "["+ x + "," + y + "]";
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.decode("#ce0404"));
		if(chosen==true) g.setColor(Color.decode("#15ef02"));
		g.fillOval(x, y, diameter, diameter);
		
	}
}
