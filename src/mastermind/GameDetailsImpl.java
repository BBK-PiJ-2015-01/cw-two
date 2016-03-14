package mastermind;

import java.util.Set;

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
	
	public GameDetailsImpl(Long numOfAttempts, Long numOfPermutations, Set<?> gameChoices) {

		init(numOfAttempts, numOfPermutations, gameChoices);
	}
	
	private void init(Long numOfAttempts, Long numOfPermutations, Set<?> gameChoices) {
		
		setNumberOfAttempts(numOfAttempts);
		setNumberOfPermutations(numOfPermutations);
		setGameChoices(gameChoices);
	}
	

	@Override
	public Long getNumberOfAttempts() {

		return numOfAttempts;
	}

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

	@Override
	public Long getNumberOfPermutations() {

		return numOfPermutations;
	}

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

	@Override
	public Set<?> getGameChoices() {
		return gameChoices;
	}

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
