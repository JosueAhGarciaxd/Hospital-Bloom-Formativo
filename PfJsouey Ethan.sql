CREATE TABLE Pacientes (
    idPaciente RAW(16) DEFAULT SYS_GUID() PRIMARY KEY,
    Nombres VARCHAR2(50),
    Apellidos VARCHAR2(50),
    Edad NUMBER,
    Enfermedad VARCHAR2(100),
    NumeroHabitacion NUMBER,
    NumeroCama NUMBER,
    MedicamentosAsignados VARCHAR2(1000), -- Lista de medicamentos separados por comas
    HoraAplicacionMedicamentos VARCHAR2(1000) -- Lista de horas de aplicación separadas por comas
);

Select * From Pacientes;