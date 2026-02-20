FROM jenkins/jenkins:lts-jdk17

# Переключаемся на root, чтобы установить доп. пакеты
USER root

# Установка необходимых утилит (по желанию)
RUN apt-get update && apt-get install -y \
    curl \
    git \
    docker.io \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Добавляем пользователя jenkins в группу docker
RUN usermod -aG docker jenkins

# Возвращаемся к пользователю jenkins
USER jenkins

# Порты Jenkins
EXPOSE 8080 50000