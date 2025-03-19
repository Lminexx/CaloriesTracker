# User Calorie Tracker API

## Описание проекта

User Calorie Tracker API - это RESTful API для управления пользователями, их рационом и подсчётом калорий. API позволяет создавать пользователей, добавлять блюда, логировать потребление пищи, а также получать отчёты о калориях.

## Стек технологий

- Java 17  
- Spring Boot  
- Spring Validation  
- Hibernate  
- PostgreSQL
- Maven  

## Запуск проекта

### 1. Клонирование репозитория  

git clone git@github.com:Lminexx/CaloriesTracker.git

### 2. Сборка проекта
mvn clean install

### 2. Сборка проекта
mvn spring-boot:run

## Api эндпоинты

#### Пользователи
- POST /users - создание пользователя
- GET /users - получение списка пользователей
- GET /users/check/calories/{userId} - проверка статуса калорий
- GET /users/history/{userId} - история приёмов пищи

#### Блюда и приёмы пищи
- POST /users/dish - добавление блюда
- POST /users/food - добавление приёма пищи








