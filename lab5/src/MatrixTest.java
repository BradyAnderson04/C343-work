import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void test() {
		Random rand = new Random();
		boolean [][] m = new boolean[2][2];
		boolean [][] n = new boolean[2][2];
		
		m[0][0] = true;
		m[0][1] = false;
		m[1][0] = true;
		m[1][1] = false;
		
		n[0][0] = true;
		n[0][1] = false;
		n[1][0] = true;
		n[1][1] = false;
		
		Matrix matrix = new Matrix(m);
		Matrix natrix = new Matrix(n);
		// jUnit testing here
		
		String testString = matrix.toString();
		Matrix testTranspose = matrix.transposeMatrix();
		Boolean testSquare = matrix.isSquareMatrix();
		Matrix testCW = matrix.rotateClockwise();
		Matrix testCCW = matrix.rotateCounterClockwise();
		String testPercent = matrix.percentageTrue();
		Boolean testEqual = matrix.equals(natrix);
		
		assertEquals("[ 1, 0 \n"
				+ "1, 0]", testString);
		assertEquals("[ 1, 0 \n"
				+ "1, 0]", testTranspose);
		assertEquals(true, testSquare);
		assertEquals("[ 1, 1 \n"
				+ "0, 0]",testCW);
		assertEquals("[ 0, 0 \n"
				+ "1, 1]",testCCW);
		assertEquals("50%",testPercent);
		assertEquals(true, testEqual);
	}

}
