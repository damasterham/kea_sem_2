// Simple binary tree class that includes methods to construct a
// tree of ints, to print the structure, and to print the data
// using a preorder, inorder or postorder traversal.  The trees
// built have nodes numbered starting with 1 and numbered
// sequentially level by level with no gaps in the tree.  The
// documentation refers to these as "sequential trees."


public class Exercise_E_6
{
    private IntTreeNode overallRoot;

    // pre : max > 0
    // post: constructs a sequential tree with given number of
    //       nodes
    public Exercise_E_6(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }

    // post: returns a sequential tree with n as its root unless
    //       n is greater than max, in which case it returns an
    //       empty tree
    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max),
                                   buildTree(2 * n + 1, max));
        }
    }

    // post: prints the tree contents using a preorder traversal
    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }

    // post: prints the tree contents using a preorder traversal
    // post: prints in preorder the tree with given root
    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // post: prints the tree contents using a inorder traversal
    public void printInorder() {
        System.out.print("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(" " + root.data);
            printInorder(root.right);
        }
    }

    // post: prints the tree contents using a postorder traversal
    public void printPostorder() {
        System.out.print("postorder:");
        printPostorder(overallRoot);
        System.out.println();
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(IntTreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }


    // Ch17Ex1
    private int countLeft(IntTreeNode root)
    {
        int count;

        count = 0;

        if (root != null)
        {
            if (root.left != null)
            {
                count++;
                count += countLeft(root.left);
            }
            count += countLeft(root.right);
        }

        return count;
    }

    public int countLeft()
    {
        return countLeft(this.overallRoot);
    }


    // Ch17Ex2
    private int countEmpty(IntTreeNode root)
    {
        int count;

        count = 0;

        if (root != null)
        {
            count += countEmpty(root.left);
            count += countEmpty(root.right);
        }
        else
        {
            count++;
        }

        return count;
    }

    public int countEmpty()
    {
        return countEmpty(this.overallRoot);
    }

    // Ch17Ex3
    private int depthSum(IntTreeNode root, int depth)
    {
        int sum;

        sum = 0;

        if (root != null)
        {
            sum += depth * root.data;
            depth++;
            sum += depthSum(root.left, depth);
            sum += depthSum(root.right, depth);
        }

        return sum;
    }

    public int depthSum()
    {
        return depthSum(this.overallRoot, 1);
    }


    private void doublePositives(IntTreeNode root)
    {
        if (root != null)
        {
            if (root.data > 0)
            {
                root.data *= 2;
            }
            doublePositives(root.left);
            doublePositives(root.right);
        }
    }

    public void doublePositives()
    {
        doublePositives(this.overallRoot);
    }

    public static void main(String[] args)
    {
        Exercise_E_6 tree1;
        Exercise_E_6 tree2;
        Exercise_E_6 tree3;

        tree1 = new Exercise_E_6(6);
        tree2 = new Exercise_E_6(9);
        tree3 = new Exercise_E_6(8);

        System.out.println("Before doubling");
        tree1.printInorder();
        System.out.println("------------------------------------------");
        tree2.printInorder();
        System.out.println("------------------------------------------");
        tree3.printInorder();
        System.out.println();

        tree1.doublePositives();
        tree2.doublePositives();
        tree3.doublePositives();

        System.out.println("After doubling");
        tree1.printInorder();
        System.out.println("------------------------------------------");
        tree2.printInorder();
        System.out.println("------------------------------------------");
        tree3.printInorder();
        System.out.println();
    }
}