package org.bugmakers404.hermes.api.vicroad.service;

import java.time.OffsetDateTime;
import java.util.NoSuchElementException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bugmakers404.hermes.api.vicroad.dao.LinkStatsDAO;
import org.bugmakers404.hermes.api.vicroad.entity.LinkStats;
import org.bugmakers404.hermes.api.vicroad.service.interfaces.SearchableLinkStatsService;
import org.bugmakers404.hermes.api.vicroad.util.Messages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SearchableLinkStatsServiceImpl implements SearchableLinkStatsService {

  @NonNull
  private final LinkStatsDAO linkStatsDAO;

  @Override
  public LinkStats getLinkStats(Integer linkId, OffsetDateTime timestamp) {
    return linkStatsDAO.findByLinkIdAndTimestamp(linkId, timestamp)
        .orElseThrow(() -> new NoSuchElementException(
            Messages.LINK_EVENT_DOES_NOT_EXIST.format(linkId, timestamp)));
  }

  @Override
  public LinkStats getLatestLinkStats(Integer linkId) {
    return linkStatsDAO.findTopByLinkIdOrderByTimestampDesc(linkId).orElseThrow(
        () -> new NoSuchElementException(Messages.LATEST_LINK_EVENT_DOES_NOT_EXIST.format(linkId)));
  }
}
