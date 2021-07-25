package searchEngine;

/*************************************************************************
 *  Compilation:  javac In.java
 *  Execution:    java In   (basic test --- see source for required files)
 *
 *  Reads in data of various types from standard input, files, and URLs.
 *
 *************************************************************************/

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * <i>Input</i>. This class provides methods for reading strings and numbers
 * from standard input, file input, URLs, and sockets.
 * <p>
 * The Locale used is: language = English, country = US. This is consistent with
 * the formatting conventions with Java floating-point literals, command-line
 * arguments (via {@link Double#parseDouble(String)}) and standard output.
 * <p>
 * For additional documentation, see
 * <a href="http://introcs.cs.princeton.edu/31datatype">Section 3.1</a> of
 * <i>Introduction to Programming in Java: An Interdisciplinary Approach</i> by
 * Robert Sedgewick and Kevin Wayne.
 * <p>
 * Like {@link Scanner}, reading a token also consumes preceding Java
 * whitespace, reading a full line consumes the following end-of-line delimeter,
 * while reading a character consumes nothing extra.
 * <p>
 * Whitespace is defined in {@link Character#isWhitespace(char)}. Newlines
 * consist of \n, \r, \r\n, and Unicode hex code points 0x2028, 0x2029, 0x0085;
 * see <tt><a href="http://www.docjar.com/html/api/java/util/Scanner.java.html">
 *  Scanner.java</a></tt> (NB: Java 6u23 and earlier uses only \r, \r, \r\n).
 *
 * @author David Pritchard
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public final class In {

	private Scanner scanner;

	/*** begin: section (1 of 2) of code duplicated from In to StdIn */

	// assume Unicode UTF-8 encoding
	private static final String CHARSET_NAME = "UTF-8";

	// assume language = English, country = US for consistency with System.out.
	private static final Locale LOCALE = Locale.US;

	// the default token separator; we maintain the invariant that this value
	// is held by the scanner's delimiter between calls
	private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

	// makes whitespace characters significant
	private static final Pattern EMPTY_PATTERN = Pattern.compile("");

	// used to read the entire input. source:
	// http://weblogs.java.net/blog/pat/archive/2004/10/stupid_scanner_1.html
	private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");

	
	/**
	 * Create an input stream from a filename or web page name.
	 */
	public In(String s) {
		try {
			// first try to read file from local file system
			File file = new File(s);
			if (file.exists()) {
				scanner = new Scanner(file, CHARSET_NAME);
				scanner.useLocale(LOCALE);
				return;
			}

			// next try for files included in jar
			URL url = getClass().getResource(s);

			// or URL from web
			if (url == null) {
				url = new URL(s);
			}

			URLConnection site = url.openConnection();

			// in order to set User-Agent, replace above line with these two
			// HttpURLConnection site = (HttpURLConnection) url.openConnection();
			// site.addRequestProperty("User-Agent", "Mozilla/4.76");

			InputStream is = site.getInputStream();
			scanner = new Scanner(new BufferedInputStream(is), CHARSET_NAME);
			scanner.useLocale(LOCALE);
		} catch (IOException ioe) {
			System.err.println("Could not open " + s);
		}
	}

	public String readAll() { if (!scanner.hasNextLine()) return "";
	 
	  String result = scanner.useDelimiter(EVERYTHING_PATTERN).next(); // not that important to reset delimeter, since now scanner is empty
	  scanner.useDelimiter(WHITESPACE_PATTERN); // but let's do it anyway 
	  return result; 
	  }
	 

}