package gl51.movie.service.impl

import gl51.movie.data.Movie
import gl51.movie.service.MovieClient
import gl51.movie.service.MovieRegistry
import io.micronaut.test.annotation.MockBean

import io.micronaut.test.annotation.MicronautTest

import spock.lang.Specification
import javax.inject.Inject

@MicronautTest
class MovieClientImplTest extends Specification {
    @Inject MovieClientImpl client
    @Inject MovieRegistry registry

    void "injection should work"() {
        expect:
        registry != null
        client != null
    }

    void "favorites should be empty"() {
        expect:
        registry.listFavorites() == []
    }

    void "get the movie by the imdbID should work"() {
        when:
        registry.addMovieToFavorites("zhk")
        then:
        registry.listFavorites().size() == 1
        client.getMovieDetail("zhk") != null
        client.getMovieDetail("007") == null
    }

    @MockBean(MovieClientImpl)
    MovieClient client() {
        def mock = Mock(MovieClient)
        mock.getMovieDetail("zhk") >> new Movie("zhk")
        mock
    }

}
