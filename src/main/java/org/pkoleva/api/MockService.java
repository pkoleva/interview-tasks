package org.pkoleva.api;

import java.io.IOException;
import java.util.Random;

public class MockService {

    public int execute() throws IOException{
        Random random = new Random();

        if (random.nextDouble() < 0.3) {
            throw new IOException("Random failure occurred.");
        }
        return random.nextInt(1200)+1;

    }
}
