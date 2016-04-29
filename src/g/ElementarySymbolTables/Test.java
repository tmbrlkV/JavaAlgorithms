package g.ElementarySymbolTables;

public class Test {
    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.put(1, "C");
        tree.put(3, "D");
        tree.put(2, "A");
        tree.put(4, "F");
        tree.delete(4);
        Iterable<Integer> q = tree.print();
        for (Integer i: q) {
            System.out.println(i);
        }

    }
}
