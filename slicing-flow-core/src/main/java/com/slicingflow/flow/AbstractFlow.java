package com.slicingflow.flow;


import com.slicingflow.pipeline.Pipeline;
import com.slicingflow.sink.Sink;
import com.slicingflow.source.Source;

/**
 * @author songxiaosheng
 */
public abstract class AbstractFlow implements Flow{

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
}
