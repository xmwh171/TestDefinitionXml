import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/1/15 12:51
 */
public class MapSum {

    private Map<String,Integer> result;

    public MapSum() {
        this.result= new HashMap();
    }

    public void insert(String key, int val) {
        result.put(key,val);
    }

    public int sum(final String prefix) {

        return result.entrySet().stream().filter(e -> e.getKey().startsWith(prefix)).mapToInt(e -> e.getValue()).sum();
//        int sum = 0;
//        for(Map.Entry<String,Integer> entry : result.entrySet()){
//            if(entry.getKey().startsWith(prefix)){
//                sum += entry.getValue();
//            }
//        }
//        return sum;
    }

    public static void main(String[] args) {
        MapSum obj = new MapSum();
        obj.insert("apple",3);
        obj.insert("app",2);
        int param_2 = obj.sum("ap");
        System.out.println(param_2);
    }
}
