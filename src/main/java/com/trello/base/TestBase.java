package com.trello.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;



public class TestBase {
	
	public static Properties prop;
	
	
	public TestBase(){
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Practice_Manali\\TrelloApiProject\\src\\main\\java\\com\\trello\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	public static void initialization(){
		
		RestAssured.authentication = RestAssured.preemptive().basic("username", "password");
		
	}
	
	
	
	
}
