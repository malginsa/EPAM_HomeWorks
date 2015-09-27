package HomeWork150915;

public class MatrixDiag {
  // Matrix consists of "0". Its diagonals are filled up by "1".
  // Diagonals reflects by matrix's boundaries.

  private int[][] matrix;

  private void setOne(final int y, final int x) {
	if ((y < matrix.length) && (x < matrix[0].length))
	  matrix[y][x] = 1;
  }

  public MatrixDiag(final int rows, final int cols) {

	if ((rows < 1) || (cols < 1)) {
	  throw new IndexOutOfBoundsException();
	}

	this.matrix = new int[rows][cols];

	if (cols > rows) {
	  int factor = cols / rows + 1;
	  for (int i = 0; i < rows; i++) {
		for (int n = 0; n < factor; n++) {
		  setOne(i, i + n * rows);
		  setOne(i, rows - i - 1 + n * rows);
		}
	  }
	} else {
	  int factor = rows / cols + 1;
	  for (int i = 0; i < cols; i++) {
		for (int n = 0; n < factor; n++) {
		  setOne(i + n * cols, i);
		  setOne(cols - i - 1 + n * cols, i);
		}
	  }
	}

  }

  @Override
  public String toString() {
	
	String s = "Matrix of rows = " + matrix.length + ", cols = " + matrix[0].length + "\n";
	
	for (int row = 0; row < matrix.length; row++) {
	  for (int col = 0; col < matrix[row].length; col++) {
		s += matrix[row][col] + " ";
	  }
	  s += "\n";
	}

	return s;
  }

  public static void main(final String[] args) {
	MatrixDiag matrixdiag = new MatrixDiag(14, 29);
	System.out.println(matrixdiag);
	matrixdiag = new MatrixDiag(44, 19);
	System.out.println(matrixdiag);
	matrixdiag = new MatrixDiag(4, 1);
	System.out.println(matrixdiag);
//	matrixdiag = new MatrixDiag(0, 3);
//	matrixdiag = new MatrixDiag(-3, 3);
  }

}
