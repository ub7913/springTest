package com.yedam.app.ioc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUserContainer {

	public static void main(String[] args) {

		AbstractApplicationContext  factory =
				new GenericXmlApplicationContext("applicationContext.xml");//필요한 bean을 이 xml에 담을 수 있다
//		TV tv = (TV)factory.getBean("tv");
//		
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		Speaker speaker1 = (Speaker) factory.getBean("sony");//getBean은 @Autowired와 같은 것인데 받을때 어떻게 받아 오는지 비교하기 위해 빈을 만듬
		Speaker speaker2 = (Speaker) factory.getBean("sony");
		System.out.println(speaker1 == speaker2 ? "yes" : "no");
	}
}
