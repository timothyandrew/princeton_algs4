public class PercolationStats {

    private double[] x;
    int N, T;

    public PercolationStats(int N, int T) {
        x = new double[T];
        this.N = N;
        this.T = T;

        for (int i = 0; i < T; i++) {
            int count = 0;
            Percolation p = new Percolation(N);

            while(true) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);

                if(p.isFull(row,col)) {
                    p.open(row, col);
                    count++;
                }

                if(p.percolates()) {
                    x[i] = count / (double) N;
                    break;
                }
            }
        }
    }

    public double mean() {
        double sum = 0;
        for (double v : x) {
            sum += v;
        }
        return sum / T;
    }

//    public double stddev()                   // sample standard deviation of percolation threshold
  //  public double confidenceLo()             // returns lower bound of the 95% confidence interval
    //public double confidenceHi()             // returns upper bound of the 95% confidence interval

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(N, T);

        StdOut.print("mean = " + stats.mean());
    }
}