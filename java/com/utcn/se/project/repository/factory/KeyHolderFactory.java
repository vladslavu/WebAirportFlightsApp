package com.utcn.se.project.repository.factory;

import org.springframework.jdbc.support.KeyHolder;

public interface KeyHolderFactory {

    KeyHolder generateKeyHolder();

}
