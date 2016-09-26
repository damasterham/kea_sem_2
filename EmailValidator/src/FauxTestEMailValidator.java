//Created by DaMasterHam on 05-09-2016.
//
public class FauxTestEMailValidator
{
    static int testSuccesCount = 0;
    static int testTotalCount = 0;

    private static void SuccesMessage(String testName, String email)
    {
        System.out.println(testName + ": where email=" + email+ " was a SUCCESS");
    }


    private static void FailedMessage(String testName, String email)
    {
        System.out.println(testName + ": where email=" + email+ " FAILED");
    }


    private static void TotalTest()
    {
        System.out.println(testSuccesCount+"/"+testTotalCount+ " Successful tests");
    }


    public static void TestTrue(String test, String email)
    {
        testTotalCount++;

        if (EmailValidator.validate(email))
        {
            SuccesMessage(test,email);
            testSuccesCount++;
        }
        else
        {
            FailedMessage(test,email);
        }
    }


    public static void TestFalse(String test, String email)
    {
        testTotalCount++;

        if (!EmailValidator.validate(email))
        {
            SuccesMessage(test,email);
            testSuccesCount++;
        }
        else
        {
            FailedMessage(test,email);
        }
    }


    public static void TestValidEmail()
    {
        TestTrue("TestValidEmail","bla@woop.com");
    }


    public static void TestEmailStartingWithDot()
    {
        TestFalse("TestEmailStartingWithDot", ".bla@woop.com");
    }


    public static void TestEmailSubdomainEndingWithDot()
    {
        TestFalse("TestEmailStartingWithDot", "bla.@woop.com");
    }

    public static void TestEmailPlainAddress()
    {
        TestFalse("TestEmailPlainAddress", "plainaddress");
    }



    public static void main(String[] args)
    {
        TestValidEmail();
        TestEmailStartingWithDot();
        TestEmailSubdomainEndingWithDot();
        TestEmailPlainAddress();

        TotalTest();
    }
}
