package com.SimpleBank.BDiA_final_config.SourceConfig;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DataSourceProvider {
    public static DataSource dataSource;
    private DataSourceProvider(){}

    public static DataSource getDataSource() throws NamingException{
        if(dataSource == null){
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env/");
            dataSource = (DataSource) envContext.lookup("jdbc/SimpleBank");
        }
        return dataSource;
    }
}
