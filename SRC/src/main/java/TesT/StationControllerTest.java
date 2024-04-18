package TesT;

import Controller.StationController;
import Services.StationService;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

class StationControllerTest {

    @Test
    void testDeleteStationById_WhenStationExists() {
        // Mock del servicio
        StationService stationService = Mockito.mock(StationService.class);
        when(stationService.removeStation(1L)).thenReturn(true);

        // Instanciar el controlador con el servicio mockeado
        StationController stationController = new StationController(stationService);

        // Llamar al método bajo prueba
        ResponseEntity<String> responseEntity = stationController.deleteStationById(1L);

        // Verificar el resultado
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Station deleted successfully", responseEntity.getBody());
    }

    @Test
    void testDeleteStationById_WhenStationNotExists() {
        // Mock del servicio
        StationService stationService = Mockito.mock(StationService.class);
        when(stationService.removeStation(1L)).thenReturn(false);

        // Instanciar el controlador con el servicio mockeado
        StationController stationController = new StationController(stationService);

        // Llamar al método bajo prueba
        ResponseEntity<String> responseEntity = stationController.deleteStationById(1L);

        // Verificar el resultado
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(null, responseEntity.getBody());
    }
}
