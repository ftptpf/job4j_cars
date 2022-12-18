# job4j_cars
[![Build Status](https://app.travis-ci.com/ftptpf/job4j_cars.svg?branch=master)](https://app.travis-ci.com/ftptpf/job4j_cars)

## Проект "Площадка по продаже автомобилей"

Сайт по продаже автомобилей.

Используемые технологии:
Spring boot, Thymeleaf, Bootstrap, Hibernate, PostgreSql, H2, Liquibase
Сборка: Maven

### Скриншоты web интерфейса.

![Alt-текст](https://github.com/ftptpf/job4j_cars/blob/master/src/main/resources/images/1.JPG "Сайт по продаже автомобилей")

Для начала работы необходимо зарегистрироваться и авторизоваться.

![Alt-текст](https://github.com/ftptpf/job4j_cars/blob/master/src/main/resources/images/2.JPG "Регистрация")

![Alt-текст](https://github.com/ftptpf/job4j_cars/blob/master/src/main/resources/images/3.JPG "Авторизация")

Можно добавить объявление о продаже автомобиля.

![Alt-текст](https://github.com/ftptpf/job4j_cars/blob/master/src/main/resources/images/4.JPG "Добавление объявления")

После того как мы нажмем кнопку "Добавить объявление" мы попадем на форму где сможем:
- создать подробное описание
- загрузить фото
- назначить цену
- указать год выпуска
- указать пробег
- выбрать из выпадающих списков основные технические параметры автомобиля

![Alt-текст](https://github.com/ftptpf/job4j_cars/blob/master/src/main/resources/images/5.JPG "Форма объявления")

Только пользователь, который создал объявление, имеет возможность снять свой автомобиль с продажи изменив статус с "Актуально" на "Продано"

![Alt-текст](https://github.com/ftptpf/job4j_cars/blob/master/src/main/resources/images/6.JPG "Подробная информация о автомобиле")

На сайте предусмотрен фильтр который позволяет выбрать авто:
- все
- в продаже
- проданы
- новые объявления

![Alt-текст](https://github.com/ftptpf/job4j_cars/blob/master/src/main/resources/images/7.JPG "Фильтр")

### Запуск проекта.

Для запуска проекта вам понадобится установить:
JAVA 17+
PostgreSQL 13+
Intellij IDEA
Настройки базы данных смотрите в файле db.properties проекта.
Импортируйте данный проект в Intellij IDEA загрузив его с github.
Запуск проекта выполните запустив метод main файла Main.java проекта.

![Alt-текст](https://github.com/ftptpf/job4j_cars/blob/master/src/main/resources/images/8.JPG "Файл Main.java")

![Alt-текст](https://github.com/ftptpf/job4j_cars/blob/master/src/main/resources/images/9.JPG "Запуск проекта")

После запуска для начала работы с "Площадкой по продаже автомобилей" перейдите по ссылке http://localhost:8080/index