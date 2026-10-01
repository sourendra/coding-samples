// Infosys 1st Round
public class ConcurrentWorker {

    /**
     * Minimum Concurrent Workers:
     *
     * You are given a list of requests, each with a {start, end} time. A worker handles one request at a time and is busy during [start, end).
     * A worker that finishes at time t can immediately take a request starting at t.
     *
     * Return the minimum number of workers needed to handle all requests.
     *
     * public int minWorkers(int[][] requests)
     *
     * Constraints:
     *
     * 1 <= requests.length <= 10^5
     * 0 <= start < end <= 10^9
     * Input is not sorted
     *
     * Sample:
     *
     * [[0,30],[5,10],[15,20]]          -> 2
     * [[7,10],[2,4]]                   -> 1
     * [[1,5],[5,9],[9,12]]             -> 1
     * [[1,10],[2,9],[3,8],[4,7]]       -> 4
     *
     * */
    //start 0, if endTime> 2nd start time then start another worker.

    public static void main(String[] args) {
        int[][] requests1 = {{0, 30}, {5, 10}, {15, 20}};
        int[][] requests2 = {{7, 10}, {2, 4}};
        int[][] requests3 = {{1, 5}, {5, 9}, {9, 12}};
        int[][] requests4 = {{1, 10}, {2, 9}, {3, 8}, {4, 7}};
        ConcurrentWorker concurrentWorker = new ConcurrentWorker();
        int count1 = concurrentWorker.minimumWorkers(requests1);
        int count2 = concurrentWorker.minimumWorkers(requests2);
        int count3 = concurrentWorker.minimumWorkers(requests3);
        int count4 = concurrentWorker.minimumWorkers(requests4);
        System.out.println("Minimum " + count1 + " workers required for request1");
        System.out.println("Minimum " + count2 + " workers required for request2");
        System.out.println("Minimum " + count3 + " workers required for request3");
        System.out.println("Minimum " + count4 + " workers required for request4");
    }

    private int minimumWorkers(int[][] requests) {
        int count = 1;
        for (int i = 0; i < requests.length-1; i++) {
            if (requests[i][1] > requests[i+1][0]){
                if (requests[i][0] < requests[i+1][0])
                    count++;
            }
        }
        return count;
    }
}
