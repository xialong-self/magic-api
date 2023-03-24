package com.xialong.magicapi;

import com.xialong.magicapi.config.MultiDatasourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author 夏龙
 * @description 功能描述
 * @create 2023/3/22 16:30
 */
@ActiveProfiles(profiles = "local")
@SpringBootTest
class TestMagicDatasourceConfig {
    @Autowired(required = false)
    private MultiDatasourceConfig multiDatasourceConfig;
    @Test
    void contextLoads(){
        multiDatasourceConfig.getDatasource().entrySet().stream().forEach(entry->
                System.out.println(String.format("key:%s\nurl:%s\nusername:%s",
                        entry.getKey(),
                        entry.getValue().getUrl(),
                        entry.getValue().getUsername())));
        System.out.println("down");
    }
}
