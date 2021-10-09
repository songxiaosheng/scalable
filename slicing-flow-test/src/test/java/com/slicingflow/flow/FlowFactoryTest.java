package com.slicingflow.flow;

import com.slicingflow.flow.factory.FlowFactory;
import com.slicingflow.flow.factory.SlicingFlowFactory;
import com.slicingflow.sink.Sink;
import org.junit.Test;

public class FlowFactoryTest {
    @Test
    public void testFactory(){
        FlowFactory flowFactory = new SlicingFlowFactory();
        Flow flow = flowFactory.createFlow();
        Sink sink = flow.source(null).process(null).process(null).sink();
    }
}
