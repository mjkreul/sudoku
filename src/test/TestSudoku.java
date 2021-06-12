package test;

import sudoku.SudokuCell;
import sudoku.SudokuGame;
import sudoku.SudokuSolver;

import java.util.Arrays;

public class TestSudoku {

	public static void main(String[] args) throws Exception {
////		SudokuCell s = new SudokuCell();
////		s.printCell();
////		System.out.println();
////		s.setNum(1, 0, 0);
////		s.printCell();
////		System.out.println();
////		s.setNum(1, 2, 2);
////		s.printCell();
////		System.out.println();
////		s.setNum(2, 2, 2);
////		s.printCell();
////		System.out.println();
////		s.setNum(3, 2, 2);
////		s.printCell();
////		System.out.println();
////		s.replaceNum(3, 2, 2);
////		s.printCell();
////		System.out.println();
////		s.setNum(10, 1, 2);
////		s.printCell();
////		System.out.println();
////		s.replaceNum(10, 2, 2);
////		s.printCell();
////		System.out.println();
//
//		SudokuGame g = new SudokuGame(2);
//		SudokuCell c = g.getCell(0, 0);
//		c.printCell();
//		System.out.println();
//		g.printBoard();
//		System.out.println();
//		/**
//		 * saved complete gameboard
//		 */
//		g.setNum(1, 0, 0, 0, 0);
//		g.setNum(2, 0, 0, 0, 1);
//		g.setNum(3, 0, 0, 1, 0);
//		g.setNum(4, 0, 0, 1, 1);
//		g.setNum(3, 0, 1, 0, 0);
//		g.setNum(4, 0, 1, 0, 1);
//		g.setNum(2, 0, 1, 1, 0);
//		g.setNum(1, 0, 1, 1, 1);
//		g.setNum(4, 1, 0, 0, 0);
//		g.setNum(3, 1, 0, 0, 1);
//		g.setNum(2, 1, 0, 1, 0);
//		g.setNum(1, 1, 0, 1, 1);
//		g.setNum(2, 1, 1, 0, 0);
//		g.setNum(1, 1, 1, 0, 1);
//		g.setNum(4, 1, 1, 1, 0);
//		g.setNum(3, 1, 1, 1, 1);
//		g.printBoard();
//		System.out.println();
//		g.setNum(2, 0, 0, 0, 0);
//		g.printBoard();
//		System.out.println();
		int[][] board = {
				{-1, 7, -1, 9, -1, -1, -1, 6, 1 },
				{1, -1, -1, 7, -1, -1, 8, 9, 5 },
				{-1, 5, 6, -1, 3, -1, -1, 7, -1 },
				{-1, 9, 8, 6, 1, 2, 7, 5, -1 },
				{6, -1, 7, -1, 8, -1, -1, 2, -1 },
				{-1, -1, -1, 4, 7, -1, -1, 3, -1 },
				{7, -1, -1, 2, 9, 4, -1, -1, 3 },
				{-1, -1, -1, -1, -1, -1, -1, -1, -1 },
				{-1, 3, 5, 8, -1, -1, -1, -1, 7 }
		};
		SudokuSolver test = new SudokuSolver(board);
		test.printBoard();
		int[][] output = test.solve();
//		for(int i = 0; i < 9; i++){
//			System.out.println(Arrays.toString(output[i]));
//		}
		test.printBoard();

	}
}
