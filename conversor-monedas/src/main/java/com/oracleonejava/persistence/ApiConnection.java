package com.oracleonejava.persistence;

import java.net.URI;
import java.util.Optional;

public interface ApiConnection {
    public Optional<String> requestURL(URI uri);
}
