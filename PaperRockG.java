
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.*;

public class PaperRockG {
	
	public static Font font= new Font("Arial",Font.PLAIN,25);
	
	public static String[] optionList={"PAPER","ROCK","SCISSORS"};
	public static int listSize=optionList.length;
	
	public static JLabel playerLabel= new JLabel("PLAYER: ");
	
	public static JLabel computerLabel= new JLabel("COMPUTER: ");
	
	public static JLabel winnerLabel=new JLabel("GAME STARTS");
	
	//Pictures and Picture Labels
	
	//playerImageLabel.setBounds(20,200,260,235);
	public static ImageIcon rockImage= new ImageIcon("rock.png");
	public static ImageIcon paperImage= new ImageIcon("paper.png");
	public static ImageIcon scissorsImage= new ImageIcon("scissors.png");
	
	public static JLabel playerImageLabel=new JLabel(rockImage);
	
	//computer pictures
	public static JLabel computerImageLabel= new JLabel(rockImage);
	
	//score labels 
	public static JLabel playerScoreLabel= new JLabel("Player Score:   ");
	public static JLabel computerScoreLabel= new JLabel("Computer Score:   ");
	
	
	
	public static int playerScore=0;
	public static int computerScore=0;
	
	//reset score button
	
	public static JButton resetButton= new JButton("RESET SCORE");
	
	
	//method to handle button clicks
	public static void handleClick(String option) {
		String player=option;
		
		String computer=optionList[(int) (Math.random()*listSize)];
		System.out.println(option);
		playerLabel.setText("PLAYER: "+player);
		computerLabel.setText("COMPUTER: "+computer);
		if (player.equals("ROCK")) {
			playerImageLabel.setIcon(rockImage);
		}
		
		else if (player.equals("PAPER")) {
			playerImageLabel.setIcon(paperImage);
		}
		
		else if (player.equals("SCISSORS")) {
			playerImageLabel.setIcon(scissorsImage);
		}
		
		if (computer.equals("ROCK")) {
			computerImageLabel.setIcon(rockImage);
		}
		
		else if (computer.equals("PAPER")) {
			computerImageLabel.setIcon(paperImage);
		}
		
		else if (computer.equals("SCISSORS")) {
			computerImageLabel.setIcon(scissorsImage);
		}
		
		if ((player.equals("ROCK") && computer.equals("SCISSORS")) || ( player.equals("SCISSORS") && computer.equals("PAPER")) || 
		(player.equals("PAPER") && computer.equals("ROCK"))) {
			System.out.println("Player won");
			winnerLabel.setText("PLAYER WON");
			
			playerScore++;
			playerScoreLabel.setText("Player Score   :"+playerScore);
		}
		if ((computer.equals("ROCK") && player.equals("SCISSORS")) || (computer.equals("SCISSORS") && player.equals("PAPER")) ||
		(computer.equals("PAPER") && player.equals("ROCK"))) {
			System.out.println("Computer won");
			winnerLabel.setText("COMPUTER WON");
			computerScore++;
			computerScoreLabel.setText("Computer Score:   "+computerScore);
		}
		
		if (player.equals(computer)) {
			System.out.println("Even");
			winnerLabel.setText("EVEN");
		}
		System.out.println(playerScore+"  "+computerScore);
	}
	
		
	
	//main 
	
	public static void main(String[] args) {
		
		JFrame gameFrame= new JFrame("Paper,Scissors, Rock");
		
		//Game Buttons 
		JButton paperButton=new JButton("PAPER");
		paperButton.setBounds(10,10,250,40);
		paperButton.setFont(font);
		
		JButton rockButton=new JButton("ROCK");
		rockButton.setBounds(10,60,250,40);
		rockButton.setFont(font);
		
		JButton scissorsButton= new JButton("SCISSORS");
		scissorsButton.setBounds(10,110,250,40);
		scissorsButton.setFont(font);
		
		//Quit Button 
		JButton exitButton=new JButton("Exit");
		exitButton.setBounds(710,610,90,25);
		exitButton.setFont(font);
		//Quit method 
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameFrame.dispose(); //terminate jFrame
				System.exit(0); // terminate program
			}
		});
		
		//reset game method
		resetButton.setFont(font);
		resetButton.setBounds(440,610,220,25);
		
		resetButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerScore=0;
				computerScore=0;
				playerScoreLabel.setText("Player Score:  "+playerScore);
				computerScoreLabel.setText("Computer Score:  "+computerScore);
				
			}
		});
		
				
		
		
		
		
		//game option methods 
		
		//paper method 
		
		paperButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleClick("PAPER");
			}
		});
		
		rockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleClick("ROCK");
			}
		});
		
		scissorsButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleClick("SCISSORS");
			}
		});
		
		//labels and set fonts positions 
		
		//JLabel playerLabel= new JLabel("Player :");
		playerLabel.setBounds(20,170,270,30);
		computerLabel.setBounds(450,170,290,30);
		playerLabel.setFont(font);
		computerLabel.setFont(font);
		
		//picture images
		
		playerImageLabel.setBounds(20,220,260,235);
		computerImageLabel.setBounds(450,220,260,235);
		
		//score labels 
		playerScoreLabel.setBounds(20,470,260,30);
		computerScoreLabel.setBounds(450,470,260,30);
		playerScoreLabel.setFont(font);
		computerScoreLabel.setFont(font);
		
		//winner label 
		
		winnerLabel.setBounds(230,550,260,30);
		winnerLabel.setFont(font);
		winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		//add elements to Frame 
		gameFrame.add(paperButton);
		gameFrame.add(rockButton);
		gameFrame.add(scissorsButton);
		gameFrame.add(exitButton);
		gameFrame.add(playerLabel);
		gameFrame.add(computerLabel);
		gameFrame.add(winnerLabel);
		gameFrame.add(playerImageLabel);
		gameFrame.add(computerImageLabel);
		gameFrame.add(playerScoreLabel);
		gameFrame.add(computerScoreLabel);
		gameFrame.add(resetButton);
		
		//frame size and close 
		
		gameFrame.setSize(830,700);
		
		//BG color 
		gameFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
		gameFrame.setLayout(null);
		
		gameFrame.setVisible(true);
		
		
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
