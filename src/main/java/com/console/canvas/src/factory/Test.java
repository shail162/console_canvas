package com.console.canvas.src.factory;

/**
 * Created by Sneha on 11/12/2017.
 */
public class Test {

    public static void main(String args[]) {
        long c_time = System.currentTimeMillis();
        n_squares(5000);
        System.out.println(System.currentTimeMillis() - c_time);
    }

    static String n_squares(int n) {
        StringBuffer s = new StringBuffer("0");
        int n_squared = n*n;
        for (int i=0; i<n_squared; i++) {
            s.append (", " + i);
        }
        return s.toString();
    }
}
