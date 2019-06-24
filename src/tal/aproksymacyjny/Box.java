package tal.aproksymacyjny;

public class Box {

    private int id;
    private int size;

    public Box(int id, int size) {
        this.id = id;
        this.size = size;
    }

    public int getId() {
        return this.id;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "Box[id: " + id + " size: " + size + "]";
    }

    public String toStringNoId() {
        return "Box[" + size + "]";
    }
}
