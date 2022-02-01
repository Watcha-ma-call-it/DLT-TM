# Combining TMs and DLTs

## Translation Memory as a Ledger

A Translation Memory can be thought of exactly like a ledger with a state. The transactions in the ledger represents any update to the translation memory, whether its a new source string, providing  a translation for a source or updating an existing translation. And the state represents (at a given point in time) the latest and greatest translations. Its pretty much exactly what a translation memory is but explicitly split up into transactions and the states. Lets just illustrate this in a simple example.

The state is essentially a list of translation objects, where each translation looks something like this:

```json
{
    id:"Unique ID"
    source:"Source String",
    sourceLanguage:"Source Language",
    target:"Translated String",
    targetLanguage:"Translation Language"
}
```

Lets begin our example by creating a new TM. Our current state, which is also the genesis state has nothing to show. Our first transaction would be to create a new entry. The transaction would look something like this:

```json
{
    transactionType:"create",
    transactionObject:{
        id:"1",
        source:"Hello World",
        sourceLanguage:"English",
        targetLanguage:"Spanish"
    }
}
```

The transaction contains the type of transaction and then the transaction object. The transaction type signifies what operation is going to happen and the object represents the data that is going to be consumed, in this case we are going to `create` an entry with the data. This transaction is recorded in the ledger of transactions; and once in the ledger the state is updated to represent:

```json
{
    id:"1"
    source:"Hello World",
    sourceLanguage:"English",
    targetLanguage:"Spanish"
}
```

You may have noticed that there is no translation for the source string. This is where the next transaction comes into play. We are going to translation this specific entry with another transaction:

```json
{
    transactionType:"update",
    transactionObject:{
        id:"1",
        target:"Hola World"
    }
}
```

This transaction specifies that we are going to `update` an entry in the state. The transaction object specifies information about what we are going to update such as the entry in the TM we are updating and the fields to update. Once this transaction enters the ledger the state updates to represents this:

```json
{
    id:"1"
    source:"Hello World",
    sourceLanguage:"English",
    target:"Hola World",
    targetLanguage:"Spanish"
}
```

If you are a Spanish speaker you may notice a mistake; 'World' is not translated in the target field. Our translator just realised the mistake too, to rectify this they are going to create another transaction to update the mistake:

```json
{
    transactionType:"update",
    transactionObject:{
        id:"1",
        target:"Hola Mundo"
    }
}
```

Just like the transaction before, once it is recorded in the ledger the global state is updated:

```json
{
    id:"1"
    source:"Hello World",
    sourceLanguage:"English",
    target:"Hola Mundo",
    targetLanguage:"Spanish"
}
```

So in this example an entry was added into the TM, then updated once followed by another update. The latest and greatest state of the TM is shown above. However, lets take a look at the ledger. The ledger contains a total of 3 transactions, ordered in the order they occurred:

```json
{
    transactionType:"create",
    transactionObject:{
        id:"1",
        source:"Hello World",
        sourceLanguage:"English",
        targetLanguage:"Spanish"
    }
},
{
    transactionType:"update",
    transactionObject:{
        id:"1",
        target:"Hola World"
    }
},
{
    transactionType:"update",
    transactionObject:{
        id:"1",
        target:"Hola Mundo"
    }
}
```

The ledger, if you recall, is just an append only list that cannot be altered in any way. Once a transaction as added the effects of the transaction will remain in the history. This is a really cool feature because, as an example, we can generate the state at any given point in history. Since we know the first state (or genesis state) we can apply all the transactions up to the point that is of interest. We can find out when an error entered the TM, who generated a transaction, and trace a translation throughout its life.

Just for full disclosure, you don't actually need to keep track of the current state as we have a ledger to compute the current state. However, as you can imagine, as a ledger gets longer and longer, and a TM gets more mature the time taken to compute the current state gets longer. That's why we keep track of the latest state along side the ledger, for simplicity and speed.

## Smart Contracts

Now we have understood how transactions and ledgers can be used to make a Translation Memory happen, next we will look at how we can add some business logic to the ledger and state. We can consider a Translation memory as having these basic functions:

-  Create a new entry
   -  This is really a basic functionality, given a source string, source language and target language create a transaction that will create a new asset.
   -  We saw an example of a transaction like this above.
-  Update an existing translation
   -  Similar to the create function the update has been seen above. Where given a target string update the entry with it.
-  Leverage a string
   -  This function is a little more complex. Given a source string and target language search for all strings that are 'like' the source and then provide a score about how close the results match with the input.
   -  This function as you may expected doesn't exactly change the state of the ledger nor will it add any transactions as its basically querying the current state for leverage matches.
-  Search for a particular source string
   -  Just a simple query function that will return a list of entries which match the input source string.
   -  Again this function wont create any transactions.
-  Delete an existing translation
   -  A basic function that will create a transaction to delete an entry in the TM

With just these basic functions we can recreate a translation memory and the simple interactions to it. But there can be more complex functions that can extend and hopefully enhance a translation memory.

_to expand about more complex functions and baseline code in all network participants_

## Going beyond the Simple

In the examples above, we had a very simple model of transactions and translations themselves but a Translation Memory combined with DLTs can be provide so much more. Lets take a look at the benefits of Distributed Systems and DLTs in general and apply these to the Translation Memory to see the advantages and the perceived sleights it brings with it.

-  Ownership
    who owns it
    merge companies
    define the interactions i.e translators

-  Peer to Peer
    connect driectly with peers
    interface/allow for nodes in places

-  Traceability
    see who affected the tm
    show the translation trace of a string from updates to creation to edits
    people prove that they worked on something

-  Translator identity
    prove that helped translate something
    go from 1 company to another, identity remains the same, but the access to the ledgers have changed, but not your transaction history

## Hypotetical scenario
    define accounts in system
    define an application
    define the smart contract functions