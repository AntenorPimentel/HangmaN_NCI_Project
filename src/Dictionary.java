
public class Dictionary{
	
	//VARIABLE
	int lives;
	int countLetterGuessed;
	String word;
	String[] wordList;
	String[] letterGuessed;
	String[] wordSelectedDived;
	private static final int NUMBER_OF_WORDS = 20;
	
	//CONSTRUCTOR
	public Dictionary(){
		this.lives = 6;
		this.inicializeLetterGuessed();
		this.inicializeWordList();
		this.wordRandom();
		this.inicializeDivideWord(word);
		this.countLetterGuessed = this.word.length();
	}

	//GET AND SET
	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	//METHOD
	 /************************************************************
	 * private method that implements a process that
	 * select 1 word in one list of 20 words.
	 * 
	 * @param
	 * @return void
	 ************************************************************/
	private void wordRandom(){		
		int indexWord = 0;
		indexWord = (int) (Math.random() * NUMBER_OF_WORDS);	
		this.word = wordList[indexWord];			
	}

	 /************************************************************
	 * private method to initialize the Array LetterGuessed 
	 * adding symbol "0" and each element.
	 * 
	 * @param
	 * @return void
	 ************************************************************/
	private void inicializeLetterGuessed(){
		this.letterGuessed = new String[26];
		for (int i = 0; i < this.letterGuessed.length ; i++) {
			letterGuessed[i] = "0";
		}
	}
	
	 /************************************************************
	 * private method to get the size of the wordToGuess
	 * and initialize the Array divideWord with the same size
	 * adding symbol "_" and each element.
	 * 
	 * @param String 
	 * @return void
	 ************************************************************/
	private void inicializeDivideWord(String word) {
		wordSelectedDived = new String[word.length()];
		for (int i = 0; i < word.length(); i++) {
			wordSelectedDived[i] = "_";
		}
	 }
	 
	 /************************************************************
	 * private method to initialize the Array WordList 
	 * with 20 words.
	 * 
	 * @param  
	 * @return void
	 ************************************************************/
	private void inicializeWordList(){
		this.wordList = new String[] {"litter", "beanbag", "opening", "settlement", "monkey", "turtle", "bigbang", "comic", 
				"statement", "iteration", "null", "integer", "float", "iphone", "smartphone", "version", "control", "a", "i", "the"}; 	 
	}
	
	 /************************************************************
	 * method to print out the divideWord actualized.
	 * 
	 * @param 
	 * @return void
	 ************************************************************/
	public String getDivideWord() {
		String wordReturn = "";
		for (int i = 0; i < wordSelectedDived.length; i++) {
			wordReturn += wordSelectedDived[i] + " ";
		}
		return wordReturn;
	}
	
	 /************************************************************
	 * method verify if the input is one Word or if is a Letter.
	 * 
	 * @param String 
	 * @return boolean
	 *************************************************************/
	public boolean isLetter(String input){	
		boolean verify = false;
		int length = input.length(); 
		
		if(length == 1){
			verify = true;
		}
		return verify; 
	}
	
	 /************************************************************
	 * method to implements a process that verify if the Input 
	 * is a Number return TRUE, if it's String return FALSE.
	 * 
	 * @param 
	 * @return boolean 
	 ************************************************************/
	public boolean isNumeric(String input){ 
		boolean result = true;
		
		try {			
			Double.parseDouble(input);

		 }catch (NumberFormatException e) {
		    result = false;
		 }	
		return result;
	}
	
	 /************************************************************
	 * private method to check if the letter was used before
	 * return TRUE, and if not return FALSE and add the letter 
	 * in the Array letterGuessed. 
	 * 
	 * @param 
	 * @return boolean
	 ************************************************************/
	private boolean isUsedLetter(String letter) {
		boolean exist = false;
		for (int i = 0; i < this.letterGuessed.length; i++) {
			if (letterGuessed[i].equals(letter)) {
				exist = true;
				break;
			} else if (this.letterGuessed[i].equals("0")) {
				letterGuessed[i] = letter;
				break;
			}
		}
		return exist;
	}

	 /************************************************************
	 * method to receive the letter and compare to
	 * the wordToGuess and actualize the word. 
	 * If the letter guessed is correct return TRUE, 
	 * otherwise return FALSE.
	 * 
	 * @param 
	 * @return boolean
	 ************************************************************/
	public boolean compareToWord(String letter) {
		boolean letterUsed = false;
		int count = 0;
		letterUsed = this.isUsedLetter(letter);
			
		if(letterUsed == false){
			for (int i = 0; i < word.length(); i++) {	
				String currentLetter = Character.toString(word.charAt(i));
				if(letter.equals(currentLetter)){
					wordSelectedDived[i] = Character.toString(word.charAt(i));
					this.countGuessed();
					count++;
				}
			}	
		}
		
		if(count > 0){	
			letterUsed = true;
		}
		return letterUsed;
	}

	 /***********************************************************
	 * method to Print out the LetterGuessed.
	 * 
	 * @param 
	 * @return void
	 ************************************************************/
	public String getLetterGuessed() {
		String messageReturn = "";
		for (int i = 0; i < letterGuessed.length; i++) {
			if (!letterGuessed[i].equals("0")) {
				messageReturn += letterGuessed[i] + " ";
			}
		}
		return messageReturn;
	}
	
	 /***********************************************************
	 * method to count and update the numbers of LetterGuessed.
	 * 
	 * @return void
	 * @param 
	 ************************************************************/
	private void countGuessed(){	
		if(this.countLetterGuessed > 0){
			this.countLetterGuessed = this.countLetterGuessed - 1;
		}
	}
	
	 /************************************************************
	 * method to count and update the number of live and return
	 * the current number of lives.
	 * 
	 * @return 
	 * @param 
	 ************************************************************/
	public int countLive(){	
		if(this.getLives() > 0){
			setLives(this.getLives() - 1);
		}
		
		return this.getLives();
	}
	
	 /************************************************************
	 * method to count less 1 from the current total.
	 * letters guessed
	 * 
	 * @param 
	 * @return void
	 ************************************************************/
	public boolean checkLetterGuessed(){
		boolean available = true;
		if(this.countLetterGuessed == 0){
			available = false;
		}
		return available;
	}	
}
