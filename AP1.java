/*Java Program of Calculator using Applet*/
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;
public class AP1 extends Applet implements ActionListener
{
    TextField inp;
    //Function to add features to the frame
    public void init()
    {
	setBackground(Color.white);
	setLayout(null);
	int i;
	inp = new TextField();
	inp.setBounds(150,100,200,50);
	this.add(inp);
	Button button[] = new Button[10];
	for(i=0;i<10;i++)
	{
	    button[i] = new Button(String.valueOf(9-i));
        button[i].setBounds(150+((i%3)*50),150+((i/3)*50),50,50);
	    this.add(button[i]);
	    button[i].addActionListener(this);
	}
	Button dec=new Button(".");
	dec.setBounds(200,300,50,50);
	this.add(dec);
	dec.addActionListener(this);

    Button dzr=new Button("00");
	dzr.setBounds(250,300,50,50);
	this.add(dzr);
	dzr.addActionListener(this);
 
	Button clr=new Button("C");
	clr.setBounds(225,400,50,50);
	this.add(clr);
	clr.addActionListener(this);
 
	Button operator[] = new Button[8];
	operator[0]=new Button("/");
	operator[1]=new Button("*");
	operator[2]=new Button("-");
	operator[3]=new Button("+");
	operator[4]=new Button("=");
    operator[5]=new Button("%");
    operator[6]=new Button("^");
    operator[7]=new Button("ROOT");
	for(i=0;i<5;i++)
	{
	    operator[i].setBounds(300,150+(i*50),50,50);
	    this.add(operator[i]);
	    operator[i].addActionListener(this);
    }
	operator[5].setBounds(200,350,50,50);
	this.add(operator[5]);
	operator[5].addActionListener(this);

    operator[6].setBounds(150,350,50,50);
	this.add(operator[6]);
	operator[6].addActionListener(this);

    operator[7].setBounds(250,350,50,50);
	this.add(operator[7]);
	operator[7].addActionListener(this);
    }
    String num1="";
    String op="";
    String num2="";
    //Function to calculate the expression
    public void actionPerformed(ActionEvent e)
    {
	String button = e.getActionCommand();
        char ch = button.charAt(0);
	if(ch>='0' && ch<='9'|| ch=='.') 
	{ 
	    if (!op.equals("")) 
		num2 = num2 + button; 
	    else
		num1 = num1 + button; 
        String a=num1+op+num2;  
	    inp.setText(a); 
	} 
	else if(ch=='C') 
	{ 
	    num1 = op = num2 = ""; 
	    inp.setText(""); 
    }
	else if (ch =='=') 
	{ 
	    if(!num1.equals("") && !num2.equals(""))
	    {
		double temp=0.0;
		double n1=Double.parseDouble(num1);
		double n2=Double.parseDouble(num2);
		if(n2==0 && op.equals("/"))
		{
		    inp.setText(num1+op+num2+" = Zero Division Error");
		    num1 = op = num2 = "";
		}
		else
		    {
		    if (op.equals("+")) 
		        temp = n1 + n2; 
		    else if (op.equals("-")) 
		        temp = n1 - n2; 
		    else if (op.equals("/")) 
	  	        temp = n1/n2;
            else if(op.equals("%"))
			{
				temp=(n1*n2)/100;
			} 
		    else if(op.equals("*"))
		        temp = n1*n2;
            else if(op.equals("^"))
                temp=Math.pow(n1,n2);
            else
            {   
                if((n2==2))
                temp=Math.sqrt(n1);
                else if(n2==3)
                temp=Math.cbrt(n1);
            }
            String x=Double.toString(temp);     
		    inp.setText(x); 
		    num1 = Double.toString(temp);
		    op = num2 = ""; 
            }
        }
	    else
	    {
		num1 = op = num2 = ""; 
		inp.setText("");
	    }
    } 
	else 
	{ 
	    if (op.equals("") || num2.equals("")) 
		op = button; 
	    else 
	    { 
		double temp;
		double n1=Double.parseDouble(num1);
		double n2=Double.parseDouble(num2);
		if(n2==0 && op.equals("/"))
		{
		    inp.setText(num1+op+num2+" = Zero Division Error");
		    num1 = op = num2 = "";
		}
		else
		    {
		    if (op.equals("+")) 
		        temp = n1 + n2; 
		    else if (op.equals("-")) 
		        temp = n1 - n2; 
		    else if (op.equals("/")) 
	  	        temp = n1/n2;
            else if(op.equals("%"))
                temp = (n1*n2)/100;       
		    else if(op.equals("*"))
		        temp = n1*n2;
            else if(op.equals("^"))
                temp=Math.pow(n1,n2);
            else
                temp=Math.sqrt(n1); 
            String y=Double.toString(temp);
            inp.setText(y);   
		    num1 = Double.toString(temp); 
		    op = button; 
		    num2 = ""; 
	        }
        }
	    inp.setText(num1+op+num2);
    }
}
}