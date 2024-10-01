# Comece com uma imagem base contendo o ambiente de execução Java
FROM openjdk:8-jdk-alpine

# Adicione informações do mantenedor
LABEL maintainer="seu-email@example.com"

# Torne a porta 8080 disponível para o mundo fora deste contêiner
EXPOSE 8080

# O arquivo jar do aplicativo
ARG JAR_FILE=target/*.jar

# Adicione o jar do aplicativo ao contêiner
ADD ${JAR_FILE} app.jar

# Execute o arquivo jar
ENTRYPOINT ["java","-jar","/app.jar"]


