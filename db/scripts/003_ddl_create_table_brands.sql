CREATE TABLE IF NOT EXISTS brands (
    id SERIAL PRIMARY KEY ,
    name TEXT UNIQUE NOT NULL
);

COMMENT ON TABLE brands IS 'Марка автомобиля';
COMMENT ON COLUMN brands.id IS 'Идентификатор марки автомобиля';
COMMENT ON COLUMN brands.name IS 'Наименование марки автомобиля';
