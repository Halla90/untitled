
package com.company;

import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random dice1 = new Random();
        Random dice2 = new Random();
        boolean won=false;
        boolean six1=false, six2=false;
        int user1point=0, user2point=0, thrownum=0, num1, num2, six1throw=0, six2throw=0;
        num1=1;
        num2=0;
        int turn=0;
        int roll;
        System.out.println("To roll dice, enter 0");
        while(!won){
            roll=scanner.nextInt();
            if(roll==0){
                if(num1!=num2){
                    thrownum++;}
                turn=thrownum % 2;
                if(thrownum==six1throw+2)
                    six1=false;
                if(thrownum==six2throw+2)
                    six2=false;

                if(turn==1)
                    System.out.println("Player 1's turn");
                else
                    System.out.println("Player 2's turn");
                num1=(dice1.nextInt(6))+1;
                num2=(dice2.nextInt(6))+1;

                System.out.println(num1);
                System.out.println(num2);

                if(turn<1){
                    user2point=user2point+num1+num2;}
                else{
                    user1point=user2point+num1+num2;}

                if(num1==num2){
                    if(num1==1){
                        if(turn<1){
                            user2point=0;}
                        else{
                            user1point=0;}}
                    else if(num1==6){
                        if(turn<1){
                            if(!six2){
                                six2=true;
                                six2throw=thrownum;
                            }
                            else{
                                won=true;
                            }
                        }
                        else{
                            if(!six1){
                                six1=true;
                                six1throw=thrownum;}
                            else{
                                won=true;
                                six2throw=thrownum;}
                        }
                    }


                    if(turn<1){
                        if(user2point>=40){
                            won=true;}}
                    else{
                        if(user1point>=40){
                            won=true;}}
                }



            }
            if(turn==1){
                System.out.println("Player 1 has " + user1point + " points");}
            else
                System.out.println("Player 2 has " + user2point + " points");
            if(num1==num2){
                System.out.println("extra throw");
            }
        }

        if(turn<1){
            System.out.print("Player 2 won");}
        else
            System.out.print("Player 1 won");}
}


