package org.bugmakers404.hermes.api.vicroad.controller;

import static org.bugmakers404.hermes.api.vicroad.util.RestEndPointConfig.VICROAD_LINK_EVENT;
import static org.bugmakers404.hermes.api.vicroad.util.RestEndPointConfig.VICROAD_LINK_EVENT_ON_TIMESTAMP;
import static org.bugmakers404.hermes.api.vicroad.util.RestEndPointConfig.VICROAD_LINK_INFO;

import io.swagger.v3.oas.annotations.Operation;
import java.time.OffsetDateTime;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bugmakers404.hermes.api.vicroad.entity.link.LinkEvent;
import org.bugmakers404.hermes.api.vicroad.entity.link.LinkInfo;
import org.bugmakers404.hermes.api.vicroad.service.interfaces.SearchableLinkEventService;
import org.bugmakers404.hermes.api.vicroad.service.interfaces.SearchableLinkInfoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class LinkController {

  @NonNull
  private final SearchableLinkEventService linkEventService;

  @NonNull
  private final SearchableLinkInfoService linkInfoService;

  @Operation(summary = "Get the latest link event")
  @GetMapping(path = VICROAD_LINK_EVENT, produces = MediaType.APPLICATION_JSON_VALUE)
  public LinkEvent getLatestLinkEvent(@PathVariable Integer linkId) {
    return linkEventService.getLatestLinkEvent(linkId);
  }

  @Operation(summary = "Get the link event with specific ID and timestamp")
  @GetMapping(path = VICROAD_LINK_EVENT_ON_TIMESTAMP, produces = MediaType.APPLICATION_JSON_VALUE)
  public LinkEvent getLinkEvent(@PathVariable Integer linkId,
      @PathVariable OffsetDateTime timestamp) {
    return linkEventService.getLinkEvent(linkId, timestamp);
  }

  @Operation(summary = "Get the latest link info")
  @GetMapping(path = VICROAD_LINK_INFO, produces = MediaType.APPLICATION_JSON_VALUE)
  public LinkInfo getLatestLinkInfo(@PathVariable Integer linkId) {
    return linkInfoService.getLatestLinkInfo(linkId);
  }

}
