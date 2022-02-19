package game.pieces;

import java.util.HashSet;

import game.Board;
import game.pieces.PieceTypeClass.PieceType;

public class Bishop extends Piece {

	public Bishop(final boolean color) {
		super(PieceType.Bishop, color);
	}

	public void display() {
		if (color) {
			System.out.print("W Bishop");
		} else {
			System.out.print("B Bishop");
		}
	}

	public HashSet<Short> possibleMoves(Board board, int line, int colonne) {
		HashSet<Short> moves = new HashSet<>();
		short new_coordinate;

		int k = line - 1;
		int l = colonne - 1;
		while (k >= 0 && l >= 0 && board.board[k][l] == null) { // on regarde les cases sur la diagonale en haut a
																// gauche de la piece
			new_coordinate = (short) (10 * k + l);
			moves.add(new_coordinate);
			k--;
			l--;
		}
		if (k >= 0 && l >= 0) {
			if (board.board[k][l].color != color) {
				new_coordinate = (short) (10 * k + l);
				moves.add(new_coordinate);
			}
		}

		k = line - 1;
		l = colonne + 1;
		while (k >= 0 && l < 8 && board.board[k][l] == null) { // on regarde les cases sur la diagonale en haut a droite
																// de la piece
			new_coordinate = (short) (10 * k + l);
			moves.add(new_coordinate);
			k--;
			l++;
		}
		if (k >= 0 && l < 8) {
			if (board.board[k][l].color != color) { // on a rencontre une case non vide, on regarde si on peut capturer
													// la piece ou non
				new_coordinate = (short) (10 * k + l);
				moves.add(new_coordinate);
			}
		}

		k = line + 1;
		l = colonne - 1;
		while (k < 8 && l >= 0 && board.board[k][l] == null) { // on regarde les cases sur la diagonale en bas a gauche
																// de la piece
			new_coordinate = (short) (10 * k + l);
			moves.add(new_coordinate);
			k++;
			l--;
		}
		if (k < 8 && l >= 0) {
			if (board.board[k][l].color != color) {
				new_coordinate = (short) (10 * k + l);
				moves.add(new_coordinate);
			}
		}

		k = line + 1;
		l = colonne + 1;
		while (k < 8 && l < 8 && board.board[k][l] == null) { // on regarde les cases sur la diagonale en bas a droite
																// de la piece
			new_coordinate = (short) (10 * k + l);
			moves.add(new_coordinate);
			k++;
			l++;
		}
		if (k < 8 && l < 8) {
			if (board.board[k][l].color != color) {
				new_coordinate = (short) (10 * k + l);
				moves.add(new_coordinate);
			}
		}
		return moves;
	}

	public HashSet<Short> legalMoves(Board board, int i, int j) {
		HashSet<Short> legal_moves = new HashSet<Short>();
		HashSet<Short> moves = board.board[i][j].possibleMoves(board, i, j);
		for (short square_move : moves) {
			try {
				if (!checkMoveIsIllegal(board, i, j, square_move / 10, square_move - 10 * (square_move / 10))) {
					legal_moves.add(square_move);
				}
			} catch (Exception e) {
				// nothing to do, bc the way we did it, no exception can actually be cuaght
			}
		}
		return legal_moves;
	}
}
