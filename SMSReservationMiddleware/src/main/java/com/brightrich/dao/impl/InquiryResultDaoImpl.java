package com.brightrich.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.brightrich.dao.InquiryResultDao;
import com.brightrich.model.InquiryResult;
import com.brightrich.util.Constant;

public class InquiryResultDaoImpl implements InquiryResultDao {

	String sql_INSERT = "insert into TEMP_FLIGHT_SCHEDULE ("+ Constant.InquiryProcess.IR_FIELDS_INSERT +") "
            + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
    
    String sql_SELECT = "select " + Constant.InquiryProcess.IR_FIELDS_QUERY 
            + " from TEMP_FLIGHT_SCHEDULE ";
    
    String sql_UPDATE = "update TEMP_FLIGHT_SCHEDULE set "+ Constant.InquiryProcess.FLAG +" = ? where "+ Constant.InquiryProcess.INQ_ID +" = ? ";        
    
    String sql_DELETE = "delete from TEMP_FLIGHT_SCHEDULE where "+ Constant.InquiryProcess.MSISDN +" = ? and ("+ Constant.InquiryProcess.FLAG +" <> ? OR "+ Constant.InquiryProcess.FLAG + " is null)";
    
    private JdbcTemplate jdbcTemplate;
	
	public void saveInquiryResult(List<InquiryResult> irList) {				
		
		for (InquiryResult i : irList) {
	        System.out.println("RETURN DATE DAO = " + i.getReturnDate());						
			jdbcTemplate.update(sql_INSERT, new Object[]{
					
					i.getMsisdn(),i.getOrigin(),i.getDestination(),i.getFlightType(),i.getDepartureDate(),i.getReturnDate(),i.getAirlines(),i.getFlightClass(),
					i.getNumOfPax(),i.getOutboundTimeRange(),i.getReturnTimeRange(),i.getFlightKey(),i.getFlightNumber(),i.getDepartureTime(),i.getArrivalTime(),
					i.getPrice(),i.getFlag()
					
		        }, new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, 
		            Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR
		        });
		}			
	}

	public InquiryResult getInquiryResult(String msisdn, String flightKey,
			String flightType) {		
		String sql = sql_SELECT+" where "+ Constant.InquiryProcess.MSISDN +" = ? and " + Constant.InquiryProcess.FLIGHT_KEY + " = ? and "+ Constant.InquiryProcess.FLIGHT_TYPE;        
        @SuppressWarnings("unchecked")
		List<InquiryResult> list = jdbcTemplate.query(sql, new Object[] {msisdn, flightKey, flightType}, new InquiryResultRowMapper());
        System.out.println("LIST TRX");
        if (list!=null && list.size()>0){
        	System.out.println("LIST TRX " + list);
            return list.get(0);
        }
        System.out.println("LIST NULL");
        return null;
	}
	
	public InquiryResult getInquiryResultWithTypeAndKey(String msisdn, String flightTypeAndKey) {		
		String sql = sql_SELECT+" where "+ Constant.InquiryProcess.MSISDN +" = ? and concat(" + Constant.InquiryProcess.FLIGHT_TYPE + ","+ Constant.InquiryProcess.FLIGHT_KEY+") = ?";
		
		System.out.println("SQL QUERY = " + sql + "FLIGHTKEY TYPE = " + flightTypeAndKey);
		
        @SuppressWarnings("unchecked")
		List<InquiryResult> list = jdbcTemplate.query(sql, new Object[] {msisdn, flightTypeAndKey}, new InquiryResultRowMapper());
        System.out.println("LIST TRX");
        if (list!=null && list.size()>0){
        	System.out.println("LIST TRX " + list);
            return list.get(0);
        }
        System.out.println("LIST NULL");
        return null;
	}

	public void updateInquiryResultFlag(String status, String inqId) {
		String sql = sql_UPDATE;
        Object[] param = new Object[]{status, inqId};
        jdbcTemplate.update(sql, param);
	}

	public void deleteTemporaryInquiryResult(String msisdn, String flag) {
		String sql = sql_DELETE;
        Object[] param = new Object[]{msisdn, flag};
        jdbcTemplate.update(sql, param);
		System.out.println("DELETED");
		System.out.println("SQL QUERY = " + sql + " PARAM = " + msisdn + " " + flag);
	}

	/**
     * @param jdbcTemplate the jdbcTemplate to set
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	class InquiryResultRowMapper implements RowMapper{

	    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        InquiryResult r = new InquiryResult();
	        r.setAirlines(rs.getString(Constant.InquiryProcess.AIRLINES));
	        r.setArrivalTime(rs.getString(Constant.InquiryProcess.ARRIVAL_TIME));
	        r.setDepartureDate(rs.getString(Constant.InquiryProcess.DEPARTURE_DATE));
	        r.setDepartureTime(rs.getString(Constant.InquiryProcess.DEPARTURE_TIME));
	        r.setDestination(rs.getString(Constant.InquiryProcess.DESTINATION));
	        r.setFlag(rs.getString(Constant.InquiryProcess.FLAG));
	        r.setFlightClass(rs.getString(Constant.InquiryProcess.FLIGHT_CLASS));
	        r.setFlightKey(rs.getString(Constant.InquiryProcess.FLIGHT_KEY));
	        r.setFlightNumber(rs.getString(Constant.InquiryProcess.FLIGHT_NUMBER));
	        r.setFlightType(rs.getString(Constant.InquiryProcess.FLIGHT_TYPE));
	        r.setId(String.valueOf(rs.getInt(Constant.InquiryProcess.INQ_ID)));
	        r.setMsisdn(rs.getString(Constant.InquiryProcess.MSISDN));
	        r.setNumOfPax(rs.getString(Constant.InquiryProcess.NUM_OF_PAX));
	        r.setOrigin(rs.getString(Constant.InquiryProcess.ORIGIN));
	        r.setOutboundTimeRange(rs.getString(Constant.InquiryProcess.OUTBOUND_TIME_RANGE));
	        r.setPrice(rs.getString(Constant.InquiryProcess.PRICE));
	        r.setReturnDate(rs.getString(Constant.InquiryProcess.RETURN_DATE));
	        r.setReturnTimeRange(rs.getString(Constant.InquiryProcess.RETURN_TIME_RANGE));
	        
	        return r;
	    }	
	}
}
