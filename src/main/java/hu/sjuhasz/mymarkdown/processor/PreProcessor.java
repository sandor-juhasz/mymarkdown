package hu.sjuhasz.mymarkdown.processor;

import java.io.*;

/**
 * Created by Sanyi on 2014.03.15..
 */
public class PreProcessor extends AbstractProcessor {

    @Override
    public void process(Reader in, Writer o) throws IOException {
        try (LineNumberReader bin = new LineNumberReader(in);
              PrintWriter out = new PrintWriter(o)) {
            try {
                String line = bin.readLine();
                while (line != null) {
                    if (line.trim().startsWith("exercise")) {
                        out.println("%%%exercise");
                        line=bin.readLine();
                        while (!line.trim().equals("")) {
                            out.println(line.trim());
                            line=bin.readLine();
                        }
                        out.println("===");
                        line=bin.readLine();
                        while (line.trim().equals("") || Character.isWhitespace(line.charAt(0))) {
                            String formattedLine=line.replace("\t", "    ");
                            if (formattedLine.length()>4)
                                formattedLine=formattedLine.substring(4);
                            out.println(formattedLine);
                            line=bin.readLine();
                        }
                        out.println("%%%");
                    } else {
                        out.println(line);
                        line=bin.readLine();
                    }
                }
            }catch (Exception e) {
                System.out.println("Error at line "+bin.getLineNumber());
                e.printStackTrace();
            }
        }
    }
}
