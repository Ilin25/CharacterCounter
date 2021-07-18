package ru.ilin.charactercounter.cache;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CacheProviderImplTests {

    private final CacheProviderImpl cacheProvider = new CacheProviderImpl(20);

    @Test
    void isPresentShouldReturnBooleanWhenCharacter() {
        cacheProvider.putInCache('A', 1);
        assertThat(cacheProvider.isPresent('A'), equalTo(true));
        assertThat(cacheProvider.isPresent('B'), equalTo(false));
    }

    @Test
    void putInCacheShouldReturnNumberWhenEntry() {
        assertThat(cacheProvider.putInCache('A',1), equalTo(1));
    }

    @Test
    void getFromCacheShouldReturnNumberWhenCharacter() {
        cacheProvider.put('A', 1);
        assertThat(cacheProvider.getFromCache('A'), equalTo(1));
    }
}
