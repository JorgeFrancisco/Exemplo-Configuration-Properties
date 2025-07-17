## 📘 Uso de `@ConfigurationProperties` no Spring Boot

### ✅ Por que usar `@ConfigurationProperties`?

`@ConfigurationProperties` é uma forma poderosa, segura e organizada de carregar configurações da aplicação, seja a partir de `application.yml`, `application.properties`, ou via Spring Cloud Config.

Ela permite mapear propriedades externas para **objetos fortemente tipados**, com suporte a validação, estruturas complexas e legibilidade superior.

---

## 🚀 Vantagens sobre `@Value`

| Característica                             | `@ConfigurationProperties` | `@Value` |
| ------------------------------------------ | -------------------------- | -------- |
| ✅ Agrupamento de propriedades              | Sim                        | Não      |
| ✅ Suporte a listas e objetos aninhados     | Sim                        | Não      |
| ✅ Validação automática (`@Validated`)      | Sim                        | Parcial  |
| ✅ Tipo seguro (type-safe)                  | Sim                        | Parcial  |
| ✅ Menos duplicação (boilerplate reduzido)  | Sim                        | Não      |
| ✅ Melhor testabilidade e injeção como bean | Sim                        | Limitado |
| ✅ Integração com Spring Cloud Config       | Sim                        | Sim      |

---

## 🧹 Exemplos

### application.yml

```yaml
app:
  name: Meu Sistema
  max-users: 100
  features:
    - login
    - cadastro
    - relatorio
```

### Classe de configuração com record

```java
@ConfigurationProperties(prefix = "app")
@Validated
public record AppProperties(
    @NotBlank String name,
    @Min(1) int maxUsers,
    @NotEmpty List<String> features
) {}
```

### Ativando no Spring Boot

```java
@SpringBootApplication
@ConfigurationPropertiesScan(basePackageClasses = AppProperties.class)
public class MinhaAplicacao {
    public static void main(String[] args) {
        SpringApplication.run(MinhaAplicacao.class, args);
    }
}
```

---

## 💡 Boas práticas

- Prefira `record` (Java 17+) para imutabilidade e clareza.
- Use `@ConfigurationPropertiesScan` com `basePackageClasses` para evitar erros de pacote.
- Combine com `@Validated` e `jakarta.validation.constraints` para validar os dados automaticamente.
- Em apps com Spring Cloud Config, combine com `@RefreshScope` se quiser recarregar configs sem restart.

---

## 🥪 Testabilidade

Você pode instanciar facilmente a config em testes:

```java
AppProperties config = new AppProperties("Teste", 50, List.of("a", "b"));
```

---

## 🏁 Conclusão

Use `@ConfigurationProperties` sempre que precisar:

- Agrupar configurações relacionadas;
- Ler listas, mapas ou objetos complexos;
- Validar e proteger propriedades obrigatórias;
- Tornar seu código mais legível, testável e moderno.

