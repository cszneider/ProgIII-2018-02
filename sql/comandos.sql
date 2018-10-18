create table Usuarios (
	idUsuario integer not null,
    dsNome varchar( 120 ) not null,
    dsEmail varchar( 70 ) not null,
    dtInclusao timestamp not null,
    dtNascimento timestamp,
    dsInfoSenha char( 32 ),
    tpSexo char( 1 ),
    dsRenda Numeric( 15, 2 ),
	primary key( idUsuario )
);

create unique index porEmail on Usuarios ( dsEmail )

insert into usuarios 
( idUsuario, dsNome, dsEmail, dtInclusao, tpSexo, dsRenda )
values
( 1, 'Joe Satriani', 'satriani@gmail.com', current_timestamp, 'M', 98587 );

select * from usuarios;