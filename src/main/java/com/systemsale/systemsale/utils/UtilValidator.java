package com.systemsale.systemsale.utils;

import java.util.List;

import static java.util.Objects.isNull;

public class UtilValidator {

    public static Boolean isContent(List<?> lst) {
        return (!(isNull(lst) || lst.isEmpty()));

    }
}