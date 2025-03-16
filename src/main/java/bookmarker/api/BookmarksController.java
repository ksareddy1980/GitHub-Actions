package bookmarker.api;

import bookmarker.domain.CreateBookmarkRequest;
import bookmarker.dto.BookmarkDTO;
import bookmarker.dto.BookmarksPageDTO;
import bookmarker.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookmarks")
public class BookmarksController {

    private final BookmarkService bookmarkService;


    @GetMapping
    public BookmarksPageDTO getBookmarks(@RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "") String query) {
        if(null != query || query.trim().isEmpty()) {
            return bookmarkService.getBookmarks(page);
        }
        return bookmarkService.searchBookmarks(query, page);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkDTO createBookmark(CreateBookmarkRequest request) {
        return bookmarkService.createBookmark(request);
    }
}
