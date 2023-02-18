package hu.sjuhasz.mymarkdown.env;

import hu.sjuhasz.mymarkdown.processor.MockProcessor;
import hu.sjuhasz.mymarkdown.processor.Processor;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Sanyi on 2014.03.15..
 */
public class ServiceLocatorTest {

    @Test
    public void testDefaultProcessor() {
        Processor p = ServiceLocator.getProcessor();
        assertNotNull("Processor is null", p);
    }

    @Test
    public void testOverrideDefaultProcessor() {
        Processor p=new MockProcessor();
        ServiceLocator.setProcessor(p);
        Processor p2 = ServiceLocator.getProcessor();
        assertEquals("Not the same processor was returned.", p, p2);
    }

}
