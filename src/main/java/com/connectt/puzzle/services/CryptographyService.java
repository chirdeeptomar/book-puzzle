package com.connectt.puzzle.services;

public class CryptographyService {

    public static String decrypt(String text, int rotateValue) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = getCharValue(rotateValue, ch, 'a', 'z');

                decryptedText.append(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = getCharValue(rotateValue, ch, 'A', 'Z');

                decryptedText.append(ch);
            } else {
                decryptedText.append(ch);
            }
        }
        return decryptedText.toString();
    }

    private static char getCharValue(int rotateValue, char ch, char a, char z) {
        ch = (char) (ch - rotateValue);

        if (ch < a) {
            ch = (char) (ch + z - a + 1);
        }
        return ch;
    }
}
