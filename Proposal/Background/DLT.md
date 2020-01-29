# Distributed Ledger Technology

## Ledgers and State

A ledger is just a record of transactions which have occurred. For example a bank ledger contains the transactions of all the exchanges of balance between its users, for example :

    Bob wants to send Alice £5. A transaction will be made such that 
        Bob =£5=> Alice

This transaction is then recorded into the ledger. The ledger is ordered and shows each transaction from the start to the latest state.

State is very simple, its just the overall status of all the accounts on the ledger. For example:

    Bob currently has £60, Alice has £20, and Richard is a new customer, the state is represented as
        Bob     : £60
        Alice   : £20
        Richard : £0

States and ledgers go hand in hand, ledgers contain transactions which alter the state. Using the ledger we can compute the latest state by applying all the transactions in the order they occurred from the genesis state.

## Distributed Architecture

**Before explaining what distributed architecture is; it is best to make explicit that there is a difference between Distributed and Decentralized architecture.**

Architecture types can be considered on a scale where Centralised is on one extreme and Distributed on the other extreme, with Decentralised being some place in between the extremes. Each of these networks are made up of peers within them. Where as centralised network has 1 central point of communication between all the nodes, distributed networks has no central peer to communicate and transmit data between; instead peers communicate directly to other peers.

Distributed architectures, also called mesh networks, are very resilient and cheap. The network contains very diverse peers of varying quality in communication links and the machines themselves, thus creating a relatively cheap network. Having no Central part of the system results in high resilience since there is no central point of failure; every node has to fail in order for the network to fail. The other advantage is geographic spread since the network can grow just by adding new nodes that connect to the closest nodes.

## Distributed Ledgers

> So how and why do ledgers and distributed networks go together?

Lets look at the Bank example again. Banks maintain a ledger in a centralized architecture, wherein every transaction has to go through the central authority. Once the central authority has accepted the transaction, the ledger is updated with that transaction.

Now if we had the same situation in a distributed architecture, there is no central authority controlling and maintaining the ledger. Since there is no one entity controlling the ledger who do we send the transactions to? In short the answer is everyone. Each peer, collectively, maintains and controls the ledger; and as such the transactions which can join the ledger. Peers on the network have to agree that a transaction is legit and once the majority of the network agrees on the correctness of the transaction, that transaction enters the ledger.

Another thing to point out is that the ledger is distributed among every peer. I.e. every person has a copy of the ledger. So when the network agrees for a transaction to join the ledger, it effectively means that every peer has to add that transaction to their ledger. This means that every peer has the exact same ledger as the surrounding peers.

There may be a lot of questions about certain unclear aspects such as, How do the peers agree on what transactions enter the ledger? The answer to that question has quite an in depth answer which you can research; but essentially there are consensus algorithms which are used in distributed systems to ensure that peers reach an agreement about something, i.e. a transaction. But for this project I will highlight a very high level transaction flow in a distributed ledger, which should give a clearer picture about what is happening:

    Bob will send Alice £5 
        [Bob =£5=> Alice]
    Bob will send this transaction to every peer on the network.
    Everyone will validate that the transaction is legit 
        [For example does Bob have enough money to send]
    Once the majority of the network has agreed its legit, everyone will add the transaction to their ledger 
        [They will agree through a consensus protocol]
    Everyone has updated their ledger and this transaction has now been officially recorded
        [Thus having the same effect as a bank updating their ledger]

It seems like a neat concept, but now begs the question why is this important or game changing?

## Benefits of Distributed Ledger Technologies

-  Disintermediation

-  Immutability of Transactions

-  Transparency

-  Censorship Proof

## DLT's Effect on the Business Stack

## Final Remarks