package dev.darrenmatthews.translations.smartcontracts.ledgerApi;

import java.util.Arrays;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.shim.ChaincodeStub;
import org.hyperledger.fabric.shim.ledger.CompositeKey;

public class LedgerStateList {
	
	private Context ctx;
    private String name;
    private LedgerStateDeserializer deserializer;

    /**
     * Store Fabric context for subsequent API access, and name of list
     *
     * @param deserializer
     */
    public LedgerStateList(Context ctx, String listName, LedgerStateDeserializer deserializer) {
        this.ctx = ctx;
        this.name = listName;
        this.deserializer = deserializer;

    }

    /**
     * Add a state to the list. Creates a new state in worldstate with appropriate
     * composite key. Note that state defines its own key. State object is
     * serialized before writing.
     */
    public LedgerStateList addState(LedgerState state) {
        System.out.println("Adding state " + this.name);
        ChaincodeStub stub = this.ctx.getStub();
        System.out.println("Stub=" + stub);
        String[] splitKey = state.getSplitUniqueKey();
        System.out.println("Split key " + Arrays.asList(splitKey));

        CompositeKey ledgerKey = stub.createCompositeKey(this.name, splitKey);
        System.out.println("ledgerkey is ");
        System.out.println(ledgerKey);

        byte[] data = LedgerState.serialize(state);
        System.out.println("ctx" + this.ctx);
        System.out.println("stub" + this.ctx.getStub());
        this.ctx.getStub().putState(ledgerKey.toString(), data);

        return this;
    }

    /**
     * Get a state from the list using supplied keys. Form composite keys to
     * retrieve state from world state. State data is deserialized into JSON object
     * before being returned.
     */
    public LedgerState getState(String key) {
        CompositeKey ledgerKey = this.ctx.getStub().createCompositeKey(this.name, LedgerState.splitUniqueKey(key));

        byte[] data = this.ctx.getStub().getState(ledgerKey.toString());
        if (data != null) {
            LedgerState state = this.deserializer.deserialize(data);
            return state;
        } else {
            return null;
        }
    }

    /**
     * Update a state in the list. Puts the new state in world state with
     * appropriate composite key. Note that state defines its own key. A state is
     * serialized before writing. Logic is very similar to addState() but kept
     * separate becuase it is semantically distinct.
     */
    public LedgerStateList updateState(LedgerState state) {
        CompositeKey ledgerKey = this.ctx.getStub().createCompositeKey(this.name, state.getSplitUniqueKey());
        byte[] data = LedgerState.serialize(state);
        this.ctx.getStub().putState(ledgerKey.toString(), data);

        return this;
    }
	
	public static LedgerStateList getStateList(Context ctx, String ledgerListName, LedgerStateDeserializer deserializer) {
		return new LedgerStateList(ctx, ledgerListName, deserializer);
	}
}
