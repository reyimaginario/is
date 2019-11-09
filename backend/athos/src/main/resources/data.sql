insert into profesional (dni, nombre, apellido, matricula) values ('11222333', 'Sigmund', 'Freud', '1');
insert into profesional (dni, nombre, apellido, matricula) values ('22333444', 'Jacques', 'Lacan', '2');
insert into profesional (dni, nombre, apellido, matricula) values ('33444555', 'Carl',    'Jung',  '3');

insert into sujeto (dni, nombre, apellido, profesional_dni) values ('1', 'Teddy',  'Daniels',    22333444);
insert into sujeto (dni, nombre, apellido, profesional_dni) values ('2', 'Sabina', 'Spielrein',  33444555);
insert into sujeto (dni, nombre, apellido, profesional_dni) values ('3', 'Eliza',  'Beckinsale', 22333444);

insert into evaluacion_psicologica (evaluacion_id, fecha_inicio, motivo, profesional_dni, sujeto_dni, finalizado)
    values (1, to_date('1818-05-05', 'yyyy-MM-dd'), 'test', 22333444, 1, 0);

insert into test_aplicado (test_aplicado_id, test_code, evaluacion_id)
    values (1, 'mmpi2', 1);

insert into respuesta_temporal (respuesta_id, evaluacion_id, test_code, pregunta, respuesta) values
    (1, 1, 'mmpi2', 1, 0),
    (2, 1, 'mmpi2', 2, 0),
    (3, 1, 'mmpi2', 3, 1),
    (4, 1, 'mmpi2', 4, 0),
    (5, 1, 'mmpi2', 5, 1),
    (6, 1, 'mmpi2', 6, 1),
    (7, 1, 'mmpi2', 7, 1);