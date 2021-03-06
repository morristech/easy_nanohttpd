package org.lyon_yan.android.nanohttpd.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * servlet加载器
 * 
 * @author Lyon_Yan <br/>
 *         <b>time</b>: 2015年9月18日 上午11:16:30
 */
public class NanoHTTPDServletLoader<V extends NanoHTTPDServlet> {
	private static Map<String, NanoHTTPDServlet> maps = null;

	public V loadNanoHTTPDServlet(String uri) {
		if (maps != null && maps.containsKey(uri)) {
			@SuppressWarnings("unchecked")
			V v2 = (V) maps.get(uri);
			V v = v2;
			return v;
		}
		return null;
	}

	public boolean contains(String uri) {
		return maps.containsKey(uri);
	}

	/**
	 * 注册Servlet
	 * 
	 * @author Lyon_Yan <br/>
	 *         <b>time</b>: 2015年10月24日 下午4:59:21
	 * @param nanoHTTPDServlet
	 */
	public void registNanoHTTPDServlet(V nanoHTTPDServlet) {
		if (maps == null) {
			maps = new HashMap<String, NanoHTTPDServlet>();
		}
		maps.put(nanoHTTPDServlet.getURLPath(), nanoHTTPDServlet);
	}

	/**
	 * 获取已注册的servlet
	 * 
	 * @author Lyon_Yan <br/>
	 *         <b>time</b>: 2015年10月24日 下午5:04:11
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<V> getNanoHTTPDServletList() {
		if (maps == null) {
			return null;
		}
		return new ArrayList<V>((Collection<? extends V>) maps.values());
	}

	public void clear() {
		if (maps == null) {
			return;
		}
		maps.clear();
		maps = null;
	}

}
