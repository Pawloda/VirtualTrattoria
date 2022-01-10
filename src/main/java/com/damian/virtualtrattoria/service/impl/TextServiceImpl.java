package com.damian.virtualtrattoria.service.impl;

import com.damian.virtualtrattoria.service.TextService;

import java.util.Locale;

/**
 * Class implements interface of text's service.
 *
 * @author Damian
 * @version 1.0
 * @since 05.01.2022
 */
public class TextServiceImpl implements TextService {

    @Override
    public String convertTextToValidFormat(String text) {
        text = convertFirstLetterToGreatLetter(text);
        return convertEveryFirstLetterAfterSpaceToGreatLetter(text);
    }

    /**
     * Method makes first letter great other letters small.
     *
     * @return text in string.
     */
    private String convertFirstLetterToGreatLetter(String text) {
        text = text.toLowerCase(Locale.ROOT);
        String temp = text.substring(0, 1).toUpperCase();
        text = text.substring(1);
        return temp + text;
    }

    /**
     * Method makes every first letter after space great.
     *
     * @return text in string.
     */
    private String convertEveryFirstLetterAfterSpaceToGreatLetter(String text) {
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == ' ' && text.charAt(i + 1) >= 97 && text.charAt(i + 1) <= 122) {
                String front = text.substring(0, i+1);
                String letter = text.substring(i+1, i + 2).toUpperCase();
                String back = text.substring(i + 2);
                text = front + letter + back;
            }
        }
        return text;
    }

}
