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

    It is sometimes more pratical to maintain different TMs for different categories of translations. For example, it may be prudent to maintain a TM for different content types, such as User Interface strings and Documentation. These TMs may be used in different places for different purposes, for example; Someone may want linguists to translate UI strings in one platform (thus using the UI TM in that platform) and then want linguists to translate Documentation in another platform. This can be a management nightmare as you may have to maintain these TMs (i.e. clean them) seperately outside their respective platforms, to then be uploaded again. This also doesnt take into account when you may want a combination of TMs in one platform. For example the UI TM is being continually updated in one platform, but then the Documentation platform wants to use UI TMs in their leveraging. This causes more overhead as you have to download and upload these TMs to different platforms mulitple times as more updates come in.

-  Distributing TMs to Linguists

    As mentioned before TMs are very useful for linguists to be able to search, so that they can understand style and how certain terminology has been translated before. Some ways to distribute the TM to the linguist is by just giving them the exported TMX file which they can then used their prefered TM search tool. This poses an issue of, how do you keep the linguists TMs up to date with the latest translations so that they are always searching for the latest styles and terminology. With the added overhead of having multiple TMs across different platforms it becomes a cumbersome task to make sure a linguist has access to the TMs they need in order to be able to translate to the best of their ability.

-  Ownership of TMs

    This issue can be quite a complex one, especially with different laws in different countries, and different policies between companies and organisations. However, the same core issue still persists; who exactly owns the TMs? TMs can be generated in many different ways, whether its an in-house localisation system, within an external Translation Management System, or by a linguists who records the translations they have done. This poses many different questions, is the entity who generates a TM owns the TM? Is the owner of the source strings the owner of the TM, regardless of where it was generated? Does a linguist who does the translation own a partial part of the TM (their IP)? If you distribute a TM to someone outside the entity's group does that TM fall under a distribution license? These questions can have very complex and sometime ambiguous answers.

---

> This page may not encapsulate everything a TM has to offer, nor does it highlight issues with TMs across the industry but I do believe it is enough basic knowledge to help understand the concepts within the proposal. Please head back to the start [here](../index 'The Proposal'). 
