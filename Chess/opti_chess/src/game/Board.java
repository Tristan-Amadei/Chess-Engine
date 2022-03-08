package game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import game.pieces.*;
import game.pieces.PieceTypeClass.PieceType;
import game.MoveTypeClass.MoveType;
import game.opponent.Engine;
import game.opponent.Evaluation;
import game.opponent.TranspositionTable;
import game.opponent.ZobristKey;

public class Board {

	public Piece[][] board;
	public boolean colorToPlay;
	public List<Move> movesPlayed; // list here, and note hashset bc we need to know what the moves contained are
									// w/o knowing them by advance
	public List<Short> inGamePieces;
	public short whiteKingPosition;
	public short blackKingPosition;
	public ZobristKey zKey;
	public TranspositionTable table;

	public Board() {
		Piece[][] gameBoard = new Piece[8][8];
		this.board = gameBoard;
		this.movesPlayed = new ArrayList<Move>();
		this.inGamePieces = new ArrayList<Short>();
		ZobristKey zKey = new ZobristKey();
		zKey.zobristFillArray();
		this.zKey = zKey;
		this.table = new TranspositionTable();
	}

	public void newGameBoard() {
		colorToPlay = true;
		whiteKingPosition = (short) 74;
		blackKingPosition = (short) 04;
		// Set up the Black side
		board[0][0] = new Rook(false);
		inGamePieces.add((short) (10 * 0 + 0));
		board[0][1] = new Knight(false);
		inGamePieces.add((short) (10 * 0 + 1));
		board[0][2] = new Bishop(false);
		inGamePieces.add((short) (10 * 0 + 2));
		board[0][3] = new Queen(false);
		inGamePieces.add((short) (10 * 0 + 3));
		board[0][4] = new King(false);
		inGamePieces.add((short) (10 * 0 + 4));
		board[0][5] = new Bishop(false);
		inGamePieces.add((short) (10 * 0 + 5));
		board[0][6] = new Knight(false);
		inGamePieces.add((short) (10 * 0 + 6));
		board[0][7] = new Rook(false);
		inGamePieces.add((short) (10 * 0 + 7));

		// Set up the White side
		board[7][0] = new Rook(true);
		inGamePieces.add((short) (10 * 7 + 0));
		board[7][1] = new Knight(true);
		inGamePieces.add((short) (10 * 7 + 1));
		board[7][2] = new Bishop(true);
		inGamePieces.add((short) (10 * 7 + 2));
		board[7][3] = new Queen(true);
		inGamePieces.add((short) (10 * 7 + 3));
		board[7][4] = new King(true);
		inGamePieces.add((short) (10 * 7 + 4));
		board[7][5] = new Bishop(true);
		inGamePieces.add((short) (10 * 7 + 5));
		board[7][6] = new Knight(true);
		inGamePieces.add((short) (10 * 7 + 6));
		board[7][7] = new Rook(true);
		inGamePieces.add((short) (10 * 7 + 7));

		// Set up the pawns
		for (int i = 0; i < 8; i++) {
			board[6][i] = new Pawn(true);
			inGamePieces.add((short) (10 * 6 + i));
			board[1][i] = new Pawn(false);
			inGamePieces.add((short) (10 * 1 + i));
		}
	}

	public void display() {
		System.out.println("+---------+---------+---------+---------+---------+---------+---------+---------+");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print("|");
				if (board[i][j] != null) {
					board[i][j].display();
				} else {
					System.out.print("        ");
				}
				System.out.print(" ");
			}
			System.out.print("|");
			System.out.println();
			System.out.println("+---------+---------+---------+---------+---------+---------+---------+---------+");
		}
	}

	public void playInConsole() {
		Scanner sc = new Scanner(System.in);
		String keepGoing = "yes";
		int depth;
		this.display();
		while (!keepGoing.equals("no")) {

			boolean moveValid = false;
			while (!moveValid) {
				System.out.println("What piece to move? Type 'Engine' should you want the engine to play on this move");
				String coor_piece = sc.next();
				if (coor_piece.equals("engine") || coor_piece.equals("Engine")) {
					System.out.println("To what depth?");
					depth = sc.nextInt();
					while (depth < 1) {
						System.out.println("To what depth?");
						depth = sc.nextInt();
					}
					Engine.playBestMove_alphaBeta(this, depth, colorToPlay);
				} else {
					char colonne = coor_piece.charAt(0);
					char ligne = coor_piece.charAt(coor_piece.length() - 1);
					int i_piece = 8 - Character.getNumericValue(ligne);
					int j_piece = (int) colonne - 97;

					System.out.println("What square to move it onto ?");
					String case_ = sc.next();
					char col_case = case_.charAt(0);
					char li_case = case_.charAt(case_.length() - 1);
					int i_case = 8 - Character.getNumericValue(li_case);
					int j_case = (int) col_case - 97;

					try {
						board[i_piece][j_piece].movePiece(this, i_piece, j_piece, i_case, j_case);
						moveValid = true;
					} catch (IllegalMoveException illegal) {
						System.out.println("Invalid Move");
					} catch (Exception e) {
						System.out.println("Bug with the code");
					}
				}

				this.display();
				System.out.println("Position Evaluation: " + Evaluation.overallEvaluation(this) / 100 + "\n");
				System.out.println("Wish to keep playing? Enter yes if so");
				keepGoing = sc.next();
			}
		}
		sc.close();
	}

	public void unmakeMoveEnPassant() {
		Move lastMove = movesPlayed.get(movesPlayed.size() - 1);
		if (lastMove.getMoveType() == MoveType.EnPassant) {
			int start_line = lastMove.getStartSquare() / 10;
			int start_col = lastMove.getStartSquare() - 10 * start_line;
			int landing_line = lastMove.getLandingSquare() / 10;
			int landing_col = lastMove.getLandingSquare() - 10 * landing_line;

			board[start_line][start_col] = board[landing_line][landing_col];
			inGamePieces.add(lastMove.getStartSquare());
			board[landing_line][landing_col] = null;
			inGamePieces.remove((Object) (lastMove.getLandingSquare()));

			boolean colorOfPawnCapturing = lastMove.getColorOfPiece();
			board[start_line][landing_col] = new Pawn(!colorOfPawnCapturing);
			inGamePieces.add((short) (10 * start_line + landing_col));

			colorToPlay = !colorToPlay;
			movesPlayed.remove(movesPlayed.size() - 1);
		}
	}

	public void unmakeMoveKingSideCastle() {
		Move lastMove = movesPlayed.get(movesPlayed.size() - 1);
		if (lastMove.getMoveType() == MoveType.KingSideCastle) {
			int start_line = lastMove.getStartSquare() / 10;
			int start_col = lastMove.getStartSquare() - 10 * start_line;
			int landing_line = lastMove.getLandingSquare() / 10;
			int landing_col = lastMove.getLandingSquare() - 10 * landing_line;

			board[start_line][start_col] = board[landing_line][landing_col];
			inGamePieces.add(lastMove.getStartSquare());
			board[landing_line][landing_col] = null;
			inGamePieces.remove((Object) (lastMove.getLandingSquare()));

			board[landing_line][landing_col + 1] = board[landing_line][start_col + 1];
			inGamePieces.add((short) (10 * landing_line + landing_col + 1));
			board[landing_line][start_col + 1] = null;
			inGamePieces.remove((Object) ((short) (10 * landing_line + start_col + 1)));

			((King) board[start_line][4]).hasMoved = false; // necessarily false otherwise castling would not have been
															// possible
			((Rook) board[start_line][7]).hasMoved = false;

			if (landing_line == 0) { // black king
				blackKingPosition = (short) (04);
			} else {
				whiteKingPosition = (short) (74);
			}

			if (landing_line == 0) { // black king
				blackKingPosition = (short) (04);
			} else {
				whiteKingPosition = (short) (74);
			}

			colorToPlay = !colorToPlay;
			movesPlayed.remove(movesPlayed.size() - 1);
		}
	}

	public void unmakeMoveQueenSideCastle() {
		Move lastMove = movesPlayed.get(movesPlayed.size() - 1);
		if (lastMove.getMoveType() == MoveType.QueenSideCastle) {
			int start_line = lastMove.getStartSquare() / 10;
			int start_col = lastMove.getStartSquare() - 10 * start_line;
			int landing_line = lastMove.getLandingSquare() / 10;
			int landing_col = lastMove.getLandingSquare() - 10 * landing_line;

			board[start_line][start_col] = board[landing_line][landing_col];
			inGamePieces.add(lastMove.getStartSquare());
			board[landing_line][landing_col] = null;
			inGamePieces.remove((Object) (lastMove.getLandingSquare()));

			board[landing_line][0] = board[landing_line][start_col - 1];
			inGamePieces.add((short) (10 * landing_line + 0));
			board[landing_line][start_col - 1] = null;
			inGamePieces.remove((Object) ((short) (10 * landing_line + start_col - 1)));

			((King) board[start_line][4]).hasMoved = false; // necessarily false otherwise castling would not have been
															// possible
			((Rook) board[start_line][0]).hasMoved = false;

			if (landing_line == 0) { // black king
				blackKingPosition = (short) (04);
			} else {
				whiteKingPosition = (short) (74);
			}

			colorToPlay = !colorToPlay;
			movesPlayed.remove(movesPlayed.size() - 1);
		}
	}

	public void unmakeMoveNormal() {
		Move lastMove = movesPlayed.get(movesPlayed.size() - 1);
		if (lastMove.getMoveType() == MoveType.Normal) {
			int start_line = lastMove.getStartSquare() / 10;
			int start_col = lastMove.getStartSquare() - 10 * start_line;
			int landing_line = lastMove.getLandingSquare() / 10;
			int landing_col = lastMove.getLandingSquare() - 10 * landing_line;

			board[start_line][start_col] = board[landing_line][landing_col];
			inGamePieces.add(lastMove.getStartSquare());

			if (lastMove.getCapturedPiece() == null) {
				board[landing_line][landing_col] = null;
				inGamePieces.remove((Object) (lastMove.getLandingSquare()));
			} else {
				switch (lastMove.getCapturedPiece()) {
				case Pawn:
					board[landing_line][landing_col] = new Pawn(!lastMove.getColorOfPiece());
					break;
				case Bishop:
					board[landing_line][landing_col] = new Bishop(!lastMove.getColorOfPiece());
					break;
				case Knight:
					board[landing_line][landing_col] = new Knight(!lastMove.getColorOfPiece());
					break;
				case Rook:
					board[landing_line][landing_col] = new Rook(!lastMove.getColorOfPiece());
					break;
				case Queen:
					board[landing_line][landing_col] = new Queen(!lastMove.getColorOfPiece());
					break;
				case King:
					board[landing_line][landing_col] = new King(!lastMove.getColorOfPiece());
					break;
				}
			}

			if (lastMove.getMovedPiece() == PieceType.King) {
				if (lastMove.getColorOfPiece()) {
					whiteKingPosition = (short) (10 * start_line + start_col);
					((King) board[start_line][start_col]).hasMoved = this.whiteKingHasAlreadyMoved();
				} else {
					blackKingPosition = (short) (10 * start_line + start_col);
					((King) board[start_line][start_col]).hasMoved = this.blackKingHasAlreadyMoved();
				}
			}

			if (lastMove.getMovedPiece() == PieceType.Rook) {
				switch (lastMove.getStartSquare()) {
				case (short) 77:
					((Rook) board[7][7]).hasMoved = this.whiteRook77hasAlreadyMoved();
					break;
				case (short) 70:
					((Rook) board[7][0]).hasMoved = this.whiteRook70hasAlreadyMoved();
					break;
				case (short) 00:
					((Rook) board[0][0]).hasMoved = this.blackRook00hasAlreadyMoved();
					break;
				case (short) 07:
					((Rook) board[0][7]).hasMoved = this.blackRook07hasAlreadyMoved();
					break;
				}
			}

			colorToPlay = !colorToPlay;
			movesPlayed.remove(movesPlayed.size() - 1);
		}
	}

	public void unmakeMovePromotion() {
		Move lastMove = movesPlayed.get(movesPlayed.size() - 1);
		if (lastMove.getMoveType() == MoveType.Promotion) {
			int start_line = lastMove.getStartSquare() / 10;
			int start_col = lastMove.getStartSquare() - 10 * start_line;
			int landing_line = lastMove.getLandingSquare() / 10;
			int landing_col = lastMove.getLandingSquare() - 10 * landing_line;

			board[start_line][start_col] = new Pawn(lastMove.getColorOfPiece());
			board[landing_line][landing_col] = null;
			inGamePieces.add(lastMove.getStartSquare());

			if (lastMove.getCapturedPiece() == null) {
				board[landing_line][landing_col] = null;
				inGamePieces.remove((Object) (lastMove.getLandingSquare()));
			} else {
				switch (lastMove.getCapturedPiece()) {
				case Pawn:
					board[landing_line][landing_col] = new Pawn(!lastMove.getColorOfPiece());
					break;
				case Bishop:
					board[landing_line][landing_col] = new Bishop(!lastMove.getColorOfPiece());
					break;
				case Knight:
					board[landing_line][landing_col] = new Knight(!lastMove.getColorOfPiece());
					break;
				case Rook:
					board[landing_line][landing_col] = new Rook(!lastMove.getColorOfPiece());
					break;
				case Queen:
					board[landing_line][landing_col] = new Queen(!lastMove.getColorOfPiece());
					break;
				case King:
					board[landing_line][landing_col] = new King(!lastMove.getColorOfPiece());
					break;
				}
			}

			colorToPlay = !colorToPlay;
			movesPlayed.remove(movesPlayed.size() - 1);
		}
	}

	public void unmakeMove() {
		Move lastMove = movesPlayed.get(movesPlayed.size() - 1);
		switch (lastMove.getMoveType()) {
		case EnPassant:
			unmakeMoveEnPassant();
			break;
		case KingSideCastle:
			unmakeMoveKingSideCastle();
			break;
		case QueenSideCastle:
			unmakeMoveQueenSideCastle();
			break;
		case Normal:
			unmakeMoveNormal();
			break;
		case Promotion:
			unmakeMovePromotion();
			break;
		default: break;
		}
	}

	public short getKingPosition(boolean color) {
		if (color) {
			return whiteKingPosition;
		} else {
			return blackKingPosition;
		}
	}

	public boolean whiteKingHasAlreadyMoved() {
		if (whiteKingPosition != (short) 74) {
			return true;
		}
		for (int i = 0; i < movesPlayed.size() - 1; i++) {
			Move move = movesPlayed.get(i);
			if ((move.getMoveType() == MoveType.KingSideCastle || move.getMoveType() == MoveType.QueenSideCastle)
					&& move.getColorOfPiece()) {
				return true;
			}
			if (move.getMovedPiece() == PieceType.King && move.getColorOfPiece()) {
				return true;
			}
		}
		return false;
	}

	public boolean blackKingHasAlreadyMoved() {
		if (blackKingPosition != (short) 04) {
			return true;
		}
		for (int i = 0; i < movesPlayed.size() - 1; i++) {
			Move move = movesPlayed.get(i);
			if ((move.getMoveType() == MoveType.KingSideCastle || move.getMoveType() == MoveType.QueenSideCastle)
					&& !move.getColorOfPiece()) {
				return true;
			}
			if (move.getMovedPiece() == PieceType.King && !move.getColorOfPiece()) {
				return true;
			}
		}
		return false;
	}

	public boolean whiteRook77hasAlreadyMoved() {
		if (board[7][7] == null || !(board[7][7].getType() == PieceType.Rook && board[7][7].getColor())) {
			return false;
		}
		for (int i = 0; i < movesPlayed.size() - 1; i++) {
			Move move = movesPlayed.get(i);
			if (move.getMovedPiece() == PieceType.Rook && move.getStartSquare() == ((short) 77)
					&& move.getColorOfPiece()) {
				return true;
			}
		}
		return false;
	}

	public boolean whiteRook70hasAlreadyMoved() {
		if (board[7][0] == null || !(board[7][0].getType() == PieceType.Rook && board[7][0].getColor())) {
			return false;
		}
		for (int i = 0; i < movesPlayed.size() - 1; i++) {
			Move move = movesPlayed.get(i);
			if (move.getMovedPiece() == PieceType.Rook && move.getStartSquare() == ((short) 70)
					&& move.getColorOfPiece()) {
				return true;
			}
		}
		return false;
	}

	public boolean blackRook00hasAlreadyMoved() {
		if (board[0][0] == null || !(board[0][0].getType() == PieceType.Rook && board[0][0].getColor() == false)) {
			return false;
		}
		for (int i = 0; i < movesPlayed.size() - 1; i++) {
			Move move = movesPlayed.get(i);
			if (move.getMovedPiece() == PieceType.Rook && move.getStartSquare() == ((short) 00)
					&& move.getColorOfPiece() == false) {
				return true;
			}
		}
		return false;
	}

	public boolean blackRook07hasAlreadyMoved() {
		if (board[0][7] == null || !(board[0][7].getType() == PieceType.Rook && board[0][7].getColor() == false)) {
			return false;
		}
		for (int i = 0; i < movesPlayed.size() - 1; i++) {
			Move move = movesPlayed.get(i);
			if (move.getMovedPiece() == PieceType.Rook && move.getStartSquare() == ((short) 07)
					&& move.getColorOfPiece() == false) {
				return true;
			}
		}
		return false;
	}
	
	public List<Move> allLegalMoves() {
		List<Short> copy = new ArrayList<Short>();
		copy.addAll(inGamePieces);
		List<Move> allMoves = new ArrayList<Move>();
		for (short piece_square : copy) {
			int line = piece_square / 10;
			int col = piece_square - 10 * line;
			Piece piece = board[line][col];
			HashSet<Short> moves = piece.legalMoves(this, line, col);
			for (short move_square : moves) {
				Move primitiveMove = new Move(piece.getType(), piece.getColor(), piece_square, move_square, null, MoveType.Normal);
				Move elaborateMove = primitiveMove.returnMoveFromHashSet(this, piece.getType(), piece.getColor(), piece_square, move_square);
				allMoves.add(elaborateMove);
			}
		}
		return allMoves;
	}
	
	public List<Move> allCaptureMoves() {
		List<Move> moves = this.allLegalMoves();
		List<Move> captures = new ArrayList<Move>();
		for (Move move : moves) {
			if (move.getCapturedPiece() != null) {
				captures.add(move);
			}
		}
		return captures;
	}
	
	public HashSet<Short> allPossibleMoveSquares(boolean color) {
		HashSet<Short> moveSquares = new HashSet<>();
		for (short moveSquare : moveSquares) {
			if (board[moveSquare/10][moveSquare*10].getColor() == color) {
				moveSquares.addAll(board[moveSquare/10][moveSquare*10].possibleMoves(this, moveSquare/10, moveSquare*10));
				if (board[moveSquare/10][moveSquare*10].getType() == PieceType.Pawn) {
					moveSquares.addAll(((Pawn) board[moveSquare/10][moveSquare*10]).enPassant(this, moveSquare/10, moveSquare*10));
				}
			}
		}
		return moveSquares;
	}
}
