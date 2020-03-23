package dev.darrenmatthews.translations.smartcontracts.ledgerApi;

import org.json.JSONObject;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Essentially the MongoDocument of the Ledger. I.e. defines what all states in
 * the ledger must contain. A unique key, and provides methods to generate key
 * values, and provides a way to serialise the state objects
 */
public class LedgerState {

	protected String uniqueKey;

	public LedgerState() {

	}

	public String[] getSplitUniqueKey() {
		return LedgerState.splitUniqueKey(this.uniqueKey);
	}

	
	// has a key:value size of (250 bytes : 20 MB)
	public static String makeUniqueKey(String[] keyParts) {
		return String.join(":", keyParts);
	}

	public static String[] splitUniqueKey(String uniqueKey) {
		return uniqueKey.split(":");
	}

	// Could be externalised as a centralised way of serialising an object, i.e.
	// with gson instead
	public static byte[] serialize(Object object) {
		String jsonStr = new JSONObject(object).toString();
		return jsonStr.getBytes(UTF_8);
	}
}
