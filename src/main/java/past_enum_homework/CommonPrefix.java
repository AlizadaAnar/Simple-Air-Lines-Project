package past_enum_homework;

import java.util.Arrays;

public class CommonPrefix {
    public static void main(String[] args) {

        String[] names = {"Appain", "Appale", "Appaix", "Appaon", "Appaet"};
        Arrays.sort(names);
        String s1 = names[0];
        String s2 = names[names.length - 1];
        int x = 0;

        while (x < s1.length() && x < s2.length()) {
            if (s1.charAt(x) == s2.charAt(x)) {
                x++;
            } else {
                break;
            }
        }

        System.out.println(s1.substring(0, x));

    }
}
