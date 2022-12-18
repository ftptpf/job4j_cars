CREATE TABLE IF NOT EXISTS posts (
    id SERIAL PRIMARY KEY ,
    text TEXT ,
    photo BYTEA ,
    created TIMESTAMP ,
    price BIGINT ,
    sale BOOLEAN ,
    user_id INT NOT NULL REFERENCES users(id) ,
    car_id INT NOT NULL REFERENCES cars(id)
);

COMMENT ON TABLE posts IS 'Объявления';
COMMENT ON COLUMN posts.id IS 'Идентификатор объявления';
COMMENT ON COLUMN posts.photo IS 'Фотография автомобиля';
COMMENT ON COLUMN posts.text IS 'Текст описания объявления';
COMMENT ON COLUMN posts.created IS 'Дата создания объявления';
COMMENT ON COLUMN posts.price IS 'Цена в объявлении';
COMMENT ON COLUMN posts.sale IS 'Статус актуальности объявления';
COMMENT ON COLUMN posts.user_id IS 'Автор объявления';
COMMENT ON COLUMN posts.car_id IS 'Продаваемый автомобиль';


