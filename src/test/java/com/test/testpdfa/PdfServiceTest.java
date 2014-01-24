package com.test.testpdfa;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class PdfServiceTest {

	@Test
	public void testIsPdfAFail() throws IOException {
		boolean isPdfA = PdfService.isPdfA(new File("test.pdf"));
		assertEquals(false, isPdfA);
	}

	@Test
	public void testIsPdfASuccess1() throws IOException {
		boolean isPdfA = PdfService.isPdfA(new File("test-pdfa.pdf"));
		assertEquals(true, isPdfA);
	}

	@Test(expected = NullPointerException.class)
	public void testIsPdfANPE() throws IOException {
		// currently in PDFBox 1.8.3 this throws NPE, this should be fixed in
		// PDFBox 2.0
		PdfService.isPdfA(new File("test-npe-error.pdf"));
	}

}
