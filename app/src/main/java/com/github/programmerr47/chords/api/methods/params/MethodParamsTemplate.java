package com.github.programmerr47.chords.api.methods.params;

import android.support.annotation.NonNull;

import java.util.Map;
import java.util.Set;

/**
 * Common template for most of the inheritors. Made for providing Builder-pattern
 * for creation of any params and using one formula/one template for creating string representation of
 * params.
 * <br><br>
 * Common result of {@link MethodParamsTemplate#getParamsString()} is:
 * <br>
 * <strong>param_name1</strong>=<strong>param_value1<strong>
 * &
 * <strong>param_name2</strong>=<strong>param_value2</strong>
 * &...&
 * <strong>param_nameN</strong>=<strong>param_valueN</strong>
 *
 * @author Michael Spitsin
 * @since 2014-10-21
 */
@SuppressWarnings("unused")
public abstract class MethodParamsTemplate implements MethodParams{

    /**
     * Empty constructor with Builder param for providing builder-pattern
     *
     * @param builder construction builder
     */
    protected MethodParamsTemplate(@NonNull Builder builder) {
        //nothing
    }

    @Override
    public final String getParamsString() {
        Map<String, String> mapOfParams = getMapOfParams();
        Set<Map.Entry<String, String>> params = mapOfParams.entrySet();

        StringBuilder result = new StringBuilder("");
        boolean isFirst = true;
        for (Map.Entry<String, String> param : params) {
            if (!isFirst) {
                result.append("&");
            } else {
                isFirst = false;
            }

            result.append(param.getKey()).append("=").append(param.getValue());
        }

        return result.toString();
    }

    @Override
    public String toString() {
        return getParamsString();
    }

    /**
     * Mapping all params for executing {@link MethodParamsTemplate#getParamsString()}.
     *
     * @return {@link Map} of the parameters, where {@code key} is
     */
    protected abstract @NonNull Map<String, String> getMapOfParams();

    /**
     * Common builder class for all inheritors of {@link MethodParamsTemplate}.
     *
     * @author Michael Spitsin
     * @since 2014-10-21
     */
    public static abstract class Builder {

        public abstract MethodParamsTemplate build();
    }
}
