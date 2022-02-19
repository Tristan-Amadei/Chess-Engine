package game;

import java.util.HashSet;
import java.util.List;

import game.MoveTypeClass.MoveType;
import game.opponent.*;
import game.pieces.*;
import game.pieces.PieceTypeClass.PieceType;

public class Main {

	public static void main(String[] args) throws IllegalMoveException {

		long t0 = System.currentTimeMillis();

		Board board = new Board();
		board.newGameBoard();

		board.board[6][4].movePiece(board, 6, 4, 4, 4);
		board.board[1][2].movePiece(board, 1, 2, 3, 2);
		board.board[7][6].movePiece(board, 7, 6, 5, 5);
		board.board[0][1].movePiece(board, 0, 1, 2, 2);
		board.board[6][3].movePiece(board, 6, 3, 4, 3);
		board.board[3][2].movePiece(board, 3, 2, 4, 3);
		board.board[5][5].movePiece(board, 5, 5, 4, 3);
		board.board[0][6].movePiece(board, 0, 6, 2, 5);
		board.board[7][1].movePiece(board, 7, 1, 5, 2);
		board.board[1][4].movePiece(board, 1, 4, 3, 4);
		board.board[4][3].movePiece(board, 4, 3, 3, 1);
		board.board[1][3].movePiece(board, 1, 3, 2, 3);
		board.board[7][2].movePiece(board, 7, 2, 3, 6);
		board.board[1][0].movePiece(board, 1, 0, 2, 0);
		board.board[3][1].movePiece(board, 3, 1, 5, 0);
		board.board[1][1].movePiece(board, 1, 1, 3, 1);
		board.board[5][2].movePiece(board, 5, 2, 3, 3);
		board.board[0][5].movePiece(board, 0, 5, 1, 4);
		board.board[3][6].movePiece(board, 3, 6, 2, 5);
		board.board[1][4].movePiece(board, 1, 4, 2, 5);
		board.board[3][3].movePiece(board, 3, 3, 2, 5);
		board.board[0][3].movePiece(board, 0, 3, 2, 5);
		board.board[7][3].movePiece(board, 7, 3, 3, 3);
		board.board[0][2].movePiece(board, 0, 2, 1, 3);
		board.board[5][0].movePiece(board, 5, 0, 3, 1);
		board.board[2][0].movePiece(board, 2, 0, 3, 1);
		Engine.playBestMove_alphaBeta(board, 2, board.colorToPlay);
		// board.playInConsole();

		board.display();
		long t1 = System.currentTimeMillis();
		System.out.println("Total time: " + (t1 - t0) + " ms");
	}
}
