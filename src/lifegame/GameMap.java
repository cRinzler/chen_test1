package lifegame;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public  class GameMap extends JPanel{

private final int width=30;
private final int height=30;
public final int MAX_LINE=20;
public final int MAX_ROW=25;
private final int DELAY_TIME = 1050;  	//��ʱ
private Timer timer;  
int key=0;
private int tepmap[][]={       //�м�ת��
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		
};
private int map[][]={      //ϸ����ͼ
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		
};	
	JButton startButton=new JButton("���ҿ�ʼ");
	JLabel info=new JLabel("Tips.�����������ѡ����ϸ����Ȼ����ѡ��ʼ����Ϸ�����ڼ������ͣ�������ѡ���ϸ��"); 
	JLabel AliveNumTag=new JLabel("��ϸ������"); 
    int  AliveNum=0;
	int JudgeOnplay=0;  //���أ��ж��Ƿ��������л�����ͣ
	
 GameMap(){
	
	this.setLayout(null);
	this.add(info);
	this.add(AliveNumTag);
	this.add(startButton);
	startButton.setBounds(3, 750,610,40);
	info.setBounds(0,790,610,40);
	AliveNumTag.setBounds(0,820,610,40);
	startButton.addActionListener( new ButtonListener());
	MyMouseClickAction();
	
	
	
}
 public void MyMouseClickAction(){
	addMouseListener(new MouseAdapter(){
		 public void mouseClicked(MouseEvent e)
		          {
			      int row=0;
			      int line=0;
		          line=e.getX()/30;
		          row=e.getY()/30; 
		          map[row][line]=1;
		          repaint();
		           }
		
	});
	
 
 }

 
 //��ť�¼�����ʼϸ���仯
 public class ButtonListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(startButton))
		{
			//System.out.println("�����ť");
		 JudgeOnplay++;
		 if(JudgeOnplay%2==1)//���İ�ť״̬
			 startButton.setText("������ͣ");
		 else if(JudgeOnplay%2==0)
			 startButton.setText("���ҿ�ʼ");
			start();
			
		}
		
		
		
		
	}}
 
 //��ʼ
public void start(){
	
	for(int row=0;row<MAX_ROW;row++)
			tepmap[row]=map[row];

	timer = new Timer(DELAY_TIME, new ActionListener() {  
		  
     
        public void actionPerformed(ActionEvent e) {  
        	if(JudgeOnplay%2==1)
        	{
             changeCellStatus();  
             repaint(); 
            }
        	
        }  
    });  
    // ������ʱ�� 
	if(key==0){
    timer.start();  
    key=1;
	}
	

}

//ͳ���ھ���Ŀ
public int getAroundCellNum(int row,int line){
	int count=0;
	int r,l;
	for(r=row-1;r<=row+1;r++)
		for(l=line-1;l<=line+1;l++)
		{
			if(r<0||r>=MAX_ROW||l<0|l>=MAX_LINE)
               continue;
			if(map[r][l]==1)
				count++;
			
		}
	if(map[row][line]==1)
		count--;
	return count;
}

//�����ھӻ�ϸ����Ŀ���ı�ϸ����һ״̬
public void changeCellStatus(){
	for(int row=0;row<MAX_ROW;row++)
		for(int line=0;line<MAX_LINE;line++){
	int count=getAroundCellNum(row,line);
	if(count==3)
	{
		tepmap[row][line]=1;
		
	}
	else if(count==2)
	{
		tepmap[row][line]=map[row][line];
		
	}
	else
	{
		tepmap[row][line]=0;	
	}
		}
	
	
	//����
	for(int row=0;row<MAX_ROW;row++)
			map[row]=tepmap[row];
			
		

}

//������
public void paintComponent(Graphics g){
	super.paintComponent(g);
	int count=0;
	for(int i=0;i<MAX_ROW;i++)
		for(int j=0;j<MAX_LINE;j++){
			g.drawRect(j*width, i*height, width, height);
			if(map[i][j]==1)
			{
				g.fillRect(j*width, i*height, width, height);
				count++;
			}
			
		}
   
	AliveNum=count;
	AliveNumTag.setText("��ϸ����: "+AliveNum);
}	
	
public void setCellStatus(int row,int line,int status){
	if(status==1||status==0){
		map[row][line]=status;
			
	}
	
}
	
public void initalMap(){
	
	for(int row=0;row<MAX_ROW;row++)
		for(int line=0;line<MAX_LINE;line++)
			map[row][line]=0;
	
	
}
public int getCellStatus(int row,int line)
{
	
return map[row][line];

}

public int[][] getCellMap()
{
	
return map;
}

}
