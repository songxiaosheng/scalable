package com.slicingflow.sink.factory;

import com.slicingflow.sink.Sink;

/**
 * @author songxiaosheng
 */
public interface SinkFactory {

    /**
     * @param sinkMeta
     * @return
     */
    Sink createSink(SinkMeta sinkMeta);
}

