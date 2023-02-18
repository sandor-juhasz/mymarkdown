package hu.sjuhasz.mymarkdown.processor;

import java.io.*;

/**
 * Created by Sanyi on 2014.03.15..
 */
public abstract class AbstractProcessor implements Processor {

    @Override
    public void process(String inputFilename) throws IOException {
        process(inputFilename, null);
    }


    @Override
    public void process(String inputFilename, String outputFilename) throws IOException {
        Reader in = null;
        Writer out = null;
        try {
            in = inputFilename != null ? new FileReader(inputFilename) : new InputStreamReader(System.in);
            out = outputFilename != null ? new FileWriter(outputFilename) : new OutputStreamWriter(System.out);

            process(in, out);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {}
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {}
            }
        }
    }

    @Override
    public abstract void process(Reader in, Writer out) throws IOException;
}
