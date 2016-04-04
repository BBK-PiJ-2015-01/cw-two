package mastermind;

public interface OutputFormatter {
	 
    void outputGameDetails(GameInstance instance);
 
    void outputSolution(GameInstance instance);
 
    void outputGameHistory(GameInstance instance);
 
    void outputAttemptPrompt(GameInstance instance);
 
    void outputCommandPrompt(GameInstance instance);
 
    void outputSuccessMessage(GameInstance instance);
 
    void outputFailedMessage(GameInstance instance);
    
    void outputFinalMessage();
 
}