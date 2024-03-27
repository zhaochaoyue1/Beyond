package com.example.algorithm.huarongdao;

/**
 * @description: SushiHuarongDao
 * @date: 2023/12/1 下午7:42
 * @author: zcy
 * @version: 1.0
 */
public class SushiHuarongDao {
    private int[][] board;
    private int rows;
    private int cols;
    private boolean[][] visited;

    public SushiHuarongDao(int[][] board) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        this.visited = new boolean[rows][cols];
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private boolean isExitReached() {
        // 根据游戏规则定义出口状态
        return board[3][1] == 0 && board[3][2] == 0;
    }

    private void move(int x1, int y1, int x2, int y2) {
        // 在棋盘上移动寿司块
        int temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    private boolean dfs(int depth) {
        if (depth == 0) {
            return false;
        }

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (board[x][y] != 0 && !visited[x][y]) {
                    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
                    for (int[] dir : directions) {
                        int newX = x + dir[0];
                        int newY = y + dir[1];
                        if (isValidMove(newX, newY)) {
                            move(x, y, newX, newY);
                            visited[x][y] = true;
                            if (isExitReached() || dfs(depth - 1)) {
                                return true;
                            }
                            move(newX, newY, x, y);
                            visited[x][y] = false;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // 初始化寿司华容道棋盘
        int[][] board = {
                {1, 1, 2, 0},
                {3, 0, 2, 0},
                {3, 0, 4, 4},
                {5, 5, 0, 6}
        };

        SushiHuarongDao sushiHuarongDao = new SushiHuarongDao(board);

        // 设置深度，可以根据实际情况调整
        int depth = 10;

        if (sushiHuarongDao.dfs(depth)) {
            System.out.println("成功找到解法！");
            for (int[] row : board) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("未找到解法。");
        }
    }
}

