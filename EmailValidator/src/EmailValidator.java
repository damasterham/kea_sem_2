//Created by DaMasterHam on 05-09-2016.
//
public class EmailValidator
{
    public static boolean validate(String email)
    {
        int atIndex;

        if (email.charAt(0) == '.')
        {
            return false;
        }

        atIndex = email.indexOf("@");

        if (email.charAt(atIndex - 1) == '.')
        {
            return false;
        }

        return true;
    }
}
