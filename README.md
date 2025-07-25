# Тестовый фреймворк. UI & API test automation

### [Todoist]("https://todoist.com/") 
#### Планировщик задач. Создан для управления задачами, проектами, временем, работе в команде

---
> UI- и API-фреймворк на Java для автоматизированного тестирования функциональности регистрации, авторизации, 
> восстановления пароля и поиска в системе todoist.com. 
> Проект разделён на модули для поддержания архитектуры.

---
## Стек технологий и инструментов:
![alt text](docs/tools.png)
- Java 11+ 
- Selenium WebDriver
- TestNG 
- REST Assured 
- Faker 
- WebDriverManager
- Maven
- Properties (Config.properties)
- Postman
- DevTools

---

## UI Тестовые сценарии:
### Стартовая страница: 
- Переход на страницу авторизации
- Переход на страницу регистрации

### Страница регистрации:
- Успешная регистрация c валидными данными
- Email уже используется в приложении
- Валидация пустых полей

### Страница авторизации:
- Вход с валидными данными
- Использование невалидного емейла
- Валидный емейл и невалидный пароль
- Отправка формы с пустыми полями

```java
@Test
public void testValidEmailInvalidPassword() {
loginPage.login(Config.getValidEmail(), generatePassword(8,12));
Assert.assertEquals(errorMessage.getText(), "Wrong email or password.");
}
```
---

## API Тестовые сценарии:
- Вход с валидными данными
- Использование невалидного емейла
- Валидный емейл и невалидный пароль
- Пустые поля
- Запрос на восстановление пароля с валидным емейлом
- Запрос на восстановление пароля с невалидным емейлом
- Ипользование поля поиска в Help Center модуле

```java
@Test
public void testInvalidEmailFormat() {
given()
.body(new LoginPageAPI(invalidEmail, password))
.post(LOGIN_ENDPOINT)
.then()
.statusCode(400)
.body("error", equalTo("Email is invalid"));
}
```

---
## Генерация данных

1) Все чувствительные данные хранятся в Config.properties

2) Email и пароли генерируются через Faker:
- generateValidEmail()
- generateInvalidEmail()
- generatePassword()

---

### Irina Evminova
