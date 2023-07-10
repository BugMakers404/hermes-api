package org.bugmakers404.hermes.api.vicroad.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bugmakers404.hermes.api.vicroad.dao.RouteInfoDAO;
import org.bugmakers404.hermes.api.vicroad.entity.RouteInfo;
import org.bugmakers404.hermes.api.vicroad.service.interfaces.SearchableRouteInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SearchableRouteInfoServiceImpl implements SearchableRouteInfoService {

  @NonNull
  private final RouteInfoDAO routeInfoDAO;

  @Override
  public RouteInfo getLatestRouteInfo(Integer routeId) {
    return null;
  }
}
