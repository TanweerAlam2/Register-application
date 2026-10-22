# register-app

A multi-module Maven web application organized using a three-layer architecture.

## Modules

- `domain` - entities and request/response models
- `repository` - persistence abstraction and JDBC/H2 implementation
- `service` - validation and business rules
- `web` - servlet controllers and web resources

## Architecture

```text
Browser
  |
  v
Presentation layer: web module (Servlets)
  |
  v
Business layer: service module
  |
  v
Data access layer: repository module
  |
  v
H2 database
```

## Requirements

- JDK 21
- Maven 3.9+
- Tomcat 9.x or another Servlet 4 compatible container

## Build

```bash
mvn clean package
```

Deploy `web/target/register-app.war` to Tomcat's `webapps` directory and open:

```text
http://localhost:8080/register-app/
```
