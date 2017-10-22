/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author ardal
 */
public class TestDataCreator {
    public static BinaryTree<Integer> createTestTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root.data = 5;

        // Node 2
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>();
        node2.data = 2;

        // Node 5
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>();
        node5.data = 5;

        // Node 3
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>();
        node3.data = 3;
        node3.setLeft(node2);
        node3.setRight(node5);

        tree.root.setLeft(node3);

        // Node 8
        BinaryTreeNode<Integer> node8 = new BinaryTreeNode<>();
        node8.data = 8;

        // Node 7
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>();
        node7.data = 7;
        node7.setRight(node8);

        tree.root.setRight(node7);

        return tree;
    }
    
    public static BinaryTree<Integer> createTestUnbalancedTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root.data = 1;

        // Node 2
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>();
        node2.data = 2;

        // Node 3
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>();
        node3.data = 3;
        
        tree.root.setLeft(node2);
        tree.root.setRight(node3);

        // Node 4
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>();
        node4.data = 4;

        // Node 5
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>();
        node5.data = 5;
        
        node4.setLeft(node5);

        node2.setLeft(node4);

        return tree;
    }
    
    public static Graph<Integer> createDirectedGraphWithLoops(){
        Graph<Integer> graph = new Graph<>();
        Vertex<Integer> vertice1 = new Vertex(1);
        Vertex<Integer> vertice2 = new Vertex(2);
        Vertex<Integer> vertice3 = new Vertex(3);
        Vertex<Integer> vertice4 = new Vertex(4);
        
        graph.addEdge(vertice1, vertice2);
        graph.addEdge(vertice1, vertice3);
        graph.addEdge(vertice2, vertice1);
        graph.addEdge(vertice3, vertice1);
        graph.addEdge(vertice2, vertice4);
        
        return graph;
    }
    
    public static Graph<Integer> createDirectedGraphWithoutLoops(){
        Graph<Integer> graph = new Graph<>();
        Vertex<Integer> vertice1 = new Vertex(1);
        Vertex<Integer> vertice2 = new Vertex(2);
        Vertex<Integer> vertice3 = new Vertex(3);
        Vertex<Integer> vertice4 = new Vertex(4);
        
        graph.addEdge(vertice1, vertice2);
        graph.addEdge(vertice1, vertice3);
        graph.addEdge(vertice4, vertice2);
        
        return graph;
    }
    
    public static BinarySearchTree createTestBST(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.root.data = 10;

        // Node 4
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>();
        node4.data = 4;

        // Node 7
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>();
        node7.data = 7;

        // Node 6
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>();
        node6.data = 6;
        node6.setLeft(node4);
        node6.setRight(node7);

        tree.root.setLeft(node6);

        // Node 21
        BinaryTreeNode<Integer> node21 = new BinaryTreeNode<>();
        node21.data = 21;

        // Node 15
        BinaryTreeNode<Integer> node15 = new BinaryTreeNode<>();
        node15.data = 15;
        node15.setRight(node21);

        tree.root.setRight(node15);

        return tree;
    }
    
    /**
     * This binary tree is not a BST.
     */
    public static BinaryTree<Integer> createTestBinaryTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root.data = 5;

        // Node 2
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>();
        node2.data = 2;

        // Node 6
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>();
        node6.data = 6;

        // Node 3
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>();
        node3.data = 3;
        node3.setLeft(node2);
        node3.setRight(node6);

        tree.root.setLeft(node3);

        // Node 8
        BinaryTreeNode<Integer> node8 = new BinaryTreeNode<>();
        node8.data = 8;

        // Node 7
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>();
        node7.data = 7;
        node7.setRight(node8);

        tree.root.setRight(node7);

        return tree;
    }
}
