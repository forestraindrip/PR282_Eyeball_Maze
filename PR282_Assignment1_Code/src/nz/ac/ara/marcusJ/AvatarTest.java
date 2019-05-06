package nz.ac.ara.marcusJ;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AvatarTest {
	Avatar avatar;

	@BeforeEach
	void beforeEach() {
		Position position = new Position(2, 2);
		this.avatar = new Avatar("aAvatar", position, Direction.UP);
	}



	@Nested
	class testMoveUp {
		@Test
		void testMoveUpX() {
			final int expected = new Position(2, 0).X;
			final String errMsg = "the Avatar should not move horizontally";

			final int actual = avatar.moveUp(2).myPosition.X;

			assertEquals(expected, actual, errMsg);
		}

		@Test
		void testMoveUpY() {
			final int expected = new Position(2, 0).Y;
			final String errMsg = "the Avatar does not move up";

			final int actual = avatar.moveUp(2).myPosition.Y;

			assertEquals(expected, actual, errMsg);
		}
	}

	@Nested
	class testMoveDown {
		@Test
		void testMoveDownX() {
			final int expected = new Position(2, 4).X;
			final String errMsg = "the Avatar should not move horizontally";

			final int actual = avatar.moveDown(2).myPosition.X;

			assertEquals(expected, actual, errMsg);
		}

		@Test
		void testMoveDownY() {
			final int expected = new Position(2, 4).Y;
			final String errMsg = "the Avatar does not move down";

			final int actual = avatar.moveDown(2).myPosition.Y;

			assertEquals(expected, actual, errMsg);

		}
	}

	@Nested
	class testMoveLeft {
		@Test
		void testMoveLeftX() {
			final int expected = new Position(0, 2).X;
			final String errMsg = "the Avatar does not move left";

			final int actual = avatar.moveLeft(2).myPosition.X;

			assertEquals(expected, actual, errMsg);
		}

		@Test
		void testMoveLeftY() {
			final int expected = new Position(0, 2).Y;
			final String errMsg = "the Avatar should not move vertically";

			final int actual = avatar.moveLeft(2).myPosition.Y;

			assertEquals(expected, actual, errMsg);
		}
	}

	@Nested
	class testMoveRight {
		@Test
		void testMoveRightX() {
			final int expected = new Position(4, 2).X;
			final String errMsg = "the Avatar does not move right";

			final int actual = avatar.moveRight(2).myPosition.X;

			assertEquals(expected, actual, errMsg);

		}

		@Test
		void testMoveRightY() {
			final int expected = new Position(4, 2).Y;
			final String errMsg = "the Avatar should not move vertically";

			final int actual = avatar.moveRight(2).myPosition.Y;

			assertEquals(expected, actual, errMsg);

		}
	}
}
