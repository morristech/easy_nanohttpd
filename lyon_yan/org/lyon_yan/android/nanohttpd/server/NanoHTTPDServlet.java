package org.lyon_yan.android.nanohttpd.server;

import fi.iki.elonen.NanoHTTPD;
/**
 * 简单的servlet接口
 * @author Lyon_Yan
 * <br/><b>time</b>: 2015年9月18日 上午11:15:47
 */
public abstract class NanoHTTPDServlet {
	public abstract String getURLPath();

	public NanoHTTPDServlet() {
		// TODO Auto-generated constructor stub
		NanoHTTPDServletLoader.registNanoHTTPDServlet(this);
	}

	public void init(NanoHTTPD nanoHTTPD, NanoHTTPDRequest nanoHTTPDRequest) {

	}

	public void doGet(NanoHTTPD nanoHTTPD, NanoHTTPDRequest nanoHTTPDRequest) {

	}

	public void doPost(NanoHTTPD nanoHTTPD, NanoHTTPDRequest nanoHTTPDRequest) {

	}

	public void destory() {

	}

}
