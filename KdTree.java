import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

/**
 * Created by ryan on 3/7/17.
 *
 * TODO:
 * 1. check logic of insert and root inserts
 * 2. finish implementing helper methods
 * 3. run test cases
 *
 **/
public class KdTree
{
    private int size;
    private Node root;

    private class Node
    {
        private Node left; // lower value
        private Node right; // higher value
        private Point2D p;
        private RectHV r;

        public Node(Point2D p, RectHV r)
        {
            this.p = p;
            this.r = r;
        }
    }

    public KdTree()
    {
        size = 0;
        root = null;

    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

    public void insert(Point2D p)
    {
        root = insert(root, p, 0.0, 0.0, 1.0, 1.0, true);
    }

    private Node insert(Node node, Point2D p, double x0, double y0, double x1, double y1, boolean orientation)
    {
        // ORIENTATION
        // TRUE = Vertical
        // FALSE = Horizontal

        // empty location reached
        if (node == null)
        {
            size++;
            RectHV r = new RectHV(x0, y0, x1, y1);
            return new Node(p, r);
        }
        // check if duplicate node
        else if (node.p.x() == p.x() && node.p.y() == p.y())
        {
            return node;
        }
        // vertical is true, compare x values
        if(orientation)
        {
            double cmp = p.x() - node.p.x();

            // new node.p.x value is less than current -> go left
            if (cmp < 0)
            {
                node.left = insert(node.left, p, x0, y0, node.p.x(), y1, !orientation);
            }
            // else go right
            else
            {
                node.right = insert(node.right, p, node.p.x(), y0, x1, y1, !orientation);
            }
        }
        else
        {
            double cmp = p.y() - node.p.y();
            if (cmp < 0)
            {
                node.left = insert(node.left, p, x0, y0, x1, node.p.y(), !orientation);
            }
            else
            {
                node.right = insert(node.right, p, x0, node.p.y(), x1, y1, !orientation);
            }
        }

        return node;
    }

    public boolean contains(Point2D p)
    {

    }

    public void draw()
    {

    }

    public Iterable<Point2D> range(RectHV rect)
    {

    }

    public Point2D nearest(Point2D P)
    {

    }
}
