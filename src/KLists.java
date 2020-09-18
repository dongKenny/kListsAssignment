public class KLists {

    public double[] mergeKLists (double[][] outerArray) {
        //Outer array has no inner arrays, return empty array
        if (outerArray.length == 0) {
            return new double[0];
        }

        //Initialize the result with the first array of outerArray and loop starting with the index (next array) after it
        double[] result = outerArray[0];
        for (int i = 1; i < outerArray.length; i++) {
            result = merge(result, outerArray[i]);
        }
        return result;
    }

    public double[] merge(double[] left, double[] right) {
        int i = 0;
        int l = 0;
        int r = 0;
        int leftLen = left.length;
        int rightLen = right.length;

        double[] result = new double[leftLen + rightLen];

        //Compare items between both subarrays
        while(l < leftLen && r < rightLen){
            if (left[l] <= right[r]) {
                result[i] = left[l++];
            }
            else {
                result[i] = right[r++];
            }
            i++;
        }

        //Copy remaining elements on left
        while(l < leftLen) {
            result[i++] = left[l++];
        }

        //Copy remaining elements on right
        while(r < rightLen) {
            result[i++] = right[r++];
        }
        return result;
    }

    public void arrayOutput(double[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        if (arr.length > 0) {
            System.out.print(arr[arr.length-1]);
        }
        System.out.print("]\n");
    }

    public static void main(String args[]) {
        KLists mergeK = new KLists();
        double[][] test = { {1.1, 4.4, 5.5}, {1.1, 3.3, 4.4}, {2.2, 6.6} };
        double[][] test2 = {};
        double[][] test3 = {{}};
        double[][] test4 = { {9.7, 17.1}, {15.8}, {12.7, 18.5, 21.27} };
        double[][] test5 = {{1.0, 2.0, 3.0, 4.0}};

        double[] result = mergeK.mergeKLists(test);
        double[] result2 = mergeK.mergeKLists(test2);
        double[] result3 = mergeK.mergeKLists(test3);
        double[] result4 = mergeK.mergeKLists(test4);
        double[] result5 = mergeK.mergeKLists(test5);

        mergeK.arrayOutput(result);
        mergeK.arrayOutput(result2);
        mergeK.arrayOutput(result3);
        mergeK.arrayOutput(result4);
        mergeK.arrayOutput(result5);


    }
}
