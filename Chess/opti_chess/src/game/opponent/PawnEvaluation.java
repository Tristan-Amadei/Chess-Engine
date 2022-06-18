package game.opponent;

import java.util.ArrayList;
import java.util.List;

import game.Board;
import game.pieces.PieceTypeClass.PieceType;

public class PawnEvaluation {
	
	public static List<int[]> countPawns(Board board) {
		List<int[]> numberOfPawns = new ArrayList<>();
		int[] whitePawns = new int[8];
		int[] blackPawns = new int[8];
		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < 8; i++) {
				if (board.board[i][j] != null && board.board[i][j].getType() == PieceType.Pawn) {
					if (board.board[i][j].getColor()) {
						whitePawns[j]++;
					} else {
						blackPawns[j]++;
					}
				}
			}
		}
		numberOfPawns.add(whitePawns);
		numberOfPawns.add(blackPawns);
		return numberOfPawns;
	}
	
	public static int numberOfIsolatedPawns(List<int[]> pawnsCount, boolean color) {
		int[] pawnStructure;
		if (color) {
			pawnStructure = pawnsCount.get(0);
		} else {
			pawnStructure = pawnsCount.get(1);
		}
		
		int isolatedPawns = 0;
		if (pawnStructure[0] > 0 && pawnStructure[1] == 0) {
			isolatedPawns += pawnStructure[0];
		}
		if (pawnStructure[7] > 0 && pawnStructure[6] == 0) {
			isolatedPawns += pawnStructure[8];
		}
		
		for (int j = 1; j < 7; j++) {
			if (pawnStructure[j-1] == 0 && pawnStructure[j] > 0 && pawnStructure[j+1] == 0) {
				isolatedPawns += pawnStructure[j];
			}
		}
		
		return isolatedPawns;
	}
	
	public static int numberOfDoubledPawns(List<int[]> pawnsCount, boolean color) {
		int[] pawnStructure;
		if (color) {
			pawnStructure = pawnsCount.get(0);
		} else {
			pawnStructure = pawnsCount.get(1);
		}
		
		int doubledPawns = 0;
		for (int j = 0; j < 8; j++) {
			doubledPawns += Math.max(pawnStructure[j]-1, 0);
		}
		
		return doubledPawns;
	}
	
	public static int scoreOfPawnStructure(Board board) {
		List<int[]> pawnsCount = countPawns(board);
		
		int scoreOfPawnStructure = 0;
		
		int nb_doubledPawns_white = numberOfDoubledPawns(pawnsCount, true);
		int nb_doubledPawns_black = numberOfDoubledPawns(pawnsCount, false);
		scoreOfPawnStructure -= 5*(nb_doubledPawns_white - nb_doubledPawns_black);
		
		int nb_isolatedPawns_white = numberOfIsolatedPawns(pawnsCount, true);
		int nb_isolatedPawns_black = numberOfIsolatedPawns(pawnsCount, false);
		scoreOfPawnStructure -= 5*(nb_isolatedPawns_white - nb_isolatedPawns_black);
		
		return scoreOfPawnStructure;
	}
}
