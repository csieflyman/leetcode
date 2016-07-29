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
public class SameTree {

    private TreeNode p;
    private TreeNode q;
    private boolean expectedResult;

    public SameTree(TreeNode p, TreeNode q, boolean expectedResult) {
        this.p = p;
        this.q = q;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new TreeNode(0), new TreeNode(1), false}, {buildPTree(), buildQTree(), true}
        });
    }

    @Test
    public void testSameTree() {
        Assert.assertEquals(expectedResult, isSameTree(p, q));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p != null && q == null || p == null && q != null)
            return false;
        else {
            if(p.val != q.val)
                return false;
            else
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    private static TreeNode buildPTree() {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        return a;
    }

    private static TreeNode buildQTree() {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        return a;
    }
}
