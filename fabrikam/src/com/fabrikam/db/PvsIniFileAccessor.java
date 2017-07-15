/*
 *	PvsIniFileAccessor.java
 *	Class outline:
 *		Configuration file access class.
 *
 *	History:
 *		NO	Data		Version		Updated by		Content of change
 *		1	2007/01		V01L01		FUJITSU			princeps edition.
 */

package com.fabrikam.db;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Control a configuration file.<br>
 *
 * Read a configuration file and store configuration information.
 * @see java.io.FileInputStream
 * @see java.io.FileNotFoundException
 * @see java.io.IOException
 * @see java.util.Properties
 */
public class PvsIniFileAccessor {

	/**
	 * Configuration file name.
	 */
	private static final String INI_FIME_NAME = "/Application.properties";

	/**
	 * Polling interval.
	 */
	public static final String KEY_POLLING_INTERVAL = "Polling.Interval";
	public static final String CONNECTION_URL = "db.url";
	public static final String DB_USER = "db.user";
	public static final String DB_PASSWORD = "db.password";
	public static final String TANDACONNECTION_URL = "TandAdb.url";
	public static final String TANDADB_USER = "TandAdb.user";
	public static final String TANDADB_PASSWORD = "TandAdb.password";

	/**
	 * Instance
	 */
	private static PvsIniFileAccessor iniFileAccessor = new PvsIniFileAccessor();
	/**
	 * To store configuration information.
	 */
	private Properties iniInfo = null;


	/**
	 * Read configuration file and construct configuration file accessor class.
	 */
	private PvsIniFileAccessor() {

		FileInputStream inStream = null;
		iniInfo = new Properties();
		try {

			//inStream = new FileInputStream(INI_FIME_NAME);
			//iniInfo.load(inStream);
			//Properties properties = new Properties() ;
			iniInfo.load(PvsIniFileAccessor.class.getResourceAsStream("/Application.properties"));
			//iniInfo.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("/Application.properties"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		/*catch (FileNotFoundException fnfEx) {
		}*/
		/*catch (IOException ioEx) {
		}
		catch (IllegalArgumentException iaEx) {
		}*/
		finally {

			try {

				if (null != inStream) {

					inStream.close();
				}
			}
			catch (Exception ex) {
			}
		}
	}


	/**
	 * Get a configuration file accessor.(
	 *
	 * @return	PvsIniFileAccessor
	 */
	public static PvsIniFileAccessor getInstance() {
		if(iniFileAccessor==null)
		iniFileAccessor = new PvsIniFileAccessor();
		return iniFileAccessor;
	}


	/**
	 * Get a configuration information of specified key.<br>
	 * If the information doesn't exit, return null character.
	 *
	 * @param	key		Configuration information of specified key.
	 * @return	Configuration information.
	 */
	public String getIniInfo(String key) {

		if (null == iniInfo) {

			return "";
		}

		String info = iniInfo.getProperty(key);
		if (null == info) {

			return "";
		}
		return info;
	}
}
