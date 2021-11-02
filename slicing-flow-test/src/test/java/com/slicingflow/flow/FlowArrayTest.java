package com.slicingflow.flow;

import com.slicingflow.flow.factory.FlowFactory;
import com.slicingflow.flow.factory.SlicingFlowFactory;
import com.slicingflow.process.AvgProcess;
import com.slicingflow.process.Processor;
import com.slicingflow.process.factory.ProcessorFactory;
import com.slicingflow.process.factory.ReflectionProcessorFactory;
import com.slicingflow.process.factory.ReflectionProcessorMeta;
import com.slicingflow.sink.Sink;
import com.slicingflow.source.ArraySource;
import com.slicingflow.source.CollectionSource;
import com.slicingflow.source.Source;
import com.slicingflow.source.factory.ReflectionSourceFactory;
import com.slicingflow.source.factory.ReflectionSourceMeta;
import com.slicingflow.source.factory.SourceFactory;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FlowArrayTest {
    /**
     * Split a large array into multiple small arrays
     */
    @Test
    public void sliceArray(){
        FlowFactory flowFactory = new SlicingFlowFactory();
        Flow flow = flowFactory.createFlow();
        ProcessorFactory processorFactory = new ReflectionProcessorFactory();
        SourceFactory sourceFactory = new ReflectionSourceFactory();
        Source source = sourceFactory.createSource(new ReflectionSourceMeta<>(ArraySource.class));
        source.setSource(new int[]{1,2,3,4,5,6,7,8,9});

        Processor processor = processorFactory.createProcessor(new ReflectionProcessorMeta<>(AvgProcess.class));
        Map<String,Object> map = new HashMap();
        map.put("NUM_OF_SLICES",3);
        processor.setMeta(map);
        Sink sink = flow.source(source)
                .process(processor)
                .sink();
    }
}
