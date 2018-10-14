/*
	function:为NA旧报修网添加工作日
	author:龙猫
	date:2018/10/14
 */

public class Main {

    public static void main(String[] args) {
        int i = Integer.parseInt("01");
		DateAddOne dateAddOne = new DateAddOne();
		CheckWorkday checkWorkday = new CheckWorkday();
		String date = dateAddOne.DateAddOneFunction("2018-10-12");
		try {
			boolean x = checkWorkday.checkWorkDay(date);
			System.out.println(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println(date);
    }
}
