package org.bugmakers404.hermes.api.vicroad.util;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Messages {
  LINK_EVENT_DOES_NOT_EXIST(1,
      "Event of link (%d) at timestamp (%s) does not exist in the database"),
  LATEST_LINK_EVENT_DOES_NOT_EXIST(2, "Link (%d) does not have the latest event in the database"),

  LATEST_LINK_INFO_DOES_NOT_EXIST(3,
      "Link (%d) does not have the latest information in the database");


  private final Integer code;

  private final String msg;

  public String format(Object... params) {
    return toString().formatted(params);
  }

  @Override
  public String toString() {
    return "Error %d: %s".formatted(this.code, this.msg);
  }
}
