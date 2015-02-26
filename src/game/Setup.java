package game;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Setup {

	public static void main(String[] args) {

		Setup s = new Setup();
		JLabel message = new JLabel("Let's Play Mini Golf!", JLabel.CENTER);

		JRow players = s.new JRow("How many players?", 1);

		JRow p1 = s.new JRow("Name?", 5);
		JRow p2 = s.new JRow("Name?", 5);
		JRow p3 = s.new JRow("Name?", 5);
		JRow p4 = s.new JRow("Name?", 5);

		ActionListener playerNumListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				p1.disable();
				p2.disable();
				p3.disable();
				p4.disable();

				switch (players.l.getText()) {

				case "4":
					p4.enable();

				case "3":
					p3.enable();

				case "2":
					p2.enable();

				default:
					p1.enable();

				}

			}
		};

		players.getField().addActionListener(playerNumListener);
		
		JPanel inputPanel = new JPanel();

		inputPanel.setLayout(new GridLayout(0, 1, 5, 5));
		inputPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK, 2),
				BorderFactory.createEmptyBorder(6, 6, 6, 6)));

	}

	public Setup() {
		// TODO Auto-generated constructor stub
	}

	private class JRow {

		JLabel l;
		JTextField t;

		public JRow(String message, int tbLength) {
			l = new JLabel(message, JLabel.CENTER);
			t = new JTextField(tbLength);

		}

		public JRow(String message) {
			l = new JLabel(message, JLabel.CENTER);
			t = new JTextField();

		}

		public JRow(String message, String boxDefault, int tbLength) {
			l = new JLabel(message, JLabel.CENTER);
			t = new JTextField(boxDefault, 2);

		}

		public JLabel getLabel() {
			return l;
		}

		public JTextField getField() {
			return t;
		}

		public void disable() {

			l.setEnabled(false);
			t.setEnabled(false);

		}

		public void enable() {

			l.setEnabled(true);
			t.setEnabled(true);
		}

	}
}
