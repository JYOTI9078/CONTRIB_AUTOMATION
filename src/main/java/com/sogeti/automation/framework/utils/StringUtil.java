package com.sogeti.automation.framework.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    public List<String> stringToList(String commaSeparatedString) {
        return Arrays.asList(StringUtils.splitPreserveAllTokens(commaSeparatedString, ","));
    }
}
