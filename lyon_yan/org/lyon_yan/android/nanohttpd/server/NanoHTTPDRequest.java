package org.lyon_yan.android.nanohttpd.server;

import java.util.Map;

import fi.iki.elonen.NanoHTTPD.Method;

/**
 * 请求信息
 * 
 * @author Lyon_Yan <br/>
 *         <b>time</b>: 2015年9月18日 上午11:15:26
 */
public class NanoHTTPDRequest {
	private String uri;
	private Method method;
	private Map<String, String> headers;
	private Map<String, String> parms;
	private Map<String, String> files;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public Map<String, String> getParms() {
		return parms;
	}

	public void setParms(Map<String, String> parms) {
		this.parms = parms;
	}

	public Map<String, String> getFiles() {
		return files;
	}

	public void setFiles(Map<String, String> files) {
		this.files = files;
	}

}