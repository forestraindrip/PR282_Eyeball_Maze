package nz.ac.ara.marcusJ;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

class StateTest {
	State theState;

	@BeforeEach
	void beforeEach() {
		Gson gson = new Gson();
		String json = "{\"myAvatar\":{\"myName\":\"Player\",\"myDirection\":\"UP\",\"myPosition\":{\"X\":1,\"Y\":4}},\"mySaves\":[\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}};;{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}\"],\"myMaze\":{\"mySquares\":[[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":0,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":0,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":0,\"Y\":2}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":0,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":1,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":3}},{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":2,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":2,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":2,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":3,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":3,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":4,\"Y\":4}}]],\"myStartSquare\":{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},\"myCurrentGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}}],\"myFinishedGoals\":[],\"myRoute\":[{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}}],\"widthMaze\":5,\"heightMaze\":5},\"isFinished\":false,\"mazeOriginal\":\"{\\\"mySquares\\\":[[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":3}},{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":4}}]],\\\"myStartSquare\\\":{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},\\\"myCurrentGoals\\\":[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}}],\\\"myFinishedGoals\\\":[],\\\"myRoute\\\":[{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}}],\\\"widthMaze\\\":5,\\\"heightMaze\\\":5}\"}";
		theState = gson.fromJson(json, State.class);
//		theState = new State("Player", 5, 5, 1, 4, 2, 6, Direction.UP);
	}

	// Test 1. and Test 2. are in SquareTest.java

	// 3. Automatically create a new maze
	@Nested
	class testHasAMaze {

		// 3.a Test maze has myStartSquare
		@Test
		void testHasStartSquare() {
			final String errMsg = "Should have a myStartSquare";

			final Class<Square> expected = Square.class;

			final Class<?> actual = theState.myMaze.myStartSquare.getClass();

			assertEquals(expected, actual, errMsg);
		}

		// 3.b Test maze has myCurrentGoals which is an array of squares
		@Test
		void testHasGoals() {
			final String errMsg = "Should have an myCurrentGoals which is an array of squares";

			final Class<Square> expected = Square.class;

			for (Square goal : theState.myMaze.myCurrentGoals) {
				final Class<?> actual = goal.getClass();
				assertEquals(expected, actual, errMsg);
			}
		}

		// 3.c Test maze has a route which is an array of squares
		@Test
		void testHasRoute() {
			final String errMsg = "Should have myRoute which is an array of squares";

			final Class<Square> expected = Square.class;

			for (Square aSquare : theState.myMaze.myRoute) {
				final Class<?> actual = aSquare.getClass();
				assertEquals(expected, actual, errMsg);
			}

		}
	}

	// 4. The game can create an Avatar
	@Nested
	class testHasAnAvatar {

		// 4.a Test avatar type
		@Test
		void testAvatarType() {
			final String errMsg = "Should return an Avatar instance";
			final Class<Avatar> expected = Avatar.class;

			final Class<?> actual = theState.myAvatar.getClass();

			assertEquals(expected, actual, errMsg);
		}

		// 4.b Test avatar has myPosition
		@Test
		void testAvatarHasMyPosition() {
			final String errMsg = "Should have myPosition";
			final Class<Position> expected = Position.class;

			final Class<?> actual = theState.myAvatar.myPosition.getClass();

			assertEquals(expected, actual, errMsg);
		}

		// 4.c Test avatar has myDirection
		@Test
		void testAvatarHasMyDirection() {
			final String errMsg = "Should have myPosition";
			final Class<Direction> expected = Direction.class;

			final Class<?> actual = theState.myAvatar.myDirection.getClass();

			assertEquals(expected, actual, errMsg);
		}

	}

	// 5. Avatar can move up if it is a legal move
	@Nested
	class testMoveUp {

		// 5.a. Legal move up
		@Test
		void testLegalMoveUp() {
			int x = 1;
			int y = 0;
			final boolean expected = true;
			final String errMsg = "the Avatar should move up";

			Position pos = new Position(1, 0);
			try {
				theState.moveAvatar(pos);
			} catch (Exception e) {
				e.printStackTrace();
			}
			final boolean actual = theState.myAvatar.myPosition.X == x && theState.myAvatar.myPosition.Y == y;

			assertEquals(expected, actual, errMsg);
		}

		// 5.b. Illegal move up
		@Test
		void testIllegalMoveUp() {
			final String errMsg = "the Avatar should not move up and return an Exception";
			Position pos = new Position(0, 2);

			assertThrows(Exception.class, () -> theState.moveAvatar(pos), errMsg);
		}
	}

	// 6. Avatar can move down if it is a legal move
	@Nested
	class testMoveDown {
		@BeforeEach
		void beforeEach() {
			Gson gson = new Gson();
			String json = "{\"myAvatar\":{\"myName\":\"Player\",\"myDirection\":\"LEFT\",\"myPosition\":{\"X\":2,\"Y\":1}},\"mySaves\":[\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}};;{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}};;{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"RIGHT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"DOWN\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"RIGHT\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"LEFT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}}\"],\"myMaze\":{\"mySquares\":[[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":0,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":0,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":0,\"Y\":2}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":0,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":1,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":3}},{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":2,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":2,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":2,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":3,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":3,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":4,\"Y\":4}}]],\"myStartSquare\":{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},\"myCurrentGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}}],\"myFinishedGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}}],\"myRoute\":[{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}}],\"widthMaze\":5,\"heightMaze\":5},\"isFinished\":false,\"mazeOriginal\":\"{\\\"mySquares\\\":[[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":3}},{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":4}}]],\\\"myStartSquare\\\":{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},\\\"myCurrentGoals\\\":[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}}],\\\"myFinishedGoals\\\":[],\\\"myRoute\\\":[{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}}],\\\"widthMaze\\\":5,\\\"heightMaze\\\":5}\"}\r\n";
			theState = gson.fromJson(json, State.class);
		}

		// 6.a. Legal move down
		@Test
		void testLegalMoveDown() {
			int x = 2;
			int y = 3;
			final boolean expected = true;
			final String errMsg = "the Avatar should move down";

			Position pos = new Position(2, 3);
			try {
				theState.moveAvatar(pos);
			} catch (Exception e) {
				e.printStackTrace();
			}
			final boolean actual = (theState.myAvatar.myPosition.X == x) && (theState.myAvatar.myPosition.Y == y);

			assertEquals(expected, actual, errMsg);
		}

		// 5.b. Illegal move down
		@Test
		void testIllegalMovedDown() {
			final String errMsg = "the Avatar should not move down and return an Exception";
			Position pos = new Position(2, 4);

			assertThrows(Exception.class, () -> theState.moveAvatar(pos), errMsg);
		}
	}

	// 7. Avatar can move left if it is a legal move
	@Nested
	class testMoveLeft {
		@BeforeEach
		void beforeEach() {
			Gson gson = new Gson();
			String json = "{\"myAvatar\":{\"myName\":\"Player\",\"myDirection\":\"LEFT\",\"myPosition\":{\"X\":2,\"Y\":1}},\"mySaves\":[\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}};;{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}};;{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"RIGHT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"DOWN\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"RIGHT\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"LEFT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}}\"],\"myMaze\":{\"mySquares\":[[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":0,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":0,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":0,\"Y\":2}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":0,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":1,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":3}},{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":2,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":2,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":2,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":3,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":3,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":4,\"Y\":4}}]],\"myStartSquare\":{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},\"myCurrentGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}}],\"myFinishedGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}}],\"myRoute\":[{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}}],\"widthMaze\":5,\"heightMaze\":5},\"isFinished\":false,\"mazeOriginal\":\"{\\\"mySquares\\\":[[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":3}},{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":4}}]],\\\"myStartSquare\\\":{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},\\\"myCurrentGoals\\\":[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}}],\\\"myFinishedGoals\\\":[],\\\"myRoute\\\":[{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}}],\\\"widthMaze\\\":5,\\\"heightMaze\\\":5}\"}\r\n";
			theState = gson.fromJson(json, State.class);
		}

		// 7.a. Legal move Left
		@Test
		void testLegalMoveLeft() {
			int x = 1;
			int y = 1;
			final boolean expected = true;
			final String errMsg = "the Avatar should move Left";

			Position pos = new Position(1, 1);
			try {
				theState.moveAvatar(pos);
			} catch (Exception e) {
				e.printStackTrace();
			}
			final boolean actual = theState.myAvatar.myPosition.X == x && theState.myAvatar.myPosition.Y == y;

			assertEquals(expected, actual, errMsg);
		}

		// 7.b. Illegal move Left
		@Test
		void testIllegalMoveLeft() {
			final String errMsg = "the Avatar should not move Left and return an Exception";
			Position pos = new Position(0, 1);

			assertThrows(Exception.class, () -> theState.moveAvatar(pos), errMsg);
		}
	}

	// 8. Avatar can move right if it is a legal move
	@Nested
	class testMoveRight {
		@BeforeEach
		void beforeEach() {
			Gson gson = new Gson();
			String json = "{\"myAvatar\":{\"myName\":\"Player\",\"myDirection\":\"UP\",\"myPosition\":{\"X\":0,\"Y\":3}},\"mySaves\":[\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}};;{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}};;{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"RIGHT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"DOWN\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"RIGHT\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"LEFT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}}\"],\"myMaze\":{\"mySquares\":[[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":0,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":0,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":0,\"Y\":2}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":0,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":1,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":3}},{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":2,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":2,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":2,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":3,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":3,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":4,\"Y\":4}}]],\"myStartSquare\":{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},\"myCurrentGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}}],\"myFinishedGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}}],\"myRoute\":[{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}}],\"widthMaze\":5,\"heightMaze\":5},\"isFinished\":false,\"mazeOriginal\":\"{\\\"mySquares\\\":[[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":3}},{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":4}}]],\\\"myStartSquare\\\":{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},\\\"myCurrentGoals\\\":[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}}],\\\"myFinishedGoals\\\":[],\\\"myRoute\\\":[{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}}],\\\"widthMaze\\\":5,\\\"heightMaze\\\":5}\"}\r\n";
			theState = gson.fromJson(json, State.class);
		}

		// 8.a. Legal move Right
		@Test
		void testLegalMoveRight() {
			int x = 4;
			int y = 3;
			final boolean expected = true;
			final String errMsg = "the Avatar should move Right";

			Position pos = new Position(4, 3);
			try {
				theState.moveAvatar(pos);
			} catch (Exception e) {
				e.printStackTrace();
			}
			final boolean actual = theState.myAvatar.myPosition.X == x && theState.myAvatar.myPosition.Y == y;

			assertEquals(expected, actual, errMsg);
		}

		// 8.b. Illegal move Right
		@Test
		void testIllegalMoveRight() {
			final String errMsg = "the Avatar should not move Right and return an Exception";
			Position pos = new Position(0, 3);

			assertThrows(Exception.class, () -> theState.moveAvatar(pos), errMsg);
		}
	}

	// 9. Replace a goal to a blank square after the avatar left it
	@Nested
	class testChangeToBlankSquare {
		@BeforeEach
		void beforeEach() {
			Gson gson = new Gson();
			String json = "{\"myAvatar\":{\"myName\":\"Player\",\"myDirection\":\"UP\",\"myPosition\":{\"X\":1,\"Y\":0}},\"mySaves\":[\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}};;{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}};;{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}}\"],\"myMaze\":{\"mySquares\":[[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":0,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":0,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":0,\"Y\":2}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":0,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":1,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":3}},{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":2,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":2,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":2,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":3,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":3,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":4,\"Y\":4}}]],\"myStartSquare\":{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},\"myCurrentGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}}],\"myFinishedGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}}],\"myRoute\":[{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}}],\"widthMaze\":5,\"heightMaze\":5},\"isFinished\":false,\"mazeOriginal\":\"{\\\"mySquares\\\":[[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":3}},{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":4}}]],\\\"myStartSquare\\\":{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},\\\"myCurrentGoals\\\":[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}}],\\\"myFinishedGoals\\\":[],\\\"myRoute\\\":[{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}}],\\\"widthMaze\\\":5,\\\"heightMaze\\\":5}\"}\r\n";
			theState = gson.fromJson(json, State.class);
		}

		// 9.a. Test the colour
		@Test
		void testColour() {
			final String errMsg = "Colour should be none";
			final Colour expected = Colour.NONE;

			try {
				theState.moveAvatar(new Position(2, 0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			final Square theSquare = theState.myMaze.mySquares[1][0];
			final Colour actual = theSquare.myColour;

			assertEquals(expected, actual, errMsg);
		}

		// 9.b. Test the symbol
		@Test
		void testSymbol() {
			final String errMsg = "Symbol should be none";
			final Symbol expected = Symbol.NONE;

			try {
				theState.moveAvatar(new Position(2, 0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			final Square theSquare = theState.myMaze.mySquares[1][0];
			final Symbol actual = theSquare.mySymbol;

			assertEquals(expected, actual, errMsg);
		}

		// 9.c Test the position
		@Test
		void testPosition() {
			final String errMsg = "Position should be the same";
			final int x = 0;
			final int y = 0;
			final boolean expected = true;

			try {
				theState.moveAvatar(new Position(0, 0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			final Square theSquare = theState.myMaze.mySquares[0][0];
			final boolean actual = theSquare.myPosition.X == x && theSquare.myPosition.Y == y;

			assertEquals(expected, actual, errMsg);
		}
	}

	// 10. The game can check whether a move is on the same X or Y axis
	@Nested
	class testIsOnTheSameAxis {
		@BeforeEach
		void beforeEach() {
			Gson gson = new Gson();
			String json = "{\"myAvatar\":{\"myName\":\"Player\",\"myDirection\":\"LEFT\",\"myPosition\":{\"X\":2,\"Y\":1}},\"mySaves\":[\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}};;{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}};;{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"RIGHT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"DOWN\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"RIGHT\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"LEFT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}}\"],\"myMaze\":{\"mySquares\":[[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":0,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":0,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":0,\"Y\":2}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":0,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":1,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":3}},{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":2,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":2,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":2,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":3,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":3,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":4,\"Y\":4}}]],\"myStartSquare\":{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},\"myCurrentGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}}],\"myFinishedGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}}],\"myRoute\":[{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}}],\"widthMaze\":5,\"heightMaze\":5},\"isFinished\":false,\"mazeOriginal\":\"{\\\"mySquares\\\":[[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":3}},{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":4}}]],\\\"myStartSquare\\\":{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},\\\"myCurrentGoals\\\":[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}}],\\\"myFinishedGoals\\\":[],\\\"myRoute\\\":[{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}}],\\\"widthMaze\\\":5,\\\"heightMaze\\\":5}\"}\r\n";
			theState = gson.fromJson(json, State.class);
		}

		// 10.a. Is the same X, different Y
		@Test
		void testTheSameXDifferentY() {
			final String errMsg = "Avatar should move horizontally to the new square";
			final int x = 2;
			final int y = 3;
			final boolean expected = true;

			try {
				theState.moveAvatar(new Position(2, 3));
			} catch (Exception e) {
				e.printStackTrace();
			}
			final boolean actual = theState.myAvatar.myPosition.X == x && theState.myAvatar.myPosition.Y == y;

			assertEquals(expected, actual, errMsg);
		}

		// 10.b. Is the same Y, different X
		@Test
		void testTheSameYDifferentX() {
			final String errMsg = "Avatar should move vertically to the new square";
			final int x = 1;
			final int y = 1;
			final boolean expected = true;

			try {
				theState.moveAvatar(new Position(1, 1));
			} catch (Exception e) {
				e.printStackTrace();
			}
			final boolean actual = theState.myAvatar.myPosition.X == x && theState.myAvatar.myPosition.Y == y;

			assertEquals(expected, actual, errMsg);
		}

		// 10.c. Different X and different Y
		@Test
		void testDifferentXDifferentY() {
			final String errMsg = "Avatar should move vertically to the new square";

			assertThrows(NotTheSameAxisException.class, () -> {
				theState.moveAvatar(new Position(0, 2));
			}, errMsg);
		}
	}

	// 11. The game can check whether the avatar is moving backward
	@Nested
	class testIsMoveBackward
	{
		@BeforeEach
		void beforeEach() {
			Gson gson = new Gson();
			String json = "{\"myAvatar\":{\"myName\":\"Player\",\"myDirection\":\"RIGHT\",\"myPosition\":{\"X\":2,\"Y\":1}},\"mySaves\":[\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}};;{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}};;{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"RIGHT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"DOWN\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"RIGHT\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"LEFT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}}\"],\"myMaze\":{\"mySquares\":[[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":0,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":0,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":0,\"Y\":2}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":0,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":1,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":3}},{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":2,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":2,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":2,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":3,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":3,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":4,\"Y\":4}}]],\"myStartSquare\":{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},\"myCurrentGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}}],\"myFinishedGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}}],\"myRoute\":[{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}}],\"widthMaze\":5,\"heightMaze\":5},\"isFinished\":false,\"mazeOriginal\":\"{\\\"mySquares\\\":[[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":3}},{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":4}}]],\\\"myStartSquare\\\":{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},\\\"myCurrentGoals\\\":[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}}],\\\"myFinishedGoals\\\":[],\\\"myRoute\\\":[{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}}],\\\"widthMaze\\\":5,\\\"heightMaze\\\":5}\"}\r\n";
			theState = gson.fromJson(json, State.class);
		}

		// 12.a. Is moving back
		@Test
		void testMovingBack() {
			final String errMsg = "Avatar should not move back";

			assertThrows(MoveBackwardExecption.class, () -> {
				theState.moveAvatar(new Position(1, 1));
			}, errMsg);
		}

	}

	// 12. The game can check whether the avatar is moving to the same square
	@Nested
	class testIsTheSameSquare {
		@BeforeEach
		void beforeEach() {
			Gson gson = new Gson();
			String json = "{\"myAvatar\":{\"myName\":\"Player\",\"myDirection\":\"UP\",\"myPosition\":{\"X\":2,\"Y\":1}},\"mySaves\":[\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}};;{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}};;{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"RIGHT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"DOWN\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"RIGHT\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"LEFT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}};;{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}}\"],\"myMaze\":{\"mySquares\":[[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":0,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":0,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":0,\"Y\":2}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":0,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":1,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":3}},{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":2,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":2,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":2,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":3,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":3,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":4,\"Y\":4}}]],\"myStartSquare\":{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},\"myCurrentGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}}],\"myFinishedGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}}],\"myRoute\":[{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}}],\"widthMaze\":5,\"heightMaze\":5},\"isFinished\":false,\"mazeOriginal\":\"{\\\"mySquares\\\":[[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":3}},{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":4}}]],\\\"myStartSquare\\\":{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},\\\"myCurrentGoals\\\":[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}}],\\\"myFinishedGoals\\\":[],\\\"myRoute\\\":[{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}}],\\\"widthMaze\\\":5,\\\"heightMaze\\\":5}\"}\r\n";
			theState = gson.fromJson(json, State.class);
		}

		// 12.a. Is move to different square
		@Test
		void testDifferentSquare() {
			final String errMsg = "Avatar should move to the new square";
			final int x = 3;
			final int y = 1;
			final boolean expected = true;

			try {
				theState.moveAvatar(new Position(3, 1));
			} catch (Exception e) {
				e.printStackTrace();
			}
			final boolean actual = theState.myAvatar.myPosition.X == x && theState.myAvatar.myPosition.Y == y;

			assertEquals(expected, actual, errMsg);
		}

		// 12.b. Is move to the same square
		@Test
		void testTheSameSquare() {
			final String errMsg = "Avatar should not move to the new square";

			assertThrows(MoveToSameSquareException.class, () -> {
				theState.moveAvatar(new Position(2, 1));

			}, errMsg);
		}
	}

	// Test 13. and test 14 are in SquareTest.java
	// 13. The game can check whether two squares have the same colour
	// 14. The game can check whether two squares have the same symbol

	// 15. Count the remaining goals
	@Nested
	class testRemainingGoals {
		@BeforeEach
		void beforeEach() {
			Gson gson = new Gson();
			String json = "{\"myAvatar\":{\"myName\":\"Player\",\"myDirection\":\"UP\",\"myPosition\":{\"X\":1,\"Y\":4}},\"mySaves\":[\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}};;{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}\"],\"myMaze\":{\"mySquares\":[[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":0,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":0,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":0,\"Y\":2}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":0,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":1,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":3}},{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":2,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":2,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":2,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":3,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":3,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":4,\"Y\":4}}]],\"myStartSquare\":{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},\"myCurrentGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}}],\"myFinishedGoals\":[],\"myRoute\":[{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}}],\"widthMaze\":5,\"heightMaze\":5},\"isFinished\":false,\"mazeOriginal\":\"{\\\"mySquares\\\":[[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":3}},{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":4}}]],\\\"myStartSquare\\\":{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},\\\"myCurrentGoals\\\":[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}}],\\\"myFinishedGoals\\\":[],\\\"myRoute\\\":[{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}}],\\\"widthMaze\\\":5,\\\"heightMaze\\\":5}\"}";

			theState = gson.fromJson(json, State.class);
		}

		// 15.a. Test the original goal amount
		@Test
		void testOriginalGoalAmount() {
			final String errMsg = "Should return the amount of remaining goals";
			final int expected = 2;

			final int actual = theState.myMaze.countRemainingGoals();

			assertEquals(expected, actual, errMsg);
		}

		// 15.b. Test the change goal amount
		@Test
		void testChangedGoalAmount() {
			final String errMsg = "Should return the changed amount of remaining goals";
			final int expected = 1;

			try {
				theState.moveAvatar(new Position(1, 0));
			} catch (Exception e) {
				e.printStackTrace();
			}
			final int actual = theState.myMaze.countRemainingGoals();

			assertEquals(expected, actual, errMsg);
		}
	}

	// 16. The game can record the Avatar's’smoves
	@Nested
	class testRecordMoves {
		@BeforeEach
		void beforeEach() {
			Gson gson = new Gson();
			String json = "{\"myAvatar\":{\"myName\":\"Player\",\"myDirection\":\"UP\",\"myPosition\":{\"X\":1,\"Y\":4}},\"mySaves\":[\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}};;{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}\"],\"myMaze\":{\"mySquares\":[[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":0,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":0,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":0,\"Y\":2}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":0,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":1,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":3}},{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":2,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":2,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":2,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":2,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":3,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":3,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":4,\"Y\":4}}]],\"myStartSquare\":{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},\"myCurrentGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}}],\"myFinishedGoals\":[],\"myRoute\":[{\"isStart\":true,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":4}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}}],\"widthMaze\":5,\"heightMaze\":5},\"isFinished\":false,\"mazeOriginal\":\"{\\\"mySquares\\\":[[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":3}},{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":4}}]],\\\"myStartSquare\\\":{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},\\\"myCurrentGoals\\\":[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}}],\\\"myFinishedGoals\\\":[],\\\"myRoute\\\":[{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}}],\\\"widthMaze\\\":5,\\\"heightMaze\\\":5}\"}";

			theState = gson.fromJson(json, State.class);
		}

		// 16.a. Test the original record size
		@Test
		void testOriginalRecoredSize() {
			final String errMsg = "Should return the amount of the saves";
			final int expected = 1;

			final int actual = theState.mySaves.size();

			assertEquals(expected, actual, errMsg);
		}

		// 16.b. Test the changed record size
		@Test
		void testChangedRecoredSize() {
			final String errMsg = "Should return the amount of the saves";
			final int expected = 5;
			final Position[] arrayPos = new Position[] { new Position(1, 0), new Position(4, 0), new Position(4, 2),
					new Position(4, 3) };

			for (Position pos : arrayPos) {
				try {
					theState.moveAvatar(pos);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			final int actual = theState.mySaves.size();

			assertEquals(expected, actual, errMsg);
		}
	}

	// 17. The game can undo the Avatar's move
	@Nested
	class testUndoMove {
		@BeforeEach
		void beforeEach() {
			Gson gson = new Gson();
			String json = "{\"myAvatar\":{\"myName\":\"Player\",\"myDirection\":\"UP\",\"myPosition\":{\"X\":1,\"Y\":1}},\"mySaves\":[\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}};;{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":3}};;{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":3}}\",\"{\\\"myName\\\":\\\"Player\\\",\\\"myDirection\\\":\\\"UP\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":1}};;{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":1}}\"],\"myMaze\":{\"mySquares\":[[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":0,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"PURPLE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":0,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":0,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":0,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":0}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":1,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":1,\"Y\":3}},{\"isStart\":true,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"YELLOW\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":2,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":2,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":2,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"DIAMOND\",\"myPosition\":{\"X\":2,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":2,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"RED\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":3,\"Y\":0}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":3,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"THUNDERBOLT\",\"myPosition\":{\"X\":3,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":3,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":3,\"Y\":4}}],[{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":4,\"Y\":0}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"GREEN\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":2}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"CROSS\",\"myPosition\":{\"X\":4,\"Y\":3}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"NONE\",\"mySymbol\":\"NONE\",\"myPosition\":{\"X\":4,\"Y\":4}}]],\"myStartSquare\":{\"isStart\":true,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":4}},\"myCurrentGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"GREEN\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":1}}],\"myFinishedGoals\":[{\"isStart\":false,\"isGoal\":true,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":3}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":1}}],\"myRoute\":[{\"isStart\":true,\"isGoal\":false,\"myColour\":\"BLUE\",\"mySymbol\":\"STAR\",\"myPosition\":{\"X\":1,\"Y\":4}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"BLUE\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":3}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"YELLOW\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":1,\"Y\":1}},{\"isStart\":false,\"isGoal\":false,\"myColour\":\"GREEN\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":3,\"Y\":1}},{\"isStart\":false,\"isGoal\":true,\"myColour\":\"GREEN\",\"mySymbol\":\"FLOWER\",\"myPosition\":{\"X\":4,\"Y\":1}}],\"widthMaze\":5,\"heightMaze\":5},\"isFinished\":false,\"mazeOriginal\":\"{\\\"mySquares\\\":[[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"PURPLE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":0,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":3}},{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"DIAMOND\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":2,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"RED\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"THUNDERBOLT\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":4}}],[{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":0}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":2}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"CROSS\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"NONE\\\",\\\"mySymbol\\\":\\\"NONE\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":4}}]],\\\"myStartSquare\\\":{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},\\\"myCurrentGoals\\\":[{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":1}}],\\\"myFinishedGoals\\\":[],\\\"myRoute\\\":[{\\\"isStart\\\":true,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"STAR\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":4}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"BLUE\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":3}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"YELLOW\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":1,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":false,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":3,\\\"Y\\\":1}},{\\\"isStart\\\":false,\\\"isGoal\\\":true,\\\"myColour\\\":\\\"GREEN\\\",\\\"mySymbol\\\":\\\"FLOWER\\\",\\\"myPosition\\\":{\\\"X\\\":4,\\\"Y\\\":1}}],\\\"widthMaze\\\":5,\\\"heightMaze\\\":5}\"}\r\n";
			theState = gson.fromJson(json, State.class);
		}

		// 17.a. Check the position of the avatar
		@Test
		void testAvatarPosition() {
			final String errMsg = "The position of the avatar should be rollbacked";
			final boolean expected = true;

			try {
				theState.undoLastMove();
			} catch (NoSaveException e) {
				e.printStackTrace();
			}
			final boolean actual = theState.myAvatar.myPosition.X == 1 && theState.myAvatar.myPosition.Y == 3;

			assertEquals(expected, actual, errMsg);

		}

		// 17.b. Check whether remaining goal amount is rollbacked
		@Test
		void testAmountRemainingGoal() {
			final String errMsg = "The amount of goals should be rollbacked";
			final int expected = 2;

			try {
				theState.undoLastMove();
			} catch (NoSaveException e) {
				e.printStackTrace();
			}
			final int actual = theState.myMaze.countRemainingGoals();

			assertEquals(expected, actual, errMsg);
		}

		// 17.c. Check if a blank goal square is rollbacked to the previous status
		@Test
		void testStatusSquare() {
			final String errMsg = "The colour and symbol of the goal square should be rollbacked";
			final boolean expected = true;

			try {
				theState.undoLastMove();
			} catch (NoSaveException e) {
				e.printStackTrace();
			}
			Position pos = theState.myAvatar.myPosition;
			Square square = theState.myMaze.mySquares[pos.X][pos.Y];
			final boolean actual = square.myColour == Colour.BLUE && square.mySymbol == Symbol.FLOWER;
			assertEquals(expected, actual, errMsg);
		}
	}

	// 18. get a solution of the maze
	@Nested
	class testMazeSolution {
		// 18.a. Test the correctness of the solution
		@BeforeEach
		void beforeEach() {
//			theState = new State("Player", 5, 5, 1, 4, 3, 6, Direction.UP);
//			showMaze();
		}

		@Test
		void testSolution() {
			final String errMsg = "Should have a correct maze solution";
			final boolean expected = true;

			for (int i = 0; i < 100; i++) {
				theState = new State("Player", 5, 5, 1, 4, 3, 6, Direction.UP);
				ArrayList<Square> solution = theState.getMazeRoute();
				for (int step = 1; step < solution.size(); step++) {
					Position nextStep = solution.get(step).myPosition;
					try {
						theState.moveAvatar(nextStep);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				final boolean actual = theState.isFinished;

				assertEquals(expected, actual, errMsg);
			}
		}
	}

	// 20. and 21.
	@Nested
	class testSaveAndLoad {
		int SIZE = 10;
		String[] arrayString = new String[SIZE];
		Maze[] arrayMaze = new Maze[SIZE];

		@BeforeEach
		void beforeEach() {
			Gson gson = new Gson();
			for (int i = 0; i < SIZE; i++) {
				Position position = new Position(i, i);
				Direction direction = Direction.UP;
				Maze aMaze = new Maze(10, 10, position, 2, 6, direction);

				arrayMaze[i] = aMaze;
				String jsonMaze = gson.toJson(aMaze);
				arrayString[i] = jsonMaze;
			}
		}

//			20.	Save a maze to a string
//			20.a.	Test the string
		@Test
		void testSaveMaze() {
			final String errMsg = "Should return a correct stringified maze";

			for (int i = 0; i < SIZE; ++i) {
				final String expected = this.arrayString[i];

				final Maze aMaze = this.arrayMaze[i];
				final String actual = aMaze.saveMaze();

				assertEquals(expected, actual, errMsg);
			}
		}

//			21.	Load a maze from a string
//			21.a.	Test the maze content
		@Test
		void testLoadMaze() {
			final String errMsg = "Should return a correct Maze instance";

			for (int i = 0; i < SIZE; ++i) {
				Maze mazeOriginal = this.arrayMaze[i];

				final String json = this.arrayString[i];
				theState.loadMaze(json);
				final Maze mazeLoaded = theState.myMaze;
				final boolean expected = true;

				boolean hasTheSameStartSquare = this.isTheSameSquare(mazeOriginal.myStartSquare,
						mazeLoaded.myStartSquare);
				boolean hasTheSameMySquares = hasTheSameMySquares(mazeOriginal, mazeLoaded);

				boolean hasTheSameMyCurrentGoals = isTheSameArraySquares(mazeOriginal.myCurrentGoals,
						mazeLoaded.myCurrentGoals);
				boolean hasTheSameFinishedGoals = isTheSameArraySquares(mazeOriginal.myFinishedGoals,
						mazeLoaded.myFinishedGoals);
				boolean hasTheSameMyRoute = isTheSameArraySquares(mazeOriginal.myRoute, mazeLoaded.myRoute);

				final boolean actual = hasTheSameStartSquare && hasTheSameMySquares && hasTheSameMyCurrentGoals
						&& hasTheSameFinishedGoals && hasTheSameMyRoute;

				assertEquals(expected, actual, errMsg);
			}

		}

		private boolean isTheSameArraySquares(ArrayList<Square> array1, ArrayList<Square> array2) {

			boolean result = true;

			for (int i = 0; i < array1.size(); i++) {
				if (!isTheSameSquare(array1.get(i), array2.get(i))) {
					result = false;
					break;
				}

			}
			return result;
		}

		private boolean isTheSameSquare(Square square1, Square square2) {
			boolean result = false;

			if ((square1.isStart == square2.isStart) && (square1.isGoal == square2.isGoal)
					&& (square1.isStart == square2.isStart) && (square1.myColour == square2.myColour)
					&& (square1.mySymbol == square2.mySymbol) && (square1.myPosition.X == square2.myPosition.X)
					&& (square1.myPosition.Y == square2.myPosition.Y)) {
				result = true;
			}

			return result;
		}

		private boolean hasTheSameMySquares(Maze mazeOriginal, Maze mazeLoaded) {
			boolean result = true;
			Square[][] squaresOriginal = mazeOriginal.mySquares;
			Square[][] squaresLoaded = mazeLoaded.mySquares;

			for (int x = 0; x < squaresOriginal.length; x++) {
				for (int y = 0; y < squaresOriginal[x].length; y++) {
					if (!isTheSameSquare(squaresOriginal[x][y], squaresLoaded[x][y])) {
						result = false;
						break;
					}
				}
			}
			return result;
		}

	}

	// 21. Player can restart the game
	@Nested
	class testRestartGame {
		State newState;

		@BeforeEach
		void beforeEach() {
			theState = new State("Marcus", 5, 5, 1, 4, 2, 6, Direction.UP);
			newState = theState.restartGame();
		}

		// 22.a. Test is the initialised avatar
		@Test
		void testIsTheInitialisedAvatar() {
			final String errMsg = "Should have the same avatar";
			Avatar avatarOriginal = theState.myAvatar;
			Avatar avatarNew = newState.myAvatar;
			final boolean expected = true;

			// Is the same position
			final boolean isTheSamePosition = avatarOriginal.myPosition.X == avatarNew.myPosition.X
					&& avatarOriginal.myPosition.Y == avatarNew.myPosition.Y;
			// Is the same direction
			final boolean isTheSameDirection = avatarOriginal.myDirection.equals(avatarNew.myDirection);
			final boolean actual = isTheSamePosition && isTheSameDirection;

			assertEquals(expected, actual, errMsg);
		}

		// 22.b. Test is the initialised maze
		@Test
		void testIsTheInitialisedMaze() {
			final String errMsg = "Should have the same Maze";
			Maze mazeOriginal = theState.myMaze;
			Maze mazeNew = newState.myMaze;
			final boolean expected = true;

			final boolean hasTheSameStartSquare = isTheSameSquare(mazeOriginal.myStartSquare, mazeNew.myStartSquare);
			boolean hasTheSameMySquares = hasTheSameMySquares(mazeOriginal, mazeNew);

			final boolean hasTheSameMyCurrentGoals = isTheSameArraySquares(mazeOriginal.myCurrentGoals,
					mazeNew.myCurrentGoals);
			final boolean hasTheSameFinishedGoals = isTheSameArraySquares(mazeOriginal.myFinishedGoals,
					mazeNew.myFinishedGoals);
			final boolean hasTheSameMyRoute = isTheSameArraySquares(mazeOriginal.myRoute, mazeNew.myRoute);

			final boolean actual = hasTheSameStartSquare && hasTheSameMySquares && hasTheSameMyCurrentGoals
					&& hasTheSameFinishedGoals && hasTheSameMyRoute;

			assertEquals(expected, actual, errMsg);
		}

	}

	/////// supporting methods ////
	protected <T> void say(T msg) {
		System.out.println(msg);
	}

	protected boolean isTheSameArraySquares(ArrayList<Square> array1, ArrayList<Square> array2) {

		boolean result = true;

		for (int i = 0; i < array1.size(); i++) {
			if (!isTheSameSquare(array1.get(i), array2.get(i))) {
				result = false;
				break;
			}

		}
		return result;
	}

	protected boolean isTheSameSquare(Square square1, Square square2) {
		boolean result = false;

		// System.out.println(square1 + " " + square2);

		if ((square1.isStart == square2.isStart) && (square1.isGoal == square2.isGoal)
				&& (square1.isStart == square2.isStart) && (square1.myColour == square2.myColour)
				&& (square1.mySymbol == square2.mySymbol) && (square1.myPosition.X == square2.myPosition.X)
				&& (square1.myPosition.Y == square2.myPosition.Y)) {
			result = true;
		}

		return result;
	}

	protected boolean hasTheSameMySquares(Maze mazeOriginal, Maze mazeLoaded) {
		boolean result = true;
		Square[][] squaresOriginal = mazeOriginal.mySquares;
		Square[][] squaresLoaded = mazeLoaded.mySquares;

		for (int x = 0; x < squaresOriginal.length; x++) {
			for (int y = 0; y < squaresOriginal[x].length; y++) {
				if (!isTheSameSquare(squaresOriginal[x][y], squaresLoaded[x][y])) {
					result = false;
					break;
				}
			}
		}
		return result;
	}

	protected void showMaze() {
		String output = "";
		for (int y = 0; y < theState.myMaze.heightMaze; y++) {
			for (int x = 0; x < theState.myMaze.widthMaze; x++) {
				Square square = theState.myMaze.mySquares[x][y];
				if (square.isSamePosition(theState.myAvatar.myPosition)) {
					output += "*";
				}
				output += square.toString() + " ";
			}
			output += "\r\n";
		}
		say(output);
	}

	protected void showRoute() {
		ArrayList<Square> theRoute = theState.getMazeRoute();
		int counter = 0;
		for (Square square : theRoute) {
			++counter;
			String message = counter + "- x:" + square.myPosition.X + " y:" + square.myPosition.Y;
			message += " colour: " + square.myColour + " symbol:" + square.mySymbol;
			message += " s: " + square.isStart + " g:" + square.isGoal;
			say(message);
		}
	}
}
