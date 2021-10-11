package com.slicingflow.process.factory;

import com.slicingflow.process.Processor;

/**
 * @author songxiaosheng
 */
public class ReflectionProcessorFactory<T> extends AbstractProcessorFactory {
    //    private final Logger logger = LoggerFactory.getLogger(ReflectionProcessFactory.class);
    @Override
    public Processor createProcessor(ProcessorMeta processorMeta) {
        try {
            if (!(processorMeta instanceof ReflectionProcessorMeta)) {
                throw new IllegalArgumentException("processorMeta is not instance of ReflectionProcessorMeta ");
            }
            ReflectionProcessorMeta<Processor> reflectionProcessorMeta = (ReflectionProcessorMeta<Processor>) processorMeta;
            return reflectionProcessorMeta.getProcessClass().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
//            logger.error("");
//            throw new
        }

        return null;
    }
}
