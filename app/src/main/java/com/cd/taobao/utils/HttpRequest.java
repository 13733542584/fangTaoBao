package com.cd.taobao.utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.Volley;

public class HttpRequest {

	private static HttpRequest Instance;

	private RequestQueue mQueue;

	private ImageLoader mLoader;

	private boolean isStop = false;

	private HttpRequest(Context context) {
		mQueue = Volley.newRequestQueue(context);
		mLoader = new ImageLoader(mQueue, new BitmapCache());
	}

	public static HttpRequest getInstance(Context context) {

		if (Instance == null) {
			synchronized (HttpRequest.class) {
				if (Instance == null) {
					Instance = new HttpRequest(context);
				}
			}
		}
		return Instance;
	}

	/**
	 * 加载图片的方法
	 * 
	 * @param requestUrl
	 * @param lis
	 * @param maxWidth
	 * @param maxHeight
	 */
	public void loadImage(String requestUrl, ImageListener lis, int maxWidth,
                          int maxHeight) {
		mLoader.get(requestUrl, lis, maxWidth, maxHeight);
	}

	/**
	 * 发送请求的方法
	 * 
	 * @param request
	 */
	public void sendRequest(Request request) {
		// 把请求放入队列中
		if (isStop) {
			mQueue.start();
		}
		mQueue.add(request);
	}

	/**
	 * 清理的方法
	 */
	public void clear() {
		mQueue.getCache().clear();
	}

	/**
	 * 获取ImageLoader的对象
	 */
	public ImageLoader getImageLoader() {
		return mLoader;
	}

	public void stopQueue() {
		mQueue.stop();
		isStop = true;
	}
}
