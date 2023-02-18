package hu.sjuhasz.mymarkdown.processor;

import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sanyi on 2014.03.15..
 */
public class SimpleProcessorTest {

    @Test
    public void testProcessing() throws Exception {
        Processor p = new SimpleMarkdownProcessor();
        StringWriter out = new StringWriter();
        p.process(new StringReader("Hello *world*"), out);
        assertEquals("<p>Hello <em>world</em></p>", out.toString().trim());
    }
}
