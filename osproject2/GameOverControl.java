package osproject2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;

public class GameOverControl implements ActionListener {
	private static JPanel container;
	private GameClient client;

	public GameOverControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client; 
	}
	
	public void actionPerformed(ActionEvent e) {

		// Get the name of the button clicked.
		String command = e.getActionCommand();

		// The Cancel button takes the user back to the initial panel.
		if (command.equals("Yes"))
		{
			try {
				client.sendToServer("Play Again");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		else if(command.equals("No")) {
			System.exit(0);

		}

	}
}
