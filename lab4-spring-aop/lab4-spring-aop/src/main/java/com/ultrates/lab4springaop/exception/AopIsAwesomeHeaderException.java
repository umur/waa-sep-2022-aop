package com.ultrates.lab4springaop.exception;

public class AopIsAwesomeHeaderException extends Exception{
    public AopIsAwesomeHeaderException(){
        super();
    }
    public AopIsAwesomeHeaderException(String msg){
        super(msg);
        System.out.println(msg);
    }
}
