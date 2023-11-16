# Используйте официальный образ Maven в качестве базового образа
FROM maven:3.8.4-openjdk-11 AS builder

# Копируем файлы с описанием зависимостей проекта (pom.xml) в контейнер
COPY pom.xml .

# Загружаем зависимости Maven в контейнер
RUN mvn dependency:go-offline -B

# Копируем исходный код приложения в контейнер
COPY src ./src

# Собираем JAR-файл с помощью Maven
RUN mvn package

# Создаем финальный образ на основе образа с JAR-файлом
FROM openjdk:11-jre-slim

# Копируем JAR-файл из образа сборки в финальный образ
COPY --from=builder /target/my-app.jar /app.jar

# Указываем команду для запуска приложения при запуске контейнера
CMD ["java", "-jar", "/app.jar"]