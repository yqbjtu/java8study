
package com.yq.proxy;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.druid.pool.DruidPooledPreparedStatement;
import com.alibaba.druid.pool.DruidPooledResultSet;
import com.alibaba.druid.pool.DruidPooledStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.DatabaseMetaData;

/**
 * Simple to Introduction
 * className: ProxyVerifyMain
 *
 * @author EricYang
 * @version 2018/5/26 15:30
 */
public class ProxyVerifyMain {
    private static final Logger logger = LoggerFactory.getLogger(MysqlProxyServer.class);

    public static void main(String[] args) {
        DruidDataSourceUtil druidDataSourceUtil = new DruidDataSourceUtil();
        DruidDataSource druidDataSource = null;
        try {
            druidDataSource = druidDataSourceUtil.getDataSource();
            String sql = "select * from user";
            //String sql = "select * from user where username =? ";

            for (int i = 0; i < 1; i++) {
                DruidPooledConnection dbConn = druidDataSourceUtil.getDruidConnection(druidDataSource);
                DatabaseMetaData metaDate = dbConn.getConnection().getMetaData();
                System.out.println("URL:" + metaDate.getURL());

                try (DruidPooledStatement stmtNew = (DruidPooledStatement) dbConn.createStatement()) {
                    DruidPooledPreparedStatement ps = (DruidPooledPreparedStatement)dbConn.prepareStatement(sql);
                    //ps.setString(1,"tom");
                    DruidPooledResultSet rs = (DruidPooledResultSet)ps.executeQuery();
                    //getFetchRowCount
                    if (rs != null) {
                        while(rs.next()) {
                            int id = rs.getInt(1);
                            int active = rs.getInt(1);
                            String name = rs.getString(7);
                            System.out.println(id + "," + active + "," + name);
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Error={}", e.getLocalizedMessage());
            System.exit(1);
        }
    }

}

