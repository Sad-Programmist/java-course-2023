package edu.project3;

import java.time.OffsetDateTime;

public final class Log {
    private final String remoteAddr;
    private final String remoteUser;
    private final OffsetDateTime timeLocal;
    private final String requestType;
    private final String requestedSource;
    private final String requestProtocol;
    private final int status;
    private final long bodyBytesSent;
    private final String httpReferer;
    private final String httpUserAgent;

    @SuppressWarnings("ParameterNumber")
    public Log(
        String remoteAddr,
        String remoteUser,
        OffsetDateTime timeLocal,
        String requestType,
        String requestedSource,
        String requestProtocol,
        int status,
        long bodyBytesSent,
        String httpReferer,
        String httpUserAgent
    ) {
        this.remoteAddr = remoteAddr;
        this.remoteUser = remoteUser;
        this.timeLocal = timeLocal;
        this.requestType = requestType;
        this.requestedSource = requestedSource;
        this.requestProtocol = requestProtocol;
        this.status = status;
        this.bodyBytesSent = bodyBytesSent;
        this.httpReferer = httpReferer;
        this.httpUserAgent = httpUserAgent;
    }

    public Log(OffsetDateTime timeLocal, String requestType, String requestedSource, int status, long bodyBytesSent) {
        this(null, null, timeLocal, requestType, requestedSource, null, status, bodyBytesSent, null, null);
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public String getRemoteUser() {
        return remoteUser;
    }

    public OffsetDateTime getTimeLocal() {
        return timeLocal;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getRequestedSource() {
        return requestedSource;
    }

    public String getRequestProtocol() {
        return requestProtocol;
    }

    public int getStatus() {
        return status;
    }

    public long getBodyBytesSent() {
        return bodyBytesSent;
    }

    public String getHttpReferer() {
        return httpReferer;
    }

    public String getHttpUserAgent() {
        return httpUserAgent;
    }
}
