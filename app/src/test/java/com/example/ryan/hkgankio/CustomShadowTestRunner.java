package com.example.ryan.hkgankio;

import com.example.ryan.hkgankio.bean.FuLiBean;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.internal.bytecode.InstrumentationConfiguration;

/**
 * Created by ryan on 7/21/16.
 */
public class CustomShadowTestRunner extends RobolectricGradleTestRunner {
    public CustomShadowTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    public InstrumentationConfiguration createClassLoaderConfig() {
        InstrumentationConfiguration.Builder builder = InstrumentationConfiguration.newBuilder();
        /**
         * 添加要进行Shadow的对象
         */
        builder.addInstrumentedClass(FuLiBean.class.getName());
        return builder.build();
    }
}
