package hu.sjuhasz.mymarkdown.processor.plugins;

import org.markdown4j.Markdown4jProcessor;
import org.markdown4j.Plugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Sanyi on 2014.03.16..
 */
public class ExamplePlugin extends Plugin {

    public ExamplePlugin() {
        super("exercise");
    }

    @Override
    public void emit(StringBuilder stringBuilder, List<String> strings, Map<String, String> stringStringMap) {
        System.out.println("Example plugin.");
        StringBuilder question = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        StringBuilder actual=question;
        for (String l : strings) {
            String line = l;
            if (line.equals("===")) {
                actual=answer;
            } else {
                actual.append(line);
                actual.append("\n");
            }
        }

        Markdown4jProcessor p = new Markdown4jProcessor();
        p.addStyleClass("prettyprint", "pre");
        p.addHtmlAttribute("stlye", "prettyprint", "pre");
        stringBuilder.append("<div class=\"exercise\">\n");
        stringBuilder.append("<div class=\"question\">\n");
        try {
            String answerText = p.process(question.toString());
            System.out.println(answerText);
            answerText=answerText.substring(3,answerText.length()-5);
            stringBuilder.append(answerText);
        } catch (IOException e) {
            stringBuilder.append("ERROR");
            e.printStackTrace();
        }
        stringBuilder.append("</div>\n");
        stringBuilder.append("<div class=\"answer\">\n");
        try {
            stringBuilder.append(p.process(answer.toString()));
        } catch (IOException e) {
            stringBuilder.append("ERROR");
            e.printStackTrace();
        }
        stringBuilder.append("</div>\n");
        stringBuilder.append("</div>\n");
    }
}

/*
      <div class="exercise">
        <div class="question">
            Set your name and email address for the current git
            repository.
        </div>
        <div class="answer">
           <p>You need to execute the following commands:</p>
           <pre class="prettyprint"><code lang="bash">git configure email sandor.juhasz@n.com
git configure name Sándor Juhász</code></pre>
        </div>
      </div>
 */
