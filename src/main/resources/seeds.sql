INSERT IGNORE INTO categories (id, name, description) VALUES ('60e52c74-2411-4dd7-ad31-3b4358405afe', 'TRAVEL', 'Mochilas para viajar');
INSERT IGNORE INTO categories (id, name, description) VALUES ('1bd18dac-b638-400a-aa30-8ecbf2c5c511', 'SCHOOL', 'Mochilas para la esculea');
INSERT IGNORE INTO categories (id, name, description) VALUES ('dbfa7051-a9ae-43fb-b7b0-2773b887a3b2', 'SPORT', 'Mochilas deportivas');
INSERT IGNORE INTO categories (id, name, description) VALUES ('5f0e7eb7-c3b9-4436-b214-039795dee8f7', 'WORK', 'Mochilas para el trabajo');

INSERT IGNORE INTO roles (id, name, description) VALUES ('b317d38a-1e4b-43fe-bceb-cd157c94f8be', 'USER', 'Role user');
INSERT IGNORE INTO roles (id, name, description) VALUES ('7bd3b826-98c2-40e4-83c4-a422895d0497', 'ADMIN', 'Role admin');

INSERT IGNORE INTO users (id, first_name, last_name, email, password, address, role_id, enable) VALUES ('7c0a4c5a-2034-46d4-a7f6-8f6b29260161', 'Juan', 'Perez', 'admin@gmail.com', '$2a$12$h9fxb5.EADRL9Sy9CfHE6uM1moYn9bdLtG8ErDqwj6IFKb5q0p7SO', 'La Paz', '7bd3b826-98c2-40e4-83c4-a422895d0497', true);
INSERT IGNORE INTO users (id, first_name, last_name, email, password, address, role_id, enable) VALUES ('2291d35f-c159-482b-970c-38099a900b99', 'Luis', 'Roman', 'user@gmail.com', '$2a$12$kF4Aexd7tnpQu7W0iRpB5uMy0kYw0bW7G3drlGX/MrWGeL8dLIlJq', 'El Alto', 'b317d38a-1e4b-43fe-bceb-cd157c94f8be', true);

INSERT IGNORE INTO products (id, name, description, image_url, price, stock, activate, category_id) VALUES ('9507da33-0c2c-4108-a387-c6314f60acec', 'Product A', 'Description del producto A', 'https://image.png', 59.99, 130, true,'60e52c74-2411-4dd7-ad31-3b4358405afe' );
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, activate, category_id) VALUES ('6ac82bac-26c0-42ba-83ef-7e27e27d9c32', 'Product B', 'Descripción del producto B', 'https://image2.png', 79.99, 25, true, '60e52c74-2411-4dd7-ad31-3b4358405afe');
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, activate, category_id) VALUES ('5ed49fd6-2dde-40db-ba40-5b61736362f3', 'Product E', 'Descripción del producto E', 'https://image5.png', 129.99, 5, true, '1bd18dac-b638-400a-aa30-8ecbf2c5c511');
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, activate, category_id) VALUES ('59191557-d9c5-42af-96d1-a04d7c25940e', 'Product F', 'Descripción del producto F', 'https://image6.png', 45.99, 42, true, 'dbfa7051-a9ae-43fb-b7b0-2773b887a3b2');
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, activate, category_id) VALUES ('39bbfc5b-64cc-4879-af27-81ae5c680d99', 'Product G', 'Descripción del producto G', 'https://image7.png', 29.99, 110, true, 'dbfa7051-a9ae-43fb-b7b0-2773b887a3b2');
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, activate, category_id) VALUES ('998a3c92-ce19-4b45-b934-b1cb1a912b57', 'Product H', 'Descripción del producto H', 'https://image8.png', 88.99, 33, true, '5f0e7eb7-c3b9-4436-b214-039795dee8f7');
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, activate, category_id) VALUES ('650350d9-1bba-458b-a9de-317c8037ada2', 'Product I', 'Descripción del producto I', 'https://image9.png', 66.99, 75, true, '5f0e7eb7-c3b9-4436-b214-039795dee8f7');

