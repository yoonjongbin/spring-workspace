package com.kh.di;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// hello.properties(부가정보, meta-data)의 내용을 읽어 Hello 객체를 생성 return
public class HelloFactory {
	
	private Hello hello;
	private Properties properties;
	
	private static HelloFactory hf;
	private HelloFactory() {}
	
	public synchronized static HelloFactory getInstance() {
		if(hf==null) {
			hf = new HelloFactory();
		}
		return hf;
	}
	
	// properties file을 추상화, 캡슐화 한 java.util.Properties 객체 생성
	public void setConfigResource(String configResource) {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(configResource);
			
			properties = new Properties();
			properties.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void newInstanceHello(String name) {
		String className = properties.getProperty(name).trim();
		System.out.println("hello.properties에서 추출한 className : " + className);
		
		try {
			Class cls = Class.forName(className);
			Object obj = cls.newInstance();
			
			if(obj instanceof Hello) {
				this.hello = (Hello) obj;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Hello 객체 생성하는 newInstanceHello() 호출 및 Hello 객체를 return
	public Hello getBean(String name) {
		this.newInstanceHello(name);
		return hello;
	}
}
