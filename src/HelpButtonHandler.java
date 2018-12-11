import javax.swing.JFrame;
import javax.swing.JLabel;

class HelpButtonHandler  {
	// Instructions on how to run my GUI... I need to write
	String s = "This is how you run my GUI";
	JFrame help = new JFrame("Help");
	JLabel instructions = new JLabel(s);

	
	public HelpButtonHandler() {
			help.setSize(400,400);
			help.setLocation(450,100);
			instructions.setHorizontalAlignment(JLabel.CENTER);
			help.add(instructions);
			//help.setVisible(true);
	}
	
	public void setVisible(boolean b) {
		help.setVisible(b); 
	}
	

}
