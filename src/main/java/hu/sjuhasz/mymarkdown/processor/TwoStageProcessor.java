package hu.sjuhasz.mymarkdown.processor;

import java.io.*;

/**
 * Created by Sanyi on 2014.03.16..
 */
public class TwoStageProcessor extends AbstractProcessor {
    @Override
    public void process(Reader in, Writer out) throws IOException {

        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        PreProcessor pp = new PreProcessor();
        try (OutputStreamWriter oo = new OutputStreamWriter(buf)) {
            pp.process(in, oo);
        }

        byte[] array = buf.toByteArray();

        ByteArrayInputStream in2 = new ByteArrayInputStream(array);
        ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
        try (InputStreamReader rr = new InputStreamReader(in2);
             OutputStreamWriter oo = new OutputStreamWriter(buf2)) {
            ExtendedMarkdownProcessor p = new ExtendedMarkdownProcessor();
            p.process(rr, oo);
        }

        byte[] array2 = buf2.toByteArray();
        ByteArrayInputStream in3 = new ByteArrayInputStream(array2);
        try (InputStreamReader rr = new InputStreamReader(in3)) {
            PostProcessor p = new PostProcessor();
            p.process(rr, out);
        }
    }
}
