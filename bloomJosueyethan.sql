create table Paciente(
uuid VARCHAR2(100) primary KEY,
nombre VARCHAR2(100)not null,
apellido varchar2(100) not null,
edad number not null,
numHabitacion number not null,
numCama number unique,
fechaIngreso varchar2(15) not null,
--fk
enfermedad number not null,
medicamento number not null,

constraint fkEnfermedad
foreign key (enfermedad)
references Enfermedad(idEnfermedad),

constraint fkMedicamento
foreign key (medicamento)
references Medicamento(idMedicamento)
);

create table Enfermedad(
idEnfermedad number GENERATED AS IDENTITY START WITH 1 INCREMENT BY 1 primary key,
nombreEnfermedad varchar(100)
);

create table Medicamento(
idMedicamento number GENERATED AS IDENTITY START WITH 1 INCREMENT BY 1 primary key,
nombreMedicamento varchar2(100),
horaAplicacion varchar2(100)
);

commit