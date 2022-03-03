package game.opponent;

public class TranspositionTableProbing {

	public enum ProbingResult {
		OK, 
		NotOK
	}
	
	public ProbingResult result;
	public double score;
}
