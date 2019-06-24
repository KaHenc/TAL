package tal.aproksymacyjny;

import java.util.LinkedList;
import java.util.List;

public class Bucket {

    private int id;
    private int bucketSize;
    private List<Box> boxes;

    public Bucket(int id, int bucketSize) {
        if(bucketSize <= 0 || bucketSize >= 1024) bucketSize = 16;

        this.id = id;
        this.bucketSize = bucketSize;
        boxes = new LinkedList<>();
    }

    public int getId() {
        return this.id;
    }

    public int getCurrentFreeSpace() {
        int sum = 0;
        for(Box b : boxes) sum += b.getSize();
        return (bucketSize - sum);
    }

    public void addBox(Box box) {
       // if (getCurrentFreeSpace() > getCurrentFreeSpace() + box.getSize())
            this.boxes.add(box);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for(Box b: boxes) sb.append(b.toString() + ", ");

        return "Bucket [id: " + id + " Boxes[" + sb.toString() + "]";
    }

    public String toStringNoId() {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < boxes.size(); i++) {
            if (i != boxes.size() - 1) sb.append(boxes.get(i).toStringNoId() + ", ");
            else sb.append(boxes.get(i).toStringNoId());
        }

        return "Bucket [id: " + id + " Boxes[" + sb.toString() + "]";
    }
}
