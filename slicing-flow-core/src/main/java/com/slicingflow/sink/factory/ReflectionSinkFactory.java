package com.slicingflow.sink.factory;

import com.slicingflow.process.Processor;
import com.slicingflow.process.factory.ProcessorMeta;
import com.slicingflow.process.factory.ReflectionProcessorMeta;
import com.slicingflow.sink.Sink;

/**
 * @author songxiaosheng
 */
public class ReflectionSinkFactory extends AbstractSinkFactory{
    @Override
    public Sink createSink(SinkMeta sinkMeta) {
        try {
            if (!(sinkMeta instanceof ReflectionSinkMeta)) {
                throw new IllegalArgumentException("sinkMeta is not instance of ReflectionSinkMeta ");
            }
            ReflectionSinkMeta<Sink> reflectionProcessorMeta = (ReflectionSinkMeta<Sink>) sinkMeta;
            return reflectionProcessorMeta.getSinkClass().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
//            logger.error("");
//            throw new
        }

        return null;
    }
}
