/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import com.google.gson.Gson;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@DataType()
public class Translation {

    @Property()
    private final String sourceString;

    @Property()
    private String targetString;

    @Property()
    private final String sourceLocale;

    @Property()
    private final String targetLocale;

    public Translation(String sourceLocale, String targetLocale, String sourceStr) {
        this.sourceLocale = sourceLocale;
        this.targetLocale = targetLocale;
        this.sourceString = sourceStr;
	}

	public String getSourceLocale() {
        return sourceLocale;
    }

    public String getTargetLocale() {
        return targetLocale;
    }

    public String getSourceString() {
        return sourceString;
    }

    public String getTargetString() {
        return targetString;
    }

    public void setTargetString(String target) {
        this.targetString = target;
    }

    public String toJSONString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static Translation fromJSONString(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Translation.class);
    }
}
