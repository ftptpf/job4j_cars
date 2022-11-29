CREATE TABLE IF NOT EXISTS history_owners (
    id SERIAL PRIMARY KEY ,
    driver_id INT NOT NULL REFERENCES drivers(id) ,
    car_id INT NOT NULL REFERENCES cars(id)
);

COMMENT ON TABLE history_owners IS 'История владения автомобилем';
COMMENT ON COLUMN history_owners.driver_id IS 'Владелец автомобиля';
COMMENT ON COLUMN history_owners.car_id IS 'Автомобиль';