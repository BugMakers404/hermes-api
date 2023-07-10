package org.bugmakers404.hermes.api.vicroad.service.interfaces;


import org.bugmakers404.hermes.api.vicroad.entity.RouteInfo;

public interface SearchableRouteInfoService {
  RouteInfo getLatestRouteInfo(Integer routeId);
}
