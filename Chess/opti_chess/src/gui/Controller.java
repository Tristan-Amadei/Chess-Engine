package gui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import game.MoveTypeClass.MoveType;
import game.opponent.Engine;
import game.opponent.Evaluation;
import game.pieces.PieceTypeClass.PieceType;
import game.*;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class Controller {
	
	@FXML
	public void opponentPlay(KeyEvent e) {
		KeyCode code = e.getCode();
		switch (code) {
		case ENTER:
			System.out.println("Engine summoned");
			Engine.playBestMove_alphaBeta(RunningGUI.gameBoard, 3, RunningGUI.gameBoard.colorToPlay);
			this.movePieceFromLastMove();
			break;
		case LEFT:
			System.out.println("Random Moves");
			this.randomMoves();
			break;
		default:
			break;
		}
	}

	public void randomMoves() {
		List<Move> moves = RunningGUI.gameBoard.allLegalMoves();
		while (moves.size() > 0) {
			Random rand = new Random();
			Move chosenMove = moves.get(rand.nextInt(moves.size()));
			chosenMove.playMove(RunningGUI.gameBoard);
			this.movePieceFromLastMove();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
			}
			RunningGUI.gameBoard.display();
			moves = RunningGUI.gameBoard.allLegalMoves();
		}
	}

	@FXML
	private TextArea ColorToPlay;
	@FXML
	private TextArea boardEvaluation;

	public void setColorToPlay() {
		String color;
		if (RunningGUI.gameBoard.colorToPlay) {
			color = "White";
		} else {
			color = "Black";
		}
		ColorToPlay.setText(color);
	}

	public void setEvaluation() {
		double eval = Evaluation.overallEvaluation(RunningGUI.gameBoard);
		String str_eval = "" + eval;
		boardEvaluation.setText(str_eval);
	}

	@FXML
	private ImageView WRook1;
	private double xwRook1;
	private double ywRook1;
	private int line_WRook1 = 7;
	private int col_WRook1 = 0;
	@FXML
	private ImageView WRook2;
	private double xwRook2;
	private double ywRook2;
	private int line_WRook2 = 7;
	private int col_WRook2 = 7;
	@FXML
	private ImageView BRook1;
	private double xbRook1;
	private double ybRook1;
	private int line_BRook1 = 0;
	private int col_BRook1 = 0;
	@FXML
	private ImageView BRook2;
	private double xbRook2;
	private double ybRook2;
	private int line_BRook2 = 0;
	private int col_BRook2 = 7;

	@FXML
	private ImageView WKnight1;
	private double xwKnight1 = 87.5;
	private double ywKnight1 = 612.5;
	private int line_WKnight1 = 7;
	private int col_WKnight1 = 1;
	@FXML
	private ImageView WKnight2;
	private double xwKnight2;
	private double ywKnight2;
	private int line_WKnight2 = 7;
	private int col_WKnight2 = 6;
	@FXML
	private ImageView BKnight1;
	private double xbKnight1;
	private double ybKnight1;
	private int line_BKnight1 = 0;
	private int col_BKnight1 = 1;
	@FXML
	private ImageView BKnight2;
	private double xbKnight2;
	private double ybKnight2;
	private int line_BKnight2 = 0;
	private int col_BKnight2 = 6;

	@FXML
	private ImageView WBishop1;
	private double xwBishop1;
	private double ywBishop1;
	private int line_WBishop1 = 7;
	private int col_WBishop1 = 2;
	@FXML
	private ImageView WBishop2;
	private double xwBishop2;
	private double ywBishop2;
	private int line_WBishop2 = 7;
	private int col_WBishop2 = 5;
	@FXML
	private ImageView BBishop1;
	private double xbBishop1;
	private double ybBishop1;
	private int line_BBishop1 = 0;
	private int col_BBishop1 = 2;
	@FXML
	private ImageView BBishop2;
	private double xbBishop2;
	private double ybBishop2;
	private int line_BBishop2 = 0;
	private int col_BBishop2 = 5;

	@FXML
	private ImageView WQueen;
	private double xwQueen;
	private double ywQueen;
	private int line_WQueen = 7;
	private int col_WQueen = 3;
	@FXML
	private ImageView BQueen;
	private double xbQueen;
	private double ybQueen;
	private int line_BQueen = 0;
	private int col_BQueen = 3;

	@FXML
	private ImageView WKing;
	private double xwKing;
	private double ywKing;
	private int line_WKing = 7;
	private int col_WKing = 4;
	@FXML
	private ImageView BKing;
	private double xbKing;
	private double ybKing;
	private int line_BKing = 0;
	private int col_BKing = 4;

	@FXML
	private ImageView WPawn1;
	private double xwPawn1;
	private double ywPawn1;
	private int line_WPawn1 = 6;
	private int col_WPawn1 = 0;
	@FXML
	private ImageView WPawn2;
	private double xwPawn2;
	private double ywPawn2;
	private int line_WPawn2 = 6;
	private int col_WPawn2 = 1;
	@FXML
	private ImageView WPawn3;
	private double xwPawn3;
	private double ywPawn3;
	private int line_WPawn3 = 6;
	private int col_WPawn3 = 2;
	@FXML
	private ImageView WPawn4;
	private double xwPawn4;
	private double ywPawn4;
	private int line_WPawn4 = 6;
	private int col_WPawn4 = 3;
	@FXML
	private ImageView WPawn5;
	private double xwPawn5;
	private double ywPawn5;
	private int line_WPawn5 = 6;
	private int col_WPawn5 = 4;
	@FXML
	private ImageView WPawn6;
	private double xwPawn6;
	private double ywPawn6;
	private int line_WPawn6 = 6;
	private int col_WPawn6 = 5;
	@FXML
	private ImageView WPawn7;
	private double xwPawn7;
	private double ywPawn7;
	private int line_WPawn7 = 6;
	private int col_WPawn7 = 6;
	@FXML
	private ImageView WPawn8;
	private double xwPawn8;
	private double ywPawn8;
	private int line_WPawn8 = 6;
	private int col_WPawn8 = 7;

	@FXML
	private ImageView BPawn1;
	private double xbPawn1;
	private double ybPawn1;
	private int line_BPawn1 = 1;
	private int col_BPawn1 = 0;
	@FXML
	private ImageView BPawn2;
	private double xbPawn2;
	private double ybPawn2;
	private int line_BPawn2 = 1;
	private int col_BPawn2 = 1;
	@FXML
	private ImageView BPawn3;
	private double xbPawn3;
	private double ybPawn3;
	private int line_BPawn3 = 1;
	private int col_BPawn3 = 2;
	@FXML
	private ImageView BPawn4;
	private double xbPawn4;
	private double ybPawn4;
	private int line_BPawn4 = 1;
	private int col_BPawn4 = 3;
	@FXML
	private ImageView BPawn5;
	private double xbPawn5;
	private double ybPawn5;
	private int line_BPawn5 = 1;
	private int col_BPawn5 = 4;
	@FXML
	private ImageView BPawn6;
	private double xbPawn6;
	private double ybPawn6;
	private int line_BPawn6 = 1;
	private int col_BPawn6 = 5;
	@FXML
	private ImageView BPawn7;
	private double xbPawn7;
	private double ybPawn7;
	private int line_BPawn7 = 1;
	private int col_BPawn7 = 6;
	@FXML
	private ImageView BPawn8;
	private double xbPawn8;
	private double ybPawn8;
	private int line_BPawn8 = 1;
	private int col_BPawn8 = 7;

	public void follow_WRook1(MouseEvent e) {
		WRook1.setLayoutX(xwRook1 = e.getSceneX() - (87.5 / 2));
		WRook1.setLayoutY(ywRook1 = e.getSceneY() - (87.5 / 2));
		WRook1.toFront();
		WRook1.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_WRook2(MouseEvent e) {
		WRook2.setLayoutX(xwRook2 = e.getSceneX() - (87.5 / 2));
		WRook2.setLayoutY(ywRook2 = e.getSceneY() - (87.5 / 2));
		WRook2.toFront();
		WRook2.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_BRook1(MouseEvent e) {
		BRook1.setLayoutX(xbRook1 = e.getSceneX() - (87.5 / 2));
		BRook1.setLayoutY(ybRook1 = e.getSceneY() - (87.5 / 2));
		BRook1.toFront();
		BRook1.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_BRook2(MouseEvent e) {
		BRook2.setLayoutX(xbRook2 = e.getSceneX() - (87.5 / 2));
		BRook2.setLayoutY(ybRook2 = e.getSceneY() - (87.5 / 2));
		BRook2.toFront();
		BRook2.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_WKnight1(MouseEvent e) {
		WKnight1.setLayoutX(xwKnight1 = e.getSceneX() - (87.5 / 2));
		WKnight1.setLayoutY(ywKnight1 = e.getSceneY() - (87.5 / 2));
		WKnight1.toFront();
		WKnight1.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_WKnight2(MouseEvent e) {
		WKnight2.setLayoutX(xwKnight2 = e.getSceneX() - (87.5 / 2));
		WKnight2.setLayoutY(ywKnight2 = e.getSceneY() - (87.5 / 2));
		WKnight2.toFront();
		WKnight2.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_BKnight1(MouseEvent e) {
		BKnight1.setLayoutX(xbKnight1 = e.getSceneX() - (87.5 / 2));
		BKnight1.setLayoutY(ybKnight1 = e.getSceneY() - (87.5 / 2));
		BKnight1.toFront();
		BKnight1.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_BKnight2(MouseEvent e) {
		BKnight2.setLayoutX(xbKnight2 = e.getSceneX() - (87.5 / 2));
		BKnight2.setLayoutY(ybKnight2 = e.getSceneY() - (87.5 / 2));
		BKnight2.toFront();
		BKnight2.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_WBishop1(MouseEvent e) {
		WBishop1.setLayoutX(xwBishop1 = e.getSceneX() - (87.5 / 2));
		WBishop1.setLayoutY(ywBishop1 = e.getSceneY() - (87.5 / 2));
		WBishop1.toFront();
		WBishop1.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_WBishop2(MouseEvent e) {
		WBishop2.setLayoutX(xwBishop2 = e.getSceneX() - (87.5 / 2));
		WBishop2.setLayoutY(ywBishop2 = e.getSceneY() - (87.5 / 2));
		WBishop2.toFront();
		WBishop2.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_BBishop1(MouseEvent e) {
		BBishop1.setLayoutX(xbBishop1 = e.getSceneX() - (87.5 / 2));
		BBishop1.setLayoutY(ybBishop1 = e.getSceneY() - (87.5 / 2));
		BBishop1.toFront();
		BBishop1.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_BBishop2(MouseEvent e) {
		BBishop2.setLayoutX(xbBishop2 = e.getSceneX() - (87.5 / 2));
		BBishop2.setLayoutY(ybBishop2 = e.getSceneY() - (87.5 / 2));
		BBishop2.toFront();
		BBishop2.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_WQueen(MouseEvent e) {
		WQueen.setLayoutX(xwQueen = e.getSceneX() - (87.5 / 2));
		WQueen.setLayoutY(ywQueen = e.getSceneY() - (87.5 / 2));
		WQueen.toFront();
		WQueen.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_BQueen(MouseEvent e) {
		BQueen.setLayoutX(xbQueen = e.getSceneX() - (87.5 / 2));
		BQueen.setLayoutY(ybQueen = e.getSceneY() - (87.5 / 2));
		BQueen.toFront();
		BQueen.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_WKing(MouseEvent e) {
		WKing.setLayoutX(xwKing = e.getSceneX() - (87.5 / 2));
		WKing.setLayoutY(ywKing = e.getSceneY() - (87.5 / 2));
		WKing.toFront();
		WKing.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_BKing(MouseEvent e) {
		BKing.setLayoutX(xbKing = e.getSceneX() - (87.5 / 2));
		BKing.setLayoutY(ybKing = e.getSceneY() - (87.5 / 2));
		BKing.toFront();
		BKing.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_WPawn1(MouseEvent e) {
		WPawn1.setLayoutX(xwPawn1 = e.getSceneX() - (87.5 / 2));
		WPawn1.setLayoutY(ywPawn1 = e.getSceneY() - (87.5 / 2));
		WPawn1.toFront();
		WPawn1.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_WPawn2(MouseEvent e) {
		WPawn2.setLayoutX(xwPawn2 = e.getSceneX() - (87.5 / 2));
		WPawn2.setLayoutY(ywPawn2 = e.getSceneY() - (87.5 / 2));
		WPawn2.toFront();
		WPawn2.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_WPawn3(MouseEvent e) {
		WPawn3.setLayoutX(xwPawn3 = e.getSceneX() - (87.5 / 2));
		WPawn3.setLayoutY(ywPawn3 = e.getSceneY() - (87.5 / 2));
		WPawn3.toFront();
		WPawn3.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_WPawn4(MouseEvent e) {
		WPawn4.setLayoutX(xwPawn4 = e.getSceneX() - (87.5 / 2));
		WPawn4.setLayoutY(ywPawn4 = e.getSceneY() - (87.5 / 2));
		WPawn4.toFront();
		WPawn4.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_WPawn5(MouseEvent e) {
		WPawn5.setLayoutX(xwPawn5 = e.getSceneX() - (87.5 / 2));
		WPawn5.setLayoutY(ywPawn5 = e.getSceneY() - (87.5 / 2));
		WPawn5.toFront();
		WPawn5.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_WPawn6(MouseEvent e) {
		WPawn6.setLayoutX(xwPawn6 = e.getSceneX() - (87.5 / 2));
		WPawn6.setLayoutY(ywPawn6 = e.getSceneY() - (87.5 / 2));
		WPawn6.toFront();
		WPawn6.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_WPawn7(MouseEvent e) {
		WPawn7.setLayoutX(xwPawn7 = e.getSceneX() - (87.5 / 2));
		WPawn7.setLayoutY(ywPawn7 = e.getSceneY() - (87.5 / 2));
		WPawn7.toFront();
		WPawn7.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_WPawn8(MouseEvent e) {
		WPawn8.setLayoutX(xwPawn8 = e.getSceneX() - (87.5 / 2));
		WPawn8.setLayoutY(ywPawn8 = e.getSceneY() - (87.5 / 2));
		WPawn8.toFront();
		WPawn8.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_BPawn1(MouseEvent e) {
		BPawn1.setLayoutX(xbPawn1 = e.getSceneX() - (87.5 / 2));
		BPawn1.setLayoutY(ybPawn1 = e.getSceneY() - (87.5 / 2));
		BPawn1.toFront();
		BPawn1.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_BPawn2(MouseEvent e) {
		BPawn2.setLayoutX(xbPawn2 = e.getSceneX() - (87.5 / 2));
		BPawn2.setLayoutY(ybPawn2 = e.getSceneY() - (87.5 / 2));
		BPawn2.toFront();
		BPawn2.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_BPawn3(MouseEvent e) {
		BPawn3.setLayoutX(xbPawn3 = e.getSceneX() - (87.5 / 2));
		BPawn3.setLayoutY(ybPawn3 = e.getSceneY() - (87.5 / 2));
		BPawn3.toFront();
		BPawn3.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_BPawn4(MouseEvent e) {
		BPawn4.setLayoutX(xbPawn4 = e.getSceneX() - (87.5 / 2));
		BPawn4.setLayoutY(ybPawn4 = e.getSceneY() - (87.5 / 2));
		BPawn4.toFront();
		BPawn4.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_BPawn5(MouseEvent e) {
		BPawn5.setLayoutX(xbPawn5 = e.getSceneX() - (87.5 / 2));
		BPawn5.setLayoutY(ybPawn5 = e.getSceneY() - (87.5 / 2));
		BPawn5.toFront();
		BPawn5.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_BPawn6(MouseEvent e) {
		BPawn6.setLayoutX(xbPawn6 = e.getSceneX() - (87.5 / 2));
		BPawn6.setLayoutY(ybPawn6 = e.getSceneY() - (87.5 / 2));
		BPawn6.toFront();
		BPawn6.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_BPawn7(MouseEvent e) {
		BPawn7.setLayoutX(xbPawn7 = e.getSceneX() - (87.5 / 2));
		BPawn7.setLayoutY(ybPawn7 = e.getSceneY() - (87.5 / 2));
		BPawn7.toFront();
		BPawn7.setCursor(Cursor.CLOSED_HAND);
	}

	public void follow_BPawn8(MouseEvent e) {
		BPawn8.setLayoutX(xbPawn8 = e.getSceneX() - (87.5 / 2));
		BPawn8.setLayoutY(ybPawn8 = e.getSceneY() - (87.5 / 2));
		BPawn8.toFront();
		BPawn8.setCursor(Cursor.CLOSED_HAND);
	}

	public void possibleMoves(MouseEvent e) {
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		HashSet<Short> moves = RunningGUI.gameBoard.board[i][j].legalMoves(RunningGUI.gameBoard, i, j);
		if (listCircle.size() == 0) {
			this.setList();
		}
		for (int k = 0; k < 8; k++) {
			for (int l = 0; l < 8; l++) {
				if (moves.contains((Object) ((short) (10 * k + l)))) {
					double opacity = listCircle.get(8 * k + l).getOpacity();
					if (opacity == 0) {
						listCircle.get(8 * k + l).toFront();
					} else {
						listCircle.get(8 * k + l).toBack();
					}
					listCircle.get(8 * k + l).setOpacity(0.5 - opacity);

				}
			}
		}
	}

	public void move_WRook1(MouseEvent e) {
		WRook1.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			WRook1.toFront();
			RunningGUI.gameBoard.board[line_WRook1][col_WRook1].movePiece(RunningGUI.gameBoard, line_WRook1, col_WRook1,
					i, j);
			this.reactIfCapture(i, j);
			line_WRook1 = i;
			col_WRook1 = j;
			WRook1.setLayoutX(xwRook1 = col_WRook1 * (700 / 8 + 0.5));
			WRook1.setLayoutY(ywRook1 = line_WRook1 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			WRook1.setLayoutX(xwRook1 = col_WRook1 * (700 / 8 + 0.5));
			WRook1.setLayoutY(ywRook1 = line_WRook1 * (700 / 8 + 0.5));
		}
	}

	public void move_WRook2(MouseEvent e) {
		WRook2.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			WRook2.toFront();
			RunningGUI.gameBoard.board[line_WRook2][col_WRook2].movePiece(RunningGUI.gameBoard, line_WRook2, col_WRook2,
					i, j);
			this.reactIfCapture(i, j);
			line_WRook2 = i;
			col_WRook2 = j;
			WRook2.setLayoutX(xwRook2 = col_WRook2 * (700 / 8 + 0.5));
			WRook2.setLayoutY(ywRook2 = line_WRook2 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			WRook2.setLayoutX(xwRook2 = col_WRook2 * (700 / 8 + 0.5));
			WRook2.setLayoutY(ywRook2 = line_WRook2 * (700 / 8 + 0.5));
		}
	}

	public void move_BRook1(MouseEvent e) {
		BRook1.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			BRook1.toFront();
			RunningGUI.gameBoard.board[line_BRook1][col_BRook1].movePiece(RunningGUI.gameBoard, line_BRook1, col_BRook1,
					i, j);
			this.reactIfCapture(i, j);
			line_BRook1 = i;
			col_BRook1 = j;
			BRook1.setLayoutX(xbRook1 = col_BRook1 * (700 / 8 + 0.5));
			BRook1.setLayoutY(ybRook1 = line_BRook1 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			BRook1.setLayoutX(xbRook1 = col_BRook1 * (700 / 8 + 0.5));
			BRook1.setLayoutY(ybRook1 = line_BRook1 * (700 / 8 + 0.5));
		}
	}

	public void move_BRook2(MouseEvent e) {
		BRook2.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			BRook2.toFront();
			RunningGUI.gameBoard.board[line_BRook2][col_BRook2].movePiece(RunningGUI.gameBoard, line_BRook2, col_BRook2,
					i, j);
			this.reactIfCapture(i, j);
			line_BRook2 = i;
			col_BRook2 = j;
			BRook2.setLayoutX(xbRook2 = col_BRook2 * (700 / 8 + 0.5));
			BRook2.setLayoutY(ybRook2 = line_BRook2 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			BRook2.setLayoutX(xbRook2 = col_BRook2 * (700 / 8 + 0.5));
			BRook2.setLayoutY(ybRook2 = line_BRook2 * (700 / 8 + 0.5));
		}
	}

	public void move_WKnight1(MouseEvent e) {
		WKnight1.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			WKnight1.toFront();
			RunningGUI.gameBoard.board[line_WKnight1][col_WKnight1].movePiece(RunningGUI.gameBoard, line_WKnight1,
					col_WKnight1, i, j);
			this.reactIfCapture(i, j);
			line_WKnight1 = i;
			col_WKnight1 = j;
			WKnight1.setLayoutX(xwKnight1 = col_WKnight1 * (700 / 8 + 0.5));
			WKnight1.setLayoutY(ywKnight1 = line_WKnight1 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			WKnight1.setLayoutX(xwKnight1 = col_WKnight1 * (700 / 8 + 0.5));
			WKnight1.setLayoutY(ywKnight1 = line_WKnight1 * (700 / 8 + 0.5));
		}
	}

	public void move_WKnight2(MouseEvent e) {
		WKnight2.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			WKnight2.toFront();
			RunningGUI.gameBoard.board[line_WKnight2][col_WKnight2].movePiece(RunningGUI.gameBoard, line_WKnight2,
					col_WKnight2, i, j);
			this.reactIfCapture(i, j);
			line_WKnight2 = i;
			col_WKnight2 = j;
			WKnight2.setLayoutX(xwKnight2 = col_WKnight2 * (700 / 8 + 0.5));
			WKnight2.setLayoutY(ywKnight2 = line_WKnight2 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			WKnight2.setLayoutX(xwKnight2 = col_WKnight2 * (700 / 8 + 0.5));
			WKnight2.setLayoutY(ywKnight2 = line_WKnight2 * (700 / 8 + 0.5));
		}
	}

	public void move_BKnight1(MouseEvent e) {
		BKnight1.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			BKnight1.toFront();
			RunningGUI.gameBoard.board[line_BKnight1][col_BKnight1].movePiece(RunningGUI.gameBoard, line_BKnight1,
					col_BKnight1, i, j);
			this.reactIfCapture(i, j);
			line_BKnight1 = i;
			col_BKnight1 = j;
			BKnight1.setLayoutX(xbKnight1 = col_BKnight1 * (700 / 8 + 0.5));
			BKnight1.setLayoutY(ybKnight1 = line_BKnight1 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			BKnight1.setLayoutX(xbKnight1 = col_BKnight1 * (700 / 8 + 0.5));
			BKnight1.setLayoutY(ybKnight1 = line_BKnight1 * (700 / 8 + 0.5));
		}
	}

	public void move_BKnight2(MouseEvent e) {
		BKnight2.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			BKnight2.toFront();
			RunningGUI.gameBoard.board[line_BKnight2][col_BKnight2].movePiece(RunningGUI.gameBoard, line_BKnight2,
					col_BKnight2, i, j);
			this.reactIfCapture(i, j);
			line_BKnight2 = i;
			col_BKnight2 = j;
			BKnight2.setLayoutX(xbKnight2 = col_BKnight2 * (700 / 8 + 0.5));
			BKnight2.setLayoutY(ybKnight2 = line_BKnight2 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			BKnight2.setLayoutX(xbKnight2 = col_BKnight2 * (700 / 8 + 0.5));
			BKnight2.setLayoutY(ybKnight2 = line_BKnight2 * (700 / 8 + 0.5));
		}
	}

	public void move_WBishop1(MouseEvent e) {
		WBishop1.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			WBishop1.toFront();
			RunningGUI.gameBoard.board[line_WBishop1][col_WBishop1].movePiece(RunningGUI.gameBoard, line_WBishop1,
					col_WBishop1, i, j);
			this.reactIfCapture(i, j);
			line_WBishop1 = i;
			col_WBishop1 = j;
			WBishop1.setLayoutX(xwBishop1 = col_WBishop1 * (700 / 8 + 0.5));
			WBishop1.setLayoutY(ywBishop1 = line_WBishop1 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			WBishop1.setLayoutX(xwBishop1 = col_WBishop1 * (700 / 8 + 0.5));
			WBishop1.setLayoutY(ywBishop1 = line_WBishop1 * (700 / 8 + 0.5));
		}
	}

	public void move_WBishop2(MouseEvent e) {
		WBishop2.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			WBishop2.toFront();
			RunningGUI.gameBoard.board[line_WBishop2][col_WBishop2].movePiece(RunningGUI.gameBoard, line_WBishop2,
					col_WBishop2, i, j);
			this.reactIfCapture(i, j);
			line_WBishop2 = i;
			col_WBishop2 = j;
			WBishop2.setLayoutX(xwBishop2 = col_WBishop2 * (700 / 8 + 0.5));
			WBishop2.setLayoutY(ywBishop2 = line_WBishop2 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			WBishop2.setLayoutX(xwBishop2 = col_WBishop2 * (700 / 8 + 0.5));
			WBishop2.setLayoutY(ywBishop2 = line_WBishop2 * (700 / 8 + 0.5));
		}
	}

	public void move_BBishop1(MouseEvent e) {
		BBishop1.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			BBishop1.toFront();
			RunningGUI.gameBoard.board[line_BBishop1][col_BBishop1].movePiece(RunningGUI.gameBoard, line_BBishop1,
					col_BBishop1, i, j);
			this.reactIfCapture(i, j);
			line_BBishop1 = i;
			col_BBishop1 = j;
			BBishop1.setLayoutX(xbBishop1 = col_BBishop1 * (700 / 8 + 0.5));
			BBishop1.setLayoutY(ybBishop1 = line_BBishop1 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			BBishop1.setLayoutX(xbBishop1 = col_BBishop1 * (700 / 8 + 0.5));
			BBishop1.setLayoutY(ybBishop1 = line_BBishop1 * (700 / 8 + 0.5));
		}
	}

	public void move_BBishop2(MouseEvent e) {
		BBishop2.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			BBishop2.toFront();
			RunningGUI.gameBoard.board[line_BBishop2][col_BBishop2].movePiece(RunningGUI.gameBoard, line_BBishop2,
					col_BBishop2, i, j);
			this.reactIfCapture(i, j);
			line_BBishop2 = i;
			col_BBishop2 = j;
			BBishop2.setLayoutX(xbBishop2 = col_BBishop2 * (700 / 8 + 0.5));
			BBishop2.setLayoutY(ybBishop2 = line_BBishop2 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			BBishop2.setLayoutX(xbBishop2 = col_BBishop2 * (700 / 8 + 0.5));
			BBishop2.setLayoutY(ybBishop2 = line_BBishop2 * (700 / 8 + 0.5));
		}
	}

	public void move_WQueen(MouseEvent e) {
		WQueen.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			WQueen.toFront();
			RunningGUI.gameBoard.board[line_WQueen][col_WQueen].movePiece(RunningGUI.gameBoard, line_WQueen, col_WQueen,
					i, j);
			this.reactIfCapture(i, j);
			line_WQueen = i;
			col_WQueen = j;
			WQueen.setLayoutX(xwQueen = col_WQueen * (700 / 8 + 0.5));
			WQueen.setLayoutY(ywQueen = line_WQueen * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			WQueen.setLayoutX(xwQueen = col_WQueen * (700 / 8 + 0.5));
			WQueen.setLayoutY(ywQueen = line_WQueen * (700 / 8 + 0.5));
		}
	}

	public void move_BQueen(MouseEvent e) {
		BQueen.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			BQueen.toFront();
			RunningGUI.gameBoard.board[line_BQueen][col_BQueen].movePiece(RunningGUI.gameBoard, line_BQueen, col_BQueen,
					i, j);
			this.reactIfCapture(i, j);
			line_BQueen = i;
			col_BQueen = j;
			BQueen.setLayoutX(xbQueen = col_BQueen * (700 / 8 + 0.5));
			BQueen.setLayoutY(ybQueen = line_BQueen * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			BQueen.setLayoutX(xbQueen = col_BQueen * (700 / 8 + 0.5));
			BQueen.setLayoutY(ybQueen = line_BQueen * (700 / 8 + 0.5));
		}
	}

	public void move_WKing(MouseEvent e) {
		WKing.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			WKing.toFront();
			RunningGUI.gameBoard.board[line_WKing][col_WKing].movePiece(RunningGUI.gameBoard, line_WKing, col_WKing, i,
					j);
			this.reactIfCapture(i, j);
			line_WKing = i;
			col_WKing = j;
			WKing.setLayoutX(xwKing = col_WKing * (700 / 8 + 0.5));
			WKing.setLayoutY(ywKing = line_WKing * (700 / 8 + 0.5));
			if (RunningGUI.gameBoard.movesPlayed.get(RunningGUI.gameBoard.movesPlayed.size() - 1)
					.getMoveType() == MoveType.KingSideCastle) {
				WRook2.setLayoutX(xwRook2 = 5 * (700 / 8 + 0.5));
				WRook2.setLayoutY(ywRook2 = 7 * (700 / 8 + 0.5));
				line_WRook2 = 7;
				col_WRook2 = 5;
			}
			if (RunningGUI.gameBoard.movesPlayed.get(RunningGUI.gameBoard.movesPlayed.size() - 1)
					.getMoveType() == MoveType.QueenSideCastle) {
				WRook1.setLayoutX(xwRook1 = 3 * (700 / 8 + 0.5));
				WRook1.setLayoutY(ywRook1 = 7 * (700 / 8 + 0.5));
				line_WRook1 = 7;
				col_WRook1 = 3;
			}
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			WKing.setLayoutX(xwKing = col_WKing * (700 / 8 + 0.5));
			WKing.setLayoutY(ywKing = line_WKing * (700 / 8 + 0.5));
		}
	}

	public void move_BKing(MouseEvent e) {
		BKing.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			BKing.toFront();
			RunningGUI.gameBoard.board[line_BKing][col_BKing].movePiece(RunningGUI.gameBoard, line_BKing, col_BKing, i,
					j);
			this.reactIfCapture(i, j);
			line_BKing = i;
			col_BKing = j;
			BKing.setLayoutX(xbKing = col_BKing * (700 / 8 + 0.5));
			BKing.setLayoutY(ybKing = line_BKing * (700 / 8 + 0.5));
			if (RunningGUI.gameBoard.movesPlayed.get(RunningGUI.gameBoard.movesPlayed.size() - 1)
					.getMoveType() == MoveType.KingSideCastle) {
				BRook2.setLayoutX(xbRook2 = 5 * (700 / 8 + 0.5));
				BRook2.setLayoutY(ybRook2 = 0 * (700 / 8 + 0.5));
				line_BRook2 = 0;
				col_BRook2 = 5;
			}
			if (RunningGUI.gameBoard.movesPlayed.get(RunningGUI.gameBoard.movesPlayed.size() - 1)
					.getMoveType() == MoveType.QueenSideCastle) {
				BRook1.setLayoutX(xbRook1 = 3 * (700 / 8 + 0.5));
				BRook1.setLayoutY(ybRook1 = 0 * (700 / 8 + 0.5));
				line_BRook1 = 0;
				col_BRook1 = 3;
			}
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			BKing.setLayoutX(xbKing = col_BKing * (700 / 8 + 0.5));
			BKing.setLayoutY(ybKing = line_BKing * (700 / 8 + 0.5));
		}
	}

	public void move_WPawn1(MouseEvent e) {
		WPawn1.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			WPawn1.toFront();
			RunningGUI.gameBoard.board[line_WPawn1][col_WPawn1].movePiece(RunningGUI.gameBoard, line_WPawn1, col_WPawn1,
					i, j);
			this.reactIfCaptureWPawn(i, j);
			if (i == 0) { // the pawn was promoted
				Image White_queen = new Image("White Queen.png");
				WPawn1.setImage(White_queen);
			}
			line_WPawn1 = i;
			col_WPawn1 = j;
			WPawn1.setLayoutX(xwPawn1 = col_WPawn1 * (700 / 8 + 0.5));
			WPawn1.setLayoutY(ywPawn1 = line_WPawn1 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			WPawn1.setLayoutX(xwPawn1 = col_WPawn1 * (700 / 8 + 0.5));
			WPawn1.setLayoutY(ywPawn1 = line_WPawn1 * (700 / 8 + 0.5));
		}
	}

	public void move_WPawn2(MouseEvent e) {
		WPawn2.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			WPawn2.toFront();
			RunningGUI.gameBoard.board[line_WPawn2][col_WPawn2].movePiece(RunningGUI.gameBoard, line_WPawn2, col_WPawn2,
					i, j);
			this.reactIfCaptureWPawn(i, j);
			if (i == 0) { // the pawn was promoted
				Image White_queen = new Image("White Queen.png");
				WPawn2.setImage(White_queen);
			}
			line_WPawn2 = i;
			col_WPawn2 = j;
			WPawn2.setLayoutX(xwPawn2 = col_WPawn2 * (700 / 8 + 0.5));
			WPawn2.setLayoutY(ywPawn2 = line_WPawn2 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			WPawn2.setLayoutX(xwPawn2 = col_WPawn2 * (700 / 8 + 0.5));
			WPawn2.setLayoutY(ywPawn2 = line_WPawn2 * (700 / 8 + 0.5));
		}
	}

	public void move_WPawn3(MouseEvent e) {
		WPawn3.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			WPawn3.toFront();
			RunningGUI.gameBoard.board[line_WPawn3][col_WPawn3].movePiece(RunningGUI.gameBoard, line_WPawn3, col_WPawn3,
					i, j);
			this.reactIfCaptureWPawn(i, j);
			if (i == 0) { // the pawn was promoted
				Image White_queen = new Image("White Queen.png");
				WPawn3.setImage(White_queen);
			}
			line_WPawn3 = i;
			col_WPawn3 = j;
			WPawn3.setLayoutX(xwPawn3 = col_WPawn3 * (700 / 8 + 0.5));
			WPawn3.setLayoutY(ywPawn3 = line_WPawn3 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			WPawn3.setLayoutX(xwPawn3 = col_WPawn3 * (700 / 8 + 0.5));
			WPawn3.setLayoutY(ywPawn3 = line_WPawn3 * (700 / 8 + 0.5));
		}
	}

	public void move_WPawn4(MouseEvent e) {
		WPawn4.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			WPawn4.toFront();
			RunningGUI.gameBoard.board[line_WPawn4][col_WPawn4].movePiece(RunningGUI.gameBoard, line_WPawn4, col_WPawn4,
					i, j);
			this.reactIfCaptureWPawn(i, j);
			if (i == 0) { // the pawn was promoted
				Image White_queen = new Image("White Queen.png");
				WPawn4.setImage(White_queen);
			}
			line_WPawn4 = i;
			col_WPawn4 = j;
			WPawn4.setLayoutX(xwPawn4 = col_WPawn4 * (700 / 8 + 0.5));
			WPawn4.setLayoutY(ywPawn4 = line_WPawn4 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			WPawn4.setLayoutX(xwPawn4 = col_WPawn4 * (700 / 8 + 0.5));
			WPawn4.setLayoutY(ywPawn4 = line_WPawn4 * (700 / 8 + 0.5));
		}
	}

	public void move_WPawn5(MouseEvent e) {
		WPawn5.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			WPawn5.toFront();
			RunningGUI.gameBoard.board[line_WPawn5][col_WPawn5].movePiece(RunningGUI.gameBoard, line_WPawn5, col_WPawn5,
					i, j);
			this.reactIfCaptureWPawn(i, j);
			if (i == 0) { // the pawn was promoted
				Image White_queen = new Image("White Queen.png");
				WPawn5.setImage(White_queen);
			}
			line_WPawn5 = i;
			col_WPawn5 = j;
			WPawn5.setLayoutX(xwPawn5 = col_WPawn5 * (700 / 8 + 0.5));
			WPawn5.setLayoutY(ywPawn5 = line_WPawn5 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			WPawn5.setLayoutX(xwPawn5 = col_WPawn5 * (700 / 8 + 0.5));
			WPawn5.setLayoutY(ywPawn5 = line_WPawn5 * (700 / 8 + 0.5));
		}
	}

	public void move_WPawn6(MouseEvent e) {
		WPawn6.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			WPawn6.toFront();
			RunningGUI.gameBoard.board[line_WPawn6][col_WPawn6].movePiece(RunningGUI.gameBoard, line_WPawn6, col_WPawn6,
					i, j);
			this.reactIfCaptureWPawn(i, j);
			if (i == 0) { // the pawn was promoted
				Image White_queen = new Image("White Queen.png");
				WPawn6.setImage(White_queen);
			}
			line_WPawn6 = i;
			col_WPawn6 = j;
			WPawn6.setLayoutX(xwPawn6 = col_WPawn6 * (700 / 8 + 0.5));
			WPawn6.setLayoutY(ywPawn6 = line_WPawn6 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			WPawn6.setLayoutX(xwPawn6 = col_WPawn6 * (700 / 8 + 0.5));
			WPawn6.setLayoutY(ywPawn6 = line_WPawn6 * (700 / 8 + 0.5));
		}
	}

	public void move_WPawn7(MouseEvent e) {
		WPawn7.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			WPawn7.toFront();
			RunningGUI.gameBoard.board[line_WPawn7][col_WPawn7].movePiece(RunningGUI.gameBoard, line_WPawn7, col_WPawn7,
					i, j);
			this.reactIfCaptureWPawn(i, j);
			if (i == 0) { // the pawn was promoted
				Image White_queen = new Image("White Queen.png");
				WPawn7.setImage(White_queen);
			}
			line_WPawn7 = i;
			col_WPawn7 = j;
			WPawn7.setLayoutX(xwPawn7 = col_WPawn7 * (700 / 8 + 0.5));
			WPawn7.setLayoutY(ywPawn7 = line_WPawn7 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			WPawn7.setLayoutX(xwPawn7 = col_WPawn7 * (700 / 8 + 0.5));
			WPawn7.setLayoutY(ywPawn7 = line_WPawn7 * (700 / 8 + 0.5));
		}
	}

	public void move_WPawn8(MouseEvent e) {
		WPawn8.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			WPawn8.toFront();
			RunningGUI.gameBoard.board[line_WPawn8][col_WPawn8].movePiece(RunningGUI.gameBoard, line_WPawn8, col_WPawn8,
					i, j);
			this.reactIfCaptureWPawn(i, j);
			if (i == 0) { // the pawn was promoted
				Image White_queen = new Image("White Queen.png");
				WPawn8.setImage(White_queen);
			}
			line_WPawn8 = i;
			col_WPawn8 = j;
			WPawn8.setLayoutX(xwPawn8 = col_WPawn8 * (700 / 8 + 0.5));
			WPawn8.setLayoutY(ywPawn8 = line_WPawn8 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			WPawn8.setLayoutX(xwPawn8 = col_WPawn8 * (700 / 8 + 0.5));
			WPawn8.setLayoutY(ywPawn8 = line_WPawn8 * (700 / 8 + 0.5));
		}
	}

	public void move_BPawn1(MouseEvent e) {
		BPawn1.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			BPawn1.toFront();
			RunningGUI.gameBoard.board[line_BPawn1][col_BPawn1].movePiece(RunningGUI.gameBoard, line_BPawn1, col_BPawn1,
					i, j);
			this.reactIfCaptureBPawn(i, j);
			if (i == 7) { // the pawn was promoted
				Image Black_queen = new Image("Black Queen.png");
				BPawn1.setImage(Black_queen);
			}
			line_BPawn1 = i;
			col_BPawn1 = j;
			BPawn1.setLayoutX(xbPawn1 = col_BPawn1 * (700 / 8 + 0.5));
			BPawn1.setLayoutY(ybPawn1 = line_BPawn1 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			BPawn1.setLayoutX(xbPawn1 = col_BPawn1 * (700 / 8 + 0.5));
			BPawn1.setLayoutY(ybPawn1 = line_BPawn1 * (700 / 8 + 0.5));
		}
	}

	public void move_BPawn2(MouseEvent e) {
		BPawn2.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			BPawn2.toFront();
			RunningGUI.gameBoard.board[line_BPawn2][col_BPawn2].movePiece(RunningGUI.gameBoard, line_BPawn2, col_BPawn2,
					i, j);
			this.reactIfCaptureBPawn(i, j);
			if (i == 7) { // the pawn was promoted
				Image Black_queen = new Image("Black Queen.png");
				BPawn2.setImage(Black_queen);
			}
			line_BPawn2 = i;
			col_BPawn2 = j;
			BPawn2.setLayoutX(xbPawn2 = col_BPawn2 * (700 / 8 + 0.5));
			BPawn2.setLayoutY(ybPawn2 = line_BPawn2 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			BPawn2.setLayoutX(xbPawn2 = col_BPawn2 * (700 / 8 + 0.5));
			BPawn2.setLayoutY(ybPawn2 = line_BPawn2 * (700 / 8 + 0.5));
		}
	}

	public void move_BPawn3(MouseEvent e) {
		BPawn3.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			BPawn3.toFront();
			RunningGUI.gameBoard.board[line_BPawn3][col_BPawn3].movePiece(RunningGUI.gameBoard, line_BPawn3, col_BPawn3,
					i, j);
			this.reactIfCaptureBPawn(i, j);
			if (i == 7) { // the pawn was promoted
				Image Black_queen = new Image("Black Queen.png");
				BPawn3.setImage(Black_queen);
			}
			line_BPawn3 = i;
			col_BPawn3 = j;
			BPawn3.setLayoutX(xbPawn3 = col_BPawn3 * (700 / 8 + 0.5));
			BPawn3.setLayoutY(ybPawn3 = line_BPawn3 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			BPawn3.setLayoutX(xbPawn3 = col_BPawn3 * (700 / 8 + 0.5));
			BPawn3.setLayoutY(ybPawn3 = line_BPawn3 * (700 / 8 + 0.5));
		}
	}

	public void move_BPawn4(MouseEvent e) {
		BPawn4.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			BPawn4.toFront();
			RunningGUI.gameBoard.board[line_BPawn4][col_BPawn4].movePiece(RunningGUI.gameBoard, line_BPawn4, col_BPawn4,
					i, j);
			this.reactIfCaptureBPawn(i, j);
			if (i == 7) { // the pawn was promoted
				Image Black_queen = new Image("Black Queen.png");
				BPawn4.setImage(Black_queen);
			}
			line_BPawn4 = i;
			col_BPawn4 = j;
			BPawn4.setLayoutX(xbPawn4 = col_BPawn4 * (700 / 8 + 0.5));
			BPawn4.setLayoutY(ybPawn4 = line_BPawn4 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			BPawn4.setLayoutX(xbPawn4 = col_BPawn4 * (700 / 8 + 0.5));
			BPawn4.setLayoutY(ybPawn4 = line_BPawn4 * (700 / 8 + 0.5));
		}
	}

	public void move_BPawn5(MouseEvent e) {
		BPawn5.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			BPawn5.toFront();
			RunningGUI.gameBoard.board[line_BPawn5][col_BPawn5].movePiece(RunningGUI.gameBoard, line_BPawn5, col_BPawn5,
					i, j);
			this.reactIfCaptureBPawn(i, j);
			if (i == 7) { // the pawn was promoted
				Image Black_queen = new Image("Black Queen.png");
				BPawn5.setImage(Black_queen);
			}
			line_BPawn5 = i;
			col_BPawn5 = j;
			BPawn5.setLayoutX(xbPawn5 = col_BPawn5 * (700 / 8 + 0.5));
			BPawn5.setLayoutY(ybPawn5 = line_BPawn5 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			BPawn5.setLayoutX(xbPawn5 = col_BPawn5 * (700 / 8 + 0.5));
			BPawn5.setLayoutY(ybPawn5 = line_BPawn5 * (700 / 8 + 0.5));
		}
	}

	public void move_BPawn6(MouseEvent e) {
		BPawn6.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			BPawn6.toFront();
			RunningGUI.gameBoard.board[line_BPawn6][col_BPawn6].movePiece(RunningGUI.gameBoard, line_BPawn6, col_BPawn6,
					i, j);
			this.reactIfCaptureBPawn(i, j);
			if (i == 7) { // the pawn was promoted
				Image Black_queen = new Image("Black Queen.png");
				BPawn6.setImage(Black_queen);
			}
			line_BPawn6 = i;
			col_BPawn6 = j;
			BPawn6.setLayoutX(xbPawn6 = col_BPawn6 * (700 / 8 + 0.5));
			BPawn6.setLayoutY(ybPawn6 = line_BPawn6 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			BPawn6.setLayoutX(xbPawn6 = col_BPawn6 * (700 / 8 + 0.5));
			BPawn6.setLayoutY(ybPawn6 = line_BPawn6 * (700 / 8 + 0.5));
		}
	}

	public void move_BPawn7(MouseEvent e) {
		BPawn7.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			BPawn7.toFront();
			RunningGUI.gameBoard.board[line_BPawn7][col_BPawn7].movePiece(RunningGUI.gameBoard, line_BPawn7, col_BPawn7,
					i, j);
			this.reactIfCaptureBPawn(i, j);
			if (i == 7) { // the pawn was promoted
				Image Black_queen = new Image("Black Queen.png");
				BPawn8.setImage(Black_queen);
			}
			line_BPawn7 = i;
			col_BPawn7 = j;
			BPawn7.setLayoutX(xbPawn7 = col_BPawn7 * (700 / 8 + 0.5));
			BPawn7.setLayoutY(ybPawn7 = line_BPawn7 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			BPawn7.setLayoutX(xbPawn7 = col_BPawn7 * (700 / 8 + 0.5));
			BPawn7.setLayoutY(ybPawn7 = line_BPawn7 * (700 / 8 + 0.5));
		}
	}

	public void move_BPawn8(MouseEvent e) {
		BPawn8.setCursor(Cursor.OPEN_HAND);
		double x_Mouse = e.getSceneX();
		double y_Mouse = e.getSceneY();
		int j = (int) Math.floor(8 * x_Mouse / 700);
		int i = (int) Math.floor(8 * y_Mouse / 700);
		try {
			BPawn8.toFront();
			RunningGUI.gameBoard.board[line_BPawn8][col_BPawn8].movePiece(RunningGUI.gameBoard, line_BPawn8, col_BPawn8,
					i, j);
			this.reactIfCaptureBPawn(i, j);
			if (i == 7) { // the pawn was promoted
				Image Black_queen = new Image("Black Queen.png");
				BPawn8.setImage(Black_queen);
			}
			line_BPawn8 = i;
			col_BPawn8 = j;
			BPawn8.setLayoutX(xbPawn8 = col_BPawn8 * (700 / 8 + 0.5));
			BPawn8.setLayoutY(ybPawn8 = line_BPawn8 * (700 / 8 + 0.5));
			//RunningGUI.gameBoard.display();
		} catch (Exception exp) {
			BPawn8.setLayoutX(xbPawn8 = col_BPawn8 * (700 / 8 + 0.5));
			BPawn8.setLayoutY(ybPawn8 = line_BPawn8 * (700 / 8 + 0.5));
		}
	}

	public void movePieceFromLastMove() {
		Move lastMove = RunningGUI.gameBoard.movesPlayed.get(RunningGUI.gameBoard.movesPlayed.size() - 1);
		int start_line = lastMove.getStartSquare() / 10;
		int start_col = lastMove.getStartSquare() - 10 * start_line;
		int landing_line = lastMove.getLandingSquare() / 10;
		int landing_col = lastMove.getLandingSquare() - 10 * landing_line;

		ImageView moving_piece = getPieceOnCoordinate(start_line, start_col);

		moving_piece.toFront();
		if (lastMove.getMovedPiece() == PieceType.Pawn) {
			if (lastMove.getColorOfPiece()) {
				this.reactIfCaptureWPawn(landing_line, landing_col);
			} else {
				this.reactIfCaptureBPawn(landing_line, landing_col);
			}
		} else {
			this.reactIfCapture(landing_line, landing_col);
		}

		if (lastMove.getMoveType() == MoveType.Promotion) { // the pawn was promoted
			if (lastMove.getColorOfPiece()) {
				Image White_queen = new Image("White Queen.png");
				moving_piece.setImage(White_queen);
			} else {
				Image Black_queen = new Image("Black Queen.png");
				moving_piece.setImage(Black_queen);
			}
		}

		if (lastMove.getMoveType() == MoveType.KingSideCastle) {
			if (lastMove.getColorOfPiece()) {
				WRook2.setLayoutX(xwRook2 = 5 * (700 / 8 + 0.5));
				WRook2.setLayoutY(ywRook2 = 7 * (700 / 8 + 0.5));
				line_WRook2 = 7;
				col_WRook2 = 5;
			} else {
				BRook2.setLayoutX(xbRook2 = 5 * (700 / 8 + 0.5));
				BRook2.setLayoutY(ybRook2 = 0 * (700 / 8 + 0.5));
				line_BRook2 = 0;
				col_BRook2 = 5;
			}
		}
		if (lastMove.getMoveType() == MoveType.QueenSideCastle) {
			if (lastMove.getColorOfPiece()) {
				WRook1.setLayoutX(xwRook1 = 3 * (700 / 8 + 0.5));
				WRook1.setLayoutY(ywRook1 = 7 * (700 / 8 + 0.5));
				line_WRook1 = 7;
				col_WRook1 = 3;
			} else {
				BRook1.setLayoutX(xbRook1 = 3 * (700 / 8 + 0.5));
				BRook1.setLayoutY(ybRook1 = 0 * (700 / 8 + 0.5));
				line_BRook1 = 0;
				col_BRook1 = 3;
			}
		}

		moving_piece.setLayoutX(landing_col * (700 / 8 + 0.5));
		moving_piece.setLayoutY(landing_line * (700 / 8 + 0.5));
		this.setXSquareOfPiece(landing_col, landing_line, landing_col);
		this.setYSquareOfPiece(landing_col, landing_line, landing_line);
		// //RunningGUI.gameBoard.display();
	}

	public ImageView getPieceOnCoordinate(double col, double line) {
		double j = col * (700 / 8 + 0.5);
		double i = line * (700 / 8 + 0.5);
		if (WRook1.getLayoutX() == i && WRook1.getLayoutY() == j) {
			return WRook1;
		}
		if (WRook2.getLayoutX() == i && WRook2.getLayoutY() == j) {
			return WRook2;
		}
		if (BRook1.getLayoutX() == i && BRook1.getLayoutY() == j) {
			return BRook1;
		}
		if (BRook2.getLayoutX() == i && BRook2.getLayoutY() == j) {
			return BRook2;
		}
		if (WKnight1.getLayoutX() == i && WKnight1.getLayoutY() == j) {
			return WKnight1;
		}
		if (WKnight2.getLayoutX() == i && WKnight2.getLayoutY() == j) {
			return WKnight2;
		}
		if (BKnight1.getLayoutX() == i && BKnight1.getLayoutY() == j) {
			return BKnight1;
		}
		if (BKnight2.getLayoutX() == i && BKnight2.getLayoutY() == j) {
			return BKnight2;
		}
		if (WBishop1.getLayoutX() == i && WBishop1.getLayoutY() == j) {
			return WBishop1;
		}
		if (WBishop2.getLayoutX() == i && WBishop2.getLayoutY() == j) {
			return WBishop2;
		}
		if (BBishop1.getLayoutX() == i && BBishop1.getLayoutY() == j) {
			return BBishop1;
		}
		if (BBishop2.getLayoutX() == i && BBishop2.getLayoutY() == j) {
			return BBishop2;
		}
		if (WQueen.getLayoutX() == i && WQueen.getLayoutY() == j) {
			return WQueen;
		}
		if (BQueen.getLayoutX() == i && BQueen.getLayoutY() == j) {
			return BQueen;
		}
		if (WKing.getLayoutX() == i && WKing.getLayoutY() == j) {
			return WKing;
		}
		if (BKing.getLayoutX() == i && BKing.getLayoutY() == j) {
			return BKing;
		}
		if (BRook1.getLayoutX() == i && BRook1.getLayoutY() == j) {
			return BRook1;
		}
		if (BRook2.getLayoutX() == i && BRook2.getLayoutY() == j) {
			return BRook2;
		}
		if (BRook1.getLayoutX() == i && BRook1.getLayoutY() == j) {
			return BRook1;
		}
		if (BRook2.getLayoutX() == i && BRook2.getLayoutY() == j) {
			return BRook2;
		}
		if (BKnight1.getLayoutX() == i && BKnight1.getLayoutY() == j) {
			return BKnight1;
		}
		if (BKnight2.getLayoutX() == i && BKnight2.getLayoutY() == j) {
			return BKnight2;
		}
		if (BKnight1.getLayoutX() == i && BKnight1.getLayoutY() == j) {
			return BKnight1;
		}
		if (BKnight2.getLayoutX() == i && BKnight2.getLayoutY() == j) {
			return BKnight2;
		}
		if (BBishop1.getLayoutX() == i && BBishop1.getLayoutY() == j) {
			return BBishop1;
		}
		if (BBishop2.getLayoutX() == i && BBishop2.getLayoutY() == j) {
			return BBishop2;
		}
		if (BBishop1.getLayoutX() == i && BBishop1.getLayoutY() == j) {
			return BBishop1;
		}
		if (BBishop2.getLayoutX() == i && BBishop2.getLayoutY() == j) {
			return BBishop2;
		}
		if (BQueen.getLayoutX() == i && BQueen.getLayoutY() == j) {
			return BQueen;
		}
		if (BQueen.getLayoutX() == i && BQueen.getLayoutY() == j) {
			return BQueen;
		}
		if (BKing.getLayoutX() == i && BKing.getLayoutY() == j) {
			return BKing;
		}
		if (BKing.getLayoutX() == i && BKing.getLayoutY() == j) {
			return BKing;
		}
		if (WPawn1.getLayoutX() == i && WPawn1.getLayoutY() == j) {
			return WPawn1;
		}
		if (WPawn2.getLayoutX() == i && WPawn2.getLayoutY() == j) {
			return WPawn2;
		}
		if (WPawn3.getLayoutX() == i && WPawn3.getLayoutY() == j) {
			return WPawn3;
		}
		if (WPawn4.getLayoutX() == i && WPawn4.getLayoutY() == j) {
			return WPawn4;
		}
		if (WPawn5.getLayoutX() == i && WPawn5.getLayoutY() == j) {
			return WPawn5;
		}
		if (WPawn6.getLayoutX() == i && WPawn6.getLayoutY() == j) {
			return WPawn6;
		}
		if (WPawn7.getLayoutX() == i && WPawn7.getLayoutY() == j) {
			return WPawn7;
		}
		if (WPawn8.getLayoutX() == i && WPawn8.getLayoutY() == j) {
			return WPawn8;
		}
		if (BPawn1.getLayoutX() == i && BPawn1.getLayoutY() == j) {
			return BPawn1;
		}
		if (BPawn2.getLayoutX() == i && BPawn2.getLayoutY() == j) {
			return BPawn2;
		}
		if (BPawn3.getLayoutX() == i && BPawn3.getLayoutY() == j) {
			return BPawn3;
		}
		if (BPawn4.getLayoutX() == i && BPawn4.getLayoutY() == j) {
			return BPawn4;
		}
		if (BPawn5.getLayoutX() == i && BPawn5.getLayoutY() == j) {
			return BPawn5;
		}
		if (BPawn6.getLayoutX() == i && BPawn6.getLayoutY() == j) {
			return BPawn6;
		}
		if (BPawn7.getLayoutX() == i && BPawn7.getLayoutY() == j) {
			return BPawn7;
		}
		if (BPawn8.getLayoutX() == i && BPawn8.getLayoutY() == j) {
			return BPawn8;
		}
		return null;
	}

	public void setXSquareOfPiece(double col, double line, int x) {
		double j = col * (700 / 8 + 0.5);
		double i = line * (700 / 8 + 0.5);
		if (WRook1.getLayoutX() == i && WRook1.getLayoutY() == j) {
			xwRook1 = x;
		}
		if (WRook2.getLayoutX() == i && WRook2.getLayoutY() == j) {
			xwRook2 = x;
		}
		if (BRook1.getLayoutX() == i && BRook1.getLayoutY() == j) {
			xbRook1 = x;
		}
		if (BRook2.getLayoutX() == i && BRook2.getLayoutY() == j) {
			xbRook2 = x;
		}
		if (WKnight1.getLayoutX() == i && WKnight1.getLayoutY() == j) {
			xwKnight1 = x;
		}
		if (WKnight2.getLayoutX() == i && WKnight2.getLayoutY() == j) {
			xwKnight2 = x;
		}
		if (BKnight1.getLayoutX() == i && BKnight1.getLayoutY() == j) {
			xbKnight1 = x;
		}
		if (BKnight2.getLayoutX() == i && BKnight2.getLayoutY() == j) {
			xbKnight2 = x;
		}
		if (WBishop1.getLayoutX() == i && WBishop1.getLayoutY() == j) {
			xwBishop1 = x;
		}
		if (WBishop2.getLayoutX() == i && WBishop2.getLayoutY() == j) {
			xwBishop2 = x;
		}
		if (BBishop1.getLayoutX() == i && BBishop1.getLayoutY() == j) {
			xbBishop1 = x;
		}
		if (BBishop2.getLayoutX() == i && BBishop2.getLayoutY() == j) {
			xbBishop2 = x;
		}
		if (WQueen.getLayoutX() == i && WQueen.getLayoutY() == j) {
			xwQueen = x;
		}
		if (BQueen.getLayoutX() == i && BQueen.getLayoutY() == j) {
			xbQueen = x;
		}
		if (WKing.getLayoutX() == i && WKing.getLayoutY() == j) {
			xwKing = x;
		}
		if (BKing.getLayoutX() == i && BKing.getLayoutY() == j) {
			xbKing = x;
		}
		if (BRook1.getLayoutX() == i && BRook1.getLayoutY() == j) {
			xbRook1 = x;
		}
		if (BRook2.getLayoutX() == i && BRook2.getLayoutY() == j) {
			xbRook2 = x;
		}
		if (BRook1.getLayoutX() == i && BRook1.getLayoutY() == j) {
			xbRook1 = x;
		}
		if (BRook2.getLayoutX() == i && BRook2.getLayoutY() == j) {
			xbRook2 = x;
		}
		if (BKnight1.getLayoutX() == i && BKnight1.getLayoutY() == j) {
			xbKnight1 = x;
		}
		if (BKnight2.getLayoutX() == i && BKnight2.getLayoutY() == j) {
			xbKnight2 = x;
		}
		if (BKnight1.getLayoutX() == i && BKnight1.getLayoutY() == j) {
			xbKnight1 = x;
		}
		if (BKnight2.getLayoutX() == i && BKnight2.getLayoutY() == j) {
			xbKnight2 = x;
		}
		if (BBishop1.getLayoutX() == i && BBishop1.getLayoutY() == j) {
			xbBishop1 = x;
		}
		if (BBishop2.getLayoutX() == i && BBishop2.getLayoutY() == j) {
			xbBishop2 = x;
		}
		if (BBishop1.getLayoutX() == i && BBishop1.getLayoutY() == j) {
			xbBishop1 = x;
		}
		if (BBishop2.getLayoutX() == i && BBishop2.getLayoutY() == j) {
			xbBishop2 = x;
		}
		if (BQueen.getLayoutX() == i && BQueen.getLayoutY() == j) {
			xbQueen = x;
		}
		if (BQueen.getLayoutX() == i && BQueen.getLayoutY() == j) {
			xbQueen = x;
		}
		if (BKing.getLayoutX() == i && BKing.getLayoutY() == j) {
			xbKing = x;
		}
		if (BKing.getLayoutX() == i && BKing.getLayoutY() == j) {
			xbKing = x;
		}
		if (WPawn1.getLayoutX() == i && WPawn1.getLayoutY() == j) {
			xwPawn1 = x;
		}
		if (WPawn2.getLayoutX() == i && WPawn2.getLayoutY() == j) {
			xwPawn2 = x;
		}
		if (WPawn3.getLayoutX() == i && WPawn3.getLayoutY() == j) {
			xwPawn3 = x;
		}
		if (WPawn4.getLayoutX() == i && WPawn4.getLayoutY() == j) {
			xwPawn4 = x;
		}
		if (WPawn5.getLayoutX() == i && WPawn5.getLayoutY() == j) {
			xwPawn5 = x;
		}
		if (WPawn6.getLayoutX() == i && WPawn6.getLayoutY() == j) {
			xwPawn6 = x;
		}
		if (WPawn7.getLayoutX() == i && WPawn7.getLayoutY() == j) {
			xwPawn7 = x;
		}
		if (WPawn8.getLayoutX() == i && WPawn8.getLayoutY() == j) {
			xwPawn8 = x;
		}
		if (BPawn1.getLayoutX() == i && BPawn1.getLayoutY() == j) {
			xbPawn1 = x;
		}
		if (BPawn2.getLayoutX() == i && BPawn2.getLayoutY() == j) {
			xbPawn2 = x;
		}
		if (BPawn3.getLayoutX() == i && BPawn3.getLayoutY() == j) {
			xbPawn3 = x;
		}
		if (BPawn4.getLayoutX() == i && BPawn4.getLayoutY() == j) {
			xbPawn4 = x;
		}
		if (BPawn5.getLayoutX() == i && BPawn5.getLayoutY() == j) {
			xbPawn5 = x;
		}
		if (BPawn6.getLayoutX() == i && BPawn6.getLayoutY() == j) {
			xbPawn6 = x;
		}
		if (BPawn7.getLayoutX() == i && BPawn7.getLayoutY() == j) {
			xbPawn7 = x;
		}
		if (BPawn8.getLayoutX() == i && BPawn8.getLayoutY() == j) {
			xbPawn8 = x;
		}
	}

	public void setYSquareOfPiece(double col, double line, int y) {
		double j = col * (700 / 8 + 0.5);
		double i = line * (700 / 8 + 0.5);
		if (WRook1.getLayoutX() == i && WRook1.getLayoutY() == j) {
			ywRook1 = y;
		}
		if (WRook2.getLayoutX() == i && WRook2.getLayoutY() == j) {
			ywRook2 = y;
		}
		if (BRook1.getLayoutX() == i && BRook1.getLayoutY() == j) {
			ybRook1 = y;
		}
		if (BRook2.getLayoutX() == i && BRook2.getLayoutY() == j) {
			ybRook2 = y;
		}
		if (WKnight1.getLayoutX() == i && WKnight1.getLayoutY() == j) {
			ywKnight1 = y;
		}
		if (WKnight2.getLayoutX() == i && WKnight2.getLayoutY() == j) {
			ywKnight2 = y;
		}
		if (BKnight1.getLayoutX() == i && BKnight1.getLayoutY() == j) {
			ybKnight1 = y;
		}
		if (BKnight2.getLayoutX() == i && BKnight2.getLayoutY() == j) {
			ybKnight2 = y;
		}
		if (WBishop1.getLayoutX() == i && WBishop1.getLayoutY() == j) {
			ywBishop1 = y;
		}
		if (WBishop2.getLayoutX() == i && WBishop2.getLayoutY() == j) {
			ywBishop2 = y;
		}
		if (BBishop1.getLayoutX() == i && BBishop1.getLayoutY() == j) {
			ybBishop1 = y;
		}
		if (BBishop2.getLayoutX() == i && BBishop2.getLayoutY() == j) {
			ybBishop2 = y;
		}
		if (WQueen.getLayoutX() == i && WQueen.getLayoutY() == j) {
			ywQueen = y;
		}
		if (BQueen.getLayoutX() == i && BQueen.getLayoutY() == j) {
			ybQueen = y;
		}
		if (WKing.getLayoutX() == i && WKing.getLayoutY() == j) {
			ywKing = y;
		}
		if (BKing.getLayoutX() == i && BKing.getLayoutY() == j) {
			ybKing = y;
		}
		if (BRook1.getLayoutX() == i && BRook1.getLayoutY() == j) {
			ybRook1 = y;
		}
		if (BRook2.getLayoutX() == i && BRook2.getLayoutY() == j) {
			ybRook2 = y;
		}
		if (BRook1.getLayoutX() == i && BRook1.getLayoutY() == j) {
			ybRook1 = y;
		}
		if (BRook2.getLayoutX() == i && BRook2.getLayoutY() == j) {
			ybRook2 = y;
		}
		if (BKnight1.getLayoutX() == i && BKnight1.getLayoutY() == j) {
			ybKnight1 = y;
		}
		if (BKnight2.getLayoutX() == i && BKnight2.getLayoutY() == j) {
			ybKnight2 = y;
		}
		if (BKnight1.getLayoutX() == i && BKnight1.getLayoutY() == j) {
			ybKnight1 = y;
		}
		if (BKnight2.getLayoutX() == i && BKnight2.getLayoutY() == j) {
			ybKnight2 = y;
		}
		if (BBishop1.getLayoutX() == i && BBishop1.getLayoutY() == j) {
			ybBishop1 = y;
		}
		if (BBishop2.getLayoutX() == i && BBishop2.getLayoutY() == j) {
			ybBishop2 = y;
		}
		if (BBishop1.getLayoutX() == i && BBishop1.getLayoutY() == j) {
			ybBishop1 = y;
		}
		if (BBishop2.getLayoutX() == i && BBishop2.getLayoutY() == j) {
			ybBishop2 = y;
		}
		if (BQueen.getLayoutX() == i && BQueen.getLayoutY() == j) {
			ybQueen = y;
		}
		if (BQueen.getLayoutX() == i && BQueen.getLayoutY() == j) {
			ybQueen = y;
		}
		if (BKing.getLayoutX() == i && BKing.getLayoutY() == j) {
			ybKing = y;
		}
		if (BKing.getLayoutX() == i && BKing.getLayoutY() == j) {
			ybKing = y;
		}
		if (WPawn1.getLayoutX() == i && WPawn1.getLayoutY() == j) {
			ywPawn1 = y;
		}
		if (WPawn2.getLayoutX() == i && WPawn2.getLayoutY() == j) {
			ywPawn2 = y;
		}
		if (WPawn3.getLayoutX() == i && WPawn3.getLayoutY() == j) {
			ywPawn3 = y;
		}
		if (WPawn4.getLayoutX() == i && WPawn4.getLayoutY() == j) {
			ywPawn4 = y;
		}
		if (WPawn5.getLayoutX() == i && WPawn5.getLayoutY() == j) {
			ywPawn5 = y;
		}
		if (WPawn6.getLayoutX() == i && WPawn6.getLayoutY() == j) {
			ywPawn6 = y;
		}
		if (WPawn7.getLayoutX() == i && WPawn7.getLayoutY() == j) {
			ywPawn7 = y;
		}
		if (WPawn8.getLayoutX() == i && WPawn8.getLayoutY() == j) {
			ywPawn8 = y;
		}
		if (BPawn1.getLayoutX() == i && BPawn1.getLayoutY() == j) {
			ybPawn1 = y;
		}
		if (BPawn2.getLayoutX() == i && BPawn2.getLayoutY() == j) {
			ybPawn2 = y;
		}
		if (BPawn3.getLayoutX() == i && BPawn3.getLayoutY() == j) {
			ybPawn3 = y;
		}
		if (BPawn4.getLayoutX() == i && BPawn4.getLayoutY() == j) {
			ybPawn4 = y;
		}
		if (BPawn5.getLayoutX() == i && BPawn5.getLayoutY() == j) {
			ybPawn5 = y;
		}
		if (BPawn6.getLayoutX() == i && BPawn6.getLayoutY() == j) {
			ybPawn6 = y;
		}
		if (BPawn7.getLayoutX() == i && BPawn7.getLayoutY() == j) {
			ybPawn7 = y;
		}
		if (BPawn8.getLayoutX() == i && BPawn8.getLayoutY() == j) {
			ybPawn8 = y;
		}
	}

	public void reactIfCapture(double i, double j) {
		this.setColorToPlay();
		this.setEvaluation();
		for (Circle circle : listCircle) {
			circle.setOpacity(0);
			circle.toBack();
		}
		if (RunningGUI.gameBoard.movesPlayed.get(RunningGUI.gameBoard.movesPlayed.size() - 1)
				.getCapturedPiece() != null) {
			ImageView capturedPiece = this.getPieceOnCoordinate(i, j);
			if (capturedPiece != null) {
				capturedPiece.setOpacity(0);
				capturedPiece.setLayoutX(-88);
				capturedPiece.setLayoutY(-88);
			}
		}
	}

	public void reactIfCaptureWPawn(double i, double j) {		
		this.setColorToPlay();
		this.setEvaluation();
		for (Circle circle : listCircle) {
			circle.setOpacity(0);
			circle.toBack();
		}
		if (RunningGUI.gameBoard.movesPlayed.get(RunningGUI.gameBoard.movesPlayed.size() - 1)
				.getMoveType() == MoveType.EnPassant) {
			ImageView capturedPiece = this.getPieceOnCoordinate(i + 1, j);
			if (capturedPiece != null) {
				capturedPiece.setOpacity(0);
				capturedPiece.setLayoutX(-88);
				capturedPiece.setLayoutY(-88);
			}
		} else if (RunningGUI.gameBoard.movesPlayed.get(RunningGUI.gameBoard.movesPlayed.size() - 1)
				.getCapturedPiece() != null) {
			ImageView capturedPiece = this.getPieceOnCoordinate(i, j);
			if (capturedPiece != null) {
				capturedPiece.setOpacity(0);
				capturedPiece.setLayoutX(-88);
				capturedPiece.setLayoutY(-88);
			}
		}
	}

	public void reactIfCaptureBPawn(double i, double j) {
		this.setColorToPlay();
		this.setEvaluation();
		for (Circle circle : listCircle) {
			circle.setOpacity(0);
			circle.toBack();
		}
		if (RunningGUI.gameBoard.movesPlayed.get(RunningGUI.gameBoard.movesPlayed.size() - 1)
				.getMoveType() == MoveType.EnPassant) {
			ImageView capturedPiece = this.getPieceOnCoordinate(i - 1, j);
			if (capturedPiece != null) {
				capturedPiece.setOpacity(0);
				capturedPiece.setLayoutX(-88);
				capturedPiece.setLayoutY(-88);
			}
		} else if (RunningGUI.gameBoard.movesPlayed.get(RunningGUI.gameBoard.movesPlayed.size() - 1)
				.getCapturedPiece() != null) {
			ImageView capturedPiece = this.getPieceOnCoordinate(i, j);
			if (capturedPiece != null) {
				capturedPiece.setOpacity(0);
				capturedPiece.setLayoutX(-88);
				capturedPiece.setLayoutY(-88);
			}
		}
	}

	@FXML
	private Circle Circle00;
	@FXML
	private Circle Circle01;
	@FXML
	private Circle Circle02;
	@FXML
	private Circle Circle03;
	@FXML
	private Circle Circle04;
	@FXML
	private Circle Circle05;
	@FXML
	private Circle Circle06;
	@FXML
	private Circle Circle07;
	@FXML
	private Circle Circle10;
	@FXML
	private Circle Circle11;
	@FXML
	private Circle Circle12;
	@FXML
	private Circle Circle13;
	@FXML
	private Circle Circle14;
	@FXML
	private Circle Circle15;
	@FXML
	private Circle Circle16;
	@FXML
	private Circle Circle17;
	@FXML
	private Circle Circle20;
	@FXML
	private Circle Circle21;
	@FXML
	private Circle Circle22;
	@FXML
	private Circle Circle23;
	@FXML
	private Circle Circle24;
	@FXML
	private Circle Circle25;
	@FXML
	private Circle Circle26;
	@FXML
	private Circle Circle27;
	@FXML
	private Circle Circle30;
	@FXML
	private Circle Circle31;
	@FXML
	private Circle Circle32;
	@FXML
	private Circle Circle33;
	@FXML
	private Circle Circle34;
	@FXML
	private Circle Circle35;
	@FXML
	private Circle Circle36;
	@FXML
	private Circle Circle37;
	@FXML
	private Circle Circle40;
	@FXML
	private Circle Circle41;
	@FXML
	private Circle Circle42;
	@FXML
	private Circle Circle43;
	@FXML
	private Circle Circle44;
	@FXML
	private Circle Circle45;
	@FXML
	private Circle Circle46;
	@FXML
	private Circle Circle47;
	@FXML
	private Circle Circle50;
	@FXML
	private Circle Circle51;
	@FXML
	private Circle Circle52;
	@FXML
	private Circle Circle53;
	@FXML
	private Circle Circle54;
	@FXML
	private Circle Circle55;
	@FXML
	private Circle Circle56;
	@FXML
	private Circle Circle57;
	@FXML
	private Circle Circle60;
	@FXML
	private Circle Circle61;
	@FXML
	private Circle Circle62;
	@FXML
	private Circle Circle63;
	@FXML
	private Circle Circle64;
	@FXML
	private Circle Circle65;
	@FXML
	private Circle Circle66;
	@FXML
	private Circle Circle67;
	@FXML
	private Circle Circle70;
	@FXML
	private Circle Circle71;
	@FXML
	private Circle Circle72;
	@FXML
	private Circle Circle73;
	@FXML
	private Circle Circle74;
	@FXML
	private Circle Circle75;
	@FXML
	private Circle Circle76;
	@FXML
	private Circle Circle77;

	private List<Circle> listCircle = new ArrayList<Circle>();

	public void setList() {
		listCircle.add(Circle00);
		listCircle.add(Circle01);
		listCircle.add(Circle02);
		listCircle.add(Circle03);
		listCircle.add(Circle04);
		listCircle.add(Circle05);
		listCircle.add(Circle06);
		listCircle.add(Circle07);
		listCircle.add(Circle10);
		listCircle.add(Circle11);
		listCircle.add(Circle12);
		listCircle.add(Circle13);
		listCircle.add(Circle14);
		listCircle.add(Circle15);
		listCircle.add(Circle16);
		listCircle.add(Circle17);
		listCircle.add(Circle20);
		listCircle.add(Circle21);
		listCircle.add(Circle22);
		listCircle.add(Circle23);
		listCircle.add(Circle24);
		listCircle.add(Circle25);
		listCircle.add(Circle26);
		listCircle.add(Circle27);
		listCircle.add(Circle30);
		listCircle.add(Circle31);
		listCircle.add(Circle32);
		listCircle.add(Circle33);
		listCircle.add(Circle34);
		listCircle.add(Circle35);
		listCircle.add(Circle36);
		listCircle.add(Circle37);
		listCircle.add(Circle40);
		listCircle.add(Circle41);
		listCircle.add(Circle42);
		listCircle.add(Circle43);
		listCircle.add(Circle44);
		listCircle.add(Circle45);
		listCircle.add(Circle46);
		listCircle.add(Circle47);
		listCircle.add(Circle50);
		listCircle.add(Circle51);
		listCircle.add(Circle52);
		listCircle.add(Circle53);
		listCircle.add(Circle54);
		listCircle.add(Circle55);
		listCircle.add(Circle56);
		listCircle.add(Circle57);
		listCircle.add(Circle60);
		listCircle.add(Circle61);
		listCircle.add(Circle62);
		listCircle.add(Circle63);
		listCircle.add(Circle64);
		listCircle.add(Circle65);
		listCircle.add(Circle66);
		listCircle.add(Circle67);
		listCircle.add(Circle70);
		listCircle.add(Circle71);
		listCircle.add(Circle72);
		listCircle.add(Circle73);
		listCircle.add(Circle74);
		listCircle.add(Circle75);
		listCircle.add(Circle76);
		listCircle.add(Circle77);
	}
}
