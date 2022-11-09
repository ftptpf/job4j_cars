CREATE TABLE IF NOT EXISTS participates (
    id SERIAL PRIMARY KEY ,
    user_id INT NOT NULL REFERENCES users(id) ,
    post_id INT NOT NULL REFERENCES posts(id)
);

COMMENT ON TABLE participates IS 'Подписки пользователей на уведомления';
COMMENT ON COLUMN participates.id IS 'Идентификатор подписки';
COMMENT ON COLUMN participates.user_id IS 'Пользователь подписки';
COMMENT ON COLUMN participates.post_id IS 'Объявление не которое подписан пользователь';