package mastermind;

/**
* An GameOutputter displays output.
* 
* An GameOutputter displays output to System.out
*
*/

public interface GameOutputter { 
	
	/**
	* prints some text
	*
	* @param String: a message
	*/
    void output(String message); 

	/**
	* prints a line of text
	*
	* @param String: a message
	*/
    void outputLine(String message); 
 
	/**
	* prints the complete game history
	*
	* @param String: a message
	*/
    void outputGameState(GameState state); 
}
