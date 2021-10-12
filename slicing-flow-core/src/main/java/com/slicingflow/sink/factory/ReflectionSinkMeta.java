package com.slicingflow.sink.factory;


import com.slicingflow.sink.Sink;

/**
 * @author songxiaosheng
 */
public class ReflectionSinkMeta<Sink> implements SinkMeta {
    private Class<Sink> sinkClass;

    public ReflectionSinkMeta(Class<Sink> sinkClass) {
        this.sinkClass = sinkClass;
    }

    public Class<Sink> getSinkClass() {
        return sinkClass;
    }

    public void setSinkClass(Class<Sink> sinkClass) {
        this.sinkClass = sinkClass;
    }
}
