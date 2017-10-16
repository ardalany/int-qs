package Graph;

/**
 *
 * @author ardal
 */
public class BinarySearchTreeDataInserter {
    /**
     * Inserts an ascending sorted array of values into a binary search tree with minimal height
     * @param sortedValues an array of integers, sorted in ascending order
     */
    public BinarySearchTree insert(int[] sortedValues){
        BinarySearchTree tree = new BinarySearchTree();
        
        tree.root = getRoot(sortedValues, 0, sortedValues.length - 1);
        
        return tree;
    }
    
    private BinaryTreeNode<Integer> getRoot(int[] sortedValues, int startIndex, int endIndex){
        if(startIndex > endIndex) {
            return null;
        }
        else {
            BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>();
            int middleIndex = (endIndex + startIndex) / 2;
            
            rootNode.data = sortedValues[middleIndex];
            
            rootNode.setLeft(getRoot(sortedValues, startIndex, middleIndex - 1));
            
            rootNode.setRight(getRoot(sortedValues, middleIndex + 1, endIndex));
            
            return rootNode;
        } 
    }
}
