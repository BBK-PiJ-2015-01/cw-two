package mastermind;

/**
* An OutputFormatter formats output for display.
* 
* An OutputFormatter formats output for display with the aid of properties file.
*
*/

public interface OutputFormatter {
	
	/**
	* Output the game details
	*
	* @param GameInstance: an instance of the game
	*/
    void outputGameDetails(GameInstance instance);
 
	/**
	* Output the solution
	*
	* @param GameInstance: an instance of the game
	*/
    void outputSolution(GameInstance instance);
 
	/**
	* Output the game history
	*
	* @param GameInstance: an instance of the game
	*/
    void outputGameHistory(GameInstance instance);
 
	/**
	* Output a prompt for the next attempt
	*
	* @param GameInstance: an instance of the game
	*/
    void outputAttemptPrompt(GameInstance instance);
 
	/**
	* Output a prompt for a command
	*
	* @param GameInstance: an instance of the game
	*/
    void outputCommandPrompt(GameInstance instance);
 
	/**
	* Output a success message
	*
	* @param GameInstance: an instance of the game
	*/
    void outputSuccessMessage(GameInstance instance);
 
	/**
	* Output a failure message
	*
	* @param GameInstance: an instance of the game
	*/
    void outputFailedMessage(GameInstance instance);
    
	/**
	* Output the final message
	*
	* @param GameInstance: an instance of the game
	*/
    void outputFinalMessage();
 
}