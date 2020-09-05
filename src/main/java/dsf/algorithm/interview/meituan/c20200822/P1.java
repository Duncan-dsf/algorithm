package dsf.algorithm.interview.meituan.c20200822;

import java.util.Scanner;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/22 15:56
 */
public class P1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] arr = new String[n];
            for (int i=0; i<n; i++) {
                arr[i] = scanner.nextLine();
            }

            for (int i=0; i<n; i++) {

                boolean numF = false;
                String str = arr[i];
                if (str == null || str.length() < 2) {
                    System.out.println("Wrong");
                    continue;
                }
                char fir = str.charAt(0);
                if (!(fir <= 'z' && fir >= 'a') && !(fir >= 'A' && fir<='Z')) {
                    System.out.println("Wrong");
                    continue;
                }
                for (int j = 1; j< str.length(); j++) {
                    char ch = str.charAt(j);
                    if ((ch >= '0' && ch <= '9'))
                        numF = true;
                    if ((ch >= '0' && ch <= '9') || (ch <= 'z' && ch >= 'a') || (ch >= 'A' && ch<='Z')) {
                    } else {
                        numF = false;
                        break;
                    }
                }
                if (numF) {
                    System.out.println("Accept");
                } else {
                    System.out.println("Wrong");
                }
            }
        }
    }
}
