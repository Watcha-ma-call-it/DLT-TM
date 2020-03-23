package dev.darrenmatthews.translations.smartcontracts;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.shim.ChaincodeStub;

public class TranslationAssetContext extends Context {
	
	public TranslationAssetList translationAssetList;

	public TranslationAssetContext(ChaincodeStub stub) {
		super(stub);
		this.translationAssetList = new TranslationAssetList(this);
	}

}
