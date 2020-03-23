package dev.darrenmatthews.translations.smartcontracts;

import org.hyperledger.fabric.contract.Context;

import dev.darrenmatthews.translations.smartcontracts.ledgerApi.LedgerStateList;

public class TranslationAssetList {

	private LedgerStateList stateList;

	// instantiate by getting the current world leger list?
	public TranslationAssetList(Context ctx) {
		this.stateList = LedgerStateList.getStateList(ctx, TranslationAssetList.class.getSimpleName(),
				TranslationAsset::deserialize);
	}
	
	public TranslationAssetList addTranslationAsset(TranslationAsset asset) {
		stateList.addState(asset);
		return this;
	}

	public TranslationAsset getTranslation(String assetKey) {
		return (TranslationAsset) this.stateList.getState(assetKey);
	}

	public TranslationAssetList updateTranslationAsset(TranslationAsset translation) {
		this.stateList.updateState(translation);
		return this;
	}
}
