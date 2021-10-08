package com.slicingflow.flow;


import com.slicingflow.sink.Sink;

import javax.annotation.processing.Processor;
import java.nio.channels.Pipe;

/**
 *
 * @author songxiaosheng
 */
public interface Flow {


    /**
     * @return
     */
    Flow source();

    /**
     * @return
     */
    Flow process();

    /**
     *
     */
    void sink();
}
