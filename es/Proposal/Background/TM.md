# Memoria de traducción

## ¿Qué es la memoria de traducción?

Básicamente, la memoria de traducción es una base de datos que se utiliza como almacén de traducciones que pueden ayudar al proceso de traducción. Se le pueden agregar nuevas cadenas. Se pueden realizar actualizaciones a las entradas existentes. Las traducciones existentes se pueden eliminar una vez que hayan quedado desactualizadas. Puede haber una memoria de traducción para cada idioma o las memorias de traducción más complejas pueden contener varios idiomas para una fuente determinada.

## Algunos usos de la memoria de traducción

- Aprovechamiento de cadenas para la traducción

    La memoria de traducción se puede utilizar para reutilizar cadenas traducidas previamente en una nueva traducción en un proceso llamado apalancamiento. El apalancamiento esencialmente busca en la TM una cadena que sea similar a una cadena de entrada. Si la cadena de entrada coincide exactamente como algo traducido previamente (se puede extender para que coincida exactamente con el contexto, el dominio y otros metadatos), la cadena de entrada se puede aprovechar al 100%; lo que significa que la traducción real no es necesaria. A veces, las cadenas de entrada pueden tener una entrada similar, pero no exacta, en la TM. Luego se dice que estas cadenas están niveladas en X% (es decir, qué tan 'similar' es la cadena de entrada a la entrada TM). Esas cadenas apalancadas tienden a significar que se necesita cierto grado de traducción externa para traducir completamente la cadena de entrada. Cuando una cadena se traduce completamente, la traducción se agrega a la TM para ser reutilizada (o apalancada) en el futuro.

- Entrenamiento de motores MT

    Dado que las memorias de traducción contienen las últimas y mejores traducciones que se han traducido hasta la fecha, es el mejor lugar para recopilar datos de capacitación para la traducción automática. Usando una TM limpia (una TM limpia ayuda a que el motor resultante sea más preciso), el motor de traducción automática puede crear un modelo que puede producir traducciones que están más alineadas con las otras traducciones dentro de la TM. Es decir, el mismo tipo de estilo / tono, menos sobretraducciones, etc. Los TM no tienen que usarse solo para entrenar motores MT internos, sino que pueden usarse para mejorar y refinar motores MT generales; como los proporcionados por Google, Microsoft y Amazon; para nombrar sólo unos pocos.

- Buscar para ayudar con las traducciones

    Durante la fase de traducción, un lingüista puede buscar en la memoria de traducción una guía de estilo particular o verificar cómo se tradujo previamente un cierto término, un nombre de producto, por ejemplo. Tener la capacidad de buscar ayuda a este proceso y ayuda a acelerarlo, al tiempo que ayuda a mantener un estándar general que puede haberse establecido.

- Proporcionar las últimas y mejores traducciones

    En términos simples, la memoria de traducción debe representar las traducciones más actualizadas y correctas dentro de la cartera de propietarios. Si alguien, es decir, el consumidor, desea utilizar las últimas traducciones disponibles, entonces la Memoria de traducción es el lugar indicado.

- Un activo de la empresa.

    Cada traducción dentro de la memoria de traducción puede considerarse un activo. Así como la cadena fuente, que podría ser documentación o código, es un activo de quien la posee, también lo es el contenido traducido. Dicho esto, la memoria de traducción contiene todos los activos traducidos dentro de la empresa u organización. Estos activos son tan valiosos como los activos de origen y deben tratarse con la misma integridad. Esta explicación, sin embargo, pasa por alto la discusión muy compleja y a veces ambigua de la propiedad del contenido traducido (IP).

## Problemas actuales con memorias de traducción

- Mantenimiento de múltiples TM

    No tiene que haber 1 TM para 1 compañía / persona. Una entidad podría tener múltiples TM divididas por grupo de productos, tipo de contenido, dominio. Cuando una entidad tiene más de 1 TM, puede ser muy difícil mantener cada uno individualmente, especialmente si hay una combinación de sistemas internos y externos que utilizan TM y hacen un seguimiento de las traducciones.

- Cambio del sistema de gestión de la traducción

    Llega un momento en que desea cambiar el Sistema de gestión de traducción que se está utilizando y esto significa que tendrá que ocurrir la migración de datos. Transferir datos de un sistema a otro puede ser bastante problemático, lo mismo ocurre con la carga y las TM en un nuevo sistema.

- Sincronización de datos a través de TM

    Es bastante común tener múltiples datos TM en diferentes plataformas y en diferentes formas. Luego se convierte en una tarea gigantesca para garantizar que todas las versiones de los datos TM estén sincronizadas en todas las plataformas. Por ejemplo, un TMS puede usarse para documentación y otro TMS para UI. La documentación y la interfaz de usuario tendrán su propia TM. Pero la documentación puede querer usar la UI TM en ayuda de la traducción. Esto causa un problema cuando la UI TM se actualiza continuamente en la UI TMS, los mismos cambios no se reflejan en la documentación TM a menos que la nueva TM se haya exportado y actualizado.

- Distribución de TM a lingüistas

    Del mismo modo, las TM se pueden distribuir a los lingüistas para ayudar con la búsqueda, pero las TM se actualizan continuamente y no se distribuyen fácilmente, especialmente cuando tienes múltiples TM en múltiples lugares.

- Propiedad de TMs

    Con los TM duplicados de muchas maneras diferentes y muchas plataformas diferentes, surge la pregunta, ¿quién es el propietario de este TM? ¿La plataforma que generó la TM tiene algún derecho a la propiedad de la TM que generaron? ¿La entidad que proporcionó las cadenas de origen posee la TM? Al distribuir una TM a un lingüista, ¿significa que esta TM ahora es libre de distribuirse como el lingüista lo considere apropiado?
