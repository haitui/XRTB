package com.xrtb.tests;

import static org.junit.Assert.fail;

import com.xrtb.bidder.RTBServer;
import com.xrtb.common.Configuration;

/**
 * The JUNIT common configuration is done here.
 * @author ben
 *
 */
public class Config {
	/** The hostname the test programs will use for the RTB bidder */
	public static final String testHost = "localhost:8080";
	static RTBServer  server;
	
	public static void setup() throws Exception {
		Configuration c = Configuration.getInstance();
		c.clear();
		try {
		c.initialize("./Campaigns/payday.json");
		server = new RTBServer();
		Thread.sleep(5000);
		} catch (Exception e) {
			fail(e.toString());
		}
	}
	
	public static void teardown() {
		if (server != null)
			server.halt();
	}
}