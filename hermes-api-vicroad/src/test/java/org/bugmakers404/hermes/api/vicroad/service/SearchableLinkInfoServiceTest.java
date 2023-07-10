package org.bugmakers404.hermes.api.vicroad.service;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.bugmakers404.hermes.api.vicroad.dao.LinkInfoDAO;
import org.bugmakers404.hermes.api.vicroad.entity.LinkInfo;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchableLinkInfoServiceTest {
  @Mock
  private LinkInfoDAO linkInfoDAO;

  private SearchableLinkInfoServiceImpl searchableLinkInfoService;

  @BeforeMethod
  public void setup() {
    MockitoAnnotations.openMocks(this);
    searchableLinkInfoService = new SearchableLinkInfoServiceImpl(linkInfoDAO);
  }

  @Test
  public void testGetLatestLinkInfo() {
    Integer linkId = 1;

    LinkInfo mockLatestLinkInfo = new LinkInfo();
    // Populate mockLatestLinkInfo with test data

    when(linkInfoDAO.findTopByLinkIdOrderByTimestampDesc(eq(linkId)))
        .thenReturn(Optional.of(mockLatestLinkInfo));

    LinkInfo result = searchableLinkInfoService.getLatestLinkInfo(linkId);

    assertEquals(result, mockLatestLinkInfo);
  }

  @Test(expectedExceptions = NoSuchElementException.class)
  public void testGetLatestLinkInfoThrowsException() {
    Integer linkId = 1;

    when(linkInfoDAO.findTopByLinkIdOrderByTimestampDesc(eq(linkId)))
        .thenReturn(Optional.empty());

    searchableLinkInfoService.getLatestLinkInfo(linkId);
  }
}
