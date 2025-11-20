package dsa;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8StreamPart1Questions {
    public static void main(String[] args) {


//          1.Given a list of integers, find out all the even numbers that exist in the list using Stream?
//          2.Given a list of integers, find out all the numbers starting with 1 using Stream ?
//          3.How to find duplicate elements in a given integers list in java using Stream ?
//          4.Given the list of integers, find the first element of the list using Stream ?
//          5.How to remove duplicates from a list while preserving the order using Java streams?
//          6.Given a list of integers, find the maximum value element present in it using Stream ?
//          7.Given a list of integers, sort all the values present in it using Stream ?
//          8.Given a list of integers, sort all the values present in it in descending order using Stream ?
//          9.Java 8 program to perform cube on list elements and filter numbers greater than 50 ?
//          10.Find the kth smallest element in an array using java streams ?
//          11.Given a String, find the first non - repeated character in it using Stream ?
//          12.Given a String, find the first repeated character in it using Stream ?
//          13.How to find frequency from the String list in Java8 ?
//          14.How to find only duplicate elements with its count from the String ArrayList in Java8 ?
//          15.Find the longest string in a list of strings using Java streams?


        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);



      //  list.stream().filter(n->n%2==0).forEach(System.out::println);

      List<String> startWithOneList = list.stream().map(n-> n + " ").filter(num -> num.startsWith("1")).collect(Collectors.toList());
       // System.out.println(startWithOneList);

        Set<Integer> set = new HashSet<>();

       // list.stream().filter(n->!set.add(n)).forEach(System.out::println);

       // list.stream().findFirst().ifPresent(System.out::println);


       List<Integer> uniqueNumbert =list.stream().distinct().collect(Collectors.toList());

        System.out.println(uniqueNumbert);

        int max = list.stream().max((a,b)->a.compareTo(b)).get();
        System.out.println("Max value = "+ max);

       List<Integer> sortedList =   list.stream().sorted().collect(Collectors.toList());

        System.out.println("Sorted List " + sortedList);

        List<Integer> sortedListDesc= list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println(" Desc Sorted List " + sortedListDesc);

        list.stream().map(n->n*n*n).filter(i->i>50).forEach(System.out::println);

        int[] array = {4,2,7,1,5,3,6};
        int k=3;
        int kthSmallest = Arrays.stream(array).sorted().skip(k-1).findFirst().orElse(-1);
        System.out.println("Kth Smallest Element= " + kthSmallest);

        String inputString= "Java articles are Awesome";

        Character result=  inputString.chars().
                mapToObj(s->Character.toLowerCase(Character.valueOf((char) s )))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry->entry.getValue()==1)
                .map(ent->ent.getKey())
                .findFirst()
                .get();

        System.out.println("result= "+ result);

        Character result1=  inputString.chars().
                mapToObj(s->Character.toLowerCase(Character.valueOf((char) s )))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry->entry.getValue()>1)
                .map(ent->ent.getKey())
                .findFirst()
                .get();

        System.out.println("result1= "+ result1);

        List<String> charList= Arrays.asList("AA","BB","AA","CC");

       Map<String,Long> frequencyCount =charList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println("Frequency Count " + frequencyCount);

        Map<String,Long> duplicateElement =charList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry->entry.getValue()>1)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        System.out.println("Duplicate Elemnets "+ duplicateElement);

        List<String> strList= List.of("apple","banana","cherry","date","orange" ,"jackfruit");

        Optional<String> longestString =strList.stream().max(Comparator.comparingInt(String::length));
        String longestStringNew = strList.stream().max((a,b)->a.length()-b.length()).get();

        System.out.println( "Longest String " + longestStringNew);
        System.out.println( "Longest String " + longestString.get());

    }
}
