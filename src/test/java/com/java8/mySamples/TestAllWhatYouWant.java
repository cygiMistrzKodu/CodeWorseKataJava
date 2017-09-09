package com.java8.mySamples;

import static org.junit.Assert.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class TestAllWhatYouWant {

	@Test
	@Ignore
	public void test() {

		List<String> validationSummary = new ArrayList<String>();

		validationSummary.add("Lista 1 lala 1");
		validationSummary.add("Lista &&***^");
		validationSummary.add("Lista 110  100 10");
		validationSummary.add("Zasuwamy Panie Janie");

		StringBuilder builder = new StringBuilder();

		// String a = builder.append(validationSummary).toString();

		validationSummary.forEach(t -> builder.append(t + "\n"));

		System.out.println(builder.toString());

	}

	@Test
	public void test2() {

		// LocalDate date = LocalDate.now();
		//
		// GregorianCalendar gregorianCalendar =
		// GregorianCalendar.from(ZonedDateTime.now());

		// "valueDate":"2016-08-22"

		// ZoneId zoneId = ZoneId.of("Europe/London");
		// ZoneId zoneId2 = ZoneId.of("Australia/Lord_Howe");

		// ZoneId zoneId = ZoneId.of("America/Los_Angeles");
		// ZoneId zoneId2 = ZoneId.of("Australia/Lord_Howe");
		//
		//
		// LocalDate localDate = LocalDate.of(2016, 8, 22);
		//
		// LocalDate LalaZoneDate = LocalDate.now(zoneId);
		//
		// LocalDate LalaZoneDate3 = LocalDate.now(zoneId2);
		//
		// LalaZoneDate = LalaZoneDate.of(localDate.getYear(),
		// localDate.getMonth(),localDate.getDayOfMonth());
		//
		//
		// System.out.println(LalaZoneDate);
		//
		//
		// System.out.println(LalaZoneDate3);

		// localDate.get

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
//		String ValueDateText = "2016-08-21";

//		String ValueDateText = "2016-08-05";
//		String ValueDateText = "2016-08-05";
		String ValueDateText = "2017-08-27";

		LocalDate valueDate = LocalDate.parse(ValueDateText, dateTimeFormatter);

		if (valueDate.getDayOfWeek() == DayOfWeek.SATURDAY) {

			System.out.println("Dzisiaj jest Sobota\n");

		}

		if (valueDate.getDayOfWeek() == DayOfWeek.SUNDAY) {

			System.out.println("Dzisiaj Niedziela\n");

		}
		
		System.out.println("------- ISO FORMAT -----");
		System.out.println(valueDate);

	}

}
