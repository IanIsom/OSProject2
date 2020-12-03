package osproject2;

import java.awt.*;
import javax.swing.*;

public class InitialPanel extends JPanel 
{
	//Constructor for initial panel
	public InitialPanel(InitialControl ic)
	{
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JButton btnStartGame = new JButton("Start Game");
		panel_1.add(btnStartGame);
		
		btnStartGame.addActionListener(ic);
		
		
	}
}
