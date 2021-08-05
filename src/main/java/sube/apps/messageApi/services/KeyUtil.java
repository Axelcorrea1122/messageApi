package sube.apps.messageApi.services;

public class KeyUtil {

		private KeyUtil() {
		}

		public static boolean validateKey(String key) {
			return isValidKey(key);
		}

		private static boolean isValidKey(String key) {
			if (key != null && key != "") {
				return true;
			}
			return false;
		}
	}
