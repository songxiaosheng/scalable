package com.slicingflow.flow;


import com.slicingflow.process.Processor;
import com.slicingflow.sink.Sink;
import com.slicingflow.source.Source;


/**
 *
 * @author songxiaosheng
 */
public interface Flow {


    /**
     * @return
     */
    Flow source(Source source);

    /**
     * @return
     */
    Flow process(Processor process);

    /**
     *
     */
    Sink sink();
}
