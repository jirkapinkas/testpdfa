package com.test.testpdfa;

import java.io.File;
import java.io.IOException;

import javax.activation.FileDataSource;

import org.apache.pdfbox.preflight.PreflightDocument;
import org.apache.pdfbox.preflight.ValidationResult;
import org.apache.pdfbox.preflight.exception.SyntaxValidationException;
import org.apache.pdfbox.preflight.parser.PreflightParser;

public class PdfService {

	public static boolean isPdfA(File file) throws IOException {
		ValidationResult result = null;

		FileDataSource fd = new FileDataSource(file);
		PreflightParser parser = new PreflightParser(fd);
		try {

			/*
			 * Parse the PDF file with PreflightParser that inherits from the
			 * NonSequentialParser. Some additional controls are present to
			 * check a set of PDF/A requirements. (Stream length consistency,
			 * EOL after some Keyword...)
			 */
			parser.parse();

			/*
			 * Once the syntax validation is done, the parser can provide a
			 * PreflightDocument (that inherits from PDDocument) This document
			 * process the end of PDF/A validation.
			 */
			PreflightDocument document = parser.getPreflightDocument();
			document.validate();

			// Get validation result
			result = document.getResult();
			document.close();

		} catch (SyntaxValidationException e) {
			/*
			 * the parse method can throw a SyntaxValidationExceptionif the PDF
			 * file can't be parsed. In this case, the exception contains an
			 * instance of ValidationResult
			 */
			result = e.getResult();
		}

		// display validation result
		if (result.isValid()) {
			return true;
		} else {
			// System.out.println("The file" + args[0] +
			// " is not valid, error(s) :");
			// for (ValidationError error : result.getErrorsList()) {
			// System.out.println(error.getErrorCode() + " : " +
			// error.getDetails());
			// }
			return false;
		}

	}
}
