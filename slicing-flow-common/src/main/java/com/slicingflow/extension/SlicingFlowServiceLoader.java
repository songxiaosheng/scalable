package com.slicingflow.extension;


import java.util.ServiceLoader;

/**
 * @author songxiaosheng
 */
public class SlicingFlowServiceLoader<S> {
    /**
     * slicing flow extended directory
     */
    private static final String PREFIX = "META-INF/slicing-flow/";

    private SlicingFlowServiceLoader(Class<S> service, ClassLoader loader) {

    }

    public static <S> SlicingFlowServiceLoader<S> load(Class<S> service,
                                            ClassLoader loader)
    {
        return new SlicingFlowServiceLoader<>(service, loader);
    }
}
