package server.security;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class JwtAuthenticationEntryPointTest {

    private HttpServletResponse httpServletResponse;

    @Before
    public void init() {
        httpServletResponse = Mockito.mock(HttpServletResponse.class);
    }

    @Test
    public void entryPointTest() throws IOException {

    }

}
