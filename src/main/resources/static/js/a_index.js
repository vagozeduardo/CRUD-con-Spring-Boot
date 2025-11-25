const btnSesion = document.getElementById("BtnIniciar_Sesion");
const btnRegistro = document.getElementById("boton_registro");
const mensaje = document.getElementById("message_Sesion");

// evento clic para iniciar sesión
btnSesion.addEventListener('click', async function (event) {
    event.preventDefault();


    //si los declaro afuera no me obtiene los datos ._.
    const CorreoUsuario = document.getElementById("username").value.trim();
    const password_usuario = document.getElementById("password").value.trim();

    // Validar que los campos no estén vacíos (no funciona despues)
    /*if (CorreoUsuario.value === null || password_usuario.value === null) {
        mensaje.innerText = "Por favor, complete todos los campos.";
        return;
    }*/

    let datosLogin = {
        Correo: CorreoUsuario,
        Contrasena: password_usuario
    }
    console.log(datosLogin)

    try {
        const respuesta = await fetch('http://localhost:8080/login', {  // envia los datos al servidor mediante fetch usando la direccion
            method: 'POST',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datosLogin)
        });

        // para obtener la respuesta
        const resultado = await respuesta.json();

        if (resultado.loginExitoso) { 

            localStorage.setItem("isLoggedin",true) // para guardar si se inicio sesion
            window.location.href = 'cuerpo.html';

        } else {
            // imprime mensaje de error si las Datos son incorrectas
            mensaje.innerText = "Datos incorrectas.";
        }
    } catch (error) {
        console.error("Error:", error);
        mensaje.innerText = "Ocurrió un error al procesar la solicitud.";
    }
});

// evento click para registrarse 
btnRegistro.addEventListener('click', () => {
    window.location.href = "b_registro.html"; // cierra la interfaz y abre la siguiente
});
