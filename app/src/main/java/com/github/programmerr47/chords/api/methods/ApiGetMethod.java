package com.github.programmerr47.chords.api.methods;

import android.support.annotation.NonNull;

import com.github.programmerr47.chords.api.methods.params.MethodParams;
import com.github.programmerr47.chords.api.parsers.ParserFrom;
import com.github.programmerr47.chords.representation.utils.Util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;

/**
 * Common template for all GET-methods. All new implemented GET-methods
 * must extend this class.
 *
 * @author Michael Spitsin
 * @since 2014-10-21
 */
public abstract class ApiGetMethod<MethodResult> implements ApiMethod<MethodResult> {

    protected MethodParams mParams;
    protected String mUrl;
    protected ParserFrom<MethodResult> mResultParser;

    @Override
    public MethodResult execute() throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(mUrl);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity responseEntity = httpResponse.getEntity();
        InputStream responseStream = responseEntity.getContent();

        if (responseStream != null) {
            String responseString = Util.covertInputStreamToString(responseStream);
            responseStream.close();
            return mResultParser.parseObjectFrom(responseString);
        } else {
            return null;
        }
    }

    /**
     * Sets method url base on type of method. Basically all api method
     * has common part of url (it is a API url), but for more flexibility
     * we has not setMethodName method but setUrl method for maintenance cases
     * when you has no official api and need to parse some page for example.
     *
     * @param url method url
     */
    public ApiGetMethod<MethodResult> setFullUrlWithoutParams(@NonNull String url) {
        mUrl = url;
        return this;
    }

    /**
     * Sets parser from metadata that comes as a result of urlMethod.
     * This metadata can be JSON, XML or just HTML page layout. So for special
     * method special parser must be specified.
     *
     * @param parser method result parser
     */
    public ApiGetMethod<MethodResult> setMethodResultParser(@NonNull ParserFrom<MethodResult> parser) {
        mResultParser = parser;
        return this;
    }

    /**
     * Sets params for specified method. For GET method it is just parameters to
     * main url.
     *
     * @param params method params
     */
    public ApiGetMethod<MethodResult> setMethodParams(@NonNull MethodParams params) {
        mParams = params;
        return this;
    }
}
