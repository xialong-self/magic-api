package com.xialong.magicapi.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.ssssssss.magicapi.datasource.model.DataSourceInfo;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author 夏龙
 * @description 重新getMatchOutcome方法，条件加载配置文件
 * @create 2023/3/22 15:40
 */
public class MultiDatasourceConfigCondition extends SpringBootCondition {
    public static final Bindable<Map<String, DataSourceInfo>> STRING_REGISTRATION_MAP = Bindable.mapOf(String.class, DataSourceInfo.class);

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConditionMessage.Builder builder = ConditionMessage.forCondition("Magic-api Multi Datasource Configured Condition");
        Map<String, DataSourceInfo> registrations = getRegistrations(context.getEnvironment());
        if (!registrations.isEmpty()) {
            return ConditionOutcome.match(builder.foundExactly(
                    "datasource" + String.join(",", registrations.keySet())
            ));
        }
        return ConditionOutcome.noMatch(builder.notAvailable("datasource configs"));
    }

    public Map<String, DataSourceInfo> getRegistrations(Environment environment) {
        return Binder.get(environment).bind("data.datasource", STRING_REGISTRATION_MAP)
                .orElse(Collections.emptyMap());
    }
}
