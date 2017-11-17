package com.joyplus.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class GetRequestJsonUtils {
	
	public static String getRequestJsonString(HttpServletRequest request) throws IOException{
		String submitMethod = request.getMethod();
		if(submitMethod == "GET"){
			return new String(request.getQueryString().getBytes("iso-8859-1"),"utf-8").replaceAll("%22", "\"");
		}else{
			return getRequestPostStr(request);
		}
	}
	
	//Get byte[] from post request
	public static byte[] getRequestPostBytes(HttpServletRequest request)throws IOException{
		int contentLength = request.getContentLength();
		if(contentLength < 0){
			return null;
		}
		byte buffer[] = new byte[contentLength];
		for(int i=0; i<contentLength;){
			int readlen = request.getInputStream().read(buffer, i, contentLength-1);
			if(readlen == -1){
				break;
			}
			i += readlen;
		}
		return buffer;
	}
	
	//Get string from post request
	public static String getRequestPostStr(HttpServletRequest request) throws IOException{
		byte buffer[] = getRequestPostBytes(request);
		String charEncoding = request.getCharacterEncoding();
		if(charEncoding == null){
			charEncoding = "UTF-8";
		}
		return new String(buffer, charEncoding);
	}

}
