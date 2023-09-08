<!DOCTYPE html>
<html>
<head>
    <title>Información Básica</title>
</head>
<body>
    <h1>Información Básica de la Persona</h1>
    <p>RUT: <%= ((Persona) session.getAttribute("persona")).getRut() %></p>
    <p>Nombre: <%= ((Persona) session.getAttribute("persona")).getNombre() %></p>
    <p>Apellido: <%= ((Persona) session.getAttribute("persona")).getApellido() %></p>
    <!-- Otros campos de información básica -->
</body>
</html>
