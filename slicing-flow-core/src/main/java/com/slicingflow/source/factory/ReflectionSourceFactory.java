package com.slicingflow.source.factory;

import com.slicingflow.process.Processor;
import com.slicingflow.process.factory.ProcessorMeta;
import com.slicingflow.process.factory.ReflectionProcessorMeta;
import com.slicingflow.source.Source;

/**
 * @author songxiaosheng
 */
public class ReflectionSourceFactory extends AbstractSourceFactory{
    @Override
    public Source createSource(SourceMeta sourceMeta) {
        try {
            if (!(sourceMeta instanceof ReflectionSourceMeta)) {
                throw new IllegalArgumentException("processorMeta is not instance of ReflectionProcessorMeta ");
            }
            ReflectionSourceMeta<Source> reflectionProcessorMeta = (ReflectionSourceMeta<Source>) sourceMeta;
            return reflectionProcessorMeta.getSourceClass().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
//            logger.error("");
//            throw new
        }

        return null;
    }
}
