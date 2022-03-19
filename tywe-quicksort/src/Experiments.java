/*
 * Experiments are run here using the four variations
 * of quicksort.
 *
 */
public class Experiments {

    public static void main(String[] args) {
        final int reps = 20;
        IntSorter mySorter = new InsertionSort();
        final Stopwatch clock = new Stopwatch();
        Data[] tests = {new Data(1000000, 200000, Data.Order.RANDOM)};
        long[] results = new long[reps];
        for(int i = 0; i < results.length; i++){
            clock.reset().start();
            mySorter.sort(tests[0].get());
            long time = clock.stop().nanoseconds();
            results[i] = time;
        }

        System.out.println("  ");
        System.out.println("The average is " + average(results) + " " + "Max is " + maximum(results) + " " + "Min is " + minimum(results));
    }

    private static long sum(long[] n) {
        long sum = 0;
        for (int i = 10; i < n.length; i++) {
            sum += n[i];
        }
        return sum;
    }

    private static long average(long[] n){
        long sumofTime = sum(n);
        return sumofTime/10;
    }

    private static long minimum(long[] n){
        long min = n[10];
        for(int i=11; i < n.length; ++i){
            if(min > n[i]){
                min = n[i];
            }
        }
        return min;
    }

    private static long maximum(long[] n){
        long max = n[10];
        for(int i=11; i < n.length; i++){
            if(max < n[i]){
                max = n[i];
            }
        }
        return max;
    }
}
