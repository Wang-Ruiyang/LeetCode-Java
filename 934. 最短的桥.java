class Solution {

    int[][] step = {{1,0},{-1,0},{0,1},{0,-1}};

    Deque<int[]> edge;

    public int shortestBridge(int[][] grid) {
        boolean isFind = false;

        edge = new ArrayDeque<>();

        //通过找到一个岛屿的一块，利用DFS找到这个岛屿的所有块，并标记为2
        //并找到它的边源水域，也标记成为2，并加入edge队列
        for (int i=0;i<grid.length;i++) {
            if (isFind) {
                break;
            }
            for (int j=0;j<grid[0].length;j++) {
                if (isFind) {
                    break;
                }
                if (grid[i][j]==1) {    //表示已经找到了第一个岛屿的一块了
                    isFind = true;
                    Mark(grid,i,j);     //对当前块进行标记为2（通过DFS岛屿标记）
                }
            }
        }

        int result = 1;    //目前已经扩充一波水域

        //此时第一轮扩充已经完成
        while (!edge.isEmpty()) {

            int n = edge.size();    //获取第一个岛屿的边缘水域
            for (int i=0;i<n;i++) {
                int[] loc = edge.pollFirst();    //第一个区域的边缘位置
                for (int[]s : step) {    //对当前位置的四个方向进行扩充
                    int x = loc[0]+s[0], y = loc[1]+s[1];
                    if (!isLegal(x,y,grid.length)) {       //如果位置不合法
                        continue;
                    }
                    if (grid[x][y] == 2) {
                        continue;
                    }
                    if (grid[x][y] == 1) {    //表示已经找到了另一个岛屿
                        return result;
                    }
                    if (grid[x][y] == 0) {    //扩充水域
                        grid[x][y] = 2;
                        edge.addLast(new int[]{x,y});
                    }
                }
            }
            result++;
        }
        return result;
    }

    public void Mark(int[][] grid, int i, int j) {
        if (!isLegal(i,j,grid.length)) {    //如果不是合法位置，退出
            return;
        }
        if (grid[i][j]==2) {    //如果是同一个岛屿且已经被标记，退出
            return;
        }
        if (grid[i][j]==1) {     //如果是同一个岛屿但是还没有被标记
            grid[i][j] = 2;
            for (int[]s : step) {
                Mark(grid,i+s[0],j+s[1]);
            }
        }
        if (grid[i][j]==0) {     //如果遇到水域，则表示已经到了这个岛屿的边界了，将这个水也变成岛屿的一部分，在存储边界水域的edge中添加
            grid[i][j] = 2;
            edge.addLast(new int[]{i,j});
        }
    }

    public boolean isLegal(int i, int j, int n) {    //判断是否在合法区域（没有超过边界）
        if (i<0 || i>=n || j<0 || j>=n) {
            return false;
        }
        return true;
    }
}