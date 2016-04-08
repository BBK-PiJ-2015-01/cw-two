package mastermind;

/**
* A GameInputter handles the conversion of user input
* 
* A GameInputter handles the conversion of user input into choice entities
* or game commands
*
*/

public interface GameInputter {
	
	/**
	* interpret the attempt
	*
	* @return GameAttempt: an attempt object
	*/
    GameAttempt readAttempt(); 

	/**
	* Get the command
	*
	* @return GameCommand: an enumerated game command
	*/
    GameCommand getCommand();
 
	/**
	* Returns a message (not really implemented)
	* 
	* @return String: null
	*/
    String getMessage(); 
}
