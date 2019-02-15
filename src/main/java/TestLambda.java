import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/1/15 14:14
 */
public class TestLambda {

    // http://www.cnblogs.com/aoeiuv/p/5911692.html

    /**
     * lambda表达式的一般语法:
     * (Type1 param1, Type2 param2, ..., TypeN paramN) -> {
         statment1;
         statment2;
         //.............
         return statmentM;
        }
         单参数语法:
         param1 -> {
         statment1;
         statment2;
         //.............
         return statmentM;
         }
         方法引用语法：
         objectName::instanceMethod
         ClassName::staticMethod
         ClassName::instanceMethod
     */
    public void test(){
        // 单参数语法
        List<String> proNames = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        List<String> lowercaseNames1 = proNames.stream().map(name -> {return name.toLowerCase();}).collect(Collectors.toList());
        System.out.println(lowercaseNames1);
        // 单参数语法简写
        List<String> lowercaseNames2 = proNames.stream().map(name -> name.toLowerCase()).collect(Collectors.toList());
        System.out.println(lowercaseNames2);
        // 方法引用写法
        List<String> lowercaseNames3 = proNames.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(lowercaseNames3);

        //lambda表达式可使用的变量
        String waibu = "lambda :";
        List<String> proStrs = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        List<String> execStrs = proStrs.stream().map(chuandi -> {
            Long zidingyi = System.currentTimeMillis();
            return waibu + chuandi + " -----:" + zidingyi;
        }).collect(Collectors.toList());
        System.out.println(execStrs);
        execStrs.forEach(System.out::println);

        //转全小写  (在lambda中，this不是指向lambda表达式产生的那个SAM对象，而是声明它的外部对象)
        List<String> execStrs2 = proStrs.stream().map(str -> {
            System.out.println(this.getClass().getName());
            return str.toLowerCase();
        }).collect(Collectors.toList());
        execStrs2.forEach(System.out::println);
    }

    public static void main(String[] args) {
        TestLambda testLambda = new TestLambda();
        testLambda.test();
    }
}
