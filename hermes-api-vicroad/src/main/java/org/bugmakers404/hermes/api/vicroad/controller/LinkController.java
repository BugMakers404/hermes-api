package org.bugmakers404.hermes.api.vicroad.controller;

import static org.bugmakers404.hermes.api.vicroad.util.RestfulEndpointConfig.VICROAD_LINK_EVENT;
import static org.bugmakers404.hermes.api.vicroad.util.RestfulEndpointConfig.VICROAD_LINK_EVENT_ON_TIMESTAMP;
import static org.bugmakers404.hermes.api.vicroad.util.RestfulEndpointConfig.VICROAD_LINK_INFO;
import static org.bugmakers404.hermes.api.vicroad.util.RestfulEndpointConfig.VICROAD_LINK_INFO_WITH_ID;

import io.swagger.v3.oas.annotations.Operation;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bugmakers404.hermes.api.vicroad.dao.projection.LinkNameProjection;
import org.bugmakers404.hermes.api.vicroad.entity.LinkInfo;
import org.bugmakers404.hermes.api.vicroad.entity.LinkStats;
import org.bugmakers404.hermes.api.vicroad.service.interfaces.SearchableLinkInfoService;
import org.bugmakers404.hermes.api.vicroad.service.interfaces.SearchableLinkStatsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class LinkController {

  @NonNull
  private final SearchableLinkStatsService linkEventService;

  @NonNull
  private final SearchableLinkInfoService linkInfoService;

  @Operation(summary = "Get the latest link stats")
  @GetMapping(path = VICROAD_LINK_EVENT, produces = MediaType.APPLICATION_JSON_VALUE)
  public LinkStats getLatestLinkEvent(@PathVariable Integer linkId) {
    return linkEventService.getLatestLinkStats(linkId);
  }

  @Operation(summary = "Get the link stats with specific ID and timestamp")
  @GetMapping(path = VICROAD_LINK_EVENT_ON_TIMESTAMP, produces = MediaType.APPLICATION_JSON_VALUE)
  public LinkStats getLinkEvent(@PathVariable Integer linkId,
      @PathVariable OffsetDateTime timestamp) {
    return linkEventService.getLinkStats(linkId, timestamp);
  }

  @Operation(summary = "Get existing link names in the database")
  @GetMapping(path = VICROAD_LINK_INFO, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<LinkNameProjection> getAllLinkNames() {
    return linkInfoService.getAllDistinctLinkNames();
  }

  @Operation(summary = "Get the latest link info")
  @GetMapping(path = VICROAD_LINK_INFO_WITH_ID, produces = MediaType.APPLICATION_JSON_VALUE)
  public LinkInfo getLatestLinkInfo(@PathVariable Integer linkId) {
    return linkInfoService.getLatestLinkInfo(linkId);
  }

}
