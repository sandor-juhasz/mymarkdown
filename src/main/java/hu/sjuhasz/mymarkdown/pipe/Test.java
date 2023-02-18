package hu.sjuhasz.mymarkdown.pipe;

import hu.sjuhasz.mymarkdown.processor.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Sanyi on 2014.03.20..
 */
public class Test {

    public static void main(String[] args) throws Exception {
        try (FileReader in  = new FileReader("c:\\Users\\Sanyi\\Documents\\My Dropbox\\OCPJP\\io_fundamentals.md");
             FileWriter out = new FileWriter("c:\\Temp\\io_fundamentals.md.out")) {
            Processor p = new PageTemplateProcessor(
                                "C:\\Users\\Sanyi\\Documents\\My Dropbox\\OCPJP\\template.html" ,
                                new MultiStageProcessor(
                                    new PreProcessor(),
                                    new ExtendedMarkdownProcessor(),
                                    new PostProcessor()));
            p.process(in, out);
        }
    }

}
