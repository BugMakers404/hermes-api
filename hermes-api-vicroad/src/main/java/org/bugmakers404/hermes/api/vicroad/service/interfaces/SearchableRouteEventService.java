package org.bugmakers404.hermes.api.vicroad.service.interfaces;


import java.time.OffsetDateTime;
import org.bugmakers404.hermes.api.vicroad.entity.route.RouteEvent;

public interface SearchableRouteEventService {

  RouteEvent getRouteEvent(Integer routeId, OffsetDateTime timestamp);

  RouteEvent getLatestRouteEvent(Integer routeId);
}
