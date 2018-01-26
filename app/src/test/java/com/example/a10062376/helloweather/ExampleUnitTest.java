package com.example.a10062376.helloweather;

import com.example.a10062376.helloweather.utils.CharacterParser;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        String strs = CharacterParser.getInstance().getSelling("北京是首都");
        System.out.println("词组转换为拼音："+strs);

        String string = CharacterParser.getInstance().convert("南");
        System.out.println("单字转换为拼音："+string);

    }
}