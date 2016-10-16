import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by DaMasterHam on 16-10-2016.
 */
public class Test
{
    public static void mystery3(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String first = list.remove(i);
            list.add(i + 1, first);
        }
    }

    public static void main(String[] args)
    {
        List<String> str = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7"));

        mystery3(str);
    }
}
