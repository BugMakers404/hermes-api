package org.bugmakers404.hermes.api.vicroad.dao;

import org.bugmakers404.hermes.api.vicroad.entity.route.RouteInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RouteInfoDAO extends MongoRepository<RouteInfo, String> {

  List<RouteInfo> findAllByRouteId(Integer routeId);

  RouteInfo findTopByRouteIdOrderByTimestampDesc(Integer routeId);
}
