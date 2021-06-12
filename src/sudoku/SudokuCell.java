/**
 * This is a cell for a sudoku game. It can be expanded to any size you want it to be.
 * 
 * @author mattkreul
 */

package sudoku;

import java.util.Arrays;

public class SudokuCell 
{
	private Integer[][] cell;
	
	private int size;
	
	/**
	 * Constructor for standard game (3x3)
	 */
	public SudokuCell() {
		size = 3;
		cell = new Integer[3][3];
	}
	
	/**
	 * Constructor for a different sized game (size input is the root size)
	 * @param size
	 * 	root size of board
	 */
	public SudokuCell(int size) {
		this.size = size;
		cell = new Integer[size][size];
	}
	
	/**
	 * Adds number to cell only if it is an empty cell
	 * @param num
	 * 	number to add
	 * @param row
	 * @param col
	 */
	public void setNum(Integer num, int row, int col) {
		if(checkNum(num) && cell[row][col] == null) {
			cell[row][col] = num;
		}
	}
	
	/**
	 * Replaces a number if the position contains an Integer only
	 * @param num
	 * @param row
	 * @param col
	 */
	 public void replaceNum(Integer num, int row, int col) {
		 if(checkNum(num) && cell[row][col].getClass() == Integer.class) {
			 cell[row][col] = num; 
		 }
	 }
	
	/**
	 * Returns number from cell position
	 * @param row
	 * @param col
	 * @return
	 * 	number in position
	 */
	public Integer getNum(int row, int col) {
		
		return cell[row][col];
	}
	
	/**
	 * Returns cell.
	 * @return
	 * 	cell
	 */
	public Integer[][] getCell(){
		return cell;
	}
	
	/**
	 * Returns desired row as array
	 * @param row
	 * @return
	 * 
	 */
	public Integer[] getCellRow(int row) {//use this for checking and for printing entire board.
		Integer[] toRet = new Integer[size];
		for(int i = 0; i < size; i++) {
			toRet[i] = cell[row][i];
		}
		return toRet;
	}
	
	/**
	 * Returns the column desired AS AN ARRAY (TO NOTE THIS MEANS THAT THE ARRAY IS HORIZONTAL).
	 * @param col
	 * @return
	 * 	column array (as row array)
	 */
	public Integer[] getCellCol(int col) {//prob only use this for checking
		Integer[] toRet = new Integer[size];
		for(int i = 0; i < size; i++) {
			toRet[i] = cell[i][col];
		}
		return toRet;
	}
	
	/**
	 * Prints the cell to the console. 
	 * 
	 * Only really used this for testing the 
	 */
	public void printCell() {
		for(int i = 0; i < size; i++) {
			System.out.println(Arrays.toString(cell[i]));
		}
	}
	
	/**
	 * Helper method checks if the number is already placed in the cell or if the number is in between the numbers they can play
	 * @param num
	 * 	number to check
	 * @return
	 * 	boolean
	 */
	private boolean checkNum(Integer num) {
		if(num.intValue() < 1 || num.intValue() > (size*size)) {
			return false;
		}
		for(int row = 0; row < size; row++ ) {
			for(int col = 0; col < size; col++) {
				if(num.equals(cell[row][col])) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Returns the length of the size of the cell
	 * @return
	 * 	size
	 */
	public int getSize() {
		return size;
	}
}
