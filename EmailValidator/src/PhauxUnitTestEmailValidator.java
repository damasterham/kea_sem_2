import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//Created by DaMasterHam on 05-09-2016.
//
public class PhauxUnitTestEmailValidator
{
    private int count;
    private int maxCount;
    private Collection<String> emails;

    public PhauxUnitTestEmailValidator(Collection<String> emails)
    {
        initialize(emails);
    }

    public PhauxUnitTestEmailValidator(String emailsFile)
    {
//        File f = new File(".");
//        for (String s : f.list())
//        {
//            System.out.println(s);
//        }

        Scanner scan;
        String line;
        Set<String> set;
        File file;

        set = new HashSet<>();

        try
        {
            file = new File("src/"+"invalidEmails.txt");

            scan = new Scanner(file);

            while (scan.hasNextLine())
            {
                line = scan.nextLine();
                set.add(line);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        initialize(set);
    }


    private void initialize(Collection<String> emails)
    {
        count = 0;
        this.emails = emails;
        maxCount = emails.size();
    }


    public void TestEmails()
    {
        for (String email : emails)
        {
            TestEmail(email);
        }

        System.out.println(count+"/"+maxCount+" are invalid emails");
    }

    public void TestEmail(String email)
    {
        boolean valid;

        valid = EmailValidatorOLD.isValid(email);

        if (valid)
        {
            System.out.println(email + " is Valid");

        }
        else
        {
            count++;
            System.out.println(email + " is Invalid");
        }

    }


    public static void main(String[] args)
    {
        int i =0;

            PhauxUnitTestEmailValidator test01;

            test01 = new PhauxUnitTestEmailValidator("invalidEmails.txt");

            test01.TestEmails();


    }
}
