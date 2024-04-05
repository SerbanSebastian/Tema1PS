select * from Users;
select * from UserRoles;
select * from Roles;
select * from Items;
use museum;

insert into Roles(role_name, role_permissions)
values ('EMPLOYEE', 'EMPLOYEE:READ,EMPLOYEE:WRITE,EMPLOYEE:UPDATE,EMPLOYEE:DELETE'),
('ADMIN', 'EMPLOYEE:READ,ADMIN:READ,EMPLOYEE:WRITE,ADMIN:WRITE,EMPLOYEE:UPDATE,ADMIN:UPDATE,EMPLOYEE:DELETE,ADMIN:DELETE');

insert into UserRoles (user_id, role_id)
values ('marius123@gmail.com',1);

insert into Users (first_name, last_name, email, password, address, phone, creation_date)
values ('Marius','Periculosul','marius123@gmail.com','password','Address','0000000000',now());

insert into Users (first_name, last_name, email, password, address, phone, creation_date)
values ('admin','admin','admin@gmail.com','password','Address','0000000000',now());

insert into UserRoles (user_id, role_id)
values ('admin@gmail.com', 2);

DROP TABLE Items;
INSERT INTO Items (title, artist, art_type, year_of_creation, country_of_origin)
VALUES
    ('Starry Night', 'Vincent van Gogh', 'Post-Impressionism', 1889, 'Netherlands'),
    ('Mona Lisa', 'Leonardo da Vinci', 'Renaissance', 1503, 'Italy'),
    ('The Persistence of Memory', 'Salvador Dalí', 'Surrealism', 1931, 'Spain'),
    ('The Starry Night', 'Vincent van Gogh', 'Post-Impressionism', 1889, 'Netherlands'),
    ('The Night Watch', 'Rembrandt', 'Baroque', 1642, 'Netherlands'),
    ('Girl with a Pearl Earring', 'Johannes Vermeer', 'Baroque', 1665, 'Netherlands'),
    ('Guernica', 'Pablo Picasso', 'Surrealism', 1937, 'Spain'),
    ('The Scream', 'Edvard Munch', 'Expressionism', 1893, 'Norway'),
    ('The Birth of Venus', 'Sandro Botticelli', 'Renaissance', 1484, 'Italy'),
    ('The Kiss', 'Gustav Klimt', 'Art Nouveau', 1907, 'Austria'),
    ('The Last Supper', 'Leonardo da Vinci', 'Renaissance', 1498, 'Italy'),
    ('American Gothic', 'Grant Wood', 'Regionalism', 1930, 'United States'),
    ('Water Lilies', 'Claude Monet', 'Impressionism', 1919, 'France'),
    ('The Thinker', 'Auguste Rodin', 'Sculpture', 1902, 'France'),
    ('Les Demoiselles d''Avignon', 'Pablo Picasso', 'Cubism', 1907, 'Spain'),
    ('The Sleeping Gypsy', 'Henri Rousseau', 'Naïve Art', 1897, 'France'),
    ('The Creation of Adam', 'Michelangelo', 'Renaissance', 1512, 'Italy'),
    ('The Swing', 'Jean-Honoré Fragonard', 'Rococo', 1767, 'France'),
    ('Whistler''s Mother', 'James Abbott McNeill Whistler', 'Realism', 1871, 'United States'),
    ('The Great Wave off Kanagawa', 'Katsushika Hokusai', 'Ukiyo-e', 1831, 'Japan');
