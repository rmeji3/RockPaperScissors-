// ****************************************************************
//   Program Name:  RPSGUI.java
//   Programmer:	Rafael Mejia
//   Date:			4/18/22
//
//	This is the GUI for the rock paper scissor game
// ****************************************************************

//import statements
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RPSGUI{
    public static void main(String args[]){
		RPSGUI game = new RPSGUI();
		game.display();



		}

		// instance data
		private JFrame rpsFrame;
		private JPanel buttonsPanel;
		private JPanel scoreBoardPanel;
		private JPanel gamePlayPanel;
		private JPanel gamePanel;
		// labels
		private JLabel[] resultsLabels;
		private JLabel playerLabel = new JLabel("Player Wins:", SwingConstants.CENTER);
		private JLabel computerLabel = new JLabel("Computer Wins:", SwingConstants.CENTER);
		private JLabel tiesLabel = new JLabel("Ties:", SwingConstants.CENTER);
		private JLabel gamePlayLabel = new JLabel("Choose Rock, Paper, or Scissors!!", SwingConstants.CENTER);
		// buttons
		private JButton[] rpsButtons;
		// images for the buttons
		private ImageIcon[] icons = new ImageIcon[3];
		// String game play return
		private String resultsString;
		// counting variables
		private int userWins = 0, computerWins = 0, ties = 0;

		// constructor for the GUI
		public RPSGUI(){
			// create the images for the buttons
			icons[0] = new ImageIcon("mastu.JPG");
			icons[1] = new ImageIcon("paper.PNG");
			icons[2] = new ImageIcon("scissors.PNG");
			// create the buttons
			rpsButtons = new JButton[3];
			// put images on the buttons
			for(int i = 0; i < rpsButtons.length; i++){
				// create the button
				rpsButtons[i] = new JButton("");
				rpsButtons[i].setIcon(reSizeIcon(icons[i], 167, 167));
				rpsButtons[i].setBackground(Color.black);
				rpsButtons[i].addActionListener(new ButtonListener());
			}

			// build our panels
			// scoreboard panel
			resultsLabels = new JLabel[3];
			scoreBoardPanel = new JPanel();
			scoreBoardPanel.setLayout(new GridLayout(2, 3));
			scoreBoardPanel.setBackground(Color.red);
			// results labels
			for(int i = 0; i < resultsLabels.length; i++){
				resultsLabels[i] = new JLabel("0", SwingConstants.CENTER);
			}
			// add everything to the scoreboard panel
			scoreBoardPanel.add(playerLabel);
			scoreBoardPanel.add(computerLabel);
			scoreBoardPanel.add(tiesLabel);
			scoreBoardPanel.add(resultsLabels[0]);
			scoreBoardPanel.add(resultsLabels[1]);
			scoreBoardPanel.add(resultsLabels[2]);

			// buttons panel
			buttonsPanel = new JPanel();
			buttonsPanel.setLayout(new GridLayout(1, 3));
			// add allthe buttons to the buttons panel
			for(int i = 0; i < rpsButtons.length; i++){
				buttonsPanel.add(rpsButtons[i]);
			}

			// gameplay panel (bottom)
			gamePlayPanel = new JPanel();
			gamePlayPanel.setBackground(Color.blue);
			gamePlayLabel.setForeground(Color.white);
			gamePlayPanel.add(gamePlayLabel);

			// game panel
			gamePanel = new JPanel();
			gamePanel.setLayout(new BorderLayout());
			gamePanel.add(scoreBoardPanel, BorderLayout.NORTH);
			gamePanel.add(buttonsPanel, BorderLayout.CENTER);
			gamePanel.add(gamePlayPanel, BorderLayout.SOUTH);

			// set up the frame
			rpsFrame = new JFrame("Rock, Paper, Scissors - Kevin Walsh");
			rpsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			rpsFrame.setPreferredSize(new Dimension(500, 300));

			// add the panel to the frame
			rpsFrame.add(gamePanel);
		}

		// display method
		public void display(){
			rpsFrame.pack();
			rpsFrame.show();
		}

		// resize the button images
		private static Icon reSizeIcon(ImageIcon icon, int newWidth, int newHeight){
			Image img = icon.getImage();
			Image resizedImage = img.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH);

			return new ImageIcon(resizedImage);
		}

		// button listener
		private class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				// figure out which button has been pressed
				Object source = e.getSource();

				// testing
				//System.out.println(source);
				if(source.equals(rpsButtons[0])){
					resultsString = Rock.playGame("r");
				}else if(source.equals(rpsButtons[1])){
					resultsString = Rock.playGame("p");
				}else{
					resultsString = Rock.playGame("s");
				}

				// update the display
				gamePlayLabel.setText(resultsString);

				// count wins, losses, and ties
				if(resultsString.contains("WIN")){
					userWins++;
					resultsLabels[0].setText("" + userWins);
				}else if(resultsString.contains("LOSE")){
					computerWins++;
					resultsLabels[1].setText("" + computerWins);
				}else{
					ties++;
					resultsLabels[2].setText("" + ties);
				}
			}
		}
	}

