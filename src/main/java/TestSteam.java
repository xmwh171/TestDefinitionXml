import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/1/15 13:48
 */
public class TestSteam {

    // https://www.cnblogs.com/zxf330301/p/6586750.html

    public static int test(List<String> wordList){
        int countByIterator = 0;
        for (String word: wordList) {
            if (word.length() > 7) {
                countByIterator++;
            }
        }
        return countByIterator;
    }

    public static long testFilter(List<String> wordList){
        long countByStream = wordList.stream().filter(a->a.length()>7).filter(a->a.length()<10).count();
        return countByStream;
    }

    public static List<String> testCollect(List<String> wordList){
        List<String> list = wordList.stream().filter(a->a.length()>7).collect(Collectors.toList());
        return list;
    }

    public static void testCreateStream(){
        // of方法
        Stream.of("1");
        Stream.of("1","2");
        // generator方法
        Stream.generate(() -> Math.random());
        // iterate方法
        Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);
        // 通过Collection子类获取Stream
        Arrays.asList("Java", "Python", "Swift", "HTML").stream();
    }

    public static void testConvertStream(List<String> wordList){


        // filter 过滤
        long countByStream = wordList.stream().filter(a->a.length()>7).filter(a->a.length()<10).count();

    }

    public static Stream<String> testMap(){
        List<String> langList = Arrays.asList("Java", "Python", "Swift", "HTML");
        Stream<String> mapStream = langList.stream().map(String::toUpperCase).limit(10);
        return mapStream;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("regular", "expression", "specified", "as", "a", "string", "must");
        System.out.println(test(wordList));
        System.out.println(testFilter(wordList));
        System.out.println(testCollect(wordList));
        testMap().forEach(System.out::println);
    }

}
