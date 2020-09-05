package dsf.algorithm.archive.ac.t1;

import java.util.Scanner;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/18 18:57
 */
public class P4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            if (line == null || line.length() == 0) {
                System.out.println(-1);
                continue;
            }
            int n = line.length();
            if (line.charAt(0) == '-') {
                System.out.println(0);
                continue;
            }
            if (line.charAt(n-1) == '-') {
                System.out.println(n-1);
                continue;
            }
            int l = -1, r = -1, ml = -1, mr = -1;
            char last = 'p';
            for (int i=0; i<n; i++) {
                if (line.charAt(i) == '-') {
                    if (last != '-') {
                        l = r = i;
                    } else {
                        r++;
                        if (r-l > mr-ml) {
                            mr = r;
                            ml = l;
                        }
                    }
                }
                last = line.charAt(i);
            }
            System.out.println((ml+mr)/2);
        }
    }
}
