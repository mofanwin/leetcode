package daily_exercise.I1778;

public class GridMaster {
    int[][] metrics;
    int row;
    int col;
    public GridMaster(int [][] metrics) {
        this.metrics = metrics;
        for(int i = 0 ; i < metrics.length;i++) {
            for(int j = 0 ; j < metrics[0].length ; j++) {
                if(metrics[i][j] == -1){
                    row = i;
                    col = j;
                    break;
                }
            }
        }
    }

    boolean isTarget() {
        return metrics[row][col] == 2;
    }

    boolean canMove(char direction) {
        int r = row;
        int c = col;
        if(direction  == 'U') r--;
        else if(direction == 'R') c++;
        else if(direction == 'D') r++;
        else c--;
        if(r >=0 && r < metrics.length && c >=0 && c < metrics[0].length && metrics[r][c] != 0) return true;
        else return false;
    }

    void move(char direction) {
        if(canMove(direction)) {
            if(direction  == 'U') row--;
            else if(direction == 'R') col++;
            else if(direction == 'D') row++;
            else col--;
        }
    }
}
