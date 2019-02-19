package multithread;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/2/18 18:41
 */
public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton(){}

    public static Singleton getUniqueInstance(){
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if(uniqueInstance == null){
            //类对象加锁
            synchronized (Singleton.class){
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
