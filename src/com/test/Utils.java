package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.test.oracle.data.replication.utils.ConnectionPool;

public class Utils {

	public static int olmIncoTxnTableInsertTask(final long nbrTxnId, final String threadName) {

		System.out.println("ThreadName : " + threadName + " -- nbrTxnId : " + nbrTxnId);
		final String insertStatement = "Insert into OLM_INCO_TXN (TYP_ENTITY,COD_ENTITY,NBR_TXNID,AMT_TXN,FLG_DRCR,DAT_TXN_VAL,DAT_TXN_POST,COD_TXNTYPE,TXT_NARRATION,FLG_BREACH,COD_BREACHACTION,COD_MAKER,DAT_MAKER,COD_CHECKER,DAT_CHECKER,NBR_ENTITY_TXNID,NBR_PROCESSID,BVT_STATUS,AMT_LGRTXN,BVT_KIND,DAT_BUSINESS,TXT_BALANCEMODE,TXT_ACCTENTRYMODE,FLG_SNDMT920) values ('INCOLOAN','9',?,10000,'C',to_date('06-08-19','DD-MM-RR'),to_date('06-08-19','DD-MM-RR'),'EODSWP',null,'N',null,null,null,null,null,'116',214,null,null,null,null,null,null,null)";
		int row = 0;
		try (final Connection conn = OracleSourceConnection.getSoruceConnection();
				final PreparedStatement preparedStatement = conn.prepareStatement(insertStatement)) {

			preparedStatement.setLong(1, nbrTxnId);

			row = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return row;

	}

	public static int saveOlmIncoTxnData(final long nbrTxnId, final ConnectionPool connectionPool,final DataSource dataSource) throws SQLException {

		System.out.println("saveOlmIncoTxnData >> ThreadName : " + Thread.currentThread().getName()
				+ " -- Nbr Txn Id : " + nbrTxnId);
		final String insertStatement = "Insert into OLM_INCO_TXN (TYP_ENTITY,COD_ENTITY,NBR_TXNID,AMT_TXN,FLG_DRCR,DAT_TXN_VAL,DAT_TXN_POST,COD_TXNTYPE,TXT_NARRATION,FLG_BREACH,COD_BREACHACTION,COD_MAKER,DAT_MAKER,COD_CHECKER,DAT_CHECKER,NBR_ENTITY_TXNID,NBR_PROCESSID,BVT_STATUS,AMT_LGRTXN,BVT_KIND,DAT_BUSINESS,TXT_BALANCEMODE,TXT_ACCTENTRYMODE,FLG_SNDMT920) values ('INCOLOAN','9',?,10000,'C',to_date('06-08-19','DD-MM-RR'),to_date('06-08-19','DD-MM-RR'),'EODSWP',null,'N',null,null,null,null,null,'116',214,null,null,null,null,null,null,null)";
		int row = 0;
		
		final Connection connection = dataSource.getConnection();
		connection.setAutoCommit(true);

		if (connection != null) {

			try (final Connection conn = connection;
					final PreparedStatement preparedStatement = conn.prepareStatement(insertStatement)) {

				preparedStatement.setLong(1, nbrTxnId);

				row = preparedStatement.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();

			}

		}

		return row;

	}

	public static int olmIncoTxnTableDeleteAllTask() {

		final String insertStatement = "Delete from OLM_INCO_TXN";
		int row = 0;
		try (final Connection conn = OracleSourceConnection.getSoruceConnection();
				final PreparedStatement preparedStatement = conn.prepareStatement(insertStatement)) {

			row = preparedStatement.executeUpdate();
			System.out.println("Deleted Row : " + row);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return row;

	}

	public static int deleteAllOlmIncoTxnData(final ConnectionPool connectionPool,final DataSource dataSource) throws SQLException {

		final String insertStatement = "Delete from OLM_INCO_TXN";
		int row = 0;
		final Connection connection = dataSource.getConnection();
		connection.setAutoCommit(true);
		if (connection != null) {

			try (final Connection conn = connection;
					final PreparedStatement preparedStatement = conn.prepareStatement(insertStatement)) {

				row = preparedStatement.executeUpdate();
				System.out.println("Deleted Row : " + row);

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		return row;

	}

	public static int testTableInsertTask(final long empId, final String threadName) {

		System.out.println("ThreadName : " + threadName + " -- Employee Id : " + empId);

		final String insertStatement = "Insert into TEST1 (EMPID,ENAME,SALARY) values (?,?,100)";
		int row = 0;
		try (final Connection conn = OracleSourceConnection.getSoruceConnection();
				final PreparedStatement preparedStatement = conn.prepareStatement(insertStatement)) {

			preparedStatement.setLong(1, empId);
			preparedStatement.setString(2, "Test" + empId);

			row = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return row;

	}

	public static int saveTestData(final long empId, final ConnectionPool connectionPool,final DataSource dataSource) throws SQLException {

		System.out.println(
				"saveTestData >> ThreadName : " + Thread.currentThread().getName() + " -- Employee Id : " + empId);

		final String insertStatement = "Insert into TEST1 (EMPID,ENAME,SALARY) values (?,?,100)";
		int row = 0;
		final Connection connection = dataSource.getConnection();
		connection.setAutoCommit(true);
		if (connection != null) {

			try (final Connection conn = connection;
					final PreparedStatement preparedStatement = conn.prepareStatement(insertStatement)) {

				preparedStatement.setLong(1, empId);
				preparedStatement.setString(2, "Test" + empId);

				row = preparedStatement.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		return row;

	}

	public static int testTableDeleteAllTask() {

		final String insertStatement = "Delete from TEST1";
		int row = 0;
		try (final Connection conn = OracleSourceConnection.getSoruceConnection();
				final PreparedStatement preparedStatement = conn.prepareStatement(insertStatement)) {

			row = preparedStatement.executeUpdate();
			System.out.println("Deleted Row : " + row);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return row;

	}

	public static int deleteAllTestData(final ConnectionPool connectionPool,final DataSource dataSource) throws SQLException {

		final String insertStatement = "Delete from TEST1";
		int row = 0;
		final Connection connection = dataSource.getConnection();
		connection.setAutoCommit(true);
		if (connection != null) {

			try (final Connection conn = connection;
					final PreparedStatement preparedStatement = conn.prepareStatement(insertStatement)) {

				row = preparedStatement.executeUpdate();
				System.out.println("Deleted Row : " + row);

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		return row;

	}

}
