# Client System
Repositório do Projeto do backend de TJW 

## Sobre
O sistema proposto a ser desenvolvido se trata de um sistema interno de uma empresa de gerenciamento de lojas, onde seriam registrado as lojas, clientes, entradas, cidades das lojas, tudo isso seria registrado e gerenciado e as lojas poderiam ser vistas em um mapa, facilitando a visualização e gerenciamento das lojas.

## Requisitos
- Java 17 ou superior
- Postgresql
- Um banco com nome de ```store_db```

## Instalação
Primeiramente utilize o comando
```
git clone https://github.com/joselisboaa/StoreMappingBackend.git
```
para poder clonar o projeto localmente

Após isso, crie um banco no pgAdmin4 (ou no postgresql via CLI) chamado ```store_db``` e execute o comando:
```
 sudo -u postgres psql store_db < insert.sql
```
Se estiver no Linux

Caso esteja em outro SO será necessário fazer os inserts manualmente (estará um exemplo dos inserts no final do arquivo), ou a aplicação terá problemas na execução.

Utilize alguma IDE e abra o projeto na sua IDE de preferência, após isso basta iniciar a aplicação.

### Modelagem do banco de dados
![Modelo Banco de Dados](https://github.com/joselisboaa/StoreMappingBackend/assets/67613937/c71af9ba-fc59-4ed8-adb7-80f25f91f936)



INSERTS NO BANCO:

INSERT INTO account VALUES(1, 'admin', 'admin');
INSERT INTO city VALUES(1, 'Sobral');
INSERT INTO client VALUES(1, 'José Lisboa', null);
INSERT INTO customer_entry VALUES(1, 45, 29, 'Março');
INSERT INTO signature VALUES(1, 1, 1);
INSERT INTO store VALUES(1, '-3.335555', '-35.31235', 'Loja do José Lisboa', 1);
