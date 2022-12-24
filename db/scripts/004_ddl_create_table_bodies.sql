CREATE TABLE IF NOT EXISTS bodies (
    id SERIAL PRIMARY KEY ,
    name TEXT UNIQUE NOT NULL
);

COMMENT ON TABLE bodies IS 'Кузов автомобиля';
COMMENT ON COLUMN bodies.id IS 'Идентификатор кузова автомобиля';
COMMENT ON COLUMN bodies.name IS 'Наименование кузова автомобиля';
