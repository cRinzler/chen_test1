package lifegame;

import javax.swing.*;


public class lifegame extends JFrame{
	
	lifegame(){
		this.setSize(610,900);
		this.setTitle("Chen's lifegame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		this.setResizable(false);  
		this.setLocationRelativeTo(null);
        this.add(new GameMap());
	}
	
public static void main(String args[]){
	
	lifegame game=new lifegame();
	game.setVisible(true);

	
}
}
