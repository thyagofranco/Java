# Alura TDD

Software sempre mudam!

Teste manuais são caros e demoram para ser executados.

Teste automatizado é um programa que testa nosso programa. 

Teste manuais e automatizados tem 3 etapas:
Criação do cenário a ser testado:
Ação que realiza o teste:
Validação:

O Junit nos ajuda na parte de validação dos resultados. 
os métodos de uma classe de teste devem ser anotados com @Test,
devem ser public void nomeDoTeste() e não receber argumentos.

O nome dos métodos de testes devem ser expressivos e explicar o teste.

Vantagens dos testes automaticos de unidade:
Executam rapidamente, em milisegundos.
É preciso e sempre executará da mesma forma.
Após escrito, o custo para execução é muito baixo. 

Um ponto muito comum, levantado por estudantes que estão aprendendo testes automatizados, é: "hoje eu escrevo 100 linhas por dia; com testes, escreverei 50 linhas de código de produção e 50 linhas de código de testes. Ou seja, serei mais improdutivo".

Depende da sua definição de produtividade. Se produtividade significa linhas de código de produção escritas por dia, talvez você seja menos produtivo. Agora, se sua definição é algo como "linhas de código escritas com qualidade", então, muito provavelmente, você será mais produtivo com testes.

É difícil garantir qualidade de um sistema sem testes automatizados, por todos os motivos já citados ao longo deste capítulo.

Além disso, alguns estudos mostram que programadores que escrevem testes, a longo prazo, são mais produtivos do que os que não escrevem e até gastam menos tempo depurando o código! Isso faz sentido: imagine um desenvolvedor que testa manualmente. Quantas vezes por dia ele executa o MESMO teste? O programador que automatiza o teste gasta seu tempo apenas 1 vez: escrevendo-o. Depois, executar o teste é rápido e barato. Ou seja, ao longo do tempo, escrever testes automatizados vai fazer você economizar tempo.


Quais testes devemos escrever e quais não fazem sentido serem escritos? 
Escrever testes para todas as entradas possíveis é impossível e muito caro. 

Regra: escrever um teste por classe de equivalência, não repetir teste similares. 

A qualidade do seu código de testes, deve ser tão boa quando o seu código de produção.


Muitas vezes ao implementarmos novas funcionalidades acabamos desenvolvendo de forma correta a nova funcionalidade, contudo ela quebra uma funcionalidade anterior, por isso testes de regressão são importante, rodar a bateria complete de destes para verificar não se somente as novas funcionalidades passam, mas também se as novas funcionalidades não quebram as antigas. 

Quanto mais testes, mais segurança em modificar o código. 

Desenvolvedores que estão aprendendo a testar geralmente sentem dificuldades no momento de levantar e escrever cenários para o teste.

Lembre-se que um teste automatizado é muito parecido com um teste manual. Do mesmo jeito que você pensa no cenário de um teste manual (por exemplo, visitar a página de cadastro, preencher o campo CPF com "123", clicar no botão, e etc), você faz no automatizado.

Foque-se na classe que você está testando. Pense sobre o que você espera dela. Como ela deve funcionar? Se você passar tais parâmetros para ela, como ela deve reagir?

TDD oferece excelentes momentos para refatorar o código, pois a bateria de testes da confiança para o desenvolvedor realizar as alterações, garantindo o comportamento. 

Ciclo TDD - Test Driven Development 

Robert C. Martin (Uncle Bob)
You must write a failing test before you write any production code.
You must not write more of a test than is sufficient to fail, or fail to compile.
You must not write more production code than is sufficient to make the currently failing test pass.

O termo dado para a ideia de dar sempre passos pequenos e escrever código simples o tempo todo é conhecido por baby steps.

TDD faz muito sentido ao implementar novas funcionalidades, ao corrigir bugs, ao trabalhar em códigos complexos, etc.

Mas às vezes não precisamos seguir o fluxo ideal da prática de TDD. Por exemplo, às vezes queremos só escrever um conjunto de testes que faltaram para determinada funcionalidade. Nesse momento, não faríamos TDD, mas sim escreveríamos testes.

Em códigos extremamente simples, talvez a prática de TDD não seja necessária. Mas lembre-se: cuidado para não achar que "tudo é simples", e nunca praticar TDD.

Devemos sempre nos preocupar com a repetição em nossas classes de teste. Um bom patter a ser utilizardo é o Builder
onde podemos criar Test Data Builders para criar nossos cenários de teste, e se caso algo mude, podemos apenas alterar essa classe utilitária, ao invés de recriar manualmente todos os casos teste por teste. Isso diminui o acoplamento.

Codigo de teste simples = mais facil de evoluir.