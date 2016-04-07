package mastermind;

import java.util.Set;

/**
* Implementation for the GameDetails interface.
* 
* A GameDetails object provides getters and setter for the number of attempts that will
* be allowed, the number of permutations in the secret code and the type of entities the
* code can consist of (for extensibility this could be a set of anything) 
*
*@author Simon Baird & Johannes Neethling
*/

public class GameDetailsImpl implements GameDetails {

	private Long numOfAttempts;
	private Long numOfPermutations;
	private Set<?> gameChoices;
	//
	private final String NEGATIVE_VALUE_MSG = "A negative value is not allowed";
	private final String NULL_VALUE_MSG = "A null value is not allowed";
	private final String EMPTY_COLLECTION_MSG = "An empty Collection is not allowed";

	public GameDetailsImpl() {
		
	}
	
	/**
	 * Constructor
	 * 
	 * @param Long: the number of attempts
	 * @param Long: the number of permutations
	 * @param Set: the set of entities
	 *
	 */
	public GameDetailsImpl(Long numOfAttempts, Long numOfPermutations, Set<?> gameChoices) {

		init(numOfAttempts, numOfPermutations, gameChoices);
	}
	
	private void init(Long numOfAttempts, Long numOfPermutations, Set<?> gameChoices) {
		
		setNumberOfAttempts(numOfAttempts);
		setNumberOfPermutations(numOfPermutations);
		setGameChoices(gameChoices);
	}
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public Long getNumberOfAttempts() {

		return numOfAttempts;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void setNumberOfAttempts(Long numberOfAttempts) {

		if (numberOfAttempts == null) {
			throw new IllegalArgumentException(NULL_VALUE_MSG);
		}
		if (numberOfAttempts < 0L) {
			throw new IllegalArgumentException(NEGATIVE_VALUE_MSG);
		}
		numOfAttempts = numberOfAttempts;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public Long getNumberOfPermutations() {

		return numOfPermutations;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void setNumberOfPermutations(Long numberOfPermutations) {

		if (numberOfPermutations == null) {
			throw new IllegalArgumentException(NULL_VALUE_MSG);
		}
		if (numberOfPermutations < 0L) {
			throw new IllegalArgumentException(NEGATIVE_VALUE_MSG);
		}
		numOfPermutations = numberOfPermutations;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public Set<?> getGameChoices() {
		return gameChoices;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void setGameChoices(Set<?> gameChoices) {
		
		if (gameChoices == null) {
			throw new IllegalArgumentException(NULL_VALUE_MSG);
		}
		if (gameChoices.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_COLLECTION_MSG);
		}
		this.gameChoices = gameChoices;
	}

}
