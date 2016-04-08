package mastermind;

import java.util.List;

/**
* An AttemptEvaluator produces the score for an attempt.
* 
* An AttemptEvaluator produces the score for an attempt by comparing the
* players guess with the secret code
*
*/

public interface AttemptEvaluator { 
	
	/**
	* Evaluate the attempt
	*
	* @param List: the code for the game
	* @param List: the attempt at guessing the code
	* @throws NullPointerException if any of the parameters are null
	* @return AttemptResult: the result of the attempt
	*/
	AttemptResult evaluateGuess(List<?> game, List<?> guess); 
}

