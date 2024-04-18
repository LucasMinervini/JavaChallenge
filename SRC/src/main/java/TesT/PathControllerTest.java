package TesT;

import Controller.PathController;
import Services.PathService;
import model.ShortestPathResponse;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PathControllerTest {
    @Test
    public void testGetShortestPath() {
        // Mock del servicio
        PathService pathService = Mockito.mock(PathService.class);

        // Datos dummy para el test
        List<Long> shortestPath = Arrays.asList(10L, 13L, 12L);
        double cost = 80.0;
        when(pathService.getShortestPath(10L, 13L)).thenReturn(new ShortestPathResponse(shortestPath, cost));

        // Instanciar el controlador con el servicio mockeado
        PathController pathController = new PathController(pathService);

        // Llamar al método bajo prueba
        ResponseEntity<ShortestPathResponse> responseEntity = pathController.getShortestPath(10L, 13L);

        // Verificar el resultado
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        ShortestPathResponse responseBody = responseEntity.getBody();
        assertEquals(shortestPath, responseBody.getPath());
       // assertEquals(cost, responseBody.getCost());
    }
}
