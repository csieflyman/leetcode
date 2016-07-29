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
public class MaximumDepthofBinaryTree {

    private TreeNode root;
    private int expectedResult;

    public MaximumDepthofBinaryTree(TreeNode root, int expectedResult) {
        this.root = root;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {buildTree1(), 5}, {buildTree2(), 3}, {buildTree3(), 3}
        });

    }

    @Test
    public void testMaxDepth() throws Exception {
        Assert.assertEquals(maxDepth(root), expectedResult);
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;

        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }

    private static TreeNode buildTree1() {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode d = new TreeNode(3);
        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(5);
        a.left = b;
        b.left = d;
        d.right = f;
        f.left = g;
        return a;
    }

    private static TreeNode buildTree2() {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        a.left = b;
        a.right = c;
        b.left = d;
        return a;
    }

    private static TreeNode buildTree3() {
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
        b.right = e;
        c.left = f;
        c.right = g;
        return a;
    }
}
