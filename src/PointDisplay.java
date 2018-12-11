import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;



class PointDisplay extends JPanel{
	
	// To do: make an undirected graph
	// First I need to have the vertices stored in a list : done
	// Then I need to find a way to connect two dots using an edge
	// all this needs to happen here 
			private Vertex chosen;
			int size = 0;
			int  x1,y1,x2,y2;
			static int labelID = 0;
			static int index = 0;
			public static LinkedList<Vertex> adjHelper[];
			public static ArrayList<Vertex> vertices = new ArrayList<Vertex>(); 
			public static LinkedList<Edge> edges = new LinkedList<Edge>();
			public static ArrayList<Integer> labels = new ArrayList<Integer>();
			public static ArrayList<JLabel> labelDisplay = new ArrayList<JLabel>();
			ArrayList<LinkedList<Integer>> adjList = new ArrayList<LinkedList<Integer>>();
		
			public PointDisplay() {
				this.addMouseListener(new PointClickedListener(this));
				this.addMouseListener(new PointCapturedListener(this));
				this.addMouseListener(new moveVertexListener());
			}
			
			
			public static boolean isVChosen() {
				return GraphGUI.isVChosen;
			}
			
			public static boolean isEChosen() {
				
				return GraphGUI.isEChosen;
			}
			
			public static boolean moveChosen() {
				return GraphGUI.moveIsChosen;
			}
			
			public static boolean tFieldChosen() {
				return GraphGUI.textFieldChosen;
			}
			 
			public void addVertex(Vertex v) {
				vertices.add(v); 
				this.repaint();
				System.out.println(v.toString());
				System.out.println("Vertex Num:" +v.getID());
				System.out.println("Size of ArrayList: "+vertices.size());
				store();
				//store(v.getID());
				System.out.println();
				size = vertices.size();
				System.out.println("Size of the adjList: "+adjList.size());
				index++;
				
			}
			
			public void store() {
					adjList.add(new LinkedList<Integer>());
			}

			public void addEdge(Vertex x, Vertex y) {
				int a1 = x.getID();
				int b1 = y.getID();
				System.out.println(x+" This is the ID: "+a1);
				System.out.println(y+" This is the ID: "+b1);
				
				for(Vertex looking : vertices) {
					if(looking==x) {
						a1 = looking.getID();
						x = looking;
					}
				}
				
				for(Vertex looking : vertices) {
					if(looking==y) {
						b1 = looking.getID();
						y = looking;
					}
				}
				System.out.println("hehehehe: "+y.toString());
				adjList.get(a1).add(b1);
				adjList.get(b1).add(a1);
				// creates the connection
				System.out.println("\nAdjacency List:");
		        for(int i=0; i<adjList.size(); i++){
		            System.out.println(i + ": " + adjList.get(i));
		        } // tester
				Edge newE = new Edge(x.getX(),x.getY(),y.getX(),y.getY(),Color.decode("#001ece"));
				labels.add(newE.getWeight());
				System.out.println("Weight of Edge: "+newE.getWeight());
				System.out.println("How many Labels are there: "+ labels.size());
				
				drawEdge(newE);
				
				
			} 
			
			
			
			class moveVertexListener extends MouseAdapter{
				int newX,newY, oldX, oldY;
				Vertex vert;
				int clicks = 0;
				Vertex a;
				@Override
				public void mouseClicked(MouseEvent e) {
					oldX= e.getX();
					oldY = e.getY();
					if(moveChosen()) {
						if(clicks==0) {
							for(Vertex n : vertices) {
								if(((n.getX()>=oldX-10) && (n.getX()<=oldX+10)) && ((n.getY()>=oldY-10)&&(n.getY()<=oldY+10)) && (clicks==0)) {
									n.isChosen();
									vert = n;
									clicks++;
									repaint();
									System.out.println("Clicks for Move Vertex: "+clicks);
								}		
							}
						}
						else if(clicks==1) {
							vert.setX(e.getX());
							vert.setY(e.getY());
							clicks=0;
							vert.setChosen(false);
							repaint();
						}
					}
				}
			} // moveVertexListener
			
			public void overrideWeight(String a) {
				
			}
			
			
			public void drawEdge(Edge x) {
				edges.add(x);
				this.repaint();
			}

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
					for(Vertex v : vertices) {
						v.draw(g);
					}
					for(Edge e : edges) {
						e.draw(g);
					}

					for (int x=0; x<labels.size(); x++) {
						int j = labels.get(x);
						String a = String.valueOf(j);
						g.drawString(a, ((edges.get(x).getFromX()+edges.get(x).getToX())/2), ((edges.get(x).getFromY()+(edges.get(x).getToY()))/2)-15);
					} // prints l
					
			}
			

	}	

