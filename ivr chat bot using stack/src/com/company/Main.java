package com.company;



public class Main {

    public static void main(String[] args)  {
	// write your code here
        DataBaseOpearations dbo = new DataBaseOpearations();
        ChatBot cb = new ChatBot();
       // cb.menu();
        cb.fetchDataFromDb();
      // dbo.makeConnection();
      // dbo.insertIntoTables();
    }
}
