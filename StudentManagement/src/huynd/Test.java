/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynd;

import java.io.IOException;
import java.io.Console;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Lawliet
 */
public class Test {
    public static void main(String[] args) {
        JFrame f=new JFrame();//Tao instance cua JFrame  
          
JButton b=new JButton("Giống chưa");//Tao instance cua JButton  
b.setBounds(1100,400,600, 50);//truc x, truc y, do rong, chieu cao  
    
JButton b2=new JButton("Start Game");//Tao instance cua JButton  
b2.setBounds(1100,600,600, 50);//truc x, truc y, do rong, chieu cao 

JButton b3=new JButton("Setting");//Tao instance cua JButton  
b3.setBounds(1100,800,600, 50);//truc x, truc y, do rong, chieu cao 
          
f.add(b);//Them button vao trong JFrame  
f.add(b2);
f.add(b3);
          
f.setSize(2500,2000);//Do rong la 400 va chieu cao la 500  
f.setLayout(null);//Khong su dung Layout Manager  
f.setVisible(true);//Tao Frame la co the nhin thay (visible)  

    }
}
