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
public class SymmetricTree {

    private TreeNode root;
    private boolean expectedResult;
    private InvertBinaryTree invertBinaryTree;
    private SameTree sameTree;

    public SymmetricTree(TreeNode root, boolean expectedResult) {
        this.root = root;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {buildSymmetricTree(), true}, {buildNonSymmetricTree(), false}
        });
    }

    @Before
    public void setUp() throws Exception {
        invertBinaryTree = new InvertBinaryTree(null, null);
        sameTree = new SameTree(null, null, false);
    }

    @Test
    public void testSymmetricTree() throws Exception {
        Assert.assertEquals(isSymmetric(root), expectedResult);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        else if(root.left != null && root.right != null) {
            if(root.left.val != root.right.val)
                return false;
            else {
                return isSameTree(invertTree(root.left), root.right);
            }
        }
        else {
            if(root.left != null)
                return isSameTree(invertTree(root.left), root.right);
            else
                return isSameTree(invertTree(root.right), root.left);
        }
    }

    private boolean isSameTree(TreeNode rootA, TreeNode rootB) {
        return sameTree.isSameTree(rootA, rootB);
    }

    private TreeNode invertTree(TreeNode root) {
        return invertBinaryTree.invertTree(root);
    }

    private static TreeNode buildSymmetricTree() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(3);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        return a;
    }

    private static TreeNode buildNonSymmetricTree() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(3);
        a.left = b;
        a.right = c;
        b.right = d;
        c.right = e;
        return a;
    }
}
