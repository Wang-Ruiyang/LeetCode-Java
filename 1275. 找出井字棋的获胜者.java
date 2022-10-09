class Solution {

    public String tictactoe(int[][] moves) {
        String[][] well = new String[3][3];
        for (int i=0;i<moves.length;i++) {
            if (i%2==0) {   //X
                well[moves[i][0]][moves[i][1]] = "A";
            }
            else {
                well[moves[i][0]][moves[i][1]] = "B";
            }
        }
        for (int i=0;i<3;i++) {
            if (well[i][0] == well[i][1] && well[i][0] == well[i][2] && well[i][0]!=null) {
                return well[i][0];
            }
            if (well[0][i] == well[1][i] && well[0][i] == well[2][i] && well[0][i]!=null) {
                return well[0][i];
            }
        }
        if (well[0][0] == well[1][1] && well[0][0] == well[2][2] && well[0][0]!=null) {
            return well[1][1];
        }
        if (well[0][2] == well[1][1] && well[0][2] == well[2][0] && well[0][2]!=null) {
            return well[1][1];
        }
        if (moves.length==9) {
            return "Draw";
        }
        return "Pending";
    }
}