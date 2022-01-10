package com.damian.virtualtrattoria.service;

import com.damian.virtualtrattoria.service.impl.TextServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Class with tests for text's service. It uses parameterized tests.
 *
 * @author Damian
 * @version 1.0
 * @since 05.01.2022
 */
@Suite
@SuiteDisplayName("Input Text Service's Test")
public class TextServiceTest {

    private final TextService textService = new TextServiceImpl();
    private final String text1 = "test1 TEST2 Test3 tEST4 5";
    private final String text2 = "";

    //convertTextToValidFormat - positive
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6, 10, 11, 12, 13, 14, 15, 16, 17, 22, 23, 24 })
    public void shouldReturnEquals_ForConvertTextToValidFormat_WhenSingsNotChangedAreChecked(int position) {
        //given
        String convertedText = textService.convertTextToValidFormat(text1);
        //when
        char reference = text1.charAt(position);
        char result = convertedText.charAt(position);
        //then
        assertEquals(reference, result);
    }

    @ParameterizedTest
    @ValueSource(ints = { 7, 8, 9, 19, 20, 21 })
    public void shouldReturnEquals_ForConvertTextToValidFormat_WhenSingsChangedToSmallAreChecked(int position) {
        //given
        String convertedText = textService.convertTextToValidFormat(text1);
        //when
        char reference = text1.charAt(position);
        char result = convertedText.charAt(position);
        //then
        assertEquals(reference + 32, result);
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 18 })
    public void shouldReturnEquals_ForConvertTextToValidFormat_WhenSingsChangedToGreatAreChecked(int position) {
        //given
        String convertedText = textService.convertTextToValidFormat(text1);
        //when
        char reference = text1.charAt(position);
        char result = convertedText.charAt(position);
        //then
        assertEquals(reference - 32, result);
    }

    //convertTextToValidFormat - negative
    @Test
    public void shouldThrowsException_ForConvertTextToValidFormat_WhenThereAreNoSigns() {
        //given
        //when
        //then
        assertThrows(StringIndexOutOfBoundsException.class, () -> textService.convertTextToValidFormat(text2));
    }

}
