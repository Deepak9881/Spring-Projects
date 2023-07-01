package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Team;

public class TestSpringFirst {
	
	public static void main(String[] args) {
//		XmlBeanFactory bf=new XmlBeanFactory(new ClassPathResource("SpringConfig.xml"));
//		ApplicationContext ct=new ClassPathXmlApplicationContext("SpringConfig.xml");
//		System.out.println("before get");
//		HelloWorld hw=(HelloWorld) ct.getBean("ms");
//		System.out.println("after");
//		hw.greet();
		
		ApplicationContext ct=new ClassPathXmlApplicationContext("SpringConfig.xml");
//		System.out.println("Before");
//		Player p=(Player)ct.getBean("p1");
//		System.out.println("after");
//		System.out.println(p.getPid());
//		System.out.println(p.getPname());
		
		Team t1=(Team)ct.getBean("t1");
		System.out.println(t1);
	}

}
