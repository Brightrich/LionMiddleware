package com.brightrich.dao.impl;

import java.sql.Types;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;

import com.brightrich.dao.SMSMessageDao;
import com.brightrich.model.SMSMessage;

public class SMSMessageDaoImpl implements SMSMessageDao {

	private JdbcTemplate jdbcTemplate;
	String sql_INSERT = "insert into TEMP_SMS_RECEIVED (MSISDN, MESSAGE, RECEIVED_DATE) "
            + "values (?,?,?)";
	
	public void saveTransaction(SMSMessage m) {
		jdbcTemplate.update(sql_INSERT, new Object[]{
	           m.getMsisdn(),m.getMessage(), m.getReceivedDate()
	        }, new int[]{Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP
	        });
		
	}

	/**
     * @param jdbcTemplate the jdbcTemplate to set
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
}
