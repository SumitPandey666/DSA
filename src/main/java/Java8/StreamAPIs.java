package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIs {
    public static void main(String args[]){
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        double totalSum = nums.stream()
                .mapToDouble(Integer :: doubleValue)
                .sum();

        System.out.println("total sum is:  "+totalSum);

        double sumOfEvenNumbers = nums.stream()
                .filter(n -> n%2 == 0)
                .mapToDouble(Integer :: doubleValue)
                .sum();

        System.out.println("even numbers total sum is:  "+sumOfEvenNumbers);

        double sumOfOddNumbers = nums.stream()
                .filter(n -> n%2 != 0)
                .mapToDouble(Integer :: doubleValue)
                .sum();

        System.out.println("odd numbers total sum is:  "+sumOfOddNumbers);

        List<Integer> mapNumsToSquares = nums.stream()
                .map(n -> n*n)
                .collect(Collectors.toList());

        System.out.println("square list is:  "+mapNumsToSquares);

        List<Double> squareRootOfNums = nums.stream()
                .map(Math::sqrt)
                .collect(Collectors.toList());

        System.out.println("square root list is: " + squareRootOfNums);


    }
}
