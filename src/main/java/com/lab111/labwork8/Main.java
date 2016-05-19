package com.lab111.labwork8;

/**
 * Created by verrden on 03.05.16.
 */
public class Main {
    public static void main(String[] args) {
        Component root = new DComposite("Top");
        Component BFSroot = new BComposite("Top");
        Component F1 = new DComposite("Branch1");
        Component F2 = new DComposite("Branch2");
        Component F3 = new BComposite("Branch1");
        Component F4 = new BComposite("Branch2");
        root.add(F1, F2);
        BFSroot.add(F3, F4, new Node("Node-"));
        Component Node1 = new DComposite("Node1");
        Node1.add(new Node("Node+"));
        F1.add(Node1,new Node("Node2"));
        F2.add(new Node("Node3"), new Node("Node4"));
        Component NodeB2 = new BComposite("Node2");
        NodeB2.add(new Node("Node+"));
        F3.add(new Node("Node1"), NodeB2, new Node("Node3"));
        F4.add(new Node("Node4"), new Node("Node5"));

        System.out.println("DFS ITERATOR");
        IIterator iterator = root.getIterator();
        do {
            System.out.println(iterator.current());
        } while (iterator.next() != null);

        System.out.println("BFS ITERATOR");
        iterator = BFSroot.getIterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
