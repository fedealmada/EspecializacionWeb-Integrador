INSERT INTO usuarios (tipo_usuario, apellido, email, nacionalidad, nombre, password, role, username, especialidad)
VALUES
    ('Doctor', 'Johnson', 'john.johnson@example.com', 'American', 'John', 'password123', 'ADMIN', 'johnd', 'Cardiology'),
    ('Paciente', 'Smith', 'kevin.smith@example.com', 'British', 'Kevin', 'password456', 'USER', 'kevins', null),
    ('Doctor', 'Gomez', 'jorge.brown@example.com', 'Argentino', 'Jorge', 'password789', 'ADMIN', 'michaelb', 'Pediatrics'),
    ('Paciente', 'Rogers', 'isaac.rogers@example.com', 'Iranian', 'Isaac', 'password890', 'USER', 'isaacro', null),
    ('Doctor', 'Johnson', 'john.johnson@example.com', 'American', 'John', 'password123', 'ADMIN', 'johnd', 'Cardiology'),
    ('Paciente', 'Smith', 'kevin.smith@example.com', 'British', 'Kevin', 'password456', 'USER', 'kevins', null),
    ('Doctor', 'Brown', 'michael.brown@example.com', 'Canadian', 'Michael', 'password789', 'ADMIN', 'michaelb', 'Pediatrics'),
    ('Paciente', 'Rogers', 'isaac.rogers@example.com', 'Iranian', 'Isaac', 'password890', 'USER', 'isaacro', null),
    ('Doctor', 'Johnson', 'john.johnson@example.com', 'American', 'John', 'password123', 'ADMIN', 'johnd', 'Cardiology'),
    ('Paciente', 'Smith', 'kevin.smith@example.com', 'British', 'Kevin', 'password456', 'USER', 'kevins', null),
    ('Doctor', 'Brown', 'michael.brown@example.com', 'Canadian', 'Michael', 'password789', 'ADMIN', 'michaelb', 'Pediatrics'),
    ('Paciente', 'Rogers', 'isaac.rogers@example.com', 'Iranian', 'Isaac', 'password890', 'USER', 'isaacro', null);        
    
    INSERT INTO servicios (nombre, precio, bloque_tiempo)
VALUES
    ('Consulta', 50.00, 1),
    ('Vacunación', 30.00, 2),
    ('Cardiología', 80.00, 3),
    ('Oftalmología', 70.00, 2),
    ('Cirugía', 200.00, 4),
    ('Urgencia', 150.00, 4),
    ('Pediatría', 60.00, 2);  