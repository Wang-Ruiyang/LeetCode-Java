class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        boolean isRow = false, isColumn = false;

        for (int i=0;i<r;i++) {    //看第一列有没有0
            if (matrix[i][0] == 0) {
                isColumn = true;
            }
        }
        for (int i=0;i<c;i++) {    //看第一行有没有0
            if (matrix[0][i] == 0) {
                isRow = true;
            }
        }

        for (int i=1;i<r;i++) {
            for (int j=1;j<c;j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i=1;i<r;i++) {
            for (int j=1;j<c;j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isColumn) {
            for (int i=0;i<r;i++) {    //看第一列有没有0
                matrix[i][0] = 0;
            }
        }

        if (isRow) {
            for (int i=0;i<c;i++) {    //看第一列有没有0
                matrix[0][i] = 0;
            }
        }
    }
}