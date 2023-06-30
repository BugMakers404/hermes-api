package org.bugmakers404.hermes.api.vicroad.util;

public class RestEndPointConfig {

  public static final String VICROAD_BASE_PATH = "/api/vicroad";

  public static final String VICROAD_EVENT_BASE_PATH = VICROAD_BASE_PATH + "/event";

  public static final String VICROAD_INFO_BASE_PATH = VICROAD_BASE_PATH + "/info";

  // Link endpoints
  public static final String VICROAD_LINK_EVENT = VICROAD_EVENT_BASE_PATH + "/link/{linkId}";

  public static final String VICROAD_LINK_EVENT_ON_TIMESTAMP =
      VICROAD_LINK_EVENT + "/timestamp/{timestamp}";

  public static final String VICROAD_LINK_INFO = VICROAD_INFO_BASE_PATH + "/link/{linkId}";

  public static final String VICROAD_LINK_INFO_ON_TIMESTAMP =
      VICROAD_INFO_BASE_PATH + "/timestamp/{timestamp}";
}
