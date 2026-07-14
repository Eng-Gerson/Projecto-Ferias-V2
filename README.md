## Sobre 
Esse projecto foi feito no Intellij
O primeiro repositório foi feito usando NetBeans se voce usa IntelliJ copie este repositório.
O projecto tem finalidade academica. 
Algumas tabelas que estão nos ficheiros SQL não serão implementadas, o foco eram as classes principais a saber Departamento,Empregado,Projecto,Chefia e Dependente.

## Requisitos
1. IntelliJ Idea versão 2026.1.3 +
2. JDK versão 25
3. MariaDB 10.4.32
4. MySQL Server 8.0 +
5. Xampp ou MySQL Workbench

## Como utilizar?
1. Ligue o MySQL. (Se você usa xampp é só clicar em start no xampp, de contrário pode activa-lo nos serviços)
2. Execute os dois códigos .sql na pasta "MySQL", no mysql workbench ou no xampp. Começando do ficheiro "Criar tabela.sql"
3. Renomeie o "db.properties.example" para "db.properties"
4. Clique com o botão direito na pasta "lib" e selecione "Add as library..."
5. Vá para src/app e rode o Main.java

## Configurar User
Se você quer usar um user diferente do "root" sem password, vá no src/database/db.properties no ficheiro "db.properties" coloque o nome do user e a sua password.


