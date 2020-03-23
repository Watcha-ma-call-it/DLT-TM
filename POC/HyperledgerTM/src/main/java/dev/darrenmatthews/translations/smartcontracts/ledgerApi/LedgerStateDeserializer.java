package dev.darrenmatthews.translations.smartcontracts.ledgerApi;

@FunctionalInterface
public interface LedgerStateDeserializer {
    LedgerState deserialize(byte[] buffer);
}
