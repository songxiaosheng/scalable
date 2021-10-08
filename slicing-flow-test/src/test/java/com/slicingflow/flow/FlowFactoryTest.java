package com.slicingflow.flow;

import com.slicingflow.flow.factory.FlowFactory;
import com.slicingflow.flow.factory.SlicingFlowFactory;
import org.junit.Test;

public class FlowFactoryTest {
    @Test
    public void testFactory(){
        FlowFactory flowFactory = new SlicingFlowFactory();
        Flow flow = flowFactory.createFlow();
        flow.source().process().sink();
    }
}
