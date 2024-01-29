-- Crear la tabla de categorías
CREATE TABLE tbl_categories (
                                id INT PRIMARY KEY,
                                name VARCHAR(255) NOT NULL
);

-- Crear la tabla de proyectos
CREATE TABLE tbl_projects (
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              name VARCHAR(255) NOT NULL,
                              description TEXT,
                              numproject INT,
                              cost DECIMAL(10, 2),
                              status VARCHAR(50),
                              create_at DATE,
                              category_id INT,
                              FOREIGN KEY (category_id) REFERENCES tbl_categories(id)
);

INSERT INTO tbl_categories (id, name) VALUES (1, 'privados');
INSERT INTO tbl_categories (id, name) VALUES (2, 'públicos');
INSERT INTO tbl_categories (id, name) VALUES (3, 'mixtos');

INSERT INTO tbl_projects (name, description, numproject, cost ,status, create_at,category_id)
VALUES ('Silver','Actualizar licencia ambientale',5,178.89,'CREATED','2023-09-05',1);

INSERT INTO tbl_projects (name, description, numproject,cost,status, create_at,category_id)
VALUES ('CáceresEmpresas ''Actualizar registro ambiental ''5555 ',4,12.5,'CREATED','2023-10-05',1);


INSERT INTO tbl_projects (name, description, numproject,cost,status, create_at,category_id)
VALUES ('Spring ','Actualizar licencia ambiental '' 255',12,40.06,'CREATED','2023-10-05',2);