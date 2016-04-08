package mastermind;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
* Implementation of the OutputFormatter interface.
* 
* An OutputFormatter formats output for display with the aid of properties file.
* 
* @author Simon Baird & Johannes Neethling
*/

public class OutputFormatterImpl implements OutputFormatter {

	private final GameOutputter out;
	//
	private final Properties properties;
	//
	private final String PROPERTIES_FILE_NAME = "outputFormatter.properties";
	//
	private final String DETAILS_FORMAT_NAME = "detailsFormat";
	private final String SOLUTION_FORMAT_NAME = "solutionFormat";
	private final String ATTEMPT_PROMPT_FORMAT_NAME = "attemptPromptFormat";
	private final String COMMAND_PROMPT_FORMAT_NAME = "commandPromptFormat";
	private final String SOLVED_FORMAT_NAME = "solvedFormat";
	private final String FAILED_FORMAT_NAME = "failedFormat";
	private final String FINAL_MESSAGE = "finalMessage";

	/**
	 * Constructor
	 * 
	 *@param GameOutputter: the game outputter object
	 *@throws FileNotFoundException if the properties file cannot be found
	 *@throws IOException if the properties file cannot be read
	 */
	
	public OutputFormatterImpl(GameOutputter out) throws FileNotFoundException, IOException {

		this.out = out;
		properties = new Properties();
		out.outputLine(System.getProperty("user.dir"));
		properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
		// properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void outputGameDetails(GameInstance instance) {

		// Supply the permutations, size, values, codes and number of attempts,
		// to the format

		String format = properties.getProperty(DETAILS_FORMAT_NAME);
		String outputMessage = format == null ? "No details format found"
				: String.format(format, instance.getGameDetails().getNumberOfPermutations(),
						instance.getGameDetails().getGameChoices().size(),
						instance.getGameDetails().getGameChoices().toString(),
						instance.getGameDetails().getGameChoices(), instance.getGameDetails().getNumberOfAttempts());

		out.outputLine(outputMessage);
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void outputSolution(GameInstance instance) {

		// Supply the solution to the format
		String format = properties.getProperty(SOLUTION_FORMAT_NAME);
		String outputMessage = format == null ? "No solution format found"
				: String.format(format, instance.getGameState().getSolution().toString());

		out.outputLine(outputMessage);

	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void outputGameHistory(GameInstance instance) {

		// Output a row for each available attempt
		// Pass the attempt and the score to the format
		String gameHistoryFormat = "%s %s";
		String scoreFormat = "%s %d ";
		for (GameAttempt attempt : instance.getGameState().getGameHistory()) {
			String score = "";
			if (attempt.getAttemptResult().getExactScore() > 0) {
				score = String.format(scoreFormat, properties.getProperty("correctGuess"),
						attempt.getAttemptResult().getExactScore());
			}
			if (attempt.getAttemptResult().getNearScore() > 0) {
				score = score + String.format(scoreFormat, properties.getProperty("nearGuess"),
						attempt.getAttemptResult().getNearScore());
			}
			List<?> firstLetters = attempt.getAttempt().stream().map(a -> a.toString().charAt(0)).collect(Collectors.toList());
			out.outputLine(String.format(gameHistoryFormat, firstLetters, score));
		}
		// Empty line for unused attempts
		for (long remaining = 0; remaining < instance.getRemainingAttempts(); remaining++) {
			out.outputLine(nStrings(".", instance.getGameDetails().getNumberOfPermutations()));
		}
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void outputAttemptPrompt(GameInstance instance) {

		// Supply the remaining attempts to the format
		String format = properties.getProperty(ATTEMPT_PROMPT_FORMAT_NAME);
		String outputMessage = format == null ? "No attempt prompt format found"
				: String.format(format, instance.getRemainingAttempts());

		out.output(outputMessage);

	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void outputCommandPrompt(GameInstance instance) {

		// Supply the EXIT and NEW GAME commands to the format
		String format = properties.getProperty(COMMAND_PROMPT_FORMAT_NAME);
		String outputMessage = format == null ? "No command prompt format found"
				: String.format(format, GameCommand.EXIT.getToken(), GameCommand.EXIT, GameCommand.NEW_GAME.getToken(),
						GameCommand.NEW_GAME);

		out.output(outputMessage);
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void outputSuccessMessage(GameInstance instance) {

		// Supply the number of attempts taken to the format
		String format = properties.getProperty(SOLVED_FORMAT_NAME);
		String outputMessage = format == null ? "No solved format found"
				: String.format(format,
						instance.getGameDetails().getNumberOfAttempts() - instance.getRemainingAttempts());
		out.outputLine(outputMessage);
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void outputFailedMessage(GameInstance instance) {

		// Supply the solution to the format
		String format = properties.getProperty(FAILED_FORMAT_NAME);
		List<?> firstLetters = instance.getGameState().getSolution().stream().map(a -> a.toString().charAt(0)).collect(Collectors.toList());
		String outputMessage = format == null ? "No failed format found"
				: String.format(format, firstLetters);
		out.outputLine(outputMessage);
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void outputFinalMessage() {
		// Output the final message
		String message = properties.getProperty(FINAL_MESSAGE);
		out.outputLine(message);

	}

	/**
	* {@inheritDoc}
	*/
	private String nStrings(String text, long times) {
		if (times == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (long i = 0; i < times; i++) {
			sb.append(text).append(" ");
		}
		return sb.toString().trim();
	}

}