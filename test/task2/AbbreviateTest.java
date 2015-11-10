package task2;

import org.junit.Test;

import org.junit.Assert;

public class AbbreviateTest {
	
  private static final String LONG_STRING = "I'm way too long, ain't I?";

@Test
  public void unneccessaryAbbrevitateAtFront() {
	  String result = Abbreviate.abbreviateAtFront(LONG_STRING, 3);
	  Assert.assertEquals(LONG_STRING, result);
  }
  
  @Test
  public void effectivelyAbbrevitateAtFront() {
	  String result = Abbreviate.abbreviateAtFront(LONG_STRING, 5);
	  Assert.assertEquals("...ay too long, ain't I?", result);
  }
  
  @Test
  public void fullyAbbreviateAtFront() {
	  String result = Abbreviate.abbreviateAtFront(LONG_STRING, LONG_STRING.length() - 3);
	  Assert.assertEquals("...", result);
  }
  
  @Test
  public void unneccessaryAbbreviate() {
	  String result = Abbreviate.abbreviate(LONG_STRING, LONG_STRING.length());
	  Assert.assertEquals(LONG_STRING, result);
  }
  
  @Test
  public void effectivelyAbbrevitate() {
	  String result = Abbreviate.abbreviate(LONG_STRING, 10);
	  Assert.assertEquals("I'm way...", result);
  }
  
  @Test
  public void fullyAbbreviate() {
	  String result = Abbreviate.abbreviate(LONG_STRING, 3);
	  Assert.assertEquals("...", result);
  }
  
  @Test
  public void abbreviateBothSides() {
	  String result = Abbreviate.abbreviate(LONG_STRING, 8, 5);
	  Assert.assertEquals("...ay...", result);
  }
}