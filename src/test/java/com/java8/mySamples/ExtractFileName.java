package com.java8.mySamples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class ExtractFileName {

	@Test
	public void test() {

		// String input = "1231231223123131_FILE_NAME.EXTENSION.OTHEREXTENSION\r\n";
		// String input =
		// "1_This_is_an_otherExample.mpg.OTHEREXTENSIONadasdassdassds34";
		String input = "1231231223123131_myFile.tar.gz2";
		// String input = "1231231223123131_FILE_NAME.EXTENSION.OTHEREXTENSION";
		// String input = "r621257";

		System.out.println(extractFileName(input));

	}

	public static String extractFileName(String dirtyFileName) {

		Pattern p = Pattern.compile(".*?_(.*\\..*)\\..*\\s*");
		Matcher m = p.matcher(dirtyFileName);
		m.matches();

		return m.group(1);
	}

}
