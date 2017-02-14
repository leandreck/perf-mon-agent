package de.leandreck.bob.perfmonagent;

import java.lang.instrument.Instrumentation;

/**
 * Created by grebe on 29.01.2017.
 */
public class Stuart {

    /**
     * Configure collector agent and add instrumentation.
     *
     * @param args
     * @param instrumentation
     */
    public static void premain(String args, Instrumentation instrumentation){
        ClassLogger transformer = new ClassLogger();
        instrumentation.addTransformer(transformer);
    }

}
