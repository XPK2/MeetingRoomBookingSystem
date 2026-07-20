# Spring Boot Core (skeleton)

A bare technical skeleton for interns to build on. No business logic — just the
layered structure, a PostgreSQL connection, a security config stub, Swagger, and
global exception handling.

## Layers / folders

```
org.example
├── MeetingRoomBookingApplication      # entry point
├── domain/                            # PURE Java, no framework
│   ├── model/                         #   (empty) put your domain models here
│   └── repository/
│       └── Repository.java            #   generic CRUD contract Repository<ID,T>
├── application/
│   ├── service/                       #   (empty) put your use-case services here
│   └── exception/                     #   NotFoundException, ForbiddenException
├── infrastructure/persistence/
│   ├── entity/                        #   (empty) @Entity JPA classes
│   ├── jpa/                           #   (empty) Spring Data JpaRepository interfaces
│   ├── mapper/                        #   (empty) entity <-> domain mappers
│   └── adapter/                       #   (empty) implement domain repositories over JPA
├── config/
│   ├── SecurityConfig.java            # security stub (everything open — add auth here)
│   └── OpenApiConfig.java             # Swagger metadata
└── api/
    ├── controller/                    # PingController (demo — replace it)
    ├── dto/                           #   (empty) request/response records
    └── exception/                     # GlobalExceptionHandler (RFC-7807 ProblemDetail)
```

The domain layer stays framework-free on purpose: JPA belongs in `infrastructure`,
and adapters map between the two.

## Run

1. Have PostgreSQL running and create the database:
   ```sql
   CREATE DATABASE meeting_room;
   ```
   Defaults: `localhost:5432`, `postgres`/`postgres`. Override via `DB_URL` /
   `DB_USERNAME` / `DB_PASSWORD`.

2. Start the app:
   ```
   mvn spring-boot:run
   ```
   Tables auto-create (`ddl-auto=update`). Smoke test: `GET http://localhost:8080/api/ping`.

3. Tests (in-memory H2, no DB needed):
   ```
   mvn test
   ```

## Swagger / OpenAPI

- UI: http://localhost:8080/swagger-ui.html
- Spec: http://localhost:8080/v3/api-docs

## Where to start (intern)

1. Add a domain model in `domain/model` + a repository contract in `domain/repository`.
2. Add the JPA `entity` + `jpa` repo + `mapper` + `adapter` for it.
3. Add a `service` and a REST `controller` + `dto`.
4. Add real auth in `SecurityConfig` (UserDetailsService, login, token filter),
   then lock down routes with `.anyRequest().authenticated()`.
