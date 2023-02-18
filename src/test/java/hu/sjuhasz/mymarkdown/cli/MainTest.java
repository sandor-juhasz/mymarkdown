package hu.sjuhasz.mymarkdown.cli;

import hu.sjuhasz.mymarkdown.env.ServiceLocator;
import hu.sjuhasz.mymarkdown.processor.MockProcessor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sanyi on 2014.03.15..
 */
public class MainTest {

    @Test
    public void testCallingWithFilename() {
        String filename = "testme.txt";
        MockProcessor processor = new MockProcessor();
        ServiceLocator.setProcessor(processor);
        Main.main(new String[] { filename });
        assertEquals(filename, processor.getInputFilename());
    }
}
