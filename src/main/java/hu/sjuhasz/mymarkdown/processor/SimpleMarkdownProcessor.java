package hu.sjuhasz.mymarkdown.processor;

import org.markdown4j.Markdown4jProcessor;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by Sanyi on 2014.03.15..
 */
public class SimpleMarkdownProcessor extends AbstractProcessor {
    @Override
    public void process(Reader in, Writer out) throws IOException {
        String output = new Markdown4jProcessor().process(in);
        out.write(output);
    }
}
