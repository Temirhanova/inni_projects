package ru.innopolis.stc13.threads.threadPoll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class FindWordTaskTest {
    private List<String> resultList;
    private String source;
    private String[] words;
    private Runnable runnable = Mockito.mock(Runnable.class);
    private final static String FIRST_SENTENCE = "Doing test";
    private FindWordTask findWordTask;
    private final static String FILE_ANY = "E:\\JAVA Innopolis\\5. потоки\\threads\\src\\main\\java\\ru\\innopolis\\stc13\\threads\\threadPoll\\result\\file1.txt";

    @BeforeEach
    void beforeEach() {
        findWordTask = new FindWordTask(resultList, source, words);
    }

    @Test
    void runNullTest() {

    }

    @Test
    void checkWordInSentenceTrueTest() {
        boolean result = findWordTask.checkWordInSentence(FIRST_SENTENCE, "test");
        assertTrue(true);
    }

    @Test
    void checkWordInSentenceFalseTest() {
        boolean resulr = findWordTask.checkWordInSentence(FIRST_SENTENCE, "hhh");
        assertTrue(false);
    }
}