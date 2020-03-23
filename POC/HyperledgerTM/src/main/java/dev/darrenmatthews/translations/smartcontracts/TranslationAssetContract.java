package dev.darrenmatthews.translations.smartcontracts;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Info;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.shim.ChaincodeStub;

import dev.darrenmatthews.translations.smartcontracts.ledgerApi.LedgerState;

//This is a smart contract definition for the asset. I.e the functions that this document can do. 
//Invoking these functions wont update the world state unless the world state is update (and accepted transaction) 
//in the overall translation asset list

@Contract(name = "org.darrennetwork.translationasset", info = @Info(title = "My Translation Asset Contract"))
@Default
public class TranslationAssetContract implements ContractInterface {
	public TranslationAssetContract() {
	}

	@Override
	public Context createContext(ChaincodeStub stub) {
		return new TranslationAssetContext(stub);
	}

	@Transaction
	public TranslationAsset create(TranslationAssetContext ctx, String srcLang, String trgLang, String srcString,
			String owner) {
		System.out.println(ctx);

		// Create new translation asset
		TranslationAsset translation = TranslationAsset.createInstance(srcLang, trgLang, srcString, null, null, owner);

		// Update the asset to be created. Could also add leveraging here and update the
		// state differently
		translation.setNewString();
		translation.setOwner(owner);

		System.out.println(translation);

		// add translation asset to the ledger in the world state
		ctx.translationAssetList.addTranslationAsset(translation);

		return translation;
	}

	@Transaction
	public TranslationAsset update(TranslationAssetContext ctx, String srcLang, String trgLang, String srcString, String trgString) {
		//get current asset from the world state using information provided
		String assetKey = LedgerState.makeUniqueKey(new String[] {srcLang, trgLang, srcString});
		TranslationAsset translation = ctx.translationAssetList.getTranslation(assetKey);
		
		//validation - im just checking for bad input as example
		if(trgString == null) {
			throw new RuntimeException("Translation for " + srcString + " cannot be empty.");
		}
		
		//move state and add translation
		translation.setTranslation(trgString);
		translation.setTranslated();
		
		//update the asset in the world state
		ctx.translationAssetList.updateTranslationAsset(translation);
		
		return translation;
	}

}
