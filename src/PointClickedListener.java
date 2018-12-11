import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class PointClickedListener extends MouseAdapter{
	protected PointDisplay panel;

	public PointClickedListener(PointDisplay panel) {
		this.panel = panel;
	}  
	
	@Override 
	public void mouseClicked(MouseEvent e) {
			if(PointDisplay.isVChosen()) {
				Vertex a = new Vertex(e.getX()-5, e.getY()-7, 10, Color.decode("#ce0000"), PointDisplay.index);
						panel.addVertex(a);
			}			
	} 
  
}
