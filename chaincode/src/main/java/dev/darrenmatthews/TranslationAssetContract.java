/*
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.darrenmatthews;

import java.util.ArrayList;
import java.util.List;


import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Info;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.shim.ChaincodeException;
import org.hyperledger.fabric.shim.ChaincodeStub;
import org.hyperledger.fabric.shim.ledger.KeyValue;
import org.hyperledger.fabric.shim.ledger.QueryResultsIterator;

import com.owlike.genson.Genson;

@Contract(
        name = "translation-memory",
        info = @Info(
                title = "Translation Asset Management",
                description = "The HyperLegendary Translation Asset Management System",
                version = "0.0.1-SNAPSHOT"))
@Default
public final class TranslationAssetContract implements ContractInterface {

    private final Genson genson = new Genson();

    private enum AssetTransferErrors {
        ASSET_NOT_FOUND,
        ASSET_ALREADY_EXISTS
    }

    /**
     * Creates some initial assets on the ledger.
     *
     * @param ctx the transaction context
     */
    @Transaction(intent = Transaction.TYPE.SUBMIT)
    public void InitLedger(final Context ctx) {
        ChaincodeStub stub = ctx.getStub();

        TranslationAsset asset = new TranslationAsset("id1", "Hello World", "en-us", "es-es", "darren", "Text");
        asset.setTarget("Hola Mundo");
        stub.putStringState(asset.getId(), genson.serialize(asset));

        asset = new TranslationAsset("id2", "Hello World", "en-us", "zh-cn", "darren", "Text");
        asset.setTarget("你好世界");
        stub.putStringState(asset.getId(), genson.serialize(asset));

        asset = new TranslationAsset("id3", "Hello World", "en-us", "de-de", "darren", "Text");
        asset.setTarget("Hallo Welt");
        stub.putStringState(asset.getId(), genson.serialize(asset));

        asset = new TranslationAsset("id4", "Hello World", "en-us", "fr-fr", "darren", "Text");
        asset.setTarget("Bonjour monde");
        stub.putStringState(asset.getId(), genson.serialize(asset));
    }

    @Transaction(intent = Transaction.TYPE.SUBMIT)
    public TranslationAsset CreateAsset(
            final Context ctx,
            final String id,
            final String source,
            final String srcLang,
            final String trgLang,
            final String owner,
            final String domain) {
        ChaincodeStub stub = ctx.getStub();

        TranslationAsset asset = new TranslationAsset(id, source, srcLang, trgLang, owner, domain);

        if (AssetExists(ctx, id)) {
            String errorMessage = String.format("Asset %s already exists", id);
            System.out.println(errorMessage);
            throw new ChaincodeException(errorMessage, AssetTransferErrors.ASSET_ALREADY_EXISTS.toString());
        }

        //Use Genson to convert the Asset into string, sort it alphabetically and serialize it into a json string
        String sortedJson = genson.serialize(asset);
        stub.putStringState(id, sortedJson);

        return asset;
    }

    /**
     * Retrieves an asset with the specified ID from the ledger.
     *
     * @param ctx the transaction context
     * @param assetID the ID of the asset
     * @return the asset found on the ledger if there was one
     */
    @Transaction(intent = Transaction.TYPE.EVALUATE)
    public TranslationAsset ReadAsset(final Context ctx, final String assetID) {
        ChaincodeStub stub = ctx.getStub();
        String assetJSON = stub.getStringState(assetID);

        if (assetJSON == null || assetJSON.isEmpty()) {
            String errorMessage = String.format("Asset %s does not exist", assetID);
            System.out.println(errorMessage);
            throw new ChaincodeException(errorMessage, AssetTransferErrors.ASSET_NOT_FOUND.toString());
        }

        TranslationAsset asset = genson.deserialize(assetJSON, TranslationAsset.class);
        return asset;
    }


    @Transaction(intent = Transaction.TYPE.SUBMIT)
    public TranslationAsset UpdateAsset(final Context ctx, final String id, final String translation) {
        ChaincodeStub stub = ctx.getStub();

        if (!AssetExists(ctx, id)) {
            String errorMessage = String.format("Asset %s does not exist", id);
            System.out.println(errorMessage);
            throw new ChaincodeException(errorMessage, AssetTransferErrors.ASSET_NOT_FOUND.toString());
        }

        TranslationAsset asset = ReadAsset(ctx, id);
        asset.setTarget(translation);

        //Use Genson to convert the Asset into string, sort it alphabetically and serialize it into a json string
        stub.putStringState(asset.getId(), genson.serialize(asset));
        return asset;
    }

    /**
     * Deletes asset on the ledger.
     *
     * @param ctx the transaction context
     * @param assetID the ID of the asset being deleted
     */
    @Transaction(intent = Transaction.TYPE.SUBMIT)
    public void DeleteAsset(final Context ctx, final String assetID) {
        ChaincodeStub stub = ctx.getStub();

        if (!AssetExists(ctx, assetID)) {
            String errorMessage = String.format("Asset %s does not exist", assetID);
            System.out.println(errorMessage);
            throw new ChaincodeException(errorMessage, AssetTransferErrors.ASSET_NOT_FOUND.toString());
        }

        stub.delState(assetID);
    }

    /**
     * Checks the existence of the asset on the ledger
     *
     * @param ctx the transaction context
     * @param assetID the ID of the asset
     * @return boolean indicating the existence of the asset
     */
    @Transaction(intent = Transaction.TYPE.EVALUATE)
    public boolean AssetExists(final Context ctx, final String assetID) {
        ChaincodeStub stub = ctx.getStub();
        String assetJSON = stub.getStringState(assetID);

        return (assetJSON != null && !assetJSON.isEmpty());
    }

    /**
     * Retrieves all assets from the ledger.
     *
     * @param ctx the transaction context
     * @return array of assets found on the ledger
     */
    @Transaction(intent = Transaction.TYPE.EVALUATE)
    public String GetAllAssets(final Context ctx) {
        ChaincodeStub stub = ctx.getStub();

        List<TranslationAsset> queryResults = new ArrayList<>();

        // To retrieve all assets from the ledger use getStateByRange with empty startKey & endKey.
        // Giving empty startKey & endKey is interpreted as all the keys from beginning to end.
        // As another example, if you use startKey = 'asset0', endKey = 'asset9' ,
        // then getStateByRange will retrieve asset with keys between asset0 (inclusive) and asset9 (exclusive) in lexical order.
        QueryResultsIterator<KeyValue> results = stub.getStateByRange("", "");

        for (KeyValue result: results) {
            TranslationAsset asset = genson.deserialize(result.getStringValue(), TranslationAsset.class);
            System.out.println(asset);
            queryResults.add(asset);
        }

        return genson.serialize(queryResults);
    }
}
