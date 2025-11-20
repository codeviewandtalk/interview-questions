package Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class TestJava {

    public static void main(String[] args) {
        int[] arr = {2, 10, 16, 20};

        List<Integer> list = Arrays.asList(2, 10, 16, 20);
        for (int i = 2; i <= 20; i += 2) {
            if (!list.contains(i)) {
                // System.out.println(i);
            }
        }

        IntStream.range(1, 21).filter(i -> i % 2 == 0).forEach((e) -> {
            if (!list.contains(e)) {
                System.out.println(e);
            }
        });
    }

    Map<String, Integer> map = new HashMap<String, Integer>();


    public static  String processString(String s){
        char[] str= s.toCharArray();
        StringBuffer res= new StringBuffer();
        for(int i=0; i< str.length; i++){
            if(str[i]=='#'){
                 if(res.length()>0){
                     res.deleteCharAt(res.length()-1);
                 }
            }else{
                res.append(str[i]);
            }
        }
        return res.toString();
    }

}
class Employee {
    private int id;
    private String name;
    private  double salary;
    private String dept;

    public Employee(int id, String name, double salary,String dept) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dept= dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }
}


