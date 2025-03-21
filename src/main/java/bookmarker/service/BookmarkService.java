package bookmarker.service;

import bookmarker.domain.Bookmark;
import bookmarker.domain.CreateBookmarkRequest;
import bookmarker.dto.BookmarkDTO;
import bookmarker.dto.BookmarkMapper;
import bookmarker.dto.BookmarksPageDTO;
import bookmarker.repositories.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final BookmarkMapper bookmarkMapper;

    @Transactional(readOnly = true)
    public BookmarksPageDTO getBookmarks(Integer page) {
        int pageNumber = page < 1 ? 0 : page-1;
        Pageable pageable = PageRequest.of(pageNumber, 5, Sort.Direction.DESC, "createdAt");
        Page<BookmarkDTO> bookmarkPage = bookmarkRepository.findBy(pageable);
        return new BookmarksPageDTO((bookmarkPage));
    }

    @Transactional(readOnly = true)
    public BookmarksPageDTO searchBookmarks(String query, Integer page) {
        int pageNo = page < 1 ? 0 : page -1 ;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        //Page<BookmarkDTO> bookmarkPage = repository.searchBookmarks(query, pageable);
        Page<BookmarkDTO> bookmarkPage = bookmarkRepository.findByTitleContainsIgnoreCase(query, pageable);
        return new BookmarksPageDTO(bookmarkPage);
    }

    @Transactional
    public BookmarkDTO createBookmark(CreateBookmarkRequest request) {
        Bookmark bookmark = new Bookmark(null, request.getTitle(), request.getUrl(), Instant.now());
        Bookmark savedBookmark = bookmarkRepository.save(bookmark);
        return bookmarkMapper.toDTO(savedBookmark);
    }
}
