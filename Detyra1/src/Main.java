import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static List<List<Integer>> per (int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        per(arr, 0,ans);
        return  ans;
    }
    private static void per(int[] arr, int k,List<List<Integer>> ans){
        for(int i = k; i < arr.length; i++){
            swap(arr, i, k);
            per(arr, k+1,ans);
            swap(arr, k, i);
        }
        if (k == arr.length -1){
            System.out.println(Arrays.toString(arr));
            ans.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        }
    }
    private static void swap(int [] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = per(new int[]{1,2,3});
    }
}
