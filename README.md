
# Sistema de Validação de Endereços

O desafio proposto foi criar um programa executável capaz de receber um endereço e separar o número do nome da rua/avenida.

### Exemplo:

**Input:** "Rua Miritiba, 36"  
**Output:** ["Rua Miritiba", "36"]

O programa também deverá receber padrões de outros países e exibir a mesma formatação.

### Exemplo:
**Input:** "4, Rue de la Republique"  
**Output:** ["Rue de la Republique", "4"]

O programa também deve funcionar em situações mais complexas, como:  
**"Rua Miritiba, 36B"** e **"Calle 44 No 1991"**

# Tecnologias utilizadas:

- Java JDK 17.0.5
- Intellij IDE (Criação do algoritmo) & Eclipse IDE (Utilizada na compilação)

A linguagem Java foi escolhida para este desafio, pois o mesmo código funcionará em vários sistemas operacionais diferentes.

# Lógica do Código:

A aplicação foi separada em três partes:

- **`Main Class`**:
    - Responsável por possibilitar o usuário executar a classe **`TestCases`** e **`AddressValidator`** através de uma tela interativa.
- **`TestCases Class`**:
    - Responsável por executar uma lista de testes, demonstrando as funcionalidades da classe **`AddressValidator`**.
- **`AddressValidator Class`**: 
    - Responsável pela separação do nome/número do endereço.

# Autor:

### Gabriel Vieira

<div>
<a href="https://www.linkedin.com/in/vieirafront-end/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> 
    <a href = "mailto:gabrielvieiranovaes5@gmail.com"><img src="https://img.shields.io/badge/-Gmail-C20C00?style=for-the-badge&logo=gmail&logoColor=white&" target="_blank"></a>
</div>
