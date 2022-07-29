package practice;

import java.util.*;

public class Test {

    static int get(int[][] a, int 회전, int 행이동, int 열이동, int 행, int 열) {
        행 -= 행이동;
        열 -= 열이동;
        if (행 < 0 ||  a.length - 1 < 행) return 0;
        if (열 < 0 ||  a.length - 1 < 열) return 0;
        if (회전 == 1) { // 90도
            int t = 행;
            행 = a.length - 1 - 열;
            열 = t;
        } else if (회전 == 2) { // 180 도
            행 = a.length - 1 - 행;
            열 = a.length - 1 - 열;
        } else if (회전 == 3) { // 270 도
            int t = 행;
            행 = 열;
            열 = a.length - 1 - t;
        }
        return a[행][열];
    }

    static void print(int[][] key, int 회전, int 행이동, int 열이동) {
        for (int 행 = -2; 행 < key.length + 2; ++행) {
            for (int 열 = -2; 열 < key.length + 2; ++열) {
                int k = get(key, 회전, 행이동, 열이동, 행, 열);
                System.out.printf("%2s ", k > 0 ? String.valueOf(k) : ".");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] a = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int 회전 = 0; 회전 < 4; ++회전) {
            System.out.println("--------");
            for (int 이동 = -a.length + 1; 이동 < a.length; ++이동) {
                print(a, 회전, 이동, 이동);
            }
        }
    }

}