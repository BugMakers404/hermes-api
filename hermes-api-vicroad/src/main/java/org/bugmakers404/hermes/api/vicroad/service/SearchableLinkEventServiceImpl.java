package org.bugmakers404.hermes.api.vicroad.service;

import java.time.OffsetDateTime;
import java.util.NoSuchElementException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bugmakers404.hermes.api.vicroad.dao.LinkEventDAO;
import org.bugmakers404.hermes.api.vicroad.entity.link.LinkEvent;
import org.bugmakers404.hermes.api.vicroad.service.interfaces.SearchableLinkEventService;
import org.bugmakers404.hermes.api.vicroad.util.Messages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SearchableLinkEventServiceImpl implements SearchableLinkEventService {

  @NonNull
  private final LinkEventDAO linkEventDAO;

  @Override
  public LinkEvent getLinkEvent(Integer linkId, OffsetDateTime timestamp) {
    return linkEventDAO.findByLinkIdAndTimestamp(linkId, timestamp)
        .orElseThrow(() -> new NoSuchElementException(
            Messages.LINK_EVENT_DOES_NOT_EXIST.format(linkId, timestamp)));
  }

  @Override
  public LinkEvent getLatestLinkEvent(Integer linkId) {
    return linkEventDAO.findTopByLinkIdOrderByTimestampDesc(linkId).orElseThrow(
        () -> new NoSuchElementException(Messages.LATEST_LINK_EVENT_DOES_NOT_EXIST.format(linkId)));
  }
}
