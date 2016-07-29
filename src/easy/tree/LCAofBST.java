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
public class LCAofBST {

    private TreeNode root;
    private TreeNode p;
    private TreeNode q;
    private TreeNode expectedResult;

    public LCAofBST(TreeNode root, TreeNode p, TreeNode q, TreeNode expectedResult) {
        this.root = root;
        this.p = p;
        this.q = q;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        TreeNode root = buildTree();
        return Arrays.asList(new Object[][]{
                {root, new TreeNode(2), new TreeNode(8), new TreeNode(6)},
                {root, new TreeNode(2), new TreeNode(4), new TreeNode(2)},
                {root, new TreeNode(3), new TreeNode(9), new TreeNode(6)},
                {root, new TreeNode(7), new TreeNode(9), new TreeNode(8)},
                {root, new TreeNode(3), new TreeNode(5), new TreeNode(4)}
        });
    }

    @Test
    public void testLCA() {
        Assert.assertEquals(lowestCommonAncestor(root, p, q).val, expectedResult.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root.left == null && root.right == null)
            return null;
        if(isBetween(root, p, q)) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        return leftNode == null ? lowestCommonAncestor(root.right, p, q) : leftNode;
    }

    private static boolean isBetween(TreeNode root, TreeNode p, TreeNode q) {
        return !((root.val > p.val && root.val > q.val) || (root.val < p.val && root.val < q.val));
    }

    private static TreeNode buildTree() {
        TreeNode a = new TreeNode(6);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(0);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(9);
        TreeNode h = new TreeNode(3);
        TreeNode i = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.left = h;
        e.right = i;
        return a;
    }
}
