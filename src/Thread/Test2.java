package Thread;


/**
 * 目的： 通过多线程同步来同时操作一个对象
 * 买火车票问题
 * 通过实现Runnable接口
 */
public class Test2 implements Runnable{

    private int  n = 10;


    @Override
    public void run()
    {
        while (n > 0) {
            try {
                //模拟延时
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + n-- + "票");
        }

    }
    //没上锁，你这个线程得到的num可能是1，可以进入循环，但是执行到一部分后cpu暂停了你这个线程的任务，去执行另一个线程，另一个线程会修改到num值，当再执行上一个线程时，你的num早就变了
    //出现-1的情况是甲线程在比较票数的时候票数为1,但乙线程已经执行完毕票数减减,所以甲线程实际上渐渐票数时时0减减,自然是-1
    //出现多线程 操作一个对象，并发问题,数据紊乱

    /**
     *
     * 解决并发问题需要用到锁lock
     * 我在Test*  解决了这个问题
     */
    public static void main(String[] args) {
        //多线程同步来同时操作一个资源， 线程不安全，数据紊乱
        Test2 t2 =  new Test2();
        new Thread(t2,"小明").start();
        new Thread(t2,"daasA").start();
        new Thread(t2,"~~~~").start();


    }
}
