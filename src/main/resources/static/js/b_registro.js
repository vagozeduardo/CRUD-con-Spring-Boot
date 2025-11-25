

document.getElementById("registroForm").addEventListener("submit", function (event) {
    event.preventDefault(); // esto hace algo asi de no recargar l apagina si se da click pero hay unn error no se borre los datos en los campos

    // variables para los datos de los campos
    const nombre = document.getElementById("nombre").value.trim();
    const apellidoPaterno = document.getElementById("apellidoPaterno").value.trim();
    const apellidoMaterno = document.getElementById("apellidoMaterno").value.trim();
    const correo = document.getElementById("correo").value;
    const confirmarCorreo = document.getElementById("confirmarCorreo").value.trim();
    const contraseña = document.getElementById("contraseña").value.trim();
    const confirmarContraseña = document.getElementById("confirmarContraseña").value.trim();
    const ITFtipoUsuario = document.getElementById("tipoUsuario").value.trim();
    console.log(ITFtipoUsuario)
    const errorMensaje = document.getElementById("errorMensaje");

    // le quita los acentos y deja a minusculas el texto
    const normalizedTipo = ITFtipoUsuario
        .normalize("NFD") // algo asi de separar un un caracter como "ó" a "o'"
        .replace(/[\u0300-\u036f]/g, "") // esto reemplaza con "" (nada en "") los caracteres q esten en esos valores
        .toLowerCase();

    // if ternario para elegir el texto a mandar al sistema
    const tipoUsuario = (normalizedTipo == "anfitrion") ? "Propietario" : ITFtipoUsuario;
    console.log(tipoUsuario)

    // limpia mensajes de error si hay
    errorMensaje.innerText = "";

    // lalidaciones 
    if (correo !== confirmarCorreo) {
        errorMensaje.innerText = "Los correos electrónicos no coinciden.";
        return;
    }
    if (contraseña !== confirmarContraseña) {
        errorMensaje.innerText = "Las contraseñas no coinciden.";
        return;
    }
    if (!ITFtipoUsuario) {
        errorMensaje.innerText = "Seleccione el tipo de usuario.";
        return;
    }



    // Construir el objeto JSON a enviar
    const Datos_usuario = {
        Nombre: nombre,
        Apellido_Paterno: apellidoPaterno,
        Apellido_Materno: apellidoMaterno,
        Correo: correo,
        Contrasena: contraseña,
        Tipo_Usuario: tipoUsuario
    };

    console.log("Enviando datos:", Datos_usuario);


    fetch("http://localhost:8080/registro", {
        method: "POST",
        mode: 'cors',
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(Datos_usuario)
    })
        .then(response => {
            console.log("Estado de respuesta:", response.status);
            console.log("Headers de respuesta:", response.headers);

            if (!response.ok) {
                return response.json().then(errors => {
                    console.log("Errores recibidos:", errors);

                    
                    errorMensaje.innerText = "";

                    
                    for (const [field, message] of Object.entries(errors)) {
                        const errorMessage = `${field}: ${message}`;
                        errorMensaje.innerText += `${errorMessage}\n`;
                    }

                    // y hay error salta al catch para no pasar .then
                    throw new Error("Errores de validación detectados");
                });
            }
            // ve si la respuesta es JSON o texto
            const tipo_respuesta = response.headers.get("Content-Type");
            if (tipo_respuesta && tipo_respuesta.includes("application/json")) {
                return response.json();
            } else {
                return response.text(); // pasa como trexto si no es json
            }

        })
        .then(data => {
            // ve si la respuesta es JSON o texto
        if (typeof data === "string") {
            console.log("Respuesta de texto recibida:", data);
            alert(data); // imprime texto como alerta
        } else {
            console.log("Datos JSON recibidos:", data);
            alert(data.message);
        }

            window.location.href = 'cuerpo.html';
        })
        .catch(error => {
            console.error("Error general:", error);

            // si no es un error de las validación dise esto
            if (error.message !== "Errores de validación detectados") {
                errorMensaje.innerText = "Error al enviar los datos. Por favor, inténtelo nuevamente.";
            }
        });

});
