package hu.sjuhasz.mymarkdown.processor;

import hu.sjuhasz.mymarkdown.processor.plugins.ExamplePlugin;
import org.markdown4j.Markdown4jProcessor;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Created by Sanyi on 2014.03.16..
 */
public class ExtendedMarkdownProcessor extends AbstractProcessor {
    @Override
    public void process(Reader in, Writer out) throws IOException {
        Markdown4jProcessor p = new Markdown4jProcessor();
        p.registerPlugins(new ExamplePlugin());
        String output = p.process(in);
        out.write(output);
        out.flush();
    }

}
