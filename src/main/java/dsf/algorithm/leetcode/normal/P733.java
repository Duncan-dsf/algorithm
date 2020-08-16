package dsf.algorithm.leetcode.normal;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/16 15:46
 */
public class P733 {

    public int[][] floodFill(int[][] image, int i, int j, int newColor) {


        if (newColor == image[i][j]) return image;
        int old = image[i][j];
        image[i][j] = newColor;

        if (i>0 && old == image[i-1][j])
            floodFill(image, i-1, j, newColor);
        if (i < image.length-1 && old == image[i+1][j])
            floodFill(image, i+1, j, newColor);
        if (j > 0 && old == image[i][j-1])
            floodFill(image, i, j-1, newColor);
        if (j < image[0].length-1 && old == image[i][j+1])
            floodFill(image, i, j+1, newColor);

        return image;
    }

}
