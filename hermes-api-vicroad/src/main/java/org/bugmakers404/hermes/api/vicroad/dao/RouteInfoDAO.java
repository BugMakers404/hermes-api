package org.bugmakers404.hermes.api.vicroad.dao;


import java.util.List;
import org.bugmakers404.hermes.api.vicroad.entity.RouteInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouteInfoDAO extends MongoRepository<RouteInfo, String> {

  List<RouteInfo> findAllByRouteId(Integer routeId);

  RouteInfo findTopByRouteIdOrderByTimestampDesc(Integer routeId);
}
