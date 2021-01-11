package FindWordStrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ProgramTests {

    @Test (expected = IllegalArgumentException.class)
    public void generateWords_emptyString_throwsError() {
        IDictionary dictionary = new Dictionary();

        String inputWord = "";
        WordGenerator generator = new WordGenerator(dictionary);
        HashSet<String> results = generator.generateWords(inputWord);
    }

    @Test (expected = IllegalArgumentException.class)
    public void generateWords_stringWithNumbers_throwsError() {
        IDictionary dictionary = new Dictionary();

        String inputWord = "All4One";
        WordGenerator generator = new WordGenerator(dictionary);
        HashSet<String> results = generator.generateWords(inputWord);
    }

    @Test (expected = IllegalArgumentException.class)
    public void generateWords_stringWithSpecialCharacters_throwsError() {
        IDictionary dictionary = new Dictionary();

        String inputWord = "boyz%";
        WordGenerator generator = new WordGenerator(dictionary);
        HashSet<String> results = generator.generateWords(inputWord);
    }

    @Test
    public void generateWords_singleLetterWord_returnsCorrectResult() {
        IDictionary mockDictionary = mock(IDictionary.class);

        HashSet<String> mock = new HashSet<>();
        mock.add("a");
        for (String string : mock)
            when(mockDictionary.isEnglishWord(string)).thenReturn(true);

        HashSet<String> generatedWords = new HashSet<>();

        String inputWord = "a";
        WordGenerator generator = new WordGenerator(mockDictionary);
        HashSet<String> results = generator.generateWords(inputWord);
        for (String s : results) {
            generatedWords.add(s);
        }

        Assert.assertEquals(1, generatedWords.size());
        Assert.assertEquals(mock, results);
    }

    @Test
    public void generateWords_twoLetterWord_returnsCorrectResult() {
        IDictionary mockDictionary = mock(IDictionary.class);

        HashSet<String> mock = new HashSet<>();
        mock.add("a");
        mock.add("at");
        for (String string : mock)
            when(mockDictionary.isEnglishWord(string)).thenReturn(true);

        HashSet<String> generatedWords = new HashSet<>();

        String inputWord = "at";
        WordGenerator generator = new WordGenerator(mockDictionary);
        HashSet<String> results = generator.generateWords(inputWord);
        for (String s : results) {
            generatedWords.add(s);
        }

        Assert.assertEquals(2, generatedWords.size());
        Assert.assertEquals(mock, results);
    }

    @Test
    public void generateWords_threeLetterWord_returnsCorrectResult() {
        IDictionary mockDictionary = mock(IDictionary.class);

        HashSet<String> mock = new HashSet<>();
        mock.add("a");
        mock.add("at");
        mock.add("ta");
        mock.add("cat");
        mock.add("act");
        for (String string : mock)
            when(mockDictionary.isEnglishWord(string)).thenReturn(true);


        HashSet<String> generatedWords = new HashSet<>();

        String inputWord = "cat";
        WordGenerator generator = new WordGenerator(mockDictionary);
        HashSet<String> results = generator.generateWords(inputWord);
        for (String s : results) {
            generatedWords.add(s);
        }

        Assert.assertEquals(5, generatedWords.size());
        Assert.assertEquals(mock, results);
    }

    @Test
    public void generateWords_twoWordInput_onlyFirstWordProcessed() {
        IDictionary mockDictionary = mock(IDictionary.class);

        HashSet<String> mock = new HashSet<>();
        mock.add("a");
        mock.add("at");
        mock.add("fa");
        mock.add("aft");
        mock.add("fat");
        for (String string : mock)
            when(mockDictionary.isEnglishWord(string)).thenReturn(true);

        String inputWord = "fat cat";
        HashSet<String> generatedWords = new HashSet<>();

        WordGenerator generator = new WordGenerator(mockDictionary);
        HashSet<String> results = generator.generateWords(inputWord);
        for (String s : results) {
            generatedWords.add(s);
        }

        Assert.assertEquals(5, generatedWords.size());
        Assert.assertEquals(mock, results);
    }

    @Test
    public void generateWords_otherThreeLetterWord_returnsCorrectResult() {
        IDictionary mockDictionary = mock(IDictionary.class);
        HashSet<String> mock = new HashSet<>();
        mock.add("po");
        mock.add("or");
        mock.add("pro");
        for (String string : mock) {
            when(mockDictionary.isEnglishWord(string)).thenReturn(true);
        }

        HashSet<String> generatedWords = new HashSet<>();

        String inputWord = "pro";
        WordGenerator generator = new WordGenerator(mockDictionary);
        HashSet<String> results = generator.generateWords(inputWord);
        for (String s : results) {
            generatedWords.add(s);
        }

        Assert.assertEquals(3, generatedWords.size());
        Assert.assertEquals(mock, results);
    }

    @Test
    public void generateWords_wordWithDupLetters_returnsCorrectResult() {
        IDictionary mockDictionary = mock(IDictionary.class);
        HashSet<String> mock = new HashSet<>();
        mock.add("a");
        mock.add("ad");
        mock.add("da");
        mock.add("dad");
        mock.add("add");
        for (String string : mock)
            when(mockDictionary.isEnglishWord(string)).thenReturn(true);

        HashSet<String> generatedWords = new HashSet<>();

        String inputWord = "add";
        WordGenerator generator = new WordGenerator(mockDictionary);
        HashSet<String> results = generator.generateWords(inputWord);
        for (String s : results) {
            generatedWords.add(s);
        }

        Assert.assertEquals(5, generatedWords.size());
        Assert.assertEquals(mock, results);
    }

    @Test
    public void generateWords_fourLetterWord_returnsCorrectResult() {
        IDictionary mockDictionary = mock(IDictionary.class);
        HashSet<String> mock = new HashSet<>();
        mock.add("cud");
        mock.add("crud");
        for (String string : mock)
            when(mockDictionary.isEnglishWord(string)).thenReturn(true);

        HashSet<String> generatedWords = new HashSet<>();

        String inputWord = "crud";
        WordGenerator generator = new WordGenerator(mockDictionary);
        HashSet<String> results = generator.generateWords(inputWord);
        for (String s : results) {
            generatedWords.add(s);
        }

        Assert.assertEquals(2, generatedWords.size());
        Assert.assertEquals(mock, results);
    }

    @Test
    public void generateWords_longWord_returnsCorrectResult() {
        IDictionary mockDictionary = mock(IDictionary.class);
        HashSet<String> mock = new HashSet<>();
        mock.add("i");
        mock.add("or");
        mock.add("in");
        mock.add("ow");
        mock.add("on");
        mock.add("go");
        mock.add("gi");
        mock.add("ki");
        mock.add("wo");
        mock.add("wok");
        mock.add("kor");
        mock.add("kin");
        mock.add("gin");
        mock.add("wog");
        mock.add("wig");
        mock.add("row");
        mock.add("now");
        mock.add("won");
        mock.add("win");
        mock.add("gor");
        mock.add("org");
        mock.add("gow");
        mock.add("koi");
        mock.add("nog");
        mock.add("nor");
        mock.add("ring");
        mock.add("rink");
        mock.add("king");
        mock.add("wing");
        mock.add("grin");
        mock.add("wink");
        mock.add("wonk");
        mock.add("grow");
        mock.add("worn");
        mock.add("know");
        mock.add("work");
        mock.add("wrong");
        mock.add("grown");
        mock.add("rowing");
        mock.add("working");
        for (String string : mock)
            when(mockDictionary.isEnglishWord(string)).thenReturn(true);


        HashSet<String> generatedWords = new HashSet<>();

        String inputWord = "working";
        WordGenerator generator = new WordGenerator(mockDictionary);
        HashSet<String> results = generator.generateWords(inputWord);
        for (String s : results) {
            generatedWords.add(s);
        }

        Assert.assertEquals(40, generatedWords.size());
        Assert.assertEquals(mock, results);
    }
}
