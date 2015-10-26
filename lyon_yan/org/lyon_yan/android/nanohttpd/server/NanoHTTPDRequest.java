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
	/**
	 * request请求时的uri
	 */
	private String uri;
	/**
	 * request请求提交的方式
	 */
	private Method method;
	/**
	 * request请求时提交的数据包
	 */
	private Map<String, String> headers;
	/**
	 * request请求时携带的表单式数据
	 */
	private Map<String, String> parms;
	private Map<String, String> files;
	/**
	 * request请求是所携带的字符串
	 */
	private String queryString = null;
	public static final String QUERY_STRING = "NanoHTTPD.QUERY_STRING";

	public NanoHTTPDRequest() {
		super();
	}

	public NanoHTTPDRequest(String uri, Method method,
			Map<String, String> headers, Map<String, String> parms,
			Map<String, String> files) {
		super();
		setUri(uri);
		setMethod(method);
		setHeaders(headers);
		setParms(parms);
		setFiles(files);
		if (getParms().containsKey(QUERY_STRING)) {
			setQueryString(getParms().get(QUERY_STRING));
			getParms().remove(QUERY_STRING);
		}
	}

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

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getQueryString() {
		return queryString;
	}
}