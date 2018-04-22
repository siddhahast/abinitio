package root.sid.linkedlist;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;


/**
 * Created by siddhahast on 24/8/16.
 */
public class MyUtils {

    /**
     * API for minimum element of an array
     * @param arr
     * @return
     */
    public static int getMinElementArray(int[] arr){
        int i = 0;
        int temp = arr[i];
        while(i<arr.length){
            if(arr[i]<=temp){
                temp = arr[i];
            }
        }
        return temp;
    }

    public static int getIndexMinElementArray(int [] arr){
        int i =0;
        int temp = i;
        while(i<arr.length){
            if(arr[i]<=arr[temp]){
                temp = i;
            }
        }
        return temp;
    }

    /**
     * API to find the factorial of a number
     * @param n
     * @return
     */
    public static int factorial(int n){
        if(n==0 || n==1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }

    public static int fibonacci(int n){
        return 0;
    }

    /**
     *
     * @param arr
     * @return
     */
    public static Map<String, Integer> getMaxMin(int[] arr){
        Map<String, Integer> map = new HashMap<String, Integer>();
        return printMaxMin(arr, 0, arr.length-1, map);
    }

    private static Map<String,Integer> printMaxMin(int[] arr, int i, int j, Map<String, Integer> map){
        if(i==j){
            map.put("min",arr[i]);
            map.put("max",arr[i]);
            return map;
        } else if(j-i==1){
            if(arr[i]<arr[j]){
                map.put("min",arr[i]);
                map.put("max",arr[j]);
            }else{
                map.put("min",arr[j]);
                map.put("max",arr[i]);
            }
            return map;
        }else{
            int mid = (i+j)/2;
            Map<String, Integer> left = new HashMap<String, Integer>();
            left = printMaxMin(arr, i, mid, left);
            Map<String, Integer> right = new HashMap<String, Integer>();
            right = printMaxMin(arr, mid+1, j, right);
            Map<String,Integer> m = new HashMap<String, Integer>();
            if(left.get("min")<right.get("min")){
                m.put("min",left.get("min"));
            }else{
                m.put("min",right.get("min"));
            }
            if(left.get("max")<right.get("max")){
                m.put("max", right.get("max"));
            }else{
                m.put("max", left.get("max"));
            }
            return m;
        }
    }



}
