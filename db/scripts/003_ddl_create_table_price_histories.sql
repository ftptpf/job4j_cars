CREATE TABLE IF NOT EXISTS price_histories (
    id SERIAL PRIMARY KEY ,
    before BIGINT NOT NULL ,
    after BIGINT NOT NULL ,
    created TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);

COMMENT ON TABLE price_histories IS 'История изменения цены автомобиля';
COMMENT ON COLUMN price_histories.id IS 'Идентификатор записи в истории';
COMMENT ON COLUMN price_histories.before IS 'Предыдущая цена';
COMMENT ON COLUMN price_histories.after IS 'Последующая цена';
COMMENT ON COLUMN price_histories.id IS 'Дата записи в истории изменения цены автомобиля';