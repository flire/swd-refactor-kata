package task1;

import org.junit.Test;
import org.junit.Assert;

public class IndexOfAnyTest {
	@Test
	public void testSearchTheOnly() {
		int resultIndex = IndexOfAny.indexOfAny("abcedf", new char[] {'c'});
		Assert.assertEquals(2, resultIndex);
	}
	
	@Test
	public void testSearchMultiple() {
		int resultIndex = IndexOfAny.indexOfAny("abcedf", new char[] {'b','c', 'a'});
		Assert.assertEquals(0, resultIndex);
	}
	
	@Test
	public void testSearchNone() {
		int resultIndex = IndexOfAny.indexOfAny("abcedf", new char[] {});
		Assert.assertEquals(-1, resultIndex);
	}
	
	@Test
	public void testSearchNoneExistent() {
		int resultIndex = IndexOfAny.indexOfAny("abcedf", new char[] {'g'});
		Assert.assertEquals(-1, resultIndex);
	}
	
	@Test
	public void testSearchEmptyString() {
		int resultIndex = IndexOfAny.indexOfAny("", new char[] {'a'});
		Assert.assertEquals(-1, resultIndex);
	}
}