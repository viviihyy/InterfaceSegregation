# Atividade 4 — Princípio da Segregação de Interfaces (ISP)

> **Unidade Curricular:** Arquitetura de Sistemas  
> **Professor:** Lucas Santos  
> **Tema:** Refatoração para o Princípio da Segregação de Interfaces (ISP)

---

## 📖 Contexto

A **TechStore** possuía uma interface monolítica chamada `GerenciadorDeClientes`, que agrupava todas as operações possíveis de um cliente: cadastro, comunicação e fidelidade.

Isso causava um problema clássico de design: classes concretas eram forçadas a implementar métodos que não precisavam, violando o **ISP — Interface Segregation Principle**.

---

## ❌ O Problema: Violação do ISP

Antes da refatoração, todos os métodos de implementação estavam concentrado em uma única interface. Isso obrigava o `ClienteComumService` a implementar métodos como `enviarNotificacao` e `aplicarDescontoVIP`, que não fazem sentido para um cliente comum.

Resultado: os métodos eram implementados apenas para lançar `UnsupportedOperationException`, o que é um sinal claro de violação do princípio.

> *"Clientes não devem ser forçados a depender de interfaces que não utilizam."*  
> — Robert C. Martin

---

## ✅ A Solução: Segregação de Interfaces

A interface monolítica foi quebrada em **três interfaces menores e coesas**, cada uma com uma responsabilidade bem definida:

| Interface | Responsabilidade |
|---|---|
| `ICadastroCliente` | `cadastrarCliente()` e `buscarClientePorEmail()` |
| `INotificador` | `enviarNotificacao()` |
| `IGerenciadorFidelidade` | `aplicarDescontoVIP()` |

Com isso, cada classe implementa **apenas o que realmente precisa**:

- **`ClienteComumService`** → implementa somente `ICadastroCliente`
- **`ClienteVIPService`** → implementa `ICadastroCliente`, `INotificador` e `IGerenciadorFidelidade`

---

## 🗂️ Estrutura do Projeto

```
InterfaceSegregation/
└── src/
    ├── domain/
    │   └── Cliente.java
    ├── interfaces/
    │   ├── ICadastroCliente.java
    │   ├── INotificador.java
    │   └── IGerenciadorFidelidade.java
    ├── service/
    │   ├── ClienteComumService.java
    │   └── ClienteVIPService.java
    └── Main.java
```

---

## ▶️ Como Executar

1. Clone o repositório
2. Abra o projeto em uma IDE Java (ex: IntelliJ IDEA)
3. Execute a classe `Main.java`

### Saída esperada:

```
===== CLIENTE COMUM =====
CLIENTE COMUM CADASTRADO COMO: Luisa
CLIENTE COMUM ENCONTRADO: lulu@gmail.com

===== CLIENTE VIP =====
CLIENTE VIP CADASTRADO COMO: Gabrielli
CLIENTE VIP ENCONTRADO: gabi@gmail.com
NOTIFICAÇÃO ENVIADA PARA: gabi@gmail.com - Promoção especial!
VIP APLICANDO 20.0% DE DESCONTO PARA gabi@gmail.com
```

---

## 📚 Conceito Aplicado

O **Princípio da Segregação de Interfaces (ISP)** faz parte dos princípios **SOLID** e diz que interfaces devem ser pequenas e focadas, evitando que uma classe seja obrigada a depender de métodos que não utiliza. A solução adotada garante maior coesão, menor acoplamento e facilita a manutenção e extensão do sistema.
