package org.bugmakers404.hermes.api.vicroad.service.interfaces;


import org.bugmakers404.hermes.api.vicroad.entity.route.RouteInfo;

public interface SearchableRouteInfoService {
  RouteInfo getLatestRouteInfo(Integer routeId);
}
