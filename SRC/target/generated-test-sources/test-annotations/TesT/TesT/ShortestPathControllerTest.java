package TesT;

import Controller.ShortestPathController;
import Services.ShortestPathService;
import model.ShortestPathResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ShortestPathController.class)
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class ShortestPathControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShortestPathService shortestPathService;

    @Test
    void testGetShortestPath() throws Exception {
        // Arrange
        ShortestPathResponse expectedResponse = new ShortestPathResponse(/* provide expected response */);
        when(shortestPathService.getShortestPath(anyLong(), anyLong())).thenReturn(expectedResponse);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/shortest-path")
                        .param("sourceId", "1")
                        .param("destinationId", "2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.path").exists())
                .andExpect(jsonPath("$.cost").exists())
                .andExpect(jsonPath("$.path").isArray())
                .andExpect(jsonPath("$.cost").isNumber());
    }
}
