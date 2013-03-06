public class QuickFind implements UnionFind {
    private int[] id;

    public QuickFind(int N) {
        this.id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        int id_p = id[p];
        for (int i = 0; i < id.length; i++) {
            if(id[i] == id_p){
                id[i] = id[q];
            }
        }
    }

    public int[] getId() {
        return id;
    }

    public boolean connected(int p, int q) {
        return (id[p] == id[q]);
    }
}
