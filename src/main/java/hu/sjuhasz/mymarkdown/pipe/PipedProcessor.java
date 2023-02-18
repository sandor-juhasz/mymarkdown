package hu.sjuhasz.mymarkdown.pipe;

import hu.sjuhasz.mymarkdown.processor.Processor;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PipedReader;
import java.io.Writer;

/**
 * Created by Sanyi on 2014.03.20..
 */
public class PipedProcessor extends AbstractPipedStep {

    private Processor processor;

    public PipedProcessor(Processor processor) {
        this.processor = processor;
        in=new PipedReader();
    }

    @Override
    public String getStepName() {
        return "PipedProcessor";
    }

    @Override
    public void run() {
        if (in == null) {
            System.err.println("Input stream is null for "+getStepName());
            return;
        }
        if (out == null) {
            System.err.println("OutputStream is null for "+getStepName());
            return;
        }

        try {
            try {
                try (Writer w = new OutputStreamWriter(System.out)) {
                    processor.process(in, out);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {  // Close all the Piped Streams used in this thread.
            try {
                in.close();
            } catch (IOException e) {}
            try {
                out.close();
            } catch (IOException e) {}
        }
    }
}
