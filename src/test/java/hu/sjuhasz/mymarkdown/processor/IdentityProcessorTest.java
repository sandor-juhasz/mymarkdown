package hu.sjuhasz.mymarkdown.processor;

import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sanyi on 2014.03.15..
 */
public class IdentityProcessorTest {

    @Test
    public void testProcess() throws Exception {
        StringReader in = new StringReader("test");
        StringWriter out = new StringWriter();

        new IdentityProcessor().process(in, out);
        assertEquals("test", out.toString());
    }
}
