package com.user.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.user.config.daoAnnotation.MasterDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


//@Configuration
public class MasterDataSourceConfig {

    // masterDataSource 对应mapper
    private static final String MASTER_MAPPER_LOCATION = "classpath*:mapper/master/*.xml";

    /** *
     * @Author honva
     * @Description 添加数据源
     * @Date 2020/7/16
     * @Param []
     * @return javax.sql.DataSource
    **/
    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        DataSource masterDataSource = new DruidDataSource();
        return masterDataSource;
    }

    @Bean(name = "masterDao")
    public JdbcTemplate masterDao(@Qualifier("masterDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * @return org.apache.ibatis.session.SqlSessionFactory
     * @Author honva
     * @Description mybatis的sqlsession工厂，配置xml映射
     * @Date 2020/7/16
     * @Param [masterDataSource]
     **/
    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(masterDataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MASTER_MAPPER_LOCATION));
//        sessionFactoryBean.setTypeAliasesPackage();
        return sessionFactoryBean.getObject();
    }

    /**
     * @return void
     * @Author honva
     * @Description mybatis配置事务，dao类，xml文件，注解
     * @Date 2020/7/16
     * @Param []
     **/
    @Bean("masterMapperScanner")
    public void masterMapperScanner() {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setSqlSessionFactoryBeanName("masterSqlSessionFactory");
        scannerConfigurer.setBasePackage("com.user.dao");
        scannerConfigurer.setAnnotationClass(MasterDataSource.class);
    }

    /**
     * @return org.springframework.jdbc.datasource.DataSourceTransactionManager
     * @Author honva
     * @Description 主库事务管理
     * @Date 2020/7/16
     * @Param []
     **/
    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }

    //    @Bean(name = "clusterDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.cluster")
//    public DataSource clusterDataSource(){
//        DataSource clusterDataSource = new DruidDataSource();
//        return clusterDataSource;
//    }
//    @Bean(name = "clusterDao")
//    public JdbcTemplate clusterDao(@Qualifier("clusterDataSource") DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//    }

}
