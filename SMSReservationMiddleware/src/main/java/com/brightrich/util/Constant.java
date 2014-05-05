package com.brightrich.util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public class Constant {

	public static class Validation{
		
		public static final SimpleDateFormat flightTimeFormat = new SimpleDateFormat("dd-MMM-yyyy");
		
		public static final String VALIDATION_ERROR = "VALIDATION_ERROR";
		public static final String INQUIRY_PATTERN_ERROR_MSG = "Untuk melakukan pencarian jadwal pesawat ketik LION <ASAL> <TUJUAN> <R(ETURN)/S(INGLE)> " +
															"<TANGGAL BERANGKAT> <BULAN> <MORNING/AFTERNOON/NIGHT> - <TANGGAL PULANG> <BULAN> <MORNING/AFTERNOON/NIGHT> <ECONOMY/BUSINESS> <JUMLAH PENUMPANG> \n " +
															"Contoh: LION CGK DPS R 10 JUN MORNING - 12 JUN NIGHT ECONOMY 2";		
		public static final String INQUIRY_FLIGHT_NA_MSG = "Pelanggan Yth, Penerbangan tidak tersedia untuk tanggal yang anda pilih. Silahkan memilih tanggal lain. terima kasih";
		public static final String INQUIRY_FLIGHT_ERROR =  "Pelanggan Yth, silahkan mencoba beberapa saat lagi. terima kasih.";
		public static final String INQUIRY_FLIGHT_DATE_ERROR = "Pelanggan Yth, tanggal keberangkatan harus lebih dahulu dibandingkan tanggal kepulangan. terima kasih";
		@SuppressWarnings("serial")
		public static final Map<String, String> monthMapIDtoEN = Collections.unmodifiableMap(
			    new HashMap<String, String>() {{			    				    				    	
			        put("JANUARI","JAN");put("JANUARY","JAN");put("JAN","JAN");put("FEBRUARY","FEB");put("FEBRUARI","FEB");put("FEB","FEB");
			        put("MARCH","MAR");put("MARET","MAR");put("MAR","MAR");put("APRIL","APR");put("APR","APR");
			        put("MAY","MAY");put("MEI","MAY");put("JUNE","JUN");put("JUNI","JUN");put("JUN","JUN");
			        put("JULY","JUL");put("JULI","JUL");put("JUL","JUL");put("AUGUST","AUG");put("AGUSTUS","AUG");put("AGU","AUG");put("AUG","AUG");
			        put("SEPTEMBER","SEP");put("SEPT","SEP");put("SEP","SEP");put("NOVEMBER","NOV");put("NOV","NOV");
			        put("OCTOBER","OCT");put("OKTOBER","OCT");put("OKT","OCT");put("OCT","OCT");put("DECEMBER","DEC");put("DESEMBER","DEC");put("DES","DEC");put("DEC","DEC");
			    }});
		
		
		public static final String BOOKING_PATTERN_ERROR_MSG = "Untuk memilih penerbangan ketik BOOKING O#<Nomor urut keberangkatan> R#<Nomor urut kepulangan> \n" +				
															   "Contoh: BOOKING O#1 R#2 atau untuk single flight BOOKING O#1";
		
		public static final String BOOKING_SCHEDULE_NF_ERROR_MSG = "Pelanggan Yth, nomor urut penerbangan yang anda pilih salah. terima kasih";
		
		public static final String BOOKING_FLIGHT_ERROR =  "Pelanggan Yth, proses reservasi gagal, silahkan melakukan pencarian baru untuk jadwal penerbangan. terima kasih.";
		
		public static final String PAX_PATTERN_ERROR_MSG = "Untuk memasukkan info penumpang ketik PAX P1 <MR/MRS/MS> <NAMA DEPAN> <NAMA TENGAH> <NAMA BELAKANG> <NOMOR KTP>#P2 <MR/MRS/MS> <NAMA DEPAN> <NAMA TENGAH> <NAMA BELAKANG> <NOMOR KTP> sebanyak jumlah penumpang. \n" +				
															"Contoh: PAX P1 MR JOHN DOE 1234567890#P2 MRS JANE DOE 9876543210 /n untuk penumpang di bawah umur, nomor KTP tidak perlu dimasukkan.";
		
		public static final String PAX_BOOK_NF_ERROR_MSG = "Pelanggan Yth, Anda belum melakukan proses pemilihan penerbangan. Silahkan melakukan pemilihan penerbangan terlebih dahulu.";
		
		public static final String PAX_INCOMPLETE_ERROR_MSG = "Pelanggan Yth, nama penumpang yang didaftarkan tidak sesuai dengan jumlah penumpang";
		
		public static final String PAX_SERVICE_ERROR = "Pelanggan Yth, proses pendaftaran penumpang gagal, silahkan melakukan kembali pendaftaran.";				
		
	}
	
	public static class MessageParser{				
		
		public static final String STARTS_WITH_LION = "LION";
		public static final String STARTS_WITH_BATIK = "BATIK";
		public static final String STARTS_WITH_AIRLINES = "AIRLINES";
		public static final String STARTS_WITH_BOOKING = "BOOKING";
		public static final String STARTS_WITH_PAX = "PAX";
		public static final String STARTS_WITH_PAY = "PAY";
		
		public static final String STEP = "STEP";
		
		public static final String PATTERN_NOT_FOUND = "PATTERN_NOT_FOUND";
		
		public static final String R_FLAG = "R";
		public static final String S_FLAG = "S";
		
		public static final String AVOIDED_WHITE_SPACE = " ";
		public static final String AVOIDED_DASH = "-";
		
		public static final String FLIGHT_TYPE = "FLIGHT_TYPE";
		
		public static final String wsPattern="(\\s+)";	// White Space 1
		public static final String wordPattern="((?:[a-z][a-z]+))";	// Word 2
		public static final String numberPattern="(\\d+)";	// Integer Number 1
		
		public static class FlightInquiry{		
		
		//FLIGHT INQ ATTRIBUTES		
		public static final String AIRLINES = "AIRLINES";
		public static final String ORIGIN = "ORIGIN";
		public static final String DESTINATION = "DESTINATION";
		public static final String OUTBOUND_DATE = "OUTBOUND_DATE";
		public static final String OUTBOUND_MONTH = "OUTBOUND_MONTH";
		public static final String OUTBOUND_TIME_RANGE = "OUTBOUND_TIME_RANGE";		
		public static final String RETURN_TIME_RANGE = "RETURN_TIME_RANGE";
		public static final String FLIGHT_CLASS = "FLIGHT_CLASS";
		public static final String NUM_OF_PAX = "NUM_OF_PAX";
		
		//RETURN FLIGHT ONLY
		public static final String RETURN_DATE = "RETURN_DATE";
		public static final String RETURN_MONTH = "RETURN_MONTH";
				
		public static final String[] RETURN_FLIGHT_ORDER = new String[]{AIRLINES, ORIGIN, DESTINATION, FLIGHT_TYPE, OUTBOUND_DATE, OUTBOUND_MONTH, OUTBOUND_TIME_RANGE,AVOIDED_DASH, 
																		RETURN_DATE,RETURN_MONTH,RETURN_TIME_RANGE, FLIGHT_CLASS, NUM_OF_PAX}; 
		
		public static final String[] SINGLE_FLIGHT_ORDER = new String[]{AIRLINES, ORIGIN, DESTINATION, FLIGHT_TYPE, OUTBOUND_DATE, OUTBOUND_MONTH, OUTBOUND_TIME_RANGE, 
																		FLIGHT_CLASS, NUM_OF_PAX};
		
		public static final String airPattern="(LION|BATIK)";	// Word 1	
		public static final String rTypePattern="(R)";	// Any Single Character 1
	    public static final String sTypePattern="(S)";	// Any Single Character 1		    
	    public static final String dayPattern="((?:(?:[0-2]?\\d{1})|(?:[3][01]{1})))(?![\\d])";	// Day 1		    
	    public static final String monthPattern="((?:Jan(?:uary)?|Jan(?:uari)?|Feb(?:ruary)?|Feb(?:ruari)?|Mar(?:ch)?|Mar(?:et)?|Apr(?:il)?|May|Mei|Jun(?:e)?|Jun(?:i)?|Jul(?:y)?|Jul(?:i)?|Aug(?:ust)?|Agu(?:stus)?|Sep(?:tember)?|Sept|Oct(?:ober)?|Okt(?:ober)?|Nov(?:ember)?|Dec(?:ember)?|Des(?:ember)?))";	// Month 1		    
	    public static final String timeRangePattern="(MORNING|AFTERNOON|NIGHT)";	// Word 4		    
	    public static final String dashPattern="(-)";	// Any Single Character 2		    		    		    		    		    
	    public static final String classPattern="(ECONOMY|BUSINESS|EXECUTIVE)";	// Word 6		    
	    
	    
	    public static final Pattern rFlightPattern = Pattern.compile(airPattern+wsPattern+wordPattern+wsPattern+wordPattern+wsPattern+rTypePattern+wsPattern+dayPattern+
				wsPattern+monthPattern+wsPattern+timeRangePattern+wsPattern+dashPattern+wsPattern+dayPattern+wsPattern+monthPattern+wsPattern+
				timeRangePattern+wsPattern+classPattern+wsPattern+numberPattern,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    
	    public static final Pattern sFlightPattern = Pattern.compile(airPattern+wsPattern+wordPattern+wsPattern+wordPattern+wsPattern+sTypePattern+wsPattern+dayPattern+
				wsPattern+monthPattern+wsPattern+timeRangePattern+wsPattern+classPattern+wsPattern+numberPattern,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    
	    public static final String CHOSEN_FLAG = "C";
	    
		}
		
		public static class FlightBooking{
			
			//FLIGHT BOOKING ATTRIBUTES
			public static final String OUTBOUND_FLIGHT = "OUTBOUND_FLIGHT";
			public static final String RETURN_FLIGHT = "RETURN_FLIGHT";
			public static final String BOOKING = "BOOKING";
			
			public static final String[] RETURN_BOOKING_ORDER = new String[]{BOOKING, OUTBOUND_FLIGHT, RETURN_FLIGHT};
			public static final String[] SINGLE_BOOKING_ORDER = new String[]{BOOKING, OUTBOUND_FLIGHT};
			
			public static final String commandPattern = "(BOOKING)";
			public static final String wildcardFlag = "(#)";
			public static final String oFlightFlag = "(O#\\d+)";
			public static final String rFlightFlag = "(R#\\d+)";
			
			
			public static final Pattern rBookingPattern = Pattern.compile(commandPattern+wsPattern+oFlightFlag+wsPattern+rFlightFlag,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		    
		    public static final Pattern sBookingPattern = Pattern.compile(commandPattern+wsPattern+oFlightFlag,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		}
		
		public static class PaxDetails{
			
			public static final String PAX_COMMAND = "PAX";
			public static final String WILDCARD = "#";
			public static final String PAX_NUMBER = "PAX_NUMBER";
			public static final String PAX_TITLE = "PAX_TITLE";
			public static final String PAX_FIRST_NAME = "PAX_FIRST_NAME";
			public static final String PAX_LAST_NAME = "PAX_LAST_NAME";
			public static final String PAX_MIDDLE_NAME = "PAX_MIDDLE_NAME";
			public static final String PAX_SSN = "PAX_SSN";
			
			public static final String paxNumberPattern = "(P\\d+)";
			public static final String adultTitlePattern = "(MR|MRS|MS)";
			public static final String childTitlePattern = "(MR|MS)";
			
			public static final String[] ADULT_PAX_ORDER = new String[]{PAX_NUMBER, PAX_TITLE, PAX_FIRST_NAME, PAX_LAST_NAME, PAX_SSN};
			public static final String[] CHILD_PAX_ORDER = new String[]{PAX_NUMBER, PAX_TITLE, PAX_FIRST_NAME, PAX_LAST_NAME};
			public static final String[] ADULT_PAX_WITH_MID_NAME_ORDER = new String[]{PAX_NUMBER, PAX_TITLE, PAX_FIRST_NAME, PAX_MIDDLE_NAME, PAX_LAST_NAME, PAX_SSN};
			public static final String[] CHILD_PAX_WITH_MID_NAME_ORDER = new String[]{PAX_NUMBER, PAX_TITLE, PAX_FIRST_NAME, PAX_MIDDLE_NAME, PAX_LAST_NAME};
			
			public static final Pattern adultPaxPattern = Pattern.compile(paxNumberPattern+wsPattern+adultTitlePattern+wsPattern+wordPattern+wsPattern+wordPattern+wsPattern+numberPattern, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			public static final Pattern adultPaxWithMidNamePattern = Pattern.compile(paxNumberPattern+wsPattern+adultTitlePattern+wsPattern+wordPattern+wsPattern+wordPattern+wsPattern+wordPattern+wsPattern+numberPattern, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			public static final Pattern childPaxPattern = Pattern.compile(paxNumberPattern+wsPattern+childTitlePattern+wsPattern+wordPattern+wsPattern+wordPattern, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			public static final Pattern childPaxWithMidNamePattern = Pattern.compile(paxNumberPattern+wsPattern+childTitlePattern+wsPattern+wordPattern+wsPattern+wordPattern+wsPattern+wordPattern, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			
			public static final String NUM_OF_PAX = "NUM_OF_PAX";
			
		}
		
	}
	
	public static class InquiryProcess {			
		public static final String INQ_ID = "ID";
		public static final String MSISDN = "MSISDN";
		public static final String ORIGIN = "ORIGIN";
		public static final String DESTINATION = "DESTINATION";
		public static final String FLIGHT_TYPE = "FLIGHT_TYPE";
		public static final String DEPARTURE_DATE = "DEPARTURE_DATE";
		public static final String RETURN_DATE = "RETURN_DATE";
		public static final String AIRLINES = "AIRLINES";
		public static final String FLIGHT_CLASS = "FLIGHT_CLASS";
		public static final String NUM_OF_PAX = "NUM_OF_PAX";
		public static final String OUTBOUND_TIME_RANGE = "OUTBOUND_TIME_RANGE";
		public static final String RETURN_TIME_RANGE = "RETURN_TIME_RANGE";
		public static final String FLIGHT_KEY = "FLIGHT_KEY";		
		public static final String FLIGHT_NUMBER = "FLIGHT_NUMBER";		
		public static final String DEPARTURE_TIME = "DEPARTURE_TIME";		
		public static final String ARRIVAL_TIME = "ARRIVAL_TIME";
		public static final String PRICE = "PRICE";
		public static final String FLAG = "FLAG";
		
		public static final String RETURN_TYPE = "R";
		public static final String OUTBOUND_TYPE = "O";
		
		public static final String IR_FIELDS_INSERT = MSISDN + ", " + ORIGIN+ ", " +DESTINATION+ ", " +FLIGHT_TYPE+ ", " +DEPARTURE_DATE+ ", " +RETURN_DATE+ ", " +AIRLINES
				  + ", " + FLIGHT_CLASS + ", " + NUM_OF_PAX + ", " + OUTBOUND_TIME_RANGE + ", " + RETURN_TIME_RANGE + ", " + FLIGHT_KEY
				  + ", " +FLIGHT_NUMBER+ ", " +DEPARTURE_TIME+ ", " +ARRIVAL_TIME+ ", " +PRICE+ ", " +FLAG;
		
		public static final String IR_FIELDS_QUERY = INQ_ID + ", " + MSISDN + ", " + ORIGIN+ ", " +DESTINATION+ ", " +FLIGHT_TYPE+ ", " +DEPARTURE_DATE+ ", " +RETURN_DATE+ ", " +AIRLINES
													  + ", " + FLIGHT_CLASS + ", " + NUM_OF_PAX + ", " + OUTBOUND_TIME_RANGE + ", " + RETURN_TIME_RANGE + ", " + FLIGHT_KEY
													  + ", " +FLIGHT_NUMBER+ ", " +DEPARTURE_TIME+ ", " +ARRIVAL_TIME+ ", " +PRICE+ ", " +FLAG;
	}
	
	
	public static class BookingProcess{
		public static final String FLAG_BOOKED = "B";
		public static final String FLAG_PAID = "P";
		public static final String FLAG_CANCELED = "C";
		
		//fields				
		public static final String TRX_ID = "TRX_ID";
		public static final String BOOKING_CODE = "BOOKING_CODE";
		public static final String OUTBOUND_FLIGHT_NUMBER = "OUTBOUND_FLIGHT_NUMBER";
		public static final String RETURN_FLIGHT_NUMBER = "RETURN_FLIGHT_NUMBER";
		public static final String FLIGHT_CLASS = "FLIGHT_CLASS";
		public static final String DEPARTURE_DATE = "DEPARTURE_DATE";
		public static final String OUTBOUND_DEPARTURE_TIME = "OUTBOUND_DEPARTURE_TIME";
		public static final String RETURN_DEPARTURE_TIME = "RETURN_DEPARTURE_TIME";
		public static final String RETURN_DATE = "RETURN_DATE";
		public static final String FLIGHT_TYPE = "FLIGHT_TYPE";
		public static final String NUM_OF_PAX = "NUM_OF_PAX";
		public static final String TOTAL_FARES = "TOTAL_FARES";
		public static final String ORIGIN = "ORIGIN";
		public static final String DESTINATION = "DESTINATION";
		public static final String MSISDN = "MSISDN";
		public static final String AIRLINES = "AIRLINES";
		public static final String BOOKING_DATE = "BOOKING_DATE";
		public static final String FLAG = "FLAG";
		public static final String PAYMENT_CODE = "PAYMENT_CODE";
		public static final String OUTBOUND_ARRIVAL_TIME = "OUTBOUND_ARRIVAL_TIME";
		public static final String RETURN_ARRIVAL_TIME = "RETURN_ARRIVAL_TIME";
		
		
		public static final String TRX_FIELDS_QUERY = TRX_ID + ", " + BOOKING_CODE + ", " + OUTBOUND_FLIGHT_NUMBER+ ", " +DEPARTURE_DATE+ ", " +OUTBOUND_DEPARTURE_TIME+ ", " +RETURN_DATE+ ", " +RETURN_DEPARTURE_TIME+ ", " +FLIGHT_TYPE
													  + ", " + NUM_OF_PAX + ", " + TOTAL_FARES + ", " + ORIGIN + ", " + DESTINATION + ", " + MSISDN+ ", " +AIRLINES+ ", " +BOOKING_DATE+ ", " +FLAG+ ", " +PAYMENT_CODE
													  + ", " +RETURN_FLIGHT_NUMBER+ ", " +FLIGHT_CLASS+ ", " +OUTBOUND_ARRIVAL_TIME+ ", " +RETURN_ARRIVAL_TIME;
	}
	
	public static class Common{
		public static final Locale idr = new Locale("id", "ID");
		public static final NumberFormat numberFormatIDR = NumberFormat.getCurrencyInstance(idr);
		public static final String RP = "Rp";
		public static final String DEC_DIGIT = ",00";		
	}
	
	
}
