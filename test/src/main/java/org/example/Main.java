package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int x = 0;

    static void a(int x, int[] arr) {
        x++;
        arr[0]=99;
        arr = new int[2];
        arr[0]=14;
        arr[1]=16;
    }
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread n = new Thread(() -> {
            synchronized (lock) {
                for(int i = 0; i< 30_000_000; i++) {
                    x++;
                }
            }
        });
        Thread z = new Thread(() -> {
            synchronized (lock) {
            for(int i = 0; i< 25_000_000; i++) {
                x--;
            }
            }
        });
        synchronized (lock) {
            x++;
        }
        n.start();
        z.start();
        n.join();
        z.join();
//        Thread.sleep(1000);
        System.out.println(x);
    }
}