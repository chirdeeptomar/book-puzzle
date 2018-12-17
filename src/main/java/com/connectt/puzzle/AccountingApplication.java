package com.connectt.puzzle;

import com.connectt.puzzle.data.DataAccess;
import com.connectt.puzzle.models.Body;
import com.connectt.puzzle.models.Crypt;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static com.connectt.puzzle.services.CryptographyService.decrypt;

public class AccountingApplication {

    // Should be ideally injection through IoC
    private DataAccess dataAccess;

    private Map<Integer, Integer> rotateMap;

    private AccountingApplication() {
        dataAccess = new DataAccess();
        rotateMap = new HashMap<>();
    }

    public static void main(String[] args) {
        AccountingApplication application = new AccountingApplication();
        System.out.println(application.read());
        application.shutdown();
    }

    private void shutdown() {
        dataAccess.close();
    }

    private String read() {
        Map<Integer, Integer> rotation = getRotation();
        Stream<Body> bodyStream = dataAccess.getBody();

        StringBuilder text = new StringBuilder();

        bodyStream.map(body -> decrypt(body.getText(), rotation.get(body.getId())))
                .forEach(text::append);
        return text.toString();
    }

    private Map<Integer, Integer> getRotation() {
        Stream<Crypt> cryptStream = dataAccess.getCrypt();

        cryptStream.forEach(crypt -> {
            for (int i = 0; i < crypt.getLength(); i++) {
                rotateMap.put(crypt.getStart() + i, crypt.getRotate());
            }
        });

        return rotateMap;
    }
}
