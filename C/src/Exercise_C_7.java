//Created by DaMasterHam on 16-09-2016.
//
import java.lang.Math;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Exercise_C_7 implements Comparable<Exercise_C_7>
{

    // Fields
    private int originX;
    private int originY;
    private int x;
    private int y;

    // Constructors
    public Exercise_C_7()
    {
        this(0,0);
    }

    public Exercise_C_7(int x, int y)
    {
        this.originX = x;
        this.originY = y;
        setLocation(x, y);
    }

// Behavior (Instance methods)

    // Accessors
    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getOriginalX()
    {
        return originX;
    }

    public int getOriginalY()
    {
        return originY;
    }

    public double distanceFromOrigin()
    {
        return Math.sqrt(Math.pow(x - originX, 2) + Math.pow(y - originY, 2));
    }

    public String toString()
    {
        return String.format("(%d,%d)",x,y);
    }


    public int quadrant()
    {
        if (x > 0 && y > 0)
        {
            return 1;
        }
        else if (x < 0 && y < 0)
        {
            return 2;
        }
        else if (x > 0 && y < 0)
        {
            return 3;
        }
        else if (x < 0 && y > 0)
        {
            return 4;
        }
        else // x == 0 & y == 0
        {
            return 0;
        }
    }

    public int quadrantAlt()
    {

        if (x == 0 || x == 0)
        {
            return 0;
        }
        if (x > 0) // where x is posistive
        {
            if (y >= 0)
            {
                return 1;
            }
            else // y < 0
            {
                return 3;
            }
        }
        else if (x < 0) // where x is negative
        {
            if (y > 0)
            {
                return 4;
            }
            else // y < 0
            {
                return 2;
            }
        }
        return 0;
    }

    public int manhattanDistance(Exercise_C_7 other)
    {
        return (other.x - this.x) + (other.y - this.y);
    }

    public boolean isHorizontal(Exercise_C_7 other)
    {
        return this.y == other.y;
    }

    public double slope(Exercise_C_7 other)
    {
        if (this.x == other.x)
        {
            throw new IllegalArgumentException("Cannot get slope of the two Points. The x values of each point must not be the same.");
        }

        return (other.y - this.y) / (other.x - this.x);
    }


    public boolean equals(Exercise_C_7 p)
    {
        return equals(p.getX(), p.getY());
        //return (p.getX() == this.x && p.getY() == this.y);
    }

    public boolean equals(int x, int y)
    {
        return (x == this.x && y == this.y);
    }

    // Mutators
    public void setLocation(int x, int y)
    {
        this.x = x;
        this.y = y;
    }


    public void translate(int x, int y)
    {
        setLocation(this.x + x, this.y +y);
    }

    public void flip()
    {
        this.x *= -1;
        this.y *= -1;
    }

    // Ch10Ex18
    public int compareTo(Exercise_C_7 other)
    {
        int comparison;

        comparison = Integer.compare(this.y, other.y);

        if (comparison == 0)
        {
            comparison = Integer.compare(this.x, other.x);
        }

        return comparison;
    }

    public static void main(String[] args)
    {
        Exercise_C_7 a;
        Exercise_C_7 b;
        Exercise_C_7 c;
        Exercise_C_7 d;
        List<Exercise_C_7> array;

        a = new Exercise_C_7(4,3);
        b = new Exercise_C_7(1,8);
        c = new Exercise_C_7(2,3);
        d = new Exercise_C_7(4,5);
        array = new ArrayList<Exercise_C_7>();
        array.add(a);
        array.add(b);
        array.add(c);
        array.add(d);

        System.out.println(array.toString());

        Collections.sort(array);

        System.out.println(array.toString());
    }
}



