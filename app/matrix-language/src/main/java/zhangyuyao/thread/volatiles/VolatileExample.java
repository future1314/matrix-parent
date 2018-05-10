package zhangyuyao.thread.volatiles;

class VolatileExample {
    int x = 0;
    int b = 0;

    private void write() {
        x = 5;
        b = 1;
    }

    /**
     * 加上 volatile 栈中变量会无效，每次读取主存变量。
     * 不加volatile 每次读取的是栈中变量
     */

    private void read() {
        //int dummy = b;  
        while (x != 5) {
            System.out.println('1');
        }
    }

    public static void main(String[] args) throws Exception {
        final VolatileExample example = new VolatileExample();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                example.write();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                example.read();
            }
        });
        thread2.start();
        Thread.sleep(1000);
        thread1.start();
    }
}