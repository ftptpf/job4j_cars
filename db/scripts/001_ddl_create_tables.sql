CREATE TABLE IF NOT EXISTS engines (
    id SERIAL PRIMARY KEY ,
    name VARCHAR(128) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS brands (
    id SERIAL PRIMARY KEY ,
    name VARCHAR(64) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS bodies (
    id SERIAL PRIMARY KEY ,
    name VARCHAR(64) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS cars (
    id SERIAL PRIMARY KEY ,
    car_year INTEGER ,
    kilometer INTEGER ,
    photo BYTEA ,
    engine_id INT NOT NULL UNIQUE REFERENCES engines(id) ,
    brand_id INT NOT NULL UNIQUE REFERENCES brands(id),
    body_id INT NOT NULL UNIQUE REFERENCES bodies(id)
);

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY ,
    user_name VARCHAR(128) NOT NULL ,
    email VARCHAR(128) UNIQUE NOT NULL ,
    user_password VARCHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS history_owner (
    id SERIAL PRIMARY KEY ,
    user_id INT NOT NULL REFERENCES users(id) ,
    car_id INT NOT NULL REFERENCES cars(id)
);

CREATE TABLE IF NOT EXISTS posts (
    id SERIAL PRIMARY KEY ,
    description VARCHAR(256) ,
    created TIMESTAMP ,
    price INTEGER ,
    sold BOOLEAN ,
    user_id INT NOT NULL REFERENCES users(id) ,
    car_id INT NOT NULL REFERENCES cars(id)
);
