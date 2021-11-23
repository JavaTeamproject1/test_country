import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


class MainGraph_Polygonal extends JPanel {
   
   //초기 샘플 데이터
   private int[] NO2;
   private int[] OZ;
   private int[] CO2;
   private int[] SO2;
   private int[] Fd;
   private int[] Ud;

   public MainGraph_Polygonal() {
      super();
      NO2 = new int[7];
      OZ = new int[7];
      CO2 = new int[7];
      SO2 = new int[7];
      Fd = new int[7];
      Ud = new int[7];
   }
   
   public void setNO2(String a) {
      String[] temp=a.split(",");
      for(int i=0;i<=6;i++) {
    	 if(temp[i] == null) 
    		 NO2[i]=0;
    	 else
    		 NO2[i]=(int)(Double.parseDouble(temp[i]) * 2000);
      }
   }   
   public void setOZ(String a) {
      String[] temp=a.split(",");
      for(int i=0;i<=6;i++) {
    	 if(temp[i] == null)
    		 OZ[i]=0;
    	 else
    		 OZ[i]=(int)(Double.parseDouble(temp[i]) * 3000);
      }
   }
   public void setSO2(String a) {
      
      String[] temp=a.split(",");
      for(int i=0;i<=6;i++) {
    	  if(temp[i] == null)
    		  SO2[i] = 0;
    	  else  
    		  SO2[i]=(int)(Double.parseDouble(temp[i]) * 3000);
      }
   }
   public void setCO2(String a) {
      
      String[] temp=a.split(",");
      for(int i=0;i<=6;i++) {
    	  if(temp[i] == null)
    		  CO2[i]=0;
    	  else
    		  CO2[i]=(int)(Double.parseDouble(temp[i]) * 100);
      }
   }
   public void setFd(String a) {
      
      String[] temp=a.split(",");
      for(int i=0;i<=6;i++) {
    	  if(temp[i] == null)
    		  Fd[i] = 0;
    	  else
    		  Fd[i]=(int)(Double.parseDouble(temp[i]));
      }
   }
   public void setUd(String a) {
      
      String[] temp=a.split(",");
      for(int i=0;i<=6;i++) {
    	  if(temp[i] == null)
    		  Ud[i]=0;
    	  else
    		  Ud[i]=(int)(Double.parseDouble(temp[i]));
      }
   }

   

   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);

      // 종류Y축
      g.setColor(Color.PINK);// 글자
      g.drawString("NO2", 5, 30);
      g.setColor(Color.RED);
      g.drawString("OZ", 5, 60);
      g.setColor(Color.YELLOW);
      g.drawString("CO2", 5, 90);
      g.setColor(Color.GREEN);
      g.drawString("SO2", 5, 120);
      g.setColor(Color.BLUE);// 글자
      g.drawString("Fd", 5, 150);
      g.setColor(Color.WHITE);// 글자
      g.drawString("Ud", 5, 180);

/////////////NO2시작
      
      int x1 = 60;// 초기 x좌표

      // 점찍 반복문으로 수정//
      for (int i = 0; i <= 6; i++) {
         g.setColor(Color.PINK);
         g.fillOval(x1, 160-NO2[i], 5, 5);
         x1 += 50;
      }
      x1 = 60;// 다시 x 초기 값으로 셋팅
      // 직선 반복으로 수정
      for (int i = 0; i < 6; i++) {
         g.drawLine(x1, 160-NO2[i] + 3, x1 + 50, 160-NO2[i + 1] + 3);
         x1 += 50;
      }
      x1 = 60;//

//////////////////Oz그래프 시작
      g.setColor(Color.RED);
      for (int i = 0; i <= 6; i++) {
         g.fillOval(x1, 160-OZ[i], 5, 5);
         x1 += 50;
      }

      x1 = 60;
      for (int i = 0; i < 6; i++) {
         g.drawLine(x1, 160-OZ[i] + 3, x1 + 50, 160-OZ[i + 1] + 3);
         x1 += 50;
      }
      x1 = 60;// 그래프 그리고 다시 원위치

//////////////////CO2그래프 시작
      g.setColor(Color.YELLOW);
      for (int i = 0; i <= 6; i++) {
         g.fillOval(x1, 160-CO2[i], 5, 5);
         x1 += 50;
      }

      x1 = 60;
      for (int i = 0; i < 6; i++) {
         g.drawLine(x1, 160-CO2[i] + 3, x1 + 50, 160-CO2[i + 1] + 3);
         x1 += 50;
      }
      x1 = 60;// 그래프 그리고 다시 원위치

/////////SO2시작
      g.setColor(Color.GREEN);
      for (int i = 0; i <= 6; i++) {
         g.fillOval(x1, 160-SO2[i], 5, 5);
         x1 += 50;
      }

      x1 = 60;
      for (int i = 0; i < 6; i++) {
         g.drawLine(x1, 160-SO2[i] + 3, x1 + 50, 160-SO2[i + 1] + 3);
         x1 += 50;
      }
      x1 = 60;// 그래프 그리고 다시 원위치

//////////////Fd 시작
      g.setColor(Color.BLUE);
      for (int i = 0; i <= 6; i++) {
         g.fillOval(x1, 160-Fd[i], 5, 5);
         x1 += 50;
      }

      x1 = 60;
      for (int i = 0; i < 6; i++) {
         g.drawLine(x1,160- Fd[i] + 3, x1 + 50,160- Fd[i + 1] + 3);
         x1 += 50;
      }
      x1 = 60;// 그래프 그리고 다시 원위치
//////////Ud
      g.setColor(Color.WHITE);
      for (int i = 0; i <= 6; i++) {
         g.fillOval(x1, 160-Ud[i], 5, 5);
         x1 += 50;
      }

      x1 = 60;
      for (int i = 0; i < 6; i++) {
         g.drawLine(x1, 160-Ud[i] + 3, x1 + 50, 160-Ud[i + 1] + 3);
         x1 += 50;
      }
      x1 = 60;// 그래프 그리고 다시 원위치
      
      // 기간 1~7일 X축
      String [] days= {"DAY1","DAY2","DAY3","DAY4","DAY5","DAY6","DAY7"};//하단 일수 기준 라벨
      int dayX=50;//하단 일수 라벨 x좌표 기준.  
      for(int i=0;i<=6;i++) {
         g.drawString("DAY1", dayX, 200);// 내용,x좌표,y좌표
         dayX+=50;
      }

      
      g.setColor(Color.gray);
      
      int yy=163;//기준선의 선 시작 y값
      
      for(int i=0;i<8;i++) {
         g.drawLine(60, yy, 400, yy);
         yy=yy-20;
      }
      yy=167;
      
      String [] standard= {"0","10","20","30","40","50","60","70"};
      for(int i=0;i<8;i++) {
         g.drawString(standard[i], 420,yy );
         yy=yy-20;
      }
   }
}
