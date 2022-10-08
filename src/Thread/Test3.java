package Thread;
//java狂神，线程，的课程 ，p6
import java.util.TreeMap;

/**
 *龟兔赛跑问题
 *通过 sleep（）延时 来模拟 兔子睡觉
 */
public class Test3 implements Runnable
{
    private static String Winner;  //静态变量被实列共享 ，final是常量不能修改，所以不能用final修饰
    @Override
    public void run()
    {


        for (int i = 1; i <= 100; i++)    //快捷键 100.fori
        {
            //模拟兔子每10步休息
            if(Thread.currentThread().getName().equals("兔子")&&i%10==0)
            {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag = over(i);
            if (flag)
            {
                break;
            }
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");   //快捷键sout
        }

    }

    //判断比赛是否结束
    private boolean over(int steps)
    {
        //判断是否有胜利者
        if(Winner!=null)
        {
            return true;
        }
        else
        {
            if(steps==100)  //先走完100步的为胜利者
            {
                Winner = Thread.currentThread().getName();
                System.out.println("winner is" +Winner);
                return true;
            }
            else{}
        }
        return false;
    }

    public static void main(String[] args) {
        //线程实现方式2：通过实现Runnable接口，实现run方法，接口的实现类的实例作为Thread的target作为参数传入带参的Thread构造函数，通过调用start()方法启动线程
        //共享一条 路，在路上跑0
        Test3 test3=new Test3();
        new Thread(test3,"兔子").start();
        new Thread(test3,"乌龟").start();
    }
}
