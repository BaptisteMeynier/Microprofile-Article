CREATE TYPE WaterType AS ENUM ('SEA', 'FRESH');

CREATE TABLE Family
(
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(100),
    water_type WaterType
);

CREATE TABLE Fish
(
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(100),
    temperature INT,
    price INT,
    family_fk INT,
    CONSTRAINT FK_FishFamily FOREIGN KEY (family_fk)
    REFERENCES Family(id)
);