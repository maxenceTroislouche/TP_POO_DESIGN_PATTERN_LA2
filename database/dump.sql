create database michka_dp;
use michka_dp;

create table if not exists ADRESSE
(
    ID_ADRESSE  int auto_increment primary key,
    type_voie   varchar(10)  null,
    nom_voie    varchar(100) null,
    numero_voie varchar(10)  null,
    code_postal varchar(5)   null,
    ville       varchar(100) null
);

create table if not exists CATEGORIE_SURFACE_BIEN
(
    ID_CATEGORIE_SURFACE_BIEN  int auto_increment
    primary key,
    LIB_CATEGORIE_SURFACE_BIEN varchar(30) not null
);

create table if not exists TYPE_BIEN
(
    ID_TYPE_BIEN  int auto_increment
    primary key,
    LIB_TYPE_BIEN varchar(30) default 'TYPE DE BIEN' not null comment 'Libellé du type de bien'
    );

create table if not exists BIEN
(
    ID_BIEN                int auto_increment
    primary key,
    type_bien              int                                         null,
    categorie_surface_bien int                                         null,
    surface_habitable      decimal(5, 2) default 0.00                  not null,
    nbr_pieces             int                                         null,
    description_libre    text                                        null,
    Commentaire_agence     longtext                                    null,
    date_creation          date          default (cast(now() as date)) null,
    date_derniere_maj      date                                        null,
    ID_ADRESSE             int                                         null,
    NO_APPARTEMENT         varchar(3)                                  null,
    ETAGE                  int                                         null,
    constraint FK_ADRESSE
    foreign key (ID_ADRESSE) references ADRESSE (ID_ADRESSE),
    constraint FK_SURFACE_BIEN
    foreign key (categorie_surface_bien) references CATEGORIE_SURFACE_BIEN (ID_CATEGORIE_SURFACE_BIEN),
    constraint FK_TYPE_BIEN
    foreign key (type_bien) references TYPE_BIEN (ID_TYPE_BIEN)
    );

insert into michka_dp.ADRESSE (ID_ADRESSE, type_voie, nom_voie, numero_voie, code_postal, ville)
values  (1, 'RUE', 'JEAN SOUVRAZ', '12', '62000', 'LENS'),
        (2, 'RUE', 'DES LILAS', '29', '59700', 'MARCQ EN BAROEUL'),
        (3, 'AVENUE', 'DE FLANDRE', '42', '59290', 'WASQUEHAL'),
        (4, 'BOULEVARD', 'ALBERT 1ER', '42', '35200', 'RENNES'),
        (5, 'AVENUE', 'DU TROCADERO', '8', '59390', 'MONS EN BAROEUL');

insert into michka_dp.CATEGORIE_SURFACE_BIEN (ID_CATEGORIE_SURFACE_BIEN, LIB_CATEGORIE_SURFACE_BIEN)
values  (1, 'STUDIO'),
        (2, 'T1'),
        (3, 'T1Bis'),
        (4, 'T2'),
        (5, 'SANS OBJET'),
        (6, 'T3'),
        (7, 'T4');

insert into michka_dp.TYPE_BIEN (ID_TYPE_BIEN, LIB_TYPE_BIEN)
values  (1, 'APPARTEMENT'),
        (2, 'MAISON'),
        (3, 'GARAGE'),
        (4, 'ATELIER'),
        (5, 'COMMERCE'),
        (6, 'TERRAIN'),
        (7, 'PARKING AERIEN'),
        (8, 'PARKING COUVERT'),
        (9, 'HABITAT TEMPORAIRE');

-- create definer = root@localhost trigger BIEN_BEFORE_INSERT
--     before insert
--     on michka_dp.BIEN
--     for each row
-- BEGIN
--     SET NEW.date_creation=date(now());
--     SET NEW.date_derniere_maj = date(now());
-- END;
--
-- insert into michka_dp.BIEN (ID_BIEN, type_bien, categorie_surface_bien, surface_habitable, nbr_pieces, description_libre, Commentaire_agence, date_creation, date_derniere_maj, ID_ADRESSE, NO_APPARTEMENT, ETAGE)
-- values  (1, 1, 1, 25.00, 1, 'Studio étudiant', 'Très lumineux, à proximité de l''université', '2023-09-07', null, 1, '1', 1),
--         (2, 1, 1, 30.00, 1, null, null, null, null, 1, null, null),
--         (3, 1, 1, 30.00, 1, null, null, null, null, 5, null, null),
--         (4, 2, 2, 40.00, 2, null, null, null, null, null, null, null),
--         (5, 2, 2, 40.00, 2, 'Test', 'PLutot beau', '2024-04-01', null, 3, '31', 3),
--         (20, 1, 1, 30.00, null, null, null, '2024-04-01', '2024-04-01', 5, null, null),
--         (21, 1, null, 100.00, null, null, null, '2024-04-01', '2024-04-01', 5, null, null);
