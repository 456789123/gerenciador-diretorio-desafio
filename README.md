# Implementar um mini sistema de arquivos virtuais

O sistema deverá permitir operar sobre diretórios e arquivos através de uma API REST, além de exibir uma listagem de diretórios em um frontend básico.
Com anunciado, abaixo podemos ver como está a interface para a visualização de pastas e arquivos em sua estrutura.

![Imagem_1](https://github.com/user-attachments/assets/a32f7c46-bc11-4d56-8970-fb933ce44248)

O sistema inicia com cada pasta fechada e quando o usuário clica sobre cada pasta, ela se abre mostrando o seu repectivo conteúdo respeitando assim, sua estrutura.
Fora usado o Angular em sua versão 17.3.0 para o frontend rodando assim, na porta 4200.
Para o backend, fora implementado com o Java em sua versão JDK-17 e usando o framework Sringboot em sua versão 3.2.10.
Fora implementado os testes unitários usando Junit para o backend como pode ver rodando quando usamos o seguinte comando:
"mvn clean install".
Para o frontend fora adicionado também os testes unitários usando o seguinte comando:
"ng test" ou "npm rum test".
O banco de dados que está sendo usado é o PostGresSQL.
Ao entrar dentro do diretório "maneger-files" que é o nosso servidor Java, podemos ver em sua raiz, o script sql "controle_diretorios.sql".
Ele irá cria nosso banco de dados para simular a estrutura de diretórios.
Nosso servidor Java está sendo rodado na porta 8080 e tem todas as sua configurações no arquivo "application.yml".
Na minha opinião, eu não vejo sentido em usar uma estrutura de diretórios em um banco de dados, assim sendo, fora implementado também uma funcionalidade que irá refletir uma estrutura de diretórios real como se fosse um "Storage" de arquivos que irá se encontar no computado que irá hospedar nosso servidor Java onde irá fazer o upload de arquivos de imagem, vídeos, audios, etc.
De qualquer forma, estará funcionando para um banco de dados assim como para uma pasta de arquivos normal.
No arquivo  "application.yml", podemos ver a configuração de apontamento para um diretório qualquer no computador hospedeiro como também a configuração do banco de dados como mostra na imagem abaixo.

![configuracao](https://github.com/user-attachments/assets/0b12ddb9-916b-486b-98c0-086cbefd0166)

Pode configurar o apontamento para o diretório desejado na linha 13 como mostrado na imagem.
E a configuração do banco de dados na linha 25 em diante.

# Rodando a aplicação

Assim que fazer o clone desse mesmo repositório, primeiramente deve pegar o arquivo "controle_diretorios.sql" e executado para montar o banco de dados.
Logo depois, podemos digitar o "mvn clean install" para baixar as dependências para o servidor Java e assim executar o comando "mvn spring-boot:run" para executar nosso servidor de aplicação.
Para o frontend, projeto Angular, podemos digitar primeiramente o comando "npm install" para baixar as denpêndecias e logo depois, executar o comando "ng server".
Fora implementado todas as configurações para que não ocorra o bloqueio de "CORS-Origin" na classe "CorsConfig".
Na imagem abaixo do arquivo "application.yml" também mostra o apontamento da aplicação Angular para que seja de fácil configuração em outros ambientes como homologação e produção.

 ![Screenshot 2024-10-01 015007](https://github.com/user-attachments/assets/80b19c12-9e98-4ef7-b83a-46b79cae1602)

 Fora feito testes unitários em ambos servidores e configurado o Dockerfile em ambas as aplicaões.

Agradeço muito o interesse e tempo para com a minha pessoa e desde já agradeço a atenção.
Atenciosamente, Christiano Reis.


 
