package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.HttpRequest;
import PROJECT_HTTP_SERVER.exeptions.BadRequestException;
import PROJECT_HTTP_SERVER.exeptions.HttpVersionNotSupportedException;
import PROJECT_HTTP_SERVER.exeptions.MethodNotAllowedException;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.io.InputStream;


import static org.junit.jupiter.api.Assertions.*;

class DefaultHttpRequestParserTest {
    private DefaultHttpRequestParser defaultHttpRequestParser;

    @BeforeEach
    public void before() {
        defaultHttpRequestParser = new DefaultHttpRequestParser();
    }

    private InputStream getClassPathResourceStream(String resourceName) {
        return getClass().getClassLoader().getResourceAsStream(resourceName);
    }

    @Test
    public void testBadRequestException() throws IOException {
        try {
            defaultHttpRequestParser.parseHttpRequest(null, "localhost");
            fail("Can't parse http request: null");
        } catch (BadRequestException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testMethodNotAllowedException() throws IOException {
        try (InputStream httpMessage = getClassPathResourceStream("for_test_request/method-not-allowed.txt")) {
            HttpRequest request = defaultHttpRequestParser.parseHttpRequest(httpMessage, "localhost");
            fail("Only [GET, POST, HEAD] are supported. Current method is PUT");
        } catch (MethodNotAllowedException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testInvalidHttpVersion() throws IOException {
        try (InputStream httpMessage = getClassPathResourceStream("for_test_request/get-invalid-http-version.txt")) {
            HttpRequest request = defaultHttpRequestParser.parseHttpRequest(httpMessage, "localhost");
            fail("Current server supports only HTTP/1.1 protocol");
        } catch (HttpVersionNotSupportedException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testGetSimple() throws IOException {
        try (InputStream httpMessage = getClassPathResourceStream("for_test_request/get-simple.txt")) {
            HttpRequest request = defaultHttpRequestParser.parseHttpRequest(httpMessage, "localhost");
            assertEquals("GET", request.getMethod());
            assertEquals("/index.html", request.getUri());
            assertEquals("HTTP/1.1", request.getHttpVersion());

            assertEquals("localhost", request.getHeaders().get("Host"));
            assertEquals("Mozilla/5.0 (X11; U; Linux i686; ru; rv:1.9b5) Gecko/2008050509 Firefox/3.0b5",
                    request.getHeaders().get("User-Agent"));
            assertEquals("text/html", request.getHeaders().get("Accept"));
            assertEquals("close", request.getHeaders().get("Connection"));

            assertTrue(request.getParameters().isEmpty());

            assertEquals("localhost", request.getRemoteAddess());
        }
    }

    @Test
    public void testGetHeadersCaseUnsensitive() throws IOException {
        try (InputStream httpMessage = getClassPathResourceStream("for_test_request/get-headers-case-unsensitive.txt")) {
            HttpRequest request = defaultHttpRequestParser.parseHttpRequest(httpMessage, "localhost");
            assertEquals("localhost", request.getHeaders().get("Host"));
            assertEquals("Mozilla/5.0 (X11; U; Linux i686; ru; rv:1.9b5) Gecko/2008050509 Firefox/3.0b5",
                    request.getHeaders().get("User-Agent"));
            assertEquals("text/html", request.getHeaders().get("Accept"));
            assertEquals("close", request.getHeaders().get("Connection"));
        }
    }

    @Test
    public void testGetHeadersNewLine() throws IOException {
        try (InputStream httpMessage = getClassPathResourceStream("for_test_request/get-headers-new-line.txt")) {
            HttpRequest request = defaultHttpRequestParser.parseHttpRequest(httpMessage, "localhost");
            assertEquals("localhost", request.getHeaders().get("Host"));
            assertEquals("text/html;charset=windows-1251", request.getHeaders().get("Content-Type"));
            assertEquals("text/html", request.getHeaders().get("Accept"));
        }
    }

    @Test
    public void testHeadSimple() throws IOException {
        try (InputStream httpMessage = getClassPathResourceStream("for_test_request/head-simple.txt")) {
            HttpRequest request = defaultHttpRequestParser.parseHttpRequest(httpMessage, "localhost");
            assertEquals("HEAD", request.getMethod());
            assertEquals("/index.html", request.getUri());
            assertEquals("HTTP/1.1", request.getHttpVersion());
        }
    }

    @Test
    public void testGetWithSimpleParams() throws IOException {
        try (InputStream httpMessage = getClassPathResourceStream("for_test_request/get-with-simple-params.txt")) {
            HttpRequest request = defaultHttpRequestParser.parseHttpRequest(httpMessage, "localhost");
            assertEquals("GET", request.getMethod());
            assertEquals("/index.html", request.getUri());
            assertEquals("HTTP/1.1", request.getHttpVersion());

            assertEquals(2, request.getParameters().size());
            assertEquals("value1", request.getParameters().get("param1"));
            assertEquals("true", request.getParameters().get("param2"));
        }
    }

    @Test
    public void testGetWithDuplicateParams() throws IOException {
        try (InputStream httpMessage = getClassPathResourceStream("for_test_request/get-with-duplicate-params.txt")) {
            HttpRequest request = defaultHttpRequestParser.parseHttpRequest(httpMessage, "localhost");
            assertEquals("GET", request.getMethod());
            assertEquals("/index.html", request.getUri());
            assertEquals("HTTP/1.1", request.getHttpVersion());

            assertEquals(2, request.getParameters().size());
            assertEquals("value1,value2,value1", request.getParameters().get("param1"));
            assertEquals("true", request.getParameters().get("param2"));
        }
    }

    @Test
    public void testGetWithDecodedParams() throws IOException {
        try (InputStream httpMessage = getClassPathResourceStream("for_test_request/get-with-decoded-params.txt")) {
            HttpRequest request = defaultHttpRequestParser.parseHttpRequest(httpMessage, "localhost");
            assertEquals("GET", request.getMethod());
            assertEquals("/index.html", request.getUri());
            assertEquals("HTTP/1.1", request.getHttpVersion());

            assertEquals(6, request.getParameters().size());
            assertEquals("welcome@devstudy.net", request.getParameters().get("email"));
            assertEquals("", request.getParameters().get("password"));
            assertEquals("5", request.getParameters().get("number"));
            assertEquals("test&qwerty?ty=u", request.getParameters().get("p"));
            assertEquals("Simple Text", request.getParameters().get("text"));
            assertEquals("http://devstudy.net", request.getParameters().get("url"));
        }
    }

    @Test
    public void testPostSimple() throws IOException {
        try (InputStream httpMessage = getClassPathResourceStream("for_test_request/post-simple.txt")) {
            HttpRequest request = defaultHttpRequestParser.parseHttpRequest(httpMessage, "localhost");
            assertEquals("POST", request.getMethod());
            assertEquals("/index.html", request.getUri());
            assertEquals("HTTP/1.1", request.getHttpVersion());

            assertEquals(5, request.getParameters().size());
            assertEquals("welcome@devstudy.net", request.getParameters().get("email"));
            assertEquals("", request.getParameters().get("password"));
            assertEquals("5", request.getParameters().get("number"));
            assertEquals("Simple Text", request.getParameters().get("text"));
            assertEquals("http://devstudy.net", request.getParameters().get("url"));
        }
    }

    @Test
    public void testPostWithEmptyBody() throws IOException {
        try (InputStream httpMessage = getClassPathResourceStream("for_test_request/post-with-empty-body.txt")) {
            HttpRequest request = defaultHttpRequestParser.parseHttpRequest(httpMessage, "localhost");
            assertEquals("POST", request.getMethod());
            assertEquals("/index.html", request.getUri());
            assertEquals("HTTP/1.1", request.getHttpVersion());

            assertEquals(0, request.getParameters().size());
        }
    }

    @Test
    public void testPostWithEmptyBodyWithoutContentLength() throws IOException {
        try (InputStream httpMessage = getClassPathResourceStream(
                "for_test_request/post-with-empty-body-and-without-content-length.txt")) {
            HttpRequest request = defaultHttpRequestParser.parseHttpRequest(httpMessage, "localhost");
            assertEquals("POST", request.getMethod());
            assertEquals("/index.html", request.getUri());
            assertEquals("HTTP/1.1", request.getHttpVersion());

            assertEquals(0, request.getParameters().size());
        }
    }

}