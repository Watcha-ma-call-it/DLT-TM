/*
 * SPDX-License-Identifier: Apache-2.0
 */
package org.example;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.contract.annotation.Contact;
import org.hyperledger.fabric.contract.annotation.Info;
import org.hyperledger.fabric.contract.annotation.License;
import static java.nio.charset.StandardCharsets.UTF_8;

@Contract(name = "TranslationContract",
    info = @Info(title = "Translation contract",
                description = "My Smart Contract",
                version = "0.0.1",
                license =
                        @License(name = "Apache-2.0",
                                url = ""),
                                contact =  @Contact(email = "Backend@example.com",
                                                name = "Backend",
                                                url = "http://Backend.me")))
@Default
public class TranslationContract implements ContractInterface {

    public  TranslationContract() {
    }

    @Transaction()
    public boolean translationExists(Context ctx, String translationId) {
        byte[] buffer = ctx.getStub().getState(translationId);
        return (buffer != null && buffer.length > 0);
    }

    @Transaction()
    public void addTranslation(Context ctx, String sourceStr, String sourceLocale, String targetLocale, String id) {
        boolean exists = translationExists(ctx, id);
        if (exists) {
            throw new RuntimeException("The asset "+ id +" already exists");
        }

        Translation asset = new Translation(sourceLocale, targetLocale, sourceStr);

        ctx.getStub().putState(id, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public Translation readTranslation(Context ctx, String translationId) {
        boolean exists = translationExists(ctx,translationId);
        if (!exists) {
            throw new RuntimeException("The asset "+translationId+" does not exist");
        }

        Translation asset = Translation.fromJSONString(new String(ctx.getStub().getState(translationId),UTF_8));

        return asset;
    }

    @Transaction()
    public void submitTranslate(Context ctx, String translationId, String translation) {
        boolean exists = translationExists(ctx,translationId);

        if (!exists) {
            throw new RuntimeException("The asset "+ translationId +" does not exist");
        }

        Translation asset = Translation.fromJSONString(new String(ctx.getStub().getState(translationId),UTF_8));
        asset.setTargetString(translation);

        ctx.getStub().putState(translationId, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public void deleteTranslation(Context ctx, String translationId) {
        boolean exists = translationExists(ctx,translationId);
        if (!exists) {
            throw new RuntimeException("The asset "+translationId+" does not exist");
        }
        ctx.getStub().delState(translationId);
    }

}
