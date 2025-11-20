package dsa;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8IntStreamPart3Questions {
    public static void main(String[] args) {
        //1."Write a program to print numbers from 1 to 10 using Stream API without using loops."
        IntStream.rangeClosed(1, 10)
                .forEach(System.out::println);

//2."Using Stream API, find the sum of numbers from 1 to 100."
        int sum = IntStream.rangeClosed(1, 100)
                .sum();
        System.out.println(sum);
//3. Find the average of numbers between 1 and 50.
        OptionalDouble avg = IntStream.rangeClosed(1, 50)
                .average();
        System.out.println(avg.orElse(0));
        //4."Print all even numbers between 1 and 20 using Stream API."
        IntStream.rangeClosed(1, 20)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
//5.Find the sum of all even numbers between 1 and 100.
        int sums = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0)
                .sum();
        System.out.println(sums);

        //6."Find the factorial of a given number using Stream API."
        int n = 5;
        int factorial = IntStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
        System.out.println(factorial);
//7. Count numbers divisible by 5 between 1 and 50.
        long count = IntStream.rangeClosed(1, 50)
                .filter(p -> p % 5 == 0)
                .count();
        System.out.println(count);
//8. Create a list of squares of numbers from 1 to 10.
        List<Integer> squares = IntStream.rangeClosed(1, 10)
                .map(q -> q * q)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(squares);
//9.Find the maximum number in a range.
        int max = IntStream.rangeClosed(1, 100)
                .max()
                .orElse(-1);
        System.out.println(max);
//10.Print the first 5 odd numbers starting from 1.
        IntStream.iterate(1, w -> w + 2)
                .limit(5)
                .forEach(System.out::println);

        //11.Check if all numbers in a range are positive.
        boolean allPositive = IntStream.rangeClosed(-5, 5)
                .allMatch(f -> f > 0);
        System.out.println(allPositive); // false
//12.Find the first number divisible by 7 in the range 1 to 50.
        OptionalInt first = IntStream.rangeClosed(1, 50)
                .filter(m -> m % 7 == 0)
                .findFirst();
        System.out.println(first.orElse(-1));

//13. Generate a range of random numbers (10 numbers between 1 and 100).
        new Random()
                .ints(10, 1, 101)
                .forEach(System.out::println);
//14.Sum of squares of even numbers between 1 and 10.
        int sumSquares = IntStream.rangeClosed(1, 10)
                .filter(i -> i % 2 == 0)
                .map(j -> j * j)
                .sum();
        System.out.println(sumSquares);

// Advamced Questions
        //15.1. Find all prime numbers in a given range (1 to 50).
        List<Integer> primes = IntStream.rangeClosed(2, 50)
                .filter(k -> IntStream.rangeClosed(2, (int) Math.sqrt(k))
                        .allMatch(div -> k % div != 0))
                .boxed()
                .collect(Collectors.toList());

        System.out.println(primes);
//16. Find the second largest number in a given range.
        int secondLargest = IntStream.rangeClosed(1, 100)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();
        System.out.println(secondLargest);
//17. Find the sum of squares of numbers divisible by 3 in a range.
        int sumSqrt = IntStream.rangeClosed(1, 30)
                .filter(s -> s % 3 == 0)
                .map(t -> t * t)
                .sum();
        System.out.println(sumSqrt);

        //18. Find the missing number in a range (1 to N).
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9, 10);
        int l = 10;
        int missing = IntStream.rangeClosed(1, l)
                .sum() - numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(missing);

//19.Check if a range contains any palindrome numbers.
        boolean hasPalindrome = IntStream.rangeClosed(10, 200)
                .anyMatch(num -> new StringBuilder(String.valueOf(num))
                        .reverse().toString()
                        .equals(String.valueOf(num)));
        System.out.println(hasPalindrome);
//20.Find the first 3 numbers greater than 50 that are divisible by 7.
        List<Integer> result = IntStream.rangeClosed(1, 100)
                .filter(r -> r > 50 && r % 7 == 0)
                .limit(3)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(result);
//21. Find the GCD (Greatest Common Divisor) of two numbers using Stream API.
        int gcd = IntStream.rangeClosed(1, Math.min(18, 24))
                .filter(i -> 18 % i == 0 && 24 % i == 0)
                .max()
                .orElseThrow();
        System.out.println(gcd);
//22.Generate all Pythagorean triplets within 1 to 30.
        List<int[]> triplets = IntStream.rangeClosed(1, 30)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 30)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                        .filter(arr -> arr[2] <= 30 && arr[2] * arr[2] == arr[0] * arr[0] + arr[1] * arr[1])
                )
                .collect(Collectors.toList());

        triplets.forEach(t -> System.out.println(Arrays.toString(t)));
//23.Check if all numbers in a range are unique squares.
        boolean allUnique = IntStream.rangeClosed(1, 5)
                .map(u -> u * u)
                .boxed()
                .collect(Collectors.toSet())
                .size() == 5;
        System.out.println(allUnique);
//24.Find the K-th smallest number from a range.
        int kth = IntStream.rangeClosed(10, 50)
                .filter(v -> v % 6 == 0)
                .sorted()
                .skip(3)   // 4th element (0-based index)
                .findFirst()
                .orElseThrow();
        System.out.println(kth);

    }
}
