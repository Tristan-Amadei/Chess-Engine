package game;

public class Main {

	public static void main(String[] args) throws IllegalMoveException {
		
		Board board = new Board();
		board.newGameBoard();
		
		board.playInConsole();
	}
}
