import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

/**
 * Created by DaMasterHam on 16-10-2016.
 */

//Write a program that processes a data file of students’ course grade data. The data arrive in random order; each line
//stores information about a student’s last name, first name, student ID number, grade as a percentage, and letter
//grade.

//Your program should be able to sort the data by any of the columns. Use Comparators to achieve the sort orderings.
//Make the data sortable by last name, student ID, and grade percentage in ascending and descending order. For example,
//here are the lines of student data sorted a few different ways:

public class Exercise_G_17
{
    private static final String studentsFileStream =
              "Smith Kelly 438975 98.6 A\n"
            + "Johnson Gus 210498 72.4 C\n"
            + "Reges Stu 098736 88.2 B\n"
            + "Smith Marty 346282 84.1 B\n"
            + "Reges Abe 298575 78.3 C";

    private class Student
    {
        private String firstName;
        private String lastName;
        private int id;
        private float scorePercent;
        private char scoreLetter;

        public Student()
        {
        }

        public String getFirstName()
        {
            return firstName;
        }

        public String getLastName()
        {
            return lastName;
        }

        public int getId() {
            return id;
        }

        public float getScorePercent()
        {
            return scorePercent;
        }

        public char getScoreLetter()
        {
            return scoreLetter;
        }


        public Student setFirstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Student setLastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }

        public Student setId(int id) {
            this.id = id;
            return this;
        }

        public Student setScorePercent(float scorePercent)
        {
            this.scorePercent = scorePercent;
            return this;
        }

        public Student setScoreLetter(char scoreLetter)
        {
            this.scoreLetter = scoreLetter;
            return this;
        }

        public String toString()
        {
            return String.format("%s %s %d %.1f %s", lastName, firstName, id, scorePercent, scoreLetter);
        }
    }

    private enum ORDER
    {
        ASC, DESC
    }

    private enum SORTBY
    {
        LASTNAME, ID, GRADEPERCENT
    }

    public void sortBy(List<Student> students, SORTBY sortBy, ORDER order)
    {
        Comparator<Student> comp = null;

        switch (sortBy)
        {
            case LASTNAME: comp = new Comparator<Student>()
            {
                public int compare(Student o1, Student o2)
                {
                    char o1Last;
                    char o2Last;

                    o1Last = o1.getLastName().toLowerCase().charAt(0);
                    o2Last = o2.getLastName().toLowerCase().charAt(0);

                    return o1Last - o2Last;
                }
            };
            break;

            case ID: comp = new Comparator<Student>()
            {
                public int compare(Student o1, Student o2)
                {
                    return o1.getId() - o2.getId();
                }
            };
                break;

            case GRADEPERCENT: comp = new Comparator<Student>()
            {
                public int compare(Student o1, Student o2)
                {
                    if (o1.getScorePercent() < o2.getScorePercent())
                        return -1;
                    else if (o1.getScorePercent() > o2.getScorePercent())
                        return 1;
                    return 0;
                }
            };
                break;
        }

        if (comp != null)
        {
            if (order == ORDER.DESC)
                Collections.sort(students, comp.reversed());
            else
                Collections.sort(students, comp);
        }
    }


    public List<Student> getStudents(Scanner read)
    {
        List<Student> students = new ArrayList<Student>();

        while (read.hasNextLine())
        {
            String[] fields;
            Student student;

            fields = read.nextLine().split(" ");
            student = new Student();

            if (fields.length > 0 && fields.length < 6)
            {
                student.setLastName(fields[0])
                        .setFirstName(fields[1])
                        .setId(Integer.parseInt(fields[2]))
                        .setScorePercent(Float.parseFloat(fields[3]))
                        .setScoreLetter(fields[4].charAt(0));

                students.add(student);
            }
        }

        return students;
    }


    private static void printStudents(List<Student> students)
    {
        for (Student student : students)
        {
            System.out.println(student.toString());
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Exercise_G_17 instance = new Exercise_G_17();
        Scanner read = new Scanner(studentsFileStream);

        System.out.println("Random input");
        List<Student> students = instance.getStudents(read);
        printStudents(students);

        System.out.println("Sorted by Last name- Ascending");
        instance.sortBy(students, SORTBY.LASTNAME, ORDER.ASC);
        printStudents(students);

        System.out.println("Sorted by Id - Ascending");
        instance.sortBy(students, SORTBY.ID, ORDER.ASC);
        printStudents(students);

        System.out.println("Sorted by Grade percent - Descending");
        instance.sortBy(students, SORTBY.GRADEPERCENT, ORDER.DESC);
        printStudents(students);

        System.out.println("Sorted by Grade percent - Ascending");

        instance.sortBy(students, SORTBY.GRADEPERCENT, ORDER.ASC);
        printStudents(students);
    }

}
