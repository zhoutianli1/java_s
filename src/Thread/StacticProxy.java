package Thread;

public class StacticProxy
{
    //主函数调用 婚庆公司的帮助结婚
    public static void main(String[] args) {
        new HunQinGongSi(new Person()).HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

//真实角色，真正结婚的对象
class Person implements Marry
{
    @Override
    public void HappyMarry() {
        System.out.println("战神要结婚了");
    }
}

//代理角色，帮助对象结婚
class HunQinGongSi implements Marry
{

    private Marry target;
    public HunQinGongSi(Marry target){
        this.target=target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void before() {
        System.out.println("结婚前准备离婚材料");
    }

    private void after() {
        System.out.println("结婚后准备离婚");
    }
}
