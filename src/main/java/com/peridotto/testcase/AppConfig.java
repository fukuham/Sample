/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peridotto.testcase;

import javax.sql.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.seasar.doma.SingletonConfig;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;

/**
 *
 * @author fukuham
 */
@SingletonConfig
public class AppConfig implements Config {

    // シングルトンインスタンス
    private static final AppConfig CONFIG = new AppConfig();
    // SQL方言
    private final Dialect dialect;
    // データソース
    private final LocalTransactionDataSource localTransactionDataSource;
    // トランザクション管理を行う
    private final TransactionManager transactionManager;

    private AppConfig() {
        dialect = new PostgresDialect();
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        PoolProperties p = CreateDatasource();
        dataSource.setPoolProperties(p);
        localTransactionDataSource = new LocalTransactionDataSource(dataSource);
        transactionManager = new LocalTransactionManager(
                localTransactionDataSource.getLocalTransaction(getJdbcLogger()));
    }

    private PoolProperties CreateDatasource() {
        PoolProperties p = new PoolProperties();
        // 接続情報の設定
        p.setUrl("jdbc:postgresql://192.168.56.101:5432/sample");
        p.setDriverClassName("org.postgresql.Driver");
        p.setUsername("postgres");
        p.setPassword("postgres123");
        // その他オプション
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
                + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        return p;
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }

    @Override
    public DataSource getDataSource() {
        return localTransactionDataSource;
    }

    @Override
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    public static AppConfig singleton() {
        return CONFIG;
    }
}
