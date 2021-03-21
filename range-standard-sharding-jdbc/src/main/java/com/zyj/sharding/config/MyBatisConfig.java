package com.zyj.sharding.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan({"com.zyj.sharding.mbg.mapper","com.zyj.sharding.dao"})
public class MyBatisConfig {
}
