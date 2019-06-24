package tal.aproksymacyjny;

import tal.utils.Timer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FirstFitPacker {

    private class LastRunStatistics {
        public double lastRunTimeSecs;
        public int numCreatedBuckets;
        public long numLoopIterations;
        //public double
    }

    private int bucketSize;
    private List<Box> inputBoxes;
    private List<Bucket> buckets;
    private Timer timer;
    private LastRunStatistics lastRunStatistics;

    public FirstFitPacker() {
        buckets = new LinkedList<Bucket>();
        timer = new Timer();
        lastRunStatistics = new LastRunStatistics();
    }

    public int getBucketSize() {
        return this.bucketSize;
    }

    public void setBucketSize(int bucketSize) {
        this.bucketSize = bucketSize;
    }

    public void setInputBoxes(int[] inputBoxes) {
        this.inputBoxes = new ArrayList<Box>();

        for(int i = 0; i < inputBoxes.length; i++) {
            this.inputBoxes.add(new Box(i, inputBoxes[i]));
        }
    }

    public List<Box> getInputBoxes() {
        return this.inputBoxes;
    }

    public int getLastRunNumBuckets() {
        return this.lastRunStatistics.numCreatedBuckets;
    }

    public Double getLastRunDuration() {
        return this.lastRunStatistics.lastRunTimeSecs;
    }

    public long getLastNumLoopIterations() {
        return this.lastRunStatistics.numLoopIterations;
    }

    public List<Bucket> getPackedBuckets() {
        timer.start();

        buckets.add(new Bucket(0, bucketSize));
        boolean packed = false;
        int bucketIterator = 0;
        int numIterations = 0;

        for(Box box : inputBoxes) {
            packed = false;
            bucketIterator = 0;

            while(!packed) {
                Bucket curBucket = buckets.get(bucketIterator);

                if(curBucket.getCurrentFreeSpace() >= box.getSize()) {
                    curBucket.addBox(box);
                    packed = true;
                }
                else {
                    if(bucketIterator == buckets.size() - 1) {
                        Bucket newBucket = new Bucket(buckets.get(bucketIterator).getId() + 1, bucketSize);
                        newBucket.addBox(box);
                        buckets.add(newBucket);
                        packed = true;
                        bucketIterator = 0;
                    }
                    else bucketIterator++;
                }

                numIterations++;    //Merely for statistics
            }
        }

        timer.stop();

        lastRunStatistics.numCreatedBuckets = buckets.size();
        lastRunStatistics.lastRunTimeSecs = timer.getDurationSecs();
        lastRunStatistics.numLoopIterations = numIterations;

        return buckets;
    }
}
