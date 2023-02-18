package hu.sjuhasz.mymarkdown.pipe;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PipedReader;
import java.io.Writer;

/**
 * Created by Sanyi on 2014.03.20..
 */
public class PipedFileWriter extends AbstractPipedStep {

    public PipedFileWriter(Writer out) {
        this.out=out;
        in=new PipedReader();
    }

    @Override
    public String getStepName() {
        return "PipedFileWriter";
    }

    @Override
    public void run() {
        if (in == null) {
            System.out.println("In is null for "+getStepName());
        }
        try {
            for (int ch=in.read(); ch != -1; ch=in.read()) {
                out.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {}
        }
    }
}
