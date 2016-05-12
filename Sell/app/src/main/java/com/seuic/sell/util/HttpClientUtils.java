package com.seuic.sell.util;

import android.text.TextUtils;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.NoHttpResponseException;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.net.ssl.SSLHandshakeException;

public class HttpClientUtils {
	public static final String TAG = "HttpClientUtils";
	
	public static final String QUESTION_SIGN = "?";
	public static final String AND_SIGN = "&";
	public static final String EQUAL_SIGN = "=";
	public static final String GET_METHOD = "GET";
	public static final String POST_METHOD = "POST";
	public static final String PUT_METHOD = "PUT";
    private static final String key = "xiaoheqianwoyufen";
	
	public static final int TIMEOUT_MILLIS = 15000;
    private static String JSESSIONID; //定义一个静态的字段，保存sessionID
	/**
	 * httpResponseWithGetMethod
	 * @param baseURI
	 * @return
	 */
	protected static HttpResponse httpResponseWithGetMethod(String baseURI){
		HttpResponse httpResponse = null;

		HttpGet httpGet = new HttpGet(baseURI);
		HttpClient httpClient = getHttpClient();
		try {
            httpResponse = httpClient.execute(httpGet);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if(statusCode==HttpStatus.SC_OK){
                return httpResponse;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			httpGet = null;
//			httpClient.getConnectionManager().shutdown();
		}
		return httpResponse;
	}

	protected static HttpResponse httpResponseWithGetMethod2(String baseURI){
		HttpResponse httpResponse = null;
		HttpGet httpGet = new HttpGet(baseURI);
		HttpClient httpClient = getHttpClient();
		try {

			httpResponse = httpClient.execute(httpGet);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if(statusCode==HttpStatus.SC_OK){
				return httpResponse;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			httpGet = null;
//			httpClient.getConnectionManager().shutdown();
		}
		return httpResponse;
	}
	
	/**
	 * httpResponseWithPostMethod
	 * @param baseURI
	 * @param json
	 * @return
	 */
	protected static HttpResponse httpResponseWithPostMethod(String baseURI, String json){
		HttpResponse httpResponse = null;
		HttpPost httpPost = null;
		HttpClient httpClient = null;
		try {
			httpPost = new HttpPost(baseURI);
			httpPost.setHeader("Content-Type", "application/json");
			httpPost.setEntity(new StringEntity(json, "UTF-8"));
			httpClient = getHttpClient();
			httpResponse = httpClient.execute(httpPost);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			Log.d(TAG, "statusCode="+statusCode);
			if(statusCode==HttpStatus.SC_OK){
				return httpResponse;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return httpResponse;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return httpResponse;
		} catch (IOException e) {
			e.printStackTrace();
			return httpResponse;
		} finally{
			httpPost = null;
//			httpClient.getConnectionManager().shutdown();
//			httpClient = null;
		}
		return httpResponse;
	}

    /**
     * httpResponseWithPostMethod
     * @param baseURI
     * @param params
     * @return
     */
    protected static HttpResponse httpResponseWithPostMethod(String baseURI, List<NameValuePair> params){
        HttpResponse httpResponse = null;
        HttpPost httpPost = null;
        HttpClient httpClient = null;
        try {
            httpPost = new HttpPost(baseURI);
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            httpClient = getHttpClient();

            httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            Log.d(TAG, "statusCode="+statusCode);
            if(statusCode==HttpStatus.SC_OK){

                return httpResponse;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return httpResponse;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return httpResponse;
        } catch (IOException e) {
            e.printStackTrace();
            return httpResponse;
        } finally{
            httpPost = null;
//			httpClient.getConnectionManager().shutdown();
//			httpClient = null;
        }
        return httpResponse;
    }

	protected static HttpResponse httpResponseWithPostMethod2(String baseURI, List<NameValuePair> params){
		HttpResponse httpResponse = null;
		HttpPost httpPost = null;
		HttpClient httpClient = null;
		try {

			httpPost = new HttpPost(baseURI);
			httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=GBK");
			httpPost.setEntity(new UrlEncodedFormEntity(params, "GBK"));
			httpClient = getHttpClient();

			httpResponse = httpClient.execute(httpPost);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			Log.d(TAG, "statusCode="+statusCode);
			if(statusCode==HttpStatus.SC_OK){
				return httpResponse;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return httpResponse;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return httpResponse;
		} catch (IOException e) {
			e.printStackTrace();
			return httpResponse;
		} finally{
			httpPost = null;
//			httpClient.getConnectionManager().shutdown();
//			httpClient = null;
		}
		return httpResponse;
	}
	
	protected static HttpResponse httpResponseWithPutMethod(String baseURI, String json){
		HttpResponse httpResponse = null;
		HttpPut httpPut = null;
		HttpClient httpClient = null;
		try {
			httpPut = new HttpPut(baseURI);
			httpPut.setHeader("Content-Type", "application/json");
			httpPut.setEntity(new StringEntity(json, "UTF-8"));
			httpClient = getHttpClient();
			httpResponse = httpClient.execute(httpPut);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			Log.d(TAG, "statusCode="+statusCode);
			if(statusCode==HttpStatus.SC_OK){
				return httpResponse;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return httpResponse;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return httpResponse;
		} catch (IOException e) {
			e.printStackTrace();
			return httpResponse;
		} finally{
			httpPut = null;
//			httpClient.getConnectionManager().shutdown();
//			httpClient = null;
		}
		return httpResponse;
	}
	
	/**
     * requestResultFromServer
     * @param method http方式
     * @param baseURI url
     * @param json   参数直接为json的情况
     * @param params  参数通过列表封装
     * @return
     */
	public static String requestResult(String method,String baseURI,String json,List<NameValuePair> params){
		if(baseURI==null||"".equals(baseURI)){
			return null;
		}
		String result = null;
		HttpResponse httpResponse = null;
		HttpEntity resultEntity = null;
		//String entityJSONObject = null;
		if(HttpGet.METHOD_NAME.equals(method)){
			httpResponse = httpResponseWithGetMethod(baseURI);
		}else if(HttpPost.METHOD_NAME.equals(method)){
			if(TextUtils.isEmpty(json)&&params==null){
				return null;
			}
            if(!TextUtils.isEmpty(json)){
                httpResponse = httpResponseWithPostMethod(baseURI, json);
            }else{
                httpResponse = httpResponseWithPostMethod(baseURI, params);
            }

		}else if(HttpPut.METHOD_NAME.equals(method)){
			httpResponse = httpResponseWithPutMethod(baseURI, json);
		}else{
			return null;
		}
		if (httpResponse!=null) {
			try {
				resultEntity = httpResponse.getEntity();
				result = EntityUtils.toString(resultEntity);
				//JSONObject entityJSONObject = new JSONObject(result);
				return result;
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				
			} finally {
				httpResponse = null;
			}
		}
		return null;
	}

	public static String requestResult2(String method,String baseURI,String json,List<NameValuePair> params){
		if(baseURI==null||"".equals(baseURI)){
			return null;
		}
		String result = null;
		HttpResponse httpResponse = null;
		HttpEntity resultEntity = null;
		//String entityJSONObject = null;
		if(HttpGet.METHOD_NAME.equals(method)){
			httpResponse = httpResponseWithGetMethod2(baseURI);
		}else if(HttpPost.METHOD_NAME.equals(method)){
			if(TextUtils.isEmpty(json)&&params==null){
				return null;
			}
			if(!TextUtils.isEmpty(json)){
				httpResponse = httpResponseWithPostMethod(baseURI, json);
			}else{
				httpResponse = httpResponseWithPostMethod2(baseURI, params);
			}

		}else if(HttpPut.METHOD_NAME.equals(method)){
			httpResponse = httpResponseWithPutMethod(baseURI, json);
		}else{
			return null;
		}
		if (httpResponse!=null) {
			try {
				resultEntity = httpResponse.getEntity();
				result = EntityUtils.toString(resultEntity,"GBK");
				//JSONObject entityJSONObject = new JSONObject(result);
				return result;
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				httpResponse = null;
			}
		}
		return null;
	}
	
	protected static DefaultHttpClient getHttpClient(){
		BasicHttpParams httpParams = new BasicHttpParams();
		ConnManagerParams.setTimeout(httpParams, TIMEOUT_MILLIS);
		HttpConnectionParams.setConnectionTimeout(httpParams, 5000);
		HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLIS);
		SchemeRegistry schemeRegistry =new SchemeRegistry();
		schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
		schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
		ClientConnectionManager clientConnectionManager =new ThreadSafeClientConnManager(httpParams, schemeRegistry);
		//DefaultHttpClient httpClient = new DefaultHttpClient(clientConnectionManager, httpParams);
        DefaultHttpClient httpClient = new DefaultHttpClient(httpParams);
		return httpClient;
	}
	
	protected static JSONObject getResponseJSONObject(DefaultHttpClient httpClient,HttpUriRequest request)
			throws ClientProtocolException, IOException{
		JSONObject responseJSONObject = null;
		HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
			@Override
			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
				if(executionCount>5){
					return false;
				}
				if(exception instanceof NoHttpResponseException){
					return true;
				}
				if(exception instanceof SSLHandshakeException){
					return false;
				}
				HttpRequest httpRequest = (HttpRequest) context.getAttribute(ExecutionContext.HTTP_REQUEST);
				if(!(httpRequest instanceof HttpEntityEnclosingRequest)){
					return true;
				}
				return false;
			}
		};
		ResponseHandler<JSONObject> responseHandler = new ResponseHandler<JSONObject>() {
			@Override
			public JSONObject handleResponse(HttpResponse response)throws ClientProtocolException, IOException {
				int statusCode = response.getStatusLine().getStatusCode();
				if(statusCode==HttpStatus.SC_OK){
					HttpEntity httpEntity = response.getEntity();
					if(httpEntity!=null){
						String result = EntityUtils.toString(httpEntity, "UTF-8");
						try {
							return new JSONObject(result);
						} catch (JSONException e) {
							e.printStackTrace();
							return null;
						}
					}
				}
				return null;
			}
		};
		httpClient.setHttpRequestRetryHandler(httpRequestRetryHandler);
		responseJSONObject = httpClient.execute(request, responseHandler);
		releaseHttpRequest(request);
		return responseJSONObject;
	}
	
	protected static void releaseHttpRequest(HttpUriRequest request){
		if(request!=null&&request.isAborted()){
			request.abort();
		}
	}
	
	protected static void releaseHttpClient(DefaultHttpClient httpClient){
		if(httpClient!=null){
			httpClient.getConnectionManager().shutdown(); 
		}
	}


}
