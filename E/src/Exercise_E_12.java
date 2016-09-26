//Created by DaMasterHam on 22-09-2016.
//
public class Exercise_E_12
{
        private boolean[] inUse;
        private char[]    elementData;

        private static final int SIZE = 13; // number of letters in the english alphabet


        public Exercise_E_12()
        {
            inUse = new boolean[SIZE];
            elementData = new char[SIZE];
        }


        private static boolean isValidChar(char ch)
        {
            if (ch >= 'A' && ch <='Z')
            {
                return true;
            }

            if (ch >= 'a' && ch <='z')
            {
                return true;
            }

            return false;
        }


        private int hashFunction(char ch)
        {
      /*
       A returns 0
       B returns 1
       ...
       Z returns 25

       a returns 0
       b returns 1
       ...
       z returns 25

      */


            if (ch >= 'A' && ch <= 'Z')
            {
                return ch - 'A';
            }

            if (ch >= 'a' && ch <= 'z')
            {
                return ch - 'a';
            }

            return 0;
        }


        public void add(char ch)
        {
            int code;

            code = hashFunction(ch);

            inUse[code] = true;
            elementData[code] = ch;
        }


        public boolean contains(char ch)
        {
            int code;
            boolean result;

            code = hashFunction(ch);

            result = inUse[code];
            return result;
        }


        public void remove(char ch)
        {
            int code;

            code = hashFunction(ch);

            inUse[code] = false;
        }


        public String toString()
        {
            String str = "[ ";

            for (int i = 0; i < SIZE; i++)
            {
                if (inUse[i])
                {
                    str += elementData[i] + " ";
                }
            }
            str += "]";

            return str;
        }


        public static void main(String[] args)
        {
            Exercise_E_12 myHashSet;
            String    str;

            myHashSet = new Exercise_E_12();

            for (int i = 'A'; i <= 'Z'; i++)
            {
                myHashSet.add((char)i);
            }

            str = myHashSet.toString();


            lasseTest(myHashSet);

            System.out.println(myHashSet.toString());

        }

    private static void lasseTest(Exercise_E_12 myHashSet)
    {
        String str;

        str = myHashSet.toString();
        System.out.println(str);

        if (myHashSet.contains('Z'))
        {
            System.out.println("Contains Z");
        }

        if (!myHashSet.contains('M'))
        {
            System.out.println("Does not contain M");
        }


        myHashSet.remove('Z');

        if (!myHashSet.contains('Z'))
        {
            System.out.println("Does no longer contains Z");
        }

    }
}
