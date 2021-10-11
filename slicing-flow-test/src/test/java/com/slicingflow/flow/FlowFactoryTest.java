package com.slicingflow.flow;

import com.slicingflow.flow.factory.FlowFactory;
import com.slicingflow.flow.factory.SlicingFlowFactory;
import com.slicingflow.process.AvgProcess;
import com.slicingflow.process.Processor;
import com.slicingflow.process.factory.ProcessorFactory;
import com.slicingflow.process.factory.ReflectionProcessorFactory;
import com.slicingflow.process.factory.ReflectionProcessorMeta;
import com.slicingflow.sink.Sink;
import com.slicingflow.source.CollectionSource;
import com.slicingflow.source.Source;
import com.slicingflow.source.factory.ReflectionSourceFactory;
import com.slicingflow.source.factory.ReflectionSourceMeta;
import com.slicingflow.source.factory.SourceFactory;
import org.junit.Test;

public class FlowFactoryTest {
    @Test
    public void testFactory(){
        FlowFactory flowFactory = new SlicingFlowFactory();
        Flow flow = flowFactory.createFlow();
        ProcessorFactory processorFactory = new ReflectionProcessorFactory();
        SourceFactory sourceFactory = new ReflectionSourceFactory();
        Source source = sourceFactory.createSource(new ReflectionSourceMeta<>(CollectionSource.class));
        Processor processor = processorFactory.createProcessor(new ReflectionProcessorMeta<>(AvgProcess.class));
        Sink sink = flow.source(source)
                .process(processor)
                .sink();
    }
}
