package org.bugmakers404.hermes.api.vicroad.util;

public class RestfulEndpoints {

  public static final String VICROAD_BASE_PATH = "/api/vicroad";

  public static final String VICROAD_STATS_BASE_PATH = VICROAD_BASE_PATH + "/stats";

  public static final String VICROAD_INFO_BASE_PATH = VICROAD_BASE_PATH + "/info";

  // Link endpoints
  public static final String VICROAD_LINK_STATS = VICROAD_STATS_BASE_PATH + "/link";

  public static final String VICROAD_LINK_STATS_WITH_ID = VICROAD_LINK_STATS + "/{linkId}";
  public static final String VICROAD_LINK_STATS_WITH_ID_TIMESTAMP =
      VICROAD_LINK_STATS_WITH_ID + "/timestamp/{timestamp}";

  public static final String VICROAD_LINK_INFO = VICROAD_INFO_BASE_PATH + "/link";

  public static final String VICROAD_LINK_INFO_WITH_ID = VICROAD_LINK_INFO + "/{linkId}";
}
