package com.mybatisflux.config

import com.mybatisflex.core.mybatis.FlexConfiguration
import com.mybatisflex.spring.boot.ConfigurationCustomizer
import org.apache.ibatis.logging.stdout.StdOutImpl
import org.springframework.beans.factory.annotation.Configurable
import org.springframework.context.annotation.Configuration

@Configuration
class MyConfigurationCustomizer : ConfigurationCustomizer {
    override fun customize(configuration: FlexConfiguration) {
        configuration.logImpl = StdOutImpl::class.java
    }
}
