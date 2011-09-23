package com.netty.model.player;

import java.util.Calendar;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:11:21 AM
 */
public class Membership {

	/**
	 * 
	 */
	private Calendar calendar;

	/**
	 * 
	 */
	private byte seconds;

	/**
	 * 
	 */
	private byte minutes;

	/**
	 * 
	 */
	private byte hours;

	/**
	 * 
	 */
	private byte days;

	/**
	 * 
	 */
	private byte weeks;

	/**
	 * 
	 */
	private byte months;

	/**
	 * 
	 */
	private int years;

	/**
	 * 
	 */
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

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getLastLoggedIn() {
		return "You last logged in " + this.getSecondsLeft() + " seconds, " + this.getMinutesLeft() + " minutes, " + this.getHoursLeft() + " hours, " + this.getDaysLeft() + " days, " + this.getWeeksLeft() + " weeks, " + this.getMonthsLeft() + " months, " + this.getYearsLeft() + " years";
	}

	/**
	 * 
	 */
	public void resetMembership() {
		if (this.getSecondsLeft() <= 0) {
			return;
		}
	}

	/**
	 * 
	 * @param calendar
	 * 			The id to set.
	 */
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Calendar getCalendar() {
		return this.calendar;
	}

	/**
	 * 
	 * @param seconds
	 * 			The id to set.
	 */
	public void setSeconds(byte seconds) {
		this.seconds = seconds;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getSeconds() {
		return this.seconds;
	}

	/**
	 * 
	 * @param minutes
	 * 			The id to set.
	 */
	public void setMinutes(byte minutes) {
		this.minutes = minutes;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getMinutes() {
		return this.minutes;
	}

	/**
	 * 
	 * @param hours
	 * 			The id to set.
	 */
	public void setHours(byte hours) {
		this.hours = hours;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getHours() {
		return this.hours;
	}

	/**
	 * 
	 * @param days
	 * 			The id to set.
	 */
	public void setDays(byte days) {
		this.days = days;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getDays() {
		return this.days;
	}

	/**
	 * 
	 * @param weeks
	 * 			The id to set.
	 */
	public void setWeeks(byte weeks) {
		this.weeks = weeks;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getWeeks() {
		return this.weeks;
	}

	/**
	 * 
	 * @param months
	 * 			The id to set.
	 */
	public void setMonths(byte months) {
		this.months = months;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getMonths() {
		return this.months;
	}

	/**
	 * 
	 * @param years
	 * 			The id to set.
	 */
	public void setYears(int years) {
		this.years = years;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getYears() {
		return this.years;
	}
}