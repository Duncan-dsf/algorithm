package dsf.algorithm.leetcode.offer;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/20 21:33
 */
public class P12 {

    private char[][] board;
    int n;
    int m;
    StringBuilder word;
    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0].length == 0) return false;
        if (word == null || word.length() == 0) return true;

        n = board.length;
        m = board[0].length;
        this.board = board;
        this.word = new StringBuilder(word);

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (dfs(i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, int k) {

        if (k == word.length()) return true;
        if (i<0 || j<0 || i>=n || j>=m) return false;
        if (board[i][j] != word.charAt(k))
            return false;
        board[i][j] = '0';
        boolean res = dfs(i, j+1, k+1) || dfs(i, j-1, k+1) || dfs(i-1, j, k+1) || dfs(i+1, j, k+1);
        board[i][j] = word.charAt(k);
        return res;
    }

    public static void main(String[] args) {
        new P12().exist(new char[][]{{'a', 'a'}}, "aaa");
    }
}
