package dsf.algorithm.archive.graph.shortest_path;

/**
 * 参见 https://www.cnblogs.com/wangyuliang/p/9216365.html
 * @author 董少飞
 * @date 2020/1/27
 */
public class Floyd {

    public static void floyd(int[][] graph) {

        int n = graph.length;
        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++)
                    if (graph[i][k] + graph[k][j] < graph[i][j])
                        graph[i][j] = graph[i][k] + graph[k][j];
            }
        }
    }
}
