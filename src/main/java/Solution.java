import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/1/15 9:57
 */
public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = timeSeries.length * duration;
        for(int i = 1; i<timeSeries.length ; i++){
            count -= Math.max(0,duration - (timeSeries[i] - timeSeries[i-1]));
        }
        return count;
    }

    public static void main(String[] args) {
        int[] timeSeries = {1,4};
        int duration = 2;
        System.out.println(findPoisonedDuration(timeSeries,duration));
    }

}
