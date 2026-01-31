package com.javatalent.sbnullsafety;

import org.jspecify.annotations.Nullable;

public record Movie(Long id, String name, @Nullable Double rating) {}
