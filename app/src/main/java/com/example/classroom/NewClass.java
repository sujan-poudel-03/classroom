package com.example.classroom;

public class NewClass {

    public static void main(String[] args){
        System.out.println("Hello from new class..");
        if(args.length > 0){
            System.out.println("Arguments passed to NewClass");
            for(String arg: args){
                System.out.println((arg));
            }
        } else {
            System.out.println("No arguments passed..");
        }
    }
}
