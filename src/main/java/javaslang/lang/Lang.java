package javaslang.lang;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * General Java languange extensions. See also {@link java.util.Objects}.
 */
public final class Lang {

	private Lang() {
		throw new AssertionError(Lang.class.getName() + " cannot be instantiated.");
	}

	/**
	 * Shortcut for <code>System.out.print(String.format(format, args))</code>.
	 * 
	 * @param format
	 * @param args
	 * 
	 * @see String#format(String, Object...)
	 */
	public static void print(String format, Object... args) {
		final String s = String.format(format, args);
		System.out.print(s);
	}

	/**
	 * Shortcut for <code>System.out.print(String.format(format, args))</code>.
	 * 
	 * @param format
	 * @param args
	 * 
	 * @see String#format(String, Object...)
	 */
	public static void println(String format, Object... args) {
		final String s = String.format(format, args);
		System.out.println(s);
	}

	/**
	 * Runtime check which will throw an IllegalStateException containing the given message if the condition is false.
	 * 
	 * @param condition A boolean
	 * @param message A message An error message.
	 * @throws IllegalStateException If condition is false, contains the message.
	 */
	public static void require(boolean condition, String message) throws IllegalStateException {
		if (!condition) {
			throw new IllegalStateException(message);
		}
	}

	/**
	 * Runtime check which will throw an IllegalStateException containing the given message if the condition is false.
	 * The message is computed only if the condition is false.
	 * 
	 * @param condition A boolean
	 * @param messageSupplier An error message, computed lazily.
	 * @throws IllegalStateException If condition is false, contains the message.
	 */
	public static void require(boolean condition, Supplier<String> messageSupplier) throws IllegalStateException {
		if (!condition) {
			throw new IllegalStateException(messageSupplier.get());
		}
	}

	/**
	 * Builder pattern.
	 * 
	 * @param obj
	 * @param f
	 * @return
	 */
	public static <T, U> U with(T obj, Function<T, U> f) {
		return f.apply(obj);
	}

}