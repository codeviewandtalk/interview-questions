package dsa;

import java.util.ArrayList;
import java.util.List;

public class FlattenArray {
    public static void main(String[] args) {
        Object[] arr= {1,2,new Object[]{3,4 ,new Object[]{5,6},7,8,9}};

        List<Integer> result= flattenArray(arr);
        System.out.println(result);
    }

    private static List<Integer> flattenArray(Object[] arr) {
        List<Integer> result= new ArrayList<>();

        for(Object element:arr){
            if(element instanceof Object[]){
                result.addAll(flattenArray((Object[]) element));
            }else{
                result.add((Integer) element);
            }
        }
        return result;
    }
}
