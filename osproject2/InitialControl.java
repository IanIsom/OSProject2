package osproject2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InitialControl implements ActionListener
{
  // Private data field for storing the container.
  private static JPanel container;
  private GameClient client;
  // Constructor for the initial controller.
  public InitialControl(JPanel container, GameClient client)
  {
    this.container = container;
    this.client = client;
  }
  
  // Handle button clicks.
  public void actionPerformed(ActionEvent ae)
  {
    // Get the name of the button clicked.
    String command = ae.getActionCommand();
    
    // The Login button takes the user to the login panel.
    if (command.equals("Start Game"))
    {
      CardLayout cardLayout = (CardLayout)container.getLayout();
      cardLayout.show(container, "2");
     
    }
    
  }
  
  public static void startOver() {
	  System.out.println("HIt start over again");
      CardLayout cardLayout = (CardLayout)container.getLayout();
      cardLayout.show(container, "1");
  }
}
