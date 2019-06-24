package tal.dokladny;

import java.util.ArrayList;
import java.util.List;

public class Bin {

    protected int binSize;  //rozmiar pudelka

    protected int currentSize;  //wypelnienie

    protected List<Integer> items;  //przedmioty w pudelku


    public Bin(int size) {
        this.binSize = size;
        this.currentSize = 0;
        this.items = new ArrayList<Integer>();
    }

    public boolean put(Integer item) {
        if (currentSize + item <= binSize) {    //warunek czy sie miesci
            items.add(item);
            currentSize += item;
            return true;    //miesci sie
        } else {
            return false; // //nie miesci sie
        }
    }

    public void remove(Integer item) {  //usuwanie z pudelka
        items.remove(item);
        currentSize -= item;
    }


    public int numberOfItems() {
        return items.size();
    }   //ile przedmiotow w pudelku


    public Bin deepCopy() {
        Bin copy = new Bin(0);
        copy.items = new ArrayList<Integer>(items);
        copy.currentSize = currentSize;
        copy.binSize = binSize;
        return copy;
    }

    @Override
    public String toString() {
        String binString = "Wypelnienie: " + currentSize + "(" + binSize + ")    Przedmioty:";
        for (int i = 0; i < items.size(); i++) {
            binString += " " + items.get(i);
        }
        return binString;
    }
}
