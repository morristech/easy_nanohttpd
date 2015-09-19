package org.lyon_yan.android.nanohttpd.server;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.Method;
import fi.iki.elonen.NanoHTTPD.Response;

/**
 * 简单的servlet接口
 * 
 * @author Lyon_Yan <br/>
 *         <b>time</b>: 2015年9月18日 上午11:15:47
 */
public abstract class NanoHTTPDServlet {
	public abstract String getURLPath();

	public NanoHTTPDServlet() {
		NanoHTTPDServletLoader<NanoHTTPDServlet> nanoHTTPDServletLoader = new NanoHTTPDServletLoader<>();
		nanoHTTPDServletLoader.registNanoHTTPDServlet(this);
	}

	public NanoHTTPDServlet(NanoHTTPD nanoHTTPD,
			NanoHTTPDRequest nanoHTTPDRequest) {
		// TODO Auto-generated constructor stub
		NanoHTTPDServletLoader<NanoHTTPDServlet> nanoHTTPDServletLoader = new NanoHTTPDServletLoader<>();
		nanoHTTPDServletLoader.registNanoHTTPDServlet(this);
		init(nanoHTTPD, nanoHTTPDRequest);
		excute(nanoHTTPD, nanoHTTPDRequest);
	}
	public Response excute(NanoHTTPD nanoHTTPD,
			NanoHTTPDRequest nanoHTTPDRequest) {
		Method method = nanoHTTPDRequest.getMethod();
		if (method.equals(Method.POST)) {
			return doPost(nanoHTTPD, nanoHTTPDRequest);
		} else {
			return doGet(nanoHTTPD, nanoHTTPDRequest);
		}
	}

	public void init(NanoHTTPD nanoHTTPD, NanoHTTPDRequest nanoHTTPDRequest) {

	}

	protected Response doGet(NanoHTTPD nanoHTTPD,
			NanoHTTPDRequest nanoHTTPDRequest) {
		return nanoHTTPD.newFixedLengthResponse("null");
	}

	protected Response doPost(NanoHTTPD nanoHTTPD,
			NanoHTTPDRequest nanoHTTPDRequest) {
		return nanoHTTPD.newFixedLengthResponse("null");
	}

	public void destory() {

	}

}
