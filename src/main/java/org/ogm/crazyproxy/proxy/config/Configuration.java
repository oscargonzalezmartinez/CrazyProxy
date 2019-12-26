package org.ogm.crazyproxy.proxy.config;

public class Configuration {
//
//	public Configuration(){
//		initDataStore();
//	}
//	
//	private void initDataStore(){
//		//leer de fichero
//	
//
//		populateInternal();
//		
//		String configFile = System.getProperty("config.file");
//		if (StringUtils.isNotEmpty(configFile)){
//			populate(configFile);
//		}
//		
//		populateEnv();
//	}
//
//	private void populateEnv() {
//		String log4j = System.getProperty("log4j");
//		if (StringUtils.isNotEmpty(log4j)){
//			PropertyConfigurator.configure(log4j);
//		}
//		
//		Properties pro = new Properties();
//		String targetUrl = System.getProperty("target");
//		if (StringUtils.isNotEmpty(targetUrl)){
//			pro.put("target", targetUrl);
//		}
//		
//	
//		String errorThreshold = System.getProperty("error.threshold");
//		if (StringUtils.isNumeric(errorThreshold)){
//			pro.put("error.threshold", errorThreshold);
//		}
//		
//		String delay = System.getProperty("delay");
//		if (StringUtils.isNumeric(delay)){
//			pro.put("delay", delay);
//		}
//		
//		populate(pro);
//	}
//	
//	private void populate(String file){
//		Properties pro = new Properties();
//		try {
//			pro.load(new FileInputStream(file));
//		} catch (FileNotFoundException e) {
//			throw new ProxyException(e);
//		} catch (IOException e) {
//			throw new ProxyException(e);
//		}
//		
//		populate(pro);
//	}
//	
//	private void populateInternal(){
//		
//		Properties pro = new Properties();
//		try {
//			pro.load(getClass().getResourceAsStream("/config/default_config.properties"));
//		} catch (FileNotFoundException e) {
//			throw new ProxyException(e);
//		} catch (IOException e) {
//			throw new ProxyException(e);
//		}
//		
//		populate(pro);
//	}
//	private void populate(Properties pro){
//		
//		String port = pro.getProperty("port");
//		if (StringUtils.isNotEmpty(port)){
//			DataStore.setPort(Integer.valueOf(port));
//		}
//		
//		String targetUrl = pro.getProperty("target");
//		if (StringUtils.isNotEmpty(targetUrl)){
//			DataStore.setTarget(targetUrl);
//		}
//		
//	
//		String errorThreshold = pro.getProperty("error.threshold");
//		if (StringUtils.isNumeric(errorThreshold)){
//			DataStore.setErrorThreshold(Integer.valueOf(errorThreshold));
//		}
//		
//		String delay = pro.getProperty("delay");
//		if (StringUtils.isNumeric(delay)){
//			DataStore.setDelay(Long.valueOf(delay));
//		}
//		
//		String mode = pro.getProperty("mode");
//		if (StringUtils.isNotEmpty(mode)){
//			DataStore.setMode(mode);
//		}
//	}
}
