package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.HttpRequest;
import PROJECT_HTTP_SERVER.HttpResponse;
import PROJECT_HTTP_SERVER.HttpServerContext;
import PROJECT_HTTP_SERVER.config.HttpRequestDispatcher;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

public class DefaultHttpHandler implements HttpRequestDispatcher {
    @Override
    public void handle(HttpServerContext httpServerContext, HttpRequest httpRequest, HttpResponse httpResponse) throws IOException {
        String  url = httpRequest.getUri();
        Path path = Paths.get(httpServerContext.getRootPath().toString() + url);
        if(Files.exists(path)){
            if(Files.isDirectory(path)){
                handleDirectoryUrl(httpServerContext, httpResponse, path);
            } else {
                handleFileUrl(httpServerContext, httpResponse, path);
            }
        }
        else {
            httpResponse.setStatus(404);
            httpResponse.setBody("<h1>Not found</h1>");
        }
    }

    private void handleFileUrl(HttpServerContext httpServerContext, HttpResponse httpResponse, Path path) throws IOException {
        setEntityHeaders(httpServerContext, httpResponse, path);
        try(InputStream in = Files.newInputStream(path, StandardOpenOption.READ)){
            httpResponse.setBody(in);
        }
    }

    private void setEntityHeaders(HttpServerContext httpServerContext, HttpResponse httpResponse, Path path) throws IOException {
        String extension = FilenameUtils.getExtension(path.toString());
        httpResponse.setHeader("Content-Type", httpServerContext.getContentType(extension));
        httpResponse.setHeader("Last-Modified", Files.getLastModifiedTime(path, LinkOption.NOFOLLOW_LINKS));
        Integer expiresDays = httpServerContext.getExpiresDaysForResourse(extension);
    }

    protected void handleDirectoryUrl(HttpServerContext httpServerContext, HttpResponse httpResponse, Path path) throws IOException {
        String content = getResponseForDirectory(httpServerContext, path);
        httpResponse.setBody(content);
    }

    private String getResponseForDirectory(HttpServerContext httpServerContext, Path directoryPath) throws IOException {
        String root  = httpServerContext.getRootPath().toString();
        StringBuilder htmlBody = new StringBuilder();
        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoryPath)){
            for(Path path : directoryStream){
                htmlBody.append("<a href=\"")
                        .append(getHref(root, path))
                        .append("\">")
                        .append(path.getFileName())
                        .append("</a><br>\r\n");
            }
        }
        return htmlBody.toString();
    }

    private String getHref(String root, Path directoryPath) {
        return directoryPath.toString().replace(root, "");
    }


}
