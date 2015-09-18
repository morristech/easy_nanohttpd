package org.lyon_yan.android.nanohttpd.server;

import java.util.HashMap;
import java.util.Map;

/**
 * servlet加载器
 * 
 * @author Lyon_Yan <br/>
 *         <b>time</b>: 2015年9月18日 上午11:16:30
 */
public class NanoHTTPDServletLoader {
	private static Map<String, NanoHTTPDServlet> maps = null;

	public static NanoHTTPDServlet loadNanoHTTPDServlet(String uri) {
		if (maps != null && maps.containsKey(uri)) {
			return maps.get(uri);
		}
		return null;
	}

	protected static void registNanoHTTPDServlet(
			NanoHTTPDServlet nanoHTTPDServlet) {
		if (maps == null) {
			maps = new HashMap<String, NanoHTTPDServlet>();
		}
		maps.put(nanoHTTPDServlet.getURLPath(), nanoHTTPDServlet);
	}
}
