package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Setup {

	public static void main(String[] args) {

		Setup s = new Setup();
		JLabel message = new JLabel("Let's Play Mini Golf!", JLabel.CENTER);

		JPanel players = createRow("How many players?", "1", 1, true);

		JPanel p1 = createRow("Name?", "Player", 5, true);
		JPanel p2 = createRow("Name?", 5);
		JPanel p3 = createRow("Name?", 5);
		JPanel p4 = createRow("Name?", 5);
		
		p1.setEnabled(true);
		p2.setEnabled(false);
		p3.setEnabled(false);
		p4.setEnabled(false);

		JPanel numberOfHoles = createRow("Number of holes to play?", 2);
/*
		ActionListener playerNumListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				p1.setEnabled(false);
				p2.setEnabled(false);
				p3.setEnabled(false);
				p4.setEnabled(false);

				switch (((JTextField) players.getComponent(2)).getText()) {

				case "4":
					p4.setEnabled(true);

				case "3":
					p3.setEnabled(true);

				case "2":
					p2.setEnabled(true);

				default:
					p1.setEnabled(true);

				}

			}
		};

		ActionListener holeNumListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt(((JTextField) numberOfHoles.getComponent(2)).getText()) > 6) {
					((JTextField) numberOfHoles.getComponent(2)).setText("6");

				}

			}

		};

		((JTextField)players.getComponent(2)).addActionListener(playerNumListener);
		((JTextField) numberOfHoles.getComponent(2)).addActionListener(holeNumListener);
*/
		JPanel inputPanel = new JPanel();

		inputPanel.setLayout(new GridLayout(0, 1, 5, 5));
		inputPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK, 2),
				BorderFactory.createEmptyBorder(6, 6, 6, 6)));

		inputPanel.add(message);

		inputPanel.add(players);

		inputPanel.add(p1);

		inputPanel.add(p2);

		inputPanel.add(p3);

		inputPanel.add(p4);

//		while (true) {

			int action = JOptionPane.showConfirmDialog(null, inputPanel,
					"Mini Golf", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			if (action != JOptionPane.OK_OPTION)
				return;
			
			JFrame frame = new JFrame("Mini Golf!");

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(new BorderLayout());
			
			//so doesn't flicker
			frame.setResizable(false);
			frame.setAlwaysOnTop(true);
			
//			frame.setAlwaysOnTop(true);

			GamePanel game = new GamePanel(Integer.parseInt(((JTextField) players.getComponent(2)).getText()));
//			frame.add((Component) gameClass.cast(game), BorderLayout.CENTER);
			frame.add(game, BorderLayout.CENTER);

			frame.setSize(500, 500);
			frame.setVisible(true);

//		}

	}

	public Setup() {
		// TODO Auto-generated constructor stub
	}

	public static JPanel createRow(String labelText, int textWidth) {
    	JPanel row = new JPanel();
    	 row = new JPanel();
         row.setLayout(new FlowLayout(FlowLayout.LEFT));        
         row.add(Box.createHorizontalStrut(40));
         row.add(new JLabel(labelText));
         JTextField jt = new JTextField(textWidth);
         jt.setEnabled(false);
         row.add(jt);
         return row;
    	
    }
	
	public static JPanel createRow(String labelText, int textWidth, boolean enabled) {
    	JPanel row = new JPanel();
    	 row = new JPanel();
         row.setLayout(new FlowLayout(FlowLayout.LEFT));        
         row.add(Box.createHorizontalStrut(40));
         row.add(new JLabel(labelText));
         JTextField jt = new JTextField(textWidth);
         jt.setEnabled(enabled);
         row.add(jt);
         return row;
    	
    }
	
	public static JPanel createRow(String labelText, String defaultText, int textWidth) {
    	JPanel row = new JPanel();
    	 row = new JPanel();
         row.setLayout(new FlowLayout(FlowLayout.LEFT));        
         row.add(Box.createHorizontalStrut(40));
         row.add(new JLabel(labelText));
         JTextField jt = new JTextField(defaultText, textWidth);
         jt.setEnabled(false);
         row.add(jt);
         return row;
    	
    }
	
	public static JPanel createRow(String labelText, String defaultText, int textWidth, boolean enabled) {
    	JPanel row = new JPanel();
    	 row = new JPanel();
         row.setLayout(new FlowLayout(FlowLayout.LEFT));        
         row.add(Box.createHorizontalStrut(40));
         row.add(new JLabel(labelText));
         JTextField jt = new JTextField(defaultText, textWidth);
         jt.setEnabled(enabled);
         row.add(jt);
         return row;
    	
    }
}
