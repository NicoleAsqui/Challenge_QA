package starter.demoblaze;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static int extractNumber(String text) {
        String number = "";
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            number = matcher.group();
        }
        return Integer.parseInt(number);
    }
}
