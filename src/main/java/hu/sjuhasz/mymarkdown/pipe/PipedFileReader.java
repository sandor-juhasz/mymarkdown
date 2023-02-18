package hu.sjuhasz.mymarkdown.pipe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by Sanyi on 2014.03.20..
 */
public class PipedFileReader extends AbstractPipedStep {

    public PipedFileReader(Reader in) {
        this.in = in;
    }

    @Override
    public String getStepName() {
        return "File reader";
    }

    @Override
    public void run() {
        if (out == null) {
            System.err.println("No sink is connected for "+getStepName());
            return;
        }

        try {
            for (int ch = in.read(); ch != -1; ch=in.read()) {
                out.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                out.close();
            } catch (IOException e) {}
        }
        System.out.println("Reader completed.");
    }
}
