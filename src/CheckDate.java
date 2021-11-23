import javax.swing.JOptionPane;

public class CheckDate {
	public static String Date;
	public CheckDate() {
		
	}

	public void setDate(int month, int date) {
		 //날짜 받기
		String error = "";
        boolean check = false;  //날짜 에러 뜨는지
       
        //시작 날짜 - 2월 에러
        if(month == 2  && date > 28) {
        	error += "날짜를 다시 선택하세요 (2월은 28일까지)" + "\n";
        }
        //시작 날짜 - 1월부터 7월
        else if(month < 8) {
        	if(month % 2 == 0 && date == 31) 
        		error += "날짜를 다시 선택하세요 (" + month + "월은 30일까지)" + "\n"; 
        	else check = true;
        }
        //시작 날짜 - 8월부터 12월
        else {
        	if(month % 2 == 1 && date == 31) 
        		error += "날짜를 다시 선택하세요 (" + month + "월은 30일까지)" + "\n"; 
        	else check = true;
        }
        
        //  에러 메시지 창 띄우기
        if(check == false) {
        	JOptionPane.showMessageDialog(null, error,"날짜 선택 오류", JOptionPane.ERROR_MESSAGE);
        }
        else {
        	Date = "2018";
        	
        	//  선택된 월의 값을 문자열로 넣기
        	if(month < 10) 
        		Date += "0" + month;
        	else
        		
        		Date += month;
        	//  선택된 일의 값을 문자열로 넣기
        	if(date < 10)
        		Date += "0" + date;
        	else
        		Date += date;
        }
	}
	public String getDate() { 
		return Date; }
}
