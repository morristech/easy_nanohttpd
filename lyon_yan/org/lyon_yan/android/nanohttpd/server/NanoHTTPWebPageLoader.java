package org.lyon_yan.android.nanohttpd.server;

import java.io.File;

import android.os.Environment;

/**
 * web页面加载器，*.*等web页面必备的文件进行加载
 * 
 * @author Lyon_Yan <br/>
 *         <b>time</b>: 2015年10月24日 上午11:09:32
 */
public class NanoHTTPWebPageLoader {
	/**
	 * 默认web资源的路径是SDK的路径
	 */
	private static String webContent_PATH = Environment
			.getExternalStorageDirectory() + File.pathSeparator;

	/**
	 * 设置web资源的路径
	 * 
	 * @author Lyon_Yan <br/>
	 *         <b>time</b>: 2015年10月24日 下午12:57:44
	 * @param webContent_PATH
	 */
	public static void setWebContent_PATH(String webContent_PATH) {
		NanoHTTPWebPageLoader.webContent_PATH = webContent_PATH;
	}

	/**
	 * 获取web资源路径
	 * 
	 * @author Lyon_Yan <br/>
	 *         <b>time</b>: 2015年10月24日 下午12:58:49
	 * @return
	 */
	public static String getWebContent_PATH() {
		return webContent_PATH;
	}
}
