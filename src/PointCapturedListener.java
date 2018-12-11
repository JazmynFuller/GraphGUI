import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;



class PointCapturedListener extends MouseInputAdapter {
	public Edge newEdge;
	Vertex a,b;
	public int clicks = 0;
	int x1,y1;
	PointDisplay panel;
	
    public PointCapturedListener(PointDisplay panel) {
    	this.panel = panel;
	}
    
  
   	@Override
	public void mousePressed(MouseEvent e) {
		if(PointDisplay.isEChosen() || PointDisplay.moveChosen()) {
			x1 = e.getX();
			y1 = e.getY();
			
			if((clicks==0)) {
				for(Vertex n : PointDisplay.vertices) {
					if(((x1>=n.getX()-10)&&(x1<=n.getX()+10)) && ((y1>=n.getY()-10))&&(y1<=n.getY()+10)) {
							a = n;
							clicks++;
							System.out.println("A: "+a.toString());
					}
				}
			} else {
				for(Vertex x : PointDisplay.vertices) {
					if(((x1>=x.getX()-10)&&(x1<=x.getX()+10)) && ((y1>=x.getY()-10))&&(y1<=x.getY()+10)) {
						b = x;
						panel.addEdge(a,b);
						System.out.println("B: "+b.toString());
						x1 = 0;
						y1 = 0;
						clicks=0;
					}
				}
			}
		
		} // isEChosen
	}
} // PointCaptured Listener

