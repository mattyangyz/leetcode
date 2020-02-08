package StringRelated.ReverseString;

public class ReverseString {

    public String reverseString(char[] chars) {

        StringBuilder sb = new StringBuilder(chars.toString());
        return sb.reverse().toString();
    }

    public String reverseStringReplacing(char[] chars) {

        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return new String(chars);
    }
}
