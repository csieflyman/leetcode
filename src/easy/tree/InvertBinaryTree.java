package easy.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author csieflyman
 */
@RunWith(Parameterized.class)
public class InvertBinaryTree {

    private TreeNode root;
    private TreeNode expectedRoot;
    private SameTree sameTree;

    public InvertBinaryTree(TreeNode root, TreeNode expectedRoot) {
        this.root = root;
        this.expectedRoot = expectedRoot;
    }

    @Before
    public void setUp() throws Exception {
        sameTree = new SameTree(null, null, false);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {buildTree(), buildInverseTree()}
        });

    }

    @Test
    public void testInvertBinaryTree(){
        Assert.assertTrue(sameTree.isSameTree(invertTree(root), expectedRoot));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    private static TreeNode buildTree() {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(9);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        return a;
    }

    private static TreeNode buildInverseTree() {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(9);
        a.left = c;
        a.right = b;
        b.left = e;
        b.right = d;
        c.left = g;
        c.right = f;
        return a;
    }
}
