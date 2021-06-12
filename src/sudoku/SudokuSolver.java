package sudoku;


import java.util.Arrays;
import java.util.Stack;

public class SudokuSolver {

	private int[][] originalBoard;
	private int[][] squares;








	//TODO: entire class

	SudokuSolver(){
		originalBoard = new int[9][9];
		squares = new int[3][3];
	}

	/**
	 * Should I be throwing an exception?
	 * @param board
	 * @throws Exception
	 */
	public SudokuSolver(int[][] board) {

		originalBoard = new int[9][9];
		squares = new int[3][3];
		for(int i = 0; i < originalBoard.length; i++){
			for (int j = 0; j < originalBoard.length; j++){
				originalBoard[i][j] = board[i][j];
			}
		}
		int k = 1;
		for(int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				squares[i][j] = k++;
			}
		}

		//add below once semiworking version is working

//		if(board[0].length != board.length){
//			throw new Exception();
//		}
//		else{
//			originalBoard = new int[board.length][board.length];
//			for(int i = 0; i < originalBoard.length; i++){
//				for (int j = 0; j < originalBoard.length; j++){
//					originalBoard[i][j] = board[i][j];
//				}
//			}
//		}
	}

	/**
	 * Brute force algorithm
	 * @return
	 */
	public int[][] solve(){
		//start at [0,0] try number and then iterate until it is completed
		//check the square it's currently in
		//row 0-2 col 0-2 -> check surrounding
		//row 3-5 col 0-2 ->

		//now, need to figure out how to go back to the previous square if it is not solved yet
		int i = 0,j = 0;
		int k = 1;
		// start checking at 0,0
		// if the check doesn't pass for k = 1 then increment k
		// if the check does pass, then continue to the next "unsolved" indices going row by row
		// continue
		// if one of the empty boxes does not find a correct number, go back to the previous "solved" index and continue
		// counting.
		// if that doesn't work, continue down until the

		//holds where the previously solved index was
		// instead use a stack and then just pop until you reach the first index
		Stack<Index> prevSolvedBox = new Stack<>();
//		Index[][] prevIndex = new Index[9][9];
//		for(int l = 0; l < 9; l++){
//			for (int m = 0; m < 9; m++){
//				prevIndex[l][m] = new Index();
//				prevIndex[l][m].i = -1;
//				prevIndex[l][m].j = -1;
//			}
//		}


		while(i < 9){
			j = 0;
			while(j < 9){
				// if this current box has not been solved
				if (originalBoard[i][j] == -1){
					if(checkSquare(i, j, k) && checkRowCol(i, j, k)){
						//iterate the column
						Index tempIndex = new Index(i, j);
						prevSolvedBox.push(tempIndex);
						originalBoard[i][j] = k;
						j++;
						k = 1;
//						prevIndex[i][j].i = tempi;
//						prevIndex[i][j].j = tempj;
//						printBoard();
//						System.out.println("Stack size: " + prevSolvedBox.size());
//						System.out.println("i: " + i + " j: " + j + " k: " + k);
					}
					else{
						// if k is equal to 9 now then we have looked through all of the possibilities and need to
						// backtrack our current solution
						k++;
						while(k > 9){
							//go back to previously "solved" indices
							//i = row of prevSolvedBox
							//j = col of prevSolvedBox
							Index tempIndex = prevSolvedBox.pop();
							i = tempIndex.i;
							j = tempIndex.j;
							//k = originalBoard[i][j] + 1
							k = originalBoard[i][j] + 1;

							// reset this value to -1 so that we can check it again
							originalBoard[i][j] = -1;
						}
//						else{
//							k++;
////							k = k%9 + 1;
//						}

					}
				}
				// otherwise go to the next box and start at k = 1
				else{
					j++;
					k = 1;
				}

//				if(j == 8 && i ==8 ) break;
			}
			//once we've gotten past all of the columns and "solved them"
			i++;
		}


		return originalBoard;
	}

	/**
	 * Possibly change this.  This will iterate through the squares while skipping the square the algorithm is currently
	 * on.
	 * @param i
	 * @param j
	 * @param k
	 * @return
	 */
	private boolean checkSquare(int i, int j, int k){
		//which square do we need to check? 1,1; 1,2; 1,3;
		int row = i/3;
		int col = j/3;
		int square = squares[row][col];
//		for(int l = row; l < row + 3; l++){
//			for (int m = col; m < col + 3; m++) {
//				if (i == l && j == m) m++;
//				if (originalBoard[l][m] == k && m < col + 3) {
//					return false;
//				}
//			}
//		}


		switch (square){
			case 1:
				for(int l = 0; l < 3; l++){
					for(int m = 0; m < 3; m++){
//						if(i == l && j ==m) m++;
						if (originalBoard[l][m] == k){
							return false;
						}
					}
				}
				break;
			case 2:
				for(int l = 0; l < 3; l++){
					for(int m = 3; m < 6; m++){
//						if(i == l && j ==m) m++;
						if (originalBoard[l][m] == k){
							return false;
						}
					}
				}
				break;
			case 3:
				for(int l = 0; l < 3; l++){
					for(int m = 6; m < 9; m++){
//						if(i == l && j == m) m++;
						if (originalBoard[l][m] == k){
							return false;
						}
					}
				}
				break;
			case 4:
				for(int l = 3; l < 6; l++){
					for(int m = 0; m < 3; m++){
//						if(i == l && j == m) m++;
						if (originalBoard[l][m] == k){
							return false;
						}
					}
				}
				break;
			case 5:
				for(int l = 3; l < 6; l++){
					for(int m = 3; m < 6; m++){
//						if(i == l && j ==m) m++;
						if (originalBoard[l][m] == k){
							return false;
						}
					}
				}
				break;
			case 6:
				for(int l = 3; l < 6; l++){
					for(int m = 6; m < 9; m++){
//						if(i == l && j ==m) m++;
						if (originalBoard[l][m] == k){
							return false;
						}
					}
				}
				break;
			case 7:
				for(int l = 6; l < 9; l++){
					for(int m = 0; m < 3; m++){
//						if(i == l && j ==m) m++;
						if (originalBoard[l][m] == k){
							return false;
						}
					}
				}
				break;
			case 8:
				for(int l = 6; l < 9; l++){
					for(int m = 3; m < 6; m++){
//						if(i == l && j ==m) m++;
						if (originalBoard[l][m] == k){
							return false;
						}
					}
				}
				break;
			case 9:
				for(int l = 6; l < 9; l++){
					for(int m = 6; m < 9; m++){
//						if(i == l && j ==m) m++;
						if (originalBoard[l][m] == k){
							return false;
						}
					}
				}
				break;
		}

		return true;
	}

	private boolean checkRowCol(int i, int j, int k){

		//check the column
		for(int l = 0; l < 9; l++){
			if(originalBoard[i][l] == k){
				return false;
			}
		}
		for (int m = 0; m < 9; m++){
			if (originalBoard[m][j] == k){
				return false;
			}
		}

		return true;
	}

	public void printBoard(){
		System.out.println("--------------------------------------");
		int l = 1;
		for (int[] i : originalBoard) {
			System.out.print("| ");
			int k = 1;
			for (int j: i) {
				if(j < 1) System.out.print(" _ ");
				else System.out.print(" " + j + " ");
				if(k%3 == 0) System.out.print(" | ");
				k++;
			}
//			System.out.println("|  6  1  7  |  3  8  9  |  _  2  _  | ");
			System.out.println();
			if(l%3 == 0) System.out.println("--------------------------------------");
			l++;
		}
	}


	public static class Index{
		public int i ;
		public int j ;
		public Index(){
			this.i = -1;
			this.j = -1;
		}
		public Index(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
}



