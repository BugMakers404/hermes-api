package org.bugmakers404.hermes.api.vicroad.service;

import java.time.OffsetDateTime;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bugmakers404.hermes.api.vicroad.dao.RouteEventDAO;
import org.bugmakers404.hermes.api.vicroad.entity.route.RouteEvent;
import org.bugmakers404.hermes.api.vicroad.service.interfaces.SearchableRouteEventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SearchableRouteEventServiceImpl implements SearchableRouteEventService {

  @NonNull
  private final RouteEventDAO routeEventDAO;

  @Override
  public RouteEvent getRouteEvent(Integer routeId, OffsetDateTime timestamp) {
    return null;
  }

  @Override
  public RouteEvent getLatestRouteEvent(Integer routeId) {
    return null;
  }
}
