package mastermind;

public interface GameOutputter { 
	 
    void output(String message); 
 
    void outputLine(String message); 
 
    void outputGameState(GameState state); 
}
