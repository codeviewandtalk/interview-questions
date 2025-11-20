package Test;

import java.util.HashMap;
import java.util.Map;

public class TestAlti {
    public static void main(String[] args) {
        String str= "piyush";
        //output p-1
        countCharacter(str);
    }

    private static void countCharacter(String str) {
        Map<Character,Integer> fre = new HashMap<>();
        for(int i= 0; i< str.length();i++){

            if(fre.containsKey(str.charAt(i))){
                fre.put(str.charAt(i),fre.get(str.charAt(i)+1));
            }else{
                fre.put(str.charAt(i),1);
            }
        }
        System.out.println(fre);
    }
}
