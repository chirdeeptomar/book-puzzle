package com.connectt.puzzle;

import com.connectt.puzzle.data.DataAccess;
import com.connectt.puzzle.models.Body;
import com.connectt.puzzle.models.Crypt;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataAccessTests {

    private DataAccess dataAccess = new DataAccess();

    @Test
    void read_body_table() {
        Stream<Body> list = dataAccess.getBody();
        assertEquals(1, list.findFirst().get().getId());
    }

    @Test
    void read_crypt_table() {
        Stream<Crypt> crypts = dataAccess.getCrypt();
        Crypt crypt = crypts.findFirst().get();

        assertEquals(1, crypt.getStart());
        assertEquals(4, crypt.getLength());
        assertEquals(8, crypt.getRotate());
    }
}
