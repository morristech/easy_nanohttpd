package org.lyon_yan.android.nanohttpd.server;

import java.util.Map;

import fi.iki.elonen.NanoHTTPD;

/**
 * 简单的httpd服务器
 * 
 * @author Lyon_Yan <br/>
 *         <b>time</b>: 2015年10月26日 上午11:32:04
 */
public class HttpdServer extends NanoHTTPD {
	private NanoHTTPDServletLoader<NanoHTTPDServlet> nanoHTTPDServlet = new NanoHTTPDServletLoader<NanoHTTPDServlet>();

	public HttpdServer(int port) {
		super(port);
		// TODO Auto-generated constructor stub
	}

	public HttpdServer(String hostname, int port) {
		super(hostname, port);
		// TODO Auto-generated constructor stub
	}

	public void setNanoHTTPDServlet(
			NanoHTTPDServletLoader<NanoHTTPDServlet> nanoHTTPDServlet) {
		this.nanoHTTPDServlet = nanoHTTPDServlet;
	}

	public NanoHTTPDServletLoader<NanoHTTPDServlet> getNanoHTTPDServlet() {
		return nanoHTTPDServlet;
	}

	/**
	 * 设置web资源路径为系统的绝对路径
	 * 
	 * @author Lyon_Yan <br/>
	 *         <b>time</b>: 2015年10月26日 下午1:39:20
	 * @param webContent_PATH
	 */
	public void setWebContentIsOS(String webContent_PATH) {
		NanoHTTPWebPage.setWebContent_PATH(webContent_PATH);
	}

	@Override
	public Response serve(String uri, Method method,
			Map<String, String> headers, Map<String, String> parms,
			Map<String, String> files) {
		// TODO Auto-generated method stub
		NanoHTTPDRequest nanoHTTPDRequest = new NanoHTTPDRequest(uri, method,
				headers, parms, files);
		if (nanoHTTPDServlet.contains(uri)) {
			/**
			 * 加载指定URL的servlet来处理请求
			 */
			return nanoHTTPDServlet.loadNanoHTTPDServlet(uri).excute(this,
					nanoHTTPDRequest);
		} else {
			/**
			 * web资源管理器，用于加载静态的web页面资源文件
			 */
			return new NanoHTTPWebPage().excute(this, nanoHTTPDRequest);
		}
	}
}
