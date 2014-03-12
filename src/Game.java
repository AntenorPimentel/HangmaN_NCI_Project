import javabook.*;

public class Game {
		
	public static void main(String[] args) {
		
		/*****************************************************************/
		//Declare objects and variables
		MainWindow  mWindow = new MainWindow();
		InputBox iBox = new InputBox(mWindow);
		OutputBox oBox = new OutputBox(mWindow);
		Dictionary dictionary;
		Message message = new Message();
		boolean finish = false;
		boolean nextStep = false;
		String input = null;
		/*****************************************************************/	
		
		//start a new the game
		while (!finish) {
			
			dictionary = new Dictionary();
			//continue the game 
			while (!nextStep) {
			
				//output 
				message.showStatus(dictionary, oBox);
				
				//input
				input = message.getInput(dictionary, iBox);
				
				// check if the input is numeric 
				if (!dictionary.isNumeric(input)){
					
					// check if the input is a letter
					if (dictionary.isLetter(input)) {
											
						// compare the input with the word
						if(!dictionary.compareToWord(input)){
							
							dictionary.countLive();	
							
						}											
						
						// check if have enough live to continue
						if(dictionary.getLives()==0){	
						
							input = message.showLooseMessage(dictionary, oBox, iBox);
							
							if (input.equals("n")) {
								message.showEndMessage(oBox);
								finish = true;
								break;
							} else if (input.equals("y")) {
								break;
							}
						}
						
						// check if the letter is the last one to guess
						if(!dictionary.checkLetterGuessed()){
							
							// guessed all letters correctly
							input = message.showWinMessage(dictionary, oBox, iBox);

							if (input.equals("n")) {
								message.showEndMessage(oBox);
								finish = true;
								break;
							} else if (input.equals("y")) {
								break;
							}
						}
						
					}else{
								
						// valid guess input
						if (dictionary.getWord().equals(input)) {
							
							// guessed word is correct
							input = message.showWinMessage(dictionary, oBox, iBox);
					
							if (input.equals("n")) {
								message.showEndMessage(oBox);
								finish = true;
								break;
							} else if (input.equals("y")) {
								break;
							}

						} else {
							
							// invalid guess input
							input = message.showLooseMessage(dictionary, oBox, iBox);
					
							if (input.equals("n")) {
								message.showEndMessage(oBox);
								finish = true;
								break;
							} else if (input.equals("y")) {
								break;
							}
						}						
							
					}
				} else{
					// if the input is equal to 0, END the game
					if(input.equals("0")){	
						
						message.showEndMessage(oBox);
						finish = true;
						break;
						
					}else{
						
						// invalid input
						message.showInvalidMessage(oBox, iBox);
						
					}
				}	
			}// end of while (nextstep)
		}// end of while (finish)
	}// end of main
}// end of game class
