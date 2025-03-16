package bookmarker;

import bookmarker.domain.Bookmark;
import bookmarker.repositories.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

//@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BookmarkRepository bookmarkRepository;

    @Override
    public void run(String... args) throws Exception {
        bookmarkRepository.save(new Bookmark(null, "Google", "https://google.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "FaceBook", "https://facebook.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Gmail", "https://gmail.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "WellsFargo", "https://wellsfargo.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Key", "https://key.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Youtube", "https://youtube.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "x", "https://x.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "GoldenEagle", "https://goldeneagle.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "young", "https://young.com",  Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "fan", "https://fan.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "fan1", "https://fan1.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "fan2", "https://fan2.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "fan3", "https://fan3.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "fan4", "https://fan4.com", Instant.now()));

    }
}
