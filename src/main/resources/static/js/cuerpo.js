const cerrarSesion = document.getElementById("cerrarSesion");

cerrarSesion.addEventListener("click", (event) => {
  event.preventDefault(); // evita algo asi de recargar o algo por el estilo la pagina
  // elimina  la sesion de localstorage
  localStorage.removeItem("isLoggedin");

  window.location.href = "cuerpo.html";
});

const isLoggedin = localStorage.getItem("isLoggedin") === "true";
console.log("La sesion es: ", isLoggedin)
const buttonText = isLoggedin ? "Reservar" : "+Información"; // if ternaria para saber que texto inprimir

// Contenedor de habitaciones
let listaHabitaciones = [];

async function obtenerHabitaciones() {
  const roomContainer = document.querySelector('.room-container');
  roomContainer.innerHTML = '';

  try {
    const response = await fetch('http://localhost:8080/habitacionesonlyseis');
    const habitaciones = await response.json();

    console.log(habitaciones);
    listaHabitaciones = habitaciones;



    habitaciones.forEach(habitacion => {
      // info de habitación
      const roomCard = document.createElement('div');
      roomCard.className = 'room-card';
      roomCard.style.backgroundImage = "url('https://images.pexels.com/photos/164595/pexels-photo-164595.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2')";


      roomCard.innerHTML = `
        <h3>${habitacion.sobrenombre}</h3>
        <p>${habitacion.descripcion}</p>
        <p class="price">$${habitacion.precio} por noche</p>
        <a href="d_dormitorios.html?id=${habitacion.id_Habitacion}" class="reservar-btn" >${buttonText}</a>
      `;

      // pone la info al contenedor
      roomContainer.appendChild(roomCard);
    });
  } catch (error) {
    console.error('Error al obtener las habitaciones:', error);
    alert('Lo sentimos, no pudimos cargar las habitaciones.');
  }
}


obtenerHabitaciones();
