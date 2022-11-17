package primes;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintStream;

public class Frame extends JFrame implements ActionListener {

	JButton startBtn;
	JLabel nLabel;
	JLabel lBuffer;
	JLabel lOutput;
	JLabel lMaxPrime;
	JLabel lNumOfPrimes;
	JLabel lTime;
	JLabel lMaxPrimeValue;
	JLabel lNumOfPrimesValue;
	JLabel lTimeValue;
	JTextField tfN;
	JTextField tfBuffer;
	JTextField tfOutput;
	
	public Frame(){
		
		
		startBtn = new JButton("Start Producer");
		startBtn.setFont(new Font("Verdana", Font.PLAIN, 15));
		startBtn.addActionListener(this);
		nLabel = new JLabel("N");
		nLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lBuffer = new JLabel("Buffer Size");
		lBuffer.setFont(new Font("Verdana", Font.PLAIN, 20));
		lOutput = new JLabel("Output File");
		lOutput.setFont(new Font("Verdana", Font.PLAIN, 20));
		lMaxPrime = new JLabel("The Largest Prime Number");
		lMaxPrime.setFont(new Font("Verdana", Font.PLAIN, 15));
		lNumOfPrimes = new JLabel("# of elements (Prime numbers) generated");
		lNumOfPrimes.setFont(new Font("Verdana", Font.PLAIN, 15));
		lTime = new JLabel("Time elapsed since the start of proccessing");
		lTime.setFont(new Font("Verdana", Font.PLAIN, 15));
		lMaxPrimeValue = new JLabel("");
		lMaxPrimeValue.setFont(new Font("Verdana", Font.PLAIN, 15));
		lNumOfPrimesValue = new JLabel("");
		lNumOfPrimesValue.setFont(new Font("Verdana", Font.PLAIN, 15));
		lTimeValue = new JLabel("");
		lTimeValue.setFont(new Font("Verdana", Font.PLAIN, 15));
		tfBuffer = new JTextField();
		tfBuffer.setFont(new Font("Verdana", Font.PLAIN, 20));
		tfN = new JTextField();
		tfN.setFont(new Font("Verdana", Font.PLAIN, 20));
		tfOutput = new JTextField();
		tfOutput.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		
		tfN.setBounds(20, 20, 400, 40);
		nLabel.setBounds(440, 20, 400, 40);
		tfBuffer.setBounds(20, 90, 400, 40);
		lBuffer.setBounds(440, 90, 400, 40);
		tfOutput.setBounds(20, 160, 400, 40);
		lOutput.setBounds(440, 160, 400, 40);
		startBtn.setBounds(20, 230, 150, 40);
		lMaxPrime.setBounds(20, 330, 400, 40);
		lMaxPrimeValue.setBounds(440, 330, 400, 40);
		lNumOfPrimes.setBounds(20, 400, 400, 40);
		lNumOfPrimesValue.setBounds(440, 400, 400, 40);
		lTime.setBounds(20, 470, 400, 40);
		lTimeValue.setBounds(440, 470, 400, 40);
		
		this.add(startBtn);
		this.add(nLabel);
		this.add(lBuffer);
		this.add(lOutput);
		this.add(lMaxPrime);
		this.add(lNumOfPrimes);
		this.add(lTime);
		this.add(lMaxPrimeValue);
		this.add(lNumOfPrimesValue);
		this.add(lTimeValue);
		this.add(tfBuffer);
		this.add(tfN);
		this.add(tfOutput);
		
		this.setTitle("Prime Numbers");
		this.setSize(700, 600);
		setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		try{  
			String location = "D:\\Os\\" + tfOutput.getText();
	        File file = new File(location);
	        PrintStream stream = new PrintStream(file);
	        System.setOut(stream);
	        buffer buf = new buffer(Integer.valueOf(tfN.getText()), Integer.valueOf(tfBuffer.getText()));
	        long start1 = System.currentTimeMillis();
	        Producer P = new Producer(buf);
	        Consumer c = new Consumer(buf, lTimeValue, start1);
	        P.start();
	        c.start();
	        
	        P.join();
	        c.join();
	        
	        lMaxPrimeValue.setText(String.valueOf(buf.Max_prime));
	        lNumOfPrimesValue.setText(String.valueOf(buf.N));

	        
		}catch(Exception ex){System.out.println(ex);}  
		
	}

}
