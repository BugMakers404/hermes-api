package org.bugmakers404.hermes.api.vicroad.service;

import java.util.NoSuchElementException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bugmakers404.hermes.api.vicroad.dao.LinkInfoDAO;
import org.bugmakers404.hermes.api.vicroad.entity.link.LinkInfo;
import org.bugmakers404.hermes.api.vicroad.service.interfaces.SearchableLinkInfoService;
import org.bugmakers404.hermes.api.vicroad.util.Messages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SearchableLinkInfoServiceImpl implements SearchableLinkInfoService {

  @NonNull
  private final LinkInfoDAO linkInfoDAO;

  @Override
  public LinkInfo getLatestLinkInfo(Integer linkId) {
    return linkInfoDAO.findTopByLinkIdOrderByTimestampDesc(linkId)
        .orElseThrow(() -> new NoSuchElementException(
            Messages.LATEST_LINK_INFO_DOES_NOT_EXIST.format(linkId)
        ));
  }
}
