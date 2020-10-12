package com.yedam.app.ioc;


public class BeanFactory { //bean객체를 관리해주는 객체 , 얘가 있어야지 TV객체 이용 할 수 있음
	public Object getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		} else if(beanName.equals("lg")) {
			return new LgTV();
		}
		return null;
	}
}
