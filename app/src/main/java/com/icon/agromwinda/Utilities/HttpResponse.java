package com.icon.agromwinda.Utilities;

/**
 * @author emmanueltombo
 */
public class HttpResponse<T> {

    private ContentHttp contentHttp;
    private T response;

    public HttpResponse() {
    }

    public ContentHttp getContentHttp() {
        return contentHttp;
    }

    public void setContentHttp(ContentHttp contentHttp) {
        this.contentHttp = contentHttp;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }


}
