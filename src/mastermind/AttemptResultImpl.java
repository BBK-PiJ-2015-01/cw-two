package mastermind;

public class AttemptResultImpl implements AttemptResult {

	private Long exactScore;
	private Long nearScore;
	private String message;
	//
	private final String NEGATIVE_VALUE_MSG = "A negative value is not allowed";
	private final String NULL_VALUE_MSG = "A null value is not allowed";

	public AttemptResultImpl() {

	}

	/**
	 * Convenience constructor to generate with scores
	 * 
	 * @param exactScore
	 *            the correct guesses
	 * @param nearScore
	 *            the near guesses
	 * @throws IllegalArgumentException
	 *             if the either score is null or negative
	 */
	public AttemptResultImpl(Long exactScore, Long nearScore) {

		init(exactScore, nearScore);
	}

	private void init(Long exactScore, Long nearScore) {
		setExactScore(exactScore);
		setNearScore(nearScore);
	}

	@Override
	public Long getExactScore() {

		return exactScore;
	}

	/**
	 * Set the score representing the correct colour and position guesses
	 * 
	 * @param score
	 *            the number of correct guesses
	 * @throws IllegalArgumentException
	 *             if the guess is null or negative
	 */
	@Override
	public void setExactScore(Long score) {

		if (score == null) {
			throw new IllegalArgumentException(NULL_VALUE_MSG);
		}
		if (score < 0) {
			throw new IllegalArgumentException(NEGATIVE_VALUE_MSG);
		}
		exactScore = score;
	}

	@Override
	public Long getNearScore() {

		return nearScore;
	}

	/**
	 * Set the score representing the correct colour but incorrect position
	 * guesses
	 * 
	 * @param score
	 *            the number of correct guesses
	 * @throws IllegalArgumentException
	 *             if the guess is null or negative
	 */
	@Override
	public void setNearScore(Long score) {

		if (score == null) {
			throw new IllegalArgumentException(NULL_VALUE_MSG);
		}
		if (score < 0) {
			throw new IllegalArgumentException(NEGATIVE_VALUE_MSG);
		}
		nearScore = score;
	}

	@Override
	public String getMessage() {

		return message;
	}

	@Override
	public void setMessage(String message) {

		this.message = message;
	}

}
