package org.bugmakers404.hermes.api.vicroad.util;

import java.time.format.DateTimeFormatter;

public class Constants {
  // Constants for Timestamp format
  public final static String DATE_TIME_PATTERN_IN_EVENTS = "yyyy-MM-dd'T'HH:mm:ssXXX";
  public final static DateTimeFormatter DATE_TIME_FORMATTER_IN_EVENTS = DateTimeFormatter.ofPattern(
      DATE_TIME_PATTERN_IN_EVENTS
  );
}
