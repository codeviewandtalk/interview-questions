package outputs;


import javax.swing.text.AsyncBoxView;
class Parent {
    Parent() {
        this("Constructor");
        System.out.println("Parent Class Default Constructor");
    }
    Parent(String s){
        System.out.println("Parent Class Param " + s);
    }
}

class Child extends Parent{
    Child() {
        this("Constructor");
        System.out.println("Child Class Default Constructor");
    }
    Child(String s){
        System.out.println("Child Class Param " + s);
    }
}


public class Test {

    //Find and element in a matrix where rows and columns are sorted in ascending order.
    //System design lld and employee polling system design. Find intersection poin of a linked list.
    //word count question, dictionary problem
    //what is Singleton write the code of Singleton
    //Magic Square problem
    //Design a code repo system? Java Core concepts Database optimizations
    //Design Patterns
    //How do u count all nodes in the tree
    //K - Rotate a word. e.g ABCDEF when 3-rotated will become DEFABC
    //SOLID design principles in software engineering
    //Describe how you would build bit.ly
    //Key Differences Between map and flatMap
    //In system design I was asked to design a caching system
    //Longest Increasing subsequence: leetcode medium
    //One coding question on array - move all negative numbers to left & all positives to the right keeping the order same.
    //Given a random two dimensional array with several locations marked as non-tranversable determine the the shortest path between two random nodes.
    //Dsh questions regarding binary search and palindrome
    //Gas station( Greedy) leetcode and dp question
    //Fundamental backend questions 3 coding questions easy, medium, hard design an architecture that can handle 5000 requests per day but expected to get 10000 requests per day
    //api design around dependency injection
    //Write functions for a snake and ladder game.
    //2 persons are teamed up to complete n tasks. Each task is to be completed by either of the 2 persons. Both the persons have their reward points defined, where the 1st person gains reward_1[i] for completing ith task, and the 2nd person gains reward_2[i] points for completing ith task. Find the maximum combined reward points that can be gained if the first person has to complete k tasks and the 2nd person has to complete the remaining tasks.
    //string reverse algo and minimum sum
    //Return substring with Palindrome in a string array
    //spiral matrix, tree level avg, graph based.
    //Implement logger which is thread safe
    //Find Linked list is palindrome or not,
    //design a file system
    //flood fill
    //Implement hashmap Load balancer Find the distance of 2 leave node in a tree
    //
    public static void main(String[] args) {
    Child child= new Child();   
    }

}
