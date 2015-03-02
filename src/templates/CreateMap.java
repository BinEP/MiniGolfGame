package templates;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CreateMap {

	public ArrayList<Point> points = new ArrayList<Point>();
	public Polygon shape = new Polygon();

	public Point hole;
	public Point start;
	
	public ArrayList<Polygon> shapes = new ArrayList<Polygon>();
	
	public static void main(String[] args) {
		new CreateMap();
	}

	public CreateMap() {
		// TODO Auto-generated constructor stub

		JFrame frame = new JFrame("Map Creator");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		frame.setResizable(false);
		frame.setAlwaysOnTop(true);

		Panel game = new Panel();

		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		
		JButton newShape = new JButton("New Shape");
		newShape.setActionCommand("NewShape");
		JButton resetButton = new JButton("Reset");
		resetButton.setActionCommand("Reset");
		JButton doneButton = new JButton("Done");
		doneButton.setActionCommand("Done");
		JButton holeButton = new JButton("Hole");
		holeButton.setActionCommand("Hole");
		JButton startButton = new JButton("Start");
		startButton.setActionCommand("Start");
		
		newShape.addActionListener(game);
		resetButton.addActionListener(game);
		doneButton.addActionListener(game);
		holeButton.addActionListener(game);
		startButton.addActionListener(game);
		
		buttons.add(newShape);
		buttons.add(doneButton);
		buttons.add(resetButton);
		buttons.add(startButton);
		buttons.add(holeButton);

		frame.add(buttons, BorderLayout.NORTH);
		frame.add(game, BorderLayout.CENTER);

		frame.setSize(500, 552);

		frame.setVisible(true);

	}

	private class Panel extends JPanel implements MouseListener, ActionListener {

		public Panel() {

			setFocusable(true);
			addMouseListener(this);
			System.out.println("Shape 1 points");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if ("NewShape".equals(e.getActionCommand())) {
				points.clear();
				shapes.add(shape);
				shape = new Polygon();
				System.out.println("Shape " + (shapes.size() + 1)  + " Points");
			} else if ("Reset".equals(e.getActionCommand())) {
				points.clear();
				shapes.clear();
				shape = new Polygon();
				System.out.println("Shape 1 Points");
			} else if ("Done".equals(e.getActionCommand())) {
				getFormatString();
			} else if ("Start".equals(e.getActionCommand())) {
				start = points.get(points.size() - 1);
				shape = new Polygon();
				
			} else if ("Hole".equals(e.getActionCommand())) {
				
				hole = points.get(points.size() - 1);
				shape = new Polygon();
			}
			repaint();
		}
		
		public String getFormatString() {
			
			shapes.add(shape);
			
			ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> y = new ArrayList<ArrayList<Integer>>();
			
			ArrayList<Integer> xp = new ArrayList<Integer>();
			ArrayList<Integer> yp = new ArrayList<Integer>();

			int j = 1;
			for (Polygon poly : shapes) {
//				System.out.println("Shape Points");
				for (int i = 0; i < poly.xpoints.length; i++) {
					xp.add(poly.xpoints[i]);
					yp.add(poly.ypoints[i]);
				}
				
//				System.out.println("Print points");
				System.out.print("int[] x" + j + " = {");
				
				for (Integer i : xp) {
					System.out.print(i + ", ");
				}
				System.out.print("};");
				
				System.out.println();
				
				
				System.out.print("int[] y" + j + " = {");
				for (Integer i : yp) {
					System.out.print(i + ", ");
				}
				System.out.print("};");
				
				System.out.println();
				System.out.println("addSurface(x" + j + ", y" + j + ");");
				System.out.println("addBarrier(x" + j + ", y" + j + ");");
				System.out.println();
				System.out.println("new Point(" + hole.x + ", " + hole.y + ");");
				System.out.println("new Point(" + start.x + ", " + start.y + ");");
				x.add(xp);
				y.add(yp);
				xp.clear();
				yp.clear();
				j++;
			}
			
			return "";
		}

		public void paintComponent(Graphics g2) {

			Graphics2D g = (Graphics2D) g2;

			super.paintComponent(g);

			g.drawPolygon(shape);

			g.drawLine(0, 0, 500, 0);

			for (Polygon p : shapes) {

				g.drawPolygon(p);
			}
			
			Graphics2D g3 = (Graphics2D) g.create();
			if (start != null) {
				g.fillOval(start.x, start.y, 10, 10);
			}
			g3.setStroke(new BasicStroke(4));
			if (hole != null) {
				g3.drawOval(hole.x, hole.y, 20, 20);
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Point p = e.getPoint();
			points.add(p);
			shape.addPoint(p.x, p.y);

//			printString(points);
			System.out.println("[" + p.x + ", " + p.y + "]");

			repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void printString(ArrayList<Point> points) {
			for (Point p : points) {

				System.out.println("[" + p.x + ", " + p.y + "]");

			}
		}

	}

}
