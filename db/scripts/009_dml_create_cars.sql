INSERT INTO brands(name) VALUES ('LADA');
INSERT INTO brands(name) VALUES ('AUDI');
INSERT INTO brands(name) VALUES ('BMW');
INSERT INTO brands(name) VALUES ('OPEL');

INSERT INTO bodies(name) VALUES ('Седан');
INSERT INTO bodies(name) VALUES ('Хетчбэк');
INSERT INTO bodies(name) VALUES ('Внедорожник');
INSERT INTO bodies(name) VALUES ('Универсал');

INSERT INTO engines(name) VALUES ('100 л.с');
INSERT INTO engines(name) VALUES ('105 л.с');
INSERT INTO engines(name) VALUES ('115 л.с');
INSERT INTO engines(name) VALUES ('125 л.с');

INSERT INTO cars(car_year, kilometer, engine_id, brand_id, body_id) VALUES (2000, 50000, 1, 1, 2);
INSERT INTO cars(car_year, kilometer, engine_id, brand_id, body_id) VALUES (1999, 100000, 2, 2, 3);
INSERT INTO cars(car_year, kilometer, engine_id, brand_id, body_id) VALUES (2009, 135000, 3, 3, 1);