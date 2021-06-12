/**
 * Sudoku game board.  
 * 
 * @author mattkreul
 */

/**
 * TODO:	1. Fix printing of board
 * 			2. Make check method for inputing numbers
 * 				> figure out way to make it so checking this is in the background rather than it 
 * 				  not letting the client input wrong numbers
 * 					+ this might mean changing the way the cells work so that each number can have
 * 					  a way of letting the program of knowing the number is correct but not the 
 * 					  client.
 * 					+ OR, just create the solver and have it check the current game board to the 
 * 					  correct answer
 * 			3. 
 */
package sudoku;

import java.util.Arrays;

public class SudokuGame {
	
	private SudokuCell[][] board;
	
	private int size;
	
	private boolean gameWon = false; 
	
	public SudokuGame() {
		size = 3;
		buildGameBoard(3);
	}
	
	public SudokuGame(int size) {
		this.size = size;
		buildGameBoard(size);
	}
	
	/**
	 * Sets a number only if there is nothing there at all
	 * @param num
	 * @param boardRow
	 * @param boardCol
	 * @param cellRow
	 * @param cellCol
	 */
	public void setNum(Integer num, int boardRow, int boardCol, int cellRow, int cellCol) {
		board[boardRow][boardCol].setNum(num, cellRow, cellCol);
	}
	
	/**
	 * Replaces a number if there was a number previously there
	 * @param num
	 * @param boardRow
	 * @param boardCol
	 * @param cellRow
	 * @param cellCol
	 */
	public void replaceNum(Integer num, int boardRow, int boardCol, int cellRow, int cellCol) {
		board[boardRow][boardCol].replaceNum(num, cellRow, cellCol);
	}
	
	
	/**
	 * Returns the cell at that position.
	 * @param row
	 * @param col
	 * @return
	 * 	cell
	 */
	public SudokuCell getCell(int row, int col) {
		return board[row][col];
	}
	
	/**
	 * Prints the entire board to view.
	 */
	public void printBoard() { //TODO FIX!!!
		//This is just temporary so I can see how the game looks
		for(int row = 0; row < size; row++) {
			for(int col = 0; col < size; col++) {
				SudokuCell toPrint = getCell(row, col);
				toPrint.printCell();
				System.out.println();
			}
		}
		
//TODO fix this so that it prints like an actual board
		
//		for(int boardRow = 0; boardRow < size; boardRow++) {
//			for(int boardCol = 0; boardCol < size*size; boardCol++) {
//				for(int j = 0; j < size; j++) {
//					SudokuCell temp = getCell(boardRow, j);
//					System.out.print(Arrays.toString(temp.getCellRow(boardCol%size))+ " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		
	}
	
	public int getSize() {
		return size;
	}
	
	private void gameStatus() {
		//TODO use this to switch the game status to over so the game is done.
		
		//Print out congrats statement
		
		//Print out final game board?
	}
	/**
	 * Helper method for building the game board.
	 * @param size
	 */
	private void buildGameBoard(int size) {
		board = new SudokuCell[size][size];
		for(int row = 0; row < size; row++) {
			for(int col = 0; col < size; col++) {
				board[row][col] = new SudokuCell(size);
			}
		}
	}
	
	
}
