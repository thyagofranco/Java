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