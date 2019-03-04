package com.example.controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        /*for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("---------------------");
        for(Integer in : list){
            System.out.println(in);
        }
        System.out.println("---------------------");
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {

            }
        });*/
        list.forEach(i ->{
            System.out.println(i);
        });
    }
}
