package com.integracion2.servlets;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class loginservletTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testValidLogin() {
        HttpServletRequest request = new MockHttpServletRequest();
        HttpSession session = new MockHttpSession();

        ((MockHttpServletRequest) request).setParameter("username", "testuser");
        ((MockHttpServletRequest) request).setParameter("password", "testpassword");
        ((MockHttpServletRequest) request).setSession(session);

        loginservlet servlet = new loginservlet();
        boolean validCredentials = servlet.validarCredenciales("testuser", "testpassword");
        assertTrue(validCredentials);
    }

    @Test
    public void testInvalidLogin() {
        HttpServletRequest request = new MockHttpServletRequest();
        HttpSession session = new MockHttpSession();

        ((MockHttpServletRequest) request).setParameter("username", "testuser");
        ((MockHttpServletRequest) request).setParameter("password", "wrongpassword");
        ((MockHttpServletRequest) request).setSession(session);

        loginservlet servlet = new loginservlet();
        boolean validCredentials = servlet.validarCredenciales("testuser", "wrongpassword");
        assertFalse(validCredentials);
    }

    // Clase de ejemplo para simular HttpServletRequest
    private static class MockHttpServletRequest implements HttpServletRequest {
        private String username;
        private String password;
        private HttpSession session;

        @Override
        public String getParameter(String name) {
            if ("username".equals(name)) {
                return username;
            } else if ("password".equals(name)) {
                return password;
            }
            return null;
        }

        @Override
        public HttpSession getSession() {
            return session;
        }

        // Agrega setters para username, password y session
        public void setParameter(String name, String value) {
            if ("username".equals(name)) {
                this.username = value;
            } else if ("password".equals(name)) {
                this.password = value;
            }
        }

        public void setSession(HttpSession session) {
            this.session = session;
        }

        // Implementa los métodos faltantes de HttpServletRequest
    }

    // Clase de ejemplo para simular HttpSession
    private static class MockHttpSession implements HttpSession {
        // Implementación de los métodos necesarios para el test
    }
}
