package com.example.order.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


/**
 * <b><code>DataSourceConfig</code></b>
 * <p/>
 * 使用 Seata 对数据源进行代理
 * <p/>
 * <b>Creation Time:</b> 2023/8/1 23:27
 *
 * @author yang xiong
 * @since SpringCloudAlibaba 1.0
 */
@Configuration
public class DataSourceConfig {

    @Value("${mybatis-plus.mapper-location}")
    private String mapperLocations;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    @Bean
    public DataSourceProxy dataSourceProxy(DataSource dataSource){
        return new DataSourceProxy(dataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSourceProxy") DataSource dataSourceProxy) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
        return sqlSessionFactoryBean.getObject();
    }
}
//    String property = properties.getProperty("druid.name");
//    property = properties.getProperty("druid.url");
//    property = properties.getProperty("druid.username");
//    property = properties.getProperty("druid.password");
//    Boolean value = Utils.getBoolean(properties, "druid.testWhileIdle");
//    value = Utils.getBoolean(properties, "druid.testOnBorrow");
//    property = properties.getProperty("druid.validationQuery");
//    value = Utils.getBoolean(properties, "druid.useGlobalDataSourceStat");
//    value = Utils.getBoolean(properties, "druid.useGloalDataSourceStat");
//    value = Utils.getBoolean(properties, "druid.asyncInit");
//    property = properties.getProperty("druid.filters");
//    property = properties.getProperty("druid.timeBetweenLogStatsMillis");
//    property = properties.getProperty("druid.stat.sql.MaxSize");
//    value = Utils.getBoolean(properties, "druid.clearFiltersEnable");
//    value = Utils.getBoolean(properties, "druid.resetStatEnable");
//    property = properties.getProperty("druid.notFullTimeoutRetryCount");
//    property = properties.getProperty("druid.timeBetweenEvictionRunsMillis");
//    property = properties.getProperty("druid.maxWaitThreadCount");
//    property = properties.getProperty("druid.maxWait");
//    value = Utils.getBoolean(properties, "druid.failFast");
//    property = properties.getProperty("druid.phyTimeoutMillis");
//    property = properties.getProperty("druid.phyMaxUseCount");
//    property = properties.getProperty("druid.minEvictableIdleTimeMillis");
//    property = properties.getProperty("druid.maxEvictableIdleTimeMillis");
//    value = Utils.getBoolean(properties, "druid.keepAlive");
//    property = properties.getProperty("druid.keepAliveBetweenTimeMillis");
//    value = Utils.getBoolean(properties, "druid.poolPreparedStatements");
//    value = Utils.getBoolean(properties, "druid.initVariants");
//    value = Utils.getBoolean(properties, "druid.initGlobalVariants");
//    value = Utils.getBoolean(properties, "druid.useUnfairLock");
//    property = properties.getProperty("druid.driverClassName");
//    property = properties.getProperty("druid.initialSize");
//    property = properties.getProperty("druid.minIdle");
//    property = properties.getProperty("druid.maxActive");
//    value = Utils.getBoolean(properties, "druid.killWhenSocketReadTimeout");
//    property = properties.getProperty("druid.connectProperties");
//    property = properties.getProperty("druid.maxPoolPreparedStatementPerConnectionSize");
//    property = properties.getProperty("druid.initConnectionSqls");
//    property = System.getProperty("druid.load.spifilter.skip");
//    property = System.getProperty("druid.checkExecuteTime");