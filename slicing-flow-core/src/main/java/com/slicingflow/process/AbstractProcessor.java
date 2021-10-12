package com.slicingflow.process;

import com.slicingflow.sink.Sink;
import com.slicingflow.sink.factory.SinkFactory;
import com.slicingflow.source.Source;

/**
 * @author songxiaosheng
 */
public abstract class AbstractProcessor implements Processor {
    @Override
    public Sink process(Source source) {

        return null;
    }
}

