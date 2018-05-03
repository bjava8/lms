package com.lms.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//MyBatis 사용해서 작업할 SqlSession을 만들어줄
//SqlSessionFactory 객체 생성을 위한 클래스
public class DBService {
	private static SqlSessionFactory factory;
	
	//static 초기화문
	static {
		try {
			/* config.xml에서 정보를 읽어 SqlSessionFactory 객체 생성
			*************************************
			//MyBatis 설정파일(cofiguration) 위치
			String config = "com/study/mybatis/config.xml";
			//config 파일을 읽을 수 있는 reader 객체 생성
			Reader reader = Resources.getResourceAsReader(config);
			//config 파일 정보를 이용해서 SqlSessionFactory 객체 생성      
			factory = new SqlSessionFactoryBuilder().build(reader);
			*************************************/
			factory = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsReader("com/lms/mybatis/config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
}
