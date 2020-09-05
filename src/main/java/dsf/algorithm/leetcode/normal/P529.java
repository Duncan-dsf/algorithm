package dsf.algorithm.leetcode.normal;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/20 15:59
 */
public class P529 {

    char[][] board;
    int[][] directions = new int[][] {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    public char[][] updateBoard(char[][] board, int[] click) {

        int i = click[0];
        int j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return board;
        }
        this.board = board;
        expose(i, j);
        return board;
    }

    public void expose(int i, int j) {

        if (i<0 || j<0 || i>=board.length || j>=board[0].length) {
            return;
        }
        if (board[i][j] != 'E') return;
        int sum = 0;
        for (int[] direction : directions) {
            sum += check(i+direction[0], j+direction[1]);
        }
        if (sum == 0) {
            board[i][j] = 'B';
            for (int[] direction : directions) {
                expose(i+direction[0], j+direction[1]);
            }
        } else {
            board[i][j] = (char)(sum+'0');
        }
    }

    public int check(int i, int j) {

        if (i<0 || j<0 || i>=board.length || j>=board[0].length) {
            return 0;
        }
        return board[i][j] == 'M' ? 1 : 0;
    }

}
