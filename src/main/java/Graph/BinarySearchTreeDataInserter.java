package Graph;

/**
 *
 * @author ardal
 */
public class BinarySearchTreeDataInserter {
    /**
     * Inserts an ascending sorted array of values into a binary search tree with minimal height
     * @param sortedValue 
     */
    public BinarySearchTree insert(int[] sortedValues){
        BinarySearchTree tree = new BinarySearchTree();
        
        tree.root = getRoot(sortedValues);
        
        return tree;
    }
    
    private BinaryTreeNode<Integer> getRoot(int[] sortedValues){
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>();
        if(sortedValues.length == 1) {
            rootNode.data = sortedValues[0];
        }
        else {
            int middleIndex = sortedValues.length / 2;
            rootNode.data = sortedValues[middleIndex];
            
            int[] leftHalfValues = new int[middleIndex];
            for(int i = 0; i < middleIndex; i++) {
                leftHalfValues[i] = sortedValues[i];
            }
            
            rootNode.setLeft(getRoot(leftHalfValues));
            
            int rightHalfValuesCount = sortedValues.length - middleIndex - 1;
            
            if(rightHalfValuesCount > 0){
                int[] rightHalfValues = new int[rightHalfValuesCount];
                for(int i = 0; i < rightHalfValuesCount; i ++) {
                    rightHalfValues[i] = sortedValues[middleIndex + i + 1];
                }

                rootNode.setRight(getRoot(rightHalfValues));
            }
        }
        
        return rootNode;
    }
}
