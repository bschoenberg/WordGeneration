package FindWordStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordGenerator {

    public WordGenerator(IDictionary dictionary) {
        _dictionary = dictionary;
    }

    public List<String> generateWords(String inputWord) {

        if (inputWord.length() == 0) {
            throw new IllegalArgumentException("Word must contain at least one character");
        }

        else if (inputWord.contains(" ")) {
            String message = "More than one word input; only the first word will be processed";
            inputWord = inputWord.split(" ")[0];
        }

        else if (inputWord.matches("\\d+\\W+")) {
            throw new IllegalArgumentException("Word may not contain digits or special characters");
        }


        HashSet<String> permutations = computePermutations(inputWord);
        List<String> generatedWords = new ArrayList<>();

        for (String s : permutations) {
            if (_dictionary.isEnglishWord(s))
                generatedWords.add(s);
        }

        return generatedWords;
    }

    private HashSet<String> computePermutations(String word) {

        if (word == null)
            throw new NullPointerException("There is no word to process");

        else if (word.length() < 1)
            throw new IllegalArgumentException("Word must have at least one character");

        HashSet<String> permutations = new HashSet<>();

        if (word.length() == 1)
            permutations.add(word);

        else {
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                StringBuilder sb = new StringBuilder(word);
                String inner = sb.deleteCharAt(i).toString();

                HashSet<String> perms = computePermutations(inner);

                permutations.add(Character.toString(letter));

                for (String s : perms) {
                    permutations.add(s);
                    permutations.add(letter + s);
                    permutations.add(s + letter);
                }
            }
        }

        return permutations;
    }

    private IDictionary _dictionary;
}


