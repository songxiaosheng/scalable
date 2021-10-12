package com.slicingflow.process;

import com.slicingflow.sink.GenericSink;
import com.slicingflow.sink.Sink;
import com.slicingflow.sink.factory.ReflectionSinkFactory;
import com.slicingflow.sink.factory.ReflectionSinkMeta;
import com.slicingflow.sink.factory.SinkFactory;
import com.slicingflow.source.Source;

public class AvgProcess extends AbstractProcessor{

    @Override
    public Sink process(Source source) {
        SinkFactory sinkFactory = new ReflectionSinkFactory();
        Sink sink = sinkFactory.createSink(new ReflectionSinkMeta<>(GenericSink.class));
        return sink;
    }
}
