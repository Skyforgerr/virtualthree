# Используем официальный образ OpenJDK 17
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

# Создаем каталог для изображений
RUN mkdir -p /app/target/images

# Копируем файл с фото герба РТУ МИРЭА, используя curl
#RUN wget -o /app/target/images/MIREA_Gerb_Colour.png https://www.mirea.ru/upload/medialibrary/80f/MIREA_Gerb_Colour.png

# Вторая стадия - сборка JAR
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/ex2-0.0.1-SNAPSHOT.jar app.jar

# Устанавливаем переменную окружения для порта СУБД PostgreSQL
ENV DB_PORT=5432

# Добавляем метаданные LABEL
LABEL maintainer="Рослов Павел и Постников Иван ИКБО-24-20" \
    description="Spring Boot App with PostgreSQL" \
    version="1.0"

# Экспортируем порт, на котором будет работать приложение
EXPOSE 8080

# Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]

ONBUILD CMD echo "Сборка и запуск произведены. Авторы: Рослов Павел и Постников Иван ИКБО-24-20"

