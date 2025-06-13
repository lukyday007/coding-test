package Programmers;
import java.util.*;

public class Lv1_Minisize_Rectangle {

    class Minisize_Rectangle_Sort {
        public int solution(int[][] sizes) {

            for (int i = 0; i < sizes.length; i ++) {
                int tmp = sizes[i][0];
                if (sizes[i][0] > sizes[i][1]) {
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = tmp;
                }
            }

            int w = 0, h = 0;
            if (sizes[0][0] > sizes[0][1]) {

                Arrays.sort(sizes, (a, b) -> b[0] - a[0]);
                h = sizes[0][0];

                for (int i = 0; i < sizes.length; i ++) {
                    w = Math.max(w, sizes[i][1]);
                }

            } else {

                Arrays.sort(sizes, (a, b) -> b[1] - a[1]);
                w = sizes[0][1];

                for (int i = 0; i < sizes.length; i ++) {
                    h = Math.max(h, sizes[i][0]);
                }
            }

            return w * h;
        }
    }

    class Minisize_Rectangle_MinMax {
        public int solution(int[][] sizes) {
            int maxW = 0;
            int maxH = 0;

            for (int[] size : sizes) {
                int w = Math.min(size[0], size[1]);
                int h = Math.max(size[0], size[1]);
                maxW = Math.max(maxW, w);
                maxH = Math.max(maxH, h);
            }

            return maxW * maxH;
        }
    }
}