package com.github.programmerr47.chords.api.methods.params;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Common template for most of the cases. Made for providing Builder-pattern
 * for creation of any params and using one formula/one template for creating string representation of
 * params.
 * <br><br>
 * Common result of {@link DefaultMethodParams#getParamsString()} is:
 * <br>
 * <strong>param_name1</strong>=<strong>param_value1<strong>
 * &
 * <strong>param_name2</strong>=<strong>param_value2</strong>
 * & ... &
 * <strong>param_nameN</strong>=<strong>param_valueN</strong>
 *
 * @author Michael Spitsin
 * @since 2014-10-21
 */
@SuppressWarnings("unused")
public class DefaultMethodParams implements MethodParams {

    @NonNull
    private Map<String, String> mapOfParams;

    /**
     * Common constructor to getting builded with {@link com.github.programmerr47.chords.api.methods.params.DefaultMethodParams.DefaultMethodsParamsBuilder}
     *
     * @param builder construction builder
     */
    protected DefaultMethodParams(@NonNull DefaultMethodsParamsBuilder builder) {
        this.mapOfParams = builder.mapOfParams;
    }

    @NonNull
    @Override
    public final String getParamsString() {
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

    @NonNull
    @Override
    public String toString() {
        return getParamsString();
    }

    /**
     * Common parent for all builder classes, that want to gather all values and
     * give them to {@link DefaultMethodParams}.
     * This class used for creation of {@link DefaultMethodParams}
     * and has no set and put methods that fill map. So all inheritors must provide their own set and put
     * methods. This class made as abstract because itself it useless.
     *
     * @author Michael Spitsin
     * @since 2014-10-21
     */
    public static abstract class DefaultMethodsParamsBuilder {

        protected Map<String, String> mapOfParams;

        public DefaultMethodsParamsBuilder() {
            this.mapOfParams = new HashMap<>();
        }

        public DefaultMethodParams build() {
            return new DefaultMethodParams(this);
        }
    }
}
