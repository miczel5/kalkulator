package pl.paczka;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class kalkulator implements ActionListener{
   JTextField t1;
   JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b12, clean;
   JButton bplus, brow, bmin, bmul, bdiv, bdot, bper, bsqrt;
   double x,buf;
   char temp=' ';
   
   public static void main(String[] args){                                                                         
         SwingUtilities.invokeLater(new Runnable() {                                            
         public void run(){                                         
            new kalkulator().init(); } });} 
   
   
   
   public void actionPerformed(ActionEvent e){        
      Object target = e.getSource();  
      System.out.println(((JButton)target).getText());
      if(target==clean)                                           
      {  buf = 0;                                                      
         t1.setText(""); 
         t1.requestFocus();} 
      else if(target==b0){                                                        
         t1.setText(t1.getText()+((JButton)target).getText()); 
         t1.requestFocus();} 
      else if(target==b1){                                                        
         t1.setText(t1.getText()+((JButton)target).getText()); 
         t1.requestFocus();} 
      else if(target==b2){                                                        
         t1.setText(t1.getText()+((JButton)target).getText()); 
         t1.requestFocus();}         
      else if(target==b3){                                                        
         t1.setText(t1.getText()+((JButton)target).getText()); 
         t1.requestFocus();}                     
      else if(target==b4){                                                        
         t1.setText(t1.getText()+((JButton)target).getText()); 
         t1.requestFocus();}    
      else if(target==b5) {                                                        
         t1.setText(t1.getText()+((JButton)target).getText()); 
         t1.requestFocus();}     
      else if(target==b6){                                                        
         t1.setText(t1.getText()+((JButton)target).getText()); 
         t1.requestFocus(); }        
      else if(target==b7)  {                                                        
         t1.setText(t1.getText()+((JButton)target).getText()); 
         t1.requestFocus();  }         
      else if(target==b8) {                                                        
         t1.setText(t1.getText()+((JButton)target).getText()); 
         t1.requestFocus(); }       
      else if(target==b9)  {                                                        
         t1.setText(t1.getText()+((JButton)target).getText()); 
         t1.requestFocus();  }                     
      else if(target==bplus)  { 
    	  try{
            buf=Double.parseDouble(t1.getText());    
            temp='+';
            t1.setText("");                                       
            t1.requestFocus();}
         catch(NumberFormatException eplus) {System.out.println(eplus); }                                   }       
      else if(target==bmin)                                   
      {  try{
            buf=Double.parseDouble(t1.getText());   
            temp= '-' ;
            t1.setText("");                                       
            t1.requestFocus();     }   
        catch(NumberFormatException emin){ System.out.println(emin); }}            
      else if(target==bdiv)                                   
      {  try {
            buf=Double.parseDouble(t1.getText());   
            temp= '/' ;
            t1.setText("");                                       
            t1.requestFocus();}                                                   
        catch(NumberFormatException ediv) {System.out.println(ediv); }}          
      else if(target==bmul)                                   
      { try{
            buf=Double.parseDouble(t1.getText());   
            temp= '*' ;
            t1.setText("");                                       
            t1.requestFocus();  }
        catch(NumberFormatException emul){
            System.out.println(emul);}}     
      else if(target==bmul)                                   
      { try{
            buf=Double.parseDouble(t1.getText());   
            temp= '*' ;
            t1.setText("");                                       
            t1.requestFocus(); }
        catch(NumberFormatException emul){ System.out.println(emul);} }   
      else if(target==bdot){ 
            try{   
            String tempo;
            tempo = t1.getText();
            if(!tempo.isEmpty())
            {
                if(tempo.indexOf('.') == -1)
                {
                tempo += '.';
                t1.setText(tempo);
                System.out.println(tempo);                                      
                t1.requestFocus();    }}}
        catch(NumberFormatException emul)
        {
            System.out.println(emul);
        }
      }                     
      else if(target==bper)                                   
      { try
        {
            buf=Double.parseDouble(t1.getText()); 
            if(buf < 0)
         {
            buf = 0;
         }
         else
         {
            buf=Double.parseDouble(t1.getText());   
            temp= '%' ;
            t1.setText("");                                       
            t1.requestFocus(); 
         }
        }
        catch(NumberFormatException eper)
        {
            System.out.println(eper);   
        }                                   
      }                     
      else if(target == brow || target == t1)                        
      {   
        try
        {  
         x=Double.parseDouble(t1.getText());  
         if(temp == '+')
         {
            x = buf + x;
         }
         else if(temp == '-')
         {
             x = buf - x;
         }
         else if(temp == '/')
         {
             try 
             {
                 x = buf / x;
             }
             catch (ArithmeticException w)
             {
                 t1.setText("");
                 t1.requestFocus();  
             }
         }
         else if(temp == '*')
         {
             x = buf * x;
         }  
         else if(temp == '%')
         {
             x = (buf * x) / 100;
         }
         temp = ' ' ;
         t1.setText(Double.toString(x));                       
         t1.requestFocus();  
        }
        catch(NumberFormatException erow)
        {
            System.out.println(erow);
        }
      
      }                                                        
    PrintWriter plik; 
    try 
    {
        plik = new PrintWriter(new BufferedWriter(new FileWriter("dzialania.txt",true)));
        plik.println(buf);
        plik.println(temp);
        plik.close();
    } 
    catch (IOException ex) 
    {
        Logger.getLogger(kalkulator.class.getName()).log(Level.SEVERE, null, ex);
    }
         
   }
   
   void init()                                                                   
   {                                                                                                                            
      JFrame f=new JFrame();     
      Container c=f.getContentPane();                                           
 
      GridBagLayout gbl=new GridBagLayout();                                    
      GridBagConstraints gbc=new GridBagConstraints();                          
      gbc.fill=GridBagConstraints.HORIZONTAL;                                   
      c.setLayout(gbl);   
      f.setSize(1000, 180);
      t1=new JTextField(25); 
      t1.setEditable(false);
      t1.addActionListener(this);                                                            
      gbc.gridx=0;                                                              
      gbc.gridy=0;                                                              
      gbc.gridwidth=5;                                                                                                                        
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(t1,gbc);                                               
      c.add(t1);
      
      clean=new JButton("c");                                                    
      clean.addActionListener(this);                                             
      clean.setFocusable(false);                                                 
      clean.setToolTipText("Wyczyść");                                 
      gbc.gridx=3;                                                              
      gbc.gridy=3;                                                              
      gbc.gridwidth=1; 
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(clean,gbc);                                             
      c.add(clean);  
 
 
      b0=new JButton("0");                                                      
      b0.addActionListener(this);                                               
      b0.setFocusable(false);                                                   
      gbc.gridx=3;                                                              
      gbc.gridy=2;                                                              
      gbc.gridwidth=1;                                                                                                                        
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(b0,gbc);                                               
      c.add(b0);        
      
      b1=new JButton("1");                                                      
      b1.addActionListener(this);                                               
      b1.setFocusable(false);                                                   
      gbc.gridx=0;                                                              
      gbc.gridy=1;                                                              
      gbc.gridwidth=1;                                                                                                                        
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(b1,gbc);                                               
      c.add(b1);        
     
      b2=new JButton("2");                                                      
      b2.addActionListener(this);                                               
      b2.setFocusable(false);                                                   
      gbc.gridx=1;                                                            
      gbc.gridy=1;                                                             
      gbc.gridwidth=1;                                                                                                                        
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(b2,gbc);                                             
      c.add(b2);    
    
      b3=new JButton("3");                                                      
      b3.addActionListener(this);                                               
      b3.setFocusable(false);                                                   
      gbc.gridx=2;                                                             
      gbc.gridy=1;                                                              
      gbc.gridwidth=1;                                                                                                                       
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(b3,gbc);                                               
      c.add(b3);       
      
      b4=new JButton("4");                                                      
      b4.addActionListener(this);                                               
      b4.setFocusable(false);                                                   
      gbc.gridx=0;                                                              
      gbc.gridy=2;                                                              
      gbc.gridwidth=1;                                                                                                                       
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(b4,gbc);                                               
      c.add(b4);    
     
      b5=new JButton("5");                                                      
      b5.addActionListener(this);                                               
      b5.setFocusable(false);                                                   
      gbc.gridx=1;                                                      
      gbc.gridy=2;                                                       
      gbc.gridwidth=1;                                                                                                                        
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(b5,gbc);                                               
      c.add(b5);       
      
      b6=new JButton("6");                                                      
      b6.addActionListener(this);                                               
      b6.setFocusable(false);                                                   
      gbc.gridx=2;                                                  
      gbc.gridy=2;                                                  
      gbc.gridwidth=1;                                                                                                                      
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(b6,gbc);                                               
      c.add(b6);    
      
      b7=new JButton("7");                                                      
      b7.addActionListener(this);                                               
      b7.setFocusable(false);                                                   
      gbc.gridx=0;                                                   
      gbc.gridy=3;                                                   
      gbc.gridwidth=1;                                                                                                                       
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(b7,gbc);                                               
      c.add(b7);   
      
      b8=new JButton("8");                                                      
      b8.addActionListener(this);                                               
      b8.setFocusable(false);                                                   
      gbc.gridx=1;                                                              
      gbc.gridy=3;                                                              
      gbc.gridwidth=1;                                                                                                                        
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(b8,gbc);                                               
      c.add(b8);       
      
      b9=new JButton("9");                                                      
      b9.addActionListener(this);                                               
      b9.setFocusable(false);                                                   
      gbc.gridx=2;                                                              
      gbc.gridy=3;                                                              
      gbc.gridwidth=1;                                                                                                                       
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(b9,gbc);                                               
      c.add(b9);       
 
      bplus=new JButton("+");                                                   
      bplus.addActionListener(this);                                            
      bplus.setFocusable(false);                                                
      bplus.setToolTipText("Dodawanie");                                        
      gbc.gridx=3;                                                              
      gbc.gridy=1;                                                              
      gbc.gridwidth=1;                                                                
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(bplus,gbc); 
      c.add(bplus);                                                            
     
      bmin=new JButton("-");                                                    
      bmin.addActionListener(this);                                             
      bmin.setFocusable(false);                                                 
      bmin.setToolTipText("Odejmowanie");                                 
      gbc.gridx=2;                                                              
      gbc.gridy=4;                                                              
      gbc.gridwidth=1;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(bmin,gbc);                                             
      c.add(bmin);    
      
      bdiv=new JButton("/");                                                    
      bdiv.addActionListener(this);                                             
      bdiv.setFocusable(false);                                                 
      bdiv.setToolTipText("Dzielenie");                                 
      gbc.gridx=1;                                                              
      gbc.gridy=4;                                                              
      gbc.gridwidth=1;                                                            
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(bdiv,gbc);                                             
      c.add(bdiv);                  
      
      bmul=new JButton("*");                                                    
      bmul.addActionListener(this);                                             
      bmul.setFocusable(false);                                                 
      bmul.setToolTipText("Mnożenie");                                 
      gbc.gridx=0;                                                              
      gbc.gridy=4;                                                              
      gbc.gridwidth=1;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(bmul,gbc);  
      c.add(bmul);   
     
      bdot=new JButton(".");                                                    
      bdot.addActionListener(this);                                             
      bdot.setFocusable(false);                                                 
      bdot.setToolTipText("Kropka");                                 
      gbc.gridx=3;                                                              
      gbc.gridy=4;                                                              
      gbc.gridwidth=1;
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(bdot,gbc);                                             
      c.add(bdot);    
     
      brow=new JButton("=");                                                      
      brow.addActionListener(this);                                               
      brow.setFocusable(false);                                                   
      gbc.gridx=2;                                                              
      gbc.gridy=6;                                                              
      gbc.gridwidth=2;                                                                                                                                                                                     
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(brow,gbc);
      c.add(brow);    
     
     
      bper=new JButton("%");                                                    
      bper.addActionListener(this);                                             
      bper.setFocusable(false);                                                 
      bper.setToolTipText("Procent");                                 
      gbc.gridx=0;                                                              
      gbc.gridy=6;                                                              
      gbc.gridwidth=1; 
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(bper,gbc);                                             
      c.add(bper);    
      
      
      bsqrt=new JButton("√");                                                    
      bsqrt.addActionListener(this);                                             
      bsqrt.setFocusable(false);                                                 
      bsqrt.setToolTipText("Pierwiastek");                                 
      gbc.gridx=1;                                                              
      gbc.gridy=6;                                                              
      gbc.gridwidth=1; 
      gbc.insets=new Insets(5,5,5,5);                                           
      gbl.setConstraints(bsqrt,gbc);                                             
      c.add(bsqrt);    
      
        
      
      
      //f.pack();
      f.setSize(270,220);
      f.setBackground(Color.GRAY);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                         
      f.setTitle("Kalk");                                                       
      f.setVisible(true);
      c.setBackground(Color.GRAY);
   }                                                                            
                                                 
}