CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY ,
    name TEXT NOT NULL ,
    email TEXT UNIQUE NOT NULL ,
    password TEXT NOT NULL
);

COMMENT ON TABLE users IS 'Пользователи';
COMMENT ON COLUMN users.id IS 'Идентификатор пользователя';
COMMENT ON COLUMN users.name IS 'Имя пользователя';
COMMENT ON COLUMN users.email IS 'Email пользователя';
COMMENT ON COLUMN users.password IS 'Пароль пользователя';
