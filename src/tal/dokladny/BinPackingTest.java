package tal.dokladny;

import tal.utils.DataSetGenerator;

import java.util.ArrayList;
import java.util.List;

public class BinPackingTest {

    public static void main(String[] args) {

        DataSetGenerator dsg = new DataSetGenerator();
        int[] arr = dsg.generateRandomIntegerArray(1, 10,7);

        System.out.println("Generated array:");
        for(int i = 0; i < arr.length; i++) System.out.print(arr[i] + "  ");

        List<Integer> in = new ArrayList<Integer>();
        for (int i : arr)
        {
            in.add(i);
        }

        ExactBinPacker exactBinPacker = new ExactBinPacker(in, 10);
        test(exactBinPacker);


    }

    private static void test(ExactBinPacker packer) {
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        System.out.println("Potrzebne pudełka: " + packer.getResult());
        System.out.println("Wszystkie utworzone pudełka: " + packer.getAllBins());
        packer.printBestBins();
        endTime = System.currentTimeMillis() - startTime;
        System.out.println("Zapakowano w " + endTime + " ms");
        System.out.println("Iteracje: " + packer.getNumLoopIterations());

        System.out.println("\n\n");
    }

}
