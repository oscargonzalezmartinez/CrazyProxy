package org.ogm.crazyproxy.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class DataStore {

	private static List<DataStoreChangeListener> listener = new ArrayList<DataStoreChangeListener>();
	private static Map data = new HashMap();
	
	public static void addListener(DataStoreChangeListener newListener){
		listener.add(newListener);
	}
	public static void set(String key, Object value){
		synchronized (data) {
			
			if (data.containsKey(key)){
				data.remove(key);
			}
			data.put(key, value);
			fireEvent();
		}
	}
	private static void fireEvent() {
		for (DataStoreChangeListener dataStoreChangeListener : listener) {
			dataStoreChangeListener.onChange();
		}
	}
	
	public static <T> T get(String key){
		return (T)data.get(key);
	}

	public static void setMode(String target){
		set("mode",target);
	}
	
	public static String getMode(){
		return get("mode");
	}
	
	public static void setTarget(String target){
		set("target",target);
	}
	
	public static String getTarget(){
		return get("target");
	}
	
	public static Long getRequest(){
		return get("total.request");
	}
	public static Long getExecutionTime(){
		return get("total.executionTime");
	}
	
	public static Long getErrors(){
		return get("total.errors");
	}
	
	public static void setErrorThreshold(Integer value){
		//check 0 - 100
			set("error.threshold",value);
	}
	
	public static Long getDelay(){
		return get("delay");
	}
	
	public static void setDelay(Long value){
		//check 0 - 100
			set("delay",value);
	}
	
	public static Integer getErrorThreshold(){
		return get("error.threshold");
	}
	public static void setPort(Integer port){
		set("port",port);
	}
	
	public static Integer getPort(){
		return get("port");
	}
	
	public static void add(String key, Long value){
		synchronized (data) {
			
			Long targetValue = value;
			if (data.containsKey(key)){
				targetValue+=(Long)data.get(key);
				data.remove(key);
			}
			data.put(key, targetValue);
			fireEvent();
		}
	}
	
	public static void addRequest(){
		add("total.request",1L);
	}
	
	public static void addExecutionTime(long executionTime){
		add("total.executionTime",executionTime);
	}
	
	public static void addError(){
		add("total.errors",1L);
	}
	
	public static String print(){
		StringBuilder sb = new StringBuilder();
		for (Iterator<String> it = data.keySet().iterator(); it.hasNext();){
			String key = it.next();
			Object value = data.get(key);
			sb.append(key).append("=[").append(value).append("]\n");
		}
		
		return sb.toString();
	}
}
