package osproject2;


import ocsf.client.AbstractClient;
import java.util.ArrayList;
import ocsf.client.AbstractClient;


public class GameClient extends AbstractClient
{
	// Private data fields for storing the GUI controllers.

	private CharacterSelectControl characterSelectControl;
	private GameLobbyControl gameLobbyControl;
	private CharacterData data;
	private GameOverControl gameOverControl;
	private InitialControl initalControl;



	public void setCharacterSelectControl(CharacterSelectControl characterSelectControl) {
		this.characterSelectControl = characterSelectControl;
	}

	public void setGameLobbyControl(GameLobbyControl gameLobbyControl) {
		this.gameLobbyControl = gameLobbyControl;
	}
	
	public void setGameOverControl(GameOverControl gameOverControl) {
		this.gameOverControl = gameOverControl;
	}
	



	// Constructor for initializing the client with default settings.
	public GameClient()
	{
		super("localhost", 8300);
	}

	// Method that handles messages from the server.
	public void handleMessageFromServer(Object arg0)
	{
		// If we received a String, figure out what this event is.
		if (arg0 instanceof String)
		{
			// Get the text of the message.
			String message = (String)arg0;

			if (message.equals("Player1 Found"))
			{
				try {
					gameLobbyControl.finding();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gameLobbyControl.p1Found();

			}
			else if (message.equals("Player2 Found"))
			{
				gameLobbyControl.p2Found();
			}

			else if (message.equals("Finding"))
			{
				try {
					gameLobbyControl.finding();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (message.equals("Player 1 Wins"))
			{
				P1GameArenaControl.gameOver(arg0);
				P2GameArenaControl.gameOver(arg0);
			}
			else if (message.equals("Player 2 Wins"))
			{
				System.out.println("HIT THE CLIENT");
				P1GameArenaControl.gameOver(arg0);
				P2GameArenaControl.gameOver(arg0);
			}
			else if(message.equals("Start Over")) {
				initalControl.startOver();
				
			}
		}

		else if(arg0 instanceof CharacterData) {
			characterSelectControl.CharacterSelectSuccess();

		}
		else if(arg0 instanceof ArrayList) {
			gameLobbyControl.setData((ArrayList<CharacterData>) arg0);
		}

		else if(arg0 instanceof Double) {
			if ((double)arg0 >= 200 || (double)arg0 <-200) {

				if ((double)arg0 > 0) {
					P2GameArenaControl.dmgCalc1((double)arg0/100);
				}
				else if ((double)arg0 < 0) {
					try {
						P1GameArenaControl.dmgCalc2((double)arg0/100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else {
				if ((double)arg0 > 0) {
					P2GameArenaControl.dmgCalc3(arg0);
				}
				else if ((double)arg0 < 0) {
					P1GameArenaControl.dmgCalc4(arg0);
				}
			}
		}
	}
	public void setData(CharacterData data) {
		this.data = data;

	}


}


