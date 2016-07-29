package easy.tree;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author csieflyman
 */
@RunWith(Parameterized.class)
public class BalancedBinaryTree {

    private TreeNode root;
    private boolean expectedResult;

    public BalancedBinaryTree(TreeNode root, boolean expectedResult) {
        this.root = root;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {buildTree1(), true}, {buildTree2(), false}, {buildTree3(), false}
        });
    }

    @Test
    public void testBalancedBinaryTree() throws Exception {
        Assert.assertEquals(isBalanced(root), expectedResult);
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }

    private static TreeNode buildTree1() {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(6);
        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        e.left = g;
        return a;
    }

    private static TreeNode buildTree2() {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        e.left = f;
        return a;
    }

    private static TreeNode buildTree3() {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode d = new TreeNode(3);
        a.left = b;
        b.left = d;
        return a;
    }
}
