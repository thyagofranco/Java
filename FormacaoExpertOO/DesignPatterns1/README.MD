No início da Formação você vai aprender sobre Design Patterns com Java. Você vai conhecer a importância de estudar os padrões de projeto, resolver os problemas de muitos Ifs usando Strategy, adicionar os comportamentos ao seu objeto com Decorator, criar diferentes ações com Observer e utilizar o Builder para criação de objetos complicados.

Além disso, você criará objetos complexos com o Factory, controlará seus objetos com Flyweight, vai salvar os estados de um objeto usando o padrão Memento, entenderá como funciona uma árvore de interpretação e resolverá heranças complexas com o Bridge.

Uma certeza no mundo do Software é que ele vai mudar.
- novidades aparecerão
- alterações solicitadas pelo mercado

Como essas mudanças raramente são planejadas, os desenvolvedores acabam criando códigos díficeis de manter, complicados e muito acoplados. 

Boas idéias e bons princípios:
- Alta coesão
- Baixo acoplamento
...
Design Patterns = catálogo de boas idéias para solução de problemas recorrentes em OO.

Mais importante que saber o Pattern é entender a motivação de sua existencia:
- qual é o problema :: quando faz sentido
- solução possível :: design pattern  (onde deve ser aplicado)


Design Patter Strategy

https://sourcemaking.com/design_patterns/strategy


Quando utilizar ?
O padrão Strategy é muito útil quando temos um conjunto de algoritmos similares, e precisamos alternar entre eles em diferentes pedaços da aplicação. No exemplo do vídeo, temos diferentes maneiras de calcular o imposto, e precisamos alternar entre elas.

O Strategy nos oferece uma maneira flexível para escrever diversos algoritmos diferentes, e de passar esses algoritmos para classes clientes que precisam deles. Esses clientes desconhecem qual é o algoritmo "real" que está sendo executado, e apenas mandam o algoritmo rodar. Isso faz com que o código da classe cliente fique bastante desacoplado das implementações concretas de algoritmos, possibilitando assim com que esse cliente consiga trabalhar com N diferentes algoritmos sem precisar alterar o seu código.

