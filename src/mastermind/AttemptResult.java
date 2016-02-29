package mastermind;

/**
 * Class to encapsulate the results of evaluating an attempt to guess the secret code
 * @author sbaird02
 *
 */
		
public interface AttemptResult {

	/**
	 * 
	 * @return the number of 'pegs' which are in the correct position
	 */
	Long getExactScore();

	void setExactScore(Long score);

	/**
	 * 
	 * @return the number of 'pegs' of the correct colour but in an incorrect position
	 */
	Long getNearScore();

	void setNearScore(Long score);

	/**
	 * 
	 * @return a String containing a message pertaining to the attempt
	 */
	String getMessage();

	void setMessage(String message);
}
