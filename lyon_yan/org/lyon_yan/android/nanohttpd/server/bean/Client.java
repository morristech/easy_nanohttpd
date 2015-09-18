package org.lyon_yan.android.nanohttpd.server.bean;

public class Client {
	private String ip;
	private String port;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public Client(String ip, String port) {
		super();
		this.ip = ip;
		this.port = port;
	}

	public Client() {
		super();
	}

	public String toString() {
		return ip + ":" + port;
	}
}