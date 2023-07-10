package org.bugmakers404.hermes.api.vicroad.dao;

import java.time.OffsetDateTime;
import java.util.List;
import org.bugmakers404.hermes.api.vicroad.entity.RouteStats;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouteStatsDAO extends MongoRepository<RouteStats, String> {
  List<RouteStats> findAllByRouteId(Integer linkId);

  List<RouteStats> findAllByTimestamp(OffsetDateTime timestamp);

  RouteStats findByRouteIdAndTimestamp(Integer routeId, OffsetDateTime timestamp);

  RouteStats findTopByRouteIdOrderByTimestampDesc(Integer routeId);
}
