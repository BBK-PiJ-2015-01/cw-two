package mastermind;

import java.util.Map;

public class GameDetailsImpl implements GameDetails {

	private Long numOfAttempts;
	private Long numOfPermutations;
	private Map<?, ?> gameChoices;
	//
	private final String NEGATIVE_VALUE_MSG = "A negative value is not allowed";
	private final String NULL_VALUE_MSG = "A null value is not allowed";
	private final String EMPTY_COLLECTION_MSG = "An empty Collection is not allowed";

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
	public Map<?, ?> getGameChoices() {
		return gameChoices;
	}

	@Override
	public void setGameChoices(Map<?, ?> gameChoices) {
		
		if (gameChoices == null) {
			throw new IllegalArgumentException(NULL_VALUE_MSG);
		}
		if (gameChoices.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_COLLECTION_MSG);
		}
		this.gameChoices = gameChoices;
	}

}
