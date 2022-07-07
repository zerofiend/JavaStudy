package more;

/**
 * 线程间通信
 */
public class Demo02 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    myThread.print1();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    myThread.print2();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    myThread.print3();
                }
            }
        }.start();
    }
}

class MyThread extends Thread {
    boolean b1 = true;
    boolean b2 = false;
    boolean b3 = false;

    public synchronized void print1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (b1) {
            System.out.println("我是1号线程");
        }
        b1 = false;
        b2 = true;
        notifyAll();
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void print2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (b2) {
            System.out.println("我是2号线程");
        }
        b2 = false;
        b3 = true;
        notifyAll();
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void print3() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (b3) {
            System.out.println("我是3号线程");
        }
        b3 = false;
        b1 = true;
        notifyAll();
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}