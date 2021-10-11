package com.slicingflow.flow;


import com.slicingflow.pipeline.Pipeline;
import com.slicingflow.process.Processor;
import com.slicingflow.sink.Sink;
import com.slicingflow.source.Source;

/**
 * @author songxiaosheng
 */
public abstract class AbstractFlow implements Flow {

    /**
     * source need to be handle
     */
    private Source source;

    /**
     * source process pipeline
     */
    private Pipeline pipeline;

    /**
     * source handle result
     */
    private Sink sink;

    @Override
    public Flow source(Source source) {
        this.source = source;
        return this;
    }

    @Override
    public Flow process(Processor processor) {
        sink = processor.process(source);
        return this;
    }

    @Override
    public Sink sink() {

        return sink;
    }
}
