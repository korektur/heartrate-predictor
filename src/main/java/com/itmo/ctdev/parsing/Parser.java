package com.itmo.ctdev.parsing;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author korektur
 *         06/01/2017
 */
public class Parser {

    private String tail;

    public Parser(@Nonnull String line) {
        this.tail = Objects.requireNonNull(line);
    }

    public Optional<String> getNextToken() {
        if (tail == null) {
            throw new IllegalStateException("Line end already reached");
        }
        String[] split = tail.split(",", 2);
        String token = split[0];
        if (split.length == 2) {
            tail = split[1];
        } else {
            tail = null;
        }
        if (token.length() == 0) {
            return Optional.empty();
        }
        if (token.startsWith("\"")) {
            token = token.substring(1, token.length() - 1);
        }
        return Optional.of(token);
    }

    @Nonnull
    public List<String> getNextArrayToken() {
        if (tail == null) {
            throw new IllegalStateException("Line end already reached");
        }
        if (tail.length() == 0) {
            tail = null;
            return Collections.emptyList();
        }
        if (tail.startsWith(",")) {
            tail = tail.substring(1);
            return Collections.emptyList();
        }
        if (tail.startsWith("\"[ ")) {
            boolean isLineEnd = !tail.endsWith(",");
            String[] split = tail.substring(3).split(" ]\"(,)?", 2);
            if (split.length != 2) {
                throw new IllegalStateException("Unexpected token");
            }
            if (split[1].length() != 0) {
                tail = split[1];
            } else {
                tail = isLineEnd ? null : "";
            }
            return Arrays.stream(split[0].split(","))
                    .filter(s -> s.length() > 0)
                    .collect(Collectors.toList());
        }
        throw new IllegalStateException("Wrong token");
    }
}
