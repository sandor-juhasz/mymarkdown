package hu.sjuhasz.mymarkdown.processor;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Created by Sanyi on 2014.03.15..
 */
public class MockProcessor extends AbstractProcessor {

    private String inputFilename;

    @Override
    public void process(String inputFilename) throws IOException {
        this.inputFilename = inputFilename;
        super.process(inputFilename);
    }

    @Override
    public void process(Reader in, Writer out) {

    }

    public String getInputFilename() {
        return inputFilename;
    }
}
