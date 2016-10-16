import java.lang.annotation.ElementType;

//Created by DaMasterHam on 22-09-2016.
//
public class Exercise_E_12
{
        private boolean[][] inUse;
        private char[][]    elementData;

        private static final int SIZE = 13; // number of letters in the english alphabet
        private static final int ELEMENTS = 2;

        public Exercise_E_12()
        {
            inUse = new boolean[SIZE][ELEMENTS];
            elementData = new char[SIZE][ELEMENTS];
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


        private int[] hashFunction(char ch)
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
            int[] result;

            result = new int[ELEMENTS];


            if (ch >= 'A' && ch <= 'Z')
            {
                int iCh = ch - 'A';

                result[0] = iCh / 2;

                if ((iCh % 2) == 0)
                {
                    result[1] = 0;
                }
                else
                {
                    result[1] = 1;
                }
            }

            if (ch >= 'a' && ch <= 'z')
            {
                int iCh = ch - 'a';

                result[0] = iCh / 2;

                if ((iCh % 2) == 0)
                {
                    result[1] = 0;
                }
                else
                {
                    result[1] = 1;
                }
            }

            return result;
        }


        public void add(char ch)
        {
            int[] code;

            code = hashFunction(ch);

            inUse[code[0]][code[1]] = true;
            elementData[code[0]][code[1]] = ch;
        }


        public boolean contains(char ch)
        {
            int[] code;
            boolean result;

            code = hashFunction(ch);

            result = inUse[code[0]][code[1]];
            return result;
        }


        public void remove(char ch)
        {
            int[] code;

            code = hashFunction(ch);

            inUse[code[0]][code[1]] = false;
        }


        public String toString()
        {
            String str = "[ ";

            for (int i = 0; i < SIZE; i++)
            {
                for (int j = 0; j < ELEMENTS; j++)
                {
                    if (inUse[i][j])
                    {
                        str += elementData[i][j] + " ";
                    }
                }

            }
            str += "]";

            return str;
        }


        public static void main(String[] args)
        {
            Exercise_E_12 myHashSet;

            myHashSet = new Exercise_E_12();

            for (int i = 'A'; i <= 'Z'; i++)
            {
                myHashSet.add((char)i);
            }



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




        myHashSet.remove('Z');

        if (!myHashSet.contains('Z'))
        {
            System.out.println("Does no longer contains Z");
        }

        myHashSet.remove('m');

        if (!myHashSet.contains('M'))
        {
            System.out.println("Does not contain M");
        }
    }
}
