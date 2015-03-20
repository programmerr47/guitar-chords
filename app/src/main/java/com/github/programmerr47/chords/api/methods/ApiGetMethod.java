package com.github.programmerr47.chords.api.methods;

import android.support.annotation.NonNull;

import com.github.programmerr47.chords.api.methods.params.MethodParams;
import com.github.programmerr47.chords.api.objects.Artist;
import com.github.programmerr47.chords.api.objects.responses.ApiMethodResponse;
import com.github.programmerr47.chords.api.objects.responses.ApiMethodResponseReason;
import com.github.programmerr47.chords.api.objects.responses.DefaultApiMethodResponse;
import com.github.programmerr47.chords.api.parsers.ParserFrom;
import com.github.programmerr47.chords.representation.utils.Util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Common template for all GET-methods. All new implemented GET-methods
 * must extend this class.
 *
 * @author Michael Spitsin
 * @since 2014-10-21
 */
@SuppressWarnings("unused")
public class ApiGetMethod<ResponseObject> implements ApiMethod<ResponseObject> {

    protected MethodParams mParams;
    protected String mUrl;
    protected ParserFrom<ResponseObject> mResultParser;

    @NonNull
    @Override
    public ApiMethodResponse<ResponseObject> execute() {
        if (mUrl == null) {
            DefaultApiMethodResponse.ResponseInfoBuilder additionalInfo = new DefaultApiMethodResponse.ResponseInfoBuilder()
                    .setReason(ApiMethodResponseReason.NO_URL)
                    .setValid(false);
            return new DefaultApiMethodResponse<>(additionalInfo);
        } else {
            String fullUrl = mUrl;

            if ((mParams != null) && !mParams.getParamsString().isEmpty()) {
                fullUrl += "?" + mParams;
            }

            try {
                URL url = new URL(fullUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                if (connection.getResponseCode() != 200) {
                    DefaultApiMethodResponse.ResponseInfoBuilder additionalInfo = new DefaultApiMethodResponse.ResponseInfoBuilder()
                            .setReason(ApiMethodResponseReason.ERROR_CONNECTION_CODE.formatReason(
                                    connection.getResponseCode(),
                                    connection.getResponseMessage()))
                            .setValid(false);
                    return new DefaultApiMethodResponse<>(additionalInfo);
                } else {
                    InputStream responseStream = connection.getInputStream();

                    if (responseStream == null) {
                        DefaultApiMethodResponse.ResponseInfoBuilder additionalInfo = new DefaultApiMethodResponse.ResponseInfoBuilder()
                                .setReason(ApiMethodResponseReason.NO_RESULT)
                                .setValid(false);
                        return new DefaultApiMethodResponse<>(additionalInfo);
                    } else {
                        String responseString = Util.covertInputStreamToString(responseStream);
                        responseStream.close();
                        ResponseObject responseObject = mResultParser.parseObjectFrom(responseString);

                        DefaultApiMethodResponse.ResponseInfoBuilder additionalInfo = new DefaultApiMethodResponse.ResponseInfoBuilder()
                                .setReason(ApiMethodResponseReason.NO_REASON)
                                .setValid(true);
                        return new DefaultApiMethodResponse<>(responseObject, additionalInfo);
                    }
                }
            } catch (IOException e) {
                DefaultApiMethodResponse.ResponseInfoBuilder additionalInfo = new DefaultApiMethodResponse.ResponseInfoBuilder()
                        .setReason(ApiMethodResponseReason.ERROR_CONNECTION)
                        .setValid(false);
                return new DefaultApiMethodResponse<>(additionalInfo);
            }

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
    public ApiGetMethod<ResponseObject> setFullUrlWithoutParams(@NonNull String url) {
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
    public ApiGetMethod<ResponseObject> setMethodResultParser(@NonNull ParserFrom<ResponseObject> parser) {
        mResultParser = parser;
        return this;
    }

    /**
     * Sets params for specified method. For GET method it is just parameters to
     * main url.
     *
     * @param params method params
     */
    public ApiGetMethod<ResponseObject> setMethodParams(@NonNull MethodParams params) {
        mParams = params;
        return this;
    }
}
