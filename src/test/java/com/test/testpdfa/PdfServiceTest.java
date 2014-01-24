package com.test.testpdfa;

import static org.junit.Assert.*;

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

}
