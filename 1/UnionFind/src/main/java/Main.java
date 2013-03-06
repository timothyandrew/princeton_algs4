public class Main {

    public static void main(String[] args) {
//        UnionFind uf = new QuickFind(10);
//        uf.union(4,8);
//        uf.union(9,8);
//        uf.union(9,0);
//        uf.union(8,6);
//        uf.union(5,1);
//        uf.union(7,8);
        printIDs(new int[] {0,1,2,3,4,5,6,7,8,9});

        WeightedQuickUnion uf = new WeightedQuickUnion(10);
        uf.union(1,2);
        uf.union(2,6);
        uf.union(6,9);
        printIDs(uf.getId());
        System.out.println(uf.find(1));
        System.out.println(uf.find(2));
        System.out.println(uf.find(6));
        System.out.println(uf.find(9));
    }

    private static void printIDs(int[] id) {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println("");
    }
}
