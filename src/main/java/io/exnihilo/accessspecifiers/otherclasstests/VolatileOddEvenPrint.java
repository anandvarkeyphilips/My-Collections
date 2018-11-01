package io.exnihilo.accessspecifiers.otherclasstests;

public class VolatileOddEvenPrint {
    volatile int n;
    public static void main(String[] args) {
        final int maxNumber = 100;

        Runnable runnable = new Runnable() {
            private volatile int i = 0;
            private volatile boolean isEven = true;

            @Override
            public void run() {
                try {
                    while (i < maxNumber) {
                        if (isEven) {
                            synchronized (this) {
                                System.out.println(Thread.currentThread().getName() + ": " + i);
                                i++;
                                isEven = !isEven;
                                notify();
                                wait();
                            }
                        } else if (!isEven) {
                            synchronized (this) {
                                System.out.println(Thread.currentThread().getName() + ": " + i);
                                i++;
                                isEven = !isEven;
                                notify();
                                wait();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread a = new Thread(runnable);
        a.setName("Odd");
        Thread b = new Thread(runnable);
        b.setName("Even");
        a.start();
        b.start();
    }
}