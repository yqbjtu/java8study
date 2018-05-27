

package com.yq.proxy;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;


/**
 * Simple to Introduction
 * className: DruidDataSourceUtil
 *
 * @author EricYang
 * @version 2018/5/26 16:10
 */
public class DruidDataSourceUtil {

    public DruidDataSource getDataSource() throws Exception {
        Properties configureProperties = new Properties();
        //InputStream is = DruidDataSourceUtil.class.getClassLoader().getResourceAsStream("mysqlroperties.properties");
        System.out.println("CurrentPath:" + (String)(System.getProperty("user.dir")));

        InputStream is = new FileInputStream("mysql.properties");
        configureProperties.load(is);
        DruidDataSource druidDataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(configureProperties);
        return druidDataSource;
    }

    public DruidPooledConnection getDruidConnection(DruidDataSource druidDataSource) throws Exception {
        DruidPooledConnection dbConn = druidDataSource.getConnection();
        return dbConn;
    }
}