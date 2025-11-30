package code.multithreading;

public class Print1to10 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
            }
        });

        t1.start();
        t2.start();
    }
}
