package com.StudentStay.app.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.StudentStay.app.entity.HabitacionesDTO;
import com.StudentStay.app.entity.MenuHabitacionesDTO;
import com.StudentStay.app.entity.table_habitaciones;

public interface studentHabitacionesRepository extends JpaRepository<table_habitaciones, Integer> {

    /*@Query("SELECT new com.StudentStay.app.entity.HabitacionesDTO(US.Nombre, CONCAT_WS(' ',PR.Direccion, PR.Barrio_Colonia), HA.Precio) FROM table_habitaciones HA "+ 
    "JOIN table_Propiedades PR ON HA.ID_Propiedad = PR.ID_Propiedad "+ 
    "JOIN table_usuario US ON PR.ID_Usuario = US.ID_Usuario WHERE HA.ID_Habitacion = :ID_Habitacion")
    HabitacionesDTO findBySubConsultaconIdWithJPQL(@Param("ID_Habitacion") Long ID_Habitacion);*/

    // consulta que solo obtiene los datos que quiereo y los guarda en el DTO y no en el entity
    @Query(value = "SELECT vh.ID_Habitacion,vh.titulo,vh.Anfitrion, vh.Descripcion, vh.Ubicación, vh.Precio " +
    "FROM vista_detallesHabitacion vh " +
    "WHERE vh.ID_Habitacion = :ID_Habitacion", nativeQuery = true)
    HabitacionesDTO findByIdHabitacionDates(@Param("ID_Habitacion") Integer ID_Habitacion);



    // para mandar a traer las primeras 6 habitaciones
    @Query(value = "SELECT th.ID_Habitacion,th.Sobrenombre,th.Descripcion,th.Precio FROM habitaciones th ORDER BY th.ID_Habitacion ASC LIMIT 6",nativeQuery=true)
    List<MenuHabitacionesDTO> obtenerPrimerasseisHabitaciones();

    

}
