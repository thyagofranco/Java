SOLID


S - Single responsability
===========================

O princípio da responsabilidade única, a classe deve ter apenas uma responsabilidade, responsabilidade é motiva para mudança. 
Uma classe empregado, com métodos, efetuarPagamento(), salvarNoBancoDeDados(), imprimirRelatórioDeVendas(). tem no mínimo três motivos para mudança, são no mínimo três departamentos que devemos procurar para alterar a Classe, no mínimo três pessoas. Departamento Financeiro, DBA e Departamento de Vendas. 
Classes devem ter apenas um motivo para mudar, devemos depender/falar apenas com uma área/pessoa da empresa para alterar a classe.



O - Open/close principle
========================
Princípio aberto para extensões, fechado para mudanças.

Este princípio trabalha na busca de ao adicionar uma nova funcionalidade ao sistema, não alterar código existente buscando estender o código existente com inserção de código novo. Isso muitas vezes é possível se o código for pensado em interfaces e respeitando o Single Responsability.
