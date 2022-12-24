CREATE TABLE IF NOT EXISTS engines (
    id SERIAL PRIMARY KEY ,
    name TEXT UNIQUE NOT NULL
);

COMMENT ON TABLE engines IS 'Двигатель автомобиля';
COMMENT ON COLUMN engines.id IS 'Идентификатор двигателя';
COMMENT ON COLUMN engines.name IS 'Наименование двигателя';
