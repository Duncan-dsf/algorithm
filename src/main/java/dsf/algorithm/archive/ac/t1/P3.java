package dsf.algorithm.archive.ac.t1;

import java.util.Scanner;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/18 18:47
 */
public class P3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int p1 = scanner.nextInt(), p2 = scanner.nextInt(), p3 = scanner.nextInt();
            int t1 = scanner.nextInt(), t2 = scanner.nextInt(), t3 = scanner.nextInt();
            int rp = scanner.nextInt();

            if (rp >= t3-1) {
                t3 = 1;
                rp -= (t3-1);
                if (rp >= t2-1) {
                    t2 = 1;
                    rp -= (t2-1);
                    if (rp >= t1-1) {
                        t1 = 1;
                    } else {
                        t1 -= rp;
                    }
                } else {
                    t2 -= rp;
                    rp = 0;
                }
            } else {
                t3 -= rp;
                rp = 0;
            }

            System.out.println(p1+p2+p3-t1*2-t2*4-t3*8);
        }
    }
}
