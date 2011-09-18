package com.netty.game;

import java.util.Calendar;

public class Membership {

	private Calendar calendar;
	private byte seconds;
	private byte minutes;
	private byte hours;
	private byte days;
	private byte weeks;
	private byte months;
	private int years;

	public Membership() {
		this.setCalendar(Calendar.getInstance());
		this.setSeconds((byte) this.getCalendar().get(Calendar.SECOND));
		this.setMinutes((byte) this.getCalendar().get(Calendar.MINUTE));
		this.setHours((byte) this.getCalendar().get(Calendar.HOUR));
		this.setDays((byte) this.getCalendar().get(Calendar.DAY_OF_MONTH));
		this.setWeeks((byte) this.getCalendar().get(Calendar.WEEK_OF_MONTH));
		this.setMonths((byte) this.getCalendar().get(Calendar.MONTH));
		this.setYears(this.getCalendar().get(Calendar.YEAR));
	}

	public byte getSecondsLeft() {
		Calendar calendar = Calendar.getInstance();
		if (this.getSeconds() > calendar.get(Calendar.SECOND)) {
			byte secondsLeft = (byte) (this.getSeconds() - calendar.get(Calendar.SECOND));
			byte seconds = this.getSeconds();
			seconds -= secondsLeft;
			this.setSeconds(seconds);
			return this.getSeconds();
		}
		byte secondsLeft = (byte) (this.getSeconds() - calendar.get(Calendar.SECOND));
		byte seconds = this.getSeconds();
		seconds += secondsLeft;
		this.setSeconds(seconds);
		return this.getSeconds();
	}

	public byte getMinutesLeft() {
		Calendar calendar = Calendar.getInstance();
		if (this.getMinutes() > calendar.get(Calendar.MINUTE)) {
			byte minutesLeft = (byte) (this.getMinutes() - calendar.get(Calendar.MINUTE));
			byte minutes = this.getMinutes();
			minutes -= minutesLeft;
			this.setMinutes(minutes);
			return this.getMinutes();
		}
		byte minutesLeft = (byte) (this.getMinutes() - calendar.get(Calendar.MINUTE));
		byte minutes = this.getMinutes();
		minutes += minutesLeft;
		this.setMinutes(minutes);
		return this.getMinutes();
	}

	public byte getHoursLeft() {
		Calendar calendar = Calendar.getInstance();
		if (this.getHours() > calendar.get(Calendar.HOUR)) {
			byte hoursLeft = (byte) (this.getHours() - calendar.get(Calendar.HOUR));
			byte hours = this.getHours();
			hours -= hoursLeft;
			this.setHours(hours);
			return this.getHours();
		}
		byte hoursLeft = (byte) (this.getHours() - calendar.get(Calendar.HOUR));
		byte hours = this.getHours();
		hours += hoursLeft;
		this.setHours(hours);
		return this.getHours();
	}

	public byte getDaysLeft() {
		Calendar calendar = Calendar.getInstance();
		if (this.getDays() > calendar.get(Calendar.DAY_OF_MONTH)) {
			byte daysLeft = (byte) (this.getDays() - calendar.get(Calendar.DAY_OF_MONTH));
			byte days = this.getDays();
			days -= daysLeft;
			this.setDays(days);
			return this.getDays();
		}
		byte daysLeft = (byte) (this.getDays() - calendar.get(Calendar.DAY_OF_MONTH));
		byte days = this.getDays();
		days += daysLeft;
		this.setDays(days);
		return this.getDays();
	}

	public byte getWeeksLeft() {
		Calendar calendar = Calendar.getInstance();
		if (this.getWeeks() > calendar.get(Calendar.WEEK_OF_MONTH)) {
			byte weeksLeft = (byte) (this.getWeeks() - calendar.get(Calendar.WEEK_OF_MONTH));
			byte weeks = this.getWeeks();
			weeks -= weeksLeft;
			this.setWeeks(weeks);
			return this.getWeeks();
		}
		byte weeksLeft = (byte) (this.getWeeks() - calendar.get(Calendar.WEEK_OF_MONTH));
		byte weeks = this.getWeeks();
		weeks += weeksLeft;
		this.setWeeks(weeks);
		return this.getWeeks();
	}

	public byte getMonthsLeft() {
		Calendar calendar = Calendar.getInstance();
		if (this.getMonths() > calendar.get(Calendar.MONTH)) {
			byte monthsLeft = (byte) (this.getMonths() - calendar.get(Calendar.MONTH));
			byte months = this.getMonths();
			months -= monthsLeft;
			this.setMonths(months);
			return this.getMonths();
		}
		byte monthsLeft = (byte) (this.getMonths() - calendar.get(Calendar.MONTH));
		byte months = this.getMonths();
		months += monthsLeft;
		this.setMonths(months);
		return this.getMonths();
	}

	public int getYearsLeft() {
		Calendar calendar = Calendar.getInstance();
		if (this.getYears() > calendar.get(Calendar.YEAR)) {
			int yearsLeft = this.getYears() - calendar.get(Calendar.YEAR);
			int years = this.getYears();
			years -= yearsLeft;
			this.setYears(years);
			return this.getYears();
		}
		int yearsLeft = this.getYears() - calendar.get(Calendar.YEAR);
		int years = this.getYears();
		years += yearsLeft;
		this.setYears(years);
		return this.getYears();
	}

	public String getLastLoggedIn() {
		return "You last logged in " + this.getSecondsLeft() + " seconds, " + this.getMinutesLeft() + " minutes, " + this.getHoursLeft() + " hours, " + this.getDaysLeft() + " days, " + this.getWeeksLeft() + " weeks, " + this.getMonthsLeft() + " months, " + this.getYearsLeft() + " years";
	}

	public void resetMembership() {
		if (this.getSecondsLeft() <= 0) {

		}
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public Calendar getCalendar() {
		return this.calendar;
	}

	public void setSeconds(byte seconds) {
		this.seconds = seconds;
	}

	public byte getSeconds() {
		return this.seconds;
	}

	public void setMinutes(byte minutes) {
		this.minutes = minutes;
	}

	public byte getMinutes() {
		return this.minutes;
	}

	public void setHours(byte hours) {
		this.hours = hours;
	}

	public byte getHours() {
		return this.hours;
	}

	public void setDays(byte days) {
		this.days = days;
	}

	public byte getDays() {
		return this.days;
	}

	public void setWeeks(byte weeks) {
		this.weeks = weeks;
	}

	public byte getWeeks() {
		return this.weeks;
	}

	public void setMonths(byte months) {
		this.months = months;
	}

	public byte getMonths() {
		return this.months;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getYears() {
		return this.years;
	}
}