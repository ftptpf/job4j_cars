# job4j_cars
[![Build Status](https://app.travis-ci.com/ftptpf/job4j_cars.svg?branch=master)](https://app.travis-ci.com/ftptpf/job4j_cars)

## Проект "Площадка по продаже автомобилей"

На первой странице представлены все объявления в формате таблицы. 
Есть возможность фильтрации объявлений по заранее определенным параметрам.
Можно зайти в конкретное объявление и посмотреть детальную информацию о продаваемом автомобиле.
Для добавления объявлений - на сайте необходимо зарегистрироваться.
Для просмотра объявлений - регистрация не нужна.

### Стек технологии

В проекте используется:
- Java 17
- Spring boot 2.7
- Hibernate 5.6
- PostgreSQL 14
- H2 database 2.1
- Liquibase 4.18
- Thymeleaf 3
- Bootstrap 5
- Maven 3.8
- Junit 5
- Assertj 3.23

### Требования к окружению

Для запуска проекта вам необходимо установить:
- Java 17
- PostgreSQL 14
- Maven 3.8

### Запуск проекта

Запустите SQL shell(psql) из пакета PostgreSQL.
Создайте базу данных проекта "cars_sale_db" выполнив команду
```create database cars_sale_db;```

Запустите ваш терминал с командной строкой (например для Windows это программа cmd)
перейдите в папку с вашим проектом и запустите проект командой
```mvn spring-boot:run```

После запуска, для начала работы с "Площадкой по продаже автомобилей" - зайдите в браузер и перейдите по ссылке http://localhost:8080/index

### Взаимодействие с приложением

![Alt-текст](https://github.com/ftptpf/job4j_cars/blob/master/images/screenshots/1.JPG "Сайт по продаже автомобилей")

Для начала работы необходимо зарегистрироваться и авторизоваться.

![Alt-текст](https://github.com/ftptpf/job4j_cars/blob/master/images/screenshots/2.JPG "Регистрация")

![Alt-текст](https://github.com/ftptpf/job4j_cars/blob/master/images/screenshots/3.JPG "Авторизация")

Можно добавить объявление о продаже автомобиля.

![Alt-текст](https://github.com/ftptpf/job4j_cars/blob/master/images/screenshots/4.JPG "Добавление объявления")

После того как мы нажмем кнопку "Добавить объявление" мы попадем на форму где сможем:
- создать подробное описание
- загрузить фото
- назначить цену
- указать год выпуска
- указать пробег
- выбрать из выпадающих списков основные технические параметры автомобиля

![Alt-текст](https://github.com/ftptpf/job4j_cars/blob/master/images/screenshots/5.JPG "Форма объявления")

Только пользователь, который создал объявление, имеет возможность снять свой автомобиль с продажи изменив статус с "Актуально" на "Продано"

![Alt-текст](https://github.com/ftptpf/job4j_cars/blob/master/images/screenshots/6.JPG "Подробная информация о автомобиле")

На сайте предусмотрен фильтр который позволяет выбрать авто:
- все
- в продаже
- проданы
- новые объявления

![Alt-текст](https://github.com/ftptpf/job4j_cars/blob/master/images/screenshots/7.JPG "Фильтр")

### Контакты
Telegram @webdigg