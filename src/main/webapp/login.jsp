<%@include file="footer.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>
<hr class="hr" style="height: 100px"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-4 col-md-6 col-sm-8">
            <form class="login-form" action="svLogin" method="POST">
                <h2 class="text-center mb-4">Iniciar sesión</h2>
                <div class="form-group">
                    <label class="mb-3" for="Usuario">Nombre de Usuario</label>
                    <input name="rutUsuario" type="text" id="Usuario" class="form-control" placeholder="Ingresa Usuario"
                           required>
                </div>
                <br>
                <div class="form-group">
                    <label class="mb-3" for="passwordx">Contraseña</label>
                    <input name="password" type="password" id="passwordx" class="form-control"
                           placeholder="Ingresa tu contraseña" required>
                </div>
                <br>
                <div style="display: flex; justify-content: space-between;">
                    <button type="submit" class="btn btn-primary btn-dark mb-3">Ingresar</button>
                </div>

                <%
                    Boolean usuarioConectado = (Boolean) session.getAttribute("usuarioConectado");

                    if (usuarioConectado != null && !usuarioConectado) { %>
                <div id="alertPass" class="alert alert-danger">
                    Contraseña incorrecta. Por favor, inténtalo de nuevo.
                </div>

                <% } %>

            </form>

        </div>
    </div>
</div>


<script>
    <% Boolean error = (Boolean)request.getSession().getAttribute("errorLogin");%>

    <% if(error != null && error){ %>
    var alertElement = document.getElementById('alertPass');
    alertElement.style.display = 'block';
    var tiempoOcultar = 3000; // 3 segundos

    // Función para ocultar el elemento después del tiempo especificado
    function ocultarElemento() {
        alertElement.style.display = 'none';
    }

    // Configurar el temporizador con setTimeout
    setTimeout(ocultarElemento, tiempoOcultar);
    <%}%>
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>