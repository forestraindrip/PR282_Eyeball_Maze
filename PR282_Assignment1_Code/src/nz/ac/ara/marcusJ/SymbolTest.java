package nz.ac.ara.marcusJ;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SymbolTest {

	@Nested
	class testGetRandomSymbol {
		@Test
		void testGetRandomSymbolType() {
			final String errMsg = "The return type should be Symbol";
			final Class<Symbol> expected = Symbol.class;

			final Class<?> actual = Symbol.getRandomSymbol().getClass();

			assertEquals(expected, actual, errMsg);
		}

		@Test
		void testGetRandomSymbolValue() {
			final String errMsg = "The return type should not be NONE";

			for (int count = 0; count < 100; ++count) {
				final Symbol none = Symbol.NONE;				
				final Symbol symbol = Symbol.getRandomSymbol();
				
				assertTrue(symbol != none, errMsg );
			}
		}
	}
}
