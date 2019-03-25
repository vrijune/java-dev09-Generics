package ictgradschool.industry.collections.ex03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExerciseThree_Lists {

    /**
     * Tests the union, intersection, and difference methods using some dummy data.
     *
     * You shouldn't need to edit this class, other than to uncomment two lines once you've implemented those methods.
     */
    private void start() {

        // Tip: You can make hardcoded lists in one lin like this! HOWEVER! If you try to add() extra items to these
        // lists, it will fail.
        // See: https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#asList-T...-
        List<String> testList1 = Arrays.asList("A", "B", "C");
        List<String> testList2 = Arrays.asList("A", "D", "E");

        // Should print [A, B, C, A, D, E]
        // Note #1: Arrays.toString() returns a nice String representation of any array for us to print.
        // Note #2: List.toArray() will return an Object[] array containing all the elements in our list.
        System.out.println(Arrays.toString(union(testList1, testList2).toArray()));

        // Should print [A]
        // TODO Uncomment this line once you've completed the intersection method
        // System.out.println(Arrays.toString(intersection(testList1, testList2).toArray()));

        // Should print [B, C]
        // TODO Uncomment this line once you've completed the difference method
        // System.out.println(Arrays.toString(difference(testList1, testList2).toArray()));

    }


    /**
     * Returns a list that contains all elements in the first list plus all elements in the second list.
     *
     * @param list1 the first list
     * @param list2 the second list
     * @return the result list
     */
    private List<String> union(List<String> list1, List<String> list2) {

        List<String> result = new ArrayList<>();

        // TODO Add all items from list1 and list2 to the result

        return result;

    }

    // TODO Write an intersection method


    // TODO Write a difference method


    /**
     * Program entry point. Do not edit.
     */

    public static void main(String[] args) {
        new ExerciseThree_Lists().start();
    }

}
