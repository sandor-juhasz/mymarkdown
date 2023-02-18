package hu.sjuhasz.mymarkdown.processor;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Created by Sanyi on 2014.03.15..
 */
public class IdentityProcessor extends AbstractProcessor {
    @Override
    public void process(Reader in, Writer out) throws IOException {
        int ch =in.read();
        while (ch != -1 ) {
            out.write(ch);
            ch = in.read();
        }
    }
}
