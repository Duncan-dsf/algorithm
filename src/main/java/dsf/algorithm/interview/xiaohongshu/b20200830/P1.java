package dsf.algorithm.interview.xiaohongshu.b20200830;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/30 19:39
 */
public class P1 {

    static String[] splitMsg(String text) {

        int n = text.length();
        if (n <= 1024)
            return new String[]{text};
        char[] arr = text.toCharArray();
        ArrayList<String> list = new ArrayList<>(n/1024+1);
        int last = -1;
        for (int i=1023; i<n; ) {
            boolean flag = true;
            int next = -1;
            for (int j=i; j>last; j--) {
                if (arr[j] == '\n') {
                    list.add(text.substring(last+1, j+1));
                    flag = false;
                    last = j;
                    break;
                } else if (arr[j] == '.')
                    next = j;
            }
            if (flag) {
                list.add(text.substring(last+1, next+1));
                last = next;
            }
            i = last+1024;
        }
        if (last < n-1) {
            list.add(text.substring(last+1));
        }
        String[] res = new String[list.size()];
        return  list.toArray(res);
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] res;
        StringBuffer sb = new StringBuffer();
        while (in.hasNextLine()){
            String line = in.nextLine() ;
            if (line.length()==0)break;
            sb.append(line +"\n");
        }

        res = splitMsg(sb.toString());
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.format("msg%d:%s",res_i+1,res[res_i]));
        }

    }
}
