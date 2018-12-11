import java.awt.*;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.event.*;
import java.text.NumberFormat;

@SuppressWarnings("serial") 
class GraphGUI extends JFrame implements ActionListener {
	
	
	JFrame frame = new JFrame();
	JPanel west = new JPanel(new GridLayout (10,1));
	JPanel plotArea = new JPanel(new BorderLayout());
	public static boolean vertexMoved = false;
	public static boolean isVChosen = false;
	public static boolean isEChosen = false;
	public static boolean moveIsChosen = false;
	public static boolean textFieldChosen = false;
	JRadioButton b1 = new JRadioButton("Add Vertex", false);
	JRadioButton b2 = new JRadioButton("Add Edge", false);
	JRadioButton b3 = new JRadioButton("Move Vertex", false);
	JRadioButton b4 = new JRadioButton("Shortest Path", false);
	JRadioButton b5 = new JRadioButton("Change weight to: ");
	
	NumberFormat format = NumberFormat.getIntegerInstance();
	NumberFormatter numformatter = new NumberFormatter(format);
	
	JFormattedTextField write = new JFormattedTextField(numformatter);
	public String changeW = write.toString();
	JButton b6 = new JButton("Add All Edges");
	JButton b7 = new JButton("Random Weights");
	JButton b8 = new JButton("Minimal Spanning Tree");
	JButton b9 = new JButton("Help");
	HelpButtonHandler help = new HelpButtonHandler();
	ButtonGroup radGroup;
	PointDisplay p = new PointDisplay();
	



	public GraphGUI(String title, int h, int w) {
		west.setBackground(Color.decode("#eff2ed"));
		// restrict input in text field to integers only
		numformatter.setMinimum(1);
		numformatter.setAllowsInvalid(false);
		
		
		frame.setResizable(false);
		frame.setTitle(title);
		frame.setSize(w, h);
		frame.setBackground(Color.BLACK);
		frame.setLocation(200, 100);
		frame.add(west, BorderLayout.WEST);
		frame.add(plotArea, BorderLayout.CENTER);
		plotArea.add(p); // adds graph display area
		
		
		// adds buttons to grid
		west.add(b1); // Add Vertex
		west.add(b2); // Add Edge
		west.add(b3); // Move Vertex
		west.add(b4); // Shortest Path
		west.add(b5); // Change weight to
		west.add(write);
		write.setEnabled(false);
		write.setEditable(false);
		west.add(b6); // Add All edges
		west.add(b7); // Random Weight
		west.add(b8); // Minimal Spanning Tree
		west.add(b9); // Help
		
	
		
		// Action Listeners for each button to perform required tasks
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		

		// lets radio buttons know when each other is checked, so one is always checked at a time
		radGroup = new ButtonGroup();
		radGroup.add(b1);
		radGroup.add(b2);
		radGroup.add(b3);
		radGroup.add(b4);
		radGroup.add(b5);

		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		if(event==b1) {
			textFieldChosen = false;
			moveIsChosen = false;
			isVChosen = true;
			isEChosen = false;
			write.setEditable(false);
		}

		if(event==b2) {
			textFieldChosen = false;
			isEChosen = true;
			isVChosen = false;
			moveIsChosen = false;
			write.setEditable(false);
		}
		
		if(event==b3) {
			textFieldChosen = false;
			moveIsChosen = true;
			isEChosen = true;
			isVChosen = false;
			write.setText(null);
			write.setEditable(false);
		}
		
		if(event==b4) {
			plotArea.remove(p);
			write.setEditable(false);
		}
		
		if(event==b5) {
			textFieldChosen = true;
			plotArea.remove(p);
			write.setEditable(true);
			write.setEnabled(true);
		}
		
		if(event==b6) {
			plotArea.remove(p);
			write.setEditable(false);
			radGroup.clearSelection();
		}
		
		if(event==b7) {
			plotArea.remove(p);
			write.setEditable(false);
			radGroup.clearSelection();
		}
		
		if(event==b8) {
			plotArea.remove(p);
			write.setEditable(false);
			radGroup.clearSelection();
		}
		
		if(event==b9) {
			plotArea.remove(p);
			radGroup.clearSelection();
			help.setVisible(true);
			write.setEditable(false);
			write.setEnabled(false);	
		} // b9 

		
		
	}

}// GraphGUI Class
