package tal.aproksymacyjny;

import tal.utils.DataSetGenerator;

import java.util.Arrays;
import java.util.List;

public class FFTest {

    public static void main(String[] args) {

        //-----------------------------------------------------------------------\\
        //Using the DataSetGenerator to obtain a random array of integers to pack
        //-----------------------------------------------------------------------\\

//        DataSetGenerator dsg = new DataSetGenerator();
//        int[] arr = dsg.generateRandomIntegerArray(1, 10,20);
//
//        System.out.println("Generated array:");
//        for(int i = 0; i < arr.length; i++) System.out.print(arr[i] + ", ");
//
//        System.out.println();

        //-----------------------------------------------------------------------\\
        //Using the FirstFitPacker to pack an array of integers
        //-----------------------------------------------------------------------\\
        FirstFitPacker ffp = new FirstFitPacker();

        int[] inputBoxes0 = {1, 3, 2, 7, 10,  4, 6, 2, 1};
        int[] inputBoxes1 = {4, 9, 4, 2, 10, 10, 3, 1, 10, 9};
        int[] inputBoxes2 = {10, 9, 7, 4, 6, 2, 1, 10, 8, 6};
        int[] inputBoxes3 = {1, 3, 2, 7, 10, 4, 6, 2, 1};
        int[] inputBoxes4 = {7, 10, 8, 5, 3, 2, 2, 2, 9, 9};
        int[] inputBoxes5 = {1, 2, 2, 4, 1, 7, 6, 8, 2, 8};
        int[] inputBoxes6 = {4, 2, 4, 8, 8, 3, 1, 3, 1, 2};
        int[] inputBoxes7 = {9, 2, 1, 10, 8, 6, 9, 1, 4, 3};
        int[] inputBoxes8 = {7, 9, 3, 8, 10, 4, 5, 10, 9, 9};
        int[] inputBoxes9 = {3, 4, 4, 8, 7, 8, 9, 9, 6, 3};
        int[] inputBoxes10 = {3, 1, 1, 3, 4, 4, 5, 7, 3, 4, 8, 8, 1, 7, 7, 1, 3, 10, 5, 4};
        int[] inputBoxes11 = {1, 8, 10, 10, 10, 7, 2, 3, 2, 1, 4, 1, 1, 7, 8, 8, 6, 5, 8, 9};
        int[] inputBoxes12 = {9, 3, 5, 7, 1, 3, 1, 8, 6, 3, 9, 4, 2, 10, 8, 4, 9, 1, 4, 1};
        int[] inputBoxes13 = {8, 8, 5, 5, 3, 4, 4, 10, 6, 3, 4, 2, 1, 2, 4, 5, 1, 5, 10, 3};
        int[] inputBoxes14 = {5, 4, 10, 2, 5, 6, 2, 6, 2, 3, 1, 4, 3, 9, 10, 1, 9, 1, 8, 8};
        int[] inputBoxes15 = {5, 7, 4, 1, 9, 2, 9, 3, 3, 2, 10, 10, 9, 1, 10, 9, 10, 4, 9, 6};
        int[] inputBoxes16 = {7, 2, 7, 5, 7, 8, 6, 8, 9, 7, 6, 2, 3, 6, 2, 8, 5, 3, 1, 6};
        int[] inputBoxes17 = {4, 6, 10, 1, 2, 5, 7, 1, 6, 1, 8, 5, 3, 3, 3, 6, 2, 10, 5, 7};
        int[] inputBoxes18 = {8, 4, 7, 9, 2, 10, 3, 6, 3, 10, 6, 3, 10, 7, 8, 5, 8, 4, 3, 10};
        int[] inputBoxes19 = {8, 1, 1, 7, 8, 10, 2, 3, 6, 5, 1, 3, 5, 10, 1, 4, 1, 8, 4, 8};



                ffp.setBucketSize(10);
                ffp.setInputBoxes(inputBoxes16);

                List<Bucket> packedBuckets = ffp.getPackedBuckets();

                System.out.println("Data to pack: " + Arrays.toString(inputBoxes16) + "\n");

                for(Bucket b : packedBuckets) System.out.println(b.toStringNoId());

    }

}
