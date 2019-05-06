package nz.ac.ara.marcusJ;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ColourTest {

	@Nested
	class testGetRandomColour {
		@Test
		void testGetRandomColourType() {
			final String errMsg = "The return type should be Colour";
			final Class<Colour> expect = Colour.class;

			final Class<?> actual = Colour.getRandomColour().getClass();

			assertEquals(expect, actual, errMsg);
		}

		@Test
		void testGetRandomColourValue() {
			final String errMsg = "The return type should not be NONE";

			for (int count = 0; count < 100; ++count) {
				final Colour none = Colour.NONE;				
				final Colour colour = Colour.getRandomColour();
				
				assertTrue(colour != none, errMsg );
			}
		}
	}
}
