package com.itmo.ctdev.parsing;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author korektur
 *         06/01/2017
 */
public class ParserTest {

    @Test
    public void testGetNextToken() throws Exception {
        String line = "";
        int cnt = 10;
        String expectedToken = "test";
        for (int i = 0; i < cnt; ++i) {
            line += "\"" + expectedToken + "\",";
        }
        line = line.substring(0, line.length() - 1);
        Parser parser = new Parser(line);
        for (int i = 0; i < cnt; i++) {
            Optional<String> nextToken = parser.getNextToken();
            assertTrue(nextToken.isPresent());
            assertEquals(expectedToken, nextToken.get());
        }
    }

    @Test
    public void testGetNextTokenEmpty() {
        String line = "";
        int cnt = 10;
        for (int i = 0; i < cnt; ++i) {
            line += ',';
        }
        line = line.substring(0, line.length() - 1);
        Parser parser = new Parser(line);
        for (int i = 0; i < cnt; i++) {
            Optional<String> nextToken = parser.getNextToken();
            assertFalse(nextToken.isPresent());
        }
    }

    @Test
    public void testGetNextArrayToken() {
        String line = "\"[ ";
        int cnt = 10;
        String expectedToken = "test";
        for (int i = 0; i < cnt; i++) {
            line += expectedToken + ',';
        }
        line = line.substring(0, line.length() - 1) + " ]\"";
        Parser parser = new Parser(line);
        List<String> nextArrayToken = parser.getNextArrayToken();
        assertEquals(cnt, nextArrayToken.size());
        for (int i = 0; i < cnt; i++) {
            assertEquals(expectedToken, nextArrayToken.get(i));
        }
    }

    @Test
    public void testGetNextArrayTokenEmpty() {
        String line = "\"[  ]\",\"[  ]\",,";
        Parser parser = new Parser(line);
        List<String> nextArrayToken = parser.getNextArrayToken();
        assertEquals(0, nextArrayToken.size());
        nextArrayToken = parser.getNextArrayToken();
        assertEquals(0, nextArrayToken.size());
        nextArrayToken = parser.getNextArrayToken();
        assertEquals(0, nextArrayToken.size());
        nextArrayToken = parser.getNextArrayToken();
        assertEquals(0, nextArrayToken.size());
    }
}