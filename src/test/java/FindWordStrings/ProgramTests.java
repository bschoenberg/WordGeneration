package FindWordStrings;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ProgramTests {

    @Test (expected = IllegalArgumentException.class)
    public void generateWords_emptyString_throwsError() {
        IDictionary dictionary = new Dictionary();

        String inputWord = "";
        WordGenerator generator = new WordGenerator(dictionary);
        List<String> results = generator.generateWords(inputWord);
    }

    @Test (expected = IllegalArgumentException.class)
    public void generateWords_stringWithNumbers_throwsError() {
        IDictionary dictionary = new Dictionary();

        String inputWord = "All4One";
        WordGenerator generator = new WordGenerator(dictionary);
        List<String> results = generator.generateWords(inputWord);
    }

    @Test (expected = IllegalArgumentException.class)
    public void generateWords_stringWithSpecialCharacters_throwsError() {
        IDictionary dictionary = new Dictionary();

        String inputWord = "boyz%";
        WordGenerator generator = new WordGenerator(dictionary);
        List<String> results = generator.generateWords(inputWord);
    }

    @Test
    public void generateWords_singleLetterWord_returnsCorrectResult() {
        IDictionary mockDictionary = mock(IDictionary.class);
        when(mockDictionary.isEnglishWord("a")).thenReturn(true);

        List<String> generatedWords = new ArrayList<>();

        String inputWord = "a";
        WordGenerator generator = new WordGenerator(mockDictionary);
        List<String> results = generator.generateWords(inputWord);
        for (String s : results) {
            generatedWords.add(s);
        }

        Assert.assertEquals(1, generatedWords.size());
    }

    @Test
    public void generateWords_twoLetterWord_returnsCorrectResult() {
        IDictionary mockDictionary = mock(IDictionary.class);
        when(mockDictionary.isEnglishWord("a")).thenReturn(true);
        when(mockDictionary.isEnglishWord("at")).thenReturn(true);

        List<String> generatedWords = new ArrayList<>();

        String inputWord = "at";
        WordGenerator generator = new WordGenerator(mockDictionary);
        List<String> results = generator.generateWords(inputWord);
        for (String s : results) {
            generatedWords.add(s);
        }

        Assert.assertEquals(2, generatedWords.size());
    }

    @Test
    public void generateWords_threeLetterWord_returnsCorrectResult() {
        IDictionary mockDictionary = mock(IDictionary.class);
        when(mockDictionary.isEnglishWord("a")).thenReturn(true);
        when(mockDictionary.isEnglishWord("at")).thenReturn(true);
        when(mockDictionary.isEnglishWord("ta")).thenReturn(true);
        when(mockDictionary.isEnglishWord("cat")).thenReturn(true);
        when(mockDictionary.isEnglishWord("act")).thenReturn(true);

        List<String> generatedWords = new ArrayList<>();

        String inputWord = "cat";
        WordGenerator generator = new WordGenerator(mockDictionary);
        List<String> results = generator.generateWords(inputWord);
        for (String s : results) {
            generatedWords.add(s);
        }

        Assert.assertEquals(5, generatedWords.size());
    }

    @Test
    public void generateWords_twoWordInput_onlyFirstWordProcessed() {
        IDictionary mockDictionary = mock(IDictionary.class);
        when(mockDictionary.isEnglishWord("a")).thenReturn(true);
        when(mockDictionary.isEnglishWord("at")).thenReturn(true);
        when(mockDictionary.isEnglishWord("fa")).thenReturn(true);
        when(mockDictionary.isEnglishWord("aft")).thenReturn(true);
        when(mockDictionary.isEnglishWord("fat")).thenReturn(true);

        String inputWord = "fat cat";
        List<String> generatedWords = new ArrayList<>();

        WordGenerator generator = new WordGenerator(mockDictionary);
        List<String> results = generator.generateWords(inputWord);
        for (String s : results) {
            generatedWords.add(s);
        }

        Assert.assertEquals(5, generatedWords.size());
    }

    @Test
    public void generateWords_otherThreeLetterWord_returnsCorrectResult() {
        IDictionary mockDictionary = mock(IDictionary.class);
        when(mockDictionary.isEnglishWord("po")).thenReturn(true);
        when(mockDictionary.isEnglishWord("or")).thenReturn(true);
        when(mockDictionary.isEnglishWord("pro")).thenReturn(true);

        List<String> generatedWords = new ArrayList<>();

        String inputWord = "pro";
        WordGenerator generator = new WordGenerator(mockDictionary);
        List<String> results = generator.generateWords(inputWord);
        for (String s : results) {
            generatedWords.add(s);
        }

        Assert.assertEquals(3, generatedWords.size());
    }

    @Test
    public void generateWords_wordWithDupLetters_returnsCorrectResult() {
        IDictionary mockDictionary = mock(IDictionary.class);
        when(mockDictionary.isEnglishWord("a")).thenReturn(true);
        when(mockDictionary.isEnglishWord("ad")).thenReturn(true);
        when(mockDictionary.isEnglishWord("da")).thenReturn(true);
        when(mockDictionary.isEnglishWord("add")).thenReturn(true);
        when(mockDictionary.isEnglishWord("dad")).thenReturn(true);

        List<String> generatedWords = new ArrayList<>();

        String inputWord = "add";
        WordGenerator generator = new WordGenerator(mockDictionary);
        List<String> results = generator.generateWords(inputWord);
        for (String s : results) {
            generatedWords.add(s);
        }

        Assert.assertEquals(5, generatedWords.size());
    }

    @Test
    public void generateWords_fourLetterWord_returnsCorrectResult() {
        IDictionary mockDictionary = mock(IDictionary.class);
        when(mockDictionary.isEnglishWord("cud")).thenReturn(true);
        when(mockDictionary.isEnglishWord("crud")).thenReturn(true);

        List<String> generatedWords = new ArrayList<>();

        String inputWord = "crud";
        WordGenerator generator = new WordGenerator(mockDictionary);
        List<String> results = generator.generateWords(inputWord);
        for (String s : results) {
            generatedWords.add(s);
        }

        Assert.assertEquals(2, generatedWords.size());
    }

    @Test
    public void generateWords_longWord_returnsCorrectResult() {
        IDictionary mockDictionary = mock(IDictionary.class);
        when(mockDictionary.isEnglishWord("i")).thenReturn(true);
        when(mockDictionary.isEnglishWord("or")).thenReturn(true);
        when(mockDictionary.isEnglishWord("in")).thenReturn(true);
        when(mockDictionary.isEnglishWord("ow")).thenReturn(true);
        when(mockDictionary.isEnglishWord("ok")).thenReturn(true);
        when(mockDictionary.isEnglishWord("on")).thenReturn(true);
        when(mockDictionary.isEnglishWord("go")).thenReturn(true);
        when(mockDictionary.isEnglishWord("gi")).thenReturn(true);
        when(mockDictionary.isEnglishWord("ki")).thenReturn(true);
        when(mockDictionary.isEnglishWord("wo")).thenReturn(true);
        when(mockDictionary.isEnglishWord("wok")).thenReturn(true);
        when(mockDictionary.isEnglishWord("kor")).thenReturn(true);
        when(mockDictionary.isEnglishWord("kin")).thenReturn(true);
        when(mockDictionary.isEnglishWord("gin")).thenReturn(true);
        when(mockDictionary.isEnglishWord("wog")).thenReturn(true);
        when(mockDictionary.isEnglishWord("wig")).thenReturn(true);
        when(mockDictionary.isEnglishWord("row")).thenReturn(true);
        when(mockDictionary.isEnglishWord("now")).thenReturn(true);
        when(mockDictionary.isEnglishWord("won")).thenReturn(true);
        when(mockDictionary.isEnglishWord("win")).thenReturn(true);
        when(mockDictionary.isEnglishWord("gor")).thenReturn(true);
        when(mockDictionary.isEnglishWord("org")).thenReturn(true);
        when(mockDictionary.isEnglishWord("gow")).thenReturn(true);
        when(mockDictionary.isEnglishWord("koi")).thenReturn(true);
        when(mockDictionary.isEnglishWord("nog")).thenReturn(true);
        when(mockDictionary.isEnglishWord("nor")).thenReturn(true);
        when(mockDictionary.isEnglishWord("ring")).thenReturn(true);
        when(mockDictionary.isEnglishWord("rink")).thenReturn(true);
        when(mockDictionary.isEnglishWord("king")).thenReturn(true);
        when(mockDictionary.isEnglishWord("wing")).thenReturn(true);
        when(mockDictionary.isEnglishWord("grin")).thenReturn(true);
        when(mockDictionary.isEnglishWord("wink")).thenReturn(true);
        when(mockDictionary.isEnglishWord("wonk")).thenReturn(true);
        when(mockDictionary.isEnglishWord("grow")).thenReturn(true);
        when(mockDictionary.isEnglishWord("worn")).thenReturn(true);
        when(mockDictionary.isEnglishWord("know")).thenReturn(true);
        when(mockDictionary.isEnglishWord("work")).thenReturn(true);
        when(mockDictionary.isEnglishWord("wrong")).thenReturn(true);
        when(mockDictionary.isEnglishWord("grown")).thenReturn(true);
        when(mockDictionary.isEnglishWord("working")).thenReturn(true);

        List<String> generatedWords = new ArrayList<>();

        String inputWord = "working";
        WordGenerator generator = new WordGenerator(mockDictionary);
        List<String> results = generator.generateWords(inputWord);
        for (String s : results) {
            generatedWords.add(s);
        }

        Assert.assertEquals(40, generatedWords.size());
    }
}
