package mastermind;

import java.util.List;

public interface GameAttempt {

	List<?> getAttempt();

	void setAttempt(List<?> attempt);

	AttemptResult getAttemptResult();

	void setAttemptResult(AttemptResult result);

	String getMessage();

	void setMessage(String message);

}
