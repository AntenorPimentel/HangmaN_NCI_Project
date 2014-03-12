import javabook.*;

public class Message  {
	/************************************************************
	* STATIC MESSAGES - private static messages use
	* 					in this class.
	* 
	************************************************************/
	//START MESSAGES
	private static final String MESSAGE_TITLE = ("HANGMAN GAME ");
	private static final String MESSAGE_LIVE = ("Lives:");
	private static final String MESSAGE_WORD = ("Word: ");
	private static final String MESSAGE_LETTER_GUESSED = ("Letter guessed so far: ");
	private static final String MESSAGE_LETTER_ENTER = ("Guess a letter or enter 0 to exit: ");
	
	//ERROR MESSAGES
	private static final String MESSAGE_ERROR_INVALID_INPUT = ("Invalid input! ");
	private static final String MESSAGE_ERROR_INVALID_USED = ("Letter already used: ");
	
	//END MESSAGES
	private static final String MESSAGE_END_LOOSE = ("GAME OVER! SORRY YOU LOOSE! ");
	private static final String MESSAGE_END_WON = ("YOU WON!" );
	private static final String MESSAGE_END_AGAIN = ("Play again (y/n)?! ");
	private static final String MESSAGE_END_CONTINUE = ("Press any key to continue ");
	private static final String MESSAGE_END = ("Thank you for play Hangman! ");
	private static final String MESSAGE_END_RESULT = ("The word to guess is: ");
	
	/************************************************************
	* method to show status of live, DivideWord and
	* LetterGuessed.
	* 
	* @param 
	* @return void
	************************************************************/
	@SuppressWarnings("deprecation")
	public void showStatus(Dictionary dictionary, OutputBox theOutputWindow)
	{	
		theOutputWindow.clear();
		theOutputWindow.show();	
		theOutputWindow.println(Message.MESSAGE_LIVE + dictionary.getLives());
		theOutputWindow.println(Message.MESSAGE_WORD + dictionary.getDivideWord());
		theOutputWindow.println(Message.MESSAGE_LETTER_GUESSED + dictionary.getLetterGuessed());			
	}
	/************************************************************
	* method to get the input and change to Lower Case
	* 
	* @param 
	* @return String
	************************************************************/
	public String getInput(Dictionary dictionary, InputBox theInputWindow)
	{		
		theInputWindow.setTitle(Message.MESSAGE_TITLE);
		int icon = InputBox.QUESTION_ICON;
		theInputWindow.setIcon(icon);
		String input;
		input = theInputWindow.getString(MESSAGE_LETTER_ENTER);
		input = input.toLowerCase();
		return input;
	}
	/************************************************************
	* method to show END message.
	* 
	* @param 
	* @return void
	************************************************************/
	public void showEndMessage(OutputBox theOutputWindow)
	{	
		
		theOutputWindow.clear();
		theOutputWindow.println(Message.MESSAGE_END);
	}
	/************************************************************
	* method to show Invalid Message.
	* 
	* @param 
	* @return void
	************************************************************/
	public void showInvalidMessage(OutputBox theOutputWindow, InputBox theInputWindow)
	{		
		theOutputWindow.clear();	
		int icon = InputBox.ERROR_ICON;
		theOutputWindow.println(Message.MESSAGE_ERROR_INVALID_INPUT);
		theInputWindow.setIcon(icon);
		theInputWindow.getString(Message.MESSAGE_END_CONTINUE);		
	}
	/************************************************************
	* method to show Invalid Message.
	* 
	* @param 
	* @return void
	************************************************************/
	public void showInvalidMessage(OutputBox theOutputWindow, InputBox theInputWindow, String input)
	{		
		theOutputWindow.clear();	
		int icon = InputBox.ERROR_ICON;
		theOutputWindow.println(Message.MESSAGE_ERROR_INVALID_USED + input);
		theInputWindow.setIcon(icon);
		theInputWindow.getString(Message.MESSAGE_END_CONTINUE);		
	}
	/************************************************************
	* method to show Loose Message.
	* 
	* @param 
	* @return String
	************************************************************/
	public String showLooseMessage(Dictionary dictionary, OutputBox theOutputWindow, InputBox theInputWindow)
	{		
		theOutputWindow.clear();
		String input;
		int icon = InputBox.ERROR_ICON;	
		theOutputWindow.println(Message.MESSAGE_END_LOOSE);
		theOutputWindow.println(Message.MESSAGE_END_RESULT + dictionary.getWord());
		theInputWindow.setIcon(icon);
		input = theInputWindow.getString(Message.MESSAGE_END_AGAIN);
		input = input.toLowerCase();
		
		return input;
	}
	/************************************************************
	* method to show Win Message.
	* 
	* @param 
	* @return String
	************************************************************/
	public String showWinMessage(Dictionary dictionary, OutputBox theOutputWindow, InputBox theInputWindow)
	{		
		theOutputWindow.clear();
		String input;
		int icon = InputBox.INFO_ICON;
		theOutputWindow.println(Message.MESSAGE_END_WON);
		theOutputWindow.println(Message.MESSAGE_END_RESULT + dictionary.getWord());
		theInputWindow.setIcon(icon);
		input = theInputWindow.getString(Message.MESSAGE_END_AGAIN);
		input.toLowerCase();

		return input;
	}
}
