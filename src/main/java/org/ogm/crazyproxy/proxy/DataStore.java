package org.ogm.crazyproxy.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataStore {

	private List<DataStoreChangeListener> listener = new ArrayList<DataStoreChangeListener>();
	private Map data = new HashMap();
	
	@Value("${target}")
	private String target = null;
	
	//@Value("${mode}")
	private String mode = null;
	
	@Value("${error-threshold}")
	private Long ErrorThreshold = null;
	
	@Value("${delay}")
	private Long delay = null;
	
	public void addListener(DataStoreChangeListener newListener){
		listener.add(newListener);
	}
	
	public void set(String key, Object value){
		synchronized (data) {
			
			if (data.containsKey(key)){
				data.remove(key);
			}
			data.put(key, value);
			fireEvent();
		}
	}
	
	private void fireEvent() {
		for (DataStoreChangeListener dataStoreChangeListener : listener) {
			dataStoreChangeListener.onChange();
		}
	}
	
	public <T> T get(String key){
		return (T)data.get(key);
	}

	
	public  Long getRequest(){
		return get("total.request");
	}
	public  Long getExecutionTime(){
		return get("total.executionTime");
	}
	
	
	public  void add(String key, Long value){
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
	
	public  void addRequest(){
		add("total.request",1L);
	}
	
	public  void addExecutionTime(long executionTime){
		add("total.executionTime",executionTime);
	}
	
	public  void addError(){
		add("total.errors",1L);
	}
	
	public  Long getErrors(){
		return get("total.errors");
	}
	
	public  String print(){
		StringBuilder sb = new StringBuilder();
		for (Iterator<String> it = data.keySet().iterator(); it.hasNext();){
			String key = it.next();
			Object value = data.get(key);
			sb.append(key).append("=[").append(value).append("]\n");
		}
		
		return sb.toString();
	}
	public  List<DataStoreChangeListener> getListener() {
		return listener;
	}
	public  void setListener(List<DataStoreChangeListener> listener) {
		this.listener = listener;
	}
	public  Map getData() {
		return data;
	}
	public  void setData(Map data) {
		this.data = data;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public Long getErrorThreshold() {
		return ErrorThreshold;
	}
	public void setErrorThreshold(Long errorThreshold) {
		ErrorThreshold = errorThreshold;
	}
	public Long getDelay() {
		return delay;
	}
	public void setDelay(Long delay) {
		this.delay = delay;
	}
}
