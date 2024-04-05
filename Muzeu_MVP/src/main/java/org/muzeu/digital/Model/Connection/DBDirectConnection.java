package org.muzeu.digital.Model.Connection;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class DBDirectConnection {
    private static NamedParameterJdbcTemplate instance = null;

    private DBDirectConnection(){
        instance = new NamedParameterJdbcTemplate(ConnectionFactory.configureDataSource());
    }

    public static NamedParameterJdbcTemplate getInstance(){
        if(instance == null){
            new DBDirectConnection();
        }

        return instance;
    }
}
