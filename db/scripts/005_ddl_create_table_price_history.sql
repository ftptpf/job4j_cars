CREATE TABLE IF NOT EXISTS price_history (
    id SERIAL PRIMARY KEY ,
    before BIGINT NOT NULL ,
    after BIGINT NOT NULL ,
    created TIMESTAMP WITH TIME ZONE DEFAULT now()
);

COMMENT ON TABLE price_history IS 'История изменения цены автомобиля';
COMMENT ON COLUMN price_history.id IS 'Идентификатор записи в истории';
COMMENT ON COLUMN price_history.before IS 'Предыдущая цена';
COMMENT ON COLUMN price_history.after IS 'Последующая цена';
COMMENT ON COLUMN price_history.id IS 'Дата записи в истории изменения цены автомобиля';