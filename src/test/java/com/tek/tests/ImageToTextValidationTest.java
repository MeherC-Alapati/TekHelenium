package com.tek.tests;

import java.io.File;

import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ImageToTextValidationTest {

	@Test()
	public void validateImgetext() {

		String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\documents\\TekLogo.PNG";

		try {
			String text = getTextFromImage(filepath);
			System.out.println(text);
		} catch (TesseractException e) {
			System.out.println("Exception" + e.getMessage());
		}

	}

	public String getTextFromImage(String filepath) throws TesseractException {
		ITesseract tess = new Tesseract();
		return tess.doOCR(new File(filepath));

	}

}
