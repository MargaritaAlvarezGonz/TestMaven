package mockito;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class LogginTest {

    @InjectMocks
    private Login login;

    @Mock
    private WebService webService;

    @BeforeEach
    private void setUp(){

    }

}