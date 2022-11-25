CREATE TABLE IF NOT EXISTS participates (
    post_id INT NOT NULL REFERENCES posts(id) ,
    user_id INT NOT NULL REFERENCES users(id) ,
    PRIMARY KEY (post_id, user_id)
);

COMMENT ON TABLE participates IS 'Подписки пользователей на уведомления';
COMMENT ON COLUMN participates.post_id IS 'Объявление на которое подписан пользователь';
COMMENT ON COLUMN participates.user_id IS 'Пользователь подписки';
