package hu.sjuhasz.mymarkdown.processor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Created by Sanyi on 2014.03.15..
 */
public interface Processor {

    void process(String inputFilename) throws IOException;
    void process(String inputFilename, String outputFilename) throws IOException;
    void process(Reader in, Writer out) throws IOException;
}
