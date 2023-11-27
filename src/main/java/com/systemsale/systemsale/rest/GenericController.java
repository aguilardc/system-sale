package com.systemsale.systemsale.rest;

import com.systemsale.systemsale.entity.Generic;
import com.systemsale.systemsale.utils.UtilValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Objects.isNull;

@Component
public class GenericController {
    protected ResponseEntity<?> internalError() {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<?> created(Generic g) {
        if (isNull(g)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(g, HttpStatus.CREATED);
    }

    protected ResponseEntity<?> created(Boolean sw) {
        if (!sw) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    protected ResponseEntity<?> list(List<?> lst) {
        if (!UtilValidator.isContent(lst)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        System.out.println(lst);
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }
}
