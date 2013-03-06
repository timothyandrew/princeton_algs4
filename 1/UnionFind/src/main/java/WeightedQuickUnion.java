
public class WeightedQuickUnion implements UnionFind {
    private int[] id;
    public int[] ht;

    public WeightedQuickUnion(int N) {
        this.id = new int[N];
        this.ht = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            ht[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int root_p = root(p);
        int root_q = root(q);

        if(ht[root_p] >= ht[root_q]) { id[root_q] = root_p; ht[root_p] += ht[root_q]; }
        else { id[root_p] = root_q; ht[root_q] += ht[root_p]; }
    }

    private int root(int p) {
        if(id[p] == p) return p;
        return root(id[p]);
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public int[] getId() {
        return id;
    }
}
