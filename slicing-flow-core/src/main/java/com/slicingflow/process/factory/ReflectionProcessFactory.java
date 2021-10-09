package com.slicingflow.process.factory;

import com.slicingflow.process.Processor;

public class ReflectionProcessFactory<T> extends AbstractProcessFactory{
//    private final Logger logger = LoggerFactory.getLogger(ReflectionProcessFactory.class);
    public Processor createProcessor(Class<Processor> tClass){
        try {
            return tClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
//            logger.error("");
//            throw new
        }

        return null;
    }
}
