/*
	function:为NA旧报修网添加工作日
	author:龙猫
	date:2018/10/14
 */

public class DateAddOne {
	public String DateAddOneFunction(String InputDate){
		String NewDate;
		int MaxDate = 100;
		String strs[] = InputDate.split("-");
		int y =	Integer.parseInt(strs[0]);
		int m = Integer.parseInt(strs[1]);
		int d =	Integer.parseInt(strs[2]);
		switch (m){
			case 1:
				MaxDate = 31;
				break;
			case 2:
				MaxDate = 28;
				break;
			case 3:
				MaxDate = 31;
				break;
			case 4:
				MaxDate = 30;
				break;
			case 5:
				MaxDate = 31;
				break;
			case 6:
				MaxDate = 31;
				break;
			case 7:
				MaxDate = 31;
				break;
			case 8:
				MaxDate = 31;
				break;
			case 9:
				MaxDate = 30;
				break;
			case 10:
				MaxDate = 31;
				break;
			case 11:
				MaxDate = 30;
				break;
			case 12:
				MaxDate = 31;
				break;
		}
		if (d < MaxDate & m < 13){		//日期小于改月份最小日期，并且月份小于13执行
			if (MaxDate == 100){
				System.out.println("MaxDate=100,程序出错！");
			}
			d++;
		}else if (m < 12){				//月份不是12月时，月份+1
			d = 1;
			m++;
		}else {							//当月份为12月是，设置日期为明年1月1日
			y++;
			m = 1;
			d = 1;
		}
		if (m < 10 & d < 10){
			NewDate = y + "-0" + m + "-0" + d;
		}else if (m < 10){
			NewDate = y + "-0" + m + "-" + d;
		}else if (d < 10){
			NewDate = y + "-" + m + "-0" + d;
		} else {
			NewDate = y + "-" + m + "-" + d;
		}
		return NewDate;
	}
}
