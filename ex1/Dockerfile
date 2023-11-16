# Используем базовый образ
FROM ubuntu:latest

# Устанавливаем необходимые пакеты
RUN apt-get update && \
    apt-get install -y nginx

# Добавляем метаданные к образу
LABEL maintainer="yourname@example.com"

# Устанавливаем переменные окружения
ENV NGINX_VERSION=1.21.3 \
    PATH=/usr/local/nginx/bin:$PATH

# Копируем конфигурацию Nginx
COPY nginx.conf /etc/nginx/nginx.conf

# Добавляем файлы и директории в образ
ADD index.html /var/www/html/
ADD additional_files/ /var/www/

# Выставляем порт
EXPOSE 80

# Устанавливаем рабочую директорию
WORKDIR /var/www/html

# Задаем команду по умолчанию
CMD ["nginx", "-g", "daemon off;"]

# Устанавливаем точку входа
ENTRYPOINT ["/usr/local/nginx/bin/nginx", "-c", "/etc/nginx/nginx.conf"]

# Создаем том
VOLUME /var/www/html/data

# Устанавливаем пользователя
USER nginx

# Определяем директиву ONBUILD
ONBUILD ADD . /app/src
ONBUILD RUN /usr/local/bin/build.sh