package com.company;

import java.sql.*;

public class DataBaseOpearations {

    Connection dbConnection;

    {
        try {
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3307/chatBot","root","kail1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void makeConnection() {


        try {
            String query = "create table languages(id int primary key,col1 varchar(50) , col2 varchar(50) , col3 varchar(50) ,col4 varchar(50) )";
            Statement statement = dbConnection.createStatement();
            statement.execute(query);

            System.out.println("table1 created SuccessFully");

            String query1 = "create table options(col1 int primary key,col2 varchar(50) , col3 varchar(50))";
            statement.execute(query1);
            System.out.println("table2 create created SuccessFully");

            String query2 = "create table options(id int primary key , col1 varchar(50) , col2 varchar(50),col3 varchar(50) , col4 varchar(50) )";
            statement.execute(query2);
            System.out.println("table options created successFully");

            String query3 = "create table dth(id int primary key , col1 varchar(50) , col2 varchar(50) , col3 varchar(50) )";
            statement.execute(query3);
            System.out.println("tdh table created successfully");

            String query4 ="create table callerTune(id int primary key , col1 varchar(50) , col2 varchar(50) , col3 varchar(50) , col4 varchar(50) )";
            statement.execute(query4);
            System.out.println("callerTune created successfully ");

            String query5 = "create table newOffers(id int primary key, col1 varchar(50), col2 varchar(50) , col3 varchar(50), col4 varchar(50) )";
            statement.execute(query5);
            System.out.println("newOffer table created successfully");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertIntoTables() {


        PreparedStatement statement = null;
        try {
            String query = "insert into languages values(?,?,?,?,?)";
        /*    statement = dbConnection.prepareStatement(query);
            statement.setInt(1,1);
            statement.setString(2,"Recharge");
            statement.setString(3,"DTH");
            statement.setString(4,"Caller Tune");
            statement.setString(5,"New Plan");
            statement.executeUpdate();

            statement.setInt(1,2);
            statement.setString(2,"ரேச்சர்ஜ்");
            statement.setString(3,"டிதிஹ் ");
            statement.setString(4,"காலர் டியுன்");
            statement.setString(5,"நியூ ப்ளன்");
            statement.executeUpdate();


            statement.setInt(1,3);
            statement.setString(2,"రీఛార్జి ");
            statement.setString(3,"డిటిహ్");
            statement.setString(4,"కాలర్ ట్యూన్");
            statement.setString(5,"న్యూ ప్లేన్");
            statement.executeUpdate();
            System.out.println("inserted SuccessFully");


            String query2 = "insert into recharge values(?,?,?)";
            statement = dbConnection.prepareStatement(query2);
            statement.setInt(1,1);
            statement.setString(2,"Recharge By Airtel");
            statement.setString(3,"Coupon Recharge ");
            statement.executeUpdate();
            statement.setInt(1,2);
            statement.setString(2,"ஏர்டெல் மூலம் ரீசார்ஜ்");
            statement.setString(3,"கூப்பன் ரீசார்ஜ்");
            statement.executeUpdate();
            statement.setInt(1,3);
            statement.setString(2,"Airtel ద్వారా రీఛార్జి చేసుకోండి");
            statement.setString(3,"కూపన్ రీఛార్జ్");
            statement.executeUpdate();
            System.out.println("inserted successfully");

         */

            String query3 = "insert into dth values(?,?,?,?)";
            statement = dbConnection.prepareStatement(query3);
            statement.setInt(1,1);
            statement.setString(2,"Airtel DTH HD Plan Rs.251=49Channels+30D");
            statement.setString(3,"Airtel DTH ₹ 285 Pack = 68 Channels+30D");
            statement.setString(4,"Airtel DTH ₹ 252 Pack = 78 Channels+30D");
            statement.executeUpdate();
            System.out.println("inserted to dth successFull");

            String query4 ="insert into callerTune values(?,?,?,?,?)";
            statement = dbConnection.prepareStatement(query4);
            statement.setInt(1,1);
            statement.setString(2,"Arabic Kuthu");
            statement.setString(3,"Mudhal Nee Mudivu Nee");
            statement.setString(4,"Naaga Vera Maari");
            statement.setString(5,"Two Two Two");
            statement.executeUpdate();
            System.out.println("inserted to callerTune SuccessFull");

            String query5 ="insert into newOffers values(?,?,?,?,?)";
            statement = dbConnection.prepareStatement(query5);
            statement.setInt(1,1);
            statement.setString(2,"265=UL call+1GB/D,28D");
            statement.setString(3,"479=UL call+1.5GB/D,56D");
            statement.setString(4,"299=UL call+1.5GB/D28D");
            statement.setString(5,"549=UL call+25GB/D,56D");
            statement.executeUpdate();
            System.out.println("inserted into newOffers SuccessFully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void display (int choice , int size , int userLanguage)  {
            try {
                if(size==0){
                    System.out.println("Select Language");
                    System.out.println("1. English");
                    System.out.println("2. Tamil");
                    System.out.println("3. Telugu");

                }
                else if(size == 1) {
                    String query = "select * from languages where id= " + choice;
                    Statement statement = null;
                    statement = dbConnection.createStatement();
                    ResultSet rs = statement.executeQuery(query);
                    rs.next();
                    System.out.println("1." + rs.getString(2));
                    System.out.println("2." + rs.getString(3));
                    System.out.println("3." + rs.getString(4));
                    System.out.println("4." + rs.getString(5));

                }
                else if(size == 2){
                    if(choice ==1){
                        String query = "select * from recharge where col1= "+userLanguage;
                        Statement statement = dbConnection.createStatement();
                        ResultSet rs = statement.executeQuery(query);
                        rs.next();
                        System.out.println("1." +rs.getString(2));
                        System.out.println("2." +rs.getString(3));
                      //  System.out.println("SuccessFully Recharged");
                    }
                    else if(choice==2){
                        String query = "select * from dth";
                        Statement statement = dbConnection.createStatement();
                        ResultSet rs = statement.executeQuery(query);
                        rs.next();
                        System.out.println("1." + rs.getString(2));
                        System.out.println("2." + rs.getString(3));
                        System.out.println("3." + rs.getString(4));
                    }
                    else if (choice == 3){
                        String query = "select * from callerTune";
                        Statement statement = dbConnection.createStatement();
                        ResultSet rs = statement.executeQuery(query);
                        rs.next();
                        System.out.println("1." +rs.getString(2));
                        System.out.println("2." +rs.getString(3));
                        System.out.println("3." +rs.getString(4));
                        System.out.println("4." +rs.getString(5));
                    }
                    else if(choice == 4){
                        String query = "select * from newOffers";
                        Statement statement = dbConnection.createStatement();
                        ResultSet rs = statement.executeQuery(query);
                        rs.next();
                        System.out.println("1." +rs.getString(2));
                        System.out.println("2." +rs.getString(3));
                        System.out.println("3." +rs.getString(4));
                        System.out.println("4." +rs.getString(5));
                    }
                }

            }
            catch (SQLException e) {
                e.printStackTrace();
            }



    }

}

