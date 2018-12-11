import java.lang.Math;
import java.awt.Color;
import java.awt.Graphics;

public class Edge {
	
	public static int weight;
	protected Vertex from = new Vertex();
	protected Vertex to = new Vertex();
	private int x1,x2,y1,y2;
	public Color lineColor = Color.decode("#001ece");
	public Edge() {
		
	}
	public Edge(Vertex a, Vertex b) {
		from.isChosen();
		this.x1 = a.getX();
		this.y1 = a.getY();
		this.x2 = b.getX();
		this.y2 = b.getY();
	}
	public Edge(int x1, int y1, int x2, int y2, Color lineColor) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.lineColor = lineColor;
	}

	
	public int getFromID() {
		return from.getID();
	}
	
	public int getToID() {
		return to.getID();
	}

	public Vertex getFrom() {
		return from;
	}
	
	public Vertex setFrom(int x1,int y1) {
		from.setX(x1);
		from.setY(y1);
		return from;	
	}
	
	public Vertex setTo(int x2, int y2) {
		to.setX(x2-5);
		to.setY(y2+7);
		return to;
	}
	public void move(int x, int y) {
		this.x1 = x;
		this.y1 = y;
	}

	public int getFromX() {
		return x1;
	}
	
	public int getFromY() {
		return y1;
	}
	
	public Vertex getTo() {
		return to;
	}

	public int getToX() {
		return x2;
	}
	
	public int getToY() { 
		return y2;
	}
	
	public void setStartPoint(int x, int y) {
		this.x1 = x;
		this.y1 = y;
	}

	public void setEndPoint(int x, int y) {
		this.x2 = x;
		this.y2 = y;
	}
	
	public String getStartPoint(Vertex x) {
		return "["+x.getX()+","+x.getY()+"]";
	}
	
	public String getEndPoint(Vertex x) {
		return "["+x.getX()+","+x.getY()+"]";
	}
	
	public int getWeight() {
		int xVal = Math.abs(x1-x2);
		int yVal = Math.abs(y1-y2);
		int AB = ((xVal)*(xVal)) + ((yVal)*(yVal));
		weight = (int) Math.sqrt(AB);
		return weight;
	}
	public void setWeight(int w) {
		weight = w;
	} // use  theorem to get weight
	


	public void draw(Graphics g) {
		g.setColor(Color.decode("#001ece"));
		g.drawLine(x1+3, y1+5, x2+3, y2+5);
	}

} //Edge
