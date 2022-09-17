package tp1.p1.control;

/**
 * Represents the allowed levels in the game.
 *
 */
public enum Level {

	// TODO fill your code

	private int numberOfZombies;
	
	private double zombieFrequency;

	private Level(int numberOfZombies, double zombieFrequency) {
		this.numberOfZombies = numberOfZombies;
		this.zombieFrequency = zombieFrequency;
	}

	// TODO fill your code

	/**
	 * Parse an string and return any matching level
	 * 
	 * @param inputString string to parse
	 * @return the parsed {@link Level} or <code>null</code> if none match.
	 */
	public static Level valueOfIgnoreCase(String inputString) {
		for (Level level : Level.values()) {
			if (level.name().equalsIgnoreCase(inputString)) {
				return level;
			}
		}
		return null;
	}

	/**
	 * Returns a string representation of all the levels joined with <code>separator</code>
	 * 
	 * @param separator String used as separator
	 * 
	 * @return the string resulted from joining all levels using <code>separator</code>
	 */
	public static String all(String separator) {
		StringBuilder buffer = new StringBuilder();
		int levelCount = 0;
		for (Level level : Level.values()) {
			if (levelCount > 0) {
				buffer.append(separator);
			}
			buffer.append(level.name());
			levelCount++;
		}
		return buffer.toString();
	}
}
