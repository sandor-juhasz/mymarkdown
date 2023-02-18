package hu.sjuhasz.mymarkdown.processor;

import hu.sjuhasz.mymarkdown.pipe.AbstractPipedStep;
import hu.sjuhasz.mymarkdown.pipe.PipedFileReader;
import hu.sjuhasz.mymarkdown.pipe.PipedFileWriter;
import hu.sjuhasz.mymarkdown.pipe.PipedProcessor;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Created by Sanyi on 2014.03.20..
 */
public class MultiStageProcessor extends AbstractProcessor {

    private AbstractProcessor[] processors;

    public MultiStageProcessor(AbstractProcessor ... processors) {
        this.processors = processors;
    }

    @Override
    public void process(Reader in, Writer out) throws IOException {
        try {
            PipedFileReader reader=new PipedFileReader(in);
            AbstractPipedStep last = reader;
            for (AbstractProcessor p : processors) {
                AbstractPipedStep processorStep = new PipedProcessor(p);
                last.connect(processorStep);
                last = processorStep;
            }
            PipedFileWriter writer=new PipedFileWriter(out);
            last.connect(writer);

            Thread t = reader.startChain();
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
