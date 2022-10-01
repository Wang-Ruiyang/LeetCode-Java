import java.util.ArrayList;
import java.util.List;

class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;   //行号
        List<Integer> rows = new ArrayList<Integer>();    //行号
        List<Integer> columns = new ArrayList<Integer>();    //列号
        for (int i=0;i<r;i++) {
            for (int j =0;j<matrix[i].length;j++) {
                if (matrix[i][j] == 0) {
                    if (!rows.contains(i)) {
                        rows.add(i);
                    }
                    if (!columns.contains(j)) {
                        columns.add(j);
                    }
                }
            }
        }
        for (int i=0;i<r;i++) {
            for (int j =0;j<matrix[i].length;j++) {
                if (rows.contains(i) || columns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}