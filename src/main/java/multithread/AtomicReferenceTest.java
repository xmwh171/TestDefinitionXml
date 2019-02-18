package multithread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description 引用类型原子类 AtomicReference
 * @Author xiaohu
 * @Date 2019/2/18 12:42
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        AtomicReference<Person> ar = new AtomicReference<Person>();
        Person person = new Person("SnailClimb", 22);
        ar.set(person);
        Person updatePerson = new Person("Daisy", 20);
        ar.compareAndSet(person, updatePerson);

        System.out.println(ar.get().getName());
        System.out.println(ar.get().getAge());
    }
}
