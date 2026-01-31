package com.javatalent.sbnullsafety;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class MovieRepository {

  private final List<Movie> movies =
      Arrays.asList(
          new Movie(1L, "SpiderMan", 9.0),
          new Movie(2L, "Border 2", 8.5),
          new Movie(3L, "Avatar", 7.5),
          new Movie(4L, "Border 3", 0.0),
          null,
          null);

  @Nullable
  public Movie findByName(String name) {
    return movies.stream()
        .filter(movie -> movie.name().equalsIgnoreCase(name))
        .findFirst()
        .orElse(null);
  }

  public @Nullable List<@Nullable Movie> findAll() {
    return movies.stream().filter(Objects::nonNull).toList();
  }
}
