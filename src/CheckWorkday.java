/*
	function:为NA旧报修网添加工作日
	author:龙猫
	date:2018/10/14
 */

public class CheckWorkday {
	//	把你想要知道的日期号，加上该月份代号，再除以7，
	//	能整除的就是星期日；不能整除的，余数是几，那天就是星期几。
	//	如果日期号和月份代号相加的和小于7，那么这个和是几，那天就是星期几
	//  该年月份代号＝该月星期几－该月日期号。
	public boolean checkWorkDay(String date) throws Exception{	//是周末则返回false
		//判断日期是否是周六周日
		//基姆拉尔森计算公式
		String strs[] = date.split("-");
		int y =	Integer.parseInt(strs[0]);
		int m = Integer.parseInt(strs[1]);
		int d =	Integer.parseInt(strs[2]);
		if(m==1||m==2){//把一月和二月换算成上一年的十三月和是四月  
			m+=12;
			y--;
		}
		int	Week=(d+2*m+3*(m+1)/5+y+y/4-y/100+y/400)%7;
		switch(Week)
		{
//		case	0:	cout<<"是星期一"<<endl;break;
//		case	1:	cout<<"是星期二"<<endl;break;
//		case	2:	cout<<"是星期三"<<endl;break;
//		case	3:	cout<<"是星期四"<<endl;break;
//		case	4:	cout<<"是星期五"<<endl;break;
			case	5:	return false;
			case	6:	return false;
		}
		return true;
	}
}
