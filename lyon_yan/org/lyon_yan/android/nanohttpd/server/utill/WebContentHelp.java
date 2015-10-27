package org.lyon_yan.android.nanohttpd.server.utill;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

/**
 * webContent助手
 * 
 * @author Lyon_Yan <br/>
 *         <b>time</b>: 2015年10月27日 上午11:34:32
 */
public class WebContentHelp {
	/**
	 * 复制指定目录的assets资源至目标路径
	 * 
	 * @author Lyon_Yan <br/>
	 *         <b>time</b>: 2015年10月27日 上午11:34:51
	 * @param context
	 * @param assets_name
	 *            assets资源目录
	 * @param to_path
	 *            目标路径
	 * @throws IOException 
	 */
	public static void copyAssetsToPath(Context context, String assets_name,
			String to_path) throws IOException {
		copyAssetDirToFiles(context, to_path, assets_name);
	}

	/**
	 * 复制Assets指定目录资源至指定的目录
	 * 
	 * @author Lyon_Yan <br/>
	 *         <b>time</b>: 2015年10月27日 上午9:33:26
	 * @param context
	 * @param to_path
	 * @param dirname
	 *            不允許为空或者“”
	 * @throws IOException
	 */
	private static void copyAssetDirToFiles(Context context, String to_path,
			String dirname) throws IOException {
		File dir = new File(to_path + "/" + dirname);
		if (dir.exists()) {
			dir.delete();
		}
		dir.mkdirs();
		String[] children;
		AssetManager assetManager = context.getAssets();
		children = assetManager.list(dirname);
		for (String child : children) {
			child = dirname + "/" + child;
			String[] grandChildren = assetManager.list(child);
			if (0 == grandChildren.length)
				copyAssetFileToFiles(context, to_path, child);
			else
				copyAssetDirToFiles(context, to_path, child);
		}
	}

	private static final String TAG = "org.lyon_yan.android.nanohttpd.server.utill.WebContentHelp";

	/**
	 * 复制单个文件至指定目录
	 * 
	 * @author Lyon_Yan <br/>
	 *         <b>time</b>: 2015年10月27日 上午9:39:42
	 * @param context
	 * @param to_path
	 * @param filename
	 * @throws IOException
	 */
	private static void copyAssetFileToFiles(Context context, String to_path,
			String filename) throws IOException {
		Log.i(TAG, "\n\nto_path:" + to_path + "\nfilename:" + filename);
		InputStream is = context.getAssets().open(filename);
		byte[] buffer = new byte[is.available()];
		is.read(buffer);
		is.close();
		String t = "/";
		File of = new File(
				to_path.lastIndexOf(t) == to_path.length() - 1 ? to_path
						+ filename : to_path + t + filename);
		Log.i(TAG,
				"\n\nto_path:"
						+ to_path
						+ "\nfilename:"
						+ (to_path.lastIndexOf(t) == to_path.length() - 1 ? to_path
								+ t + filename
								: to_path + filename));
		if (of.exists()) {
			of.delete();
		}
		of.createNewFile();
		FileOutputStream os = new FileOutputStream(of);
		os.write(buffer);
		os.close();
	}
}
