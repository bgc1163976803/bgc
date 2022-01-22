package com.bgc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class bgc {

    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(new Date()));
        System.out.println(new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(new Date()).substring(9,11));
        System.out.println("hello git !!" );
        System.out.println("hello git 33!!" );
        System.out.println("hello git 44!!" );
        System.out.println("master test 44!!" );
        System.out.println("hot-fix test 44!!" );
    }
}
