package hu.sjuhasz.mymarkdown.processor;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sanyi on 2014.03.16..
 */
public class PageTemplateProcessor extends AbstractProcessor {

    private String pageTemplateFileName;
    private Processor contentProcessor;
    //private List<String> staticFiles = Arrays.asList("style.css");
    private List<String> staticFiles = new ArrayList<>();

    public PageTemplateProcessor(String pageTemplateFileName, Processor contentProcessor) {
        this.pageTemplateFileName= pageTemplateFileName;
        this.contentProcessor = contentProcessor;
    }

    @Override
    public void process(Reader in, Writer o) throws IOException {
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(pageTemplateFileName)) {
            if (is == null) {
                throw new IOException("Cannot find template in classpath: "+pageTemplateFileName);
            }
            try (Reader fileReader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
                try (PrintWriter out = new PrintWriter(o)) {
                    try (BufferedReader pageTemplate = new BufferedReader(fileReader)) {
                        String line = pageTemplate.readLine();
                        while (line != null && !line.trim().equals("<<CONTENT>>")) {
                            out.println(line);
                            line = pageTemplate.readLine();
                        }
                        if (line != null && line.trim().equals("<<CONTENT>>")) {
                            contentProcessor.process(in, out);
                            line = pageTemplate.readLine();
                        }
                        while (line != null) {
                            out.println(line);
                            line = pageTemplate.readLine();
                        }
                    }
                }
            }                
        }
        createStaticFiles();
    }

    private void createStaticFiles() throws IOException {
        for (String staticFile : staticFiles) {
            createStaticFile(staticFile);
        }
    }

    private void createStaticFile(String staticFile) throws IOException {
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(staticFile)) {
            if (is == null) {
                throw new IOException("Cannot find static file in classpath: "+staticFile);
            }
            try (FileOutputStream out = new FileOutputStream(staticFile)) {
                out.write(is.readAllBytes());
            }
        }
    }
}
