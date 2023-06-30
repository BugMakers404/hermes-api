package org.bugmakers404.hermes.api.vicroad.dao;

import org.bugmakers404.hermes.api.vicroad.entity.route.RouteEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface RouteEventDAO extends MongoRepository<RouteEvent, String> {
  List<RouteEvent> findAllByRouteId(Integer linkId);

  List<RouteEvent> findAllByTimestamp(OffsetDateTime timestamp);

  RouteEvent findByRouteIdAndTimestamp(Integer routeId, OffsetDateTime timestamp);

  RouteEvent findTopByRouteIdOrderByTimestampDesc(Integer routeId);
}
