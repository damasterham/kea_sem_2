import java.util.List;
import java.util.*;
import java.util.stream.Collector;


//Created by DaMasterHam on 05-09-2016.
//
public class EmailValidatorOLD
{
    public static Set<String> validCharachters = new HashSet<>(Arrays.asList(
            "!", "#", "$", "%", "&", "'", "*", "+", "-", "/", "=", "?", "^", "_", "`", "{", "|", "}", "~"
    ));

    private static boolean isValidCharachters(Character chara)
    {
        boolean isLetterOrDigit;

        isLetterOrDigit = Character.isLetterOrDigit(chara);

        if (isLetterOrDigit)
        {
            return true;
        }

        for (String valid : validCharachters)
        {
            if (chara.equals(valid))
            {
                return true;
            }
        }

        return false;
    }

    private static boolean isNotDot(Character chara)
    {
        return !chara.equals('.');
    }


    private static boolean isValidSub(String subString)
    {
        List<Character> list;
        char[] charas = subString.toCharArray();

        list = new LinkedList<>();


        if (charas.length == 0 || isValidEnd(charas[0])) // Check if first char is a valid char and not dot
        {
            return false;
        }

        for (int i = 1; i < charas.length-1; i++) // Checks if all in between is a valid char
        {
            if (!isValidCharachters(charas[i]))
            {
                return false;
            }
        }

        if (isValidEnd(charas[charas.length-1])) // Check if last is valid char or not dot
        {
            return false;
        }

        return true;
    }

    private static boolean isValidEnd(char chara)
    {
        return (!isValidCharachters(chara) && !isNotDot(chara));
    }


    public static boolean isValid(String email)
    {
        String[] initialSplit;
        String[] emailSplit;
        int lastDotIndex;
        String domain;

        initialSplit = email.split("@",2);

        lastDotIndex = initialSplit[1].lastIndexOf(".");
        domain = initialSplit[1].substring(lastDotIndex+1);

        emailSplit = new String[3];
        emailSplit[0] = initialSplit[0];
        emailSplit[1] = initialSplit[1];
        emailSplit[2] = domain;

        for (int i = 0; i < emailSplit.length; i++)
        {
            isValidSub(emailSplit[i]);
        }


        return true;
    }
}
