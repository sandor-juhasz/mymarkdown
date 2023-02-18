package hu.sjuhasz.mymarkdown.pipe;

import java.io.*;

/**
 * Created by Sanyi on 2014.03.20..
 */
public abstract class AbstractPipedStep implements Runnable {

    protected Reader in;
    protected Writer out;

    protected AbstractPipedStep next;

    public abstract String getStepName();

    public PipedReader getSink() {
        return (PipedReader)in;
    }

    public AbstractPipedStep connect(AbstractPipedStep next) throws IOException {
        this.next=next;
        out=new PipedWriter(next.getSink());
        return next;
    }

    public String getPipeString() {
        return getStepName()+ ( next != null ? " | " + next.getPipeString() : "" );
    }

    public Thread startChain() {
        Thread toWaitFor=null;
        if (next != null) {
            toWaitFor = next.startChain();
        }
        Thread t = new Thread(this);
        if (toWaitFor == null) {
            System.out.println("Waiting for "+getStepName());
            toWaitFor = t;
        }
        t.start();
        return toWaitFor;
    }
}
