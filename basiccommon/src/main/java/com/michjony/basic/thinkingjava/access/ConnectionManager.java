package com.michjony.basic.thinkingjava.access;

public class ConnectionManager {
	private ConnectionManager(){}
	static int howManyLeft = 3 ;
	static Connection[] colls  = new Connection[3];
	{
		for (Connection con : colls) {
			con = Connection.makeConnection();
		}
	}
	
	public static Connection getConnection(){
		if(howManyLeft>0){
			return colls[--howManyLeft];
		}else{
			System.out.println("no connections");
			return null ; 
		}
	}
	
	public static void main(String[] args) {
		ConnectionManager cm = new ConnectionManager();
		System.out.println(cm.howManyLeft); //3
		cm.getConnection();
		System.out.println(cm.howManyLeft); //2
		cm.getConnection();
		System.out.println(cm.howManyLeft); //1
		cm.getConnection();
		System.out.println(cm.howManyLeft); //0
		cm.getConnection();                 // null
		System.out.println(cm.howManyLeft); //0
	}
}

class Connection{
	private static int count = 0;
	private Connection(){
		System.out.println("Connection create");
	}
	static Connection makeConnection(){
		count++;
		return new Connection();
	}
	public static int howMany(){
		return count ;
	}
	public String toString(){
		return ("Connection " + count) ;
	}
}

