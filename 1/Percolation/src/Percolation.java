public class Percolation {
    private WeightedQuickUnionUF openUF;
    private WeightedQuickUnionUF fullUF;
    private int N;
    private int[][] grid;
    private boolean[] full;

    public Percolation(int N) {
        openUF = new WeightedQuickUnionUF(N * N);
        full = new boolean[N * N];
        this.N = N;
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = 0;
            }
        }

        for (int i = 0; i < full.length; i++) {
            full[i] = false;
        }
    }

    public void open(int i, int j) {
        int index = getIndexOfGrid(i, j);

        boolean currentCellFilled = isFull(i,j);


        if(j > 1 && isOpen(i, j - 1)) {
            if(isFull(i, j-1)) currentCellFilled = true;
            openUF.union(index, getIndexOfGrid(i, j - 1));
        }

        if(i < (N) && isOpen(i + 1, j)) {
            if(isFull(i+1, j)) currentCellFilled = true;
            openUF.union(index, getIndexOfGrid(i + 1, j));
        }

        if(j < (N) && isOpen(i, j + 1)) {
            if(isFull(i, j+1)) currentCellFilled = true;
            openUF.union(index, getIndexOfGrid(i, j + 1));
        }

        if(i > 1 && isOpen(i - 1, j)) {
            if(isFull(i-1, j)) currentCellFilled = true;
            openUF.union(index, getIndexOfGrid(i - 1, j));
        }

        if(i == 1 || currentCellFilled) full[openUF.find(getIndexOfGrid(i, j))] = true;

        grid[i-1][j-1] = 1;
    }

    public boolean isOpen(int i, int j) {
        return grid[i-1][j-1] == 1;
    }

    public boolean isFull(int i, int j) {
        return full[openUF.find(getIndexOfGrid(i, j))];
    }

    private int getIndexOfGrid(int i, int j) {
        return ((i-1) * N) + (j-1);
    }

    public boolean percolates() {
        for (int i = 1; i <= N; i++) {
            if(isFull(N, i)) return true;
        }
        return false;
    }
}
