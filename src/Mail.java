import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;

public class Mail {

    public static void main(String[] args) throws Exception {

        File file = new File("D:\\Tolstoi_Lev__Voina_i_mir._Tom_1_www.Litmir.net_27684.txt");
        BufferedReader bufferedReader
                = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")));
        String line;

        String minWord = "";
        String maxWord = "";
        int countMinWord = 1;
        int countMaxWord = 1;

        while ((line = bufferedReader.readLine()) != null) {
            String lineWithoutSpecCharacters = line.replaceAll("[^a-zA-Zà-ÿÀ-ß]", " ");
            String[] arrayWords = lineWithoutSpecCharacters.toUpperCase().split("\\s+");

            for (int i = 0; i < arrayWords.length; i++) {

                if (!arrayWords[i].isEmpty() && minWord.isEmpty()) {
                    minWord = arrayWords[i];
                    maxWord = arrayWords[i];

                } else if (!arrayWords[i].isEmpty() && arrayWords[i].length() < minWord.length()) {
                    minWord = arrayWords[i];
                    countMinWord = 1;

                } else if (!arrayWords[i].isEmpty() && arrayWords[i].length() > maxWord.length()) {
                    maxWord = arrayWords[i];
                    countMaxWord = 1;

                } else if (!arrayWords[i].isEmpty() && arrayWords[i].length() == minWord.length()
                        && arrayWords[i].compareTo(minWord) == 0) {
                    countMinWord++;

                } else if (!arrayWords[i].isEmpty() && arrayWords[i].length() == minWord.length()
                        && arrayWords[i].compareTo(minWord) < 0) {
                    minWord = arrayWords[i];
                    countMinWord = 1;

                } else if (!arrayWords[i].isEmpty() && arrayWords[i].length() == maxWord.length()
                        && arrayWords[i].compareTo(maxWord) == 0) {
                    countMaxWord++;

                } else if (!arrayWords[i].isEmpty() && arrayWords[i].length() == maxWord.length()
                        && arrayWords[i].compareTo(maxWord) > 0) {
                    maxWord = arrayWords[i];
                    countMaxWord = 1;
                }
            }
        }
        System.out.println("The smallest word is " + minWord + " and repeats " + countMinWord +
                " times; the largest - " + maxWord + " repeats " + countMaxWord);
    }
}
