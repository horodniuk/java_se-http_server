package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.config.ReadableHttpResponse;
import PROJECT_HTTP_SERVER.exeptions.HttpServerException;
import PROJECT_HTTP_SERVER.utils.HttpUtils;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class DefaultReadableHttpResponse implements ReadableHttpResponse {
    private int status;
    private final Map<String, String> headers;
    private byte[] body;

    public DefaultReadableHttpResponse() {
        this.status = 200;
        this.headers = new LinkedHashMap<>();
        this.body = new byte[0];
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public void setHeader(String name, Object value) {
        Objects.requireNonNull(name, "Name can not be null");
        Objects.requireNonNull(value, "Value can not be null");
        name = HttpUtils.normilizeHeaderName(name);
        if(value instanceof Date) {
            headers.put(name, new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z").format(value));
        } else if(value instanceof FileTime) {
            headers.put(name, new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z").format(new Date(((FileTime) value).toMillis())));
        } else {
            headers.put(name, String.valueOf(value));
        }
    }

    @Override
    public void setBody(String content) {
        Objects.requireNonNull(content, "Content can not be null");
        this.body = content.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public void setBody(InputStream in) {
        try {
            Objects.requireNonNull(in, "InputStream can't be null");
            this.body = IOUtils.toByteArray(in);
        } catch (IOException e) {
            throw new HttpServerException("Can't set http response body from inputstream: " + e.getMessage(), e);
        }
    }

    @Override
    public void setBody(Reader reader) {
        try {
            Objects.requireNonNull(reader, "Reader can't be null");
            this.body = IOUtils.toByteArray(reader, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new HttpServerException("Can't set http response body from reader: "+e.getMessage(), e);
        }
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public byte[] getBody() {
        return body;
    }

    @Override
    public boolean isBodyEmpty() {
        return getBodyLength() == 0;
    }

    @Override
    public int getBodyLength() {
        return body.length;
    }
}
