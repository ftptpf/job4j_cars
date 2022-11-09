CREATE TABLE IF NOT EXISTS engines (
    id SERIAL PRIMARY KEY ,
    name TEXT UNIQUE NOT NULL
);

COMMENT ON TABLE engines IS 'Двигатель автомобиля';
COMMENT ON COLUMN engines.id IS 'Идентификатор двигателя';
COMMENT ON COLUMN engines.name IS 'Наименование двигателя';


CREATE TABLE IF NOT EXISTS brands (
    id SERIAL PRIMARY KEY ,
    name TEXT UNIQUE NOT NULL
);

COMMENT ON TABLE brands IS 'Марка автомобиля';
COMMENT ON COLUMN brands.id IS 'Идентификатор марки автомобиля';
COMMENT ON COLUMN brands.name IS 'Наименование марки автомобиля';

CREATE TABLE IF NOT EXISTS bodies (
    id SERIAL PRIMARY KEY ,
    name TEXT UNIQUE NOT NULL
);

COMMENT ON TABLE bodies IS 'Кузов автомобиля';
COMMENT ON COLUMN bodies.id IS 'Идентификатор кузова автомобиля';
COMMENT ON COLUMN bodies.name IS 'Наименование кузова автомобиля';

CREATE TABLE IF NOT EXISTS cars (
    id SERIAL PRIMARY KEY ,
    car_year INTEGER ,
    kilometer INTEGER ,
    photo BYTEA ,
    engine_id INT NOT NULL UNIQUE REFERENCES engines(id) ,
    brand_id INT NOT NULL UNIQUE REFERENCES brands(id),
    body_id INT NOT NULL UNIQUE REFERENCES bodies(id)
);

COMMENT ON TABLE cars IS 'Автомобили';
COMMENT ON COLUMN cars.id IS 'Идентификатор автомобиля';
COMMENT ON COLUMN cars.car_year IS 'Год выпуска автомобиля';
COMMENT ON COLUMN cars.kilometer IS 'Пробег автомобиля';
COMMENT ON COLUMN cars.photo IS 'Фотография автомобиля';
COMMENT ON COLUMN cars.engine_id IS 'Двигатель автомобиля';
COMMENT ON COLUMN cars.brand_id IS 'Марка автомобиля';
COMMENT ON COLUMN cars.body_id IS 'Кузова автомобиля';

