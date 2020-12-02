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



	public void setCharacterSelectControl(CharacterSelectControl characterSelectControl) {
		this.characterSelectControl = characterSelectControl;
	}

	public void setGameLobbyControl(GameLobbyControl gameLobbyControl) {
		this.gameLobbyControl = gameLobbyControl;
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

			// If we successfully logged in, tell the login controller.
			if (message.equals("LoginSuccessful"))
			{
				loginControl.loginSuccess();
			}

			// If we successfully created an account, tell the create account controller.
			else if (message.equals("CreateAccountSuccessful"))
			{
				createAccountControl.createAccountSuccess();
			}
			else if (message.equals("Player1 Found"))
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
		}

		// If we received an Error, figure out where to display it.
		else if (arg0 instanceof Error)
		{
			// Get the Error object.
			Error error = (Error)arg0;

			// Display login errors using the login controller.
			if (error.getType().equals("Login"))
			{
				loginControl.displayError(error.getMessage());
			}

			// Display account creation errors using the create account controller.
			else if (error.getType().equals("CreateAccount"))
			{
				createAccountControl.displayError(error.getMessage());
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


