import java.util.*;

////////////////////////////////////////////////////////////////////////////////////
//
//C212
//
//Lab 6
//@Author  Brady Anderson
//Explain: 
// Simulates the popular game of life on the terminal
// where o = alive and + = dead

// this is my makeup lab for week 6
///////////////////////////////////////////////////////////////////////////////////


public class GameOfLife { 
	private boolean[][] board; 
	private final int NUMROW;
	private final int NUMCOL;
	public GameOfLife (boolean[][] initialBoard) { 
		// initialize row and columns based off input size!
		NUMROW = initialBoard.length;
		NUMCOL = initialBoard[0].length;
		board = new boolean[NUMROW][NUMCOL];
		// iterate through input to initialize values
		for(int i = 0; i<NUMROW; i++) {
			for(int j = 0; j <NUMCOL; j++) {
				board[i][j] = initialBoard[i][j];
			}
		}
		System.out.println(NUMROW);
		System.out.println(NUMCOL);
	} 
	// make the game board pretty print
	public String toString() { 
		// value to print 
		String output = "";
		for(int i = 0; i<NUMROW; i++) {
			for(int j = 0; j <NUMCOL; j++) {
				// detect value and print according symbol
				if(board[i][j] == true) {
					output += "o ";
				} else {
					output += "+ ";
				}
				// if final element on a row go to newline
			}
			output += "\n";
		}
		return output;
	}
	
	// support function
	private int checkNeighbor(int x, int y){  // y = row x = column
		/*
		 * based off different locations different amounts of points will need to be checked
		 * so I used multiple if statements to designate how to handle these various locations 
		 * on the GOL board -> from there I check all neighbors of those points
		 */
		// return value 
		int count = 0;
		// check all neighbors - up, down, left, right, diagonals
		if(x == 0 && y == 0) {
			// top left
			for(int i = y; i<y+2; i++) {
				for(int j = x; j <x+2; j++) {
					if(board[i][j] && i!=x && j!=y ) {
						count ++;
					}
				}	
			}
			if(board[0][0] == true) {
				count -= 1;
			}
		}else if( x == NUMCOL-1 && y == NUMROW-1 ) {
			// bottom right
			for(int i = y-1; i<y; i++) {
				for(int j = x-1; j <x; j++) {
					if(board[i][j] == true && i!=x && j!=y) {
						count ++;
					}
				}
			}
		}else if(x == NUMCOL-1 && y == 0){
			// top right
			for(int i = y; i<y+2; i++) {
				for(int j = x-1; j <x+1; j++) {
					if(board[i][j] == true && i!=x && j!=y) {
						count ++;
					}
				}
			}
		}else if( x == NUMCOL -1 ) {
			// right edge, but not bottom or top
			for(int i = y -1; i<y+2; i++) {
				for(int j = x-1; j <x+1; j++) {
					if(board[i][j] == true && i!=x && j!=y) {
						count ++;
					}
				}
			}
		}else if(x == 0 && y == NUMROW -1){
			// bottom left
			for(int i = y - 1; i < y; i++) {
				for(int j = x; j <x+2; j++) {
					if(board[i][j] == true && i!=x && j!=y) {
						count ++;
					}
				}
			}
		}else if(x == 0) {
			// left edge
			for(int i = y-1; i<y+2; i++) {
				for(int j = x; j <x+1; j++) {
					if(board[i][j] == true && i!=x && j!=y) {
						count ++;
					}
				}
			}
		}else if(y == NUMROW-1) {
			// bottom row, but not bottom left / right
			for(int i = y-1; i < y; i++) {
				for(int j = x-1; j < x+2; j++) {
					if(board[i][j] == true && i!=x && j!=y) {
						count ++;
					}
				}
			}
		}else if(y == 0) {
			// top row but not top left / right
			for(int i = y; i<y+2; i++) {
				for(int j = x-1; j <x+2; j++) {
					if(board[i][j] == true && i!=x && j!=y) {
						count ++;
					}
				}
			}
		} else {
			// middle of grid somewhere
			for(int i = y-1; i<y+2; i++) {
				for(int j = x-1; j <x+2; j++) {
					if(board[i][j] == true && i!=x && j!=y) {
						count ++;
					}
				}
			}
		}
		return count;
	} 
	
	// run a generation
	public void grow(int generation, int freqPrint) { 
		boolean[][] newBoard = new boolean[NUMROW][NUMCOL];
		// printing frequency tracker and repeat system
		for(int repeat = 0; repeat <= generation; repeat++) {
			// change value of a cell as a new boolean 2d array
			for(int y = 0; y<NUMROW; y++) {
				for(int x = 0; x <NUMCOL; x++) {
					int m = checkNeighbor(x, y);
					if(m > 3 || m < 2) {
						newBoard[y][x] = false;
					}else if(m == 3){
						newBoard[y][x] = true;
					}else if(m == 2 && board[y][x] == true) {
						newBoard[y][x] = true;
					}else {
						newBoard[y][x] = false;
					}
				}
			}
			board = newBoard;
			if(repeat % freqPrint == 0 && repeat != 0) {
				// print new matrix
				System.out.println(toString());
			}
		}
	} 
		
	public static void main(String[] args) {
		// random generator for java boolean array
		Random rand = new Random();
		boolean[][] board = new boolean[5][5];
		boolean[][] board1 = new boolean[6][6];
		// initialize boolean 2d array
		for(int i = 0; i< board.length; i++) {
			for(int j = 0; j <board[0].length; j++) {
				board[i][j] = rand.nextBoolean();
			}
		}
		
		// initialize boolean 2d array
		for(int i = 0; i< board1.length; i++) {
			for(int j = 0; j <board1[0].length; j++) {
				board1[i][j] = rand.nextBoolean();
			}
		}
		GameOfLife game = new GameOfLife(board);
		GameOfLife game1 = new GameOfLife(board1);
		// still life test
		System.out.println("Still Life Test");
		System.out.println(game.toString());
		game.grow(100, 20);
		// oscillator life test
		System.out.println("Oscillator Life Test");
		System.out.println(game1.toString());
		game1.grow(20, 1);
	}
} 