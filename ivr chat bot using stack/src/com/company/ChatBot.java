package com.company;


import java.util.Scanner;
import java.util.Stack;

public class ChatBot {

    DataBaseOpearations dbo1 = new DataBaseOpearations();

    Stack<Integer> userChoices = new Stack<>();

    Scanner sc = new Scanner(System.in);


    public void fetchDataFromDb() {

        boolean condition = true;
        int userLanguage = 0;
        while(condition){

            if (userChoices.size()==0){
                dbo1.display(0,0,userLanguage);
                System.out.println("0. Exit");
                System.out.println("Enter Your Choice");
                int choice = sc.nextInt();
                if (choice==0){
                    condition = false;
                }
                else if(choice < 4 && choice >0){
                    userChoices.push(choice);
                    userLanguage = choice;
                }
                else {
                    System.out.println("Invalid Input");
                }
            }
            else{
                int stackValue = userChoices.peek();
                dbo1.display(stackValue , userChoices.size() , userLanguage);
                System.out.println("9. Go back");
                System.out.println("0. Exit");
                System.out.println("Enter Your Choice");
                int choice = sc.nextInt();
                if (choice == 0){
                    condition = false;
                }
                else if (choice == 9){
                    userChoices.pop();
                }
                else{
                    userChoices.push(choice);
                }
            }
            if(userChoices.size()==3){
                System.out.println("Option Selected SuccessFully");
                System.out.println("Thanks For Using My Application");
                System.exit(0);
            }

        }

    }
}
