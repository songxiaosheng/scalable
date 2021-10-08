package com.slicingflow.flow.factory;

import com.slicingflow.flow.Flow;
import com.slicingflow.flow.SlicingFlow;
import com.slicingflow.flow.factory.AbstractFlowFactory;

/**
 * @author songxiaosheng
 */
public class SlicingFlowFactory extends AbstractFlowFactory {
    @Override
    public Flow createFlow() {
        return new SlicingFlow();
    }
}
