package tal.dokladny;

import java.util.ArrayList;
import java.util.List;

public class ExactBinPacker {

    private List<Bin> bins = new ArrayList<Bin>();  //lista pudelek
    private int currentBestSolution;    //ilosc pudelek dotychczas najlepszego rozwiazania
    private List<Bin> currentBestBins;  //lista pudelek dotychczas najlepszego rozwiazania
    private int lowerBound;
    private int allBins = 0;
    private double itemsWeight = 0;
    private long statNumLoopIterations = 0;

    protected List<Integer> in; //przedmioty do zapakowania

    public ExactBinPacker(List<Integer> in, int binSize) {
        this.in = in;
        this.currentBestBins = new ArrayList<Bin>();
        for (Integer item : in) {   //dla kazdego przedmiotu do zapakowania tworzy pudelko
            bins.add(new Bin(binSize));
            allBins++;
            itemsWeight += item.intValue();
        }
        currentBestSolution = in.size();    //rozwiazanie najgorszego przypadku

        lowerBound = (int) Math.ceil(itemsWeight / binSize);
        System.out.println("LB = " + lowerBound);
    }


    public int getResult() {
        bruteforce(in, 0);

        return currentBestSolution;
    }

    public int getAllBins() {
        return allBins;
    }

    private void bruteforce(List<Integer> in, int currentPosition) {    //przedmioty do zapakowania, pozycja w liscie przedmiotow
        if (currentPosition >= in.size()) { //ostatni przedmiot w liscie
            int filledBins = countFilledBins();
            allBins += filledBins;
            if (filledBins < currentBestSolution) { // czy rozwiazanie lepsze od dotychczasowego
                currentBestSolution = filledBins;
                currentBestBins = deepCopy(bins);
                System.out.println("AAA = " + currentBestBins.size());
            }
            return;
        }
        Integer currentItem = in.get(currentPosition);
        for (Bin bin : bins) {  //przejscie po pudelkach
            statNumLoopIterations++;
            if (bin.put(currentItem))  //true jesli zapakowany, false jesli nie
                if ( lowerBound < currentBestSolution)    //dolne ograniczenie
                    {
                        bruteforce(in, currentPosition + 1);
                        bin.remove(currentItem);
                    }

        }
    }

    public long getNumLoopIterations() {
        return this.statNumLoopIterations;
    }

    public int countFilledBins() {     //zlicza niepuste pudelka
        int filledBins = 0;
        for (Bin bin : bins) {
            if (bin.numberOfItems() != 0) {
                filledBins++;
            }
        }
        return filledBins;
    }


    public void printBestBins() {   //drukuje najlepsze rozwiazanie
        int i = 1;
        if (currentBestSolution == in.size()) {
            System.out.println("Każdy przedmiot w oddzielnym pudełku");
        } else {
            for (Bin currentBin : currentBestBins) {
                if (currentBin.numberOfItems() != 0) { // nie drukuj pustych pudelek
                    System.out.println("Pudełko nr " + i + "    " + currentBin.toString());
                    i++;
                }
            }
        }
    }

    public List<Bin> deepCopy(List<Bin> bins) {
        ArrayList<Bin> copy = new ArrayList<Bin>();
        for (int i = 0; i < bins.size(); i++) {
            copy.add(bins.get(i).deepCopy());
        }
        return copy;
    }
}
