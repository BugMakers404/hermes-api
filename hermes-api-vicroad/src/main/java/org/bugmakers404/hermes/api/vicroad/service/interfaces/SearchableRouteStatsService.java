package org.bugmakers404.hermes.api.vicroad.service.interfaces;


import java.time.OffsetDateTime;
import org.bugmakers404.hermes.api.vicroad.entity.RouteStats;

public interface SearchableRouteStatsService {

  RouteStats getRouteStats(Integer routeId, OffsetDateTime timestamp);

  RouteStats getLatestRouteStats(Integer routeId);
}
