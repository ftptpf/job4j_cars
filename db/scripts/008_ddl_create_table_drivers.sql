CREATE TABLE IF NOT EXISTS drivers (
    id SERIAL PRIMARY KEY ,
    name TEXT NOT NULL ,
    user_id INT UNIQUE REFERENCES users(id)
);

COMMENT ON TABLE drivers IS 'Автовладельцы';
COMMENT ON COLUMN drivers.id IS 'Идентификатор автовладельца';
COMMENT ON COLUMN drivers.name IS 'Имя автовладельца';
COMMENT ON COLUMN drivers.user_id IS 'Пользователь';
