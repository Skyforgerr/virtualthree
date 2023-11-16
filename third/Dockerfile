# Используем официальный образ OpenJDK 11
FROM openjdk:17 as build

# Установка рабочей директории
WORKDIR /app

# Копируем файлы с зависимостями для улучшения кэширования
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Копируем и собираем приложение
COPY src src
RUN ./mvnw install -DskipTests

# Вторая стадия - сборка JAR
FROM openjdk:17-jre-slim
WORKDIR /app
COPY --from=build /app/target/third.jar app.jar

# Устанавливаем переменную окружения для порта СУБД PostgreSQL
ENV DB_PORT=5432

# Добавляем метаданные LABEL
LABEL maintainer="Рослов Павел и Постников Иван ИКБО-24-20" \
    description="Spring Boot App with PostgreSQL" \
    version="1.0"

# Копируем файл с фото герба РТУ МИРЭА
RUN wget https://www.mirea.ru/upload/medialibrary/80f/MIREA_Gerb_Colour.png -O /app/mirea.png

# Экспортируем порт, на котором будет работать приложение
EXPOSE 8080

# Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]
