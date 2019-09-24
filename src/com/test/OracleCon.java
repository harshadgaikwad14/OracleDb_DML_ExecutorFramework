package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

class OracleCon {

	public static void main(String args[]) {
		//Connection con = null;
		
		//ResultSet rs = null;
		final String insertStatement = "Insert into OLM_INCO_TXN (TYP_ENTITY,COD_ENTITY,NBR_TXNID,AMT_TXN,FLG_DRCR,DAT_TXN_VAL,DAT_TXN_POST,COD_TXNTYPE,TXT_NARRATION,FLG_BREACH,COD_BREACHACTION,COD_MAKER,DAT_MAKER,COD_CHECKER,DAT_CHECKER,NBR_ENTITY_TXNID,NBR_PROCESSID,BVT_STATUS,AMT_LGRTXN,BVT_KIND,DAT_BUSINESS,TXT_BALANCEMODE,TXT_ACCTENTRYMODE,FLG_SNDMT920) values ('INCOLOAN','9',?,10000,'C',to_date('06-08-19','DD-MM-RR'),to_date('06-08-19','DD-MM-RR'),'EODSWP',null,'N',null,null,null,null,null,'116',214,null,null,null,null,null,null,null)";
		//PreparedStatement preparedStatement = null;

		try (Connection conn = OracleSourceConnection.getSoruceConnection(); Statement stmt = conn.createStatement();PreparedStatement preparedStatement = conn.prepareStatement(insertStatement)) {

		

			// step1 load the driver class
			//Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "LMS1", "LMS1");
			//con.setAutoCommit(true);
			// step3 create the statement object
			

			// step4 execute query
			/*
			 * rs = stmt.executeQuery("select * from TEST1"); while (rs.next())
			 * System.out.println(rs.getInt(1));
			 */

			/*
			 * System.out.println("SQl : " + Data.getInsert_OLM_INCO_TXN(1));
			 * 
			 * stmt.executeUpdate(Data.getInsert_OLM_INCO_TXN(1));
			 * 
			 * System.out.println("Done");
			 */

			//preparedStatement = con.prepareStatement(insertStatement);

			preparedStatement.setLong(1, 3);

			int row = preparedStatement.executeUpdate();

			// rows affected
			System.out.println(row); // 1

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		} 
	}
}