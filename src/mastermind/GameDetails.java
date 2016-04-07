package mastermind;

import java.util.Set;

/**
* A GameDetails object provides the configuration for each game.
* 
* A GameDetails object provides getters and setter for the number of attempts that will
* be allowed, the number of permutations in the secret code and the type of entities the
* code can consist of (for extensibility this could be a set of anything) 
*
*/

public interface GameDetails {
	
	/**
	* Returns the number of attempts to be allowed for solving the code.
	*
	* @return Long: the number of attempts
	*/
	Long getNumberOfAttempts(); 

	/**
	* Set the number of attempts allowed for solving the code.
	*
	* @param Long: the number of attempts
	* @throws IllegalArgumentException if the parameter is null or a negative number
	*/
	void setNumberOfAttempts(Long numberOfAttempts); 

	/**
	* Returns the number of permutations in the secret code.
	*
	* @return Long: the number of permutations
	*/
	Long getNumberOfPermutations(); 

	/**
	* Set the number of permutations in the secret code.
	*
	* @param Long: the number of permutations
	* @throws IllegalArgumentException if the parameter is null or a negative number
	*/
	void setNumberOfPermutations(Long numberOfPermutations); 

	/**
	* Returns the set of entities that the secret code can consist of.
	*
	* @return Set: the set of entities
	*/
	Set<?> getGameChoices(); 

	/**
	* Set the entities that the secret code can consist of.
	*
	* @param Set: the set of entities
	* @throws IllegalArgumentException if the parameter is null or an empty set
	*/
	void setGameChoices(Set<?> gameChoices);
}
