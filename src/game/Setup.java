package game;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Setup {

	public static void main(String[] args) {

		JLabel message = new JLabel("Let's Play Mini Golf!", JLabel.CENTER);
		
		
		
		JPanel inputPanel = new JPanel();

		inputPanel.setLayout(new GridLayout(0, 1, 5, 5));
		inputPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK, 2),
				BorderFactory.createEmptyBorder(6, 6, 6, 6)));

		
		
		
		
	}

	public Setup() {
		// TODO Auto-generated constructor stub
	}

	
	class JRow {
		
		JLabel l;
		JTextField t;
		
		public JRow(String message, int tbLength) {
			l = new JLabel(message, JLabel.CENTER);
			t = new JTextField(2);
			
		}
		
		public JRow(String message, String boxDefault, int tbLength) {
			l = new JLabel(message, JLabel.CENTER);
			t = new JTextField(boxDefault, 2);
			
		}
		
	}
}
