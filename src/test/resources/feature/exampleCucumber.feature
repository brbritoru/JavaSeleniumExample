# new feature
# Tags: optional

Feature: Example Testes Cucumber

  Scenario Outline: Test cucumber Amazon
    Given that staying amazon page <site>
    When finding product <produto>
    Then page shows price is above <valorProduto>
    Examples:
      | site                       | produto             | valorProduto |
      | "http://www.amazon.com.br" | "Iphone 11 pro max" | "9.125,99"   |