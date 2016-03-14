package mastermind;

import java.util.Set;

public interface GameDetails {
	
	Long getNumberOfAttempts(); 

	void setNumberOfAttempts(Long numberOfAttempts); 

	Long getNumberOfPermutations(); 

	void setNumberOfPermutations(Long numberOfPermutations); 

	Set<?> getGameChoices(); 

	void setGameChoices(Set<?> gameChoices);
}
