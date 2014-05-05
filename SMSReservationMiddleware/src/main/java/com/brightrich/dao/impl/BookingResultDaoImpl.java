package com.brightrich.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.object.SqlUpdate;

import com.brightrich.dao.BookingResultDao;
import com.brightrich.model.BookingResult;
import com.brightrich.util.Constant;

public class BookingResultDaoImpl implements BookingResultDao {

	String sql_INSERT = "insert into TEMP_BOOKING_TRX ("
			+ Constant.BookingProcess.TRX_FIELDS_QUERY + ") "
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	String sql_SELECT = "select " + Constant.BookingProcess.TRX_FIELDS_QUERY
			+ " from TEMP_BOOKING_TRX ";

	String sql_UPDATE = "update TEMP_BOOKING_TRX set "
			+ Constant.BookingProcess.FLAG + " = ? where "
			+ Constant.BookingProcess.TRX_ID + " = ? ";

	private JdbcTemplate jdbcTemplate;

	/**
	 * @param jdbcTemplate
	 *            the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void saveBookingResult(BookingResult t) {

		jdbcTemplate.update(
				sql_INSERT,
				new Object[] { t.getTransactionId(), t.getBookingCode(),
						t.getOutboundFlightNumber(), t.getDepartureDate(),
						t.getOutboundDepartureTime(), t.getReturnDate(),
						t.getReturnDepartureTime(), t.getFlightType(),
						t.getNumOfPax(), t.getTotalFare(), t.getOrigin(),
						t.getDestination(), t.getMsisdn(), t.getAirlines(),
						t.getBookingDate(), t.getFlag(), t.getPaymentCode(),
						t.getReturnFlightNumber(), t.getFlightClass(),
						t.getOutboundArrivalTime(), t.getReturnArrivalTime() },
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
						Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
						Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
						Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
						Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP,
						Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
						Types.VARCHAR, Types.VARCHAR, Types.VARCHAR });

	}

	public BookingResult getLatestBookingResult(String msisdn) {
		String sql = sql_SELECT + " where " + Constant.BookingProcess.MSISDN
				+ " = ? and " + Constant.BookingProcess.FLAG + " = ? and ("
				+ Constant.BookingProcess.PAYMENT_CODE + " is null OR "
				+ Constant.BookingProcess.PAYMENT_CODE + " = ?) order by "
				+ Constant.BookingProcess.BOOKING_DATE + " desc limit 1";
		@SuppressWarnings("unchecked")
		List<BookingResult> list = jdbcTemplate.query(sql, new Object[] {
				msisdn, Constant.BookingProcess.FLAG_BOOKED, "" },
				new BookingResultRowMapper());
		System.out.println("LIST TRX");
		if (list != null && list.size() > 0) {
			System.out.println("LIST TRX " + list);
			return list.get(0);
		}
		System.out.println("LIST NULL");
		return null;
	}

	public void updateBookingResultFlag(String status, String transactionId) {
		Object[] param = new Object[] { status, transactionId };
		jdbcTemplate.update(sql_UPDATE, param);
	}

	public void updateBookingResultPaymentCode(String paymentCode,
			String transactionId) {
		String sql = "update TEMP_BOOKING_TRX set "
				+ Constant.BookingProcess.PAYMENT_CODE + " = ? where "
				+ Constant.BookingProcess.TRX_ID + " = ?";
		Object[] param = new Object[] { paymentCode, transactionId };
		jdbcTemplate.update(sql, param);

	}

	public void updateBookingResultBookingCode(String bookingCode,
			String transactionId) {
		String sql = "update TEMP_BOOKING_TRX set "
				+ Constant.BookingProcess.BOOKING_CODE + " = ? where "
				+ Constant.BookingProcess.TRX_ID + " = ?";
		Object[] param = new Object[] { bookingCode, transactionId };
		jdbcTemplate.update(sql, param);

	}

	class BookingResultRowMapper implements RowMapper {

		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			BookingResult t = new BookingResult();
			t.setAirlines(rs.getString(Constant.BookingProcess.AIRLINES));
			t.setBookingCode(rs.getString(Constant.BookingProcess.BOOKING_CODE));
			t.setBookingDate(rs
					.getTimestamp(Constant.BookingProcess.BOOKING_DATE));
			t.setDepartureDate(rs
					.getString(Constant.BookingProcess.DEPARTURE_DATE));
			t.setOutboundDepartureTime(rs
					.getString(Constant.BookingProcess.OUTBOUND_DEPARTURE_TIME));
			t.setDestination(rs.getString(Constant.BookingProcess.DESTINATION));
			t.setFlag(rs.getString(Constant.BookingProcess.FLAG));
			t.setOutboundFlightNumber(rs
					.getString(Constant.BookingProcess.OUTBOUND_FLIGHT_NUMBER));
			t.setFlightType(rs.getString(Constant.BookingProcess.FLIGHT_TYPE));
			t.setMsisdn(rs.getString(Constant.BookingProcess.MSISDN));
			t.setNumOfPax(rs.getString(Constant.BookingProcess.NUM_OF_PAX));
			t.setOrigin(rs.getString(Constant.BookingProcess.ORIGIN));
			t.setReturnDate(rs.getString(Constant.BookingProcess.RETURN_DATE));
			t.setReturnDepartureTime(rs
					.getString(Constant.BookingProcess.RETURN_DEPARTURE_TIME));
			t.setTotalFare(rs.getString(Constant.BookingProcess.TOTAL_FARES));
			t.setTransactionId(rs.getString(Constant.BookingProcess.TRX_ID));
			t.setPaymentCode(rs.getString(Constant.BookingProcess.PAYMENT_CODE));
			t.setReturnFlightNumber(rs
					.getString(Constant.BookingProcess.RETURN_FLIGHT_NUMBER));
			t.setFlightClass(rs.getString(Constant.BookingProcess.FLIGHT_CLASS));
			t.setOutboundArrivalTime(rs
					.getString(Constant.BookingProcess.OUTBOUND_ARRIVAL_TIME));
			t.setReturnArrivalTime(rs
					.getString(Constant.BookingProcess.RETURN_ARRIVAL_TIME));
			return t;
		}
	}

	public BookingResult getBookingResult(String trxId) {
		String sql = sql_SELECT + " where " + Constant.BookingProcess.TRX_ID
				+ " = ? ";
		@SuppressWarnings("unchecked")
		List<BookingResult> list = jdbcTemplate.query(sql,
				new Object[] { trxId }, new BookingResultRowMapper());
		System.out.println("LIST TRX");
		if (list != null && list.size() > 0) {
			System.out.println("LIST TRX " + list);
			return list.get(0);
		}
		System.out.println("LIST NULL");
		return null;
	}

	public List<BookingResult> getUnpaidBooking() {
		String sql = sql_SELECT + " where (" + Constant.BookingProcess.PAYMENT_CODE
				+ " is not null OR " + Constant.BookingProcess.PAYMENT_CODE
				+ " != ?) and (" 
				+ Constant.BookingProcess.BOOKING_CODE + " is null or "+Constant.BookingProcess.BOOKING_CODE +" =? )"
				+ " and " + Constant.BookingProcess.FLAG +" =?";
		@SuppressWarnings("unchecked")
		List<BookingResult> list = jdbcTemplate.query(sql, new Object[] {
				"","", Constant.BookingProcess.FLAG_BOOKED},
				new BookingResultRowMapper());
		
		
			return list;
		
	}
}
