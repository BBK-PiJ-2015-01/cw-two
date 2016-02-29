package mastermind;

import java.util.Map;

public interface GameDetails {
	
	Long getNumberOfAttempts(); 

	void setNumberOfAttempts(Long numberOfAttempts); 

	Long getNumberOfPermutations(); 

	void setNumberOfPermutations(Long numberOfPermutations); 

	Map<?, ?> getGameChoices(); 

	void setGameChoices(Map<?, ?> gameChoices);
}
