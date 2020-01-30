# Tecnología de contabilidad distribuida

## Libros mayores y estado

Un libro mayor es solo un registro de las transacciones que han ocurrido. Por ejemplo, un libro de contabilidad bancario contiene las transacciones de todos los intercambios de saldo entre sus usuarios, por ejemplo:

```
Bob wants to send Alice £5. A transaction will be made such that
    Bob =£5=> Alice
```

Esta transacción se registra en el libro mayor. El libro mayor se ordena y muestra cada transacción desde el inicio hasta el último estado.

El estado es muy simple, es solo el estado general de todas las cuentas en el libro mayor. Por ejemplo:

```
Bob currently has £60, Alice has £20, and Richard is a new customer, the state is represented as
    Bob     : £60
    Alice   : £20
    Richard : £0
```

Los estados y los libros de contabilidad van de la mano, los libros de contabilidad contienen transacciones que alteran el estado. Usando el libro mayor podemos calcular el último estado aplicando todas las transacciones en el orden en que ocurrieron desde el estado de génesis.

## Arquitectura distribuida

**Antes de explicar qué es la arquitectura distribuida; Lo mejor es hacer explícito que hay una diferencia entre la arquitectura distribuida y descentralizada.**

Los tipos de arquitectura se pueden considerar en una escala donde Centralizado está en un extremo y Distribuido en el otro extremo, con Descentralizado en algún lugar entre los extremos. Cada una de estas redes está formada por pares dentro de ellas. Cuando una red centralizada tiene 1 punto central de comunicación entre todos los nodos, las redes distribuidas no tienen un par central para comunicarse y transmitir datos entre ellos; en cambio, los compañeros se comunican directamente con otros compañeros.

Las arquitecturas distribuidas, también llamadas redes de malla, son muy resistentes y baratas. La red contiene pares muy diversos y de calidad variable en los enlaces de comunicación y en las propias máquinas, creando así una red relativamente barata. Al no tener una parte central del sistema, se obtiene una alta resistencia ya que no existe un punto central de falla; cada nodo tiene que fallar para que la red falle. La otra ventaja es la distribución geográfica, ya que la red puede crecer simplemente agregando nuevos nodos que se conectan a los nodos más cercanos.

## Ledgers distribuidos

> Entonces, ¿cómo y por qué los libros mayores y las redes distribuidas van juntas?

Veamos nuevamente el ejemplo del Banco. Los bancos mantienen un libro mayor en una arquitectura centralizada, en donde cada transacción tiene que pasar por la autoridad central. Una vez que la autoridad central ha aceptado la transacción, el libro mayor se actualiza con esa transacción.

Ahora, si tuviéramos la misma situación en una arquitectura distribuida, no hay una autoridad central que controle y mantenga el libro mayor. Como no hay una entidad que controle el libro mayor, ¿a quién enviamos las transacciones? En resumen, la respuesta es todos. Cada par, colectivamente, mantiene y controla el libro mayor; y como tal las transacciones que pueden unirse al libro mayor. Los pares en la red tienen que aceptar que una transacción es legítima y una vez que la mayoría de la red está de acuerdo con la exactitud de la transacción, esa transacción ingresa al libro mayor.

Otra cosa a destacar es que el libro mayor se distribuye entre todos los pares. Es decir, cada persona tiene una copia del libro mayor. Entonces, cuando la red acuerda que una transacción se una al libro mayor, significa que cada par tiene que agregar esa transacción a su libro mayor. Esto significa que cada par tiene exactamente el mismo libro mayor que los pares que lo rodean.

Puede haber muchas preguntas sobre ciertos aspectos poco claros como, ¿Cómo acuerdan los pares qué transacciones ingresan al libro mayor? La respuesta a esa pregunta tiene una respuesta bastante profunda que puedes investigar; pero esencialmente hay algoritmos de consenso que se usan en sistemas distribuidos para garantizar que los pares lleguen a un acuerdo sobre algo, es decir, una transacción. Pero para este proyecto destacaré un flujo de transacciones de muy alto nivel en un libro mayor distribuido, que debería dar una idea más clara de lo que está sucediendo:

```
Bob will send Alice £5
    [Bob =£5=> Alice]
Bob will send this transaction to every peer on the network.
Everyone will validate that the transaction is legit
    [For example does Bob have enough money to send]
Once the majority of the network has agreed its legit, everyone will add the transaction to their ledger
    [They will agree through a consensus protocol]
Everyone has updated their ledger and this transaction has now been officially recorded
    [Thus having the same effect as a bank updating their ledger]
```

Parece un concepto ordenado, pero ahora surge la pregunta de por qué es importante o está cambiando el juego.

## Beneficios de las tecnologías de contabilidad distribuida

- Desintermediación

- Inmutabilidad de transacciones

- Transparencia

- Prueba de censura

- Contratos inteligentes / Chaincode

## Efecto de DLT en la pila de negocios

## Observaciones finales
