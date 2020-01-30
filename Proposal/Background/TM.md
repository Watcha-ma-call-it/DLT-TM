# Translation Memory

## What is Translation Memory

Basically Translation Memory is a database which is used as a store for translations that can aid the translation process. New strings can be added to it. Updates can be made to existing entries. Existing translations can be deleted once they have become outdated. There can be a translation memory for each language or more complex translation memories may contain multiple languages for a given source.

## Some uses of Translation Memory

-  Leveraging Strings for translation

    The translation memory can be used to reuse previoulsy translated strings in new translation in a process called leveraging. Leveraging essentially searches the TM for a string that is similar to an input string. If the input string matches exactly as something previously translated (can be extended to match exactly with context, domain and other metadata) then the input string can be leveraged 100%; meaning actual translation is not necessary. Sometimes input strings can have a similar, but not exact, entry in the TM. These strings are then said to be leveaged at X% (i.e. how 'like' is the input string to the TM entry). Those leveraged strings tend to mean some degree of external translation is needed to completely translate the input string. When a string is fully translated, the translation is added to the TM to be reused (or leveraged) in the future.

-  Training MT engines

    Since Translation memories contain the latest and greatest translations that have been translated to date, it makes it the best place to gather training data for machine translation. Using a clean TM (a clean TM helps the resulting engine be more accurate) the Machine translation engine can create a model that can produce translations which are more alligned with the other translations within the TM. I.e. the same kind of styling/tone, less overtranslations etc. TMs dont have to be used to only train in-house MT engines but they can be used to improve and refine general MT engines; such as those provided by Google, Microsoft and Amazon; to name but a few.

-  Search to help with translations

    During the translation phase a linguist may want to search the Translation Memory for particular styling guidance or to check how a certain term, a product name for example, was previously translated. Having the ability to search aids this process and helps speed it up whilst helping to maintain a general standard that may have been set. 

-  Provide Latest and Greatest translations

    In simple terms, the Translation Memory should represent the most up to date and correct translations within the owners portfolio. Should someone, i.e. the consumer, want to use the latest translations available then the Translation Memory is the place to go.

-  An asset of the company

    Each translation within the Translation Memory can be considered an asset. Just as the source string, which could be documentation or code, is an asset of whoever owns it, so too is the translated content. What that being said the Translation Memory contains every single translated asset within the company or organisation. These assets are just as valuable as the source assets and should be treated with the same integrity. This explanation, however, glosses over the very complex and sometimes ambiguous discussion of ownership of translated content (IP).

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
