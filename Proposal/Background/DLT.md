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

## Smart Contracts and Chain code

In almost every single Distributed Ledger Technology there is a concept called smart contracts (or chain code, depending on the implementation). Essentially a smart contract is a script, or piece of code that manipulates the state of the ledger by generating transactions on behalf of the executor. You can encapsulate logic into the smart contracts which, when deployed, can be executed by people on the network. For example, it wouldn't be such a bad idea to implement a voting contract, which allows 1 person to vote for something and after a certain point in time will count up the number of votes for and against the idea. Its a very simple smart contract but with a very forward thinking ideal; there is no longer a need for a trusted third party to count and collect votes, instead can be done in an incorruptible, unbiased smart contract. Smart contracts add extra logic to a Distributed Ledger so that ledger transactions can be generated and executed in a logical fashion (business logic).

## Benefits of Distributed Ledger Technologies

-  Disintermediation

    With all Distributed system you have completely removed a centralised authority and more often than not, an unneccessary middleman. Napster is a great example of this, they completely changed the music industry. Rather than people having to buy music and obtain music solely through the records labels, Napster allowed users to share music with other users on the network. Whilst Napster had a few issues with copyright and illegal distribution its system changed to music industry. Music artists realised that they could share their music directly with the consumer without the need for a record label be an unneccessary middle man. With the use of smart contracts it is possible to remove intermediatries that faciliate the exchanging of this data. For example, you would be able to transfer an asset (i.e. a house) directly to the buyer without the need of an estate agent to facilate the exchange. A smart contract would be written to exchange the owner of the house from the current owner to the buyer. There are alof of industries and companies built solely on being a middleman to facilitate interactions between entities.

-  Ownership / Transfer of Ownership

    Although not explicitly mentioned in the bank example above, all the data (i.e. the accounts) are owned by account holders. That is that each asset on the ledger is own by a participant on the network, this comes into play in the validation phase where we determine if a transaction is good or not. In the bank example we can think of a transaction (_Bob's account send £5 to Alice's account_); then we look at 2 versions of this transaction, one sent by Bob and another sent by Alice. Only an account owner can send money from their account and wont allow anyone else to initiate a transaction from not their account. So out of the 2 transactions only 1 transaction (the one from the owner : Bob) would be considered legit. Lets look at this in a general viewpoint of assets on the ledger. An asset will have an owner (or set of owners), in general, transactions that change the state of the asset tends to be done by the owner (depending on what kind of asset it is). The clear definition of what an owner of an asset is is a big strength for DLTs. Lets look at one more example, in this scenario we shall look at a real estate assets. The asset is a house, the owner of the house is the owner of the asset; there may be data on this asset such as the number of bedrooms, the council tax bands. The owner of the house may do some renovation on the property so they will update the asset with another bedroom, this may then affect which council tax band they are in. In the UK the council tax band status (amount of tax paid to local government for the house) is determined by the local council, thus state of the tax band recorded in the asset has to be initiated by the council but agreed upon by the owner. The owner of the house may want to sell the house at some point, they can transfer ownership of the asset to the new owner with a simple state change. Once transfer has taken place the new owner has the exact same permissions as the previous owner, where as the previous owner has relinguished all rights to that asset. Its a simple but powerful concept, the owner of the data determines who can interact with it, who can alter it, and has complete soverignty over all its state. Imagine have personal identifyable information stored for each user on the network, each person would own their data update their own data and be able to share or unshare their PII with whom ever they want. Now imagine the power and control that each individual has over their own information and assets compared to the world today.

-  Immutability of Transactions

    What may not be apparent in the explaination above is that once a transaction has entered a ledger it is impossible (not entirely true, due to the consensus protocols) to remove that transaction or alter it in any way. This immutabililty of transaction records an unbiased true account of what has occured throughout history. The immutability of transactions means that people are held accountable for their transactions. People cannot dispute that a transaction hasnt occured since everyone agreed on that transaction and this transaction cannot be changed. Since transaction cannot be alter in anyway this builds in an anti-censorship gate, where nothing can be censorsed. Take the bank example, they solely maintain their ledger, they could, in theory, alter the accounts and transactions of its users effectively censoring the data.

-  Trustless (Somewhat)

    Depending on how a DLT is implemented it can be completley trustless and completely distributed. The ways which DLTs can be completely trustless is the way in which each peer talks to each other. A peer doesnt trust any other peer, but it trusts itself, having this distrust creates a philosphy of verify everything. Every peer will verify every transaction it retrieves without having to trust the peer that sent it. This way by default everybody verifies if a transaction is legit or not then everyone comes to an agreement about the overall cosensus about if the transaction should be added. This trustless, verify first, behaviour creates a system which is resilient to bad actors. However this is to say that everything is at mercy of the consensus of the network. For example, a peer may think that a transaction is good but the overall consensus of the network was that the transaction was bad, this transaction will not enter the ledger. True, unbiased democracy.

## DLT's Effect on the Business Stack

You may understand what a Distributed Ledger is and the benefits it can bring with it. But you may now ask, where do Distributed Ledgers fit in the overall picture. To explain the place of DLTs, I am going to explain the events that occurred before to change the picture. I like to call the overall picture the Business Stack. The business stack is made up of 3 components (Communications, Data, Business Logic), its essentially a very naive visualisation of how a company operates. I will illustrate the journey in 3 stages; past, present, future. Where the past is the stack before the Internet, the present is in this internet era and the future being where the stack could go with DLTs. 

---

This is my version of the 'Pre Internet' era :

![Pre Internet Phase](../Images/preInternet.png)

Before the internet we had a very siloed stack, wherein every company seemingly had the same 3 components. Communications, Data and Business Logic. The Communications component included things like the postal service to talk to external entities, phones to communicate to in-house and external entities and any other mechanisms such as pneumatic tubes. The Data component relates to the data that the company has, it could be PII of its customers, or, in the bank example, the actual accounts of its customers; basically the data needed by the company to run. And finally the Business Logic layer is how the business uses the data in the previous component to essentially operate the business. Each business had to some degree a similar set up throughout the pre internet era, this started to change once the internet came along...

---

With the Internet came an updated stack :

![Internet Phase](../Images/internet.png)

Along came the internet, a high performing multimedia network that changed the whole communications layer. Instead of have a very siloed communication component the whole communication layer essentially became shared across businesses and even individual people. The data and the business logic still remained siloed to each individual enterprise but what the shared communications layer allowed for was easier access to data (via APIs, direct DB connections, etc). Just that high speed connection to data and the enterprise it self completely revolutionized the world, from big shifts to e-commerce to the completely new types of businesses. A great example of the shift is banks, banks went from in-store only type transactions (withdrawal of cash, loan applications, savings deposits, etc.) to online banking (everything in the hands of the users). Data and business logic is still siloed to each enterprise and this is apparent in the likes of Google and Facebook whose data components are vast; containing information about user behaviour, interactions, personal identifiable information. Using this data they can grow and customise their business for each user. Something you may notice is a lot of this data is duplicated in each enterprise, such as the personal information. Data privacy really came into play since a lot of data was held by these enterprises and since they weren't the actual owners of this information good practices were needed in order to protect the owner's against misuse. Understanding what kind of data companies have on their users is something that is a hot topic and on the minds of pretty much everyone. Keep that in mind and lets look at how DLTs come into play...

---

With DLTs come this updated stack:

![DLT Phase](../Images/DLT.png)

__To Be Filled in next__

## Final Remarks