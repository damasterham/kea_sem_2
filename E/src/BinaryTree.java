//Created by DaMasterHam on 19-09-2016.
//
public class BinaryTree
{
    BinaryTree left;
    BinaryTree right;
    int value;

    public BinaryTree(int value)
    {
        this.value = value;
    }

    public BinaryTree getLeft()
    {
        return left;
    }

    public BinaryTree getRight()
    {
        return right;
    }

    public Object getValue()
    {
        return value;
    }

    public void add(int value)
    {
        int compare = Integer.compare(value, this.value);

        if (compare < 0)
        {
            if (left != null)
            {
                add(value);
            }
            else
            {
                this.left = new BinaryTree(value);
            }
        }
        else if (compare > 0)
        {
            if (right != null)
            {
                add(value);
            }
            else
            {
                this.right = new BinaryTree(value);
            }
        }
    }

    private String toString(BinaryTree root)
    {
        String print;

        print = "";

        if (root != null)
        {
            print += toString(root.left);
            print += root.value + " ";
            print += toString(root.right);
        }

        return print;
    }

    public String toString()
    {
        String print;

        print = "[";
        print += toString(this);
        print += "]";

        return print;
    }

    public static int countLeft(BinaryTree root)
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

    public static void main(String[] args)
    {
        int count;

        count = 0;

        BinaryTree root;

        root = new BinaryTree(5);

        root.add(3);// left
        root.add(7); // right
        root.left.add(1); // left
        root.right.add(6); //left

        System.out.println(countLeft(root));
        System.out.println(root.toString());

    }

}
