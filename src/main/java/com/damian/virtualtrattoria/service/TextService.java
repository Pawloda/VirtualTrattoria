package com.damian.virtualtrattoria.service;

/**
 * Class contains methods for converting the text to proper format.
 *
 * @author Damian
 * @version 1.0
 * @since 05.01.2022
 */
public interface TextService {

    /**
     * Method takes from user text. For every word it makes first letter great other letters small.
     *
     * @return text in string.
     */
    String convertTextToValidFormat(String text);

}
