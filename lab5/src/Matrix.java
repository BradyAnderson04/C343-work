import java.util.Random;

/**
 * @author brady anderson
 *
 * February 19, 2019
 * 
 * matrix Library class
 * 
 * This class manipulates matrices 
 */

public class Matrix {
	
	private boolean[][] matrix;
	private final int NUMROW;
	private final int NUMCOL;
	
	
	public Matrix(boolean[][] m) {
		// initialize numrow and numcol
		NUMROW = m.length;
		NUMCOL = m[0].length;
		// initialize m
		matrix = m;
	} 
	
	public String toString() {
		// get total options and divide by row #
		String output = "[";
		for(int row = 0; row < NUMROW; row++) {
			for(int col = 0; col < NUMCOL; col++) {
				if(matrix[row][col] && col != NUMCOL -1) {
					output += "1, ";
				} else if(matrix[row][col] && col == NUMCOL -1) {
					output += "1";
				} else if(!matrix[row][col] && col == NUMCOL -1) {
					output += "0";
				}else {
					output += "0, ";
				}
			}
			if(row != NUMROW -1) {
			output += "\n";
			}
		}
		output += "]";
		return output; 	
	}
	
	public Matrix transposeMatrix() {
		boolean [][] transposeM = new boolean[NUMCOL][NUMROW];
		for(int col = 0; col < NUMCOL; col++) {
			for(int row = 0; row < NUMROW; row++) {
				transposeM[col][row] = matrix[row][col];
			}
		}
		Matrix tm = new Matrix(transposeM);
		return tm; 
		
	}
	public boolean isSquareMatrix() {
		if(NUMROW == NUMCOL) {
			return true;
		} else {
			return false; 		
		}
	}
	public Matrix rotateClockwise() {
		// make c1 = r1
		boolean [][] cwMatrix = new boolean[NUMCOL][NUMROW];
		for(int col = 0; col < NUMCOL; col++) {
			for(int row = NUMROW; row  > 0; row--) {
				cwMatrix[col][NUMROW - row] = matrix[row-1][col];
			}
		}
		Matrix cw = new Matrix(cwMatrix);
		return cw; 
		
	} 
	public Matrix rotateCounterClockwise() {
		// r c
		boolean [][] ccwMatrix = new boolean[NUMCOL][NUMROW];
		for(int col = NUMCOL; col > 0; col--) {
			for(int row = 0; row  < NUMROW; row++) {
				ccwMatrix[col-1][row] = matrix[row][NUMCOL - col];
			}
		}
		Matrix ccw = new Matrix(ccwMatrix);
		return ccw; 
		
	} 
	public String percentageTrue() {
		Integer total = NUMCOL * NUMROW;
		Double count = 0.0;
		for(int col = 0; col < NUMCOL; col++) {
			for(int row = 0; row < NUMROW; row++) {
				if(matrix[col][row] == true) {
					count += 1;
				}
			}
		}
		Double percent = 100 * (count / total);
		return Double.toString(percent) + "%"; 
		
	}  
	public boolean isEqual (Matrix m) {
		boolean status = true;
		for(int col = 0; col < NUMCOL; col++) {
			for(int row = 0; row < NUMROW; row++) {
				if(m.matrix[col][row] != matrix[row][col]) {
					status = false;
				}
			}
		}
		if(NUMCOL == m.NUMCOL && NUMROW == m.NUMROW && status) {
			return true;
		}
		return false; 
		
	}
	
	public static void main(String[] args) {
		// column x row
		Random rand = new Random();
		boolean [][] m = new boolean[2][2];
		boolean [][] n = new boolean[2][2];
		for(int row = 0; row < m.length; row++) {
			for(int col = 0; col < m[0].length; col++) {
				m[row][col] = rand.nextBoolean();
				n[row][col] = rand.nextBoolean();
			}
		}
		
		Matrix matrix = new Matrix(m);
		Matrix natrix = new Matrix(n);
		// jUnit testing here
		System.out.println(matrix.toString());
		System.out.println(matrix.transposeMatrix());
		System.out.println(matrix.rotateClockwise());
		System.out.println(matrix.rotateCounterClockwise());
		System.out.println(matrix.percentageTrue());
		System.out.println(matrix.isEqual(natrix));
		
	}
	
} 