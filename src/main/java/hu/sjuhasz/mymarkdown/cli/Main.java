package hu.sjuhasz.mymarkdown.cli;

import hu.sjuhasz.mymarkdown.env.ServiceLocator;
import hu.sjuhasz.mymarkdown.processor.Processor;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Sándor Juhász on 2014.03.15.
 */
public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        String inputFilename = null;
        if (args.length == 1) {
            inputFilename = args[0];
            System.out.println(inputFilename);
            Processor p = ServiceLocator.getProcessor();
            try {
                p.process(inputFilename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } if (args.length ==2 ) {
            inputFilename = args[0];
            String outputFile = args[1];
            Processor p = ServiceLocator.getProcessor();
            try {
                p.process(inputFilename, outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
