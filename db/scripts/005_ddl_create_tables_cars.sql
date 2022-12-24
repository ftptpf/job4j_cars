CREATE TABLE IF NOT EXISTS cars (
    id SERIAL PRIMARY KEY ,
    car_year INTEGER ,
    kilometer INTEGER ,
    engine_id INT NOT NULL REFERENCES engines(id) ,
    brand_id INT NOT NULL REFERENCES brands(id),
    body_id INT NOT NULL REFERENCES bodies(id)
);

COMMENT ON TABLE cars IS 'Автомобили';
COMMENT ON COLUMN cars.id IS 'Идентификатор автомобиля';
COMMENT ON COLUMN cars.car_year IS 'Год выпуска автомобиля';
COMMENT ON COLUMN cars.kilometer IS 'Пробег автомобиля';
COMMENT ON COLUMN cars.engine_id IS 'Двигатель автомобиля';
COMMENT ON COLUMN cars.brand_id IS 'Марка автомобиля';
COMMENT ON COLUMN cars.body_id IS 'Кузова автомобиля';
