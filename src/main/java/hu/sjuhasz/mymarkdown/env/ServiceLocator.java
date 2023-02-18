package hu.sjuhasz.mymarkdown.env;

import hu.sjuhasz.mymarkdown.processor.*;

/**
 * Created by Sanyi on 2014.03.15..
 */
public class ServiceLocator {
    private static Processor processor = new PageTemplateProcessor(
            "template.html" ,
            new MultiStageProcessor(
                    new PreProcessor(),
                    new ExtendedMarkdownProcessor(),
                    new PostProcessor()));

    public static Processor getProcessor() {
        return processor;
    }

    public static void setProcessor(Processor processor) {
        ServiceLocator.processor = processor;
    }
}
