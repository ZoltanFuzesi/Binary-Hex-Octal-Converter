package BinaryCalc;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BinaryCalculator extends JFrame{

		private  JFormattedTextField inputString;// use for input
		private  JFormattedTextField fromClipboard;// used for  --> copy to clipboard
		private  JFormattedTextField calculatedOutput;
		private  JFormattedTextField outputBinaryOfString2;
		private  JFormattedTextField outputBinaryOfString3;        
		
		private  JFormattedTextField outputStringOfBinary;
		private Action act;
		private static int stateControll = 0;
        
	    
    public static void main(String[] args) {
        
		
		BinaryCalculator bn = new BinaryCalculator();
    }
    
    public BinaryCalculator()
    {
    	
    	super("BinaryCalculator");//create main frame
    	buildFrame();
    	act = new Action();
    }
    public void buildFrame()
    {
	      	JMenuBar menubar = new JMenuBar();//menubar into frame on top
	      	JMenu mainHelp = new JMenu("Help");// menu into meubar
            JMenuItem menuItem = new JMenuItem("Show About");
            mainHelp.add(menuItem);
	      	add(menubar);// add menubar into frame
	      	menubar.add(mainHelp);//add menu into menubar
	      	setJMenuBar(menubar);
	 
	      	//mainPanel into frame
		    JPanel mainPanel = new JPanel(new GridLayout(1,2));//main panel in frame GridLayout(1,2) rigth anf left panel goes into it
	    	add(mainPanel);//add mainpanel into frame
	      	
	      	//inner rigth and left panels
	      	JPanel rigthPanel = new JPanel(new GridLayout(1 ,2));//rigth inner panel
	     	JPanel leftPanel = new JPanel(new GridLayout(1 ,2));//left inner panel
	      	mainPanel.add(rigthPanel);//add rigth panel into mainPanel
	      	mainPanel.add(leftPanel);//add left panel into mainPanel
	            	
	   
	   		//add panel into booth side
	   		JPanel innerRigth = new JPanel(new GridLayout(2, 1));
	   		JPanel innerLeft = new JPanel(new GridLayout(2, 1));
	   		rigthPanel.add(innerRigth);
	   		leftPanel.add(innerLeft);
	   		
	   		//add two panel into innerRigth
	   		JPanel topRigth = new JPanel(new BorderLayout());
	   		JPanel buttonRigth = new JPanel(new BorderLayout());
            JPanel buttonRightCenter = new JPanel(new GridLayout(3, 1));
            buttonRigth.add(buttonRightCenter, BorderLayout.CENTER);
	   		innerRigth.add(topRigth);
	   		innerRigth.add(buttonRigth);	   		
	   		JPanel topLeft = new JPanel(new BorderLayout());
	  		JPanel buttonLeft = new JPanel(new BorderLayout());
	  		innerLeft.add(topLeft);
	  		innerLeft.add(buttonLeft);

	      	
	      	//tolbars into rigth and left side
	      	JPanel rigthToolbar = new JPanel();//toolbar on top rigth
	    	JPanel leftToolbar = new JPanel();//toolbar on top left
	      	topRigth.add(rigthToolbar, BorderLayout.NORTH);//add toolbar on top rigth
	      	topLeft.add(leftToolbar, BorderLayout.NORTH);//add toolbar on top left
	      	
	      	//set up buttons
	      	 JButton rigthButtonCalculateHex = new JButton("Hexadecimal");//button
		       	rigthButtonCalculateHex.addActionListener(new ActionListener() 
				{
	   		        public void actionPerformed(ActionEvent e) 
					{
	   		        	stateControll = 1;
	   		        	act.outputClear();
						act.hexCalculate();
					}
				});
		     JButton rigthButtonCalculateDec = new JButton("Octal");//button
		     rigthButtonCalculateDec.addActionListener(new ActionListener() 
		     {
		    	 public void actionPerformed(ActionEvent e) 
		    	 {
		    		 stateControll = 2;
	   		        act.outputClear();
	   	            act.octalCalculate();
				}
			});
	        JButton rigthButtonCalculateBinary = new JButton("Binary");//button
	       	rigthButtonCalculateBinary.addActionListener(new ActionListener() 
			{
   		        public void actionPerformed(ActionEvent e) 
				{
   		        	stateControll = 3;
   		        	act.outputClear();
					act.stringCalculate();
				}
			});
	      	JButton	rigthButtonClear = new JButton("Clear");//button
	      	rigthButtonClear.addActionListener(new ActionListener() 
			{
   		        public void actionPerformed(ActionEvent e) 
				{
					act.stringClear();
				}
			});
            JButton copyToBinary = new JButton("Copy To >>>>");//button
	      	copyToBinary.addActionListener(new ActionListener() 
			{
   		        public void actionPerformed(ActionEvent e) 
				{
                                    act.binaryClear();
                                    act.copyToBinary();
				}
			});
	      	JButton leftButtonCalculateHex = new JButton("Of Hexadecimal");//button
	      	leftButtonCalculateHex.addActionListener(new ActionListener() 
			{
   		        public void actionPerformed(ActionEvent e) 
				{
   		        	if(stateControll == 1)
   		        	{
   		        		act.stringFromHex();
   		        	}
   		        	else
   		        	{
   						outputStringOfBinary.setText("The input is not Hexadecimal number");
   		        	}
					
				}
			});
	      	JButton leftButtonCalculateDec = new JButton("Of Octal");//button
	      	leftButtonCalculateDec.addActionListener(new ActionListener() 
			{
   		        public void actionPerformed(ActionEvent e) 
				{
   		        	if(stateControll == 2)
   		        	{
   		        		act.stringFromOctal();
   		        	}
   		        	else
   		        	{
   						outputStringOfBinary.setText("The input is not Octal number");
   		        	}
				}
			});
	      	JButton leftButtonCalculate = new JButton("Of Binary");//button
	      	leftButtonCalculate.addActionListener(new ActionListener() 
			{
   		        public void actionPerformed(ActionEvent e) 
				{
   		        	if(stateControll == 3)
   		        	{
   		        		act.calculateBinary();
   		        	}
   		        	else
   		        	{
   						outputStringOfBinary.setText("The input is not Binary number");
   		        	}
					
				}
			});
	      	JButton leftButtonClear = new JButton("Clear");//button
	      	leftButtonClear.addActionListener(new ActionListener() 
			{
   		        public void actionPerformed(ActionEvent e) 
				{
					act.binaryClear();
				}
			});
            JButton copyToString = new JButton("<<<< Copy to");//button
	      	copyToString.addActionListener(new ActionListener() 
			{
   		        public void actionPerformed(ActionEvent e) 
				{
                                    act.stringClear();
                                    act.copyToString();
                                        
				}
			});
            
	      	rigthToolbar.add(rigthButtonCalculateHex);
	      	rigthToolbar.add(rigthButtonCalculateDec);
	      	rigthToolbar.add(rigthButtonCalculateBinary);
	      	rigthToolbar.add(rigthButtonClear);
            rigthToolbar.add(copyToBinary);
            leftToolbar.add(copyToString);
            leftToolbar.add(leftButtonCalculateHex);
            leftToolbar.add(leftButtonCalculateDec);
	      	leftToolbar.add(leftButtonCalculate);
	      	leftToolbar.add(leftButtonClear);
                
      	
      		//set up text field to enter and retrieve information
                menuItem.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        showAbout();
                    }
                });
    		inputString = new JFormattedTextField();
    		
    		calculatedOutput = new JFormattedTextField();
            outputBinaryOfString2 = new JFormattedTextField();
            outputBinaryOfString3 = new JFormattedTextField();
    		calculatedOutput.setEditable(false);
            outputBinaryOfString2.setEditable(false);
            outputBinaryOfString3.setEditable(false);    
    		fromClipboard = new JFormattedTextField();
    		
    		outputStringOfBinary = new JFormattedTextField();
    		outputStringOfBinary.setEditable(false);
   		 	topRigth.add(inputString, BorderLayout.CENTER);
   		    buttonRightCenter.add(calculatedOutput);
            buttonRightCenter.add(outputBinaryOfString2);
            buttonRightCenter.add(outputBinaryOfString3);
   		    topLeft.add(fromClipboard, BorderLayout.CENTER);
   		    buttonLeft.add(outputStringOfBinary, BorderLayout.CENTER);
   
   			//JLabel infoemation of each input and output
   		
   			JLabel infoRightTop = new JLabel("INPUT  : Enter a String here");
   			infoRightTop.setBorder(new EmptyBorder(0,50,0,0));
   			JLabel infoRightButton	 = new JLabel("OUTPUT : Binary of String");
   			infoRightButton.setBorder(new EmptyBorder(0,50,0,0));
   			JLabel infoLeftTop = new JLabel("INPUT  : Enter Binary number here");
   			infoLeftTop.setBorder(new EmptyBorder(0,50,0,0));
   			JLabel infoLeftButton = new JLabel("OUTPUT : String of binary");
   			infoLeftButton.setBorder(new EmptyBorder(0,50,0,0));
   			
   			topRigth.add(infoRightTop, BorderLayout.SOUTH);
   			buttonRigth.add(infoRightButton, BorderLayout.SOUTH);
   			topLeft.add(infoLeftTop, BorderLayout.SOUTH);
   			buttonLeft.add(infoLeftButton, BorderLayout.SOUTH);
   
            setExtendedState(JFrame.MAXIMIZED_BOTH); 
      		setMinimumSize(new Dimension(700, 400));
      		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
      		setVisible(true);
    }
     private  void showAbout()
    {
        double VERSION = 3.0;
        String text = "BinaryCalculator by Zoltan Fuzesi\n"
                + "You Can convert from String to Binary\n"
                + "and from Binary to String\n"
                + "Version :" + VERSION;                             
           
      JOptionPane.showMessageDialog(null, text,
                            "About Database", 
                            JOptionPane.INFORMATION_MESSAGE);                                                                            
    }


     
     
     
class Action
{
    
        private  String newString = "";
        private  String output = "";
        private  String emptyString = "";
        private  int hexLength = 0;
        
        public Action()
        {
        	
        }
        
        public  void copyToBinary()
        {
            fromClipboard.setText(output);
        }
        
        public void copyToString()
        {
            inputString.setText(newString);
        }
        
        public void stringOutput(String word2)//passing binary value to output 3 lines 				OK
        {
               if(word2.length()<70)
              {
                  calculatedOutput.setText(word2);
              }
              else if(word2.length()<139)
              {
                String sub1 = word2.substring(0, 70);
                String sub2 = word2.substring(70);
                calculatedOutput.setText(sub1);
                outputBinaryOfString2.setText(sub2);

              }
              else if(output.length()<200)
              {
                  String sub1 = word2.substring(0, 70);
                  String sub2 = word2.substring(70,140);
                  String sub3 = word2.substring(140);
                  calculatedOutput.setText(sub1);
                  outputBinaryOfString2.setText(sub2);
                  outputBinaryOfString3.setText(sub3);
  ;
              }
              else if(output.length()>200)
              {
                  
                  String sub1 = word2.substring(0, 70);
                  String sub2 = word2.substring(70,140);
                  String sub3 = word2.substring(140);
                  calculatedOutput.setText(sub1);
                  outputBinaryOfString2.setText(sub2);
                  outputBinaryOfString3.setText(sub3);


              }
        }
        
	public void stringCalculate()// 	calculate binary from string						OK
	{

		
		
		String word = inputString.getText();
		
		char ch;
	      for(int j=0;j<word.length();j++)
	      {
		      ch = word.charAt(j);
		      int valueOfChar = (int)ch; 
		      int valueToPrint = valueOfChar;
		      
		      
		      //128 64 32 16 8 4 2 1
		      int[]numbers = new int[8];
		      
		      if(valueOfChar>=128)
		      {
		      	numbers[0] = 1;
		      	valueOfChar = valueOfChar - 128;
		      }
		      if(valueOfChar>=64)
		      {
		      	numbers[1] = 1;
		      	valueOfChar = valueOfChar - 64;
		      }
		      if(valueOfChar>=32)
		      {
		      	numbers[2] = 1;
		      	valueOfChar = valueOfChar - 32;
		      }
		      if(valueOfChar>=16)
		      {
		      	numbers[3] = 1;
		      	valueOfChar = valueOfChar - 16;
		      }
		      if(valueOfChar>=8)
		      {
		      	numbers[4] = 1;
		      	valueOfChar = valueOfChar - 8;
		      }
		      if(valueOfChar>=4)
		      {
		      	numbers[5] = 1;
		      	valueOfChar = valueOfChar - 4;
		      }
		      if(valueOfChar>=2)
		      {
		      	numbers[6] = 1;
		      	valueOfChar = valueOfChar - 2;
		      }
		      if(valueOfChar>=1)
		      {
		      	numbers[7] = 1;
		      	valueOfChar = valueOfChar - 1;
	      }
	      

		      for(int i=0;i<8;i++)
		      {
		      	output = output + numbers[i];
		      }
              output = output + "  ";
		}
	      
	      stringOutput(output);
		
              
       
	}
	
	public void stringClear()
	{
                output = emptyString;
                inputString.setText("");
                calculatedOutput.setText("");
                outputBinaryOfString2.setText("");
                outputBinaryOfString3.setText("");
                
	}
	
	public void outputClear()
	{
                output = emptyString;
                calculatedOutput.setText("");
                outputBinaryOfString2.setText("");
                outputBinaryOfString3.setText("");
                
	}
	
	
	public void hexCalculate()//calculate hexadecimal value					OK
	{
                    
            String string = inputString.getText();
            String newString = "";
            String hex = "";
            for(int i=0;i<string.length();i++)
            {
                char ch = string.charAt(i);
                int value = (int)ch;
                hex = Integer.toHexString(value);
                newString = newString + hex;
                
            }
                    output = newString;
                    calculatedOutput.setText(output);    
	}

	
	public void octalCalculate()  // calculate OCTAl values   			OK
	{
		String string = inputString.getText();
            String newString = "";
            String hex = "";
            String zer = "0" ;
            for(int i=0;i<string.length();i++)
            {
                char ch = string.charAt(i);
                int value = (int)ch;
                hex = Integer.toOctalString(value);
                if(hex.length()==2)
                {
                	zer = zer + hex;
                	hex = zer;
                }
                zer = "0";	
                newString = newString + hex;              
            }
                    output = newString;
                    calculatedOutput.setText(output);
		
                   
		
			
	}
	
	public void stringFromHex()//string from hexadecimal 			OK  Check from octal not working**************************************************
	{
			String hex = fromClipboard.getText();
            StringBuilder outputBuilder = new StringBuilder();
            int check = 0;
            if(hex.length()%2==0)
            {
                for (int i = 0; i < hex.length(); i+=2) {
                    try
                    {
                        String str = hex.substring(i, i+2);//get to value of hex number one time
                        outputBuilder.append((char)Integer.parseInt(str, 16)); 
                    }catch(NullPointerException e){
                    	
                    }
                    
                }
            }
            else
            {
            	output = "Your change is wrong Please use Hexadecimal number";
            	check++;
            }
                if(check==0)
                {
                	output = outputBuilder.toString();	    
                }
               
                outputStringOfBinary.setText(output);
	}
	public void stringFromOctal()//string from octal 				OK   ********check from hex not working  533
	{
					String word = fromClipboard.getText().toLowerCase();
					int divide = word.length()/3;
					int outputDecimal = 0;
					String finalStr ="";
					int s = 0;
					int s2 = 3;
			
					if(word.length()%3==0)
					{
						for(int i=0;i<divide;i++)
						{		
								String sub = word.substring(s, s2);
							try{
								// actual conversion of octal to decimal
								outputDecimal = Integer.parseInt(sub, 8);
							}
							catch(NumberFormatException ne){
								// Printing a warning message if the input is not a valid octal number
							}
			
							
							char ch = (char)outputDecimal;
		
							finalStr = finalStr + ch;
							s = s + 3;
							s2 = s2 + 3;
						}
						
	
						outputStringOfBinary.setText(finalStr);
					}
					else
					{
						outputStringOfBinary.setText("Not an octal number");
					}
	
	}
	
	
	
	public void binaryClear()
	{
		newString = emptyString;
        fromClipboard.setText("");
		outputStringOfBinary.setText("");
	}
        
        
        
        
	public void calculateBinary()  //from binary to string 			OK        	******************finish***********
	{
		  newString = emptyString;
          char ch = ' ';
          boolean trough = true;
          int numberOfBinary = 0;
          int increase = 0;
          String tempString = "";
          int sum = 0;
          int binaryValue = 128;
          String binaryWord = fromClipboard.getText(); 
          String replacedBinaryWord = binaryWord.replace(" ","");
          int loop = replacedBinaryWord.length()/8;
          //128 64 32 16 8 4 2 1
          int[]numbers = new int[replacedBinaryWord.length()];
          if(replacedBinaryWord.length()%8==0)
          {
        	  for(int l=0;l<loop;l++)
        	  {
                  while(trough)
                  {
                	  ch = replacedBinaryWord.charAt(increase);
                	  tempString = tempString + ch;
                	  numberOfBinary = Integer.parseInt(tempString);
                	  numbers[increase] = numberOfBinary;
                 
                      if(numbers[increase]==1)
                      {           
                         sum = sum + binaryValue;
                      }
                      else if(numbers[increase]==0)
                      {
           
                      }
                          binaryValue = binaryValue / 2;
                          tempString = "";
                          increase++;
                          if(increase%8==0)
                          {
                              trough=false;
                              char newCh = (char)sum;
                              newString = newString + newCh;
                              outputStringOfBinary.setText(newString);
                              binaryValue = 128;
                              trough = true;
                              if(increase==replacedBinaryWord.length())
                              {
                            	  trough = false;
                              }
                              sum = 0;  
                              
                          }
 
                  }

          
          
				}
        	  
          }
          else
          {
        	  newString = "Not a binary number";
          }
          
          outputStringOfBinary.setText(newString);
          
                 
	}
}
	

}
