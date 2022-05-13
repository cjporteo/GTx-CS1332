import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */

    private void preorderHelper(TreeNode<T> root, ArrayList<T> list){
        if (root == null){
            return;
        }
        list.add(root.getData());
        preorderHelper(root.getLeft(), list);
        preorderHelper(root.getRight(), list);
        return;
    }

    public List<T> preorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        ArrayList<T> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */

    private void inorderHelper(TreeNode<T> root, ArrayList<T> list){
        if (root == null){
            return;
        }
        inorderHelper(root.getLeft(), list);
        list.add(root.getData());
        inorderHelper(root.getRight(), list);
        return;
    }

    public List<T> inorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        ArrayList<T> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */

    private void postorderHelper(TreeNode<T> root, ArrayList<T> list){
        if (root == null){
            return;
        }
        postorderHelper(root.getLeft(), list);
        postorderHelper(root.getRight(), list);
        list.add(root.getData());
        return;
    }

    public List<T> postorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        ArrayList<T> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }
}