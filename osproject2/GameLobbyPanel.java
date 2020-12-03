package osproject2;

import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import java.awt.GridLayout;


public class GameLobbyPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JLabel lblFinding;
	private JButton findGameButton = new JButton("Find Games");
	
	//setter for error text
	public void setFinding() throws InterruptedException
	{
		lblFinding.setText("Searching...");
	}


	public GameLobbyPanel(GameLobbyControl gl) {
		
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		lblFinding = new JLabel("");
		panel.add(lblFinding);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		panel_1.add(findGameButton);
		
		findGameButton.addActionListener((ActionListener) gl);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);

	}
	

}
