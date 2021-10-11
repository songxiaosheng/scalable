package com.slicingflow.flow;

import com.slicingflow.flow.factory.FlowFactory;
import com.slicingflow.flow.factory.SlicingFlowFactory;
import com.slicingflow.process.AvgProcess;
import com.slicingflow.process.factory.ProcessorFactory;
import com.slicingflow.process.factory.ReflectionProcessorFactory;
import com.slicingflow.process.factory.ReflectionProcessorMeta;
import com.slicingflow.sink.Sink;
import org.junit.Test;

public class FlowFactoryTest {
    @Test
    public void testFactory(){
        FlowFactory flowFactory = new SlicingFlowFactory();
        Flow flow = flowFactory.createFlow();
        ProcessorFactory processorFactory = new ReflectionProcessorFactory();
        Sink sink = flow.source(null)
                .process(processorFactory.createProcessor(new ReflectionProcessorMeta<>(AvgProcess.class)))
                .sink();
    }
}
