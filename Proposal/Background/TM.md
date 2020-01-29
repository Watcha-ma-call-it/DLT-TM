# Translation Memory

## What is Translation Memory

Basically Translation Memory is a database which is used as a store for translations that can aid the translation process. New strings can be added to it. Strings within the TM can be updated with better translations. In theory should be maintained and cleaned where outdated translations should be deleted.

## Some uses of Translation Memory

-  Leverage String for translation

    Translation Management Systems holds a translation memory. Strings are leveraged from the translation memory. The rest are translated. The final translations update the translation memory, to provide better leverage the next time. There could be multiple 'projects' using a combination of translation memories to provide resuse in the future. Meta data can help to determine the best leveraging

-  Train MT engines

    Using just the source and target of the TM, you can train models for Machine Translation engines. This will provide a better more accurate translation when using the engine. A clean TM is best for training.

-  Search to help with translations

    During the translation phase a linguist may be able to search a Translation Memory to understand certain styles and terminology used in the past; to adhere to a company standard.

-  Provide Latest and Greatest translations

    The translation memory should represent the latest and greatest translation for a particular string (in simple terms)

-  An asset of the company

    A Translation Memory is an asset to any company or persons, as it contains data about how documents, code, etc are translated. Essentially the translated IP (depending on Laws)

## Current Issues with Translation Memories

-  Maintaining multiple TMs

    There doesnt have to be 1 TM for 1 company/person. One entity could have multiple TMs split by product group, Content type, domain. Its when an entity has more than 1 TM it can be very difficult to maintain each individual one, especsially if there is a combination of in-house and external systems utilising TMs and keeping track of the translations.

-  Changing Translation Management System

    A time comes when you want to change the Translation Management System being used and this means migration of data will need to occur. It can be quite troublesome to transfer data from one system to another, same goes for uploading and TMs into a new system.

-  Synchronization of Data across TMs

    It is pretty common to have multiple TM data in different platforms and in different forms. It then becomes a mammoth task to ensure that all versions of the TM data is synchronised across platforms. For example one TMS may be used for documentation and another TMS be used for UI. The documentation and UI will have their own TM. But the documentation may want to use the UI TM in aid of the translating. This causes an issue when the UI TM is continually updated in the UI TMS, the same changes are not reflected in the documentation TM unless the new TM has been exported and updated.

-  Distributing TMs to Linguists

    Similarily TMs may be distrubuted to linguists to help with searching, but the TMs are continually updated which arent easily distrubuted, especially when you have multiple TMs in mulitple places.

-  Ownership of TMs

    With TMs being duplicated in many different ways and many different platforms, it begs the question, who owns this TM? Does the platform who generated the TM have some right to the ownership of the TM they generated. Does the entity who provided the source strings own the TM? By distributing a TM to a linguist mean that this TM is now free to be distributed as the linguist sees fit?
