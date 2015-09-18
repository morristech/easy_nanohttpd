package org.lyon_yan.android.nanohttpd.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lyon_yan.android.nanohttpd.server.bean.Client;

public class NanoHTTPDRequestClientManager {
	private static Map<String, Client> map = null;

	public static void registClient(Client client) {
		if (map == null) {
			map = new HashMap<>();
		}
		map.put(client.getIp(), client);
	}

	public static List<Client> getClientList() {
		if (map == null) {
			map = new HashMap<>();
		}
		return new ArrayList<Client>(map.values());
	}

}
