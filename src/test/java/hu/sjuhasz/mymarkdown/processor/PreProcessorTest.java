package hu.sjuhasz.mymarkdown.processor;

import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sanyi on 2014.03.15..
 */
public class PreProcessorTest {

    @Test
    public void testExercises() throws IOException {
        Processor processor = new TwoStageProcessor();
        StringWriter out = new StringWriter();
        Reader in = new InputStreamReader(this.getClass().getResourceAsStream("/exercise.txt"));
        processor.process(in, new OutputStreamWriter(System.out));

        //match("/exercise_expected.txt", new StringReader(out.toString()));
    }


    private void match(String expectedResourceName, Reader in) throws IOException {
        try (InputStream ex = this.getClass().getResourceAsStream(expectedResourceName)) {
            try (BufferedReader bin = new BufferedReader(in);
                 BufferedReader bex = new BufferedReader(new InputStreamReader(ex))) {
                String lineFound = bin.readLine();
                String lineExpected = bex.readLine();
                while (lineFound != null && lineExpected != null) {
                    assertEquals(lineExpected.trim(), lineFound.trim());
                    lineFound = bin.readLine();
                    lineExpected = bex.readLine();
                }
                assertTrue(lineFound == null && lineExpected == null);
            }
        }
    }

}
