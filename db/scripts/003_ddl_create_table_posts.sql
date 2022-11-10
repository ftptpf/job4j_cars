CREATE TABLE IF NOT EXISTS posts (
    id SERIAL PRIMARY KEY ,
    description TEXT ,
    created TIMESTAMP ,
    price BIGINT ,
    sold BOOLEAN ,
    user_id INT NOT NULL REFERENCES users(id) ,
    car_id INT NOT NULL REFERENCES cars(id)
);

COMMENT ON TABLE posts IS 'Объявления';
COMMENT ON COLUMN posts.id IS 'Идентификатор объявления';
COMMENT ON COLUMN posts.description IS 'Текст описания объявления';
COMMENT ON COLUMN posts.created IS 'Дата создания объявления';
COMMENT ON COLUMN posts.price IS 'Цена в объявлении';
COMMENT ON COLUMN posts.sold IS 'Статус актуальности объявления';
COMMENT ON COLUMN posts.user_id IS 'Автор объявления';
COMMENT ON COLUMN posts.car_id IS 'Продаваемый автомобиль';


