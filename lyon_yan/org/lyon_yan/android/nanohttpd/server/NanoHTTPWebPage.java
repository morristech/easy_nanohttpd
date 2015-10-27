package org.lyon_yan.android.nanohttpd.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.lyon_yan.android.nanohttpd.server.bean.MIME_TYPES;

import android.os.Environment;
import android.util.Log;
import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.Response;

/**
 * web页面加载器，*.*等web页面必备的文件进行加载
 * 
 * @author Lyon_Yan <br/>
 *         <b>time</b>: 2015年10月24日 上午11:09:32
 */
public class NanoHTTPWebPage extends NanoHTTPDServlet{
	/**
	 * 默认web资源的路径是SDK的路径
	 */
	private static String webContent_PATH = Environment
			.getExternalStorageDirectory() + File.separator;

	/**
	 * 设置web资源的路径
	 * 
	 * @author Lyon_Yan <br/>
	 *         <b>time</b>: 2015年10月24日 下午12:57:44
	 * @param webContent_PATH
	 */
	public static void setWebContent_PATH(String webContent_PATH) {
		NanoHTTPWebPage.webContent_PATH = webContent_PATH;
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

	public NanoHTTPWebPage() {
		// TODO Auto-generated constructor stub
	}
	public Response excute(NanoHTTPD nanoHTTPD,
			NanoHTTPDRequest nanoHTTPDRequest) {
		String mimeType = MIME_TYPES.MIME_DEFAULT_BINARY;
		FileInputStream fileInputStream=null;
		try {
			String uri = nanoHTTPDRequest.getUri();
			int t = uri.lastIndexOf(".");
			if (t < 0) {

			} else {
				String temp = uri.substring(t+1);
				if (MIME_TYPES.MIME_TYPES.containsKey(temp)) {
					mimeType = MIME_TYPES.MIME_TYPES.get(temp);
				}
			}
			Log.i("lyon1",
					"\n\n-------------------------------------------------->\n:"
							+ getWebContent_PATH()+uri);
			File file = new File(getWebContent_PATH()+uri);
			if (file.exists() && !file.isDirectory()) {
				fileInputStream=new FileInputStream(file);
				return nanoHTTPD.newFixedLengthResponse(Response.Status.OK,
						mimeType, fileInputStream, file.length());
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			try {
//				fileInputStream.close();
				fileInputStream=null;
				HttpdServer.gc();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nanoHTTPD.newFixedLengthResponse(Response.Status.NOT_FOUND,
				mimeType, "404");
	}
	@Override
	public String getURLPath() {
		// TODO Auto-generated method stub
		return null;
	}

}
