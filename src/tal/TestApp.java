package tal;

import tal.aproksymacyjny.Bucket;
import tal.aproksymacyjny.FirstFitPacker;
import tal.dokladny.ExactBinPacker;
import tal.utils.DataSetGenerator;
import tal.utils.StatisticsExporter;
import tal.utils.Timer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestApp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StatisticsExporter se = new StatisticsExporter();

        int bucketSize;
        int minBoxSize;
        int maxBoxSize;
        int boxAmount;
        int[] boxArray;
        String input;

        DataSetGenerator dsg = new DataSetGenerator();
        FirstFitPacker ffp = new FirstFitPacker();

        System.out.println("**********TAL - Bin Packing**********");
        System.out.println(">[0] First fit algorithm");
        System.out.println(">[1] Exact algorithm");
        System.out.println(">[2] First vs Exact\n");

        input = scan.nextLine();

        if(input.toLowerCase().trim().equals("0")) {
            System.out.print(">Bucket size [min: 1]: ");
            input = scan.nextLine();
            bucketSize = Integer.parseInt(input);

            System.out.print(">Min box size: ");
            input = scan.nextLine();
            minBoxSize = Integer.parseInt(input);

            System.out.print(">Max box size: ");
            input = scan.nextLine();
            maxBoxSize = Integer.parseInt(input);

            System.out.print(">Box amount: ");
            input = scan.nextLine();
            boxAmount = Integer.parseInt(input);

            boxArray = dsg.generateRandomIntegerArray(minBoxSize, maxBoxSize, boxAmount);
            System.out.print(">Generated boxes to pack: " + Arrays.toString(boxArray) + "\n");

            ffp.setBucketSize(bucketSize);
            ffp.setInputBoxes(boxArray);
            List<Bucket> packedBuckets = ffp.getPackedBuckets();

            System.out.println("--------------");
            System.out.println(">Packed boxes:");

            for(Bucket b : packedBuckets) System.out.println(b.toStringNoId());

            System.out.println("--------------");
            System.out.println(">Statistics:");
            System.out.println(">Duration [s]: " + ffp.getLastRunDuration());
            System.out.println(">Buckets: " + ffp.getLastRunNumBuckets());
            System.out.println(">Loop iterations: " + ffp.getLastNumLoopIterations());

            se.setInputArray(boxArray);
            se.setPackedList(packedBuckets);
            se.setRunTime(ffp.getLastRunDuration());
            se.setBucketAmount(ffp.getLastRunNumBuckets());
            se.setNumLoopIterations(ffp.getLastNumLoopIterations());

            se.exportToFile();
        }
        else if (input.toLowerCase().trim().equals("1")) {
            System.out.print(">Bucket size [min: 1]: ");
            input = scan.nextLine();
            bucketSize = Integer.parseInt(input);

            System.out.print(">Min box size: ");
            input = scan.nextLine();
            minBoxSize = Integer.parseInt(input);

            System.out.print(">Max box size: ");
            input = scan.nextLine();
            maxBoxSize = Integer.parseInt(input);

            System.out.print(">Box amount: ");
            input = scan.nextLine();
            boxAmount = Integer.parseInt(input);

            boxArray = dsg.generateRandomIntegerArray(minBoxSize, maxBoxSize, boxAmount);
            System.out.print(">Generated boxes to pack: " + Arrays.toString(boxArray) + "\n");

            List<Integer> intList = new ArrayList<Integer>();
            for (int i : boxArray) intList.add(i);

            ExactBinPacker exactBinPacker = new ExactBinPacker(intList, bucketSize);

            Timer exactTimer = new Timer();
            exactTimer.start();
            int numBuckets = exactBinPacker.getResult();
            exactBinPacker.printBestBins();
            exactTimer.stop();

            System.out.println("--------------");
            System.out.println(">Statistics:");
            System.out.println(">Duration [s]: " + exactTimer.getDurationSecs());
            System.out.println(">Buckets: " + numBuckets);
            System.out.println(">Loop iterations: " + exactBinPacker.getNumLoopIterations());

            se.setInputArray(boxArray);
            se.setRunTime(exactTimer.getDurationSecs());
            se.setBucketAmount(numBuckets);
            se.setNumLoopIterations(exactBinPacker.getNumLoopIterations());

            se.exportToFile();
        }
        else if (input.toLowerCase().trim().equals("2")) {
            System.out.print(">Bucket size [min: 1]: ");
            input = scan.nextLine();
            bucketSize = Integer.parseInt(input);

            System.out.print(">Min box size: ");
            input = scan.nextLine();
            minBoxSize = Integer.parseInt(input);

            System.out.print(">Max box size: ");
            input = scan.nextLine();
            maxBoxSize = Integer.parseInt(input);

            System.out.print(">Box amount: ");
            input = scan.nextLine();
            boxAmount = Integer.parseInt(input);

            boxArray = dsg.generateRandomIntegerArray(minBoxSize, maxBoxSize, boxAmount);
            System.out.print(">Generated boxes to pack: " + Arrays.toString(boxArray) + "\n");


            //First Fit
            ffp.setBucketSize(bucketSize);
            ffp.setInputBoxes(boxArray);
            List<Bucket> packedBuckets = ffp.getPackedBuckets();

            System.out.println("--------------");
            System.out.println(">Packed boxes:");

            for(Bucket b : packedBuckets) System.out.println(b.toStringNoId());

            //Exact
            List<Integer> intList = new ArrayList<Integer>();
            for (int i : boxArray) intList.add(i);

            ExactBinPacker exactBinPacker = new ExactBinPacker(intList, bucketSize);

            Timer exactTimer = new Timer();
            exactTimer.start();
            int numBuckets = exactBinPacker.getResult();
            exactBinPacker.printBestBins();
            exactTimer.stop();

            System.out.println("--------------");
            System.out.println(">Statistics [FIRST FIT]:");
            System.out.println(">Duration [s]: " + ffp.getLastRunDuration());
            System.out.println(">Buckets: " + ffp.getLastRunNumBuckets());
            System.out.println(">Loop iterations: " + ffp.getLastNumLoopIterations());

            System.out.println("--------------");
            System.out.println(">Statistics [EXACT]:");
            System.out.println(">Duration [s]: " + exactTimer.getDurationSecs());
            System.out.println(">Buckets: " + numBuckets);
            System.out.println(">Loop iterations: " + exactBinPacker.getNumLoopIterations());
        }
    }
}
