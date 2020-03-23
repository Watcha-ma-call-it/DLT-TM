package dev.darrenmatthews.translations.smartcontracts;

import org.hyperledger.fabric.contract.annotation.Property;
import org.json.JSONObject;

import dev.darrenmatthews.translations.smartcontracts.ledgerApi.LedgerState;
import static java.nio.charset.StandardCharsets.UTF_8;

public class TranslationAsset extends LedgerState {

	public final static String NEW = "NEW";
	public final static String TRANSLATED = "TRANSLATED";

	@Property()
	private String translationPhase = "";

	@Property()
	private String sourceLanguage;

	@Property()
	private String targetLanguage;

	@Property()
	private String sourceString;

	@Property()
	private String targetString;

	@Property()
	private String owner;

	public TranslationAsset() {
		super();
	}

	public TranslationAsset setOwner(String owner) {
		this.owner = owner;
		return this;
	}

	public TranslationAsset setTargetLanguage(String trgLang) {
		this.targetLanguage = trgLang;
		return this;
	}

	public TranslationAsset setSourceString(String srcString) {
		this.sourceString = srcString;
		return this;
	}

	public TranslationAsset setTargetString(String trgString) {
		this.targetString = trgString;
		return this;
	}

	public TranslationAsset setSourceLanguage(String srcLang) {
		this.sourceLanguage = srcLang;
		return this;
	}

	public TranslationAsset setTranslationPhase(String trnPhase) {
		this.translationPhase = trnPhase;
		return this;
	}

	// Factory method to create an object representation
	public static TranslationAsset createInstance(String srcLang, String trgLang, String srcString, String trgString,
			String trnPhase, String owner) {
		return new TranslationAsset().setSourceLanguage(srcLang).setTargetLanguage(trgLang).setSourceString(srcString)
				.setTargetString(trgString).setTranslationPhase(trnPhase).setOwner(owner).setUniqueKey();
	}

	public TranslationAsset setUniqueKey() {
		this.uniqueKey = LedgerState.makeUniqueKey(new String[] {this.sourceLanguage, this.targetLanguage, this.sourceString});
		return this;
	}

	// Method to deserialise the json object to the asset
	public static TranslationAsset deserialize(byte[] data) {
		JSONObject json = new JSONObject(new String(data, UTF_8));

		String translationPhase = json.getString("translationPhase");
		String sourceLanguage = json.getString("sourceLanguage");
		String targetLanguage = json.getString("targetLanguage");
		String sourceString = json.getString("sourceString");
		String targetString = json.getString("targetString");
		String owner = json.getString("owner");

		return createInstance(sourceLanguage, targetLanguage, sourceString, targetString, translationPhase, owner);
	}

	public static byte[] serialize(TranslationAsset asset) {
		return LedgerState.serialize(asset);
	}

	public TranslationAsset setNewString() {
		this.translationPhase = NEW;
		return this;
	}

	public TranslationAsset setTranslation(String trgString) {
		this.targetString = trgString;
		return this;
	}

	public TranslationAsset setTranslated() {
		this.translationPhase = TRANSLATED;
		return this;
	}
}
