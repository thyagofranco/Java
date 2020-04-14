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


Strategy (Behavioral patterns)
------------------------
https://sourcemaking.com/design_patterns/strategy


Quando utilizar ?
O padrão Strategy é muito útil quando temos um conjunto de algoritmos similares, e precisamos alternar entre eles em diferentes pedaços da aplicação. No exemplo do vídeo, temos diferentes maneiras de calcular o imposto, e precisamos alternar entre elas.

O Strategy nos oferece uma maneira flexível para escrever diversos algoritmos diferentes, e de passar esses algoritmos para classes clientes que precisam deles. Esses clientes desconhecem qual é o algoritmo "real" que está sendo executado, e apenas mandam o algoritmo rodar. Isso faz com que o código da classe cliente fique bastante desacoplado das implementações concretas de algoritmos, possibilitando assim com que esse cliente consiga trabalhar com N diferentes algoritmos sem precisar alterar o seu código.


Chain of Responsability (Behavioral patterns)
----------------------

https://sourcemaking.com/design_patterns/chain_of_responsibility

O padrão Chain of Responsibility cai como uma luva quando temos uma lista de comandos a serem executados de acordo com algum cenário em específico, e sabemos também qual o próximo cenário que deve ser validado, caso o anterior não satisfaça a condição.

Nesses casos, o Chain of Responsibility nos possibilita a separação de responsabilidades em classes pequenas e enxutas, e ainda provê uma maneira flexível e desacoplada de juntar esses comportamentos novamente.


Template Method (Behavioral patterns)
---------------

https://sourcemaking.com/design_patterns/template_method

Relatórios são muito parecidos: todos eles contêm cabeçalho, corpo, e rodapé. Existem dois tipos de relatórios: simples e complexos.

As diferenças são sutis: relatórios simples possuem cabeçalhos e rodapés de uma linha, apenas com o nome do banco e telefone, respectivamente; relatórios complexos possuem cabeçalhos que informam o nome do banco, endereço, telefone, e rodapés que informam e-mail, e a data atual.

Além disso, dada uma lista de contas, um relatório simples apenas imprime titular e saldo da conta. O relatório complexo exibe titular, agência, número da conta e saldo.

Use Template Method, e implemente o mecanismo de relatórios. Use dados falsos para os dados do banco.

Quando temos diferentes algoritmos que possuem estruturas parecidas, o Template Method é uma boa solução. Com ele, conseguimos definir, em um nível mais macro, a estrutura do algoritmo e deixar "buracos", que serão implementados de maneira diferente por cada uma das implementações específicas.

Dessa forma, reutilizamos ao invés de repetirmos código, e facilitamos possíveis evoluções, tanto do algoritmo em sua estrutura macro, quanto dos detalhes do algoritmo, já que cada classe tem sua responsabilidade bem separada.


Decorator (Structural patterns)
----------

https://sourcemaking.com/design_patterns/decorator

Adiciona objetos para formar um objeto mais complexo que tem o comportamento combinado. (Justa os comportamentos separados)

Sempre que percebemos que temos comportamentos que podem ser compostos por comportamentos de outras classes envolvidas em uma mesma hierarquia, como foi o caso dos impostos, que podem ser composto por outros impostos. O Decorator introduz a flexibilidade na composição desses comportamentos, bastando escolher no momento da instanciação, quais instancias serão utilizadas para realizar o trabalho.


State (Behavioral patterns)

https://sourcemaking.com/design_patterns/state

Quando temos um objeto cujas ações variam de acordo com um estado interno, podemos separar esses estados em classes. O Objeto então comtém um estado e apenas repassa suas ações para ele define o comportamento a ser executado e as possíveis transições entre estados.  