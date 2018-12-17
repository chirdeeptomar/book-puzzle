package com.connectt.puzzle;

import org.junit.jupiter.api.Test;

import static com.connectt.puzzle.services.CryptographyService.decrypt;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CryptographyServiceTests {


    @Test
    void decrypt_none() {
        String result = decrypt("abc", 0);
        assertEquals("abc", result);
    }

    @Test
    void decrypt_simple() {
        String result = decrypt("def", 3);
        assertEquals("abc", result);
    }

    @Test
    void decrypt_mixed_case() {
        String result = decrypt("dEf", 3);
        assertEquals("aBc", result);
    }

    @Test
    void decrypt_wrap() {
        String result = decrypt("abc", 3);
        assertEquals("xyz", result);
    }
}
