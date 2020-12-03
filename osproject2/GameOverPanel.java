package osproject2;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameOverPanel extends JPanel {
	private JLabel lblWinner;
	
	public GameOverPanel(GameOverControl go) {
		
		
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		lblWinner = new JLabel("");
		panel_1.add(lblWinner);
		
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JButton btnYes = new JButton("Yes");
		panel_2.add(btnYes);
		btnYes.addActionListener((ActionListener) go);
		
		JButton btnNo = new JButton("No");
		panel_2.add(btnNo);
		btnNo.addActionListener((ActionListener) go);
		

	}
	
	public void setlblWinner(String win) {
		lblWinner.setText(win + " Play Again?");
	}

}
