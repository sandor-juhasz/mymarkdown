package hu.sjuhasz.mymarkdown.processor;

import java.io.*;

/**
 * Created by Sanyi on 2014.03.20..
 */
public class PostProcessor extends AbstractProcessor {

    @Override
    public void process(Reader in, Writer out) throws IOException {
        System.out.println("Post processor");
        try (BufferedReader i = new BufferedReader(in);
             PrintWriter o = new PrintWriter(out)) {
            String line = i.readLine();
            while (line != null ) {
                line=line.replace("<br  />", "");
                line=line.replace("<pre>", "<pre class=\"prettyprint\">");
                o.println(line);
                line=i.readLine();
            }
        }
    }

}
