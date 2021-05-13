package sube.apps.messageApi.services;

import java.util.regex.Pattern;

	public class KeyUtil {
		private static final String KEY_REGEX = "[a-zA-Z0-9_-]+";

		private KeyUtil() {
		}

		public static boolean validateKey(String key) {
			return isValidKey(key);
		}

		private static boolean isValidKey(String key) {
			if (key != null && key != "") {
				return Pattern.matches(KEY_REGEX, key);
			}
			return false;
		}
	}
