package com.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
	// 获取当天的开始时间
	public static Date getDayBegin() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getYesterday() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, -1);
		return c.getTime();
	}

	// 获取当天1点时间
	public static Date getDayOne() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 1);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	// 获取当天2点时间
	public static Date getDayTwo() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 2);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天3点时间
	public static Date getDayThree() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 3);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天4点时间
	public static Date getDayFour() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 4);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天5点时间
	public static Date getDayFive() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 5);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天6点时间
	public static Date getDaySix() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY,6);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天7点时间
	public static Date getDaySeven() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 7);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天8点时间
	public static Date getDayEight() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 8);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天9点时间
	public static Date getDayNine() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 9);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	// 获取当天10点时间
	public static Date getDayTen() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 10);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天11点时间
	public static Date getDayEleven() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 11);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天12点时间
	public static Date getDayTwelve() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天13点时间
	public static Date getDayThirteen() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 13);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天14点时间
	public static Date getDayFourteen() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 14);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天15点时间
	public static Date getDayFifteen() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 15);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天16点时间
	public static Date getDaySixteen() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 16);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天17点时间
	public static Date getDaySeventeen() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 17);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天18点时间
	public static Date getDayEighteen() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 18);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天19点时间
	public static Date getDayNineteen() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 19);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天20点时间
	public static Date getDayTwenty() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 20);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天21点时间
	public static Date getDayTwentyOne() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 21);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天22点时间
	public static Date getDayTwentyTwo() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 22);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天23点时间
	public static Date getDayTwentyThree() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	// 获取当天的结束时间
	public static Date getDayEnd() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	// 获取本周的开始时间
	public static Date getBeginDayOfWeek() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayofweek == 1) {
			dayofweek += 7;
		}
		cal.add(Calendar.DATE, 2 - dayofweek);
		return getDayStartTime(cal.getTime());
	}

	// 获取本周的结束时间
	public static Date getEndDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getBeginDayOfWeek());
		cal.add(Calendar.DAY_OF_WEEK, 6);
		Date weekEndSta = cal.getTime();
		return getDayEndTime(weekEndSta);
	}

	// 获取本月的开始时间
	public static Date getBeginDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		return getDayStartTime(calendar.getTime());
	}

	// 获取本月的结束时间
	public static Date getEndDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		int day = calendar.getActualMaximum(5);
		calendar.set(getNowYear(), getNowMonth() - 1, day);
		return getDayEndTime(calendar.getTime());
	}

	// 获取本年的开始时间
	public static Date getBeginDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		// cal.set
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR,00);
		cal.set(Calendar.MINUTE,00);
		cal.set(Calendar.SECOND,00);

		return getDayStartTime(cal.getTime());
	}

	// 获取本年的结束时间
	public static Date getEndDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DATE, 31);
		cal.set(Calendar.HOUR,00);
		cal.set(Calendar.MINUTE,00);
		cal.set(Calendar.SECOND,00);
		return getDayEndTime(cal.getTime());
	}

	// 获取某个日期的开始时间
	public static Timestamp getDayStartTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0,
				0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return new Timestamp(calendar.getTimeInMillis());
	}

	// 获取某个日期的结束时间
	public static Timestamp getDayEndTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23,
				59, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return new Timestamp(calendar.getTimeInMillis());
	}

	// 获取今年是哪一年
	public static Integer getNowYear() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return Integer.valueOf(gc.get(1));
	}

	// 获取本月是哪一月
	public static int getNowMonth() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return gc.get(2) + 1;
	}

	// 两个日期相减得到的天数
	public static int getDiffDays(Date beginDate, Date endDate) {

		if (beginDate == null || endDate == null) {
			throw new IllegalArgumentException("getDiffDays param is null!");
		}

		long diff = (endDate.getTime() - beginDate.getTime()) / (1000 * 60 * 60 * 24);

		int days = new Long(diff).intValue();

		return days;
	}

	// 两个日期相减得到的毫秒数
	public static long dateDiff(Date beginDate, Date endDate) {
		long date1ms = beginDate.getTime();
		long date2ms = endDate.getTime();
		return date2ms - date1ms;
	}

	// 获取本年二月开始时间
	public static Date getFebruaryOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		// cal.set
		cal.set(Calendar.MONTH, Calendar.FEBRUARY);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR,00);
		cal.set(Calendar.MINUTE,00);
		cal.set(Calendar.SECOND,00);

		return getDayStartTime(cal.getTime());
	}

	// 获取本年三月开始时间
	public static Date getMarchOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		// cal.set
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR,00);
		cal.set(Calendar.MINUTE,00);
		cal.set(Calendar.SECOND,00);

		return getDayStartTime(cal.getTime());
	}

	// 获取本年四月开始时间
	public static Date getAprilOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		// cal.set
		cal.set(Calendar.MONTH, Calendar.APRIL);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR,00);
		cal.set(Calendar.MINUTE,00);
		cal.set(Calendar.SECOND,00);


		return getDayStartTime(cal.getTime());
	}

	// 获取本年五月开始时间
	public static Date getMayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		// cal.set
		cal.set(Calendar.MONTH, Calendar.MAY);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR,00);
		cal.set(Calendar.MINUTE,00);
		cal.set(Calendar.SECOND,00);

		return getDayStartTime(cal.getTime());
	}

	// 获取本年六月开始时间
	public static Date getJuneOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		// cal.set
		cal.set(Calendar.MONTH, Calendar.JUNE);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR,00);
		cal.set(Calendar.MINUTE,00);
		cal.set(Calendar.SECOND,00);

		return getDayStartTime(cal.getTime());
	}

	// 获取本年七月开始时间
	public static Date getJulyOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		// cal.set
		cal.set(Calendar.MONTH, Calendar.JULY);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR,00);
		cal.set(Calendar.MINUTE,00);
		cal.set(Calendar.SECOND,00);

		return getDayStartTime(cal.getTime());
	}

	// 获取本年八月开始时间
	public static Date getAugustOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		// cal.set
		cal.set(Calendar.MONTH, Calendar.AUGUST);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR,00);
		cal.set(Calendar.MINUTE,00);
		cal.set(Calendar.SECOND,00);

		return getDayStartTime(cal.getTime());
	}

	// 获取本年九月开始时间
	public static Date getSeptemberOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		// cal.set
		cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR,00);
		cal.set(Calendar.MINUTE,00);
		cal.set(Calendar.SECOND,00);

		return getDayStartTime(cal.getTime());
	}

	// 获取本年十月开始时间
	public static Date getOctoberOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		// cal.set
		cal.set(Calendar.MONTH, Calendar.OCTOBER);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR,00);
		cal.set(Calendar.MINUTE,00);
		cal.set(Calendar.SECOND,00);

		return getDayStartTime(cal.getTime());
	}

	// 获取本年十一月开始时间
	public static Date getNovemberOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		// cal.set
		cal.set(Calendar.MONTH, Calendar.NOVEMBER);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR,00);
		cal.set(Calendar.MINUTE,00);
		cal.set(Calendar.SECOND,00);

		return getDayStartTime(cal.getTime());
	}

	// 获取本年十二月开始时间
	public static Date getDecemberOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		// cal.set
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR,00);
		cal.set(Calendar.MINUTE,00);
		cal.set(Calendar.SECOND,00);

		return getDayStartTime(cal.getTime());
	}
}
