package dsf.algorithm.meituan;

import java.util.Scanner;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/5/12 11:43
 */
public class P4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int k = scanner.nextInt();
            int n = line.length(), res = 0;
            for (int i = 0; i< n; i++) {
                for (int j = i+1+2*k; j <= n; j++) {
                    for (int m=k; m*2+1 <= (j-i); m++) {

                        if (line.substring(i, j).endsWith(line.substring(i, i+m))) {
                            res++;
                            break;
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
}
