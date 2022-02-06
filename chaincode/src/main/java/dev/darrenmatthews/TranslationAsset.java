/*
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.darrenmatthews;


import com.owlike.genson.annotation.JsonProperty;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@DataType()
public final class TranslationAsset {

    @Property()
    private String domain;

    @Property
    private final String id;

    @Property()
    private final String source;

    @Property
    private String target;

    @Property()
    private final String sourceLanguage;

    @Property()
    private final String targetLanguage;

    @Property
    private String owner;

    public TranslationAsset(
            @JsonProperty("id") final String id,
            @JsonProperty("source") final String source,
            @JsonProperty("sourceLanguage") final String srcLang,
            @JsonProperty("targetLanguage") final String trgLang,
            @JsonProperty("owner") final String owner,
            @JsonProperty("domain") final String domain)
    {
        this.id = id;
        this.source = source;
        this.sourceLanguage = srcLang;
        this.owner = owner;
        this.targetLanguage = trgLang;
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
