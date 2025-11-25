const titulo = document.getElementById('Tituloh');
const ubicacion2 = document.getElementById('ubicación_h');
const propietario = document.getElementById('nombrePropietario');
const precio = document.getElementById('precioh');
const descripciohn = document.getElementById('Descripcionh');

// obtiene el ID de los datos en el cuerpo
const params = new URLSearchParams(window.location.search);
const ID_Habitacion = params.get('id'); // obtiene el valor "id" en la URL
console.log(ID_Habitacion)

// Hacer la petición al backend
fetch(`http://localhost:8080/subConsulta/${ID_Habitacion}`) // pone el id que obtubo en la otra pagina
    .then(response => {
        if (!response.ok) {
            throw new Error('Error en la consulta');
        }
        return response.json();
    })
    .then(data => {
        console.log("Datos recibidos:", data);

        titulo.innerText = data.titulo || (data.detalles && data.detalles.titulo) || 'Título no disponible';
        propietario.innerText = data.anfitrion || (data.detalles && data.detalles.anfitrion) || 'Propietario desconocido';
        descripciohn.innerText = data.descripcion || (data.detalles && data.detalles.descripcion) || 'Sin descripción disponible';
        ubicacion2.innerText = data.ubicación || (data.detalles && data.detalles.ubicación) || 'Ubicación no disponible';
        precio.innerText = `${data.precio || (data.detalles && data.detalles.precio) || '0'}`;
        console.log('Título:', titulo);
        console.log('Propietario:', propietario);
        console.log('Descripción:', descripciohn);
        console.log('Ubicación:', ubicacion2);
        console.log('Precio:', precio);

    })
    .catch(error => console.error('Error:', error));


   
    const btn_reservar = document.getElementById("reservar");
    btn_reservar.addEventListener("click", () =>{
        const isLoggedin = localStorage.getItem("isLoggedin") === "true";

        if (isLoggedin) {
            window.location.href = "formapago.html";

        } else {
            window.location.href = "a_index.html";
        }

    });
