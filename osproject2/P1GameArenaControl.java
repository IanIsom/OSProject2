package osproject2;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;


public class P1GameArenaControl implements ActionListener{

	private static JPanel container;
	private GameClient client;
	
	public P1GameArenaControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client; 
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
	    // Get the name of the button clicked.
	    String command = e.getActionCommand();

	    // The Cancel button takes the user back to the initial panel.
	    if (command.equals("Attack"))
	    {
	    	try {
					client.sendToServer("Attack1");
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

	    }
	    else if(command.equals("Defend")) {
	    	try {
					client.sendToServer("Defend1");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	
	    }
	    else if(command.equals("Quit")) {
	    	try {
				client.sendToServer("Quit1");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	System.exit(0);
	    }
	    
		
	}
	
	public static void dmgCalc2(Object arg0) throws InterruptedException {
		P1GameArenaPanel p1 = (P1GameArenaPanel)container.getComponent(3);
		System.out.println(- (double)arg0);
		p1.setHp2(p1.getHp2() + (double) arg0);
	}
	
	public static void dmgCalc4(Object arg0) {
		P1GameArenaPanel p1 = (P1GameArenaPanel)container.getComponent(3);
		System.out.println(- (double)arg0);
		p1.setHp1(p1.getHp1() + (double) arg0);
	}
	public static void gameOver(Object arg0) {
		GameOverPanel go =(GameOverPanel)container.getComponent(5);
		go.setlblWinner((String)arg0);
	    CardLayout cardLayout = (CardLayout)container.getLayout();
	    cardLayout.show(container, "6");
	}
	
}
