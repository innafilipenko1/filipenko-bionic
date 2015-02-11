package class1;

/**
 * Created by ifilipenko on 2/11/2015.
 */
public class HW1 {

    //Реализовать алгоритм шифрования Цезаря

    public static void main(String[] args) {

        String str = "The quick brown fox Jumped over the lazy Dog";

        System.out.println( encode( str, 12));
        System.out.println( decode( encode( str, 12), 12 ));

    }

    public static String decode (String enc, int offset) {
        return encode(enc, 26-offset);
    }

    public static String encode(String enc, int offset) {
        offset = offset % 26 + 26;
        StringBuilder encoded = new StringBuilder();
        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encoded.append((char) ('A' + (i - 'A' + offset) % 26 ));
                } else {
                    encoded.append((char) ('a' + (i - 'a' + offset) % 26 ));
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }


}
