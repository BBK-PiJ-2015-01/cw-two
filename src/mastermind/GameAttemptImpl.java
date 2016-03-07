package mastermind;

import java.util.List;

public class GameAttemptImpl implements GameAttempt {

	private List<?> attempt;
	private AttemptResult attemptResult;
	private String message;
	//
	//
	private final String NULL_VALUE_MSG = "A null value is not allowed";

	@Override
	public List<?> getAttempt() {

		return attempt;
	}

	@Override
	public void setAttempt(List<?> attempt) {

		if (attempt == null) {
			throw new IllegalArgumentException(NULL_VALUE_MSG);
		}
		this.attempt = attempt;
	}

	@Override
	public AttemptResult getAttemptResult() {

		return attemptResult;
	}

	@Override
	public void setAttemptResult(AttemptResult result) {

		if (result == null) {
			throw new IllegalArgumentException(NULL_VALUE_MSG);
		}
		attemptResult = result;
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
