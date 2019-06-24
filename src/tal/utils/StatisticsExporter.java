package tal.utils;

import tal.aproksymacyjny.Bucket;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class StatisticsExporter {

    int[] inputArray;
    List<Bucket> packedList;
    private double runTime;
    private int bucketAmount;

    private long numLoopIterations;

    File exportedFile;

    public StatisticsExporter() {

    }

    public void setInputArray(int[] inputArray){
        this.inputArray = inputArray;
    }

    public void setPackedList(List<Bucket> packedList) {
        this.packedList = packedList;
    }

    public void setRunTime(double runTime) {
        this.runTime = runTime;
    }

    public void setBucketAmount(int bucketAmount) {
        this.bucketAmount = bucketAmount;
    }

    public void setNumLoopIterations(long numLoopIterations) {
        this.numLoopIterations = numLoopIterations;
    }

    public void exportToFile() {
        StringBuilder sb = new StringBuilder();

        //sb.append(Arrays.toString(inputArray) + "\n" + packedList.toString() + "\n" + runTime + "\n" + boxAmount + "\n" + numLoopIterations);

        sb.append(inputArray.length + ";" + bucketAmount + ";" + runTime + ";" + numLoopIterations);


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("exported + " + System.currentTimeMillis() + ".csv")))) {

            bw.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
