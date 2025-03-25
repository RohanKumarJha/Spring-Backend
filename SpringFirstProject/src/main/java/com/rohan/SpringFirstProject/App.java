package com.rohan.SpringFirstProject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Alien object = (Alien) context.getBean("Alien");
        System.out.println(object.hashCode());
        Alien object2 = (Alien) context.getBean("Alien");
        System.out.println(object2.hashCode());
        System.out.println("Alien age is "+object.getAge());
        object.show();
    }
}
