package org.bugmakers404.hermes.api.vicroad.service;

import java.time.OffsetDateTime;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bugmakers404.hermes.api.vicroad.dao.RouteStatsDAO;
import org.bugmakers404.hermes.api.vicroad.entity.RouteStats;
import org.bugmakers404.hermes.api.vicroad.service.interfaces.SearchableRouteStatsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SearchableRouteStatsServiceImpl implements SearchableRouteStatsService {

  @NonNull
  private final RouteStatsDAO routeStatsDAO;

  @Override
  public RouteStats getRouteStats(Integer routeId, OffsetDateTime timestamp) {
    return null;
  }

  @Override
  public RouteStats getLatestRouteStats(Integer routeId) {
    return null;
  }
}
